// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Box extends Objects {
    private float velocityX = 0;
    private float velocityY = 0;
    private Game world;
    
    public Box() {
        setImage("Box.bmp");
    }
    
    protected void addedToWorld(World world) {
        if (world instanceof Game) {
            this.world = (Game) world;
        }
    }
    
    public void act() {
        applyPhysics();
    }
    
    private void applyPhysics() {
        // Apply gravity
        velocityY += 0.3f;
        if (velocityY > 8.0f) {
            velocityY = 8.0f;
        }
        
        // Apply friction to horizontal movement
        if (velocityX > 0) {
            velocityX -= 0.1f;
            if (velocityX < 0) velocityX = 0;
        } else if (velocityX < 0) {
            velocityX += 0.1f;
            if (velocityX > 0) velocityX = 0;
        }
        
        // Handle movement
        handleMovement();
    }
    
    private void handleMovement() {
        // Horizontal movement
        if (velocityX != 0) {
            int newX = getX() + (int)velocityX;
            if (canMoveTo(newX, getY())) {
                setLocation(newX, getY());
            } else {
                velocityX = 0;
            }
        }
        
        // Vertical movement
        if (velocityY != 0) {
            int newY = getY() + (int)velocityY;
            if (canMoveTo(getX(), newY)) {
                setLocation(getX(), newY);
            } else {
                velocityY = 0;
            }
        }
    }
    
    private boolean canMoveTo(int x, int y) {
        if (world == null) return true;
        
        // Check corners of the box
        int halfSize = 9;
        return !world.isSolid(x - halfSize, y - halfSize) &&
               !world.isSolid(x + halfSize, y - halfSize) &&
               !world.isSolid(x - halfSize, y + halfSize) &&
               !world.isSolid(x + halfSize, y + halfSize);
    }
    
    public boolean sideIsSolid(int offsetX, int offsetY, int velocityX) {
        if (world == null) return false;
        
        int checkX = getX() + offsetX + velocityX;
        int checkY = getY() + offsetY;
        
        return world.isSolid(checkX, checkY);
    }
    
    public void setVelocity(float vx, float vy) {
        this.velocityX = vx;
        this.velocityY = vy;
    }
}
