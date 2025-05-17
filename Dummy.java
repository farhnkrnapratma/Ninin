// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Dummy extends Objects {
  public int _x = 0;
  public int _y = 0;

  public void act() {
    if (_x + TILESIZE >= 28 * TILESIZE) {
      _x = TILESIZE / 2;
      _y += TILESIZE;
    } else {
      _x += TILESIZE;
    }

    if (_y + TILESIZE >= 29 * TILESIZE) {
      _y = TILESIZE / 2;
    }

    setLocation(_x, _y);

    if (canSee(Player.class)) eat(Player.class);
    else if (canSee(Box.class)) eat(Box.class);
    else if (canSee(Block.class)) eat(Block.class);
    else if (canSee(Scroll.class)) eat(Scroll.class);
    else if (canSee(Enemy.class)) eat(Enemy.class);
  }
}
