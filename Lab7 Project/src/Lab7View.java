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
public class Lab7View extends JFrame 
{   
   JTextField dataN = new JTextField(5);
   JButton dataB = new JButton("Submit");
   JLabel dataL = new JLabel("Number of Elements #");
   JTextField[] disFields;
   JTextField[] disFields2;
   JFrame vF1; 
   JFrame vF2;
   JButton rv1B = new JButton("Read 1");
   JButton rv2B = new JButton("Read 2");
   JButton addB = new JButton("Add 2 to 1");
   JButton dotB = new JButton("Scalar");
   JButton matrixB = new JButton("Matrix");
   JButton clearB = new JButton("Reset");
   public Color     TCUColors   = new Color(77,25,121);
   JPanel dataP = new JPanel();
   JPanel data2P = new JPanel();
   JPanel resultP = new JPanel();
   JPanel numPanel; 
   JPanel num2Panel; 
   JTextField remarks = new JTextField(100); 
   JPanel resPanel = new JPanel(new GridLayout(1,5));
   JPanel res2Panel = new JPanel(new GridLayout(1,5));

   int numData;
   boolean verbose = true;
   public DecimalFormat decimal = new DecimalFormat("###,###.##");

public static void main(String args[])
  {
    // Construct the frame
    new Lab7View();
  }
         public Lab7View()
  {   setTitle("Vector Operations");
      remarks.setText(" Feedback to the user ");
      dataL.setFont(new Font("Helvetica",Font.BOLD,18));
      setLayout(new BorderLayout());
      dataP.add(dataL);dataP.add(dataN);dataP.add(dataB);
      dataP.setBackground(TCUColors);
      resPanel.setBackground(TCUColors);
      dataL.setForeground(Color.WHITE);
      remarks.setFont(new Font("Helvetica", Font.BOLD,16));
      remarks.setEditable(false);
      add(dataP, BorderLayout.NORTH);
      add( resPanel, BorderLayout.CENTER);
      add( remarks, BorderLayout.SOUTH);
      setBounds(50,50,550,150);
  setVisible(true); 
  validate();

   }


}