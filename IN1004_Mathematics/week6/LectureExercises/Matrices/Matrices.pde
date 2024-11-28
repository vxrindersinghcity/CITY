 Drawing drawing;
int spacing;
PVector iHat, jHat, p1, p2;
/*
Matrix multiplication example

*/


void setup() {
  size(800, 800);
  drawing = new Drawing();
  spacing=40;
  //vector operations here
  iHat = new PVector(1, 0);
  jHat = new PVector(0, 1);
  //p1=new PVector(8, 5);
  //float x = iHat.x*p1.x + iHat.y*p1.x;
  //float y = jHat.x*p1.y + jHat.y*p1.y;
  //p2 = new PVector(x, y);

}

void draw() {
  background(200);
  drawing.gridLines(-width/2, width/2, spacing);
  //vector drawing here
  drawing.drawVector(iHat, 7);
  drawing.drawVector(jHat, 7);
  //drawing.drawVector(p1);
  //drawing.drawVector(p2);
  
  
}
