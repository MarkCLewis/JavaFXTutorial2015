This repository has code for a JavaFX tutorial given at WORLDCOMP 2015.

The slides for the talk can be found as a Google doc at:
  https://docs.google.com/presentation/d/1LIddqiKWvUJvULQdwAquioMGGmWERdIA6i135we0cGc/edit?usp=sharing
  
The JavaFX API can be found at:
  http://docs.oracle.com/javase/8/javafx/api/

As promised, I have added some speed testing code in the package speed to compare Swing with JavaFX.
The current code is fairly simplistic, and the timing for JavaFX does not appear to time the full render
process, only the drawing commands, which queue to the pipeline. However, it is clearly rendering faster
than the Swing code. The timing on the Swing code indicates that drawing 1 million random circles
consistently takes more than five seconds and drawing 10,000 lines consistently takes more than one
second. The timing for JavaFX reports under 0.1 seconds for the circles and 0.002 for the lines, but
the refreshed render typically does not become visible for close to two seconds after the click. Even
with that lag, it is clear that the JavaFX code executes much faster. Worst case for the render is 3x
faster, and the time spent in the render code itself is 60x faster. 