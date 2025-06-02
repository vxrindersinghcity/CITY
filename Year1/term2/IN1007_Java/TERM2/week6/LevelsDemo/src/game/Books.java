package game;

import city.cs.engine.*;

public class Books extends DynamicBody {

    private static final Shape booksShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/books.png", 2f);

    public Books(World w) {
        super(w,booksShape);
        addImage(image);

    }
}
