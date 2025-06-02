class Robot
{
  PVector position;   // Position of the robot.
  PVector velocity;   // Amount it moves on each redraw.
  float sizeh, sizew;         // Size of robot.
  color colour;       // Colour of robot.
 
  // Initialises the robot's state.
  Robot()
  {
    position = new PVector(width/2, height/2);
    velocity = new PVector(random(-2,2),random(-2,2));
    sizeh     = 50;
    sizew     = 30;
    colour   = color(0, 0, 0);
  }
 
  // Draws the robot at its current position.
  void draw()
  {
    noStroke();
    fill(colour);
    rect(position.x, position.y, sizew, sizeh);
    
    fill(colour);
    circle(position.x+15,position.y-10,sizew);
    
    fill(colour);
    rect(position.x-20, position.y+10, 70, 10);
    
  }
 
  // Moves the robot according to its current velocity.
  void move()
  {
    position.x = position.x + velocity.x;
    position.y = position.y + velocity.y;
 
    if (position.x < 0)
    {
      velocity.x = -1 * velocity.x; // If robot at left of sketch move to right.
    }
    else if (position.x > width)
    {
      velocity.x = -1 * velocity.x; // If robot at right of sketch move to left.
    }
 
    if (position.y < 0)
    {
      velocity.y = -1 * velocity.y; // If robot at top of sketch move down.
    }
    else if (position.y > height)
    {
      velocity.y = -1 * velocity.y; // If robot at bottom of sketch move  up.
    }
  }
}
