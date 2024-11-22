class Ball {
  float x, y;                   // Ball position.
  float diameter;               // Ball diameter.
  color colour;                 // Ball colour.
  float dx, dy;                 // Movement increments.
 
  // Constructor - this is called whenever a new ball is created.
  Ball(float diam) 
  {
    // Initialise the state of the ball with some random values.
    this.diameter = diam;
    x = random(diam, width-diam);
    y = random(diam, height-diam);
    colour = color(50+diam*5, diam*3, diam*2);
    dx = random(-0.001,0.001) * pow(diam,2);
    dy = random(-0.001,0.001) * pow(diam,2);
  }
 
  void draw()
  {
    noStroke();  // What effect does not drawing stroke around each ball have?
    fill(colour);
    circle(x, y, diameter);
  }
 
  void move() 
  {
    // Make balls wrap around display.   
    if (x < -diameter) {
      x = width+diameter;
    } 
    else if (x > width+diameter) 
    {
      x = -diameter;
    }
    if (y < -diameter) 
    {
      y = height+diameter;
    } 
    else if (y > height+diameter) 
    {
      y = -diameter;
    }
 
    x += dx;
    y += dy;
  }
}
