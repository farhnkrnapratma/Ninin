// SPDX-License-Identifier: MIT
import greenfoot.*;

public abstract class Objects extends Actor {
    protected final int TILESIZE = 20;
    protected float velocity_x = 0;
    protected float velocity_y = 0;
    protected final float velocity_move_MAX = 3.0f;
    protected final float velocity_jump_MAX = 6.0f;
    protected final float velocity_fall_MAX = 8.0f;
    protected boolean changeimage = false;
    protected int Frameskipper = 0;
    protected final int FrameMAX = 8;
    
    protected void movexy(float x, float y) {
        setLocation(getX() + (int)x, getY() + (int)y);
    }
    
    protected boolean isInBounds(int x, int y) {
        return x >= 0 && x < 560 && y >= 0 && y < 560;
    }
    
    protected void clampToScreen() {
        int x = Math.max(0, Math.min(getX(), 560));
        int y = Math.max(0, Math.min(getY(), 560));
        setLocation(x, y);
    }
}
