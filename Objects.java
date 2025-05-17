// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Objects extends Actor {
  protected double velocity_x = 0;
  protected double velocity_y = 0;
  protected double velocity_move_MAX = 5;
  protected final double velocity_jump_MAX = 6;
  protected final double velocity_fall_MAX = 8;

  protected boolean changeimage = false;
  protected int FrameMAX = 3;
  protected int Frameskipper = FrameMAX;

  protected final int TILESIZE = 20;

  private static final double WALKING_SPEED = 5.0;

  public Objects() {}

  public void act() {}

  public void turn(int angle) {
    setRotation(getRotation() + angle);
  }

  public void movexy(double velocity_x, double velocity_y) {
    setLocation(getX() + (int) velocity_x, getY() + (int) velocity_y);
  }

  public void move() {
    double angle = Math.toRadians(getRotation());
    int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
    int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
    setLocation(x, y);
  }

  public void move(double Speed) {
    double angle = Math.toRadians(getRotation());
    int x = (int) Math.round(getX() + Math.cos(angle) * Speed);
    int y = (int) Math.round(getY() + Math.sin(angle) * Speed);
    setLocation(x, y);
  }

  public boolean atWorldEdge() {
    if (getX() < 20 || getX() > getWorld().getWidth() - 20) return true;
    if (getY() < 20 || getY() > getWorld().getHeight() - 20) return true;
    else return false;
  }

  public boolean canSee(Class clss) {
    Actor actor = getOneObjectAtOffset(0, 0, clss);
    return actor != null;
  }

  public void eat(Class clss) {
    Actor actor = getOneObjectAtOffset(0, 0, clss);
    if (actor != null) {
      getWorld().removeObject(actor);
    }
  }

  public void SetSpeedLimit(int limit) {
    if (limit != 0) velocity_move_MAX = limit;
  }
}
