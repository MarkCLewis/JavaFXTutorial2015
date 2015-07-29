/*
 * Created on Jul 29, 2015
 */
package speed;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingSpeedTest {
    private static class DrawPanel extends JPanel {
        @Override
        public void paint(Graphics gr) {
            long start = System.nanoTime();
            Graphics2D g = (Graphics2D)gr;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setPaint(Color.WHITE);
            g.fillRect(0, 0, 800, 800);
            g.setPaint(Color.BLACK);
            for(int i=0; i<1000000; ++i) {
                double size = Math.random()*2;
//                g.fillOval((int)(Math.random()*800), (int)(Math.random()*800), (int)size, (int)size);
                g.fill(new Ellipse2D.Double(Math.random()*800, Math.random()*800, size, size));
            }
            System.out.println("Circles "+(System.nanoTime()-start)/1e9);
            start = System.nanoTime();
            g.setPaint(Color.RED);
            for(int i=0; i<10000; ++i) {
//                g.drawLine((int)(Math.random()*800), (int)(Math.random()*800),(int)(Math.random()*800), (int)(Math.random()*800));
                g.draw(new Line2D.Double(Math.random()*800, Math.random()*800,Math.random()*800, Math.random()*800));
            }
            System.out.println("Lines "+(System.nanoTime()-start)/1e9);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPanel drawPanel = new DrawPanel();
        drawPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.add(drawPanel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
