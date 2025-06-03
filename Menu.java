// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * Menu represents the main menu world shown at game start.
 * It displays two buttons: Play and Help.
 */
public class Menu extends World {
    /**
     * Constructor: creates a 560×560 world and calls prepare() to place buttons.
     */
    public Menu() {
        super(560, 560, 1);  // Create a world of 560×560 pixels with 1×1 cell size
        prepare();           // Add and position the Play and Help buttons
    }

    /**
     * prepare() instantiates the PlayButton and HelpButton, adds them to the world,
     * and positions them at their final coordinates.
     */
    private void prepare() {
        // Create button instances
        PlayButton playButton = new PlayButton();
        HelpButton helpButton = new HelpButton();

        // Initially add both buttons at the same location to register them in the world
        addObject(playButton, 348, 395);
        addObject(helpButton, 348, 395);

        // Reposition PlayButton slightly above center
        playButton.setLocation(275, 370);
        // Reposition HelpButton just below the PlayButton
        helpButton.setLocation(275, 435);
    }
}
