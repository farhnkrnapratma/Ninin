import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The dummy object will go through the whole map to destroy each object
 * in order to craete a new map from screch
 * 
 * @author Dman
 * @version 2010
 */
public class dummy  extends Objects
{
    /**
     * Act - do whatever the dummy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public int _x = 0;
    public int _y = 0;
    

    public void act() 
    {
        if (_x + TILESIZE >= 28 * (TILESIZE))
        {   
            _x = TILESIZE/2;
            _y += TILESIZE;
        }
        else
        _x += TILESIZE;
        
        if (_y + TILESIZE >= 29 * (TILESIZE))
        _y = TILESIZE/2;
        
        
        
        setLocation(_x, _y);
                
        if (canSee(Player.class))
        eat(Player.class);
        else
        if (canSee(Box.class))
        eat(Box.class);
        else
        if (canSee(Block.class))
        eat(Block.class);
        else
        if (canSee(Coin.class))
        eat(Coin.class);
        else
        if (canSee(Enemy.class))
        eat(Enemy.class);
    }    
}
