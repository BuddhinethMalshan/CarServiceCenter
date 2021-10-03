import java.awt.*;
import java.sql.*;
import java.math.*;
import java.awt.event.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

public class Cashier {
	
	String inputID, customerName, customerAddress, customerTP, vehicleBrand, vehicleModel, vehicleRegNo;
	private String customerType;
	
	private JFrame frame1 = new JFrame();
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
		
		Cashier obj = new Cashier();     
		obj.starting();
		obj.onOldCustomerClick();
		obj.onNewCustomerClick();
		
	}
	
	public String getCustomerType() {
        return customerType;
    }

	private void starting() {
		 
		frame1.setBounds(100,100,1083,694);
		frame1.setVisible(true);
		frame1.setBackground(Color.red);
		frame1.setResizable(false);
		
		label1.setFont(new Font("arial", Font.BOLD, 50));
		label1.setForeground (Color.yellow);
		label1.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
		
		label2.setFont(new Font("arial", Font.BOLD, 40));
		label2.setForeground (Color.green);
		label2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		
		label3.setFont(new Font("arial", Font.BOLD, 40));
		label3.setForeground (Color.green);
		label3.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		label4.setFont(new Font("arial", Font.BOLD, 30));
		label4.setForeground (Color.white);
		label4.setBorder(BorderFactory.createEmptyBorder(0,420, 0, 0));
		
		button1.setFont(new Font("Arial", Font.PLAIN, 30));
		button1.setForeground (Color.green);
		button1.setBackground (Color.black);
		button1.setFocusPainted(false);
		button1.setPreferredSize(new Dimension(450, 320));
		
		button2.setFont(new Font("Arial", Font.PLAIN, 30));
		button2.setForeground (Color.green);
		button2.setBackground (Color.black);
		button2.setFocusPainted(false);
		button2.setPreferredSize(new Dimension(450, 320));
		
		
		input1.setHorizontalAlignment(JTextField.CENTER);
		input1.setCaretColor(Color.green);
		input1.setFont(new Font("arial", Font.BOLD, 30));
		input1.setForeground (Color.yellow);
		input1.setBackground (Color.BLACK);
		input1.setPreferredSize(new Dimension(200, 45));
		input1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
	
		space1.setPreferredSize(new Dimension(800, 5));
		space2.setPreferredSize(new Dimension(50, 10));
		space3.setPreferredSize(new Dimension(800, 5));
		space4.setPreferredSize(new Dimension(180, 5));
		
		panel1.setBackground(Color.black);
		
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
		frame1.add(panel1);
	}
	
	
	private void onNewCustomerClick() {
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				/**
				 * Function to change screen on new customer button click			 
				 */
				customerType = "new";
				CustomerInfo obj2 = new CustomerInfo();
				obj2.type=customerType;
				frame1.dispose();
				obj2.starting();
				obj2.fillingDetails();
				obj2.onFullServiceClick();
				obj2.onCustomServiceClick();
				
			}  
		});	
	}
	
	private void onOldCustomerClick() {
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
		
					JOptionPane.showMessageDialog(frame1,"Please Enter Your ID!","ID Missing!",JOptionPane.INFORMATION_MESSAGE);     
				}
				else {
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fourwheelautoservice","root","");
						
						System.out.println("Connected from 1");
						
						Statement stmt=con.createStatement();
						String sql = "SELECT * FROM CustomerInfo WHERE CustomerID="+ inputID;
						ResultSet rs = stmt.executeQuery(sql);
						//input1.setText(rs.("CustomerName"));
						
						if(rs.next()) {
							CustomerInfo obj3 = new CustomerInfo();
							obj3.customerID=inputID;
							obj3.type="old";
							frame1.dispose();
							obj3.starting();
							obj3.fillingDetails();
							obj3.onFullServiceClick();
							obj3.onCustomServiceClick();		
						}
						else {
							JOptionPane.showMessageDialog(frame1,"Sorry! Wrong ID","Invalid ID",JOptionPane.INFORMATION_MESSAGE);	
						}
						con.close();
						
						} catch (SQLException | ClassNotFoundException e2) {
						System.out.println("Error from 1");
						}
						
				}	
				
			}  
		});	
	}
		
}


