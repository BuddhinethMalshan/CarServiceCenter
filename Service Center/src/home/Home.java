package home;
import admin.Admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import cashier.Cashier;

public class Home {

	private JFrame frame;
	private JTextField txtname;
	private JPasswordField txtpass;
	private final ButtonGroup bg1 = new ButtonGroup();
	static String customer;

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
		frame.setTitle("Home");
		frame.setBounds(100, 100, 1083, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(830, 160, 184, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblname = new JLabel("User Name");
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblname.setBounds(791, 253, 105, 29);
		frame.getContentPane().add(lblname);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpass.setBounds(791, 331, 105, 29);
		frame.getContentPane().add(lblpass);
		
		txtname = new JTextField();
		txtname.setBounds(906, 256, 130, 28);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(908, 330, 130, 28);
		frame.getContentPane().add(txtpass);
		
		JRadioButton rbtnAdmin = new JRadioButton("Admin");
		rbtnAdmin.setBackground(SystemColor.activeCaption);
		bg1.add(rbtnAdmin);
		rbtnAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbtnAdmin.setBounds(810, 421, 67, 21);
		rbtnAdmin.setActionCommand("Admin");
		frame.getContentPane().add(rbtnAdmin);
		
		JRadioButton rbtnCashier = new JRadioButton("Cashier");
		rbtnCashier.setBackground(SystemColor.activeCaption);
		rbtnCashier.setSelected(true);
		bg1.add(rbtnCashier);
		rbtnCashier.setFont(new Font("Tahoma", Font.BOLD, 13));
		rbtnCashier.setBounds(885, 421, 75, 21);
		rbtnCashier.setActionCommand("Cashier");
		frame.getContentPane().add(rbtnCashier);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtname.getText().isEmpty() && txtpass.getPassword().length==0) {					
					JOptionPane.showMessageDialog(null, "Enter User Name and Password to login your account" );
				}else if(txtpass.getPassword().length==0) {
					 JOptionPane.showMessageDialog(null, "Please enter Password");
				}else if(txtname.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null,"Please enter User Name");
				}else {
					login();
				}								
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(966, 414, 93, 32);
		frame.getContentPane().add(btnNewButton);	
		
		JLabel lblNewLabel_2 = new JLabel("");
		try {
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/images/Car_logos.png")));
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		lblNewLabel_2.setBounds(447, 597, 600, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body>4 Wheel Auto Service<br>32/B,<br>Queen's Road,<br>Colombo 7</body></html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBorder(new EmptyBorder(0,30,0,0));
		lblNewLabel_1.setBounds(0, 512, 1069, 145);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblslide = new JLabel("");
		lblslide.setBounds(0, 134, 794, 379);
		frame.getContentPane().add(lblslide);
		lblslide.setIcon(new ImageIcon(this.getClass().getResource("/images/slides.gif")));
		
		JLabel lblloginBack = new JLabel("");
		lblloginBack.setBackground(SystemColor.activeCaption);
		lblloginBack.setOpaque(true);
		lblloginBack.setBounds(791, 134, 278, 379);
		frame.getContentPane().add(lblloginBack);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/images/4wheel.png")));
		lblNewLabel_3.setBackground(new Color(255, 215, 0));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 70));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(0, 0, 1069, 137);
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}
	
	private void login() {
		
		PreparedStatement ps1;
		PreparedStatement ps2;
		ResultSet rs1;
		ResultSet rs2;
		
		String name= txtname.getText();
		String pass= String.valueOf(txtpass.getPassword());
		
		String sql1 = "select * from admin where name_admin=? AND pass_admin=?;";
		String sql2 = "select * from cashier where name=? AND password=?;";
		
		try {
			Connection conn1= DriverManager.getConnection("jdbc:mysql://localhost:3306/CarService","root","12345");
			
			if(bg1.getSelection().getActionCommand()=="Admin") {
				//System.out.println("rrrrrrr");
				ps1 = conn1.prepareStatement(sql1);
				ps1.setString(1,name);
				ps1.setString(2,pass);
				
				rs1 = ps1.executeQuery();
				//System.out.println(rs1);
				
					if(rs1.next()){
						Admin ad = new Admin();
						ad.setVisible(true);
						frame.setVisible(false);
						frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						frame.dispose();					
						JOptionPane.showMessageDialog(frame,"Login Success!!");
						
					}else {
						JOptionPane.showMessageDialog(null,"Login Fail...");
					}
			
			}if(bg1.getSelection().getActionCommand()=="Cashier") {
				ps2 = conn1.prepareStatement(sql2);
				//System.out.println("rrrrrrr");
				ps2.setString(1,name);
				ps2.setString(2,pass);
				//System.out.println("rrrrrrr");
				
				rs2 = ps2.executeQuery();
				//System.out.println("111");
				
					if(rs2.next()){
						Cashier cash = new Cashier();
						cash.setVisible(true);
						frame.setVisible(false);
						frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						frame.dispose();		
						JOptionPane.showMessageDialog(frame,"Login Success!!");
					}else {
						JOptionPane.showMessageDialog(null,"Login Fail...");
					}			
			}
			
		 }catch(Exception ex) {
			
			System.out.println("Error....!!");
			
		}		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		Home window = new Home();
		window.frame.setVisible(true);
	}
	
//	public void setVisible(boolean b) {
//		Home window = new Home();
//		window.frame.setVisible(true);
//		
//	}
}


