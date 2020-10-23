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
import java.util.*;
import java.lang.reflect.Array; 



public class Lab2Controller extends Lab2View implements ActionListener {

	String s = instruct.getText();
	StringTokenizer st = new StringTokenizer(s);
	
public Lab2Controller(){
	encode.addActionListener(this);
	decodeBinary.addActionListener(this);
	decodeHex.addActionListener(this);
	}

public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	String whichButton = e.getActionCommand();
	System.out.println("widget selected");
	
		if(whichButton.equals("Encode")||source == encode) {
			System.out.println("Encoding");
			encode();
		}
		if(source==decodeBinary) {
			System.out.println("Decoding Binary");
			decodeB();
		}
		if(source==decodeHex) {
			System.out.println("Decoding Hex");
			decodeH();
		}
	}
public static void main(String[ ] args)
{  new Lab2Controller ();  }

String displayShortAsHex(short x) {
	String ans="";
	for (int i=0; i<4; i++) {
		int hex = x & 15;
		char hexChar = "0123456789ABCDEF".charAt(hex);
		ans = hexChar + ans;
		x = (short)(x >> 4);
	}
	return ans;
}

int convertHexToDecimal(String x) {
	int number=100;
	if (x.equals("0")||x.equals("1")||x.equals("2")||x.equals("3")||x.equals("4")||x.equals("5")||x.equals("6")||x.equals("7")||x.equals("8")||x.equals("9")) {
		number= Integer.parseInt(x);
	}
	else if (x.equals("A")) {
		number= 10;
	}
	else if (x.equals("B")) {
		number= 11;
	}
	else if (x.equals("C")) {
		number=12;
	}
	else if (x.equals("D")) {
		number= 13;
	}
	else if (x.equals("E")) {
		number= 14;
	}
	else if (x.equals("F")) {
		number= 15;
	}
	return number;		
}

//CONVERT A SHORT TO 16 BINARY DIGITS
String displayShortAsBinary(short x) {
	String ans="";
	for(int i=0; i<16; i++) {
		ans = (x & 1) + ans;
		x = (short)(x >> 1);
	}
	return ans;
}

//CONVERT AN INT TO 8 HEX DIGITS
String displayIntAsHex(int x) {
	String ans="";
	for (int i=0; i<8; i++) {
		int hex = x & 15;
		char hexChar = "0123456789ABCDEF".charAt(hex);
		ans = hexChar + ans;
		x = (x >> 4);
	}
	return ans;
}

String displayIntAsBinary(int x) {
	String ans="";
	for(int i=0; i<32; i++) {
		ans = (x & 1) + ans;
		x = (x >> 1);
	}
	return ans;
}


