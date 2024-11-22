Ball[] balls;           // Declare an array of ball objects.
 
void setup()
{
  size(400, 400);
  balls = new Ball[50];  // Create 100 new balls.
  for (int i=0; i<balls.length; i++)
  {
    balls[i] = new Ball();
  }
}
 
void draw()
{
  background(254, 244, 232);  // Pale background.
 
  // First draw the balls in their current position.
  for (Ball ball : balls)
  {
    ball.draw();
  }
 
  // Check to see if any balls have collided
  for (int i=0; i<balls.length; i++)
  {
    // Compare each ball with any untested others
    for (int j=i+1; j<balls.length; j++)
    {
      if (balls[i].hasCollidedWith(balls[j]))
      {
        balls[i].bounce(balls[j]);
      }
    }
  }
 
  // Finally move all the balls by one step.
  for (Ball ball : balls)
  {
    ball.move();
  }
}
