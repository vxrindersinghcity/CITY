Robot robot;
 
void setup()
{
  size(500, 500);
  robot = new Robot();
}
 
void draw()
{
  background(255);
  robot.draw();
  robot.move();
}
