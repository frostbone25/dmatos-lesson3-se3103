package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameState;

public class NewGameButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        //System.out.println("New Game Button");

        Application.game.start();
        Application.game.setState(GameState.PLAYING);
        Application.applicationWindow.updateWindow();
    }
}
