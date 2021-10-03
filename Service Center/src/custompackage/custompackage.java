package custompackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class custompackage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custompackage window = new custompackage();
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
	public custompackage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Custom service");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(412, 30, 243, 80);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(63, 149, 120, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(63, 203, 120, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(216, 154, 163, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 208, 163, 25);
		frame.getContentPane().add(textField_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Body wash");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(92, 336, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxTyreDressing = new JCheckBox("Tyre dressing");
		chckbxTyreDressing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTyreDressing.setBounds(92, 396, 266, 36);
		frame.getContentPane().add(chckbxTyreDressing);
		
		JCheckBox chckbxGlassCleaning = new JCheckBox("Glass cleaning");
		chckbxGlassCleaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGlassCleaning.setBounds(92, 458, 266, 36);
		frame.getContentPane().add(chckbxGlassCleaning);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Glass cleaning");
		chckbxNewCheckBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_2_1.setBounds(551, 458, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Carpet wash");
		chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_1_1.setBounds(551, 396, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Body wash");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_3.setBounds(551, 336, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("Interrior vaccum");
		chckbxNewCheckBox_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_2_2.setBounds(551, 641, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Dash cleaning");
		chckbxNewCheckBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_1_2.setBounds(551, 579, 266, 36);
		frame.getContentPane().add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxTyreDressingAnd = new JCheckBox("Tyre dressing and wax");
		chckbxTyreDressingAnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTyreDressingAnd.setBounds(551, 519, 266, 36);
		frame.getContentPane().add(chckbxTyreDressingAnd);
		
		JLabel lblNewLabel_2 = new JLabel("Quick wash");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(92, 280, 169, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Detailed wash");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(551, 280, 169, 25);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("50 000/=");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(364, 343, 93, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("10 000/=");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(364, 405, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("10 000/=");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(364, 458, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("20 000/=");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(843, 463, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("60 000/=");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(843, 341, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("8 000/=");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_2.setBounds(843, 401, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("20 000/=");
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1_2.setBounds(843, 646, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("10 000/=");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(843, 524, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("10 000/=");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_3.setBounds(843, 584, 93, 27);
		frame.getContentPane().add(lblNewLabel_3_1_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBounds(74, 322, 380, 195);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(119, 136, 153));
		panel_2.setBounds(531, 313, 400, 393);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pasindu Maduranga\\eclipse-workspace\\custompackage\\img\\bg(1).png"));
		lblNewLabel_4.setBounds(10, 10, 966, 743);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
