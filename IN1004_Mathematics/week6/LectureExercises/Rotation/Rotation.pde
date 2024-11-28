Drawing drawing;
int spacing;
PVector p1, p2;


/*
Exercise 1: Rotate 180 around the origin

Modify the rotate method so that p1 rotates 180 degrees
about the origin.

Exercise 2: Spin around the origin

Use the R(theta) values from the rotation
video (x - (cos(theta), sin(theta)) and y - (-sin(theta), 
cos(theta)) to spin p1 around the origin - you will 
need to create a variable that increments in draw()
and that is passed as a parameter to the rotate method.

*/


void setup() {
  size(800, 800);
  drawing = new Drawing();
  spacing=40;

  p1 = new PVector(8, 5);
  p2 = rotate(p1);

}

void draw() {
  background(200);
  drawing.gridLines(-width/2, width/2, spacing);
  drawing.drawVector(p1);
  drawing.drawVector(p2);

}

PVector rotate(PVector p){
  //modify rotateX and rotateY to rotate 180 around the origin
  PVector rotateX = new PVector(0, 0); 
  PVector rotateY = new PVector(0, 0);
  float x = rotateX.x*p.x + rotateY.x*p.y;
  float y = rotateX.y*p.x + rotateY.y*p.y;
  return new PVector(x, y);
}
