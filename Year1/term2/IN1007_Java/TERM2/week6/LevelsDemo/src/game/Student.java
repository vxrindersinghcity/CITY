package game;

import city.cs.engine.*;

public class Student extends Walker {
    private static final Shape studentShape = new PolygonShape(
            -0.11f,2.8f,
            0.87f,1.48f,
            0.99f,0.29f,
            0.24f,-2.32f,
            -1.12f,-2.27f,
            -1.24f,1.21f);

    private static final BodyImage imageLeft =
            new BodyImage("data/studentLeft.png", 5f);

    private static final BodyImage imageRight =
            new BodyImage("data/studentRight.png", 5f);

    private int bookCount;

    private int credits;

    public Student(World world) {
        super(world, studentShape);
        addImage(imageRight);

        bookCount = 0;
    }

    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);
        if (speed < 0){
            removeAllImages();
            addImage(imageLeft);
        }
        else{
            removeAllImages();
            addImage(imageRight);
        }

    }

    public void addBooks(){
        bookCount++;
        System.out.println("Becoming wiser: " +
                "bookCount = " + bookCount);
    }
    public int getBookCount(){
        return bookCount;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}