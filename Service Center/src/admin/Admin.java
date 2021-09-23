package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;


public class Admin {

	private JFrame frame;

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
		frame.setBounds(100, 100, 503, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelemp = new JPanel();
		panelemp.setBackground(new Color(0, 100, 0));
		panelemp.setForeground(Color.WHITE);
		panelemp.setBounds(133, 62, 120, 40);
		frame.getContentPane().add(panelemp);
		
		JLabel lblemp = new JLabel("\r\nEmployee");
		lblemp.setForeground(Color.WHITE);
		lblemp.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelemp.add(lblemp);
		
		JPanel panelemp_1 = new JPanel();
		panelemp_1.setForeground(Color.WHITE);
		panelemp_1.setBackground(new Color(0, 100, 0));
		panelemp_1.setBounds(133, 132, 120, 40);
		frame.getContentPane().add(panelemp_1);
		
		JLabel lblreport = new JLabel("Report");
		panelemp_1.add(lblreport);
		lblreport.setForeground(Color.WHITE);
		lblreport.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panelemp_2 = new JPanel();
		panelemp_2.setForeground(Color.WHITE);
		panelemp_2.setBackground(new Color(0, 100, 0));
		panelemp_2.setBounds(274, 62, 120, 40);
		frame.getContentPane().add(panelemp_2);
		
		JLabel lblcus = new JLabel("Customer Details");
		lblcus.setForeground(Color.WHITE);
		lblcus.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelemp_2.add(lblcus);
		
		JPanel panelemp_3 = new JPanel();
		panelemp_3.setForeground(Color.WHITE);
		panelemp_3.setBackground(new Color(0, 100, 0));
		panelemp_3.setBounds(274, 132, 120, 40);
		frame.getContentPane().add(panelemp_3);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setForeground(Color.WHITE);
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelemp_3.add(lblServices);
		
		JPanel panelemp_4 = new JPanel();
		panelemp_4.setForeground(Color.WHITE);
		panelemp_4.setBackground(new Color(0, 100, 0));
		panelemp_4.setBounds(133, 202, 120, 40);
		frame.getContentPane().add(panelemp_4);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setForeground(Color.WHITE);
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelemp_4.add(lblItems);
		
		JPanel panelemp_5 = new JPanel();
		panelemp_5.setForeground(Color.WHITE);
		panelemp_5.setBackground(new Color(0, 100, 0));
		panelemp_5.setBounds(274, 202, 120, 40);
		frame.getContentPane().add(panelemp_5);
		
		JLabel lblSetting = new JLabel("Settings");
		lblSetting.setForeground(Color.WHITE);
		lblSetting.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelemp_5.add(lblSetting);
	}
}

