
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab1Controller extends Lab1View implements ActionListener {

	JTextField[][] field;
	JTextField[][] field2;
	JTextField[][] result;
	JPanel p10 = new JPanel();
	int c1;
	int c2;
	int c3;
	int c4;
	int[][] one;
	int[][] two;
	{
		Lab1Model m = new Lab1Model();
		
	}
	
public Lab1Controller(){  
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	b6a.addActionListener(this);
	b9.addActionListener(this);
	b10.addActionListener(this);
	cbb.addActionListener(this); 
	}

	public void actionPerformed(ActionEvent e)
	
	{  
		Object source =  e.getSource(); 
		String whichButton = e.getActionCommand();
	    System.out.println("widget selected ");	
	    
		if(source == b1 )  { //Open Matrices
			createPanel();
			System.out.println("Creating Panels");
		}
		if(source==b2) { 
			if(cbb.getSelectedItem() == "Add") {
				System.out.println("Adding"); //Execute formula
					addition();
				}
				if(cbb.getSelectedItem() == "Subtract") {
					System.out.println("Subtracting"); //Create new Panels
						subtraction();
					}
				if(cbb.getSelectedItem() == "Multiplication") {
					System.out.println("Multiplying"); //Create new Panels
						multiplication();
					}
				if(cbb.getSelectedItem() == "Transpose") {
					System.out.println("Transposing"); //Create new Panels
						transpose();
					}
		}
		if(whichButton.equals("Reset")||source == b3) { // Reset
			System.out.println("Reseting");
			processReset(); 
		}
		if(source==b4) { //Quit
			dispose();
			System.exit(0);
		}
		if(source==b5|| source == b9) { //Clear Matrices
			processReset1();
			processReset2();
		}
		if(source==b6) { //Read
			readInput();
	}
		if(source==b10) { //Read1
			readInput1();
		}
		else {
			System.out.println("Select an action"); 
		}
	}
	private void processReset()
    {  String stringValue = null;  
	    m1.setText(stringValue); // display cleared
	    m2.setText(stringValue); // display cleared  
	    m3.setText(stringValue); // display cleared
	    m4.setText(stringValue); // display cleared
	    f1.setText(stringValue); // display cleared
     }

	
	public void createPanel()
	{
		c1 = Integer.parseInt(m1.getText());
		c2 = Integer.parseInt(m2.getText());
		c3 = Integer.parseInt(m3.getText());
		c4 = Integer.parseInt(m4.getText());
		JFrame matriceFrameX = new JFrame();
		JFrame matriceFrameY = new JFrame();
		
		JPanel matriceX = new JPanel(new GridLayout(c1,c2));
		JPanel matriceY = new JPanel(new GridLayout(c3,c4));
		
		
		matriceFrameX.add(matriceX, BorderLayout.CENTER);
		matriceFrameY.add(matriceY, BorderLayout.CENTER);
		matriceFrameX.add(p4, BorderLayout.SOUTH);
		matriceFrameY.add(p6, BorderLayout.SOUTH);
		
		
		matriceFrameX.setBounds(500,500,450,450);
		matriceFrameY.setBounds(500,500,450,450);
		
		matriceFrameX.setVisible(true);
		matriceFrameY.setVisible(true);
		
		field = new JTextField[c1][c2];
		field2 = new JTextField[c3][c4];
		
		for(int i = 0; i<c1; i++) {
			for(int j = 0; j<c2; j++) {
				field[i][j] = new JTextField();
				matriceX.add(field[i][j]);
			}
		}
		for(int i = 0; i<c3; i++) {
			for(int j = 0; j<c4; j++) {
				field2[i][j] = new JTextField();
				matriceY.add(field2[i][j]);
			}
		}
	}
	
	public void processReset1()
	{
		for(int i = 0; i<c1; i++) {
			for(int j = 0; j<c2; j++) {
				field[i][j] = null;
			}
		}
	}

	public void processReset2()
	{
		for(int i = 0; i<c3; i++) {
			for(int j = 0; j<c4; j++) {
				field2[i][j] = null;
			}
		}
	}

	public void readInput() {
		one = new int[c1][c2];
		System.out.println("X is clicked");
		for (int i=0; i<c1; i++) {
			for(int k=0; k<c2; k++) {
				one[i][k] = Integer.parseInt(field[i][k].getText());
				System.out.println("x matrix val: " + one[i][k]);
			}
		}
	}

	public void readInput1() {
		two = new int[c3][c4];
		System.out.println("Y is clicked");
		for(int i=0; i<c3; i++) {
			for(int k=0; k<c4; k++)
			{
				two[i][k] = Integer.parseInt(field2[i][k].getText());
				System.out.println("y matrix value: " + two[i][k]);
			}
		}
	}

	public void addition() {
		if(c1 == c3 && c2 == c4) {
			JFrame resultFrame = new JFrame();
			p10 = new JPanel(new GridLayout(c1,c4));
			resultFrame.add(p10, BorderLayout.CENTER);
			resultFrame.add(p6, BorderLayout.SOUTH);
			resultFrame.setTitle("Result Matrix");
			result = new JTextField[c1][c4];
			for(int i=0; i<c1; i++) {
				for(int j=0; j<c4;j++) {
					result[i][j] = new JTextField();
					p10.add(result[i][j]);
					result[i][j].setText("" + (one[i][j]+two[i][j]));
				}
			}
			resultFrame.setBounds(500,500,450,450);
			resultFrame.setVisible(true);
		}
	}
	
	public void subtraction() 
	{
		if(c1 == c3 && c2 == c4) 
		{
			JFrame resultFrame = new JFrame();
			p10 = new JPanel(new GridLayout(c1,c4));
			resultFrame.add(p10, BorderLayout.CENTER);
			resultFrame.add(p6, BorderLayout.SOUTH);
			resultFrame.setTitle("Result Matrix");
			result = new JTextField[c1][c4];
			
			for(int i=0; i<c1; i++)
			{
				for(int j=0; j<c2;j++)
				{
					result[i][j] = new JTextField();
					p10.add(result[i][j]);
					result[i][j].setText("" + (two[i][j]-one[i][j]));
				}
			}
			resultFrame.setBounds(500,500,450,450);
			resultFrame.setVisible(true);
			
		}
	}
	
	public void multiplication() {
		if(c2 == c3) {
			JFrame resultFrame = new JFrame();
			p10 = new JPanel(new GridLayout(c1,c4));
			resultFrame.add(p10, BorderLayout.CENTER);
			resultFrame.add(p6, BorderLayout.SOUTH);
			resultFrame.setTitle("Result Matrix");
			result = new JTextField[c1][c4];
			
			for(int i=0;i<c1; i++) {
				for(int j=0; j<c4; j++) {
					result[i][j]= new JTextField();
					p10.add(result[i][j]);
					int sum = 0;
					for(int k=0; k<c2; k++) {
						sum = sum + (one[i][k]*two[k][j]);
						result[i][j].setText(""+sum);
					}
				}
			}
			resultFrame.setBounds(500,500,450,450);
			resultFrame.setVisible(true);
		}
	}
	
	public void transpose() {
		JFrame resultFrame = new JFrame();
		p10 = new JPanel(new GridLayout(c1,c4));
		resultFrame.add(p10, BorderLayout.CENTER);
		resultFrame.add(p6, BorderLayout.SOUTH);
		resultFrame.setTitle("Result Matrix");
		result = new JTextField[c1][c4];
		
		for(int i=0; i<c1;i++) {
			for(int j=0; j<c2; j++) {
				result[i][j] = new JTextField();
				p10.add(result[i][j]);
				result[i][j].setText(""+ one[j][i]);
			}
		}
		resultFrame.setBounds(500,500,450,450);
		resultFrame.setVisible(true);
	}
	public static void main(String[ ] args)
    {  new Lab1Controller ();  }	

}