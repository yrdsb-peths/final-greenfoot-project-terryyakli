import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    int speed = 1;
    GreenfootImage[] Fish = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX() - speed;
        int y = getY();
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        
        if(getX() <= -100)
        {
            world.removeObject(this);
            world.createFish();
        }
        
        animateFish();
    }
    
    public Fish()
    {
        for(int i = 0; i < Fish.length; i++)
        {
            Fish[i] = new GreenfootImage("images/blue_fish/bfish" + i + ".png");
            Fish[i].scale(100, 50);
            setImage(Fish[i]);
        }
        
        animationTimer.mark();
    }
    
    int imageIndex = 0;
    public void animateFish()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(Fish[imageIndex]);
        imageIndex = (imageIndex + 1) % Fish.length;
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
