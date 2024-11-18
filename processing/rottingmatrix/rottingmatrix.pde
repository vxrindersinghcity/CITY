float angle;
void setup(){
size(600,600);
}
void draw(){
  background(255);
  stroke(0);

   fill(150,0,0);
   rectMode(CENTER);
   translate(width/2,height/2);
   
   scale(0.5);
   pushMatrix();
   rotate(radians(angle)); // Rotate the square by the angle
 rect(0,0,200,200);
 popMatrix();

  
  translate(300,0);
  rect(0,0,200,200);
 
   angle += 1;
   
 
 

}
