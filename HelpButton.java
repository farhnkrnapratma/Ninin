// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * HelpButton is a clickable UI element that opens the HelpMenu when clicked.
 * It also provides a visual shrinking effect when pressed.
 */
public class HelpButton extends Actor {

    // Constructor: scale the default image size of the button
    public HelpButton() {
        GreenfootImage img = getImage();
        img.scale(160, 70); // Set the size of the button image
        setImage(img);
    }

    // Called continuously: handles user interaction
    public void act() {
        // If the button is pressed (mouse down), shrink the image to simulate feedback
        if (Greenfoot.mousePressed(this)) {
            getImage().scale(
                (int) Math.round(getImage().getWidth() * 0.8),
                (int) Math.round(getImage().getHeight() * 0.8)
            );
        }

        // If the button is clicked (mouse up), switch to the HelpMenu screen
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(2); // Short delay for user to see the effect
            Greenfoot.setWorld(new HelpMenu()); // Navigate to HelpMenu
        }
    }
}
