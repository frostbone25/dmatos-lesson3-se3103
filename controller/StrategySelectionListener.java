package controller;

//import from our codebase
import model.PlayStrategy;
import view.ApplicationWindow;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrategySelectionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String actionCommand = actionEvent.getActionCommand();

        switch(actionCommand)
        {
            case ApplicationWindow.highLowAction:
                Application.numberGuessGame.setStrategy(PlayStrategy.HighLow);
                break;
            case ApplicationWindow.closerAwayAction:
                Application.numberGuessGame.setStrategy(PlayStrategy.CloserAway);
                break;
        }

        //console debugging
        //System.out.println(event.getActionCommand());
    }
}