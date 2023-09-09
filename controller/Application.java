package controller;

//import from our codebase
import model.NumberGuessGame;
import view.ApplicationWindow;

//import from java libraries
import javax.swing.JFrame;

//main application class
public class Application 
{
    public static final ApplicationWindow applicationWindow = new ApplicationWindow();
    public static final NumberGuessGame numberGuessGame = new NumberGuessGame();

    public static void main(String[] args)
    {
        applicationWindow.initalize();
        applicationWindow.setTitle("Number Guess Game");
        applicationWindow.setLocation(300, 200);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.pack();
        applicationWindow.setVisible(true);
    }
}
