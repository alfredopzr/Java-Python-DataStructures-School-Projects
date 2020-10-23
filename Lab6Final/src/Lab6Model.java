import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class Lab6Model {
	
	Lab6Control c;
	public Lab6Model(Lab6Control fromC)
	{
		c = fromC;
	}


 public void sSand (int opt)
{ 
	boolean a = c.check2.isSelected();
	if(c.check1.isSelected()) c.soundB.play();
	switch(opt)
	{
	case 0:
		System.out.println("Select Sandwich");break;
	case 1:
		System.out.println("Hamburger");
		c.sdsIC = c.getExtraImagesApp(1, 1, a);
	//	c.createFrame();
		break;
	case 2:
		System.out.println("CheeseBurger");
		c.sdsIC = c.getExtraImagesApp(1,2, a);
	//	c.createFrame();
		break;
	case 3:
		System.out.println("Vegetable");
		c.sdsIC = c.getExtraImagesApp(1,3, a);
	//	c.createFrame();
		break;
	case 4:
		System.out.println("Ham And Cheese");
		c.sdsIC = c.getExtraImagesApp(1,4, a);
	//	c.createFrame();
		break;
	}
	c.createFrame();
}
public void sDrink (int opt)
{ 
	boolean a = c.check2.isSelected();
	if(c.check1.isSelected()) c.soundB.play();
	switch(opt)
	{
	case 0:
		System.out.println("Select Side");break;
	case 1:
		System.out.println("Cola");
		c.sdsIC = c.getExtraImagesApp(2,1, a);
	//	c.createFrame();
		break;
	case 2:
		System.out.println("Iced Tea");
		c.sdsIC = c.getExtraImagesApp(2,2, a);
	//	c.createFrame();
		break;
	case 3:
		System.out.println("Coffee");
		c.sdsIC = c.getExtraImagesApp(2,3, a);
	//	c.createFrame();
		break;
	case 4:
		System.out.println("Water");
		c.sdsIC = c.getExtraImagesApp(2,4, a);
	//	c.createFrame();
		break;
	}
	c.createFrame();
}
public void sSide (int opt)
{ 
	boolean a = c.check2.isSelected();
	if(c.check1.isSelected()) c.soundB.play();
	switch(opt)
	{
	case 0:
		System.out.println("Select Sandwich");break;
	case 1:
		System.out.println("Fries");
		c.sdsIC = c.getExtraImagesApp(3, 1, a);
	//	c.createFrame();
		break;
	case 2:
		System.out.println("Chips");
		c.sdsIC = c.getExtraImagesApp(3,2, a);
	//	c.createFrame();
		break;
	case 3:
		System.out.println("Onion Rings");
		c.sdsIC = c.getExtraImagesApp(3,3, a);
	//	c.createFrame();
		break;
	case 4:
		System.out.println("Fried Okra");
		c.sdsIC = c.getExtraImagesApp(3,4, a);
	//	c.createFrame();
		break;
	}
	c.createFrame();
	
}
}

