/*
Name: Alfredo Perez
Date: October 03, 2019
Class: Techniques in Programming
Program Overview: Write a Java application with a 
graphical user interface that allows a user to encode and 
decode the sixteen ARM7 instructions described 
above for sixteen registers. 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab2View extends JFrame {

	//Components
	JTextField instruct = new JTextField(10);
	JTextField binaryInput = new JTextField(10);
	JTextField hexInput = new JTextField(10);
	JTextField display = new JTextField(10);
	
	JButton encode = new JButton("Encode");
	JButton decodeBinary = new JButton("Decode Binary");
	JButton decodeHex = new JButton("Decode Hex");
	
	JLabel label1a = new JLabel("To Assembly ");
	JLabel label1b = new JLabel("Language");
	JLabel label2 = new JLabel("Binary Instruction");
	JLabel label3 = new JLabel("Hex Instruction");

	JPanel p1 = new JPanel(new GridLayout(5,2));
	JPanel p2 = new JPanel(new GridLayout(1,1));
	JPanel p3 = new JPanel(new GridLayout(1,0));
	
	Image pic;
		JLabel picL = new JLabel();
		ImageIcon picIcon; 
	
public Lab2View() {
	setBounds(600, 600, 630, 650);
	setTitle("Encode/Decode Hex & Binary");
	setLayout(new BorderLayout());
	add(p1, BorderLayout.CENTER);
	add(p2, BorderLayout.SOUTH);
	add(p3, BorderLayout.NORTH);
	p2.setPreferredSize(new Dimension(100, 45));
   	pic = Toolkit.getDefaultToolkit().getImage("images/decode.jpg");
	picIcon = new ImageIcon(pic);
	picL.setIcon(picIcon);
	
	label1a.setHorizontalAlignment(JLabel.RIGHT);
	label2.setHorizontalAlignment(JLabel.CENTER);
	label3.setHorizontalAlignment(JLabel.CENTER);
	//Creating Center Panel
	p1.add(instruct); p1.add(encode);
	p1.add(label1a); p1.add(label1b);
	p1.add(binaryInput); p1.add(hexInput);
	p1.add(label2); p1.add(label3);
	p1.add(decodeBinary); p1.add(decodeHex);
	//Creating South Panel
	p2.add(display);
	//Create North Panel
	p3.add(picL);
	
	setVisible(true);
}

public static void main(String[ ] args)
{    new Lab2View ();  }	

}
