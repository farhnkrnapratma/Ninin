// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * HelpMenu represents the world shown when the player selects “Help” from the main menu.
 * It contains a single HomeButton to return to the main menu.
 */
public class HelpMenu extends World {
    /**
     * Constructor: creates a 560×560 world and calls prepare() to add the HomeButton.
     */
    public HelpMenu() {
        super(560, 560, 1);   // Create a world of 560×560 pixels with 1×1 cell size
        prepare();            // Add and position the HomeButton
    }

    /**
     * prepare() instantiates a HomeButton, adds it to the world,
     * and moves it to the top-left corner for navigation back to Menu.
     */
    private void prepare() {
        HomeButton homeButton = new HomeButton();  // Create HomeButton instance
        addObject(homeButton, 283, 261);           // Temporarily add at (283, 261)
        homeButton.setLocation(65, 30);            // Move to top-left area (x=65, y=30)
    }
}
