import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Theresa Li 
 * @version January 2023)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        prepare();
    }
    
    /*
     * When user presses 'space', it will go into the game.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /*
     * TitleScreen labels and information/instructions.
     */
    private void prepare()
    {
        Label titleLabel = new Label("Life as an axolotl", 45);
        addObject(titleLabel, 300, 75);

        Label label2 = new Label ("Press [space] to Start", 40);
        addObject(label2,300,150);

        Label label = new Label ("Use W, A, S, D to Move", 30);
        addObject(label,300,360);

        Label label3 = new Label ("Instructions:", 30);
        addObject(label3, 300, 200);

        Label label4 = new Label ("Play with your plants while avoiding large fish!" , 30);
        addObject(label4, 300, 250);

        Label label5 = new Label ("Eat worms to regain health!", 30);
        addObject(label5, 300, 300);
        Axo axo = new Axo();
        addObject(axo,515,186);
        axo.setLocation(456,223);
        axo.setLocation(537,163);
        removeObject(axo);
    }
}
