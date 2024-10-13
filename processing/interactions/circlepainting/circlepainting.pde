void setup(){
   background(255,255,255);
   size(600,600);
}
void draw(){
    noStroke();
    fill(mouseX,1,mouseY);
   circle(mouseX,mouseY,30);
}
