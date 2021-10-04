package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Admin   {

	
	
	private JFrame frame;
	private static final String username = "root";
	private static final String password = "";
	private static final String datacon = "jdbc:mysql://localhost/carservice";
	
	Connection con = null;
    Statement  pst = null;
	ResultSet rs = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,1083,694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelemp = new JPanel();
		panelemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 panelemp.setBackground(new Color(102, 205, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelemp.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee Emp = new Employee();
		        Emp.setVisible(true);
		        frame.setVisible(false);
		        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.dispose();
				
			}
			
		});
		panelemp.setBackground(new Color(0, 139, 139));
		panelemp.setForeground(Color.WHITE);
		panelemp.setBounds(228, 90, 192, 118);
		frame.getContentPane().add(panelemp);
		panelemp.setLayout(null);
		
		JLabel lblemp = new JLabel("\r\nEmployee");
		lblemp.setBounds(45, 37, 94, 37);
		lblemp.setForeground(Color.WHITE);
		lblemp.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelemp.add(lblemp);
		
		JPanel panelemp_2 = new JPanel();
		panelemp_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 panelemp_2.setBackground(new Color(102, 205, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelemp_2.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer cus = new Customer();
		        cus.setVisible(true);
		        frame.setVisible(false);
		        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		panelemp_2.setForeground(Color.WHITE);
		panelemp_2.setBackground(new Color(0, 139, 139));
		panelemp_2.setBounds(494, 90, 192, 118);
		frame.getContentPane().add(panelemp_2);
		panelemp_2.setLayout(null);
		
		JLabel lblcus = new JLabel("Customer Details");
		lblcus.setBounds(23, 45, 148, 30);
		lblcus.setForeground(Color.WHITE);
		lblcus.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelemp_2.add(lblcus);
		
		JPanel panelemp_4 = new JPanel();
		panelemp_4.addMouseListener(new MouseAdapter(){
	    public void mouseClicked(MouseEvent e) {
	        
	        Inventory invent = new Inventory();
	        invent.setVisible(true);
	        frame.setVisible(false);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.dispose();
	    }

			

			



			@Override
			public void mouseEntered(MouseEvent e) {
				 panelemp_4.setBackground(new Color(102, 205, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelemp_4.setBackground(new Color(0, 139, 139));
			}
	});
		panelemp_4.setForeground(Color.WHITE);
		panelemp_4.setBackground(new Color(0, 139, 139));
		panelemp_4.setBounds(494, 245, 192, 118);
		frame.getContentPane().add(panelemp_4);
		panelemp_4.setLayout(null);
		
		JLabel lblItems = new JLabel("Items and Service");
		lblItems.setBounds(21, 23, 161, 65);
		lblItems.setForeground(Color.WHITE);
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelemp_4.add(lblItems);
		
		JPanel panelemp_5 = new JPanel();
		panelemp_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 panelemp_5.setBackground(new Color(102, 205, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelemp_5.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Settings set = new Settings();
		        set.setVisible(true);
		        frame.setVisible(false);
		        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		panelemp_5.setForeground(Color.WHITE);
		panelemp_5.setBackground(new Color(0, 139, 139));
		panelemp_5.setBounds(228, 245, 192, 118);
		frame.getContentPane().add(panelemp_5);
		panelemp_5.setLayout(null);
		
		JLabel lblSetting = new JLabel("Settings");
		lblSetting.setBounds(57, 47, 92, 25);
		lblSetting.setForeground(Color.WHITE);
		lblSetting.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelemp_5.add(lblSetting);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 581, 1067, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/images/Car_logos.png")));
		lblNewLabel_1.setBounds(449, 0, 618, 74);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/Customer.jpg")));
		lblNewLabel.setBounds(0, 0, 1067, 655);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
	public void delete()  {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(datacon,username ,password);
        
           
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
	}
	public void update() {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(datacon,username ,password);
        
           
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
	}
	
	public void insert() {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(datacon,username ,password);
        
           
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
	}
	
	public void viewDetails(){
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(datacon,username ,password);
        
           
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
		
	}
	
	public void setVisible(boolean b) {
		Admin window = new Admin();
		window.frame.setVisible(true);
		
	}
}

