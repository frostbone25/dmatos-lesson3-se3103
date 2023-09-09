package view;

//import from our codebase
import controller.Application;
import model.NumberGuessGame;

//import from java libraries
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ApplicationCanvas extends JPanel
{
    private static final Font applicationFont = new Font("Courier New", Font.BOLD, 16);
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public ApplicationCanvas()
    {
        Dimension windowDimensions = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(windowDimensions);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        //moved here to reduce redundancy
        graphics2D.setFont(applicationFont);

        switch(Application.numberGuessGame.getState())
        {
            case INITAL:
                drawInitalCanvas(graphics2D);
                break;
            case PLAYING:
                drawPlayingCanvas(graphics2D);
                break;
            case OVER:
                drawOverCanvas(graphics2D);
                break;
        }
    }

    private void drawInitalCanvas(Graphics2D graphics2D)
    {
        String message = "Press <New Game> button to start";
        graphics2D.drawString(message, 50, 150);
    }

    private void drawPlayingCanvas(Graphics2D graphics2D)
    {
        NumberGuessGame numberGuessGame = Application.numberGuessGame;
        String promptString;

        if(numberGuessGame.isShowKeyOn())
        {
            var keyString = String.format("(Key: %d)", numberGuessGame.getKey());
            graphics2D.drawString(keyString, 50, 100);
        }

        if(numberGuessGame.getGuess() >= 0)
        {
            promptString = String.format("Your Guess: %d (Attempts: %d)", numberGuessGame.getGuess(), numberGuessGame.getAttempts());
        }
        else
        {
            promptString = "Enter your guess";
        }

        graphics2D.drawString(promptString, 50, 150);

        if(numberGuessGame.progressMessage != null)
        {
            graphics2D.drawString(numberGuessGame.progressMessage, 100, 200);
        }
    }

    private void drawOverCanvas(Graphics2D graphics2D)
    {
        String message1 = String.format("%d is correct! (Attempts = %d)", Application.numberGuessGame.getKey(), Application.numberGuessGame.getAttempts());
        String message2 = "Press <New Game> to Play Again!";

        graphics2D.drawString(message1, 50, 100);
        graphics2D.drawString(message2, 50, 150);
    }
}
