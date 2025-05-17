// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Scroll extends Objects {
  public int gfx = 1;
  public int wait = 5;

  GreenfootImage CoinAnim1 = new GreenfootImage("Coin1_32.png");
  GreenfootImage CoinAnim2 = new GreenfootImage("Coin2_32.png");
  GreenfootImage CoinAnim3 = new GreenfootImage("Coin3_32.png");
  GreenfootImage CoinAnim4 = new GreenfootImage("Coin4_32.png");

  public Scroll() {
    setImage("CoinANIM.gif");
  }

  public void act() {
    if (wait == 0) {
      if (++gfx > 4) gfx = 1;

      switch (gfx) {
        case 1:
          setImage(CoinAnim1);
          break;
        case 2:
          setImage(CoinAnim2);
          break;
        case 3:
          setImage(CoinAnim3);
          break;
        case 4:
          setImage(CoinAnim4);
          break;
        default:
          setImage(CoinAnim1);
          break;
      }

      wait = 5;
    }

    --wait;
  }
}
