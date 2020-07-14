package ledgerm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;
public class bal extends JFrame implements ActionListener{
	 JLabel lb, lb1, lb2, lb3, lb4, lb5;  
	    JTextField tf1, tf2, tf3,tf5;  
	    JButton btn; 
	    bal() {
	    	 btn = new JButton("VIEW");  
	         btn.setBounds(70, 80, 100, 20);  
	         btn.addActionListener(this);  
	         lb = new JLabel("YOUR CURRENT BALANCE");  
	         lb.setBounds(50, 50, 450, 30);  
	         lb.setForeground(Color.RED);  
	         lb.setFont(new Font("Serif", Font.BOLD, 20));  
	         setVisible(true);   
	         setSize(500, 500);  
	         lb1 = new JLabel("BALANCE");  
	         lb1.setBounds(20, 120, 100, 20);  
	         tf1 = new JTextField(50);  
	         tf1.setBounds(130, 120, 200, 20); 
	         setLayout(null);  
	         //Add components to the JFrame  
	         
	        
	         add(lb);  
	         add(btn);  
	         add(lb1);  
	         add(tf1);  
	          
	         //Set TextField Editable False  
	         tf1.setEditable(false);  
	         
	    	
	    }
	    public void actionPerformed(ActionEvent e) {  
	        //Create DataBase Coonection and Fetching Records  
	        try {  
	             
	            Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/purva","root","purva");   
	            PreparedStatement st = con.prepareStatement("select * from bal");  
	           // st.setString(1, str);  
	            //Executing Query  
	            ResultSet rs = st.executeQuery();  
	            if (rs.next()) {  
	                String s = rs.getString(1);  
	                 
	                tf1.setText(s);  
	                 
	            }
	       else {  
	                JOptionPane.showMessageDialog(null, "Name not Found");  
	            }  
	            //Create Exception Handler  
	        } catch (Exception ex) {  
	            System.out.println(ex);  
	        }  
	    }  
	    //Running Constructor  
	    public static void main(String args[]) {  
	        new bal();  
	    }  
}
