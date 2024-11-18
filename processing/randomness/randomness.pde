void setup()
{
  size(860, 200);
}
 
void draw()
{
  //noLoop();//turns off frames
  background(255);
  noStroke();
  fill(0,0,200,100); // Transparent blue
  randomSeed(123456789);
 
  float xPos   = 40;
  float yPos   = 50;
  float sSize  = 90;
 
  for (int i=0; i<8; i=i+1)
{
  quad(xPos + random(-10,10),         yPos + random(-10,10),
       xPos + sSize + random(-10,10), yPos + random(-10,10),
       xPos + sSize + random(-10,10), yPos + sSize + random(-10,10),
       xPos + random(-10,10),         yPos + sSize + random(-10,10));
 
  xPos = xPos + 100;
}
}
