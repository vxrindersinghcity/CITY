Transaction[] transactions;
int countSlide;

void setup() {
  size(800, 700);
  String[] lines = loadStrings("myData.txt");
  transactions = new Transaction[lines.length];

  for (int i=0; i<lines.length; i++) {

    String[] token = lines[i].split(",");
    int day = int(token[0].trim());//.trim() is usedd to get rid of any white scpaces
    String description = token[1].trim();
    float amount = float(token[2].trim());
    float balance = float(token[3].trim());
    transactions[i] = new Transaction(day, description, amount, balance);
  }
 
}
void draw() {
  if(countSlide==0){
  draw1();
  for (Transaction x : transactions) {
    if (x.isMouseOver()) {
      x.displayDetails();
    }
  }
  }
  if(countSlide==1){
   background(255);
  }
}
void keyPressed() {
  if(key=='d' || key=='D'){
    countSlide++;
  }if((key=='a' || key=='A') && countSlide>0){
    countSlide--;
  }
  print(countSlide);
}
void draw1(){
    background(255);
   int cols = 7; // 7 days a week
  int rows = (int)(transactions.length % float(cols));
  float xSpacing = width / 8;
  float ySpacing = height / 11;
  for (int i = 0; i < transactions.length; i++)
  {
    int col = i % cols;
    int row = i / cols;
    float x = (col + 1) * xSpacing;
    float y = (row + 1) * ySpacing;
    transactions[i].display(x, y);
  }
}
