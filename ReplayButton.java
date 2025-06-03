// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * ReplayButton is a clickable UI element that restarts the game when clicked.
 * It provides a visual feedback effect by shrinking when pressed.
 */
public class ReplayButton extends Actor {

    // Constructor: scale the button's default image to a fixed size
    public ReplayButton() {
        GreenfootImage img = getImage();
        img.scale(160, 70); // Set the button image size
        setImage(img);
    }

    // Called continuously: handles press and click interactions
    public void act() {
        // If the button is pressed (mouse down), apply a shrinking effect
        if (Greenfoot.mousePressed(this)) {
            getImage().scale(
                (int) Math.round(getImage().getWidth() * 0.8),
                (int) Math.round(getImage().getHeight() * 0.8)
            );
        }

        // If the button is clicked (mouse released), restart the game
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(2); // Short visual delay
            Greenfoot.setWorld(new Game()); // Restart the game by switching to Game world
        }
    }
}
