package Entity.Collectables;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class healer extends StaticBody {
    private static final String healImagePath = "data/collectables/healer.gif";
    private final BodyImage coinImage;

    public healer(World world, Vec2 position) {
        super(world, new CircleShape(0.5f));
        setPosition(position);

        coinImage = new BodyImage(healImagePath, 1.5f);
        addImage(coinImage);
    }
}