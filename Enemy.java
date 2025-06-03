// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Enemy extends Objects {
    // Horizontal velocity of the enemy
    protected double velocityX = 0;

    // Constructor with parameter to set initial velocity based on type
    public Enemy(int type) {
        if (type == 7) velocityX = 2;
        else if (type == 8) velocityX = 3;
        else velocityX = 2;
    }

    // Default constructor
    public Enemy() {}

    // Handle collision detection and movement logic
    private void collision() {
        if (velocityX > 0) {
            // Check for block or box in front, and if ground exists below
            Actor block = getOneObjectAtOffset(10 + (int) velocityX, 0, Block.class);
            Actor empty = getOneObjectAtOffset(10 + (int) velocityX, 11, Block.class);
            Actor box = getOneObjectAtOffset(10 + (int) velocityX, 0, Box.class);

            // Reverse direction if obstacle or no ground ahead
            if (block != null || box != null || empty == null) {
                velocityX = -velocityX;
            } else {
                movexy(velocityX, 0);
            }
        } else if (velocityX < 0) {
            // Check for block or box in front, and if ground exists below when moving left
            Actor block = getOneObjectAtOffset(-10 + (int) velocityX, 0, Block.class);
            Actor empty = getOneObjectAtOffset(-10 + (int) velocityX, 11, Block.class);
            Actor box = getOneObjectAtOffset(-10 + (int) velocityX, 0, Box.class);

            // Reverse direction if obstacle or no ground ahead
            if (block != null || box != null || empty == null) {
                velocityX = -velocityX;
            } else {
                movexy(velocityX, 0);
            }
        }
    }

    // Called every frame to update enemy behavior
    public void act() {
        collision();
    }
}
