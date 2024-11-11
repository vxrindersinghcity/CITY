// -- Declare a PImage object, called img as a global variable 
PImage img;    // <-- this is a 'bucket' into which we can put image data
 
void setup() {
  size(640, 480);
  img = loadImage("first.png"); // <-- use the loadImage() method to put data from the 'Holiday.png' file into our PImage 
        
  // < draw the image stored in img at position 0,0 on the canvas
  tint(185, 230, 255);
image(img, 0, 0);
}
void draw() {
  if (mousePressed) {
    line(pmouseX, pmouseY, mouseX,mouseY);
  }
}
 
void keyPressed () {
  save("myImage.jpg");   // -- Save an image of the current canvas
                          // -- to the sketch folder in a file called myImage.jpg ...
}
