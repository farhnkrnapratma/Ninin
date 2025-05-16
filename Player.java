// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Player extends Objects {
  private boolean jumplock = true;
  private int jumphigh = 0;
  private final int JumpMAX = 60;
  private boolean freeze = false;
  private int TILE_SIZE = 20;
  private JumpNRun m_World;

  public Player(JumpNRun m_parent) {
    m_World = m_parent;
  }

  protected void Die() {
    m_World.ReloadLevel();
  }

  public void Freeze(boolean option) {
    freeze = option;
  }

  private void ColWithEnemy() {
    Actor Enemy = getOneObjectAtOffset(10, 0, Enemy.class);
    Actor Enemy2 = getOneObjectAtOffset(-10, 0, Enemy.class);
    Actor Enemy3 = getOneObjectAtOffset(10, -9, Enemy.class);
    Actor Enemy4 = getOneObjectAtOffset(-10, -9, Enemy.class);

    if (Enemy != null || Enemy2 != null || Enemy3 != null || Enemy4 != null) {
      Freeze(true);
      Die();
    }
  }

  public void Collision() {
    if (velocity_x > 0) {
      Actor Box = getOneObjectAtOffset(10, 0, Box.class);

      if (Box != null) {
        Box box = (Box) Box;
        if (!box.SideIsSolid(10, 9, velocity_x)) {
          Box.setLocation(Box.getX() + (int) velocity_x, Box.getY());
        } else {
          setLocation(Box.getX() - TILESIZE, getY());
          box.Setvelocity(velocity_x, 0);
          velocity_x = 0;
        }
      } else {
        int X = getX() + 10 + (int) velocity_x;
        int Y = getY() - 9;
        int Yend = getY() + 9;
        boolean free = true;
        while (Y <= Yend) {
          if (m_World.isSolid(X, Y)) {
            setLocation(X / TILESIZE * TILESIZE - 10, getY());
            free = false;
          }
          Y += 18;
        }

        if (free) movexy(velocity_x, 0);
        else velocity_x = 0;
      }
    } else if (velocity_x < 0) {
      Actor Box = getOneObjectAtOffset(-10, 0, Box.class);

      if (Box != null) {
        Box box = (Box) Box;
        if (!box.SideIsSolid(-10, 9, velocity_x)) {
          Box.setLocation(Box.getX() + (int) velocity_x, Box.getY());
        } else {
          setLocation(Box.getX() + TILESIZE, getY());
          box.Setvelocity(velocity_x, 0);
          velocity_x = 0;
        }
      } else {
        int X = getX() - 10 + (int) velocity_x;
        int Y = getY() - 9;
        int Yend = getY() + 9;
        boolean free = true;
        while (Y <= Yend) {
          if (m_World.isSolid(X, Y)) {
            setLocation((X / TILESIZE + 1) * TILESIZE + 10, getY());
            free = false;
          }
          Y += 18;
        }

        if (free) movexy(velocity_x, 0);
        else velocity_x = 0;
      }
    }

    if (velocity_y > 0) {
      jumphigh = 0;

      Actor Box = getOneObjectAtOffset(9, 10 + (int) velocity_y, Box.class);
      Actor Box2 = getOneObjectAtOffset(-9, 10 + (int) velocity_y, Box.class);

      if (Box != null) {
        velocity_y = 0;
        jumplock = false;
        setLocation(getX(), Box.getY() - TILESIZE);
      } else if (Box2 != null) {
        velocity_y = 0;
        jumplock = false;
        setLocation(getX(), Box2.getY() - TILESIZE);
      } else {
        int Y = getY() + 10 + (int) velocity_y;
        int X = getX() - 9;
        int Xend = getX() + 9;
        boolean free = true;

        if (m_World.onSpike(X, Y)) {
          Die();
          return;
        }

        while (X <= Xend) {
          if (m_World.isSolid(X, Y)) {
            setLocation(getX(), (Y / TILESIZE) * TILESIZE - 10);
            free = false;
            jumplock = false;
          }
          X += 18;
        }

        if (free) movexy(0, velocity_y);
        else velocity_y = 0;
      }
    } else if (velocity_y < 0) {
      int Y = getY() - 10 + (int) velocity_y;
      int X = getX() - 9;
      int Xend = getX() + 9;
      boolean free = true;

      while (X <= Xend) {
        if (m_World.isSolid(X, Y)) {
          setLocation(getX(), (Y / TILESIZE + 1) * TILESIZE + 10);
          free = false;
          jumplock = true;
        }
        X += 18;
      }

      if (free) movexy(0, velocity_y);
      else velocity_y = 0.1;
    } else {
      boolean left = m_World.isSolid(getX() - 9, getY() + 11);
      boolean right = m_World.isSolid(getX() + 9, getY() + 11);

      if (!left && !right) {
        velocity_y = 0.3f;
        jumplock = true;
      }
    }
  }

  public void Changeimage() {
    if (velocity_x != 0) Frameskipper--;
    else return;

    if (Frameskipper == 0) {
      if (changeimage) {
        Frameskipper = FrameMAX;
        changeimage = false;
      } else if (!changeimage) {
        Frameskipper = FrameMAX;
        changeimage = true;
      }

      if (velocity_x == 0) {
      }
    }
  }

  public void GetInput() {
    boolean move_right = true, move_left = true;

    if (Greenfoot.isKeyDown("D")) {
      if (velocity_x >= 0) velocity_x += 0.2f;
      else if (velocity_x < 0) velocity_x += 0.5f;

      if (velocity_x + 0.3f > velocity_move_MAX) velocity_x = velocity_move_MAX;
      else if (velocity_x > velocity_move_MAX) velocity_x -= 0.4f;
    } else move_left = false;

    if (Greenfoot.isKeyDown("A")) {
      if (velocity_x <= 0) velocity_x -= 0.2f;
      else if (velocity_x > 0) velocity_x -= 0.5f;
      if (velocity_x - 0.3f < -velocity_move_MAX) velocity_x = -velocity_move_MAX;
      else if (velocity_x < -velocity_move_MAX) velocity_x += 0.4f;
    } else move_right = false;

    if (Greenfoot.isKeyDown("space") && !jumplock) {
      if (jumphigh == 0) jumphigh = getY() - JumpMAX;

      if (getY() <= jumphigh) {
        jumphigh = 0;
        jumplock = true;
      }

      velocity_y -= 0.4f;
      if (velocity_y < -velocity_jump_MAX) velocity_y = -velocity_jump_MAX;
    } else if (!Greenfoot.isKeyDown("space") && velocity_y < 0 && !jumplock) {
      jumplock = true;
    }

    if (jumplock) {
      velocity_y += 0.3f;
      if (velocity_y > velocity_fall_MAX) velocity_y = velocity_fall_MAX;
    }

    if (!move_left && !move_right) {
      if (velocity_x < 0) velocity_x += 0.75f;
      else if (velocity_x > 0) velocity_x -= 0.75f;

      if (velocity_x <= 1.1f && velocity_x >= -1.1f) velocity_x = 0;
    }

    if (Greenfoot.isKeyDown("r")) Die();
  }

  public void act() {
    if (!freeze) {
      if (canSee(Coin.class)) {
        eat(Coin.class);
      }

      GetInput();
      Changeimage();
      Collision();
      ColWithEnemy();
    }
  }
}