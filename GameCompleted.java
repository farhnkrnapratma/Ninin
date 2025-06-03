// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * GameCompleted represents the world shown when the player finishes all levels.
 * It displays a “You Win” banner along with navigation buttons: Home, Replay, and Help.
 */
public class GameCompleted extends World {
    /**
     * Constructor: creates a 560×560 world and calls prepare() to place UI elements.
     */
    public GameCompleted() {
        super(560, 560, 1);  // Initialize the world at 560×560 pixels with 1×1 cell size
        prepare();           // Add and position buttons and “You Win” banner
    }
    
    /**
     * prepare() instantiates and adds HomeButton, YouWin banner, ReplayButton, and HelpButton,
     * then moves each to its intended final position.
     */
    private void prepare() {
        // Create instances of each UI element
        HomeButton homeButton = new HomeButton();
        YouWin youWin = new YouWin();
        ReplayButton replayButton = new ReplayButton();
        HelpButton helpButton = new HelpButton();

        // Add each object to the world at temporary coordinates
        addObject(homeButton, 304, 313);
        addObject(youWin, 353, 226);
        addObject(replayButton, 446, 291);
        addObject(helpButton, 293, 404);

        // Reposition HomeButton at top-left corner for navigation back to main menu
        homeButton.setLocation(65, 30);
        // Center “You Win” banner near the upper center of the screen
        youWin.setLocation(275, 250);
        // Position ReplayButton below the “You Win” banner
        replayButton.setLocation(275, 340);
        // Position HelpButton further down for help screen access
        helpButton.setLocation(275, 410);
    }
}
