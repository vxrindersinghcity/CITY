Drawing drawing;
int spacing;
PVector reflectX, reflectY;
PVector p1, p2;

/*
Exercise 1: Reflect in x axis

Complete the reflect() method below
by using the PVectors reflectX and reflectY
to calcuate the x and y values for the 
returning vector.

*/


void setup() {
  size(800, 800);
  drawing = new Drawing();
  spacing=40;
  p1 = new PVector(8, 5);
  p2 = reflect(p1);

}

void draw() {
  background(200);
  drawing.gridLines(-width/2, width/2, spacing);
  drawing.drawVector(p1);
  drawing.drawVector(p2);
}

PVector reflect(PVector p){
  reflectX = new PVector(-1, 0);
  reflectY = new PVector(0, 1);
  float x = 0; //replace 0 with the correct calculation
  float y = 0; //replace 0 with the correct calculation
  return new PVector(x, y);
}
