int NBALLS = 20000; // Number of balls are in the sketch (try changing to higher or lower numbers).

Ball[] balls;
Grid buckets;
boolean showGrid;

void setup() {
  size(700, 700);
  frameRate(-1);    // Draw as fast as possible.
  textAlign(RIGHT, TOP);
  textFont(createFont("Monospaced", 16));


  // Initialise array of ball objects.
  balls = new Ball[NBALLS];
  for (int i=0; i<balls.length; i=i+1) {
    balls[i] = new Ball();
  }

  // Initialise the grid ready to store balls in each bucket.
  buckets = new Grid();
  showGrid = true;
}

void draw() {
  background(254, 244, 232);

  // Magnifier and slow motion when mouse is held down.
  if (mousePressed) {
    translate(width/2, height/2);
    scale(10);
    translate(-mouseX, -mouseY);
    frameRate(5);
  } else {
    frameRate(-1);
  }

  // First draw the balls in their current position.
  for (Ball ball : balls) {
    ball.draw();
  }

  if (showGrid) {
    buckets.draw();
  }
  buckets.checkCollisions();

  // Move all the balls by one step.
  for (Ball ball : balls) {
    ball.move();
  }

  displayFrameRate();
}

void displayFrameRate() {
  pushStyle();
  String message = nf(frameRate, 0, 1)+" frames per second";
  noStroke();
  fill(255, 150);
  rect(width-textWidth(message), 0, textWidth(message), 16);
  fill(0);
  text(message, width, 0);
  popStyle();
}

void keyPressed() {
  if (key == ' ') {
    showGrid = !showGrid;
  }
}
