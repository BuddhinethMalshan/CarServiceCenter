package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Cashier {

	private JFrame frame;
	
	private static final String username = "root";
	private static final String password = "";
	private static final String datacon = "jdbc:mysql://localhost/carservice";

	
	
	private JTextField txtcus;
	private JTextField txtempname;
	private DefaultTableModel model , model2,model3,model4,model5;
	private JTable table,table2,table3,table4,table5;
	private Object[] row ;
	private double total1 ;
	private double total2 =0;
	private double total3 =0;
	private double total4 =0;
	private double total =0;
	private double total5 =0;
	
	private String  bill1,bill2,bill3,bill4,bill5;
	private JLabel lblwash ,lblpain,lblwheel,lblbatt ,lblitem,lbltotal,lblmsg ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashier window = new Cashier();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cashier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1083, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1067, 99);
		panel.setBackground(new Color(105, 105, 105));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Service");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(464, 0, 165, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Cashier.class.getResource("/images/Car_logos.png")));
		lblNewLabel_3.setBounds(461, 42, 606, 57);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 99, 616, 155);
		panel_1.setBackground(new Color(102, 205, 170));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 616, 112);
		panel_1.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column)
		      {
		        switch(column)
		        {
		        case 0:
	              return String.class;
		        case 1:
		          return int.class;
		        default:
		        	  return Boolean.class;
		        }
		      }
		    };
		Object[] columns = {"Name" , "Price", "Select"};
 		model.setColumnIdentifiers(columns);
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
	    scrollPane.setViewportView(table);
	    viewTable1();
		
		lblwash = new JLabel("");
		lblwash.setBounds(507, 11, 109, 21);
		panel_1.add(lblwash);
		
		JLabel lblNewLabel_4 = new JLabel("Wash Price Rs :");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(326, 9, 124, 23);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("Vehicle wash");
		lblNewLabel_8.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(10, 11, 177, 21);
		panel_1.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(0, 254, 616, 145);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 47, 616, 98);
		panel_2.add(scrollPane_1);
		
		table2 = new JTable();
		model2 = new DefaultTableModel(){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column)
		      {
		        switch(column)
		        {
		        case 0:
	              return String.class;
		        case 1:
		          return int.class;
		        default:
		        	  return Boolean.class;
		        }
		      }
		    };
		
 		model2.setColumnIdentifiers(columns);
		table2.setAutoCreateRowSorter(true);
		table2.setModel(model2);
		scrollPane_1.setViewportView(table2);
	    viewTable2();
		
		lblpain = new JLabel("");
		lblpain.setBounds(501, 7, 105, 24);
		panel_2.add(lblpain);
		
		JLabel lblNewLabel_4_1 = new JLabel("Painting Price Rs:");
		lblNewLabel_4_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(314, 4, 143, 26);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Painting and wash");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(0, 139, 139));
		lblNewLabel_5.setBounds(10, 7, 182, 24);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(143, 188, 143));
		panel_3.setBounds(0, 398, 616, 133);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 46, 616, 87);
		panel_3.add(scrollPane_2);
		
		table3 = new JTable();
		model3 = new DefaultTableModel(){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column)
		      {
		        switch(column)
		        {
		        case 0:
	              return String.class;
		        case 1:
		          return int.class;
		        default:
		        	  return Boolean.class;
		        }
		      }
		    };
		
 		model3.setColumnIdentifiers(columns);
		table3.setAutoCreateRowSorter(true);
		table3.setModel(model3);
		scrollPane_2.setViewportView(table3);
	    viewTable3();
		
		lblwheel = new JLabel("");
		lblwheel.setBounds(505, 11, 85, 23);
		panel_3.add(lblwheel);
		
		JLabel lblNewLabel_4_2 = new JLabel("Wheel Price Rs :");
		lblNewLabel_4_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(324, 9, 131, 23);
		panel_3.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_6 = new JLabel("Wheel Allignment");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(10, 11, 195, 24);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(72, 209, 204));
		panel_4.setBounds(0, 532, 616, 123);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 49, 616, 74);
		panel_4.add(scrollPane_3);
		
		table4 = new JTable();
		model4 = new DefaultTableModel(){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column)
		      {
		        switch(column)
		        {
		        case 0:
	              return String.class;
		        case 1:
		          return int.class;
		        default:
		        	  return Boolean.class;
		        }
		      }
		    };
		
 		model4.setColumnIdentifiers(columns);
		table4.setAutoCreateRowSorter(true);
		table4.setModel(model4);
		scrollPane_3.setViewportView(table4);
	    viewTable4();
		
		lblbatt = new JLabel("");
		lblbatt.setBounds(502, 7, 104, 23);
		panel_4.add(lblbatt);
		
		JLabel lblNewLabel_4_3 = new JLabel("Battery Price Rs :");
		lblNewLabel_4_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(321, 11, 142, 27);
		panel_4.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_7 = new JLabel("Battery Service (normal)");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(10, 16, 233, 23);
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 139, 139));
		panel_5.setBounds(616, 99, 451, 556);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		txtcus = new JTextField();
		txtcus.setBounds(355, 22, 86, 20);
		panel_5.add(txtcus);
		txtcus.setColumns(10);
		
		txtempname = new JTextField();
		txtempname.setBounds(355, 64, 86, 20);
		panel_5.add(txtempname);
		txtempname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer :");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(188, 25, 129, 17);
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Employee :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(188, 67, 129, 17);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton_4 = new JButton("Total");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtempname.getText().length() == 0 ) {
	     	    	lblmsg.setText("Please Enter a Employee name");
			    }
	     	    else if(!(Pattern.matches("^[a-zA-Z]+$", txtempname.getText()))) {
	     	    	lblmsg.setText("Please Enter a valid name Ex: Johon");
	     	    }
	     	    else {
	     	    	calculatewash();
					calpaint();
					calwheel();
					calbattery();
					calqty();
					total = total1+total2+total3+total4+total5;
					lbltotal.setText(Double.toString(total));
					lblmsg.setText("");
	     	    }
				
				
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(102, 205, 170));
		btnNewButton_4.setBounds(10, 466, 146, 42);
		panel_5.add(btnNewButton_4);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 184, 431, 177);
		panel_5.add(scrollPane_4);
		
		
		table5 = new JTable();
		
		model5 = new DefaultTableModel(){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column)
		      {
		        switch(column)
		        {
		        case 0:
	              return String.class;
		        case 1:
		          return int.class;
		          
		        case 2:
		        	  return Boolean.class;
		        default:
		        	  return String.class;
		        }
		      }
		    };
		Object[] column5 = {"Name" , "Price", "Select","Quantity"};
 		model5.setColumnIdentifiers(column5);
		table5.setAutoCreateRowSorter(true);
		table5.setModel(model5);
		scrollPane_4.setViewportView(table5);
		
		lblitem = new JLabel("");
		lblitem.setForeground(new Color(255, 255, 255));
		lblitem.setBounds(333, 372, 108, 32);
		panel_5.add(lblitem);
		
		lbltotal = new JLabel("");
		lbltotal.setFont(new Font("Arial Black", Font.BOLD, 13));
		lbltotal.setForeground(new Color(255, 255, 255));
		lbltotal.setBounds(333, 458, 108, 32);
		panel_5.add(lbltotal);
		
		lblmsg = new JLabel("");
		lblmsg.setForeground(new Color(0, 0, 0));
		lblmsg.setBounds(188, 99, 253, 20);
		panel_5.add(lblmsg);
		
		JLabel lblNewLabel_9 = new JLabel("Total Price Rs:");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(195, 448, 102, 42);
		panel_5.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Item Price Rs:");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(195, 372, 122, 20);
		panel_5.add(lblNewLabel_10);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Wheel Price Rs :");
		lblNewLabel_4_2_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 150, 131, 23);
		panel_5.add(lblNewLabel_4_2_1);
		
		JButton btnNewButton = new JButton("Print Bill");
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtempname.getText().length() == 0 ) {
	     	    	lblmsg.setText("Please Enter a Employee name");
			    }
	     	    else if(!(Pattern.matches("^[a-zA-Z]+$", txtempname.getText()))) {
	     	    	lblmsg.setText("Please Enter a valid name Ex: Johon");
	     	    }
	     	    else {
	     	    	print();
					lblmsg.setText("");
	     	    }
				
			}
		});
		btnNewButton.setBounds(10, 522, 146, 23);
		panel_5.add(btnNewButton);
	    viewTable5();
	    
		
		
	}
	public  void viewTable1() {
		   row = new Object[3];
		   try {  
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(datacon,username ,password);
			    Statement pst = con.createStatement();
				String sql="SELECT  `servicename`,  `serviceprice` FROM `service` WHERE `servicecat`= 'Vehicle wa'";
				
				ResultSet rs=pst.executeQuery(sql);
				while (rs.next()) {
					row[0] = rs.getString("servicename");
					row[1] = rs.getString("serviceprice");
					row[2] = false;
					model.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	   }
	public  void viewTable2() {
		   row = new Object[3];
		   try {  
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(datacon,username ,password);
			    Statement pst = con.createStatement();
			    String sql="SELECT  `servicename`,  `serviceprice` FROM `service` WHERE `servicecat`=  'Paintwash'";
				ResultSet rs=pst.executeQuery(sql);
				while (rs.next()) {
					row[0] = rs.getString("servicename");
					row[1] = rs.getString("serviceprice");
					row[2] = false;
					model2.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	   }
	public void viewTable3() {
		 row = new Object[3];
		   try {  
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(datacon,username ,password);
			    Statement pst = con.createStatement();
			    String sql="SELECT  `servicename`,  `serviceprice` FROM `service` WHERE `servicecat`= 'Wheel All'";
				ResultSet rs=pst.executeQuery(sql);
				while (rs.next()) {
					row[0] = rs.getString("servicename");
					row[1] = rs.getString("serviceprice");
					row[2] = false;
					model3.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	}
	
	public void viewTable4() {
		 row = new Object[3];
		   try {  
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(datacon,username ,password);
			    Statement pst = con.createStatement();
			    String sql="SELECT  `servicename`,  `serviceprice` FROM `service` WHERE `servicecat`= 'Battery'";
				ResultSet rs=pst.executeQuery(sql);
				while (rs.next()) {
					row[0] = rs.getString("servicename");
					row[1] = rs.getString("serviceprice");
					row[2] = false;
					model4.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	}
	public  void viewTable5() {
		   row = new Object[4];
		   try {  
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection(datacon,username ,password);
			    Statement pst = con.createStatement();
				String sql="SELECT * FROM `item` WHERE 1";
				
				ResultSet rs=pst.executeQuery(sql);
				while (rs.next()) {
					row[0] = rs.getString("Item_name");
					row[1] = rs.getString("item_price");
					row[2] = false;
					row[3] = 0;
					model5.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	   }
	
	public void calculatewash() {
		
		
		total1 =0;
		int length1 = table.getRowCount();
	    int price1[] = new int[length1];
	    String name1[] = new String[length1];
	    bill1 = "";
	    Boolean checked1[] = new Boolean[length1];
	    for(int k=0;k<length1; k++) {
	    	checked1[k] = Boolean.valueOf(table.getValueAt(k,2).toString());
	    	price1[k] = Integer.valueOf(table.getValueAt(k,1).toString());
	    	name1[k] = table.getValueAt(k,0).toString();
	    	}
	    for(int i=0; i<length1; i++) {
	    	if(checked1[i] == true) {
	    		 total1 = price1[i]+total1;
	    		 bill1 = name1[i] + "   "+price1[i]+ "\n" +bill1;
	    	}
	    	else {
	    		total1 = total1+0;
	    		
	    	}
	    	
	    	
	    }
	    
	    
	    lblwash.setText(Double.toString(total1 ));
	    
	    
	    
		
		
	   
		
	
	
}
	public void calpaint() {
		
		total2 =0;
		int length2 = table2.getRowCount();
	    int price2[] = new int[length2];
	    String name2[] = new String[length2];
	    bill2 = "";
	    Boolean checked2[] = new Boolean[length2];
	    for(int k=0;k<length2; k++) {
	    	checked2[k] = Boolean.valueOf(table2.getValueAt(k,2).toString());
	    	price2[k] = Integer.valueOf(table2.getValueAt(k,1).toString());
	    	name2[k] = table2.getValueAt(k,0).toString();
	    	}
	    for(int i=0; i<length2; i++) {
	    	if(checked2[i] == true) {
	    		 total2 = price2[i]+total2;
	    		 bill2 = name2[i] + "   "+price2[i]+ "\n" +bill2;
	    	}
	    	else {
	    		total2 = total2+0;
	    		
	    	}
	    	
	    }
	    lblpain.setText(Double.toString(total2));
	   
		
	}
	
	public void calwheel() {
		
		total3 =0;
		int length3 = table3.getRowCount();
	    int price3[] = new int[length3];
	    String name3[] = new String[length3];
	    bill3 = "";
	    Boolean checked3[] = new Boolean[length3];
	    for(int k=0;k<length3; k++) {
	    	checked3[k] = Boolean.valueOf(table3.getValueAt(k,2).toString());
	    	price3[k] = Integer.valueOf(table3.getValueAt(k,1).toString());
	    	name3[k] = table3.getValueAt(k,0).toString();
	    	}
	    for(int i=0; i<length3; i++) {
	    	if(checked3[i] == true) {
	    		 total3 = price3[i]+total3;
	    		 bill3 = name3[i] + "   "+price3[i]+ "\n" +bill3;
	    	}
	    	else {
	    		total3 = total3+0;
	    		
	    	}
	    	
	    }
	    lblwheel.setText(Double.toString(total3));
	   
		
	}
	public void calbattery() {
		
		total4 =0;
		int length4 = table3.getRowCount();
	    int price4[] = new int[length4];
	    
	    String name4[] = new String[length4];
	    bill4 = "";
	    Boolean checked4[] = new Boolean[length4];
	    for(int k=0;k<length4; k++) {
	    	checked4[k] = Boolean.valueOf(table4.getValueAt(k,2).toString());
	    	price4[k] = Integer.valueOf(table4.getValueAt(k,1).toString());
	    	name4[k] = table4.getValueAt(k,0).toString();
	    	}
	    for(int i=0; i<length4; i++) {
	    	if(checked4[i] == true) {
	    		 total4 = price4[i]+total4;
	    		 
	    		 bill4 = name4[i] + "   "+price4[i]+ "\n" +bill4;
	    	}
	    	else {
	    		total4 = total4+0; 
	    		
	    	}
	    	
	    }
	    lblbatt.setText(Double.toString(total4));
	    
	    
	    
	   
		
	}
	
public void calqty() {
		
		total5 =0;
		bill5 = "";
		int length5 = table5.getRowCount();
	    int price5[] = new int[length5];
	    int qty[] = new int[length5];
	    String name5[] = new String[length5];
	    
	    Boolean checked5[] = new Boolean[length5];
	    for(int k=0;k<length5; k++) {
	    	checked5[k] = Boolean.valueOf(table5.getValueAt(k,2).toString());
	    	price5[k] = Integer.valueOf(table5.getValueAt(k,1).toString());
	    	name5[k] = table5.getValueAt(k,0).toString();
	    	if(Integer.valueOf(table5.getValueAt(k,3).toString())>0) {
	    		qty[k] =    Integer.valueOf(table5.getValueAt(k,3).toString());
	    	}
	    	
	    	else {
	    		qty[k] =    0;
	    	}
	    }
	    for(int i=0; i<length5; i++) {
	    	if(checked5[i] == true && qty[i] !=0) {
	    		 total5 = (price5[i]*qty[i]) +total5;
	    		 bill5 = name5[i] + "   "+price5[i]+ "\n" +bill5;
	    	}
	    	else {
	    		total5 = (price5[i]*0) +total5; 
	    		
	    	}
	    	
	    }
	    
	    lblitem.setText(Double.toString(total5));
	   
		
	}

public void print() {
	
//	 if(total==0) {
//		 JOptionPane.showMessageDialog(null, "Please Check the totalbefore the print");
//	 }
//	 else {
//		 String finalbill = "Customer  "+txtempname.getText()+"\n\n Vehicle wash \n" + bill1+"Total Vehicale wash Price " +total1+ "\n\n Painting and wash \n"+bill2+"Total Painting Price " +total2;
//		 String finalbill2 = "\n\n Wheel Allignment \n" +bill3+"Total Wheel Allignment Price "+total3+ "\n\n Battery Service \n" +bill4+"Total Battery Price "+total4;
//		 String finalbill3 = "\n\n items \n" +bill5+"Total Item price " +total5+"\n\n\n Total Price Is: \t" +total;
//		 JOptionPane.showMessageDialog(null, finalbill+finalbill2+finalbill3); 
//	 }
	 File myFile = new File("E:\\education\\UOC\\3rd Year\\1st Sem\\IT 3003\\teamr_repository\\Service Center\\bill.txt");
	 try {
	 FileWriter myWriter = new FileWriter(myFile);
	 
	 if(total==0)
	 {
		 JOptionPane.showMessageDialog(null, "Please Check the totalbefore the print");
	 }
	 else
	 {   String address = "|===========================|\n 4 Wheel Auto center \n 32/B \n Queen's Road\n Co;ombo -7\n Contact No-0362548791\n|===========================| \n";
		 String details = "Cashier-Nalin \n Invoice No-0456 \n |===========================|\n Vehicle -Toyota\n Customer -" +txtempname.getText()+"\n|===========================|\n";
	     String enddetail =  "\n|===========================|\n Thank you for choosing us \n Have anice Day!! \n |===========================| \n Develop by Team_R";
		 String finalbill = address+details+"\n 1. Vehicle wash \n" + bill1+"Total Vehicale wash Price " +total1+ "\n\n 2. Painting and wash \n"+bill2+"Total Painting Price " +total2;
		 String finalbill2 = "\n\n 3.Wheel Allignment \n" +bill3+"Total Wheel Allignment Price "+total3+ "\n\n 4.Battery Service \n" +bill4+"Total Battery Price "+total4;
		 String finalbill3 = "\n\n 5.items \n" +bill5+"Total Item price " +total5+"\n\n\n|==== Total Price Is: \t" +total+enddetail;
		 JOptionPane.showMessageDialog(null, finalbill+finalbill2+finalbill3); 
		 
		 
		 myWriter.write(finalbill+finalbill2+finalbill3);
		 myWriter.close();
		 JOptionPane.showMessageDialog(null,"Printed");
	 }
	 
	 } catch (IOException e) {
	 System.out.println("An error occurred");
	 e.printStackTrace();
	 }
	 }
	 
	
}

