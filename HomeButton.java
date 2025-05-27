// SPDX-License-Identifier: MIT
import greenfoot.*;

public class HomeButton extends Actor {
  public HomeButton() {
    GreenfootImage img = getImage();
    img.scale(120, 50);
    setImage(img);
  }

  public void act() {
    if (Greenfoot.mousePressed(this)) {
      getImage()
          .scale(
              (int) Math.round(getImage().getWidth() * 0.8),
              (int) Math.round(getImage().getHeight() * 0.8));
    }
    if (Greenfoot.mouseClicked(this)) {
      Greenfoot.delay(2);
      Greenfoot.setWorld(new Menu());
    }
  }
}
