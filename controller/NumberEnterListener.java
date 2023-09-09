package controller;

//import from our codebase
import model.GameState;
import model.NumberGuessGame;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NumberEnterListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        JTextField numberField = (JTextField)actionEvent.getSource();
        String numberFieldText = numberField.getText();
        int geuss;

        try
        {
            geuss = Integer.parseInt(numberFieldText);

            if(geuss < 0 || geuss > NumberGuessGame.MAX_KEY)
            {
                JOptionPane.showMessageDialog(Application.applicationWindow, "Out of Range: valid range is 0 + " + NumberGuessGame.MAX_KEY);
                return;
            }
        }
        catch(NumberFormatException exception)
        {
            JOptionPane.showMessageDialog(Application.applicationWindow, "Enter Integer Only");
            return;
        }

        Application.numberGuessGame.play(geuss);

        if(geuss == Application.numberGuessGame.getKey())
        {
            Application.numberGuessGame.setState(GameState.OVER);
        }

        numberField.setText("");
        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println(numberField.getText());
    }
}