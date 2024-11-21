int NBALLS = 1000;  // Number of balls are in the sketch (try changing to higher or lower numbers).

Ball[] balls;

void setup() {
  size(700, 700);
  frameRate(-1);    // Draw as fast as possible.
  textAlign(RIGHT, TOP);
  textFont(createFont("Monospaced", 16));

  // Initialise array of ball objects.
  balls = new Ball[NBALLS];
  for (int i=0; i<balls.length; i++) {
    balls[i] = new Ball();
  }
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

  // Check to see if any balls have collided
  for (int i=0; i<balls.length; i++) {

    // Compare each ball with any untested others
    for (int j=i+1; j<balls.length; j++) {
      if (balls[i].hasCollidedWith(balls[j])) {
        balls[i].bounce(balls[j]);
      }
    }
  }

  // Move all the balls by one step.
  for (Ball ball : balls)
  {
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
