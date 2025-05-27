// SPDX-License-Identifier: MIT
import greenfoot.*;
public class Menu extends World {
  public Menu() {
    super(560, 560, 1);
    prepare();
  }
    private void prepare() {
        PlayButton playButton = new PlayButton();
        HelpButton helpButton = new HelpButton();
        
        addObject(playButton, 348, 395);
        addObject(helpButton, 348, 395);
        
        playButton.setLocation(275, 370);
        helpButton.setLocation(275, 435);
    }
}
