// SPDX-License-Identifier: MIT
import greenfoot.*;

public class PauseMenu extends World {
  public PauseMenu() {
    super(560, 560, 1);
    prepare();
  }

  private void prepare() {
    HomeButton homeButton = new HomeButton();
    HelpButton helpButton = new HelpButton();
    ReplayButton replayButton = new ReplayButton();
    ResumeButton resumeButton = new ResumeButton();

    addObject(homeButton, 290, 290);
    addObject(helpButton, 290, 290);
    addObject(replayButton, 290, 290);
    addObject(resumeButton, 290, 290);

    homeButton.setLocation(65, 30);
    resumeButton.setLocation(275, 250);
    replayButton.setLocation(275, 320);
    helpButton.setLocation(275, 390);
  }
}
