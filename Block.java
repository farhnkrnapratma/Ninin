import greenfoot.*;

/**
 * Block is a tile in the game world that can be a solid block, grass block, or deadly spike block.
 * If it's a spike block, it will animate between different frames.
 */
public class Block extends Tile {

    private int GFX = 0; // ID of the current graphic (1 = block, 2 = grass, 3 = spikes)
    private int animationTimer = 0; // Controls spike animation timing
    private int currentFrame = 0; // Current frame index for spike animation

    private static final int ANIMATION_SPEED = 15; // Frame change delay

    // Array of spike image filenames (for animation)
    private static final String[] SPIKE_FRAMES = {
        "Spikes_32.png",
        "Spikes_32_left.png",
        "Spikes_32_right.png"
    };

    /**
     * Constructor to create a Block with a specific GFX ID.
     * @param i GFX ID to determine the type of block.
     */
    public Block(int i) {
        GFX = i;
        switch (GFX) {
            case 1:
                setImage("Block.bmp"); // Solid block
                break;
            case 2:
                setImage("BlockGrass.bmp"); // Grass-covered block
                break;
            case 3:
                setImage("Spikes_32.png"); // Spikes
                break;
            default:
                setImage("Block.bmp");
                break;
        }
    }

    // This method is called every frame
    public void act() {
        // If the block is a spike, animate it
        if (GFX == 3) {
            animateSpikes();
        }
    }

    /**
     * Animates the spike block by cycling through spike images.
     */
    private void animateSpikes() {
        animationTimer++;

        if (animationTimer >= ANIMATION_SPEED) {
            animationTimer = 0;

            // Cycle to next frame
            currentFrame = (currentFrame + 1) % SPIKE_FRAMES.length;
            setImage(SPIKE_FRAMES[currentFrame]);
        }
    }

    /**
     * Returns true if this block is a deadly spike.
     * @return true if block is GFX 3 (spike), false otherwise.
     */
    public boolean isDeadly() {
        return GFX == 3;
    }

    /**
     * Changes the GFX type of this block and resets animation if needed.
     * @param gfx The new GFX ID to apply.
     */
    public void Setgfx(int gfx) {
        switch (gfx) {
            case 1:
                setImage("Block.bmp");
                break;
            case 2:
                setImage("BlockGrass.bmp");
                break;
            case 3:
                setImage("Spikes_32.png");
                animationTimer = 0;
                currentFrame = 0;
                break;
            default:
                setImage("Block.bmp");
                break;
        }

        GFX = gfx;
    }
}
