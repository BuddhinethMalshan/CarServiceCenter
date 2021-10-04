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
import javax.swing.JTabbedPane;

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
		lblNewLabel_1.setBounds(63, 118, 120, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(63, 153, 120, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(216, 123, 163, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 158, 163, 25);
		frame.getContentPane().add(textField_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(42, 188, 915, 565);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Vehicle Wash", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 112, 380, 195);
		panel.add(panel_1);
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Body wash");
		chckbxNewCheckBox.setBounds(15, 17, 266, 36);
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JCheckBox chckbxTyreDressing = new JCheckBox("Tyre dressing");
		chckbxTyreDressing.setBounds(15, 77, 266, 36);
		panel_1.add(chckbxTyreDressing);
		chckbxTyreDressing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JCheckBox chckbxGlassCleaning = new JCheckBox("Glass cleaning");
		chckbxGlassCleaning.setBounds(15, 139, 266, 36);
		panel_1.add(chckbxGlassCleaning);
		chckbxGlassCleaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("50 000/=");
		lblNewLabel_3.setBounds(287, 24, 93, 27);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3_1 = new JLabel("10 000/=");
		lblNewLabel_3_1.setBounds(287, 86, 93, 27);
		panel_1.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("10 000/=");
		lblNewLabel_3_1_1.setBounds(287, 139, 93, 27);
		panel_1.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(487, 102, 400, 393);
		panel.add(panel_2);
		panel_2.setBackground(new Color(119, 136, 153));
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Body wash");
		chckbxNewCheckBox_3.setBounds(15, 23, 266, 36);
		panel_2.add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_2 = new JLabel("60 000/=");
		lblNewLabel_3_2.setBounds(307, 28, 93, 27);
		panel_2.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Carpet wash");
		chckbxNewCheckBox_1_1.setBounds(15, 83, 266, 36);
		panel_2.add(chckbxNewCheckBox_1_1);
		chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1_2 = new JLabel("8 000/=");
		lblNewLabel_3_1_2.setBounds(307, 88, 93, 27);
		panel_2.add(lblNewLabel_3_1_2);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Glass cleaning");
		chckbxNewCheckBox_2_1.setBounds(15, 145, 266, 36);
		panel_2.add(chckbxNewCheckBox_2_1);
		chckbxNewCheckBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("20 000/=");
		lblNewLabel_3_1_1_1.setBounds(307, 150, 93, 27);
		panel_2.add(lblNewLabel_3_1_1_1);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxTyreDressingAnd = new JCheckBox("Tyre dressing and wax");
		chckbxTyreDressingAnd.setBounds(15, 206, 266, 36);
		panel_2.add(chckbxTyreDressingAnd);
		chckbxTyreDressingAnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_3 = new JLabel("10 000/=");
		lblNewLabel_3_3.setBounds(307, 211, 93, 27);
		panel_2.add(lblNewLabel_3_3);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Dash cleaning");
		chckbxNewCheckBox_1_2.setBounds(15, 266, 266, 36);
		panel_2.add(chckbxNewCheckBox_1_2);
		chckbxNewCheckBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1_3 = new JLabel("10 000/=");
		lblNewLabel_3_1_3.setBounds(307, 271, 93, 27);
		panel_2.add(lblNewLabel_3_1_3);
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("Interrior vaccum");
		chckbxNewCheckBox_2_2.setBounds(15, 328, 266, 36);
		panel_2.add(chckbxNewCheckBox_2_2);
		chckbxNewCheckBox_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("20 000/=");
		lblNewLabel_3_1_1_2.setBounds(307, 333, 93, 27);
		panel_2.add(lblNewLabel_3_1_1_2);
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("Vehicle wash");
		lblNewLabel_5.setBounds(330, 0, 253, 46);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2_1 = new JLabel("Detailed wash");
		lblNewLabel_2_1.setBounds(505, 70, 169, 25);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Quick wash");
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(39, 78, 169, 25);
		panel.add(lblNewLabel_2_1_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Painting", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("Painting and waxing");
		lblNewLabel_5_1.setOpaque(true);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_1.setBounds(344, 0, 253, 46);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quick Painting");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(200, 104, 169, 25);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(119, 136, 153));
		panel_4.setBounds(71, 144, 451, 206);
		panel_3.add(panel_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Normal Body Paint");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_1.setBounds(27, 29, 266, 36);
		panel_4.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxWheelPaint = new JCheckBox("Wheel Paint");
		chckbxWheelPaint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxWheelPaint.setBounds(27, 77, 266, 36);
		panel_4.add(chckbxWheelPaint);
		
		JCheckBox chckbxProtactiveCoat = new JCheckBox("Protactive coat");
		chckbxProtactiveCoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxProtactiveCoat.setBounds(27, 124, 266, 36);
		panel_4.add(chckbxProtactiveCoat);
		
		JLabel lblNewLabel_1_2 = new JLabel("10 000");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(299, 34, 93, 27);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("10 000");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(299, 82, 93, 27);
		panel_4.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("10 000");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(299, 129, 93, 27);
		panel_4.add(lblNewLabel_1_2_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Wheel Alignment", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Wheel alignment");
		lblNewLabel_5_1_1.setOpaque(true);
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_1_1.setBounds(345, 0, 253, 46);
		panel_5.add(lblNewLabel_5_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(119, 136, 153));
		panel_1_1.setBounds(71, 141, 451, 206);
		panel_5.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JCheckBox chckbxToeAlignment = new JCheckBox("Toe alignment");
		chckbxToeAlignment.setBounds(26, 26, 266, 36);
		panel_1_1.add(chckbxToeAlignment);
		chckbxToeAlignment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("10 000");
		lblNewLabel_1_3.setBounds(298, 31, 93, 27);
		panel_1_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox chckbxCasterAlignment = new JCheckBox("Caster alignment");
		chckbxCasterAlignment.setBounds(26, 74, 266, 36);
		panel_1_1.add(chckbxCasterAlignment);
		chckbxCasterAlignment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("10 000");
		lblNewLabel_1_1_1_1.setBounds(298, 79, 93, 27);
		panel_1_1.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox chckbxWheelBalancing = new JCheckBox("Wheel balancing");
		chckbxWheelBalancing.setBounds(26, 121, 266, 36);
		panel_1_1.add(chckbxWheelBalancing);
		chckbxWheelBalancing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("10 000");
		lblNewLabel_1_2_1_1.setBounds(298, 126, 93, 27);
		panel_1_1.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Highbrid / EV", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Highbrid / EV services");
		lblNewLabel_5_1_2.setOpaque(true);
		lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_1_2.setBounds(348, 0, 253, 46);
		panel_6.add(lblNewLabel_5_1_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(119, 136, 153));
		panel_1_2.setBounds(75, 145, 612, 261);
		panel_6.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JCheckBox chckbxHighbridBatteryService = new JCheckBox("Highbrid battery service");
		chckbxHighbridBatteryService.setBounds(6, 20, 266, 36);
		panel_1_2.add(chckbxHighbridBatteryService);
		chckbxHighbridBatteryService.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3_1 = new JLabel("10 000");
		lblNewLabel_1_3_1.setBounds(278, 25, 93, 27);
		panel_1_2.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox chckbxHighbridBatteryService_1 = new JCheckBox("Highbrid battery repaire");
		chckbxHighbridBatteryService_1.setBounds(6, 68, 266, 36);
		panel_1_2.add(chckbxHighbridBatteryService_1);
		chckbxHighbridBatteryService_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("10 000");
		lblNewLabel_1_1_1_2.setBounds(278, 73, 93, 27);
		panel_1_2.add(lblNewLabel_1_1_1_2);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox chckbxHighbridBatteryReplace = new JCheckBox("Highbrid battery replace");
		chckbxHighbridBatteryReplace.setBounds(6, 115, 266, 36);
		panel_1_2.add(chckbxHighbridBatteryReplace);
		chckbxHighbridBatteryReplace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("10 000");
		lblNewLabel_1_2_1_2.setBounds(278, 120, 93, 27);
		panel_1_2.add(lblNewLabel_1_2_1_2);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox chckbxCasterAlignment_1_1 = new JCheckBox("SOS battery and energy test");
		chckbxCasterAlignment_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCasterAlignment_1_1.setBounds(6, 159, 266, 36);
		panel_1_2.add(chckbxCasterAlignment_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1.setBounds(278, 164, 93, 27);
		panel_1_2.add(lblNewLabel_1_1_1_2_1);
		
		JCheckBox chckbxWheelBalancing_1_1 = new JCheckBox("SOH battery and energy test");
		chckbxWheelBalancing_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxWheelBalancing_1_1.setBounds(6, 206, 266, 36);
		panel_1_2.add(chckbxWheelBalancing_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_1.setBounds(278, 211, 93, 27);
		panel_1_2.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Battery Services");
		lblNewLabel_2_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(75, 74, 169, 25);
		panel_6.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(75, 416, 612, 96);
		panel_6.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(119, 136, 153));
		
		JCheckBox chckbxCasterAlignment_1_2_1 = new JCheckBox("ev computer diagnostics");
		chckbxCasterAlignment_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCasterAlignment_1_2_1.setBounds(6, 6, 266, 36);
		panel_1_2_1.add(chckbxCasterAlignment_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_2_1 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2_1.setBounds(278, 11, 93, 27);
		panel_1_2_1.add(lblNewLabel_1_1_1_2_2_1);
		
		JCheckBox chckbxWheelBalancing_1_2_1 = new JCheckBox("High voltage SC and diagnotics");
		chckbxWheelBalancing_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxWheelBalancing_1_2_1.setBounds(6, 53, 266, 36);
		panel_1_2_1.add(chckbxWheelBalancing_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_2_1.setBounds(278, 58, 93, 27);
		panel_1_2_1.add(lblNewLabel_1_2_1_2_2_1);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Other", null, panel_7, null);
		panel_7.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(27, 58, 849, 456);
		panel_7.add(tabbedPane_1);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Engine", null, panel_8, null);
		panel_8.setLayout(null);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(new Color(119, 136, 153));
		panel_1_2_2.setBounds(10, 36, 612, 261);
		panel_8.add(panel_1_2_2);
		
		JCheckBox chckbxEngineScan = new JCheckBox("Engine Scan");
		chckbxEngineScan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxEngineScan.setBounds(6, 20, 266, 36);
		panel_1_2_2.add(chckbxEngineScan);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("10 000");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_1.setBounds(278, 25, 93, 27);
		panel_1_2_2.add(lblNewLabel_1_3_1_1);
		
		JCheckBox chckbxHighbridBatteryService_1_1 = new JCheckBox("Engine clean");
		chckbxHighbridBatteryService_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryService_1_1.setBounds(6, 68, 266, 36);
		panel_1_2_2.add(chckbxHighbridBatteryService_1_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2.setBounds(278, 73, 93, 27);
		panel_1_2_2.add(lblNewLabel_1_1_1_2_2);
		
		JCheckBox chckbxOilRelacing = new JCheckBox("Oil relacing");
		chckbxOilRelacing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxOilRelacing.setBounds(6, 115, 266, 36);
		panel_1_2_2.add(chckbxOilRelacing);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_2.setBounds(278, 120, 93, 27);
		panel_1_2_2.add(lblNewLabel_1_2_1_2_2);
		
		JCheckBox chckbxCasterAlignment_1_1_1 = new JCheckBox("Filter change");
		chckbxCasterAlignment_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCasterAlignment_1_1_1.setBounds(6, 159, 266, 36);
		panel_1_2_2.add(chckbxCasterAlignment_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1.setBounds(278, 164, 93, 27);
		panel_1_2_2.add(lblNewLabel_1_1_1_2_1_1);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("Corrosion Protection", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_1_2_3 = new JPanel();
		panel_1_2_3.setLayout(null);
		panel_1_2_3.setBackground(new Color(119, 136, 153));
		panel_1_2_3.setBounds(10, 38, 612, 261);
		panel_9.add(panel_1_2_3);
		
		JCheckBox chckbxCleaningUnderCarriage = new JCheckBox("Cleaning Under carriage");
		chckbxCleaningUnderCarriage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCleaningUnderCarriage.setBounds(6, 20, 266, 36);
		panel_1_2_3.add(chckbxCleaningUnderCarriage);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("10 000");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_2.setBounds(278, 25, 93, 27);
		panel_1_2_3.add(lblNewLabel_1_3_1_2);
		
		JCheckBox chckbxHighbridBatteryService_1_2 = new JCheckBox("Cleaning covered areas");
		chckbxHighbridBatteryService_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryService_1_2.setBounds(6, 68, 266, 36);
		panel_1_2_3.add(chckbxHighbridBatteryService_1_2);
		
		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3.setBounds(278, 73, 93, 27);
		panel_1_2_3.add(lblNewLabel_1_1_1_2_3);
		
		JCheckBox chckbxThinerClaening = new JCheckBox("Thiner Claening");
		chckbxThinerClaening.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxThinerClaening.setBounds(6, 115, 266, 36);
		panel_1_2_3.add(chckbxThinerClaening);
		
		JLabel lblNewLabel_1_2_1_2_3 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_3.setBounds(278, 120, 93, 27);
		panel_1_2_3.add(lblNewLabel_1_2_1_2_3);
		
		JCheckBox chckbxCasterAlignment_1_1_2 = new JCheckBox("Smooth underrot application");
		chckbxCasterAlignment_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCasterAlignment_1_1_2.setBounds(6, 159, 266, 36);
		panel_1_2_3.add(chckbxCasterAlignment_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_2.setBounds(278, 164, 93, 27);
		panel_1_2_3.add(lblNewLabel_1_1_1_2_1_2);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_1.addTab("Leather care and Interior cleaning", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_1_2_4 = new JPanel();
		panel_1_2_4.setLayout(null);
		panel_1_2_4.setBackground(new Color(119, 136, 153));
		panel_1_2_4.setBounds(10, 38, 612, 261);
		panel_10.add(panel_1_2_4);
		
		JCheckBox chckbxRemovingCleaning = new JCheckBox("Battery test");
		chckbxRemovingCleaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxRemovingCleaning.setBounds(6, 20, 266, 36);
		panel_1_2_4.add(chckbxRemovingCleaning);
		
		JLabel lblNewLabel_1_3_1_3 = new JLabel("10 000");
		lblNewLabel_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_3.setBounds(278, 25, 93, 27);
		panel_1_2_4.add(lblNewLabel_1_3_1_3);
		
		JCheckBox chckbxHighbridBatteryService_1_3 = new JCheckBox("Service and Repairering battery");
		chckbxHighbridBatteryService_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryService_1_3.setBounds(6, 68, 266, 36);
		panel_1_2_4.add(chckbxHighbridBatteryService_1_3);
		
		JLabel lblNewLabel_1_1_1_2_4 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_4.setBounds(278, 73, 93, 27);
		panel_1_2_4.add(lblNewLabel_1_1_1_2_4);
		
		JCheckBox chckbxFloorBoardsClaning = new JCheckBox("Replacing battery");
		chckbxFloorBoardsClaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxFloorBoardsClaning.setBounds(6, 115, 266, 36);
		panel_1_2_4.add(chckbxFloorBoardsClaning);
		
		JLabel lblNewLabel_1_2_1_2_4 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_4.setBounds(278, 120, 93, 27);
		panel_1_2_4.add(lblNewLabel_1_2_1_2_4);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Battery services", null, panel_11, null);
		panel_11.setLayout(null);
		
		JPanel panel_1_2_5 = new JPanel();
		panel_1_2_5.setLayout(null);
		panel_1_2_5.setBackground(new Color(119, 136, 153));
		panel_1_2_5.setBounds(10, 39, 612, 261);
		panel_11.add(panel_1_2_5);
		
		JCheckBox chckbxHighbridBatteryService_5 = new JCheckBox("Highbrid battery service");
		chckbxHighbridBatteryService_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryService_5.setBounds(6, 20, 266, 36);
		panel_1_2_5.add(chckbxHighbridBatteryService_5);
		
		JLabel lblNewLabel_1_3_1_4 = new JLabel("10 000");
		lblNewLabel_1_3_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_4.setBounds(278, 25, 93, 27);
		panel_1_2_5.add(lblNewLabel_1_3_1_4);
		
		JCheckBox chckbxHighbridBatteryService_1_4 = new JCheckBox("Highbrid battery repaire");
		chckbxHighbridBatteryService_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryService_1_4.setBounds(6, 68, 266, 36);
		panel_1_2_5.add(chckbxHighbridBatteryService_1_4);
		
		JLabel lblNewLabel_1_1_1_2_5 = new JLabel("10 000");
		lblNewLabel_1_1_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_5.setBounds(278, 73, 93, 27);
		panel_1_2_5.add(lblNewLabel_1_1_1_2_5);
		
		JCheckBox chckbxHighbridBatteryReplace_4 = new JCheckBox("Highbrid battery replace");
		chckbxHighbridBatteryReplace_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHighbridBatteryReplace_4.setBounds(6, 115, 266, 36);
		panel_1_2_5.add(chckbxHighbridBatteryReplace_4);
		
		JLabel lblNewLabel_1_2_1_2_5 = new JLabel("10 000");
		lblNewLabel_1_2_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_2_5.setBounds(278, 120, 93, 27);
		panel_1_2_5.add(lblNewLabel_1_2_1_2_5);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("Other Specialized Sevices");
		lblNewLabel_5_1_2_1.setOpaque(true);
		lblNewLabel_5_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_1_2_1.setBounds(348, 0, 253, 46);
		panel_7.add(lblNewLabel_5_1_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pasindu Maduranga\\eclipse-workspace\\custompackage\\img\\bg(1).png"));
		lblNewLabel_4.setBounds(10, 10, 966, 743);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		
	}
}
