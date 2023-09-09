package controller;

//import from java libraries
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;

public class ShowKeyButtonListener implements ItemListener
{
    @Override
    public void itemStateChanged(ItemEvent itemEvent) 
    {
        JCheckBox option = (JCheckBox)itemEvent.getSource();
        boolean optionChecked = option.isSelected();

        Application.numberGuessGame.setShowKeyOn(optionChecked);
        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println("check box: " + option.isSelected());
    }
}