import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Version here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Version extends Actor
{
    /**
     * Act - do whatever the Version wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Version() {
    GreenfootImage img = getImage();
    img.scale(100, 40);
    setImage(img);
  }
}
