 /***************************************************************/
 /* Program Name: Lab 6 										*/
 /* 															*/
 /* Student Name: (Alfredo Perez) 							*/
 /* Semester: (Fall 2018) 									*/
 /* Class-Section: CoSc10403-(045)						    */
 /* Instructor: (Sanchez) 									*/
 /* 															*/
 /* Program Overview: 										*/
 /* This program creates a simple Java applet with buttons,		*/
 /*  JLabels, JTextAreas, JCheckBoxes, and others displayed using GridLayout and FlowLayout
  * Sounds and ACtionListeners					*/
 /* 															*/
 /* Input:													 */
 /* The user inputs their selection of sandwich sides and drink. 					  */
 /* Output: 													  */
 /* An applet displaying a GUI, with the aforementioned components.
  * A JFrame is created with your selection and an image 	  */
 /* Program Limitations:										  */
 /* The buttons are inactive, they don't do anything. 				 				  */
 /* Significant Program Variables:Labels, Buttons, JTextAreas, JTextFields,  */
 /*  JCheckBox, JList, GridLayout, FlowLayout	                                                         */
 /*    						                                    */
 /*                                                             */
 /* ************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//Need to add rest of imports


public class Lab6Control extends Lab3 implements ActionListener, ListSelectionListener, ItemListener
{
public Lab6Model m = new Lab6Model(this);
public static void main(String args[])
{
	new Lab6Control();
}
public Lab6Control() {
	myList.addListSelectionListener(this);
	myList1.addListSelectionListener(this);
	myList2.addListSelectionListener(this);
	myChoice.addItemListener(this);
	check1.addItemListener(this);
	check2.addItemListener(this);
	check3.addItemListener(this);
	plabel2.addActionListener(this);
	plabel3.addActionListener(this);
	String isPrice;
	JFrame popUpFrame1;
	
	
}
public void actionPerformed(ActionEvent e)
{
	System.out.println(" @ Method Action Performed");
	Object whichButton = e.getSource();
	if (whichButton == plabel3)
			createFrame();
	else
		if (whichButton == plabel2)
				clearMessage();
	validate();
}
public void createFrame() {
	System.out.println(" @ Method Create Frame");
	popUpFrame1 = new JFrame("Order is on its way");
	popUpFrame1.setSize(200,200);
	popUpFrame1.setBounds(150,150,500,500);
	displayMessage();
	popUpFrame1.add(pDisplay);
	popUpFrame1.setVisible(true);
//	if( popUpFrame1 != null) popUpFrame1.dispose();

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
	 ImageIcon sdsImage = null;
	 JLabel plabel10;
	 plabel10 = new JLabel(sdsIC);

	 
	 //Display areas for the JPanel and fixing how it looks
    textDisplay = new JTextArea ("You ordered: a " + sandwiches + ", " + drinks + ", and " + sides + "\r\n" + "Your sandwich is" + grilledString);
    textDisplay1 = new JTextField("Your total is: " + priceString );
    textDisplay.setFont(myFont1);
    textDisplay.setBackground(Color.LIGHT_GRAY);
    textDisplay1.setBackground(Color.LIGHT_GRAY);
    pDisplay.add(textDisplay, BorderLayout.NORTH);
    pDisplay.add(plabel10, BorderLayout.CENTER);
    pDisplay.add(textDisplay1, BorderLayout.SOUTH);
    pDisplay.setBackground(Color.RED);
    pDisplay.setForeground(Color.RED);
}

public void itemStateChanged(ItemEvent e)
{
	if( e.getSource() == check1 )
		if (check1.isSelected()) soundB.play();
		else	System.out.println("The Sound is Off.");
	if( e.getSource() == myChoice) {if(check1.isSelected()) soundB.play();}
	if(check1.isSelected()) soundB.play();
		if(check2.isSelected()) System.out.println("Animation Selected");
			else System.out.println("Animation is off");
 if(check3.isSelected()) System.out.println("grilled Selected");
 else System.out.println( "Grilled is not selected");
}

public void valueChanged(ListSelectionEvent e) {
	JList src = (JList)e.getSource();
	int opt = src.getSelectedIndex();
	if (!src.getValueIsAdjusting())
	{if(src == myList) m.sSand(opt);
	 if(src == myList1) m.sDrink(opt);
	 if(src == myList2) m.sSide(opt);
	 
	}
	
}
public void clearMessage()
//clears selections and closes panels
{   System.out.println(" At Method clear Message");
	myChoice.setSelectedIndex(0);
	myList.setSelectedIndex(0);
	myList1.setSelectedIndex(0);
	myList2.setSelectedIndex(0);
	check1.setSelected(false);
	check2.setSelected(false);
	check3.setSelected(false);
	if(popUpFrame1 != null) 
		popUpFrame1.dispose();// dispose panel
	popUpFrame1.repaint();
}
}




