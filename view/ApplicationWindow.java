package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Application;
import controller.ExitButtonListener;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionListener;
import model.PlayStrategy;

public class ApplicationWindow extends JFrame
{
    public static final String highLowAction = "High/Low";
    public static final String closerAwayAction = "Closer/Away";

    private ApplicationCanvas applicationCanvas;

    private JTextField numberField;
    private JRadioButton highLowButton;
    private JRadioButton closerAwayButton;

    private JCheckBox showKeyButton;
    private JButton newGameButton;
    private JButton exitButton;

    public void initalize()
    {
        var contentPane = getContentPane();
        applicationCanvas = new ApplicationCanvas();
        contentPane.add(applicationCanvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        contentPane.add(southPanel, BorderLayout.SOUTH);

        JPanel numberPanel = new JPanel();
        southPanel.add(numberPanel);
        numberPanel.setBorder(new TitledBorder("Your Guess"));
        numberPanel.add(new JLabel("Enter (0 - 100)"));
        numberField = new JTextField(10);
        numberPanel.add(numberField);
        numberField.addActionListener(new NumberEnterListener());

        JPanel strategyPanel = new JPanel();
        strategyPanel.setBorder(new TitledBorder("Select strategy"));
        highLowButton = new JRadioButton(highLowAction, 
            Application.game.getStrategy() == PlayStrategy.HighLow
        );
        closerAwayButton = new JRadioButton(closerAwayAction, 
            Application.game.getStrategy() == PlayStrategy.CloserAway
        );
        strategyPanel.add(highLowButton);
        strategyPanel.add(closerAwayButton);
        southPanel.add(strategyPanel);
        StrategySelectionListener strategySelectionListener = new StrategySelectionListener();
        highLowButton.addActionListener(strategySelectionListener);
        closerAwayButton.addActionListener(strategySelectionListener);

        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(highLowButton);
        strategyGroup.add(closerAwayButton);

        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("show key");
        showKeyButton.addItemListener(new ShowKeyButtonListener());
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameButtonListener());
        exitButton = new JButton("Exit");

        //exitButton.addActionListener(new ExitButtonListener());
        //exitButton.addActionListener( (e) -> {
            //System.exit(0);
        //} );
        exitButton.addActionListener( e -> System.exit(0) );

        actionPanel.add(showKeyButton);
        actionPanel.add(newGameButton);
        actionPanel.add(exitButton);

        updateWindow();
    }

    public void updateWindow()
    {
        switch(Application.game.getState())
        {
            case INIT:
            case OVER:
                newGameButton.setEnabled(true);
                numberField.setEnabled(false);
                highLowButton.setEnabled(true);
                closerAwayButton.setEnabled(true);
                showKeyButton.setEnabled(true);
                break;
            case PLAYING:
                newGameButton.setEnabled(false);
                numberField.setEnabled(true);
                highLowButton.setEnabled(false);
                closerAwayButton.setEnabled(false);
                break;
        }

        applicationCanvas.repaint();
    }
}
