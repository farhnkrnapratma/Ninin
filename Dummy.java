// SPDX-License-Identifier: MIT
import greenfoot.*;
import java.util.List;

public class Dummy extends Actor {
    public Dummy() {
        // Create a small invisible image
        GreenfootImage image = new GreenfootImage(1, 1);
        image.setTransparency(0);
        setImage(image);
    }
    
    public void act() {
        // Remove all objects except the player and dummy
        World world = getWorld();
        if (world != null) {
            List<Actor> actors = world.getObjects(Actor.class);
            for (Actor actor : actors) {
                if (!(actor instanceof Player) && !(actor instanceof Dummy)) {
                    world.removeObject(actor);
                }
            }
        }
    }
}
