// -- Declare a PImage object, called img as a global variable 
PImage img;    // <-- this is a 'bucket' into which we can put image data
 
void setup() {
  size(640, 530);
  img = loadImage("car.jpg"); // <-- use the loadImage() method to put data from the 'Holiday.png' file into our PImage 

}
void draw() {

   int tint_value = round(mouseX*255 / width);
  background(255);
 
  tint(tint_value);
  image(img, 0, 0,640,480);
 
  textSize(16);
  fill(0);
  text("tint(" + tint_value + ");", 200, 500);
  text("image(img, 0, 0);", 200, 520);
}
 
