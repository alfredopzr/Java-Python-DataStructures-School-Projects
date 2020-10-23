 /***************************************************************/
 /* Program Name: Lab 3 										*/
 /* 															*/
 /* Student Name: (Alfredo Perez) 							*/
 /* Semester: (Fall 2018) 									*/
 /* Class-Section: CoSc10403-(045)						    */
 /* Instructor: (Sanchez) 									*/
 /* 															*/
 /* Program Overview: 										*/
 /* This program creates a simple Java applet with buttons,		*/
 /*  JLabels, JTextAreas, JCheckBoxes, and others displayed using GridLayout and FlowLayout					*/
 /* 															*/
 /* Input:													 */
 /* There is no user input to this program. 					  */
 /* Output: 													  */
 /* An applet displaying a GUI, with the aforementioned components. 	  */
 /* Program Limitations:										  */
 /* The buttons are inactive, they don't do anything. 				 				  */
 /* Significant Program Variables:Labels, Buttons, JTextAreas, JTextFields,  */
 /*  JCheckBox, JList, GridLayout, FlowLayout	                                                         */
 /*    						                                    */
 /*                                                             */
 /* ************************************************************/




import java.awt.*;
import java.applet.AudioClip;  // needed for the audio clip
import javax.swing.*;
import java.awt.event.*;  // import classes for event handling
import java.io.File;


public class Lab3 extends JFrame
{
	
 Font myFont = new Font("Helvetica",Font.BOLD,28);
Font myFont1 = new Font("Helvetic", Font.BOLD, 12);
 JLabel title = new JLabel("  Schnellwich");
 
 JLabel h1 = new JLabel("Sandwiches");
 JLabel h2 = new JLabel("   Drinks      ");
 JLabel h3 = new JLabel("Side Orders");
 JLabel cancel = new JLabel("      Cancel");
 JLabel order = new JLabel("Place Order");
 JLabel Total = new JLabel( "TOTAL");
 JLabel Empty = new JLabel("      ");
JTextField TFTop;
JTextField TFBottom;
JFrame popUpFrame1;
File myFile;
AudioClip soundA;
AudioClip soundB;
AudioClip soundC;
AudioClip soundD;
 JCheckBox check1 = new JCheckBox("Sounds");
 JCheckBox check2 = new JCheckBox("Animation");
 JCheckBox check3 = new JCheckBox("Grilled");
 JPanel pDisplay; 
JTextArea textDisplay; // Top Text Area where order info goes
JTextField textDisplay1;
 JButton schedule = new JButton("Open from 8 AM till Midnight");


 JTextArea prices = new JTextArea("   Prices \n Small   $5.50 \n Medium $7.00 \n Large   $8.50 \n XLarge   $9.50 \n",2,5);
 	//JTextArea test = new JTextArea (" Test" );
 DefaultListModel list = new DefaultListModel();
 JList myList = new JList(list);
 
 DefaultListModel list1 = new DefaultListModel();
 JList myList1 = new JList(list1);
 
 DefaultListModel list2 = new DefaultListModel();
 JList myList2 = new JList(list2);

 JComboBox myChoice = new JComboBox();

 JButton plabel2;
 JButton plabel3;
 Image sdsImage;
 ImageIcon sdsIC;
 

