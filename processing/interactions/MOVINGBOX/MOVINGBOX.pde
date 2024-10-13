float x= width/2;
float y=height/2;

void setup() {
  size(400, 400);
}
void draw()
{
  rect(x, y, 60, 60);
}
void keyPressed() {
  if (key == 'w') {
    y--;
  }
  if (key == 'a') {
    x--;
  }
  if (key == 's') {
    y++;
  }
  if (key == 'd') {
    x++;
  }
}
