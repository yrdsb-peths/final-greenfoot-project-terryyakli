import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish2 extends Actor
{
    int speed = 1;
    GreenfootImage[] Fish2 = new GreenfootImage[4];
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
    
    public Fish2()
    {
        for(int i = 0; i < Fish2.length; i++)
        {
            Fish2[i] = new GreenfootImage("images/green_fish/gfish" + i + ".png");
            //change ths image ^^^
            Fish2[i].scale(80, 50);
            setImage(Fish2[i]);
        }
        
        animationTimer.mark();
    }
    
    int imageIndex = 0;
    public void animateFish()
    {
        if(animationTimer.millisElapsed() < 250)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(Fish2[imageIndex]);
        imageIndex = (imageIndex + 1) % Fish2.length;
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
