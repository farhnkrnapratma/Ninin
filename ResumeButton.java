// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * ResumeButton is a UI button that resumes the current game session.
 * If no existing game instance is found, it starts a new game instead.
 */
public class ResumeButton extends Actor {

    // Constructor: scale the button image to a fixed size
    public ResumeButton() {
        GreenfootImage img = getImage();
        img.scale(160, 70); // Set the size of the button
        setImage(img);
    }

    // Called continuously: handles press and click interactions
    public void act() {
        // Visual feedback: shrink the button when pressed
        if (Greenfoot.mousePressed(this)) {
            getImage().scale(
                (int) Math.round(getImage().getWidth() * 0.8),
                (int) Math.round(getImage().getHeight() * 0.8)
            );
        }

        // Resume the game when clicked, or start a new one if none exists
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.delay(2); // Short delay for visual feedback

            Game currentGame = Game.getCurrentInstance(); // Retrieve the current game instance

            if (currentGame != null) {
                currentGame.resumeGame(); // Resume the paused game
            } else {
                Greenfoot.setWorld(new Game()); // Start a new game if no instance exists
            }
        }
    }
}
