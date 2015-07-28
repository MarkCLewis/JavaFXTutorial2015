/*
 * Created on Jul 26, 2015
 */
package basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UnemployPlotting extends Application {
    private static class AreaInfo {
        public final String code;
        public final String desc;

        public AreaInfo(String c, String d) {
            code = c;
            desc = d;
        }

        @Override
        public String toString() {
            return desc + " (" + code + ")";
        }
    }

    private static class UnemployInfo {
        public final String code;
        public final String series;
        public final int year;
        public final int month;
        public final double value;

        public UnemployInfo(String c, String s, int y, int m, double v) {
            code = c;
            series = s;
            year = y;
            month = m;
            value = v;
        }
    }

    private final List<AreaInfo> areas;
    private final List<UnemployInfo> unemployInfo;

    public UnemployPlotting() {
        unemployInfo = readUnemployment();
        Set<String> codes = unemployInfo.stream().map(ui -> ui.code).collect(Collectors.toSet());
        areas = readAreas(codes);
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1976);
        xAxis.setUpperBound(2016);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(15);
        final ObservableList<XYChart.Series<Number, Number>> data = FXCollections.observableList(new ArrayList<>());
        data.add(new XYChart.Series<Number, Number>());
        setData(areas.get(0).code,data);
        ListView<AreaInfo> areaList = new ListView<>(FXCollections.observableList(areas));
        areaList.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change<? extends AreaInfo> change) -> {
            setData(areas.get(areaList.selectionModelProperty().getValue().getSelectedIndex()).code,data);
        });
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis, data);
        chart.animatedProperty().set(true);
        BorderPane root = new BorderPane();
        root.setLeft(areaList);
        root.setCenter(chart);
        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setData(final String code, ObservableList<XYChart.Series<Number, Number>> data) {
        List<XYChart.Data<Number, Number>> filtered = unemployInfo.stream()
                .filter(ui -> ui.code.equals(code) && "03".equals(ui.series))
                .map(ui -> new XYChart.Data<Number, Number>(ui.year+ui.month/12.0, ui.value)).collect(Collectors.toList());
        data.get(0).getData().clear();
        data.get(0).getData().addAll(filtered);
    }

    private List<AreaInfo> readAreas(Set<String> codes) {
        List<AreaInfo> ret = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("la.area"))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\t+");
                if (codes.contains(parts[1])) {
                    AreaInfo ai = new AreaInfo(parts[1].trim(), parts[2].trim());
                    ret.add(ai);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private List<UnemployInfo> readUnemployment() {
        List<UnemployInfo> ret = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("la.data.51.Texas"))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\\s+");
                int year = Integer.parseInt(parts[1]);
                int month = Integer.parseInt(parts[2].substring(1));
                double value = Double.parseDouble(parts[3]);
                UnemployInfo ui = new UnemployInfo(parts[0].substring(3, parts[0].length() - 2),
                        parts[0].substring(parts[0].length() - 2), year, month, value);
                ret.add(ui);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
