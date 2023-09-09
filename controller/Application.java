package controller;

import javax.swing.JFrame;

import model.NumberGuessGame;
import view.ApplicationWindow;

public class Application 
{
    public static final ApplicationWindow applicationWindow = new ApplicationWindow();
    public static final NumberGuessGame game = new NumberGuessGame();

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
