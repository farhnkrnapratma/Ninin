// SPDX-License-Identifier: MIT
import greenfoot.*;

public class InfoMenu extends World {

  public InfoMenu() {
    super(560, 560, 1);
    prepare();
  }
  
  private void prepare() {
    HomeButton homeButton = new HomeButton();
    addObject(homeButton, 283, 261);
    homeButton.setLocation(85, 54);
    homeButton.setLocation(26, 28);
    homeButton.setLocation(33, 28);
    homeButton.setLocation(92, 25);
    homeButton.setLocation(66, 30);
  }
}
