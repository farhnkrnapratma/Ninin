import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,292,413);
        play.setLocation(318,399);
        play.setLocation(299,488);
        play.setLocation(314,387);
        play.setLocation(307,407);
        play.setLocation(278,397);
        play.setLocation(319,365);
        play.setLocation(284,371);
        play.setLocation(335,372);
        play.setLocation(276,367);
        Help help = new Help();
        addObject(help,348,395);
        play.setLocation(276,436);
        play.setLocation(420,562);
        play.setLocation(282,360);
        play.setLocation(274,365);
        play.setLocation(278,365);
        help.setLocation(267,425);
        help.setLocation(280,435);
        Info info = new Info();
        addObject(info,329,455);
        help.setLocation(282,504);
        info.setLocation(480,441);
        help.setLocation(266,422);
        help.setLocation(291,451);
        help.setLocation(282,436);
        help.setLocation(280,436);
        info.setLocation(456,397);
        info.setLocation(239,511);
        info.setLocation(282,506);
    }
}
