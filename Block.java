// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Block extends Tile {
  private int GFX = 0;

  public Block(int i) {
    GFX = i;
    switch (GFX) {
      case 1:
        setImage("Block.bmp");
        break;
      case 2:
        setImage("BlockGrass.bmp");
        break;
      case 3:
        setImage("Spikes_32.png");
        break;
      default:
        setImage("Block.bmp");
        break;
    }
  }

  public void act() {
  }

  public boolean isDeadly() {
    return GFX == 3;
  }

  public void Setgfx(int gfx) {
    switch (gfx) {
      case 1:
        setImage("Block.bmp");
        break;
      case 2:
        setImage("BlockGrass.bmp");
        break;
      case 3:
        setImage("Spikes_32.png");
        break;
      default:
        setImage("Block.bmp");
        break;
    }

    GFX = gfx;
  }
}
