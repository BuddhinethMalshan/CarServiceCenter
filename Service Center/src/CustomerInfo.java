import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

public class CustomerInfo {

	FullService obj = new FullService(); 
	
	String type,customerID;
	String CustomerName,CustomerAddress,CustomerTP,
	VehicleBrandName,VehicleModelName,VehicleRegNo;
	
	protected JFrame frame1 = new JFrame();
	private JFrame frame2 = new JFrame();
	private JFrame frame3 = new JFrame();
	private JPanel panel1 = new JPanel();
	private JLabel label1 = new JLabel("Customer Infomation");
	private JLabel label2 = new JLabel("Vehicle Infomation");
	private JLabel img1 = new JLabel("");
	private JLabel img2 = new JLabel("");
	private JLabel label3 = new JLabel("Name      ");
	private JLabel label4 = new JLabel("Brand Name  ");
	private JLabel label5 = new JLabel("Address  ");
	private JLabel label6 = new JLabel("Model Name  ");
	private JLabel label7 = new JLabel("T.Phone  ");
	private JLabel label8 = new JLabel("Reg. Number ");
	private JLabel label9 = new JLabel();
	private JTextField input1 = new JTextField(18);
	private JTextField input2 = new JTextField(12);
	private JTextArea input3 = new JTextArea("");
	private JTextField input4 = new JTextField(12);
	private JTextField input5 = new JTextField(18);
	private JTextField input6 = new JTextField(12);
	private JButton button1 = new JButton("FULL SERVICE");
	private JButton button2 = new JButton("CUSTOM SERVICE");
	
	
	JLabel space1 = new JLabel("");
	JLabel space2 = new JLabel("");
	JLabel space3 = new JLabel("");
	JLabel space4 = new JLabel("");
	JLabel space5 = new JLabel("");
	JLabel space6 = new JLabel("");
	JLabel space7 = new JLabel("");
	JLabel space8 = new JLabel("");
	JLabel space9 = new JLabel("");
	JLabel space10 = new JLabel("");
	JLabel space11= new JLabel("");
	JLabel space12= new JLabel("");
	JLabel space13= new JLabel("");
	
	
	public static void main(String[] args) {
		
		CustomerInfo obj = new CustomerInfo();
		//obj.fillingDetails();
		obj.starting();
		//obj.onFullServiceClick();
		//obj.onCustomServiceClick();
		
	}

