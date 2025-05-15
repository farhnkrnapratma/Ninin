import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box  extends Objects
{
    /**
     * Change velocity when player touches box
     */
    public void Setvelocity(double v_velx, double v_vely)
    {
        if (v_velx != 0)
        velocity_x = v_velx;
        if (v_vely != 0)
        velocity_y = v_vely;
    }
    /**
     * Control velocity
     */
    public void ControlVelocity()
    {
                
        // Check the velocity
        
        if (velocity_x != 0)
        {
            // We don't move the sprite so we are going to slow it down
            
            // Was he moving left ?
            if (velocity_x < 0)
            velocity_x += 0.5f;
            else
            // was he moving right ?
            if (velocity_x > 0)
            velocity_x -= 0.5f;
            
            // We want to set the velocity in direction x instantly to zero
            // when we're near zero
            if (velocity_x <= 1.1f && velocity_x >= -1.1f)
            velocity_x = 0;
        }
        

       
        if (velocity_y != 0)
        {
            velocity_y += 0.3f;
            if (velocity_y > velocity_fall_MAX)
            velocity_y = velocity_fall_MAX; 
        }
      
    }
    /**
     * Test for collision on one side\nThis is important while the player is pushing the box against a wall.
     * Returns true if somethign is standing on the offset
     */
    public boolean SideIsSolid(int offsetx, int offsety, double _velx)
    {
        Actor Block = getOneObjectAtOffset(offsetx+(int)_velx, offsety, Block.class);
        Actor Block2= getOneObjectAtOffset(offsetx+(int)_velx, -offsety, Block.class);
        Actor Box = getOneObjectAtOffset(offsetx+(int)_velx, offsety, Box.class);
        Actor Box2 = getOneObjectAtOffset(offsetx+(int)_velx, -offsety, Box.class);
        Actor Player = getOneObjectAtOffset(offsetx+(int)_velx, offsety, Player.class);
        Actor Player2 = getOneObjectAtOffset(offsetx+(int)_velx, -offsety, Player.class);
        Actor Enemy = getOneObjectAtOffset(offsetx+(int)_velx, -offsety, Enemy.class);
        Actor Enemy2= getOneObjectAtOffset(offsetx+(int)_velx, offsety, Enemy.class);
        
        return Block != null ||
               Block2 != null ||
               Box != null ||
               Box2 != null ||
               Player != null ||
               Player2 != null ||
               Enemy != null ||
               Enemy2 != null;
        
    }
    /**
     * Test for collision
     */
    public void Collision()
    {
        if (velocity_x > 0)
        {
            Actor Block = getOneObjectAtOffset(10+(int)velocity_x, 9, Block.class);
            Actor Block2= getOneObjectAtOffset(10+(int)velocity_x, -9, Block.class);
            Actor Box = getOneObjectAtOffset(10+(int)velocity_x, 9, Box.class);
            Actor Box2 = getOneObjectAtOffset(10+(int)velocity_x, -9, Box.class);
            Actor Player = getOneObjectAtOffset(10+(int)velocity_x, 9, Player.class);
            Actor Player2 = getOneObjectAtOffset(10+(int)velocity_x, -9, Player.class);
            
            
            if (Block != null)
            {
                velocity_x = 0;
                setLocation(Block.getX() - TILESIZE, getY());
            }
            else
            if (Block2 != null)
            {
                velocity_x = 0;
                setLocation(Block.getX() - TILESIZE, getY());
            }
            else
            if (Box != null)
            {
                velocity_x = 0;
                setLocation(Box.getX() - TILESIZE, getY());
            }
            else
            if (Box2 != null)
            {
                velocity_x = 0;
                setLocation(Box2.getX() - TILESIZE, getY());
            }
            else
            if (Player != null)
            {
                velocity_x = 0;
                setLocation(Player.getX() - TILESIZE, getY());
            }
            else
            if (Player2 != null)
            {
                velocity_x = 0;
                setLocation(Player2.getX() - TILESIZE, getY());
            }
            else
            movexy(velocity_x, 0);
            
        }
        
        if (velocity_y > 0)
        {
            Actor Block = getOneObjectAtOffset(9, 10+(int)velocity_y, Block.class);
            Actor Block2= getOneObjectAtOffset(-9, 10+(int)velocity_y, Block.class);
            
            Actor Box = getOneObjectAtOffset(9, 10+(int)velocity_y, Box.class);
            Actor Box2 = getOneObjectAtOffset(-9, 10+(int)velocity_y, Box.class);
            Actor Player = getOneObjectAtOffset(9, 10+(int)velocity_y, Player.class);
            Actor Player2 = getOneObjectAtOffset(-9, 10+(int)velocity_y, Player.class);
            
            
            if (Block != null)
            {
                velocity_y = 0;
                setLocation(getX(), Block.getY() - TILESIZE);
            }
            else
            if (Block2 != null)
            {
                velocity_y = 0;
                setLocation(getX(), Block2.getY() - TILESIZE);
            }
            else
            if (Box != null)
            {
                velocity_y = 0;
                setLocation(getX(), Box.getY() - TILESIZE);
            }
            else
            if (Box2 != null)
            {
                velocity_y = 0;
                setLocation(getX(), Box2.getY() - TILESIZE);
            }
            else
            if (Player != null)
            {
                velocity_y = 0;
                setLocation(getX(), Player.getY() - TILESIZE);
            }
            else
            if (Player2 != null)
            {
                velocity_y = 0;
                setLocation(getX(), Player2.getY() - TILESIZE);
            }
            else
            movexy(0, velocity_y);
        }
        else
        if (velocity_y == 0)
        {
            Actor Block = getOneObjectAtOffset(8, 10, Block.class);
            Actor Block2= getOneObjectAtOffset(-8, 10, Block.class);
            
            
            
            Actor Box = getOneObjectAtOffset(8, 10, Box.class);
            Actor Box2 = getOneObjectAtOffset(-8, 10, Box.class);
            
            Actor Player = getOneObjectAtOffset(8, 10, Player.class);
            Actor Player2 = getOneObjectAtOffset(-8, 10, Player.class);
            
            if (Block           == null && 
                Block2          == null &&
                Box             == null && 
                Box2            == null && 
                Player          == null && 
                Player2         == null)
            {
                velocity_y = 0.3f;
            }
        }
    }
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        ControlVelocity();
        // velocity_x = 1;
        Collision();
        
        // System.out.print("velocity x von player : " + velocity_y + "\n");
        
    }
}
