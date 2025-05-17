import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelpMenu extends World {

  /** Constructor for objects of class HelpMenu. */
  public HelpMenu() {
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(560, 560, 1);
    prepare();
  }

  /**
   * Prepare the world for the start of the program. That is: create the initial objects and add
   * them to the world.
   */
  private void prepare() {
    HomeButton homeButton = new HomeButton();
    addObject(homeButton, 283, 261);
    homeButton.setLocation(85, 54);
    homeButton.setLocation(26, 28);
    homeButton.setLocation(33, 28);
    homeButton.setLocation(92, 25);
    homeButton.setLocation(66, 30);
  }
}
