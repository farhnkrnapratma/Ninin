// SPDX-License-Identifier: MIT
import greenfoot.*;

public class GameCompleted extends World {
    public GameCompleted() {
        super(560, 560, 1); 
        prepare();
    }
    
    private void prepare() {
        HomeButton homeButton = new HomeButton();
        YouWin youWin = new YouWin();
        ReplayButton replayButton = new ReplayButton();
        HelpButton helpButton = new HelpButton();

        addObject(homeButton,304,313);
        addObject(youWin,353,226);
        addObject(replayButton,446,291);
        addObject(helpButton,293,404);

        homeButton.setLocation(65,30);
        youWin.setLocation(275, 250);
        replayButton.setLocation(275, 340);
        helpButton.setLocation(275, 410);
    }
}
