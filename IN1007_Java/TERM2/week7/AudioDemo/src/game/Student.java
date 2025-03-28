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

    private static final BodyImage image =
            new BodyImage("data/student.png", 5f);

    private int bookCount;

    public Student(World world) {
        super(world, studentShape);
        addImage(image);

        bookCount = 0;
    }

    public void addBooks(){
        bookCount++;
        System.out.println("Becoming wiser: " +
                "bookCount = " + bookCount);
    }
    public int getBookCount(){
        return bookCount;
    }


}