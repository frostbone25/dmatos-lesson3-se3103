package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        System.exit(0);
    }
}
