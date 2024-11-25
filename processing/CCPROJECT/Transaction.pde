class Transaction {
  private int day;
  private String description;
  private float amount;
  private float balance;
  private float x;
  private float y;
  float size;

  Transaction(int day, String description, float amount, float balance) {
    this.day=day;
    this.description=description;
    this.amount=amount;
    this.balance=balance;
     x=0;
     y=0;
  }

  void display(float x, float y) {
    this.x=x;
    this.y=y;
    if (amount>100) {
      size = map(amount, 0, -150, 10, 30);
    } else {
      size = map(amount, -10, 50, 10, 50); // Map amount to circle size
    }
    float green = map(amount, 0, 700, 0, 255);
    float red = 255 - green;
    if (amount < 0) {
      fill(red, 0, 0); // Red for negative amounts
    } else {
      fill(red, green, 0); // Gradient color based on balance
    }
    ellipse(x, y, size, size);
  }
  boolean isMouseOver() {
    float d = dist(mouseX, mouseY, x, y);
    return d < size;
  }
  void displayDetails() {
    fill(0);
    textAlign(CENTER);
    text("Day: " + day + "\nDescription: " + description + "\nAmount: " + amount + "\nBalance: " + balance, x, y - size / 2 - 20);
  }
}
