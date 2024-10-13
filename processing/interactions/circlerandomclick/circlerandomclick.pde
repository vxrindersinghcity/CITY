float circleX, circleY, radius;
color circleColor, highlightColor;
boolean isHighlighted;

void setup() {
  size(800, 600);
  circleX = random(width);
  circleY = random(height);
  radius = random(20, 50);
  circleColor = color(255, 0, 0);
  highlightColor = color(0, 255, 0);
  isHighlighted = false;
}
void draw() {
  background(255);
  if (isHighlighted) {
    fill(highlightColor);
  } else {
    fill(circleColor);
  }
  ellipse(circleX, circleY, radius * 2, radius * 2);
}
void mouseMoved() {
  if (dist(mouseX, mouseY, circleX, circleY) < radius) {
    isHighlighted = true;
  } else {
    isHighlighted = false;
  }
}

void mouseClicked() {
  if (dist(mouseX, mouseY, circleX, circleY) < radius) {
    circleX = random(width);
    circleY = random(height);
    radius = random(20, 50);
  }
}
