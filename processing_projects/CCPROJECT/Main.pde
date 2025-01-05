PFont font;
import java.util.*;

Transaction[] transactions;
int countSlide;

void setup() {
  size(900, 900);
  String[] lines = loadStrings("myData.txt");
  transactions = new Transaction[lines.length];
  
  textSize(21);

  for (int i = 0; i < lines.length; i++) {
    String[] token = lines[i].split(",");
    int day = int(token[0].trim()); // .trim() is used to get rid of any white spaces
    String description = token[1].trim();
    float amount = float(token[2].trim());
    float balance = float(token[3].trim());
    transactions[i] = new Transaction(day, description, amount, balance);
  }
}

void draw() {
  if (countSlide == 0) {
    draw1();
    for (Transaction x : transactions) {
      if (x.isMouseOver()) {
        x.displayDetails();
      }
    }
  } else if (countSlide == 1) {
    draw2();
  }
}

void keyPressed() {
  if ((key == 'd' || key == 'D')&& countSlide<1) {
    countSlide++;
  } else if ((key == 'a' || key == 'A') && countSlide > 0) {
    countSlide--;
  }
  print(countSlide);
}

void draw1() {
  background(255);
  int cols = 7; // 7 days a week
  int rows = (int) (transactions.length % float(cols));
  float xSpacing = width / 8;
  float ySpacing = height / 11;
  for (int i = 0; i < transactions.length; i++) {
    int col = i % cols;
    int row = i / cols;
    float x = (col + 1) * xSpacing;
    float y = (row + 1) * ySpacing;
    transactions[i].display(x, y);
  }
}

void draw2() {
  background(255);
  
  Map<String, Float> totalTransactions = new HashMap<>();
  for (Transaction transaction : transactions) {
    totalTransactions.put(
      transaction.description,
      totalTransactions.getOrDefault(transaction.description, 0.0) + transaction.amount
    );
  }

  // Separate and sort descriptions by total amount
  List<Map.Entry<String, Float>> sortedTransactions = new ArrayList<>(totalTransactions.entrySet());
  List<Map.Entry<String, Float>> positiveTransactions = new ArrayList<>();
  List<Map.Entry<String, Float>> negativeTransactions = new ArrayList<>();

  for (Map.Entry<String, Float> entry : sortedTransactions) {
    if (entry.getValue() >= 0) {
      positiveTransactions.add(entry);
    } else {
      negativeTransactions.add(entry);
    }
  }

  Collections.sort(positiveTransactions, new Comparator<Map.Entry<String, Float>>() {
    @Override
    public int compare(Map.Entry<String, Float> entry1, Map.Entry<String, Float> entry2) {
      return Float.compare(entry2.getValue(), entry1.getValue());
    }
  });

  Collections.sort(negativeTransactions, new Comparator<Map.Entry<String, Float>>() {// used youtube to find out what a comparator was
    @Override
    public int compare(Map.Entry<String, Float> entry1, Map.Entry<String, Float> entry2) {
      return Float.compare(entry1.getValue(), entry2.getValue());
    }
  });

  // Display the largest positive circle first
  float x = width / 2;
  float y = height / 2;
  float maxRadius = 180;

  if (!positiveTransactions.isEmpty()) {
    Map.Entry<String, Float> largestPositiveEntry = positiveTransactions.get(0);
    String largestPositiveDescription = largestPositiveEntry.getKey();
    float largestPositiveAmount = largestPositiveEntry.getValue();
    float radius = map(largestPositiveAmount, 0, positiveTransactions.get(0).getValue(), 50, maxRadius);
     //used cc module to use mapping
    fill(0,255,0); 
    ellipse(x, y, radius * 2, radius * 2);

    fill(0);
    textAlign(CENTER, CENTER);
    text(largestPositiveDescription + ": " + largestPositiveAmount, x, y);
  }

  // Draw circles for negative amounts
  float radiusOffset = positiveTransactions.isEmpty() ? maxRadius : maxRadius + 50;
  for (int i = 0; i < negativeTransactions.size(); i++) {
    Map.Entry<String, Float> entry = negativeTransactions.get(i);
    String description = entry.getKey();
    float amount = entry.getValue();

    float radius = map(abs(amount), abs(negativeTransactions.get(0).getValue()), 0, maxRadius / 2, 10);

    float angle = frameCount * 0.01f + i * TWO_PI / negativeTransactions.size();//Speed of movement
    float distance = radiusOffset + radius * 1.5;  // Adjust to avoid overlap with positive circles

    float posX = x + distance * cos(angle);
    float posY = y + distance * sin(angle);

    fill(255, 0, 0, 150);  // Semi-transparent red fill for negative amounts
    ellipse(posX, posY, radius * 2, radius * 2);

    fill(0);
    textAlign(CENTER, CENTER);
    text(description + ": " + amount, posX, posY);
    frameRate(30);
    fill(0);
    text(frameRate,50,20);
  }
}