public void encode() { //encode mnemonic to binary/hex
	this.binaryInput.setText("");
    this.hexInput.setText("");
    String assem = this.instruct.getText().trim().toUpperCase();

    StringTokenizer token = new StringTokenizer(assem, " ");
    if (token.countTokens() != 2) {
      this.display.setText("ERROR:  Wrong number of inputs");
      return;
    }
    String opcode = token.nextToken();
    String operands = token.nextToken();

    token = new StringTokenizer(operands, ",", true);
    int inst = 0;

    if (opcode.equals("ADD")) {
      inst = 6656;
      try
      {
        int r = Integer.parseInt(token.nextToken());
        token.nextToken();
        int s = Integer.parseInt(token.nextToken());
      }
      catch (NumberFormatException ce)
      {
        int s;
        this.display.setText("ERROR:  Invalid Number");
        return;
      }
      int s = 0;
      int r = 0;
      inst = inst + (r << 4) + s;
      this.binaryInput.setText(displayShortAsBinary((short)inst));
      this.hexInput.setText(displayShortAsHex((short)inst));
    }
    else
    {
      if (opcode.equals("L")) {
        inst = 1476395008;
      } else if (opcode.equals("A")) {
        inst = 1509949440;
      } else if (opcode.equals("ST")) {
        inst = 1342177280;
      } else {
        this.display.setText("ERROR:  Invalid mnemonic");
        return;
      }

      String r = token.nextToken();
      token.nextToken();
      String dx = token.nextToken();
      token.nextToken();
      String b = token.nextToken();

      token = new StringTokenizer(dx, "(", true);
      String d = token.nextToken();
      token.nextToken();
      String x = token.nextToken();
      try
      {
        int rNum = Integer.parseInt(r);
        int dNum = Integer.parseInt(d);
        int xNum = Integer.parseInt(x);
        int bNum = Integer.parseInt(b.substring(0, b.length() - 1));
      }
      catch (NumberFormatException ce)
      {
        int bNum;
        this.display.setText("ERROR:  Illegal number");
        return;
      }
      int dNum = 0;
      int xNum = 0;
      int bNum = 0;
      int rNum = 0;
      if (((rNum < 0 ? 1 : 0) | (rNum > 15 ? 1 : 0) | (xNum < 0 ? 1 : 0) | (xNum > 15 ? 1 : 0) | (bNum < 0 ? 1 : 0) | (bNum > 15 ? 1 : 0)) != 0) {
        this.display.setText("ERROR:  Invalid register number");
        return;
      }
      if (((dNum < 0 ? 1 : 0) | (dNum > 4095 ? 1 : 0)) != 0) {
        this.display.setText("ERROR:  Invalid displacement value");
        return;
      }
      inst += (rNum << 20);
      inst += dNum;
      inst += (xNum << 16);
      inst += (bNum << 12);
      this.hexInput.setText(displayIntAsHex(inst));
      this.binaryInput.setText(displayIntAsBinary(inst));
    }
  }

void decodeB() { //decode input from binary to hex/decimal
	this.instruct.setText("");
    this.hexInput.setText("");
    int instant = 0;
    String bin = this.binaryInput.getText().trim();
    if ((bin.length() != 32) && (bin.length() != 16)) {
      this.display.setText("ERROR:  Must be 16 or 32 digits");
      return;
    }
    try {
      instant = Integer.parseInt(bin, 2);
    } catch (NumberFormatException ce) {
      this.display.setText("ERROR:  invalid binary number");
      return;
    }
    if ((instant & 0xFFFF0000) != 0)
      this.hexInput.setText(displayIntAsHex(instant));
    else
      this.hexInput.setText(displayShortAsHex((short)instant));
    String assem = decode(instant);
    this.instruct.setText(assem);
}

void decodeH() { //decode input from hex to binary/decimal
	 this.binaryInput.setText("");
	    this.instruct.setText("");
	    int inst = 0;
	    String hex = this.hexInput.getText().trim();
	    if ((hex.length() != 8) && (hex.length() != 4)) {
	      this.display.setText("ERROR:  needs to be 4 or 8 digits");
	      return;
	    }
	    try {
	      inst = Integer.parseInt(hex, 16);
	    } catch (NumberFormatException ce) {
	      this.display.setText("ERROR:  illegal hex number");
	      return;
	    }
	    if ((inst & 0xFFFF0000) != 0)
	      this.binaryInput.setText(displayIntAsBinary(inst));
	    else
	      this.binaryInput.setText(displayShortAsBinary((short)inst));
	    String assem = decode(inst);
	    this.instruct.setText(assem);
	  }

String decode(int inst)
{
  String assem = "";
  if ((inst & 0xFFFF0000) == 0)
  {
    if ((inst & 0xFF00) == 6656) {
      assem = "ADD ";
      assem = assem + ((inst & 0xF0) >>> 4) + ",";
      assem = assem + (inst & 0xF);
    }
  }
  else
  {
    int opcode = inst >> 24;
    if (opcode == 88) {
      assem = "ADD ";
    } else if (opcode == 90) {
      assem = "AND ";
    } else if (opcode == 80) {
      assem = "EOR ";
    } else {
      this.display.setText("ERROR:  op code not existent");
      return "";
    }

    assem = assem + ((inst & 0xF00000) >>> 20) + ",";
    assem = assem + (inst & 0xFFF) + "(";
    assem = assem + ((inst & 0xF0000) >>> 16) + ",";
    assem = assem + ((inst & 0xF000) >>> 12) + ")";
  }
  return assem;
}

}