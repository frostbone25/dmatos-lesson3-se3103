package view;

import javax.swing.JPanel;

import controller.Application;
import model.NumberGuessGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ApplicationCanvas extends JPanel
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public ApplicationCanvas()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        switch(Application.game.getState())
        {
            case INIT:
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

    private void drawOverCanvas(Graphics2D graphics2D)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        var message1 = String.format("%d is correct! (Attempts = %d)", Application.game.getKey(), Application.game.getAttempts());
        var message2 = "Press <New Game> to Play Again!";
        graphics2D.drawString(message1, 50, 100);
        graphics2D.drawString(message2, 50, 150);
    }

    private void drawPlayingCanvas(Graphics2D graphics2D)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        NumberGuessGame game = Application.game;

        if(game.isShowKeyOn())
        {
            var keyString = String.format("(Key: %d)", game.getKey());
            graphics2D.drawString(keyString, 50, 100);
        }

        String promptString;
        if(game.getGuess() >= 0)
        {
            promptString = String.format("Your Guess: %d (Attempts: %d)", game.getGuess(), game.getAttempts());
        }
        else
        {
            promptString = "Enter your guess";
        }

        graphics2D.drawString(promptString, 50, 150);

        if(game.progressMessage != null)
        {
            graphics2D.drawString(game.progressMessage, 100, 200);
        }
    }

    private void drawInitalCanvas(Graphics2D graphics2D)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        var message = "Press <New Game> button to start";
        graphics2D.drawString(message, 50, 150);
    }
}
