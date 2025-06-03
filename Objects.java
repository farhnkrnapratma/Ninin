// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * Base class for all moving objects in the game.
 * Provides velocity handling, movement utilities, and basic interactions.
 */
public class Objects extends Actor {
  
  // Velocity properties
  protected double velocity_x = 0;
  protected double velocity_y = 0;
  
  // Maximum allowed speeds
  protected double velocity_move_MAX = 5;
  protected final double velocity_jump_MAX = 6;
  protected final double velocity_fall_MAX = 8;

  // Animation controls (unused here, for extension)
  protected boolean changeimage = false;
  protected int FrameMAX = 3;
  protected int Frameskipper = FrameMAX;

  // Size of a tile in pixels (used for positioning and collision)
  protected final int TILE_SIZE = 20;

  // Constant walking speed used in move methods
  private static final double WALKING_SPEED = 5.0;

  // Default constructor
  public Objects() {}

  /**
   * Empty act method, meant to be overridden by subclasses.
   */
  public void act() {}

  /**
   * Rotate the actor by a given angle (degrees).
   * @param angle Degrees to rotate
   */
  public void turn(int angle) {
    setRotation(getRotation() + angle);
  }

  /**
   * Move the actor by velocity_x and velocity_y.
   * @param velocity_x Movement along X axis
   * @param velocity_y Movement along Y axis
   */
  public void movexy(double velocity_x, double velocity_y) {
    setLocation(getX() + (int) velocity_x, getY() + (int) velocity_y);
  }

  /**
   * Move the actor forward by a fixed walking speed, based on current rotation.
   */
  public void move() {
    double angle = Math.toRadians(getRotation());
    int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
    int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
    setLocation(x, y);
  }

  /**
   * Move the actor forward by a specified speed, based on current rotation.
   * @param Speed Distance to move forward
   */
  public void move(double Speed) {
    double angle = Math.toRadians(getRotation());
    int x = (int) Math.round(getX() + Math.cos(angle) * Speed);
    int y = (int) Math.round(getY() + Math.sin(angle) * Speed);
    setLocation(x, y);
  }

  /**
   * Check if the actor is near the edge of the world.
   * @return true if near edge, false otherwise
   */
  public boolean atWorldEdge() {
    if (getX() < 20 || getX() > getWorld().getWidth() - 20) return true;
    if (getY() < 20 || getY() > getWorld().getHeight() - 20) return true;
    return false;
  }

  /**
   * Check if an object of specified class is touching this actor.
   * @param clss Class of the object to detect
   * @return true if object detected, false otherwise
   */
  public boolean canSee(Class clss) {
    Actor actor = getOneObjectAtOffset(0, 0, clss);
    return actor != null;
  }

  /**
   * Remove (eat) an object of the specified class touching this actor.
   * @param clss Class of the object to remove
   */
  public void eat(Class clss) {
    Actor actor = getOneObjectAtOffset(0, 0, clss);
    if (actor != null) {
      getWorld().removeObject(actor);
    }
  }

  /**
   * Set the maximum movement speed for this object.
   * @param limit New speed limit
   */
  public void SetSpeedLimit(int limit) {
    if (limit != 0) velocity_move_MAX = limit;
  }
}
