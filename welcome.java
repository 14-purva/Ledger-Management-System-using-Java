package ledgerm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class welcome extends Frame implements ActionListener{
	JButton b1,b2,b3,b4,b5;
	JLabel l1;
	JPanel p1,p2,p3,p4;
	welcome () {
		setVisible(true);
		setSize(1000,1000);
		setBackground(Color.CYAN);
		l1 = new JLabel("WELCOME TO LEDGER MANAGEMENT");
		 l1.setForeground(Color.RED);  
	     l1.setFont(new Font("Serif", Font.BOLD, 40));  
		b3 = new JButton("TRANSACTION BOOK");
		b1 = new JButton("CLICK for TRANSACTION");
		b2 = new JButton("CLICK TO MANAGE");
		b4 = new JButton("CLICK to Display current balance");
		b5 = new JButton("EXIT");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p2.add(b1); p2.add(b2); 
		p3.add(l1); 
		p2.add(b3); p2.add(b4);
		p2.setBounds(400,500 , 400, 80);
		p4.add(b5);
		add(p3,BorderLayout.NORTH); 
		add(p2,BorderLayout.CENTER);
		add(p4,BorderLayout.SOUTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			add obj = new add();
			
		}
		else if(e.getSource() == b2) {
			delete ong = new delete();
			
		}
		else if(e.getSource() == b3) {
			display onj = new display();
			
		}
		else if(e.getSource() == b4) {
			bal onj = new bal();
			 
		}
		else if(e.getSource() == b5) {
			dispose();
		}
		
	}
	public static void main(String args[]) {
		welcome obj =new welcome();
	}

}
