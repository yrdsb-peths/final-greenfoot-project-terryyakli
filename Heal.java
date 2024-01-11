import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heal here.
 * 
 * @author Theresa Li 
 * @version January 2024
 */
public class Heal extends Actor
{
    /**
     * Act - do whatever the Heal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x,y);
    }
}
