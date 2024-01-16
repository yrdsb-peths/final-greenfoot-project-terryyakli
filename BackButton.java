import greenfoot.*;  // Import the Greenfoot classes

public class BackButton extends Actor {
    // Constructor
    public BackButton() {
        // Set the initial image and size for the button
        GreenfootImage image = new GreenfootImage("red_button" +".png");
        setImage(image);
    }

    // Act method (called every frame)
    public void act() {
        // Check if the button is clicked
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld()); 
        }
    }
}
