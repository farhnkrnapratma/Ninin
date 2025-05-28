// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Block extends Tile {
    private int blockType;
    
    public Block(int type) {
        this.blockType = type;
        setGraphics(type);
    }
    
    private void setGraphics(int type) {
        switch (type) {
            case 1: // WALL
                setImage("Block.bmp");
                break;
            case 2: // GRASS_BLOCK
                setImage("BlockGrass.bmp");
                break;
            case 3: // SPIKE
                setImage("Spike.bmp");
                break;
            default:
                setImage("Block.bmp");
                break;
        }
    }
    
    public int getBlockType() {
        return blockType;
    }
}