 public static void main(String args[])
 {
 // Construct the frame
 new Lab3();
 }
 public Lab3() {
	 setLayout(new GridLayout(3,1));
	 setBounds(200,300,600,400);


	 //Image for first picture

	 Image img;
	 img = Toolkit.getDefaultToolkit().getImage("images/sign1.jpg");
	 ImageIcon ic;
	 ic = new ImageIcon( img);
	 JLabel plabel;
	 plabel = new JLabel(ic);
	 //Image for second picture
	 Image img1;
	 img1 = Toolkit.getDefaultToolkit().getImage("images/sign2.jpg");
	 ImageIcon ic1;
	 ic1 = new ImageIcon(img1);
	 JLabel plabel1;
	 plabel1 = new JLabel(ic1);
	 
	 //Image for cancel Gif
	 Image img2;
	 img2 = Toolkit.getDefaultToolkit().getImage("images/cancel.gif");
	 ImageIcon ic2;
	 ic2 = new ImageIcon(img2);
	 //JButton plabel2;
	 plabel2 = new JButton(ic2);
	 plabel2.setBorderPainted(false);
	 
	 //Image for Submit Gif
	 Image img3;
	 img3 = Toolkit.getDefaultToolkit().getImage("images/Submit.gif");
	 ImageIcon ic3;
	 ic3 = new ImageIcon(img3);
	// JButton plabel3;
	 plabel3 = new JButton(ic3);
	 plabel3.setBorderPainted(false);
	 //Image for complete picture
	 Image img4;
	 img4 = Toolkit.getDefaultToolkit().getImage("images/complete.gif");
	 ImageIcon ic4;
	 ic4 = new ImageIcon(img4);
	 JLabel plabel4;
	 plabel4 = new JLabel(ic4);
	 
	
	 //JPANELS
	 JPanel pane;
	 pane = new JPanel();
	 pane.setLayout(new GridLayout(1,3));
	 pane.add(plabel,0);
	 pane.add(title, 1);
	 pane.add(plabel1, 2);
	 
	 JPanel JP1;
	 JP1 = new JPanel();
	 JP1.add(h1);
	 JP1.add(myList);
	 
	 JPanel JP2;
	 JP2 = new JPanel();
	 JP2.add(h2);
	 JP2.add(myList1);

	 
	 JPanel JP3;
	 JP3 = new JPanel();
	 JP3.add(h3);
	 JP3.add(myList2);
	 
	 JPanel JP4;
	 JP4 = new JPanel();
	 JP4.add(myChoice);
	 JP4.add(check1);
	 JP4.add(check2);
	 JP4.add(check3);
	 
	 JPanel JP5;
	 JP5 = new JPanel();
	 JP5.add(prices);
	 
	 
	 JPanel JP6;
	 JP6 = new JPanel();
	 JP6.add(plabel2);
	 JP6.add(cancel);
	 JP6.add(plabel3);
	 JP6.add(order);

	 
	 JPanel JP7;
	 JP7 = new JPanel();
	 JP7.add(Total);
	 JP7.add(Empty);
	 JP7.add(schedule);
			 
	 JPanel grid;
	 grid = new JPanel();
	 grid.setLayout(new GridLayout(1,4));
	 grid.add(JP1);
	 grid.add(JP2);
	 grid.add(JP3);
	 grid.add(JP4);
	 
	 JPanel grid1;
	 grid1 = new JPanel();
	 grid1.setLayout(new GridLayout(1,3));
	 grid1.add(JP5);
	 grid1.add(JP6);
	 grid1.add(JP7);



 // set properties of individual widgets
 title.setForeground(Color.WHITE);
 title.setFont(myFont);
 title.setSize(80,40);


 // add items to List widget
 list.add(0,"Select Sandwich");
 list.add(1,"Hamburger");
 list.add(2,"Cheeseburger");
 list.add(3,"Ham & Cheese");
 list.add(4,"Veggie");

 //Items for myList1
 list1.add(0, "Select Drink");
 list1.add(1, "Cola");
 list1.add(2, "Iced Tea");
 list1.add(3, "Coffee");
 list1.add(4, "Water");
 
 //add items for mylist2
 list2.add(0, "Select Side");
 list2.add(1, "Fries");
 list2.add(2, "Chips");
 list2.add(3, "Onion Rings");
 list2.add(4, "Fried Okra");

 // add items to Choice widget
 myChoice.addItem("Select Size");
 myChoice.addItem("Small");
 myChoice.addItem("Medium");
 myChoice.addItem("Large");
 myChoice.addItem("X-Large");
 
 
 // add widgets to this JFrame (i.e. Lab2ExperimentCode)
 add(pane);
 add(grid);
 add(grid1);


 pane.setBackground(Color.RED);
grid1.setBackground(Color.RED);
 grid.setBackground(Color.RED);
 JP1.setBackground(Color.RED);
JP2.setBackground(Color.RED);
JP3.setBackground(Color.RED);
JP4.setBackground(Color.RED);
JP5.setBackground(Color.RED);
JP6.setBackground(Color.RED);
JP7.setBackground(Color.RED);
 
//JP1, JP2, JP3, JP4, JP5, JP6,JP7
// JP1.setBackground(Color.WHITE);
// pane.setBackground(Color.WHITE);
// pane.setBackground(Color.WHITE);
// pane.setBackground(Color.WHITE);
// pane.setBackground(Color.WHITE);
// pane.setBackground(Color.WHITE);
 
// JP1, JP2, JP3, JP4, JP5, JP6,JP7
 
 
 myList.setBackground(Color.ORANGE);
 myList1.setBackground(Color.GREEN);
 myList2.setBackground(Color.YELLOW);

 setVisible(true);
 
 
 
 }
 public ImageIcon getExtraImagesApp(int t, int opt, boolean a) {
		switch(t) 
		{case 1:switch(opt) 
			{ case 1: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/hamburger.gif");
					else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/hamburger.jpg");break;
			case 2: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/cheeseburger.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/cheeseburger.jpg");break;
			case 3: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/hamandcheese.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/hamandcheese.jpg");break;
			case 4: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/veggie.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sandwich/veggie.jpg");break;
		};break;
		case 2: switch(opt) 
		{ case 1: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/cola.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/cola.jpg");break;
			case 2: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/icetea.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/icetea.jpg");break;
			case 3: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/coffee.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/coffee.jpg");break;
			case 4: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/water.gif");
			else sdsImage = Toolkit.getDefaultToolkit().getImage("images/drinks/water.jpg");break;
		};break;
		case 3: switch(opt)
		{
		case 1: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/fries.gif");
		else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/fries.jpg");break;
		case 2: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/chips.gif");
		else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/chips.jpg");break;
		case 3: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/onionrings.gif");
		else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/onionrings.jpg");break;
		case 4: if(a) sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/friedokra.gif");
		else sdsImage = Toolkit.getDefaultToolkit().getImage("images/sides/friedokra.jpg");break;
		};break;}
		
	return new ImageIcon(sdsImage);}
 {

	 try { 
		 myFile = new File("sounds/jl.wav");
		 soundA = JApplet.newAudioClip(myFile.toURI().toURL());
		 
		 myFile = new File("sounds/select.wav");
		 soundB = JApplet.newAudioClip(myFile.toURI().toURL());
		 
		 myFile = new File("sounds/button.wav");
		 soundC = JApplet.newAudioClip(myFile.toURI().toURL());
		 
		 myFile = new File("sounds/cb.wav");
		 soundD = JApplet.newAudioClip(myFile.toURI().toURL());
	 
	 }
	 catch (Exception e) {}System.out.println("@ get Sounds is now Visible");
 }
 }
 

