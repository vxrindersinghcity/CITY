package Entity.Collectables;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Credit extends StaticBody {
    private static final String coinImagePath = "data/collectables/coin.gif";
    private final BodyImage coinImage;

    public Credit(World world, Vec2 position) {
        super(world, new CircleShape(0.5f));
        setPosition(position);

        coinImage = new BodyImage(coinImagePath, 1.5f);
        addImage(coinImage);
    }
}
