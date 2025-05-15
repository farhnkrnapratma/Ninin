import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy  extends Objects
{
    protected double velocity_x = 0;
    
    public Enemy (int i)
    {
        if (i == 7)
        velocity_x = 2;
        else
        if (i == 8)
        velocity_x = 3;
        else
        velocity_x = 2;
    }
    
    public Enemy (){}
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void Collision()
    {
        if (velocity_x > 0)
        {
            Actor Block = getOneObjectAtOffset(10+(int)velocity_x, 0, Block.class);
            Actor empty = getOneObjectAtOffset(10+(int)velocity_x, 11, Block.class);
            Actor Box = getOneObjectAtOffset(10+(int)velocity_x, 0, Box.class);
            
            
            if (Block != null)
            {
                velocity_x = -velocity_x;
            }
            else
            if (Box != null)
            {
                velocity_x = -velocity_x;
            }
            else
            if (empty == null)
            {
                velocity_x = -velocity_x;
            }
            else
            movexy(velocity_x,0);
        }
        else
        if (velocity_x < 0)
        {
            Actor Block = getOneObjectAtOffset(-10+(int)velocity_x, 0, Block.class);
            Actor empty = getOneObjectAtOffset(-10+(int)velocity_x, 11, Block.class);
            Actor Box = getOneObjectAtOffset(-10+(int)velocity_x, 0, Box.class);
            
            if (Block != null)
            {
                velocity_x = -velocity_x;
            }
            else
            if (Box != null)
            {
                velocity_x = -velocity_x;
            }
            else
            if (empty == null)
            {
                velocity_x = -velocity_x;
            }
            else
            movexy(velocity_x,0);
        }
    }
    
    public void act() 
    {
        Collision();
        // Add your action code here.
    }    
}
