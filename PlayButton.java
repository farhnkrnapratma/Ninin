// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * PlayButton is a clickable UI element that starts the game when clicked.
 * It also gives a visual shrinking effect when pressed.
 */
public class PlayButton extends Actor {

    // Constructor: scale the default image size of the button
    public PlayButton() {
        GreenfootImage img = getImage();
        img.scale(160, 70); // Set the size of the button image
        setImage(img);
    }

    // Called every frame: handles button press and click actions
    public void act() {
        // If the button is pressed (mouse down), shrink the image for visual feedback
        if (Greenfoot.mousePressed(this)) {
            getImage().scale(
                (int) Math.round(getImage().getWidth() * 0.8),
                (int) Math.round(getImage().getHeight() * 0.8)
            );
        }

        // If the button is clicked (mouse up), switch to the game world
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(2); // Short delay to allow the user to see the effect
            Greenfoot.setWorld(new Game()); // Start the game
        }
    }
}
