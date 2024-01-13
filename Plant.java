import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author Theresa  
 * @version January 2024
 */
public class Plant extends Actor
{
    GreenfootImage[] Plant = new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {        
        int x = getX();
        int y = getY();
        setLocation(x, y);
        
        animatePlant();
    }
    
    public Plant() {
        for(int i = 0; i < Plant.length; i++) {
            Plant[i] = new GreenfootImage("images/plant_idle/plant"+ i + ".png");
            Plant[i].scale(45,45);
            setImage(Plant[i]);
        }
        
        animationTimer.mark();
    }
    
    
    int imageIndex = 0;
    public void animatePlant() {
        if(animationTimer.millisElapsed() < 45) {
            return;
        }
        
        animationTimer.mark();
        
        setImage(Plant[imageIndex]);
        imageIndex = (imageIndex + 1) % Plant.length;
    }
}
