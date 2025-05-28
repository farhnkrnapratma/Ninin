// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Enemy extends Objects {
    private int movementDirection = 1;
    private int movementType;
    private Game world;
    private int moveCounter = 0;
    private final int MOVE_DISTANCE = GameConfig.TILE_SIZE * 3;
    
    public Enemy(int type) {
        this.movementType = type;
        setImage("Obstacle.png");
    }
    
    protected void addedToWorld(World world) {
        this.world = (Game) world;
    }
    
    public void act() {
        move();
    }
    
    private void move() {
        if (movementType == GameConfig.ENEMY_HORIZONTAL) {
            moveHorizontally();
        } else if (movementType == GameConfig.ENEMY_VERTICAL) {
            moveVertically();
        }
    }
    
    private void moveHorizontally() {
        int newX = getX() + (movementDirection * 2);
        
        if (canMoveTo(newX, getY())) {
            setLocation(newX, getY());
            moveCounter += 2;
        } else {
            movementDirection *= -1;
            moveCounter = 0;
        }
        
        if (moveCounter >= MOVE_DISTANCE) {
            movementDirection *= -1;
            moveCounter = 0;
        }
    }
    
    private void moveVertically() {
        int newY = getY() + (movementDirection * 2);
        
        if (canMoveTo(getX(), newY)) {
            setLocation(getX(), newY);
            moveCounter += 2;
        } else {
            movementDirection *= -1;
            moveCounter = 0;
        }
        
        if (moveCounter >= MOVE_DISTANCE) {
            movementDirection *= -1;
            moveCounter = 0;
        }
    }
    
    private boolean canMoveTo(int x, int y) {
        if (world == null) return true;
        
        return !world.isSolid(x, y) && 
               x >= 0 && x < GameConfig.PIXEL_WIDTH &&
               y >= 0 && y < GameConfig.PIXEL_HEIGHT;
    }
}
