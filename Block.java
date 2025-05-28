import greenfoot.*;

public class Block extends Tile {
  private int GFX = 0;
  private int animationTimer = 0;
  private int currentFrame = 0;
  private static final int ANIMATION_SPEED = 15;

  // [REI] Digoyang Mas Asek Asek Joss
  private static final String[] SPIKE_FRAMES = {
    "Spikes_32.png", "Spikes_32_left.png", "Spikes_32_right.png"
  };

  public Block(int i) {
    GFX = i;
    switch (GFX) {
      case 1:
        setImage("Block.bmp");
        break;
      case 2:
        setImage("BlockGrass.bmp");
        break;
      case 3:
        setImage("Spikes_32.png");
        break;
      default:
        setImage("Block.bmp");
        break;
    }
  }

  public void act() {
    if (GFX == 3) {
      animateSpikes();
    }
  }

  private void animateSpikes() {
    animationTimer++;

    if (animationTimer >= ANIMATION_SPEED) {
      animationTimer = 0;

      currentFrame = (currentFrame + 1) % SPIKE_FRAMES.length;

      setImage(SPIKE_FRAMES[currentFrame]);
    }
  }

  public boolean isDeadly() {
    return GFX == 3;
  }

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
