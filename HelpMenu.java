// SPDX-License-Identifier: MIT
import greenfoot.*;

public class HelpMenu extends World {

  public HelpMenu() {
    super(560, 560, 1);
    prepare();
  }

  private void prepare() {
    HomeButton homeButton = new HomeButton();
    addObject(homeButton, 283, 261);
    homeButton.setLocation(65, 30);
  }
}
