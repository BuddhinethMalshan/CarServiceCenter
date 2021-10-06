package cashier;

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
	CustomService obj1 = new CustomService();
	
	static String type,customerID;
	static String cname;
	static String cadd;
	static int ctp;
	static String vbrand;
	static String vmodel;
	static String vno;
	
	
	
	protected JFrame frame = new JFrame();
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
	static JTextField input1 = new JTextField(18);
	static JTextField input2 = new JTextField(12);
	////////////////////////
	static JTextArea input3 = new JTextArea("");
	static JTextField input4 = new JTextField(12);
	static JTextField input5 = new JTextField(18);
	static JTextField input6 = new JTextField(12);
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
		obj.starting();
		
	}
	void starting() {
		
		//System.out.println("I got "+type);
		//System.out.println("I got "+customerID);
		
		frame.setBounds(100,100,1083,694);
		frame.setVisible(true);
		frame.setBackground(Color.red);
		frame.setResizable(false);
		label1.setBounds(116, 5, 402, 67);
		
		label1.setFont(new Font("arial", Font.BOLD, 40));
		label1.setForeground (Color.yellow);
		label1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		label2.setBounds(598, 5, 355, 67);
		
		label2.setFont(new Font("arial", Font.BOLD, 40));
		label2.setForeground (Color.green);
		label2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		label3.setBounds(79, 215, 104, 28);
		
		label3.setFont(new Font("arial", Font.BOLD, 24));
		label3.setForeground (Color.white);
		label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label4.setBounds(584, 215, 154, 28);
		
		label4.setFont(new Font("arial", Font.BOLD, 24));
		label4.setForeground (Color.white);
		label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label5.setBounds(75, 314, 109, 28);
		
		label5.setFont(new Font("arial", Font.BOLD, 24));
		label5.setForeground (Color.white);
		label5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label6.setBounds(589, 314, 154, 28);
		
		label6.setFont(new Font("arial", Font.BOLD, 24));
		label6.setForeground (Color.white);
		label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label7.setBounds(76, 414, 106, 28);
		
		
		label7.setFont(new Font("arial", Font.BOLD, 24));
		label7.setForeground (Color.white);
		label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label8.setBounds(587, 414, 155, 28);
		
		label8.setFont(new Font("arial", Font.BOLD, 24));
		label8.setForeground (Color.white);
		label8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label9.setBounds(184, 192, 700, 0);
		
		label9.setFont(new Font("arial", Font.BOLD, 24));
		label9.setForeground(Color.decode("#06DEF7"));
		label9.setBorder(BorderFactory.createEmptyBorder(0, 350, 0,350));
		space3.setHorizontalAlignment(SwingConstants.CENTER);
		space3.setFont(new Font("Tahoma", Font.BOLD, 25));
		space3.setForeground(new Color(255, 255, 255));
		//////////////////////////////
		if(type=="old") {
		space3.setText("ID: "+customerID);
		} else {
			space3.setText("");	
		}
		img1.setBounds(309, 92, 100, 80);
		
		
		img1.setIcon(new ImageIcon("src\\Images\\user.png"));
		img1.setPreferredSize(new Dimension(100, 80));
		img1.setBorder(BorderFactory.createEmptyBorder(0,20,0,80));
		img2.setBounds(599, 92, 160, 80);
		
		img2.setIcon(new ImageIcon("src\\Images\\vehicle.png"));
		img2.setPreferredSize(new Dimension(160, 80));
		img2.setBorder(BorderFactory.createEmptyBorder(0,90,0,0));
		input1.setBounds(188, 212, 366, 34);
		
		input1.setHorizontalAlignment(JTextField.CENTER);
		input1.setCaretColor(Color.yellow);
		input1.setFont(new Font("arial", Font.PLAIN, 24));
		input1.setForeground (Color.yellow);
		input1.setBackground (Color.BLACK);
		input1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		input1.setText(Cashier.getcustName());
		input2.setBounds(743, 212, 246, 34);
		
		input2.setHorizontalAlignment(JTextField.CENTER);
		input2.setCaretColor(Color.green);
		input2.setFont(new Font("arial", Font.PLAIN, 24));
		input2.setForeground (Color.green);
		input2.setBackground (Color.BLACK);
		input2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		input2.setText(Cashier.getvehBrand());
		input3.setBounds(189, 271, 370, 115);
		
		input3.setPreferredSize(new Dimension(370, 115));
		input3.setCaretColor(Color.black);
		input3.setFont(new Font("arial", Font.PLAIN, 24));
		input3.setForeground (Color.black);
		input3.setBackground (Color.white);
		input3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		input3.setText(Cashier.getcustAdd());
		input4.setBounds(748, 311, 246, 34);
		
		
		input4.setHorizontalAlignment(JTextField.CENTER);
		input4.setCaretColor(Color.green);
		input4.setFont(new Font("arial", Font.PLAIN, 24));
		input4.setForeground (Color.green);
		input4.setBackground (Color.BLACK);
		input4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		input4.setText(Cashier.getvehModel());
		input5.setBounds(187, 411, 366, 34);
		
		input5.setHorizontalAlignment(JTextField.CENTER);
		input5.setCaretColor(Color.yellow);
		input5.setFont(new Font("arial", Font.PLAIN, 24));
		input5.setForeground (Color.yellow);
		input5.setBackground (Color.BLACK);
		input5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		input5.setText(Cashier.getcustTel());
		input6.setBounds(747, 411, 246, 34);
		
		
		input6.setHorizontalAlignment(JTextField.CENTER);
		input6.setCaretColor(Color.green);
		input6.setFont(new Font("arial", Font.PLAIN, 24));
		input6.setForeground (Color.green);
		input6.setBackground (Color.BLACK);
		input6.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
		input6.setText(Cashier.getvehNo());
		button1.setBounds(129, 495, 390, 50);
		
		button1.setFont(new Font("Arial", Font.BOLD, 24));
		button1.setForeground (Color.BLACK);
		button1.setBackground (Color.YELLOW);
		button1.setFocusPainted(false);
		button1.setPreferredSize(new Dimension(390, 50));
		button2.setBounds(609, 495, 330, 50);
		
		button2.setFont(new Font("Arial", Font.BOLD, 24));
		button2.setForeground (Color.BLACK);
		button2.setBackground (Color.YELLOW);
		button2.setFocusPainted(false);
		button2.setPreferredSize(new Dimension(330, 50));
		space1.setBounds(523, 33, 70, 10);
		
		space1.setPreferredSize(new Dimension(70, 10));
		space2.setBounds(-15, 77, 1100, 10);
		space2.setPreferredSize(new Dimension(1100, 10));
		space3.setBounds(414, 129, 180, 43);
		space3.setPreferredSize(new Dimension(180, 5));
		space4.setBounds(-15, 177, 1100, 10);
		space4.setPreferredSize(new Dimension(1100, 10));
		space5.setBounds(559, 226, 20, 5);
		space5.setPreferredSize(new Dimension(20, 5));
		space6.setBounds(-15, 251, 1100, 15);
		space6.setPreferredSize(new Dimension(1100, 15));
		space7.setBounds(564, 326, 20, 5);
		space7.setPreferredSize(new Dimension(20, 5));
		space8.setBounds(-15, 391, 1100, 15);
		space8.setPreferredSize(new Dimension(1100, 15));
		space9.setBounds(558, 425, 24, 5);
		space9.setPreferredSize(new Dimension(24, 5));
		space10.setBounds(-15, 197, 1100, 10);
		space10.setPreferredSize(new Dimension(1100, 10));
		space11.setBounds(-15, 450, 1100, 40);
		space11.setPreferredSize(new Dimension(1100, 40));
		space12.setBounds(524, 515, 80, 10);
		space12.setPreferredSize(new Dimension(80, 10));
		space13.setPreferredSize(new Dimension(30, 10));

		panel1.setBackground(Color.black);
		panel1.setLayout(null);
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
		
		frame.getContentPane().add(panel1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cash =new Cashier();
				cash.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		
		btnNewButton.setBounds(79, 592, 115, 34);
		panel1.add(btnNewButton);
		
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				try {
					if(input1.getText()=="" ||
					   input2.getText()==""	||
					   input4.getText()=="" ||
					   input6.getText()=="" ||
					   input5.getText()=="" ) {
						
						JOptionPane.showMessageDialog(null, "Please enter at lest Required Fields");
					
					}else {
				
				addingNewCustomer();
				CustomService custom = new CustomService();
				custom.setVisible(true);
				frame.setVisible(false);
				//frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				//frame.dispose();
				
					}
				}catch(Exception e1) {}
//			
			}
			
			
		});
		
		
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				try {
				if(input1.getText()=="" ||
				   input2.getText()==""	||
				   input4.getText()=="" ||
				   input6.getText()=="" ||
				   input5.getText()=="" ) {
					
					JOptionPane.showMessageDialog(null, "Please enter at lest Required Fields");
				
				}else {
					FullService full = new FullService();
					full.setVisible(true);
					full.starting();
					frame.setVisible(false);
					addingNewCustomer();
     			}
				}catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "Please enter at lest Required Fields");
				}
			
			}

		});		
		
	
	}

	void addingNewCustomer() {
		
		int ctp=0;
		cname = input1.getText();
		cadd = input3.getText();
		ctp = Integer.parseInt(input5.getText());

		vbrand = input2.getText();
		vmodel = input4.getText();
		vno = input6.getText();
				
		if(type.equals("new")) {
			
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/carservice","root","12345");
			
			String sql = "INSERT INTO `customer`(`customer_name`, `customer_add`, `customer_tel`, `customer_vhty` , `customer_vhm`, `customer_vhn`) VALUES ('"+cname+"','"+ cadd+"',"+ctp+",'"+vbrand+"', '"+vmodel+"', '"+vno+"')";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeUpdate(sql);
			
			}catch(SQLException | ClassNotFoundException e2) {
			System.out.println("error");
			}
		}
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	
		
		
	}

}
