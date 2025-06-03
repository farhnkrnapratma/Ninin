// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * Box is a dynamic object that can move, collide with other objects, and simulate gravity.
 * It inherits velocity and tile size properties from the parent class 'Objects'.
 */
public class Box extends Objects {

    /**
     * Sets the horizontal and vertical velocity of the box.
     * Only updates non-zero values.
     * @param v_velx Horizontal velocity
     * @param v_vely Vertical velocity
     */
    public void Setvelocity(double v_velx, double v_vely) {
        if (v_velx != 0) velocity_x = v_velx;
        if (v_vely != 0) velocity_y = v_vely;
    }

    /**
     * Controls friction (on X) and gravity (on Y) for the box's movement.
     * Slows down horizontal movement over time, and applies gravity downward.
     */
    public void ControlVelocity() {
        // Apply friction
        if (velocity_x != 0) {
            if (velocity_x < 0) velocity_x += 0.5f;
            else if (velocity_x > 0) velocity_x -= 0.5f;

            if (velocity_x <= 1.1f && velocity_x >= -1.1f) {
                velocity_x = 0;
            }
        }

        // Apply gravity
        if (velocity_y != 0) {
            velocity_y += 0.3f;
            if (velocity_y > velocity_fall_MAX) {
                velocity_y = velocity_fall_MAX;
            }
        }
    }

    /**
     * Checks if there is any solid object (Block, Box, Player, or Enemy)
     * on the side where the box is moving.
     * @param offsetx X-offset to check
     * @param offsety Y-offset to check
     * @param _velx Velocity in X direction
     * @return true if collision detected; otherwise false
     */
    public boolean SideIsSolid(int offsetx, int offsety, double _velx) {
        return getOneObjectAtOffset(offsetx + (int) _velx, offsety, Block.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Block.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, offsety, Box.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Box.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, offsety, Player.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Player.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, -offsety, Enemy.class) != null
            || getOneObjectAtOffset(offsetx + (int) _velx, offsety, Enemy.class) != null;
    }

    /**
     * Handles collision detection and response for both X and Y directions.
     * If a collision occurs, stops movement and adjusts position to avoid overlapping.
     */
    public void Collision() {
        // Horizontal collision
        if (velocity_x > 0) {
            Actor[] xColliders = {
                getOneObjectAtOffset(10 + (int) velocity_x, 9, Block.class),
                getOneObjectAtOffset(10 + (int) velocity_x, -9, Block.class),
                getOneObjectAtOffset(10 + (int) velocity_x, 9, Box.class),
                getOneObjectAtOffset(10 + (int) velocity_x, -9, Box.class),
                getOneObjectAtOffset(10 + (int) velocity_x, 9, Player.class),
                getOneObjectAtOffset(10 + (int) velocity_x, -9, Player.class)
            };

            for (Actor a : xColliders) {
                if (a != null) {
                    velocity_x = 0;
                    setLocation(a.getX() - TILE_SIZE, getY());
                    return;
                }
            }

            // Move if no collision
            movexy(velocity_x, 0);
        }

        // Vertical collision
        if (velocity_y > 0) {
            Actor[] yColliders = {
                getOneObjectAtOffset(9, 10 + (int) velocity_y, Block.class),
                getOneObjectAtOffset(-9, 10 + (int) velocity_y, Block.class),
                getOneObjectAtOffset(9, 10 + (int) velocity_y, Box.class),
                getOneObjectAtOffset(-9, 10 + (int) velocity_y, Box.class),
                getOneObjectAtOffset(9, 10 + (int) velocity_y, Player.class),
                getOneObjectAtOffset(-9, 10 + (int) velocity_y, Player.class)
            };

            for (Actor a : yColliders) {
                if (a != null) {
                    velocity_y = 0;
                    setLocation(getX(), a.getY() - TILE_SIZE);
                    return;
                }
            }

            // Move if no collision
            movexy(0, velocity_y);

        } else if (velocity_y == 0) {
            // Check if box is on air
            Actor[] airCheck = {
                getOneObjectAtOffset(8, 10, Block.class),
                getOneObjectAtOffset(-8, 10, Block.class),
                getOneObjectAtOffset(8, 10, Box.class),
                getOneObjectAtOffset(-8, 10, Box.class),
                getOneObjectAtOffset(8, 10, Player.class),
                getOneObjectAtOffset(-8, 10, Player.class)
            };

            boolean onGround = false;
            for (Actor a : airCheck) {
                if (a != null) {
                    onGround = true;
                    break;
                }
            }

            // If not on ground, simulate falling
            if (!onGround) {
                velocity_y = 0.3f;
            }
        }
    }

    /**
     * Called every frame. Updates velocity and checks for collisions.
     */
    public void act() {
        ControlVelocity();
        Collision();
    }
}
