// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Box extends Objects {
  public void Setvelocity(double v_velx, double v_vely) {
    if (v_velx != 0) velocity_x = v_velx;
    if (v_vely != 0) velocity_y = v_vely;
  }

  public void ControlVelocity() {
    if (velocity_x != 0) {
      if (velocity_x < 0) velocity_x += 0.5f;
      else if (velocity_x > 0) velocity_x -= 0.5f;
      if (velocity_x <= 1.1f && velocity_x >= -1.1f) velocity_x = 0;
    }

    if (velocity_y != 0) {
      velocity_y += 0.3f;
      if (velocity_y > velocity_fall_MAX) velocity_y = velocity_fall_MAX;
    }
  }

  public boolean SideIsSolid(int offsetx, int offsety, double _velx) {
    Actor Block = getOneObjectAtOffset(offsetx + (int) _velx, offsety, Block.class);
    Actor Block2 = getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Block.class);
    Actor Box = getOneObjectAtOffset(offsetx + (int) _velx, offsety, Box.class);
    Actor Box2 = getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Box.class);
    Actor Player = getOneObjectAtOffset(offsetx + (int) _velx, offsety, Player.class);
    Actor Player2 = getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Player.class);
    Actor Enemy = getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Enemy.class);
    Actor Enemy2 = getOneObjectAtOffset(offsetx + (int) _velx, offsety, Enemy.class);

    return Block != null
        || Block2 != null
        || Box != null
        || Box2 != null
        || Player != null
        || Player2 != null
        || Enemy != null
        || Enemy2 != null;
  }

  public void Collision() {
    if (velocity_x > 0) {
      Actor Block = getOneObjectAtOffset(10 + (int) velocity_x, 9, Block.class);
      Actor Block2 = getOneObjectAtOffset(10 + (int) velocity_x, -9, Block.class);
      Actor Box = getOneObjectAtOffset(10 + (int) velocity_x, 9, Box.class);
      Actor Box2 = getOneObjectAtOffset(10 + (int) velocity_x, -9, Box.class);
      Actor Player = getOneObjectAtOffset(10 + (int) velocity_x, 9, Player.class);
      Actor Player2 = getOneObjectAtOffset(10 + (int) velocity_x, -9, Player.class);

      if (Block != null) {
        velocity_x = 0;
        setLocation(Block.getX() - TILESIZE, getY());
      } else if (Block2 != null) {
        velocity_x = 0;
        setLocation(Block.getX() - TILESIZE, getY());
      } else if (Box != null) {
        velocity_x = 0;
        setLocation(Box.getX() - TILESIZE, getY());
      } else if (Box2 != null) {
        velocity_x = 0;
        setLocation(Box2.getX() - TILESIZE, getY());
      } else if (Player != null) {
        velocity_x = 0;
        setLocation(Player.getX() - TILESIZE, getY());
      } else if (Player2 != null) {
        velocity_x = 0;
        setLocation(Player2.getX() - TILESIZE, getY());
      } else movexy(velocity_x, 0);
    }

    if (velocity_y > 0) {
      Actor Block = getOneObjectAtOffset(9, 10 + (int) velocity_y, Block.class);
      Actor Block2 = getOneObjectAtOffset(-9, 10 + (int) velocity_y, Block.class);
      Actor Box = getOneObjectAtOffset(9, 10 + (int) velocity_y, Box.class);
      Actor Box2 = getOneObjectAtOffset(-9, 10 + (int) velocity_y, Box.class);
      Actor Player = getOneObjectAtOffset(9, 10 + (int) velocity_y, Player.class);
      Actor Player2 = getOneObjectAtOffset(-9, 10 + (int) velocity_y, Player.class);

      if (Block != null) {
        velocity_y = 0;
        setLocation(getX(), Block.getY() - TILESIZE);
      } else if (Block2 != null) {
        velocity_y = 0;
        setLocation(getX(), Block2.getY() - TILESIZE);
      } else if (Box != null) {
        velocity_y = 0;
        setLocation(getX(), Box.getY() - TILESIZE);
      } else if (Box2 != null) {
        velocity_y = 0;
        setLocation(getX(), Box2.getY() - TILESIZE);
      } else if (Player != null) {
        velocity_y = 0;
        setLocation(getX(), Player.getY() - TILESIZE);
      } else if (Player2 != null) {
        velocity_y = 0;
        setLocation(getX(), Player2.getY() - TILESIZE);
      } else movexy(0, velocity_y);
    } else if (velocity_y == 0) {
      Actor Block = getOneObjectAtOffset(8, 10, Block.class);
      Actor Block2 = getOneObjectAtOffset(-8, 10, Block.class);
      Actor Box = getOneObjectAtOffset(8, 10, Box.class);
      Actor Box2 = getOneObjectAtOffset(-8, 10, Box.class);
      Actor Player = getOneObjectAtOffset(8, 10, Player.class);
      Actor Player2 = getOneObjectAtOffset(-8, 10, Player.class);

      if (Block == null
          && Block2 == null
          && Box == null
          && Box2 == null
          && Player == null
          && Player2 == null) {
        velocity_y = 0.3f;
      }
    }
  }

  public void act() {
    ControlVelocity();
    Collision();
  }
}
