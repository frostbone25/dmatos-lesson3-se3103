package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.GameState;
import model.NumberGuessGame;

public class NumberEnterListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JTextField numberField = (JTextField)event.getSource();
        var str = numberField.getText();
        int geuss;

        try
        {
            geuss = Integer.parseInt(str);

            if(geuss < 0 || geuss > NumberGuessGame.MAX_KEY)
            {
                JOptionPane.showMessageDialog(Application.applicationWindow, 
                "Out of Range: valid range is 0 + " + NumberGuessGame.MAX_KEY);
                return;
            }
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(Application.applicationWindow, "Enter Integer Only");
            return;
        }

        Application.game.play(geuss);

        if(geuss == Application.game.getKey())
        {
            Application.game.setState(GameState.OVER);
        }

        numberField.setText("");
        Application.applicationWindow.updateWindow();

        //System.out.println(numberField.getText());
    }
}