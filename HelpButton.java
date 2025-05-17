import greenfoot.*;

public class HelpButton extends Actor {
  public HelpButton() {
    GreenfootImage img = getImage();
    img.scale(160, 70);
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
      Greenfoot.setWorld(new HelpMenu());
    }
  }
}
