int NBALLS = 1000;

Ball[] balls;

void setup()
{
  size(800, 800);
  frameRate(-1);    // Draw as fast as possible.
  textAlign(RIGHT, TOP);
  textFont(createFont("Monospaced", 16));

  // Initialise array of ball objects.
  balls = new Ball[NBALLS];
  float[] rnds = new float[NBALLS];

  for (int i=0; i< NBALLS; i++)
  {
    rnds[i] = random(1);
  }
  rnds = sort(rnds);

  for (int i=0; i< NBALLS; i++)
  {
    if (rnds[i] < 0.9)
    {
      balls[i] = new Ball(3 + 10*rnds[i]);
    } 
    else  if (rnds[i] < 0.997)
    {
      balls[i] = new Ball(10+10*rnds[i]);
    } 
    else if (rnds[i] < 0.998)
    {
      balls[i] = new Ball(25+10*rnds[i]);
    } 
    else 
    {
      balls[i] = new Ball(45+10*rnds[i]);
    }
  }
}

void draw() 
{
  background(0);

  // First draw the balls in their current position.
  for (Ball ball : balls) 
  {
    ball.draw();
  }

  // Move all the balls by one step.
  for (Ball ball : balls)
  {
    ball.move();
  }

  displayFrameRate();
}

void displayFrameRate() 
{
  pushStyle();
  String message = nf(frameRate, 0, 1)+" frames per second";
  noStroke();
  fill(255, 150);
  rect(width-textWidth(message), 0, textWidth(message), 16);
  fill(0);
  text(message, width, 0);
  popStyle();
}
