package game;

import city.cs.engine.*;

public class Student extends DynamicBody {
    private static final Shape studentShape = new BoxShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    private int credits = 0;

    public Student(World world) {
        super(world, studentShape);
        addImage(image);
        credits = 0;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }
}
