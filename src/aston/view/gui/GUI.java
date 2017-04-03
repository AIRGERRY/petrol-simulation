package aston.view.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * Graphical UI
 * 
 * @author Ollie
 * @version 1.0
 * @since 8 Mar 2017
 *
 */

public class GUI {
private JFrame mainFrame;
	
public GUI() {	
	
	final double p = 0.0;
	final double q = 0.0;
	;
	final int numchars = 50;
	
	// Step 1: create the components
	JButton configButton = new JButton(); 
	JButton quitButton = new JButton();
	
	JSlider pslider = new JSlider();
	String pString = "P: ";
	JLabel pLabel = new JLabel (pString + p);
	JSlider qslider = new JSlider();
	String qString = "Q: ";
	JLabel qLabel = new JLabel (qString + q);
	
	JLabel titlePriceOfGallon = new JLabel ("Price of Gallon: ");
	JTextField priceEntry = new JTextField(numchars);
	JLabel titleRunningTime = new JLabel ("Running Time: ");
	JTextField timeEntry = new JTextField (numchars);
	
	JCheckBox checkbox = new JCheckBox("Include Trucks", true);
	JCheckBox checkbox2 = new JCheckBox("Pump 1");
	JCheckBox checkbox3 = new JCheckBox("Pump 2");
	JCheckBox checkbox4 = new JCheckBox("Pump 3");
	JCheckBox checkbox5 = new JCheckBox("Till 1");
	JCheckBox checkbox6 = new JCheckBox("Till 2");
	JCheckBox checkbox7 = new JCheckBox("Till 3");
	
	// Step 2: Set the properties of the components
	configButton.setText("Configure");
	quitButton.setText("Quit");
	priceEntry.setEditable(true);
	timeEntry.setEditable(true);
	qslider.setMajorTickSpacing(1);// dont know how to make the spacing go by using double :(
	pslider.setMajorTickSpacing(1);// ^^
	
	
	}
}


