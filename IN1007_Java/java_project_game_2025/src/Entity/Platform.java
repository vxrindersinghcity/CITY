package Entity;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {
    public float width;
    public Platform(World world, Vec2 position, float width, float height) {
        super(world, new BoxShape(width / 2, height /2));
        setPosition(position);

        this.width=width;

        // Calculate the scale factor to fit the width and height
        float scaleFactor = width / height;

        // Create and scale the platform image
        BodyImage platformImage = new BodyImage("data/JunglePack/junglefloor.jpg", height/0.7f);

        // Add the image to the platform
        addImage(platformImage);

        // Manually adjust the image scale to ensure it fits the width
        AttachedImage attachedImage = getImages().get(0); // Assuming the first image is the one we added
       if(height<3&&height>1){
           attachedImage.setScale(height+1/scaleFactor);
           attachedImage.setScale(width/20);
       } else if (height<1) {
           attachedImage.setScale(height*45/scaleFactor);
           attachedImage.setScale(width/scaleFactor);

       } else{
           attachedImage.setScale(scaleFactor/19);
       }

    }

    public float getWidth() {
        return width;
    }
}
