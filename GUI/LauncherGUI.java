package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class serves to create the launcher gui for the program.
 * It extends JFrame.
 * @author Jackson Murrell
 */
@SuppressWarnings("serial")
public class LauncherGUI extends JFrame implements ActionListener
{
	//A couple constants that are used for sizing things.
	private final short WINDOW_HEIGHT = 225;
	private final short WINDOW_WIDTH = 550;
	private final byte BLANK_SPACE = 25;
	
	//Panels to use for adding in componets.
	JPanel textPanel, buttonPanel, mainPanel;
	
	//Buttons for user input and selection.
	JButton calculator, colorChooser, timer, exit, primeNumberTester, adventure;
	
	//A text label that will be used for giving the user
	//instructions on the program.
	JLabel textLabel;
	
	//A constructor to create the GUI components when an object of this class is created.
	public LauncherGUI()
	{
		//This call's the parent method's (JFrame) setTitle method.
		super("Omni-program");
		
		//These methods set various options for the JFrame.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		
		textPanel = new JPanel();
		buttonPanel = new JPanel();
        mainPanel = new JPanel();
                
		calculator = new JButton("Calculator");
		colorChooser = new JButton("Color Chooser");
		timer = new JButton("Timer");
		primeNumberTester = new JButton("Prime Number Tester");
		adventure = new JButton("Adventure Game");
		exit = new JButton("Exit Launcher");
		
        calculator.addActionListener(this);
        colorChooser.addActionListener(this);
        timer.addActionListener(this);
        exit.addActionListener(this);
        primeNumberTester.addActionListener(this);
        adventure.addActionListener(this);
                
		textLabel = new JLabel("Welcome to the launcher!  Click the button for the mini-program you would like to run.", 0);
		
		textPanel.add(Box.createVerticalStrut(BLANK_SPACE));
		textPanel.add(textLabel);
		
		buttonPanel.add(calculator);
		buttonPanel.add(colorChooser);
		buttonPanel.add(timer);
        buttonPanel.add(primeNumberTester);
        buttonPanel.add(adventure);
        buttonPanel.add(exit);

        mainPanel.setLayout(new GridLayout(2,1));
                
		mainPanel.add(textPanel);
		mainPanel.add(buttonPanel);
		//mainPanel.add(Box.createVerticalStrut(BLANK_SPACE));
		
		add(mainPanel);
                
        //pack();
	}
	//This method is required since ActionListener is implemented.
	//It will be used to process user input.
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == calculator)
		{
			setVisible(false);
			//new CalculatorGUI();
		}
		else if (e.getSource() == colorChooser)
		{
			setVisible(false);
			//new ColorChooserGUI();
		}
		else if(e.getSource() == timer)
		{
			//new TimerGUI();
			
			setVisible(false);
		}
		else if (e.getSource() == primeNumberTester)
		{
			setVisible(false);
			//new PrimeNumberTesterGUI();
		}
		else if (e.getSource() == adventure)
		{
			setVisible(false);
			//new adventure.adventure_GUI.CharacterSetupGUI();
		}
		else if(e.getSource() == exit)
        {
            System.exit(0);
        }
	}
}

