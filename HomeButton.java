// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * HomeButton is a clickable UI element that returns the player to the main menu.
 * It also provides a visual feedback effect when pressed.
 */
public class HomeButton extends Actor {

    // Constructor: scale the default image size of the button
    public HomeButton() {
        GreenfootImage img = getImage();
        img.scale(120, 50); // Set the size of the button image
        setImage(img);
    }

    // Called continuously: handles user interaction
    public void act() {
        // If the button is pressed (mouse down), shrink the image for visual feedback
        if (Greenfoot.mousePressed(this)) {
            getImage().scale(
                (int) Math.round(getImage().getWidth() * 0.8),
                (int) Math.round(getImage().getHeight() * 0.8)
            );
        }

        // If the button is clicked (mouse up), switch to the Menu screen
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(2); // Short delay for visual clarity
            Greenfoot.setWorld(new Menu()); // Navigate back to the main menu
        }
    }
}
