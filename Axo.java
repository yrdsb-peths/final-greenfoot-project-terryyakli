import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Axo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Axo extends Actor
{
    GreenfootImage[] axoRight = new GreenfootImage[7];
    GreenfootImage[] axoLeft = new GreenfootImage[7];
    SimpleTimer animationTimer = new SimpleTimer();

    String facing = "right";

    /**
     * Act - do whatever the Axo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = 0;
        int y = 0;

        if(Greenfoot.isKeyDown("D")) 
        {
            x+=2;
            facing = "right";
        }
        if(Greenfoot.isKeyDown("A")) 
        {
            x-=2;
            facing = "left";
        }
        setLocation(getX() + x, getY());

        if(Greenfoot.isKeyDown("S")) 
        {
            y+=2;
        }
        if(Greenfoot.isKeyDown("W")) 
        {
            y-=2;
        }
        setLocation(getX(), getY() + y);

        collectPlant();
        heal();
        damage();
        animateAxo();

        
    }
    
    public Axo()
    {
        for(int i = 0; i < axRight.length; i++)
        {
            axoRight[i] = new GreenfootImage("images/ax_idle/ax" + i + ".png");
            axoRight[i].scale(50, 50);
            setImage(axoRight[i]);
        }

        for(int i = 0; i < axLeft.length; i++)
        {
            axLeft[i] = new GreenfootImage("images/ax_idle/ax" + i + ".png");
            axLeft[i].mirrorHorizontally();
            axLeft[i].scale(50, 50);
            setImage(axLeft[i]);
        }

        animationTimer.mark();
    }
    
    int imageIndex = 0;
    public void animateAx()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(axRight[imageIndex]);
            imageIndex = (imageIndex + 1) % axRight.length;
        }
        else
        {
            setImage(axLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % axLeft.length;
        }
    }
    
    /*
     * Collects plants.
     */
    public void collectPlant()
    {
        if(isTouching(Plant.class))
        {
            removeTouching(Plant.class);
            MyWorld world = (MyWorld) getWorld();
            world.createPlant();
            world.increaseScore();
        }
    }
    
    boolean x = false;
    public void damage()
    {
        if(isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            MyWorld world = (MyWorld) getWorld();
            Health Health = world.getPlayerHealthBar();
            if(x == false)
            {
                Health.damage();
                world.createFish();
                x = true;
                if(Health.health <=0)
                {
                    world.gameOver();
                }
            }
        }
        else
        {
            x = false;
        }
    }
    
    boolean y = false;
    public void heal()
    {
        if(isTouching(Heal.class))
        {
            removeTouching(Heal.class);
            MyWorld world = (MyWorld) getWorld();
            Health Health = world.getPlayerHealthBar();
            if(y == false)
            {
                if(Health.health == 5)
                {
                    world.createHeal();
                    return;
                }
                Health.heal();
                world.createHeal();
                y = true;
            }
        }
        else
        {
            y = false;
        }
    }
}