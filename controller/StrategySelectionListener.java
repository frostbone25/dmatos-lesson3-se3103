package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.PlayStrategy;
import view.ApplicationWindow;

public class StrategySelectionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {
        //System.out.println(event.getActionCommand());

        String action = event.getActionCommand();
        switch(action)
        {
            case ApplicationWindow.highLowAction:
                Application.game.setStrategy(PlayStrategy.HighLow);
                break;
            case ApplicationWindow.closerAwayAction:
                Application.game.setStrategy(PlayStrategy.CloserAway);
                break;
        }
    }
}