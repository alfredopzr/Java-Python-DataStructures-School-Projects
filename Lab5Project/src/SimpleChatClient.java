

/**
 *  This program was taken as an example presented in
 *  Head First JAVA 2 ed  K Sierra and Bert Bates
 *  Many added modifications were done to allow its readability
 *  TCU Fall 2019
 *  Assumes port 5001 for the connections
 *  
 *  Note it uses an inner local class ( i.e. a class within a class)  rather than external class   (  Incoming Reader ) 
 *  modified by Antonio Sanchez
 *  
 */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SimpleChatClient extends JFrame implements WindowListener, ActionListener
{   public final boolean verbose = true;
    int portSocket = 5001;
    JPanel p = new JPanel(new BorderLayout());
    JPanel p1 = new JPanel(new GridLayout(3,2));
    JButton sendButton = new JButton("Send");
    JLabel mL = new JLabel("Message to send ", JLabel.RIGHT);
    JTextArea incoming;
    JScrollPane qScroller;
    JTextField outgoing;
	JTextField from = new JTextField(10);
	JTextField to = new JTextField(10);
	JLabel fromLabel = new JLabel("Your Port: ");
	JLabel toLabel = new JLabel("TO :");
	JCheckBox encrypt = new JCheckBox("Encrypt?");
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    String todayS, timeS, minS, secS;
    Calendar now; int year,month,day,hour,min,sec;
    public static void main(String args[]) {
		System.out.println("Simple Chat Client");
         new SimpleChatClient();
	   
	   }
    public SimpleChatClient() {
       
        setLayout(new FlowLayout());
        add(p);
        int sec = Integer.parseInt(processTime(3));
	    Random rn = new Random(sec);
	    int number =  rn.nextInt((50 - 1) + 1) + 0;
        setTitle("Simple Chat Client " + number); 
        Color c=Color.GRAY;
        if( number%4 == 0  ) c = Color.blue;
         else if(number%4 == 1 ) c = Color.magenta;
           else if( number%4 == 2 ) c = Color.yellow;
             else if( number%4 == 3 ) c = Color.red;
        p.setBackground(c);
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        incoming.setText("Client logged on "+processTime(2) +"\n");
        qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(20);
        p1.add(fromLabel); p1.add(toLabel);
        p1.add(from); p1.add(to);
        p1.add(encrypt);
        p.add(p1, BorderLayout.NORTH);
        p.add(qScroller,BorderLayout.SOUTH);
        p.add(mL,BorderLayout.WEST);
        p.add(outgoing,BorderLayout.CENTER);
        p.add(sendButton,BorderLayout.EAST);
       
        setUpNetworking();
       
        Thread readerThread = new Thread(new IncomingReader());  // thread to read messages
        readerThread.start();
        addWindowListener(this);
        sendButton.addActionListener(this);
        setBounds(400+5*number,8*number,650,400);
        setVisible(true);
        
    }
    
    public String processTime(int option)
	   {    now = Calendar.getInstance();
	        year = now.get(Calendar.YEAR); 
         month = now.get(Calendar.MONTH)+1; 
         day = now.get(Calendar.DAY_OF_MONTH);
         hour = now.get(Calendar.HOUR);
         min =  now.get(Calendar.MINUTE);	  
         sec =  now.get(Calendar.SECOND);
         if (min < 10 )  minS =  "0" + min ;  else  minS = "" + min;
         if (sec < 10 )  secS =  "0" + sec ;  else  secS = "" + sec;
         todayS =  month + " / " + day + " / " + year;  
         timeS  = hour + " : " + minS + " : " + secS; 
         switch(option) {
         case (0):  return todayS  ; 
         case (1):  return timeS;
         case (2):  return todayS + " @ " + timeS ; 
         case (3): return secS;
        } 
        return null;  // should not get here
     }
    
    private void setUpNetworking() {
        try {if (verbose) System.out.println("Openning socket at port 5001");
            sock = new Socket("127.0.0.1", portSocket); //IP Address and port Number (5001)
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking protocol established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ev) {

    	Object wb = ev.getSource();
    	String ww = ev.getActionCommand();
    	String name = from.getText().toUpperCase();
    	String reciever = to.getText().toUpperCase();

    	//System.out.println("widget selected " + ww);
    	
    	

    	if(from != null)
    	{
    		try {
    			String message=  outgoing.getText();
    			if (verbose) System.out.println("Sending coded message => " + message);
    			writer.println("FROM " + name + " TO " + reciever +  " : " + message );
    			writer.flush();	
    		}
    		catch (Exception ex) {
    			ex.printStackTrace();
    		}
    		outgoing.setText("");
    		outgoing.requestFocus();
    	}
    	else
    	{
    		try {
    			String message=  outgoing.getText();
    			if (verbose) System.out.println("Sending coded message => " + message + "\n");
    			writer.println(message);
    			writer.flush();
    		}
    		catch (Exception ex) {
    			ex.printStackTrace();
    		}
    		outgoing.setText("");
    		outgoing.requestFocus();
    	}

    }
   
    /** Internal class to handle the IncomingReader Handler
    The benefit of using an internal class is that we have access to the various objects of the 
    external class
    
    */
    
    class IncomingReader implements Runnable {
    	/**
         * Method RUN to be executed when thread.start() is executed
         */
    	
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                	 if (verbose) System.out.println("Encoded received =>  " + message);
               	 incoming.append(message + "\n");
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

