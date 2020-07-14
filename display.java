package ledgerm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class display extends JFrame implements ActionListener{
	JButton b3,b;
	JLabel l1;
	JPanel p;
	JFrame frame, frame1;
	
	static JTable table;
	
	String driverName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/purva";
	String userName = "root";
	String password = "purva";
	String[] columnNames = {"DESCRIBE", "DEBIT", "CREDIT"};

	display() {
		setVisible(true);
		setSize(500,500);
		setBackground(Color.RED);
		l1 = new JLabel("CLICK TO DISPLAY THE LEDGER");
		b3 = new JButton("SHOW THE VALUES");
		b = new JButton("EXIT");
		p = new JPanel();
		p.add(l1); p.add(b3); p.add(b);
		add(p,BorderLayout.NORTH);
		b3.addActionListener(this);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b3 ) {
		
		System.out.println("Showing Table Data.......");
		showTableData(); 
		}
		else if(ae.getSource() ==b) {
			dispose();
		}
	}
	


public void showTableData()
{

frame1 = new JFrame("Database Search Result");

frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

String des= "";
String debit= "";
String credit = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select * from ledger1";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

while(rs.next()) {


des = rs.getString("des");
debit = rs.getString("debit");
credit = rs.getString("credit");
model.addRow(new Object[]{des, debit, credit});
 
}
}
/*if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}*/
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
}

public static void main(String args[]) {
	display obj = new display();
	
}
}