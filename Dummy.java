// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Dummy extends Objects {
  // Coordinates used to control movement on grid
  public int _x = 0;
  public int _y = 0;

  public void act() {
    // Move horizontally in TILE_SIZE steps, wrap to next row if at right edge
    if (_x + TILE_SIZE >= 28 * TILE_SIZE) {
      _x = TILE_SIZE / 2;
      _y += TILE_SIZE;
    } else {
      _x += TILE_SIZE;
    }

    // If reached bottom edge, wrap to top row
    if (_y + TILE_SIZE >= 29 * TILE_SIZE) {
      _y = TILE_SIZE / 2;
    }

    // Update actor location on the grid
    setLocation(_x, _y);

    // Attempt to remove any overlapping objects in priority order
    if (canSee(Player.class)) eat(Player.class);
    else if (canSee(Box.class)) eat(Box.class);
    else if (canSee(Block.class)) eat(Block.class);
    else if (canSee(Scroll.class)) eat(Scroll.class);
    else if (canSee(Enemy.class)) eat(Enemy.class);
  }
}
