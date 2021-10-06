package cashier;

import java.awt.*;
import java.sql.*;
import java.math.*;
import java.awt.event.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

import admin.Admin;
import home.Home;

public class Cashier {
	
	String inputID, customerName, customerAddress, customerTP, vehicleBrand, vehicleModel, vehicleRegNo;
	private String customerType;
	
	private static final String username = "root";
	private static final String password = "12345";
	private static final String url = "jdbc:mysql://localhost:3306/carservice";
	
	Connection con;
    PreparedStatement ps;
	ResultSet rs ;
	
	static String custName;
	static String custAdd;
	//static int custTel;
	static String custTel1;
	static String vehBrand;
	static String vehModel;
	static String vehNo;
	
	private JFrame frame = new JFrame();
	private JPanel panel1 = new JPanel();
	private JLabel label1 = new JLabel("CUSTOMER TYPE");
	private JLabel label2 = new JLabel("NEW Customer");
	private JLabel label3 = new JLabel("OLD Customer");
	private JLabel label4 = new JLabel("ID  ");
	
	private Icon icon1 = new ImageIcon("src/Images/oldcar.jpg");
	private Icon icon2 = new ImageIcon("src/Images/newcar.jpg");
	private JButton button1 = new JButton(icon2);
	private JButton button2 = new JButton(icon1);
	private JTextField input1 = new JTextField(12);
	
	JLabel space1 = new JLabel("");
	JLabel space2 = new JLabel("");
	JLabel space3 = new JLabel("");
	JLabel space4 = new JLabel("");
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashier window = new Cashier();
					window.frame.setVisible(true);
					window.getCustomerType();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public Cashier() {
		starting();
	}
	
	private void starting() {
		 
		frame.setBounds(100,100,1083,694);
		frame.setVisible(true);
		frame.setBackground(Color.red);
		frame.setResizable(false);
		label1.setBounds(317, 5, 435, 119);
		
		label1.setFont(new Font("arial", Font.BOLD, 50));
		label1.setForeground (Color.yellow);
		label1.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
		label2.setBounds(153, 464, 290, 77);
		
		label2.setFont(new Font("arial", Font.BOLD, 40));
		label2.setForeground (Color.green);
		label2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		label3.setBounds(633, 474, 282, 57);
		
		
		label3.setFont(new Font("arial", Font.BOLD, 40));
		label3.setForeground (Color.green);
		label3.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		label4.setBounds(128, 550, 468, 36);
		
		label4.setFont(new Font("arial", Font.BOLD, 30));
		label4.setForeground (Color.white);
		label4.setBorder(BorderFactory.createEmptyBorder(0,420, 0, 0));
		button1.setBounds(54, 139, 450, 320);
		
		button1.setFont(new Font("Arial", Font.PLAIN, 30));
		button1.setForeground (Color.green);
		button1.setBackground (Color.black);
		button1.setFocusPainted(false);
		button1.setPreferredSize(new Dimension(450, 320));
		button2.setBounds(564, 139, 450, 320);
		
		button2.setFont(new Font("Arial", Font.PLAIN, 30));
		button2.setForeground (Color.green);
		button2.setBackground (Color.black);
		button2.setFocusPainted(false);
		button2.setPreferredSize(new Dimension(450, 320));
		input1.setBounds(601, 546, 340, 45);
		
		
		input1.setHorizontalAlignment(JTextField.CENTER);
		input1.setCaretColor(Color.green);
		input1.setFont(new Font("arial", Font.BOLD, 30));
		input1.setForeground (Color.yellow);
		input1.setBackground (Color.BLACK);
		input1.setPreferredSize(new Dimension(200, 45));
		input1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
		space1.setBounds(134, 129, 800, 5);
	
		space1.setPreferredSize(new Dimension(800, 5));
		space2.setBounds(509, 294, 50, 10);
		space2.setPreferredSize(new Dimension(50, 10));
		space3.setPreferredSize(new Dimension(800, 5));
		space4.setBounds(448, 500, 180, 5);
		space4.setPreferredSize(new Dimension(180, 5));
		
		panel1.setBackground(new Color(0, 0, 0));
		panel1.setLayout(null);
		
		panel1.add(label1);
		panel1.add(space1);
		panel1.add(button1);
		panel1.add(space2);
		panel1.add(button2);
		//panel1.add(space3);
		panel1.add(label2);
		panel1.add(space4);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(input1);
		frame.getContentPane().add(panel1);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Home h = new Home();
				h.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(54, 596, 125, 36);
		panel1.add(btnNewButton);
		
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
					/**
					 * Function to change screen on new customer button click			 
					 */
					customerType = "new";
					CustomerInfo obj2 = new CustomerInfo();
					obj2.type=customerType;
					frame.dispose();
					obj2.starting();
					//obj2.fillingDetails();
					//obj2.onFullServiceClick();
					//obj2.onCustomServiceClick();					
			}  
		});	
		
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				/**
				 * Function to change screen on old customer button click and 
				 * id is not empty and 
				 * id is valid		 
				 */
				customerType = "old";
				inputID = input1.getText();
				
				if(inputID.equals("")) {
		
					JOptionPane.showMessageDialog(frame,"Please Enter Your ID!","ID Missing!",JOptionPane.INFORMATION_MESSAGE);     
				}
				else {			
					oldCustID();				
				}					
			}  
		});	

		
	}
	
	
	public String getCustomerType() {
        return customerType;
    }

	
	public void oldCustID() {
		String id1 = input1.getText();
		int id = Integer.parseInt(id1);
		String sql="select * from customer where customer_id=?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			
			//System.out.println("r");
			
			if(rs.next()) {
				id = rs.getInt("customer_id");
				custName = rs.getString("customer_name");
				custAdd = rs.getString("customer_add");
				int custTel = rs.getInt("customer_tel");
				custTel1 = Integer.toString(custTel);
				vehBrand = rs.getString("customer_vhty");
				vehModel = rs.getString("customer_vhm");
				vehNo = rs.getString("customer_vhn");
				
				//System.out.println(custName);
				CustomerInfo obj3 = new CustomerInfo();
				obj3.customerID=inputID;
				obj3.type="old";
				frame.dispose();
				obj3.starting();
				//obj3.fillingDetails();
				//obj3.onFullServiceClick();
				//obj3.onCustomServiceClick();
				
			}else {
				JOptionPane.showMessageDialog(frame,"Sorry! Wrong ID","Invalid ID",JOptionPane.INFORMATION_MESSAGE);	
			}
			
			
			con.close();
		}
		catch(Exception ex) {
			System.out.println("Error");
		}
	}
	
	
	public static String getcustName() {
	    return custName;
	}
	public static String getcustAdd() {
		return custAdd;
	}
	public static String getcustTel() {
		return custTel1;
	}
	public static String getvehBrand() {
		return vehBrand;
	}
	public static String getvehModel() {
		return vehModel;
	}
	public static String getvehNo() {
		return vehNo;
	}

	public void setVisible(boolean b) {
		
		// TODO Auto-generated method stub
		
	}
}
