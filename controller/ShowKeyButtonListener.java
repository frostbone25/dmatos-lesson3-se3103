package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import view.ApplicationWindow;

public class ShowKeyButtonListener implements ItemListener
{

    @Override
    public void itemStateChanged(ItemEvent event) 
    {
        JCheckBox option = (JCheckBox)event.getSource();
        boolean checked = option.isSelected();
        Application.game.setShowKeyOn(checked);
        Application.applicationWindow.updateWindow();
        //System.out.println("check box: " + option.isSelected());
    }
    
}