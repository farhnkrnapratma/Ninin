// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Scroll extends Objects {
    private int animationCounter = 0;
    private boolean animationDirection = true;
    
    public Scroll() {
        GreenfootImage image = new GreenfootImage("scroll.png");
        if (image.getWidth() > 0) {
            image.scale(15, 15);
        } else {
            // If scroll.png doesn't exist, create a simple colored rectangle
            image = new GreenfootImage(15, 15);
            image.setColor(Color.YELLOW);
            image.fill();
        }
        setImage(image);
    }
    
    public void act() {
        animate();
    }
    
    private void animate() {
        animationCounter++;
        if (animationCounter % 5 == 0) {
            GreenfootImage image = getImage();
            if (animationDirection) {
                image.scale(image.getWidth() + 1, image.getHeight() + 1);
                if (image.getWidth() >= 18) {
                    animationDirection = false;
                }
            } else {
                image.scale(image.getWidth() - 1, image.getHeight() - 1);
                if (image.getWidth() <= 12) {
                    animationDirection = true;
                }
            }
            setImage(image);
        }
    }
}