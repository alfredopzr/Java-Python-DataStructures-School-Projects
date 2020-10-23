  /***************************************************************/ 
  /*   Program Name:     Lab 7                                    */ 
  /*                                                             */ 
  /*   Student Name:     (Alfredo Perez)                     */ 
  /*   Semester:         (Fall 2018)                  */ 
  /*   Class-Section:    CoSc10403-(045) */ 
  /*   Instructor:       (Sanchez)               */ 
  /*                                                             */ 
  /*   Program Overview: This program uses a MVC Model in order to read and store inputed data,
   * with the inputed data there are 3 operations that can be done, Addition, scalar
   * and Matrix. Each displaying the information either on already created panels,
   * or on new ones. A reset button is also active which clears all of the information                              */ 
  /*                             			         */ 
  /*                                                             */ 
  /*   Input: The two inputs are the amount of elements, and the values used in the operations
   * As well as the selection of the buttons                                                    */ 
  

  /*   Output: Results for the 3 operations - Addition, Scalar and Matrix in their respective forms, either in panels
   * or in already created TextFields                                               */ 
  

  /*   Program Limitations: Basic GUI, but a good foundation to build more complex programs using arrays and collections                                     */ 
  /*                                  */ 
  /*                                                             */ 
  /*   Significant Program Variables:  Arrays as Collections, Add 2 to 1, Scalar operation, Matrix operation, use of loops
   * use of MVC Model                       */ 
  /*                            */ 
  /*                                                             */
  /***************************************************************/  


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.*;
public class Lab7 extends Lab7View implements ActionListener
	{  Lab7Model m; 
	   JFrame vF3 = new JFrame();
	   int[]   data;  
		int[]   data2; 
	   boolean aBoolean = false;
	   boolean sBoolean = false;
	 public static void main(String args[])
		  {
		    // Construct the frame
		    new Lab7();
		  }
         public Lab7()
		  {   m = new Lab7Model(this);
			  setButtons();
		   }
         
         public void setButtons() {
        	dataB.addActionListener(this); // register
		    dataN.requestFocus();
		    rv1B.addActionListener(this);  // Register the button
      	    rv2B.addActionListener(this);  // Register the button
      	    addB.addActionListener(this);  // Register the button
      	    dotB.addActionListener(this);  // Register the button
      	    matrixB.addActionListener(this);  // Register the button
      	    clearB.addActionListener(this);  // Register the button
         }
		  
		   public void actionPerformed(ActionEvent e)
		   {  String whichWidget = e.getActionCommand();
		      System.out.println("calling action perform " + whichWidget );
		     
		      if (whichWidget.equals("Submit") )  addPanel();
		      if (whichWidget.equals("Read 1") )  m.procReadV(1);
		      if (whichWidget.equals("Read 2") )  m.procReadV(2);
		      if (whichWidget.equals("Add 2 to 1") )  m.procOper(1);
		      if (whichWidget.equals("Scalar") )  m.procOper(2);
		      if (whichWidget.equals("Matrix") )  m.procOper(3);
		      if (whichWidget.equals("Reset") )   procReset();
		      validate();
		      repaint();
		   }
		   public void addPanel()
		   {  
		      if(validateInteger(dataN))
		           {   
		    	           remarks.setText("");
		    	           numData = Integer.parseInt( dataN.getText());
		               int dataR = (int)  numData;
		               vF1 = new JFrame("Vector 1");
		        	       vF2 = new JFrame("Vector 2");
		        	       numPanel = new JPanel(new GridLayout(1,dataR,2,2));
		        		   num2Panel = new JPanel(new GridLayout(1,dataR,2,2));
		               disFields = new JTextField[ numData];
		               disFields2 = new JTextField[ numData];

		               
		               numPanel.setBackground(TCUColors);
		               num2Panel.setBackground(TCUColors);
		               resPanel.setBackground(TCUColors);
		               vF1.add( numPanel);
		               vF2.add( num2Panel);
		               add( resPanel, BorderLayout.CENTER);
		               System.out.println(dataR +  " " + numData);
		               for( int i = 0; i<  numData ; i++ )
		                  {  disFields[i] = new JTextField(10);
		                     disFields2[i] = new JTextField(10);
		                     numPanel.add( disFields[i]);
		                     num2Panel.add( disFields2[i]);
		                  }
		               resPanel.add( rv1B);
		               resPanel.add( rv2B);
		               resPanel.add( addB);
		               resPanel.add( dotB); 
		               resPanel.add( matrixB); 
		               resPanel.add( clearB); 
		               validate();
		               repaint();
		               vF1.setBounds(200,300,400,50);
		               vF2.setBounds(200,450,400,50);
		               vF1.setVisible(true);
		               vF2.setVisible(true);
		            } 
		   }
		 
		   
		   public void procReset()
		   {   vF1.remove(numPanel );
		       vF2.remove(num2Panel  );
		       if(aBoolean == true) {
		    	   
		    	   m.sPopupFrame.remove(m.sPopupPanel);
		    	   if(m.sPopupFrame !=null) m.sPopupFrame.dispose();
		       
		       }
		       if(sBoolean == true) {
		    	   
		    	   m.aPopupFrame.remove(m.aPopupPanel);
		    	   if(m.aPopupFrame !=null) m.aPopupFrame.dispose();
		    	   
		       }
		      
		       remove( resPanel );
		       data = null; 
		       data2 = null;
		       if(vF1!=null) vF1.dispose();
		       if(vF2!=null) vF2.dispose();
		       if(vF3!=null) vF3.dispose();
		       numPanel = new JPanel();
		    } 
		   public boolean validateInteger(JTextField datum)
		   { try
		         {  int  d =  Integer.parseInt(datum.getText());
		            return true;
		         }
		      catch (NumberFormatException e)
		         { System.out.println("invalid Integer " );
		            remarks.setText("Invalid integer retype");
		            return false;
		         }
		   }
   
		   
	}