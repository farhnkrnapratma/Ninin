// SPDX-License-Identifier: MIT
import greenfoot.*;

public class GameConfig {
    public static final int TILE_SIZE = 20;
    public static final int WORLD_WIDTH = 28;
    public static final int WORLD_HEIGHT = 28;
    public static final int PIXEL_WIDTH = TILE_SIZE * WORLD_WIDTH;
    public static final int PIXEL_HEIGHT = TILE_SIZE * WORLD_HEIGHT;
    
    // Game speeds
    public static final int NORMAL_SPEED = 50;
    public static final int CLEANUP_SPEED = 70;
    
    // Tile types
    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int GRASS_BLOCK = 2;
    public static final int SPIKE = 3;
    public static final int BOX = 4;
    public static final int PLAYER_SPAWN = 5;
    public static final int SCROLL = 6;
    public static final int ENEMY_HORIZONTAL = 7;
    public static final int ENEMY_VERTICAL = 8;
    
    // Player constants
    public static final float PLAYER_ACCELERATION = 0.2f;
    public static final float PLAYER_DECELERATION = 0.5f;
    public static final float PLAYER_MAX_SPEED = 3.0f;
    public static final float PLAYER_JUMP_POWER = 0.4f;
    public static final float PLAYER_GRAVITY = 0.3f;
    public static final float PLAYER_MAX_FALL_SPEED = 8.0f;
    public static final float PLAYER_MAX_JUMP_SPEED = 6.0f;
    public static final int PLAYER_JUMP_HEIGHT = 60;
    public static final int PLAYER_ANIMATION_FRAMES = 8;
}