// SPDX-License-Identifier: MIT
import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Game extends World {
    private Actor dummy = new Dummy();
    private Player player = new Player(this);
    
    private int currentLevel = 1;
    private int scrollsCollected = 0;
    private int totalObjects = 0;
    private boolean mapLoaded = false;
    private boolean allObjectsDestroyed = false;
    private boolean retry = false;
    
    private int[][] levelData = new int[GameConfig.WORLD_HEIGHT][GameConfig.WORLD_WIDTH];
    private LevelManager levelManager;
    
    public Game() {
        super(GameConfig.PIXEL_WIDTH, GameConfig.PIXEL_HEIGHT, 1);
        Greenfoot.setSpeed(GameConfig.NORMAL_SPEED);
        this.levelManager = new LevelManager();
        loadLevel(currentLevel);
        generateLevel();
    }
    
    public void reloadLevel() {
        retry = true;
    }
    
    public void loadLevel(int level) {
        int[][] newLevelData = levelManager.getLevelData(level);
        if (newLevelData != null) {
            for (int i = 0; i < GameConfig.WORLD_HEIGHT; i++) {
                System.arraycopy(newLevelData[i], 0, levelData[i], 0, GameConfig.WORLD_WIDTH);
            }
        }
    }
    
    public void generateLevel() {
        scrollsCollected = 0;
        totalObjects = 0;
        
        removeObjects(getObjects(null));
        
        int pixelX = GameConfig.TILE_SIZE / 2;
        int pixelY = GameConfig.TILE_SIZE / 2;
        
        for (int row = 0; row < GameConfig.WORLD_HEIGHT; row++) {
            pixelX = GameConfig.TILE_SIZE / 2;
            for (int col = 0; col < GameConfig.WORLD_WIDTH; col++) {
                int tileType = levelData[row][col];
                createGameObject(tileType, pixelX, pixelY);
                pixelX += GameConfig.TILE_SIZE;
            }
            pixelY += GameConfig.TILE_SIZE;
        }
        
        mapLoaded = true;
    }
    
    private void createGameObject(int tileType, int x, int y) {
        switch (tileType) {
            case GameConfig.WALL:
            case GameConfig.GRASS_BLOCK:
            case GameConfig.SPIKE:
                addObject(new Block(tileType), x, y);
                totalObjects++;
                break;
            case GameConfig.BOX:
                addObject(new Box(), x, y);
                totalObjects++;
                break;
            case GameConfig.PLAYER_SPAWN:
                addObject(player, x, y);
                totalObjects++;
                break;
            case GameConfig.SCROLL:
                addObject(new Scroll(), x, y);
                scrollsCollected++;
                totalObjects++;
                break;
            case GameConfig.ENEMY_HORIZONTAL:
            case GameConfig.ENEMY_VERTICAL:
                addObject(new Enemy(tileType), x, y);
                totalObjects++;
                break;
        }
    }
    
    public void act() {
        handleInput();
        handleLevelTransition();
    }
    
    private void handleInput() {
        if (Greenfoot.isKeyDown("p")) {
            Greenfoot.setWorld(new PauseMenu());
        }
    }
    
    private void handleLevelTransition() {
        if ((numberOfObjects() == totalObjects - scrollsCollected && mapLoaded) || retry) {
            startCleanup();
        }
        
        if (numberOfObjects() == 1) {
            finishCleanup();
        }
        
        if (allObjectsDestroyed) {
            transitionToNextLevel();
        }
    }
    
    private void startCleanup() {
        player.freeze(true);
        addObject(dummy, 0, 0);
        Greenfoot.setSpeed(GameConfig.CLEANUP_SPEED);
    }
    
    private void finishCleanup() {
        removeObject(dummy);
        allObjectsDestroyed = true;
        player.freeze(false);
        Greenfoot.setSpeed(GameConfig.NORMAL_SPEED);
    }
    
    private void transitionToNextLevel() {
        allObjectsDestroyed = false;
        
        if (!retry) {
            currentLevel++;
        }
        
        retry = false;
        loadLevel(currentLevel);
        generateLevel();
    }
    
    public boolean isSolid(int x, int y) {
        return getTileTypeAt(x, y) == GameConfig.WALL || 
               getTileTypeAt(x, y) == GameConfig.GRASS_BLOCK;
    }
    
    public boolean isSpike(int x, int y) {
        return getTileTypeAt(x, y) == GameConfig.SPIKE;
    }
    
    private int getTileTypeAt(int x, int y) {
        int tileX = x / GameConfig.TILE_SIZE;
        int tileY = y / GameConfig.TILE_SIZE;
        
        if (tileX < 0 || tileX >= GameConfig.WORLD_WIDTH || 
            tileY < 0 || tileY >= GameConfig.WORLD_HEIGHT) {
            return GameConfig.WALL; // Treat out-of-bounds as solid
        }
        
        return levelData[tileY][tileX];
    }
}
