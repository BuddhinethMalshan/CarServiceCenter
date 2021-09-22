

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Home {

	private JFrame frame;
	private JTextField txtname;
	private JPasswordField txtpass;
	private JRadioButton rbtnAdmin;
	private JRadioButton rbtnCashier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(850, 146, 184, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblname = new JLabel("User Name");
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname.setBounds(778, 220, 105, 29);
		frame.getContentPane().add(lblname);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpass.setBounds(778, 271, 105, 29);
		frame.getContentPane().add(lblpass);
		
		txtname = new JTextField();
		txtname.setBounds(893, 220, 130, 28);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(893, 270, 130, 28);
		frame.getContentPane().add(txtpass);
		
		JRadioButton rbtnAdmin = new JRadioButton("Admin");
		rbtnAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbtnAdmin.setBounds(790, 332, 67, 21);
		frame.getContentPane().add(rbtnAdmin);
		
		JRadioButton rbtnCashier = new JRadioButton("Cashier");
		rbtnCashier.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbtnCashier.setBounds(860, 332, 75, 21);
		frame.getContentPane().add(rbtnCashier);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(938, 327, 87, 32);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void login() {
		
		PreparedStatement ps1;
		PreparedStatement ps2;
		ResultSet rs1;
		ResultSet rs2;
		
		String name=txtname.getText();
		String pass= String.valueOf(txtpass.getPassword());
		
		String sql1 = "select * from admin where name_admin=? AND pass_admin=?;";
		String sql2 = "select * from cashier where name=? AND password=?;";
		
		try {
			Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","12345");
	        System.out.println("rrrrrrr");
			if(rbtnAdmin.isSelected()) {
				
				ps1 = conn1.prepareStatement(sql1);
				ps1.setString(1,name);
				ps1.setString(2,pass);
				
				rs1 = ps1.executeQuery(sql1);
				System.out.println(rs1);
				
				if(rs1.next()){
					JOptionPane.showMessageDialog(null,"Login Success!!");
				}else {
					JOptionPane.showMessageDialog(null,"Login Fail...");
				}
			
			}else if(rbtnCashier.isSelected()) {
				
				ps2 = conn1.prepareStatement(sql2);
				ps2.setString(1,name);
				ps2.setString(2,pass);
				
				rs2 = ps2.executeQuery(sql2);
				System.out.println(rs2);
				
				if(rs2.next()){
					JOptionPane.showMessageDialog(null,"Login Success!!");
				}else {
					JOptionPane.showMessageDialog(null,"Login Fail...");
				}
				
			}
			
		}catch(Exception ex) {
			
			System.out.println("Error....!!");
			
		}
	}
	
	
}




