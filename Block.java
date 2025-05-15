import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block  extends Tile
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int GFX = 0;
    public Block(int i)
    {
        GFX = i;
        switch (GFX)
        {
            case 1 :
             setImage("Block.bmp");
            break;
            case 2 :
             setImage("BlockGrass.bmp");
            break;
            case 3 :
             setImage("Spikes_32.png");
            break;
            default :
             setImage("Block.bmp");
            break;
        }
    }
    public void act() 
    {
        // Add your action code here.
    }
    public boolean isDeadly() 
    {
        return GFX == 3;
    }
    
    public void Setgfx(int gfx)
    {
        switch (gfx)
        {
            case 1 :
             setImage("Block.bmp");
            break;
            case 2 :
             setImage("BlockGrass.bmp");
            break;
            case 3 :
             setImage("Spikes_32.png");
            break;
            default :
             setImage("Block.bmp");
            break;
        }
        
        GFX = gfx;
    }
}
