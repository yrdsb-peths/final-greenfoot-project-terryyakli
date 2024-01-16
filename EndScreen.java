//hey
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author Theresa  
 * @version January 2024
 */
public class EndScreen extends World
{
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        super(880, 650, 1);
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void prepare()
    {
        Label gameOverLabel = new Label("Game over", 100);
        addObject(gameOverLabel, 280,455);

        Label label = new Label ("Press [space] to restart", 40);
        addObject(label, 250,535);
    }
}