	void fillingDetails() {
		if(type.equals("new")) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			 
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/fourwheelautoservice","root","");
				System.out.println("Connected from 2");
				
				Statement stmt=conn.createStatement();
				String sql2 = "insert into CustomerInfo (CustomerName,CustomerAddress,CustomerTP,"
						+ "VehicleBrand,VehicleModel,VehicleRegNo) values ('','','','','','')";
		
				stmt.executeUpdate(sql2);
				
				String sql3 = "SELECT * FROM CustomerInfo WHERE CustomerName='' LIMIT 1";
				ResultSet rs2 = stmt.executeQuery(sql3);
				
				while (rs2.next()) {
					
				customerID = rs2.getString("CustomerID");
				label9.setText("ID : "+customerID);
				}
				
			}catch (SQLException | ClassNotFoundException e2) {
					System.out.println("Error from 2");	
			}
		}
			
		else if(type.equals("old")){
			
			label9.setText("ID : "+customerID);
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fourwheelautoservice","root","");
				
				System.out.println("Connected from 2");
				
				Statement stmt=con.createStatement();
				String sql = "SELECT * FROM CustomerInfo WHERE CustomerID="+ customerID;
				ResultSet rs = stmt.executeQuery(sql);
		
				while (rs.next()) {
					
				CustomerName = rs.getString("CustomerName");
				input1.setText(CustomerName);
				VehicleBrandName = rs.getString("VehicleBrand");
				input2.setText(VehicleBrandName);
				CustomerAddress = rs.getString("CustomerAddress");
				input3.setText(CustomerAddress);
				VehicleModelName = rs.getString("VehicleModel");
				input4.setText(VehicleModelName);
				CustomerTP = rs.getString("CustomerTP");
				input5.setText(CustomerTP);
				VehicleRegNo = rs.getString("VehicleRegNo");
				input6.setText(VehicleRegNo);
				
				}
				
				con.close();
				
				} catch (SQLException | ClassNotFoundException e2) {
				System.out.println("Error from 22");
				}
		}
			
	}
	
	
	
	
	void starting() {
		
		System.out.println("I got "+type);
		System.out.println("I got "+customerID);
		
		frame1.setBounds(100,100,1083,694);
		frame1.setVisible(true);
		frame1.setBackground(Color.red);
		frame1.setResizable(false);
		
		frame2.setSize(800,520);
		frame2.setVisible(false);
		frame2.setBackground(Color.red);
		frame2.setResizable(false);
		
		label1.setFont(new Font("arial", Font.BOLD, 40));
		label1.setForeground (Color.yellow);
		label1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		label2.setFont(new Font("arial", Font.BOLD, 40));
		label2.setForeground (Color.green);
		label2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		label3.setFont(new Font("arial", Font.BOLD, 24));
		label3.setForeground (Color.white);
		label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label4.setFont(new Font("arial", Font.BOLD, 24));
		label4.setForeground (Color.white);
		label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label5.setFont(new Font("arial", Font.BOLD, 24));
		label5.setForeground (Color.white);
		label5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label6.setFont(new Font("arial", Font.BOLD, 24));
		label6.setForeground (Color.white);
		label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		
		label7.setFont(new Font("arial", Font.BOLD, 24));
		label7.setForeground (Color.white);
		label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label8.setFont(new Font("arial", Font.BOLD, 24));
		label8.setForeground (Color.white);
		label8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label9.setFont(new Font("arial", Font.BOLD, 24));
		label9.setForeground(Color.decode("#06DEF7"));
		label9.setBorder(BorderFactory.createEmptyBorder(0, 350, 0,350));
		
		
		img1.setIcon(new ImageIcon("src\\Images\\user.png"));
		img1.setPreferredSize(new Dimension(100, 80));
		img1.setBorder(BorderFactory.createEmptyBorder(0,20,0,80));
		
		img2.setIcon(new ImageIcon("src\\Images\\vehicle.png"));
		img2.setPreferredSize(new Dimension(160, 80));
		img2.setBorder(BorderFactory.createEmptyBorder(0,90,0,0));
		
		input1.setHorizontalAlignment(JTextField.CENTER);
		input1.setCaretColor(Color.yellow);
		input1.setFont(new Font("arial", Font.PLAIN, 24));
		input1.setForeground (Color.yellow);
		input1.setBackground (Color.BLACK);
		input1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		
		input2.setHorizontalAlignment(JTextField.CENTER);
		input2.setCaretColor(Color.green);
		input2.setFont(new Font("arial", Font.PLAIN, 24));
		input2.setForeground (Color.green);
		input2.setBackground (Color.BLACK);
		input2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		
		input3.setPreferredSize(new Dimension(370, 115));
		input3.setCaretColor(Color.black);
		input3.setFont(new Font("arial", Font.PLAIN, 24));
		input3.setForeground (Color.black);
		input3.setBackground (Color.white);
		input3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		
		input4.setHorizontalAlignment(JTextField.CENTER);
		input4.setCaretColor(Color.green);
		input4.setFont(new Font("arial", Font.PLAIN, 24));
		input4.setForeground (Color.green);
		input4.setBackground (Color.BLACK);
		input4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		
		input5.setHorizontalAlignment(JTextField.CENTER);
		input5.setCaretColor(Color.yellow);
		input5.setFont(new Font("arial", Font.PLAIN, 24));
		input5.setForeground (Color.yellow);
		input5.setBackground (Color.BLACK);
		input5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		
		
		input6.setHorizontalAlignment(JTextField.CENTER);
		input6.setCaretColor(Color.green);
		input6.setFont(new Font("arial", Font.PLAIN, 24));
		input6.setForeground (Color.green);
		input6.setBackground (Color.BLACK);
		input6.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		
		button1.setFont(new Font("Arial", Font.BOLD, 24));
		button1.setForeground (Color.BLACK);
		button1.setBackground (Color.YELLOW);
		button1.setFocusPainted(false);
		button1.setPreferredSize(new Dimension(390, 50));
		
		button2.setFont(new Font("Arial", Font.BOLD, 24));
		button2.setForeground (Color.BLACK);
		button2.setBackground (Color.YELLOW);
		button2.setFocusPainted(false);
		button2.setPreferredSize(new Dimension(330, 50));
		
		space1.setPreferredSize(new Dimension(70, 10));
		space2.setPreferredSize(new Dimension(1100, 10));
		space3.setPreferredSize(new Dimension(180, 5));
		space4.setPreferredSize(new Dimension(1100, 10));
		space5.setPreferredSize(new Dimension(20, 5));
		space6.setPreferredSize(new Dimension(1100, 15));
		space7.setPreferredSize(new Dimension(20, 5));
		space8.setPreferredSize(new Dimension(1100, 15));
		space9.setPreferredSize(new Dimension(24, 5));
		space10.setPreferredSize(new Dimension(1100, 10));
		space11.setPreferredSize(new Dimension(1100, 40));
		space12.setPreferredSize(new Dimension(80, 10));
		space13.setPreferredSize(new Dimension(30, 10));

		panel1.setBackground(Color.black);
		panel1.add(label1);
		panel1.add(space1);
		panel1.add(label2);
		panel1.add(space2);
		panel1.add(img1);
		panel1.add(space3);
		panel1.add(img2);
		panel1.add(space4);
		panel1.add(label9);
		panel1.add(space10);
		panel1.add(label3);
		panel1.add(input1);
		panel1.add(space5);
		panel1.add(label4);
		panel1.add(input2);
		panel1.add(space6);
		panel1.add(label5);
		panel1.add(input3);
		panel1.add(space7);
		panel1.add(label6);
		panel1.add(input4);
		panel1.add(space8);
		panel1.add(label7);
		panel1.add(input5);
		panel1.add(space9);
		panel1.add(label8);
		panel1.add(input6);
		panel1.add(space11);
		panel1.add(button1);
		panel1.add(space12);
		panel1.add(button2);
		
		frame1.add(panel1);
		
	}
	
	
	void onCustomServiceClick() {
		/**
		 * 1.Check whether all fields are non empty
		 * 2.Check whether Name and TP are valid
		 * 3.Send details for the bill to be print later
		 * 4.Change screen to the next screen
		 */
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				if((!input1.getText().equals(""))&&
				   (!input2.getText().equals(""))&&
				   (!input3.getText().equals(""))&&
				   (!input4.getText().equals(""))&&
				   (!input5.getText().equals(""))&&
				   (!input6.getText().equals(""))) {
				
				
					if (!(Pattern.matches("^[a-zA-Z\s]+$",input1.getText()))) {
					    JOptionPane.showMessageDialog(frame1, "Please Enter An Valid Name!", "Wrong Name", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						CustomerName = input1.getText();
					}
					
					if ((!(Pattern.matches("^[0-9]+$",input5.getText())))||
						(input5.getText().length()!=10)) {
					    JOptionPane.showMessageDialog(frame1, "Please Enter An Valid TP Number!", "Wrong TP", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						CustomerTP = input5.getText();
					}
					
					VehicleBrandName = input2.getText();
					CustomerAddress = input3.getText();
					VehicleModelName = input4.getText();
					VehicleRegNo = input6.getText();
					
					if((!CustomerName.equals(""))&&
					   (!CustomerTP.equals(""))) {
							
						
						
						sendToBill();
						toNextScreen();
				
					}
					else {
						
					}
				}
				else {
						JOptionPane.showMessageDialog(frame1, "Some Fields Are Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);	
				}
			  }

	
			private void sendToBill() {
				System.out.println("Details Send!");
			}

			private void toNextScreen() {
				frame1.setVisible(false);
				frame2.setVisible(true);
			}
			
		});
			
	}
	

	void onFullServiceClick() {
		/**
		 * 1.Check whether all fields are non empty
		 * 2.Check whether all inputs are valid
		 * 3.Send details for the bill to be print later
		 * 4.Change screen to the next screen
		 */
		
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				if((!input1.getText().equals(""))&&
				   (!input2.getText().equals(""))&&
				   (!input3.getText().equals(""))&&
				   (!input4.getText().equals(""))&&
				   (!input5.getText().equals(""))&&
				   (!input6.getText().equals(""))) {
				
				
					if (!(Pattern.matches("^[a-zA-Z\s]+$",input1.getText()))) {
					    JOptionPane.showMessageDialog(frame1, "Please Enter An Valid Name!", "Wrong Name", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						CustomerName = input1.getText();
					}
			
					if ((!(Pattern.matches("^[0-9]+$",input5.getText())))||
						(input5.getText().length()!=10)) {
					    JOptionPane.showMessageDialog(frame1, "Please Enter An Valid TP Number!", "Wrong TP", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						CustomerTP = input5.getText();
					}
					
					VehicleBrandName = input2.getText();
					CustomerAddress = input3.getText();
					VehicleModelName = input4.getText();
					VehicleRegNo = input6.getText();
					
					if((Pattern.matches("^[a-zA-Z\s]+$",input1.getText()))&&
					   (Pattern.matches("^[0-9]+$",input5.getText()))) {
							
						
						addingNewCustomer();
						sendCustomerDetailsToNext();
						toNextScreen();
						
					}
					else {
						
					}
				}
				else {
						JOptionPane.showMessageDialog(frame1, "Some Fields Are Empty!", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);	
				}
			}

		
			private void sendCustomerDetailsToNext() {
				
				    
				obj.customerID = customerID;
				obj.CustomerName = CustomerName;
				obj.CustomerAddress = CustomerAddress;
				obj.CustomerTP = CustomerTP;
				obj.VehicleBrandName = VehicleBrandName;
				obj.VehicleModelName = VehicleModelName;
				obj.VehicleRegNo = VehicleRegNo;
				
			}

			private void toNextScreen() {
				frame1.setVisible(false);
				obj.starting();
			}
			
			void addingNewCustomer() {
				if(type.equals("new")) {
					
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fourwheelautoservice","root","");
					
					Statement stmt=con.createStatement();
					String sql = "INSERT INTO customerinfo (CustomerName,CustomerAddress,CUstomerTP,"+
							"VehicleBrand,VehicleModel,VehicleRegNo) VALUES "
							+ "("+CustomerName+","+CustomerAddress+","+CustomerTP+","+VehicleBrandName+","+VehicleModelName+","+VehicleRegNo+")"
									+ "WHERE CustomerID ="+customerID;
					stmt.executeUpdate(sql);
					
					}catch(SQLException | ClassNotFoundException e2) {
					System.out.println("error");
					}
				}
			}

		});
		
		
		
	}
	
	
}
