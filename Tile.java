// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * Tile represents a block or terrain in the game.
 * The appearance of the tile is set based on an ID value.
 */
public class Tile extends Actor {

    // Called every frame (currently empty)
    public void act() {
        // No behavior defined for now
    }

    /**
     * Sets the tile graphic based on the given ID.
     * Also adds a Scroll object to the world at position (22, 22).
     *
     * @param ID The graphic ID (1 = block, 2 = grass block)
     */
    public void SetGFX(int ID) {
        switch (ID) {
            case 1:
                setImage("Block.bmp"); // Solid block
                break;
            case 2:
                setImage("BlockGrass.bmp"); // Grass-covered block
                break;
            default:
                break; // No action for undefined IDs
        }

        // Add a Scroll object to the world (assumes this Tile is in Game world)
        World welt = (Game) this.getWorld();
        welt.addObject(new Scroll(), 22, 22);
    }
}
