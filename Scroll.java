// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Scroll extends Objects {

    // Constructor - set image and scale it
    public Scroll() {
        GreenfootImage image = new GreenfootImage("scroll.png");
        image.scale(15, 15);  // Resize image to 15x15 pixels
        setImage(image);      // Set the actor's image
    }
}
