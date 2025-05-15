import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms 
 * (very yummy, especially the green ones).
 */
public class Player extends Objects
{
    // von anfang an soll Gravitation auf den Spieler wirken
    private boolean jumplock = true;
    
    private int     jumphigh = 0;
    private final int JumpMAX = 60;
    private boolean freeze = false;
    private int TILE_SIZE = 20;
    
    private JumpNRun m_World;
    
    public Player(JumpNRun m_parent)
    {
        m_World = m_parent;
    }
    
    protected void Die()
    {
        m_World.ReloadLevel();
    }
    /**
     * Freeze the player if the map is finished
     */
    public void Freeze(boolean option)
    {
        
        freeze = option;
    }
    
    private void ColWithEnemy()
    {
        Actor Enemy = getOneObjectAtOffset(10, 0, Enemy.class);
        Actor Enemy2 = getOneObjectAtOffset(-10,0 , Enemy.class);
        Actor Enemy3= getOneObjectAtOffset(10, -9, Enemy.class);
        Actor Enemy4= getOneObjectAtOffset(-10, -9, Enemy.class);
        
        if (Enemy != null || Enemy2 != null || Enemy3 != null || Enemy4 != null)
        {
            Freeze(true);
            Die();
        }
    }
    
    /**
     * Test for collision
     */
    public void Collision()
    {
        
            if (velocity_x > 0)
            {
                Actor Box = getOneObjectAtOffset(10, 0, Box.class);

                if (Box != null)
                {
                    // Convert the actor into an Box-object in order to use our selfmade functions
                    Box box = (Box)Box;
                    
                    // Test if something is behind the box - >
                    // If so -> then the box can't move more to the right
                    // If not-> then the box can be moved untill something solid appears behind it
                    if (!box.SideIsSolid(10, 9,velocity_x) )
                    {
                        Box.setLocation(Box.getX()+(int)velocity_x, Box.getY());

                    }
                    else
                    {
                        setLocation(Box.getX() - TILESIZE,getY());
                        box.Setvelocity(velocity_x, 0);
                        velocity_x = 0;
                    }
                    
                }
                else
                {
                    int X = getX() + 10 + (int)velocity_x;
                    int Y = getY() - 9;
                    int Yend = getY() + 9;
                     boolean free = true;
                    while ( Y <= Yend )
                    {
                        if (m_World.isSolid( X ,Y)) // Konvertierung nicht vergessen !
                        {
                            setLocation(X/TILESIZE * TILESIZE - 10,getY());
                            free = false;
                        }
                        
                        Y += 18;
                    }
                    
                    if (free)
                    movexy(velocity_x, 0);
                    else
                    velocity_x = 0;
                }
                
            }
            else
            if (velocity_x < 0)
            {

                Actor Box = getOneObjectAtOffset(-10, 0, Box.class);
                
                if (Box != null)
                {
                    // Convert the actor into an Box-object in order to use our selfmade functions
                    Box box = (Box)Box;
                    
                    // Test if something is behind the box - >
                    // If so -> then the box can't move more to the right
                    // If not-> then the box can be moved untill something solid appears behind it
                    if (!box.SideIsSolid(-10, 9,velocity_x) )
                    {
                        Box.setLocation(Box.getX()+(int)velocity_x, Box.getY());
                        
                    }
                    else
                    {
                        setLocation(Box.getX() + TILESIZE,getY());
                        box.Setvelocity(velocity_x, 0);
                        velocity_x = 0;
                    }
                }
                else
                {
                    int X = getX() - 10 + (int)velocity_x;
                    int Y = getY() - 9;
                    int Yend = getY() + 9;
                    boolean free = true;
                    while ( Y <= Yend )
                    {
                        if (m_World.isSolid( X ,Y)) // Konvertierung nicht vergessen !
                        {
                            setLocation((X/TILESIZE + 1) * TILESIZE + 10,getY());
                            free = false;
                        }
                        
                        Y += 18;
                    }
                    
                    if (free)
                    movexy(velocity_x, 0);
                    else
                    velocity_x = 0;
                }
                
            }
            

            // Fallend
            if (velocity_y > 0)
            {
                jumphigh = 0; 
                
                Actor Box         = getOneObjectAtOffset(9, 10+(int)velocity_y, Box.class);
                Actor Box2        = getOneObjectAtOffset(-9, 10+(int)velocity_y, Box.class);
                
                if (Box != null)
                {
                    velocity_y = 0;
                    jumplock = false;
                    setLocation(getX(),Box.getY() - TILESIZE);
                }
                else
                if (Box2 != null)
                {
                    velocity_y = 0;
                    jumplock = false;
                    setLocation(getX(),Box2.getY() - TILESIZE);
                }
                else
                {
                    int Y = getY() + 10 + (int)velocity_y;
                    int X = getX() - 9;
                    int Xend = getX() + 9;
                    
                    boolean free = true;

                    if (m_World.onSpike( X , Y ))
                    {
                        Die();
                        return;
                    }
                    
                    while ( X <= Xend )
                    {
                        if (m_World.isSolid( X ,Y)) // Konvertierung nicht vergessen !
                        {
                            
                            setLocation(getX(),(Y/TILESIZE) * TILESIZE - 10);
                            free = false;
                            jumplock = false;
                        }
                        
                        X += 18;
                    }
                    
                    if (free)
                    movexy(0, velocity_y);
                    else
                    velocity_y = 0;
                }
            }
            else
            if (velocity_y < 0)
            {
            
                int Y = getY() - 10 + (int)velocity_y;
                int X = getX() - 9;
                int Xend = getX() + 9;
                    
                boolean free = true;
                    
                while ( X <= Xend )
                {
                    if (m_World.isSolid( X ,Y)) // Konvertierung nicht vergessen !
                    {
                        setLocation(getX(),(Y/TILESIZE + 1) * TILESIZE + 10);
                        free = false;
                        jumplock = true;
                    }
                        
                    X += 18;
                }
                    
                if (free)
                 movexy(0, velocity_y);
                else
                 velocity_y = 0.1;
            }
            else
            // Haben wir Boden ???
            if (velocity_y == 0)
            {
                boolean left  = m_World.isSolid(getX() - 9, getY() + 11);
                boolean right = m_World.isSolid(getX() + 9, getY() + 11);
               
                if (!left && !right)
                 {
                    velocity_y = 0.3f;
                    jumplock = true;
                }
            }
           
    }
    
