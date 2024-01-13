import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author Theresa  
 * @version January 2024
 */
public class Health extends Actor
{
    int health = 6;
    int healthBarWidth = 200;
    int healthBarHeight = 13;
    int healthPoint = (int)healthBarWidth/health;
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        work();
    }
    
    /*
     * subtracts health points due to fireball hits
     */
    public void damage()
    {
        health--;
    }
    
    /*
     * adds health points if healhtbottles are used
     */
    public void heal()
    {
        health++;
    }
    
    
    public void work() {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * healthPoint, healthBarHeight);
    }
}
