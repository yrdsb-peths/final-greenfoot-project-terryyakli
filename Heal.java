import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heal here.
 * 
 * @author Theresa Li 
 * @version January 2024
 */
public class Heal extends Actor
{
    SimpleTimer animationTimer = new SimpleTimer();
    
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
        animateHealthWorm();
    }
    
    GreenfootImage[] Heal = new GreenfootImage[4];
    
    public Heal() {
        for(int i = 0; i<Heal.length; i++) {
            Heal[i] = new GreenfootImage("images/worm_idle/worm" + i +".png");
            Heal[i].scale(80,50);
            setImage(Heal[i]);
        }
        
        animationTimer.mark();
    }
    
    int imageIndex = 0;
    public void animateHealthWorm() {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(Heal[imageIndex]);
        imageIndex = (imageIndex + 1) % Heal.length;
    }
}
