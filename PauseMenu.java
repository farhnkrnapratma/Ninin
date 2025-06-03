// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * PauseMenu represents the world shown when the game is paused.
 * It displays three buttons: Home, Replay, and Resume.
 */
public class PauseMenu extends World {
    /**
     * Constructor: sets up a 560×560 world and calls prepare() to place buttons.
     */
    public PauseMenu() {
        super(560, 560, 1);   // Create a world of 560×560 pixels with 1×1 cell size
        prepare();            // Add and position the buttons
    }
    
    /**
     * prepare() instantiates each button, adds them to the world, and positions them.
     */
    private void prepare() {
        // Create button instances
        HomeButton homeButton = new HomeButton();
        ReplayButton replayButton = new ReplayButton();
        ResumeButton resumeButton = new ResumeButton();
        
        // Initially add all buttons at the same coordinates (we’ll adjust them next)
        addObject(homeButton, 290, 290);
        addObject(replayButton, 290, 290);
        addObject(resumeButton, 290, 290);
        
        // Move HomeButton to top-left corner area
        homeButton.setLocation(65, 30);
        // Move ResumeButton roughly near center-top
        resumeButton.setLocation(275, 250);
        // Move ReplayButton just below the ResumeButton
        replayButton.setLocation(275, 320);
    }
}
