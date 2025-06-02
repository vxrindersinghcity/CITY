package Entity;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Portal extends StaticBody {

    private static final float WIDTH = 0.5f;
    private static final float HEIGHT = 1f;
    private static final String PORTAL_IMAGE_PATH = "data/JunglePack/portal.gif";
    private Portal pairedPortal;

    public Portal(World world, Vec2 position) {
        super(world);

        Shape portalShape = new BoxShape(WIDTH, HEIGHT);
        new SolidFixture(this, portalShape);

        setPosition(position);

        BodyImage image = new BodyImage(PORTAL_IMAGE_PATH, 4);
        addImage(image);
    }

    public void setPairedPortal(Portal pairedPortal) {
        this.pairedPortal = pairedPortal;
    }

    public Portal getPairedPortal() {
        return pairedPortal;
    }
}
