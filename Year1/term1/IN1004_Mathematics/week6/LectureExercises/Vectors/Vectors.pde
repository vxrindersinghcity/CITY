Drawing drawing;
int spacing;
PVector p1, p2, p3, p4;
/*
Exercise 1: Create and draw vectors

In setup() initialise the vectors p1, p2 and p3 with the values:

p1 (5, 3)
p2 (-12, 8)
p3 (2, -2);

and draw all of them on in the draw() method. You can draw a PVector 
with the method call:

drawing.drawVector(nameOfVector);

Exercise 2: Vector length

Print the lengths/magnitutes/moduli/norms of the PVectors you have created

Exercise 3: Scalar product

Multiply p1 by 2. 
Note the effect this has on the drawing.
Multiply p1 by 0.5.
Note the effect this has on the drawing.

Exercise 4: Dot product

Print the dot product of p1 and p3

Exercise 5: 

Initialise the vector p4 by adding p1 and p3. The static method PVector.add() can 
be used to generate the result of adding two vectors.

Draw p4.


*/


void setup() {
  size(800, 800);
  drawing = new Drawing();
  spacing=10;
  //vector operations here
  p1= new PVector(5,3);
  p2= new PVector(-12,8);
  p3= new PVector(2,-2);
   println(p1.mag(),p2.mag(),p3.mag());
   p1.mult(2);
   println(p1.dot(p3));
   p4 = PVector.add(p1,p3);

}

void draw() {
  background(200);
  drawing.gridLines(-width/2, width/2, spacing);
  //vector drawing here
  drawing.drawVector(p1);
  drawing.drawVector(p2);
  drawing.drawVector(p3);
  drawing.drawVector(p4);
  
}
