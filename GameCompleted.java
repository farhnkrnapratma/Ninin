// SPDX-License-Identifier: MIT
import greenfoot.*;

public class GameCompleted extends World {
    public GameCompleted() {
        super(560, 560, 1); 
        prepare();
    }
    
    private void prepare()
    {
        ReplayButton replayButton = new ReplayButton();
        HomeButton homeButton = new HomeButton();
        YouWin youWin = new YouWin();
        
        addObject(replayButton,446,291);
        addObject(homeButton,304,313);
        addObject(youWin,353,226);
        
        homeButton.setLocation(65,30);
        youWin.setLocation(275,250);
        replayButton.setLocation(275 ,329);
    }
}
