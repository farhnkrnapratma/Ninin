// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Player extends Objects {
    // Jump control variables
    private boolean jumpLock = true;  // Lock to prevent multiple jumps
    private int jumpHigh = 0;          // Highest jump point
    private final int JumpMAX = 60;    // Maximum jump height

    private boolean freeze = false;    // Freeze player movement
    private int TILE_SIZE = 20;        // Tile size in pixels
    private Game m_World;              // Reference to game world
    private String lastDirection = "right"; // Last movement direction for image

    // Constructor to receive reference to the game world
    public Player(Game m_parent) {
        m_World = m_parent;
    }

    // Called when player dies, triggers level reload
    protected void Die() {
        m_World.ReloadLevel();
    }

    // Freeze or unfreeze player movement
    public void Freeze(boolean option) {
        freeze = option;
    }

    // Check collision with enemy and kill player if collision happens
    private void ColWithEnemy() {
        Actor Enemy1 = getOneObjectAtOffset(10, 0, Enemy.class);
        Actor Enemy2 = getOneObjectAtOffset(-10, 0, Enemy.class);
        Actor Enemy3 = getOneObjectAtOffset(10, -9, Enemy.class);
        Actor Enemy4 = getOneObjectAtOffset(-10, -9, Enemy.class);

        if (Enemy1 != null || Enemy2 != null || Enemy3 != null || Enemy4 != null) {
            Freeze(true);
            Die();
        }
    }

    // Handle collisions in all directions and movement restrictions
    public void Collision() {
        // Horizontal movement and collisions
        if (velocity_x > 0) { // Moving right
            Actor Box = getOneObjectAtOffset(10, 0, Box.class);
            if (Box != null) {
                Box box = (Box) Box;
                if (!box.SideIsSolid(10, 9, velocity_x)) {
                    Box.setLocation(Box.getX() + (int) velocity_x, Box.getY());
                } else {
                    setLocation(Box.getX() - TILE_SIZE, getY());
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
                        setLocation(X / TILE_SIZE * TILE_SIZE - 10, getY());
                        free = false;
                    }
                    Y += 18;
                }

                if (free) movexy(velocity_x, 0);
                else velocity_x = 0;
            }
        } else if (velocity_x < 0) { // Moving left
            Actor Box = getOneObjectAtOffset(-10, 0, Box.class);
            if (Box != null) {
                Box box = (Box) Box;
                if (!box.SideIsSolid(-10, 9, velocity_x)) {
                    Box.setLocation(Box.getX() + (int) velocity_x, Box.getY());
                } else {
                    setLocation(Box.getX() + TILE_SIZE, getY());
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
                        setLocation((X / TILE_SIZE + 1) * TILE_SIZE + 10, getY());
                        free = false;
                    }
                    Y += 18;
                }

                if (free) movexy(velocity_x, 0);
                else velocity_x = 0;
            }
        }

        // Vertical movement and collisions
        if (velocity_y > 0) { // Falling down
            jumpHigh = 0;

            Actor Box1 = getOneObjectAtOffset(9, 10 + (int) velocity_y, Box.class);
            Actor Box2 = getOneObjectAtOffset(-9, 10 + (int) velocity_y, Box.class);

            if (Box1 != null) {
                velocity_y = 0;
                jumpLock = false;
                setLocation(getX(), Box1.getY() - TILE_SIZE);
            } else if (Box2 != null) {
                velocity_y = 0;
                jumpLock = false;
                setLocation(getX(), Box2.getY() - TILE_SIZE);
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
                        setLocation(getX(), (Y / TILE_SIZE) * TILE_SIZE - 10);
                        free = false;
                        jumpLock = false;
                    }
                    X += 18;
                }

                if (free) movexy(0, velocity_y);
                else velocity_y = 0;
            }
        } else if (velocity_y < 0) { // Moving up
            int Y = getY() - 10 + (int) velocity_y;
            int X = getX() - 9;
            int Xend = getX() + 9;
            boolean free = true;

            while (X <= Xend) {
                if (m_World.isSolid(X, Y)) {
                    setLocation(getX(), (Y / TILE_SIZE + 1) * TILE_SIZE + 10);
                    free = false;
                    jumpLock = true;
                }
                X += 18;
            }

            if (free) movexy(0, velocity_y);
            else velocity_y = 0.1;
        } else {
            // Check if standing on ground
            boolean left = m_World.isSolid(getX() - 9, getY() + 11);
            boolean right = m_World.isSolid(getX() + 9, getY() + 11);

            if (!left && !right) {
                velocity_y = 0.3f;  // Apply gravity
                jumpLock = true;
            }
        }
    }

    // Change player image depending on movement state
    public void Changeimage() {
        if (velocity_y < 0) {
            setImage("Player_jump.png");
        } else if (jumpLock && velocity_y > 0.3f) {
            setImage("Player_fall.png");
        } else if (velocity_x < 0) {
            setImage("Player_left.png");
            lastDirection = "left";
        } else if (velocity_x > 0) {
            setImage("Player_right.png");
            lastDirection = "right";
        } else {
            if (lastDirection.equals("left")) {
                setImage("Player_left.png");
            } else {
                setImage("Player_right.png");
            }
        }

        if (velocity_x != 0) Frameskipper--;
        else return;

        if (Frameskipper == 0) {
            if (changeimage) {
                Frameskipper = FrameMAX;
                changeimage = false;
            } else {
                Frameskipper = FrameMAX;
                changeimage = true;
            }
        }
    }

    // Process user input for movement and jumping
    public void GetInput() {
        boolean moveRight = true, moveLeft = true;

        if (Greenfoot.isKeyDown("D")) {
            if (velocity_x >= 0) velocity_x += 0.2f;
            else if (velocity_x < 0) velocity_x += 0.5f;

            if (velocity_x + 0.3f > velocity_move_MAX) velocity_x = velocity_move_MAX;
            else if (velocity_x > velocity_move_MAX) velocity_x -= 0.4f;
        } else moveLeft = false;

        if (Greenfoot.isKeyDown("A")) {
            if (velocity_x <= 0) velocity_x -= 0.2f;
            else if (velocity_x > 0) velocity_x -= 0.5f;
            if (velocity_x - 0.3f < -velocity_move_MAX) velocity_x = -velocity_move_MAX;
            else if (velocity_x < -velocity_move_MAX) velocity_x += 0.4f;
        } else moveRight = false;

        if (Greenfoot.isKeyDown("space") && !jumpLock) {
            if (jumpHigh == 0) jumpHigh = getY() - JumpMAX;

            if (getY() <= jumpHigh) {
                jumpHigh = 0;
                jumpLock = true;
            }

            velocity_y -= 0.4f;
            if (velocity_y < -velocity_jump_MAX) velocity_y = -velocity_jump_MAX;
        } else if (!Greenfoot.isKeyDown("space") && velocity_y < 0 && !jumpLock) {
            jumpLock = true;
        }

        if (jumpLock) {
            velocity_y += 0.3f;
            if (velocity_y > velocity_fall_MAX) velocity_y = velocity_fall_MAX;
        }

        if (!moveLeft && !moveRight) {
            if (velocity_x < 0) velocity_x += 0.75f;
            else if (velocity_x > 0) velocity_x -= 0.75f;

            if (velocity_x <= 1.1f && velocity_x >= -1.1f) velocity_x = 0;
        }
    }

    // Main method called each frame to update player state
    public void Act() {
        if (freeze) return;

        ColWithEnemy();
        GetInput();
        Collision();
        Changeimage();
    }
}
