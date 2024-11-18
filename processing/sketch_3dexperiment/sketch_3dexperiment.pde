void setup(){
  size(600,600,P3D);
}
void draw(){
background(0);
rectMode(CENTER);
translate(width/2,height/2,-50);
rotateY(radians(mouseX));
rotateX(radians(mouseY));

sphere(200);
}
