 /***************************************************************/
 /* Program Name: Lab 5 										*/
 /* 															*/
 /* Student Name: (Alfredo Perez) 							*/
 /* Semester: (Fall 2018) 									*/
 /* Class-Section: CoSc10403-(045)						    */
 /* Instructor: (Sanchez) 									*/
 /* 															*/
 /* Program Overview: 										*/
 /* This program creates a  Java applet with buttons,		*/
 /*  JLabels, JTextAreas, JCheckBoxes, and others displayed using GridLayout and FlowLayout,
  * the program accepts input and creates a pop up frame to display the results.					*/
 /* 															*/
 /* Input:													 */
 /*  Sandwich type, drink, sides, size and if sandwich is grilled or not 					  */
 /* Output: 													  */
 /* A pop up frame displaying a GUI, with the selected information displayed as well as an image of your food. 	  */
 /* Program Limitations:										  */
 /* This lab doesn't include sounds yet. 				 				  */
 /* Significant Program Variables:Labels, Buttons, JTextAreas, JTextFields,  */
 /*  JCheckBox, JList, GridLayout, FlowLayout, pop up frames	                                                         */
 /*    						                                    */
 /*                                                             */
 /* ************************************************************/




import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.applet.AudioClip;  // needed for the audio clip
import java.io.File;


public class Lab5 extends Lab3 implements ActionListener {

	JPanel pDisplay;  
    JTextArea textDisplay; // Top Text Area where order info goes
    JTextField textDisplay1; // TextField where price goes
    JFrame popUpFrame;   // new JFrame that pops up
    
    
    
	public Lab5()
    { System.out.println(" @ Method constructor in Control");
      //add listeners
		plabel2.addActionListener(this);
		plabel3.addActionListener(this); 
	  setTitle("Alfredo's Sandwich Shop");
	  setVisible(true);
	  
		
	  
    }
	// main method
    public static void main(String args[])
		  { new Lab5(); }	 
		  
    public void actionPerformed(ActionEvent e)
	{
    	//dictates what event to happend depending on which button is pressed
		System.out.println(" @ Method action Performed");
		Object whichButton = e.getSource();
		if (whichButton == plabel3)
			createFrame();
		else
			if (whichButton == plabel2) 
						clearMessage();
		 validate();
		
	}
    // creates frame where displayMessage is produced
	 public void createFrame()
    {  System.out.println(" @ Method create Frame");
       String sandwiches,drinks, sides, size, grilledString; // local variables
       boolean isGrilled;// local boolean 
       String isPrice;
       popUpFrame = new JFrame("Extra Frame");
       popUpFrame.setSize(400,400);
       popUpFrame.setBounds(150,150, 375,250);
       displayMessage();
       popUpFrame.add(pDisplay);
       popUpFrame.setVisible(true);
    }
	public void displayMessage()
    {  // method that gathers information
		System.out.println(" At Method display Message");
        String sandwiches,drinks, sides, size, grilledString, priceString = null; // local variables
        boolean isGrilled; // local boolean 
        Object isPrice; // local object
        pDisplay = new JPanel(new BorderLayout()); //layout for Display Panel
        //attaches selected values to a variable
        sandwiches = (String) myList.getSelectedValue();
        drinks = (String) myList1.getSelectedValue();
        sides = (String) myList2.getSelectedValue();
        size = (String) myChoice.getSelectedItem();
        isGrilled =  check3.isSelected();
        if(isGrilled)  
        		grilledString = " Grilled";
			else 
				{ 
					grilledString = " not Grilled "; 
					 
				}
        isPrice = myChoice.getSelectedItem();
        if(isPrice == "Small")
        	priceString = " $ 5. 50 ";
        else if(isPrice == "Medium")
        	priceString = " $ 7. 00 ";
        else if(isPrice == "Large")
        	priceString = " $ 8. 50 ";
        else if(isPrice == "X-Large")
        	priceString = " $ 9. 50 ";
        //adding complete.gif image
        Image img4;
		 img4 = Toolkit.getDefaultToolkit().getImage("images/complete.gif");
		 ImageIcon ic4;
		 ic4 = new ImageIcon(img4);
		 JLabel plabel4;
		 plabel4 = new JLabel(ic4);
		 //Display areas for the JPanel and fixing how it looks
        textDisplay = new JTextArea ("You ordered: a " + sandwiches + ", " + drinks + ", and " + sides + "\r\n" + "Your sandwich is" + grilledString);
        textDisplay1 = new JTextField("Your total is: " + priceString );
        textDisplay.setFont(myFont1);
        textDisplay.setBackground(Color.LIGHT_GRAY);
        textDisplay1.setBackground(Color.LIGHT_GRAY);
        pDisplay.add(textDisplay, BorderLayout.NORTH);
        pDisplay.add(plabel4, BorderLayout.CENTER);
        pDisplay.add(textDisplay1, BorderLayout.SOUTH);
        pDisplay.setBackground(Color.RED);
        pDisplay.setForeground(Color.RED);
}
	public void clearMessage()
	//clears selections and closes panels
	{   System.out.println(" At Method clear Message");
		myChoice.setSelectedIndex(0);
		myList.setSelectedIndex(0);
		myList1.setSelectedIndex(0);
		myList2.setSelectedIndex(0);
		check3.setSelected(false);
		if(popUpFrame!=null) popUpFrame.dispose();   // dispose panel
		repaint();	   
	} 
}