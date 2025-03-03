package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Student extends Walker {
    private static final Shape studentShape = new PolygonShape(
            -0.11f,2.8f,
            0.87f,1.48f,
            0.99f,0.29f,
            0.24f,-2.32f,
            -1.12f,-2.27f,
            -1.24f,1.21f);

    private static final BodyImage studentImage =
            new BodyImage("data/student.png", 5f);

    private int credits;

    private int books;
    private int bookCount;

    public Student(World world) {
        super(world, studentShape);
        addImage(studentImage);

        credits = 0;
        books = 0;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }

    public void setBooks(int bookCount){
        this.bookCount = bookCount;

        //print message when a new book is read; it'll be useful later
        System.out.println("Becoming wiser: bookCount = " + bookCount);
    }
    public int getBooks(){
        return books;
    }

}