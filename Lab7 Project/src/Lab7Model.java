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
import java.applet.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Lab7Model
{ 
Lab7 c;
JFrame sPopupFrame, aPopupFrame;
JPanel sPopupPanel, aPopupPanel;
  public static void main(String args[])
  {
  new Lab7();
  }

   public Lab7Model (Lab7 fromC) 
   {
   c = fromC; 
   }
   public void procOper(int opt1)
   {
   if (opt1==1) {  //if button 1 is selected in procOper, in this case Add 2 to 1, then it runs addition method
   System.out.println("Adding vectors 1 and 2");
   int aLength = c.disFields.length;
            for(int i=0; i<aLength; i++) //iteration of loop

                 {
                if(!c.validateInteger(c.disFields[i]))  break;
                c.data[i] = c.data[i]+c.data2[i];
                c.disFields[i].setText(String.valueOf(c.data[i]));
                 }
            System.out.println("Vectors 1 and 2 Added");
            }
   if (opt1==2) {  //if button 2 is selected in procOper, in this case Scalar, then it runs the scalar method

   System.out.println("Performing Scalar");

   int[] scalarA = new int [c.disFields.length];
   int scalarR = 0;
   int aLength = c.disFields.length;
        for(int a=0; a<aLength; a++) //iteration of loop
        {

        if (!c.validateInteger(c.disFields[a])) break;

        scalarA[a] = c.data[a] * c.data2[a]; //formula for scalar
        scalarR = scalarA[a] + scalarR; //set results in scalarR

        }
//information for new frame that is to be created
        sPopupFrame = new JFrame("Scalar");
    sPopupFrame.setSize(100,100);
    sPopupFrame.setBounds(150,150,125,125);
    sPopupPanel = new JPanel(new GridLayout(1,1));
    JLabel scalarLabel = new JLabel(String.valueOf(scalarR));
    sPopupPanel.add(scalarLabel);
    sPopupFrame.add(sPopupPanel);

    sPopupFrame.setVisible(true);
    c.sBoolean = true;

   System.out.println("Finaled Scalar");

   }


   if (opt1==3) { //if button 3 is selected in procOper, in this case Matrix, then it runs the Matrix method

   System.out.println("Performing Matrix");

   JTextField[][] disFieldsR = new JTextField[c.numData][c.numData];
   int aLength = c.disFields.length;
   JLabel matrixL = new JLabel();
   aPopupPanel = new JPanel(new GridLayout(c.numData,c.numData));
//conditions in Matrix method
  for(int a=0; a<aLength; a++) {
  if (!c.validateInteger(c.disFields[a]))       break;
   for(int b=0; b<aLength; b++) {
   if (!c.validateInteger(c.disFields[b]))      break;
//formula for Matrix + where it is stored
   disFieldsR[a][b] = new JTextField(String.valueOf(c.data[b] * c.data2[a]));
                   aPopupPanel.add(disFieldsR[a][b]);
   }
  }
  //specifications for new frame that is created
       aPopupFrame = new JFrame("Matrix");
    aPopupFrame.setSize(150,150);
    aPopupFrame.setBounds(250,250,300,300);

    aPopupFrame.add(aPopupPanel);
    aPopupFrame.setVisible(true);
    c.aBoolean = true;

   System.out.println("Final Matrix");

   }

   }
   public void procReadV(int opt1)
   {  



   if (opt1==1) //if button 1 in procReadV is selected, in this case Scalar, then it runs the Read 1 Method
   {
            int aLength = c.disFields.length;
            c.data = new int[aLength];
            for(int a=0; a<aLength; a++) 
            {
                if(!c.validateInteger(c.disFields[a]))  break;
                c.data[a] = Integer.parseInt(c.disFields[a].getText());
      //          System.out.println(""+ c.disFields[a]);
            }


         }


   if (opt1==2) { //if button 2 in procReadV is selected, then it runs the Read 2 Method


   }
   int aLength = c.disFields2.length;
           c.data2 = new int[aLength];
           for(int i=0; i<aLength; i++) 
           {
                if(!c.validateInteger(c.disFields2[i]))  break;
                c.data2[i] = Integer.parseInt(c.disFields2[i].getText());
           }

   }



}