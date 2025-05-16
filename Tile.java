// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Tile extends Actor {
  public void act() {
  }

  public void SetGFX(int ID) {
    switch (ID) {
      case 1:
        setImage("Block.bmp");
        break;
      case 2:
        setImage("BlockGrass.bmp");
        break;
      default:
        break;
    }

    World welt = (JumpNRun) this.getWorld();
    welt.addObject(new Coin(), 22, 22);
  }
}