import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Play extends Actor
{
    public Play()
    {   GreenfootImage img = getImage(); 
        img.scale(180, 80); 
        setImage(img);
    }
    public void act(){
    if(Greenfoot.mousePressed(this)) {
        getImage().scale((int)Math.round(getImage().getWidth()*0.8),
        (int)Math.round(getImage().getHeight()*0.8));
    }
    if (Greenfoot.mouseClicked(this)){
        Greenfoot.delay(2);
        Greenfoot.setWorld(new JumpNRun());
        }
    }
}
