import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int plant = 0;
    Label plantLabel;
    int speed = 1;
    
    Health playerHealtherBar = new Health();
    
    /**
     * Constructor for objects of class GameMap.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(880, 650, 1, false); 
        prepare();
    }
    
    public void prepare() {
        Axo Axo = new Axo();
        addObject(axo, 100, 250);
        
        plantLabel = new Label(0, 50);
        addObject(plantLabel, 150, 470);
        
        Boundary Boundary = new Boundary();
        addObject(Boundary, 400, 40);
        
        Boundary Boundary2 = new Boundary();
        addObject(Boundary2, 400, 420);
        
        addObject(playerHealthBar, 110, 20);
        
        fishPattern();
        createPlant();
        createHeal();
        stuff();
        
    }
    
    public void stuff() {
        Label health = new Label("HP" , 20);
        addObject(health, 25, 50);
        Label plant = new Label("Plants: ",50);
        addObject(plant, 70, 450);
    }
    
    public void gameOver() {
        EndScreen world = new EndScreen();
        Greenfoot.setWorld(world);
    }
    
    public void createFish() {
        Fish Fish = new Fish();
        Fish.setSpeed(speed);
        int x = randomNumber(1000, 1500);
        int y = randomNumber(50, 410);
        addObject(Fish, x, y);
    }
    
    public void fishPattern()
    {
        for(int i = 0; i <= 4; i++)
        {
            createFish();
        }
    }
    
    public void createPlant()
    {
        Plant Plant = new Plant();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Coin, x, y);
    }
    
    public void increaseScore()
    {
        plant++;
        plantLabel.setValue(plant);
        if(plant % 6 == 0)
        {
            speed++;
        }
    }
    
    public void createHeal()
    {
        Heal Heal = new Heal();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Heal, x, y);
    }
    
    public int randomNumber(int small, int big)
    {
        int result = Greenfoot.getRandomNumber(big - small + 1);
        return result + small;
    }
    
    public Health getPlayerHealthBar()
    {
        return playerHealthBar;
    }
}
