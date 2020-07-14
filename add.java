package ledgerm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;
public class add extends JFrame implements ActionListener {  
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4 ,lb;
	JTextField t1,t2,t3,t4;
	
	
	
	JPanel p2 ;
	add() {
		setVisible(true);
		setSize(500,500);
		setBackground(Color.RED);
		b1 = new JButton("UPDATE LEDGER");
		b2 = new JButton("EXIT");
		b4 = new JButton("UPDATE BALANCE");
		
		l1 = new JLabel("DESCRIBTION ");
		l1.setBounds(100, 100, 200, 100);
		l2 = new JLabel("DEBIT");
		l3 = new JLabel("CREDIT");
		t1 = new JTextField(48);
		t2 = new JTextField(48);
		t3 = new JTextField(48);
		
		p2 = new JPanel();
		p2.add(l1); p2.add(t1); p2.add(l2); p2.add(t2); p2.add(l3); p2.add(t3);
		p2.add(b1); p2.add(b2); p2.add(b4);
		p2.setSize(100,100);
		p2.setBackground(Color.CYAN);
		add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
			
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			int id=Integer.parseInt(t2.getText());
            String ename=t1.getText();
            int esal=Integer.parseInt(t3.getText());
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/purva","root","purva");  //here sonoo is database name, root is username and password  
                Statement stmt=con.createStatement(); 
                 String sql = "insert into ledger1 values ('"+ename+"','"+id+"','"+esal+"')";
                  stmt.executeUpdate(sql);
                  con.close();     
                  System.out.println("Successfully database updated");
            }
            
            catch(Exception e)
            {
            	System.out.println(e);
            }  
			}
			else if(ae.getSource() == b2) {
				dispose();
			}
			else if(ae.getSource() == b4) {
				int n = 0;
	            String ename=t1.getText();
	            int id=Integer.parseInt(t2.getText());
	            int esal=Integer.parseInt(t3.getText()); 
	            try{
	            	  Class.forName("com.mysql.cj.jdbc.Driver");  
	  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/purva","root","purva");   
	  	            PreparedStatement st = con.prepareStatement("select * from bal");   
	  	            ResultSet rs = st.executeQuery();  
	  	            if (rs.next()) {  
	  	                String str =  rs.getString(1);   
	  	              n = Integer.parseInt(str);
		  	            if(id == 0 && esal == 0 ) {
		  	            	System.out.println("database remains same");
		  	            }
		  	            else if(id == 0) {
		  	            	int c = esal + n;
		  	            	 Statement stmt=con.createStatement(); 
		  	                 String sql = " update bal set balance = "+ c; 
		  	                  stmt.executeUpdate(sql);
		  	                JOptionPane.showMessageDialog(null, "balance updated");
		  	                  con.close();     
		  	                  System.out.println("Successfully database updated");
		  	                  
		  	            	
		  	            }
		  	            else if(esal ==0) {
		  	            	int c = n - id;
		  	            	 if(c <= 0 ) {
		  	            		 JOptionPane.showMessageDialog(null, "not enough balance"); 
		  	            	 }
		  	            	 else {
		  	            	 Statement stmt=con.createStatement(); 
		  	                 String sql = " update bal set balance = "+ c; 
		  	                  stmt.executeUpdate(sql);
		  	                  con.close();     
		  	                  System.out.println("Successfully database updated");
		  	            	 }
		  	            }
	  	            }  
	  	           
	  	            con.close();
	            }
	            
	            catch(Exception e)
	            {
	            	System.out.println(e);
	            }  
			}
		
	    }
	
	
	    //Running Constructor  
	    public static void main(String args[]) {  
	        new add();  
	    }  
	}  


