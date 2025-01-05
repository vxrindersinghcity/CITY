class Grid {
  int numCols;
  int numRows;
  ArrayList<Ball>[][] grid;

  Grid() {
    numCols = int(sqrt(NBALLS) + 0.5);
    numRows = numCols;

    // Array with empty borders to simplify the logic;
    grid = new ArrayList[numCols+2][numRows+2];

    // initialize each grid as an empty list
    for (int i = 0; i < numCols+2; i = i+1) {
      for (int j = 0; j < numRows+2; j = j+1) {
        grid[i][j] = new ArrayList();
      }
    }
  }

  void checkCollisions()
  {
    // Empty the grid
    for (int i = 1; i <= numCols; i = i+1) {
      for (int j = 1; j <= numRows; j = j+1) {
        grid[i][j].clear();
      }
    }

    // Add balls to grid
    for (Ball ball : balls) {
      int x = getStrip(ball.x / width, numCols);
      int y = getStrip(ball.y / height, numRows);
      grid[x][y].add(ball);
    }

    // look for collisions only with with balls in neighbouring grid buckets.
    for (int i = 1; i <= numCols; i = i+1) {
      for (int j = 1; j <= numRows; j = j+1) {
        for (Ball ball : grid[i][j]) {
          checkLocalCollisions(ball, grid[i-1][j-1]); // Bucket to the top-left.
          checkLocalCollisions(ball, grid[i-1][j]);   // Bucket to the left.
          checkLocalCollisions(ball, grid[i-1][j+1]); // Bucket to the bottom-left.
          checkLocalCollisions(ball, grid[i][j-1]);   // Bucket above.
          checkLocalCollisions(ball, grid[i][j]);     // This bucket
          checkLocalCollisions(ball, grid[i][j+1]);   // Bucket below.
        }
      }
    }
  }

  // The cell (1..count) corresponding to a fractional window position
  int getStrip(float frac, int count) {
    return constrain(int(frac * count) + 1, 1, count);
  }

  void checkLocalCollisions(Ball ball, ArrayList<Ball> neighbours)
  {
    for (Ball otherBall : neighbours) {
      // Only check for collison with balls not to the right
      if ((otherBall.x < ball.x || (otherBall.x == ball.x && otherBall.y < ball.y)) && 
           ball.hasCollidedWith(otherBall)) {
        ball.bounce(otherBall);
      }
    }
  }

  // Show the grid
  void draw() {
    pushStyle();
    stroke(0);
    for (int i = 1; i < numCols; i = i+1) {
      int x = i*width/numCols;
      line(x, 0, x, height);
    }
    for (int j = 1; j < numRows; j = j+1) {
      int y = j*height/numRows;
      line(0, y, width, y);
    }
    popStyle();
  }
}
