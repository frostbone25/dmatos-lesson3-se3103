package controller;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        System.exit(0);
    }
}