    /**
     * Check for image change
     */
    public void Changeimage()
    {
        if (velocity_x != 0)
        Frameskipper--;
        else
        return ;
        
        if (Frameskipper == 0)
        {
            if (changeimage)
            {
                Frameskipper = FrameMAX;
                // setImage("crab.png");
                changeimage = false;
            }
            else
            if (!changeimage)
            {
                Frameskipper = FrameMAX;
                // setImage("crab2.png");
                changeimage = true;
                
            }
            
            if (velocity_x == 0)
            {
            // setImage("crab.png");
            }
        }
    }
    
    /**
     * Get Inputs
     */
    public void GetInput()
    {
        boolean move_right = true,
                move_left  = true;
                
        // Tasten einnehmen
        
        if (Greenfoot.isKeyDown("D"))
        {
            if (velocity_x >= 0)
            velocity_x += 0.2f;
            else
            if (velocity_x < 0)
            velocity_x += 0.5f;
            
            // GEschw ist grer als -Move_MAX
            if (velocity_x+0.3f > velocity_move_MAX)
            velocity_x = velocity_move_MAX;
            else
            // GEschw ist kleiner als -Move_MAX
            if (velocity_x > velocity_move_MAX)
            velocity_x -= 0.4f;
            
            
        }
        else
        move_left = false;
        

        if (Greenfoot.isKeyDown("A"))
        {   
            if (velocity_x <= 0)
            velocity_x -= 0.2f;
            else
            if (velocity_x > 0)
            velocity_x -= 0.5f;
            // GEschw ist kleiner als Move_MAX
            if (velocity_x-0.3f < -velocity_move_MAX)
            velocity_x = -velocity_move_MAX;
            else
            // GEschw ist gr��er als Move_MAX
            if (velocity_x < -velocity_move_MAX)
            velocity_x += 0.4f;
            
         
        }
        else
        move_right = false;
        /*
        if (Greenfoot.isKeyDown("w"))
        velocity_y -= 0.3f;
        else
        if (Greenfoot.isKeyDown("s"))
        velocity_y += 0.3f;
        */
        
        if (Greenfoot.isKeyDown("space") && !jumplock)
        {
            if (jumphigh == 0)
            jumphigh = getY() - JumpMAX;
            
            if (getY() <= jumphigh)
            {
               jumphigh = 0; 
               jumplock = true;
            }
            
            velocity_y -= 0.4f;
            if (velocity_y < -velocity_jump_MAX)
            velocity_y = -velocity_jump_MAX;
            
            
        }
        else   
        if (!Greenfoot.isKeyDown("space") && velocity_y < 0 && !jumplock)
        {
            jumplock = true;
        }
        
        if (jumplock)
        {
            velocity_y += 0.3f;
            if (velocity_y > velocity_fall_MAX)
            velocity_y = velocity_fall_MAX;
        }
        
        
        
        
        if (!move_left && !move_right)
        {
            // We don't mvoe the sprites so we are going to slow it down
            
            // Was he moving left ?
            if (velocity_x < 0)
            velocity_x += 0.75f;
            else
            // was he moving right ?
            if (velocity_x > 0)
            velocity_x -= 0.75f;
            
            // We want to set the velocity in direction x instantly to zero
            // when we're near zero
            if (velocity_x <= 1.1f && velocity_x >= -1.1f)
            velocity_x = 0;
        }
        
        // When retry is pressed we reload the map in order to let the
        // Player retry the current map
        if (Greenfoot.isKeyDown("r"))
        Die();
        
        
      
    }

    public void act()
    {
        // getWorld().addObject(new Coin() , 22, 222);
        if (!freeze)
        {
            
        if (canSee(Coin.class)) 
        {
            eat(Coin.class);
        }
        
        // 1. Tasten einnehmen
        GetInput();
        
        // 2. Teste, welches Bild genommen werden soll
        Changeimage();
        
        // 3. Kollission also Position errechnen
        // if (velocity_x != 0 || velocity_y != 0)
        Collision();
        
        ColWithEnemy();
        
        
        }
        

        

    }
}


