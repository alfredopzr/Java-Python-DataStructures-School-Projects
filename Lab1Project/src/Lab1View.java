import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1View extends JFrame

{
	//Components for creating matrices
	JLabel fml1 = new JLabel("First Matrix Row/Col");
	JLabel fml2 = new JLabel("Second Matrix Row/Col");
	JLabel opl = new JLabel("Select an action");
	JTextField m1 = new JTextField(15);
	JTextField m2 = new JTextField(15);
	JTextField m3 = new JTextField(15);
	JTextField m4 = new JTextField(15);
	JButton b1 = new JButton("Create");
	JButton b2 = new JButton("Execute");
	JButton b3 = new JButton("Reset");
	JButton b4 = new JButton("QUIT");
	JComboBox cbb = new JComboBox();
	
	//Components for First Matrix
	JTextField m5 = new JTextField(5);
	JTextField m6 = new JTextField(5);
	JTextField m7 = new JTextField(5);
	JTextField m8 = new JTextField(5);
	JTextField m9 = new JTextField(5);
	JTextField m10 = new JTextField(5);
	JButton b5 = new JButton("Clear");
	JButton b6 = new JButton("Read");
	JButton b6a = new JButton("Read");
	JButton b7 = new JButton("Save");
	JButton b8 = new JButton("Open");
	JLabel f1 = new JLabel("File");
	JTextField m11 = new JTextField(5);
	
	//Components for Second Matrix
	JTextField m12 = new JTextField(10);
	JTextField m13 = new JTextField(10);
	JTextField m14 = new JTextField(10);
	JTextField m15 = new JTextField(10);
	JTextField m16 = new JTextField(10);
	JTextField m17 = new JTextField(10);
	JButton b9 = new JButton("Clear");
	JButton b10 = new JButton("Read");
	JButton b11 = new JButton("Save");
	JButton b12 = new JButton("Open");
	JLabel f2 = new JLabel("File");
	JTextField m18 = new JTextField(5);
	
	//Components for Results View
	JTextField m19 = new JTextField(5);
	JTextField m20 = new JTextField(5);
	JTextField m21 = new JTextField(5);
	JTextField m22 = new JTextField(5);
	JTextField m23 = new JTextField(5);
	JTextField m24 = new JTextField(5);
	JButton b13 = new JButton("Clear");
	JButton b14 = new JButton("Save");
	JButton b15 = new JButton("Open");
	JLabel f3 = new JLabel("File");
	JTextField m25 = new JTextField(5);
	JTextField result = new JTextField(5);
	
	
	JFrame p9 = new JFrame();
	//Panel for creating matrices
	JPanel p1 = new JPanel(new GridLayout(6,2));
	//Panel for First Matrix
	JPanel p3 = new JPanel(new GridLayout(1,3));
	//Panel for Matrix (Save part)
	JPanel p4 = new JPanel(new GridLayout(1,6));
	//Panel for Second Matrix
	JPanel p5 = new JPanel(new GridLayout(2,3));
	//Panel for Matrix (Save part)
	JPanel p6 = new JPanel(new GridLayout(1,6));
	//Panel for Results 
	JPanel p7 = new JPanel(new GridLayout(3,3));
	//Panel for Results (Save Part)
	JPanel p8 = new JPanel(new GridLayout(1,5));
	
public Lab1View()
{   
	setBounds(500,500,450,450);
	setTitle("Matrix Math Program");
	setLayout(new BorderLayout());
	add(p1,BorderLayout.CENTER);
	
	//Building matrix creation view	 
	p1.add(fml1); p1.add(fml2); p1.add(m1);
	p1.add(m2); p1.add(m3); p1.add(m4);
	p1.add(b1); p1.add(b2); p1.add(b3); p1.add(b4);
	p1.add(opl); p1.add(cbb);
	cbb.addItem("Add");
	cbb.addItem("Subtract");
	cbb.addItem("Multiplication");
	cbb.addItem("Transpose");

	//	Building first Matrix View
//	add(p3, BorderLayout.CENTER);
//	add(p4, BorderLayout.SOUTH);
//	p3.add(m5); p3.add(m6); p3.add(m7); p3.add(m8); p3.add(m9); p3.add(m10);
//	
	p4.add(b5); p4.add(b6); p4.add(f1); p4.add(m11);
	p4.add(b7); p4.add(b8);

//	Building second Matrix View
//	add(p5, BorderLayout.CENTER);
//	add(p6, BorderLayout.SOUTH);
//	p5.add(m12); p5.add(m13); p5.add(m14); p5.add(m15); p5.add(m16); p5.add(m17);
	
	p6.add(b9); p6.add(b10); p6.add(f2); p6.add(m18); p6.add(b11); p6.add(b12);

	setVisible(true);
}


 public static void main(String[ ] args)
       {    new Lab1View ();  }	


}

