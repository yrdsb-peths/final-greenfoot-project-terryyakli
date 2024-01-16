import greenfoot.*;

public class EndScreen extends World
{
    private BackButton backButton; // Declare a BackButton instance

    /**
     * Constructor for objects of class EndScreen.
     */
    public EndScreen()
    {    
        super(880, 650, 1);
        prepare();
    }

    private void prepare()
    {
        // Add the BackButton to the world
        backButton = new BackButton();
        addObject(backButton, getWidth() / 2, getHeight() / 2); // Center the button
    }

    public void act()
    {
        // Check if the BackButton is clicked
        if (Greenfoot.mouseClicked(backButton)) {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
