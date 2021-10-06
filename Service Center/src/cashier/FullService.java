	
package cashier;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DateFormatter;
	
public class FullService {
	
//	private static String Time = null;
//	private static String Date = null;
	String customerID;
	String cname = CustomerInfo.cname;
	String cadd = CustomerInfo.cadd;
	int ctp = CustomerInfo.ctp;
	String vbrand = CustomerInfo.vbrand;
	String vmodel = CustomerInfo.vmodel;
	String vno = CustomerInfo.vno;
		

	int subtotal1=0;
	int subtotal2=0;
	int subtotal3=0;
	int subtotal4=0;
	int subtotal5=0;
	int total=0;
	int subttl1=0;
	int subttl2=0;
	int subttl3=0;
	int subttl4=0;
	int subttl5=0;
	
	
	public JFrame frame1 = new JFrame();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	private JPanel panel10 = new JPanel();
	private JPanel panel11 = new JPanel();
	private JLabel label0 = new JLabel("FULL  SERVICE  PACKAGE");
	private JLabel label00 = new JLabel("<html><i>Improve your car durability in five categories...</i></html>");
	private JLabel labe0l00 = new JLabel();
	private JLabel label1 = new JLabel("  - DETAILED WASH");
	
	private JLabel label3 = new JLabel("Package Price");
	private JLabel label4 = new JLabel("LKR  0");
	private JLabel label5 = new JLabel("<html>Description : An optimum option for cleaning your car covering Body, Carpets,<br/>"
										+"Glasses, Dash and Interrior </html>");
	
	private JLabel label6 = new JLabel("  - FUEL SYSTEM CLEANING");
	private JLabel label7 = new JLabel("Package Price");
	private JLabel label8 = new JLabel("");
	
	private JLabel label9 = new JLabel(" LKR  0");
	
	private JLabel label10 = new JLabel("<html>Description : Fuel system cleaning which removes the build-up of dirt in fuel<br/>"
			+"system and helps improve your car performance</html>");
	private JLabel label11 = new JLabel("  - BATTERY TEST");
	private JLabel label12 = new JLabel("<html>- High / Low Voltage Detection<br/><br/>"
			+ "- Health Checking Of Battery<br/><br/>"
			+ "- Battery Power Check</html>");
	private JLabel label13 = new JLabel("Package Price");
	private JLabel label14 = new JLabel("LKR  0");
	private JLabel label15 = new JLabel("  - ENGINE SCANNING");
	private JLabel label16 = new JLabel("<html>- Accessential Engine Check</html>");
	private JLabel label17 = new JLabel("Package Price");
	private JLabel label18 = new JLabel("LKR  0");
	private JLabel label19 = new JLabel("<html>Description : Quick diagnosing and fixing engine malfunctions. Identify correct<br/>"
			+" faults in engine using best diagnostic tools helps improve your car performance</html>");
	private JLabel label20 = new JLabel("  - EXTERRIOR WAXING");
	private JLabel label21 = new JLabel("Package Price");
	private JLabel label22 = new JLabel("LKR  0");
	private JLabel label23 = new JLabel(" LKR  TOTAL ");
	private JLabel label24 = new JLabel("<html>Description : Provides a high-gloss finish to new of old car paint applying a hard <br/>"
			+"wax layer protect the paint for longer</html>");
	private JLabel label25 = new JLabel("TOTAL Price");
	private JLabel label26 = new JLabel("LKR  0");
	private JScrollPane scroll = new JScrollPane(panel2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				 								ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private JLabel img1 = new JLabel("");
	private JLabel img2 = new JLabel("");
	private JLabel img3 = new JLabel("");
	private JLabel img4 = new JLabel("");
	private JLabel img5 = new JLabel("");
	
	private JButton button1 = new JButton("Calculate Total");
	private JButton button2 = new JButton("CONFIRM PURCHASE");
	private JButton button3 = new JButton("Back");
	private JButton button4 = new JButton("New Customer");
	
	DefaultTableModel model1 = new DefaultTableModel(); 
	private JTable table1 = new JTable (model1);
	DefaultTableModel model2 = new DefaultTableModel();
	private JTable table2 = new JTable (model2);
	DefaultTableModel model3 = new DefaultTableModel();
	private JTable table3 = new JTable (model3);
	DefaultTableModel model4 = new DefaultTableModel();
	private JTable table4 = new JTable (model4);
	DefaultTableModel model5 = new DefaultTableModel();
	private JTable table5 = new JTable (model5);
	
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
	JLabel space11 = new JLabel("");
	JLabel space12 = new JLabel("");
	JLabel space13 = new JLabel("");
	JLabel space14 = new JLabel("");
	JLabel space15 = new JLabel("");
	JLabel space16 = new JLabel("");
	JLabel space17 = new JLabel("");
	JLabel space18 = new JLabel("");
	JLabel space19 = new JLabel("");
	JLabel space20 = new JLabel("");
	JLabel space21 = new JLabel("");
	JLabel space22 = new JLabel("");
	JLabel space23 = new JLabel("");
	JLabel space24 = new JLabel("");
	JLabel space25 = new JLabel("");
	JLabel space26 = new JLabel("");
	JLabel space27 = new JLabel("");
	JLabel space28 = new JLabel("");
	JLabel space = new JLabel("");
	JLabel space29 = new JLabel("");
	JLabel space30 = new JLabel("");
	JLabel space31 = new JLabel("");
	JLabel space32 = new JLabel("");
	JLabel space33 = new JLabel("");
	JLabel space34 = new JLabel("");
	
	
	JCheckBox cb1 = new JCheckBox("",false);  
	JCheckBox cb2 = new JCheckBox("",false);  
	JCheckBox cb3 = new JCheckBox("",false);
	JCheckBox cb4 = new JCheckBox("",false);
	JCheckBox cb5 = new JCheckBox("",false);
	
	JSeparator sp1 = new JSeparator();
	JSeparator sp2 = new JSeparator();
	JSeparator sp3 = new JSeparator();
	JSeparator sp4 = new JSeparator();
	JSeparator sp5 = new JSeparator();
	
	public static void main(String[] args) {
		
		FullService obj1 = new FullService();     
		obj1.starting();
		//System.out.println("hjhgj");
		
	}


//
		// TODO Auto-generated method stub
//		return cname;
//	}


	void starting() {
		
		table1.setForeground(Color.white);
		table1.setBackground(Color.black);
		table1.setFont(new Font("Serif", Font.BOLD, 30));
		table1.setRowHeight(45);
		table1.setGridColor(Color.black);
		model1.addColumn(""); 
		model1.addColumn("");   
	    table1.getColumnModel().getColumn(0).setPreferredWidth(400);
	    table1.getColumnModel().getColumn(1).setPreferredWidth(300);
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	    
		
	    table2.setForeground(Color.white);
		table2.setBackground(Color.black);
		table2.setFont(new Font("Serif", Font.BOLD, 30));
		table2.setRowHeight(45);
		table2.setGridColor(Color.black);
		model2.addColumn(""); 
		model2.addColumn("");   
	    table2.getColumnModel().getColumn(0).setPreferredWidth(400);
	    table2.getColumnModel().getColumn(1).setPreferredWidth(300);
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table2.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		
		
	    table3.setForeground(Color.white);
		table3.setBackground(Color.black);
		table3.setFont(new Font("Serif", Font.BOLD, 30));
		table3.setRowHeight(45);
		table3.setGridColor(Color.black);
		model3.addColumn(""); 
		model3.addColumn("");   
	    table3.getColumnModel().getColumn(0).setPreferredWidth(400);
	    table3.getColumnModel().getColumn(1).setPreferredWidth(300);
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table3.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	    
	    
	    table4.setForeground(Color.white);
		table4.setBackground(Color.black);
		table4.setFont(new Font("Serif", Font.BOLD, 30));
		table4.setRowHeight(45);
		table4.setGridColor(Color.black);
		model4.addColumn(""); 
		model4.addColumn("");   
	    table4.getColumnModel().getColumn(0).setPreferredWidth(400);
	    table4.getColumnModel().getColumn(1).setPreferredWidth(300);
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table4.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	    
	    table5.setForeground(Color.white);
		table5.setBackground(Color.black);
		table5.setFont(new Font("Serif", Font.BOLD, 30));
		table5.setRowHeight(45);
		table5.setGridColor(Color.black);
		model5.addColumn(""); 
		model5.addColumn("");   
	    table5.getColumnModel().getColumn(0).setPreferredWidth(400);
	    table5.getColumnModel().getColumn(1).setPreferredWidth(300);
	    rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    table5.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
	    
		displayingServices();
		
		//panel1.setPreferredSize(new Dimension(100, 50));
		panel1.setBackground(Color.black);
		
		panel2.setPreferredSize(new Dimension(1100, 4500));
		panel2.setBackground(Color.black);
		//panel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		panel2.setBounds(100,100,1083,694);
		
		
		panel3.setPreferredSize(new Dimension(900,110));
		panel3.setBackground(Color.black);
		panel3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.yellow));
		//panel3.setMaximumSize(new Dimension(panel3.getMaximumSize().height, panel3.getPreferredSize().width));
		//panel3.setLayout(new GridLayout(5,20,0,0));
		
		panel4.setPreferredSize(new Dimension(650, 80));
		panel4.setBackground(Color.black);
		panel4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
		
		panel5.setPreferredSize(new Dimension(700, 480));
		panel5.setBackground(Color.black);
		panel5.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		
		panel6.setPreferredSize(new Dimension(900, 110));
		panel6.setBackground(Color.black);
		panel6.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
		
		panel7.setPreferredSize(new Dimension(700, 380));
		panel7.setBackground(Color.black);
		panel7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		
		panel8.setPreferredSize(new Dimension(700, 390));
		panel8.setBackground(Color.black);
		panel8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		
		panel9.setPreferredSize(new Dimension(900, 110));
		panel9.setBackground(Color.black);
		panel9.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#FC03ED")));
		
		panel10.setPreferredSize(new Dimension(700, 440));
		panel10.setBackground(Color.black);
		panel10.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		
		panel11.setPreferredSize(new Dimension(900, 110));
		panel11.setBackground(Color.black);
		panel11.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
		
		
		scroll.setPreferredSize(new Dimension(1070, 700));
		//scroll.setBounds(100,100,1083,694);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		
		label0.setFont(new Font("arial", Font.BOLD, 50));
		label0.setForeground (Color.decode("#03FCF4"));
		label0.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		label00.setFont(new Font("arial", Font.BOLD, 26));
		label00.setForeground (Color.decode("#FC0B03"));
		label00.setBorder(BorderFactory.createEmptyBorder(10, 0, 40, 0));
		
		labe0l00.setBackground (Color.green);
		labe0l00.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
		
		label1.setFont(new Font("arial", Font.BOLD, 40));
		label1.setForeground (Color.yellow);
		label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label3.setFont(new Font("arial", Font.BOLD, 30));
		label3.setForeground (Color.yellow);
		label3.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		label4.setFont(new Font("arial", Font.BOLD, 30));
		label4.setForeground (Color.yellow);
		label4.setBorder(BorderFactory.createEmptyBorder(20, 340, 20, 0));
		
		label5.setFont(new Font("arial", Font.PLAIN, 24));
		label5.setForeground (Color.white);
		label5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		label6.setFont(new Font("arial", Font.BOLD, 40));
		label6.setForeground(Color.decode("#FC1A03"));
		label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label7.setFont(new Font("arial", Font.BOLD, 30));
		label7.setForeground (Color.red);
		label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label8.setFont(new Font("arial", Font.BOLD, 24));
		label8.setForeground (Color.green);
		label8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label9.setFont(new Font("arial", Font.BOLD, 30));
		label9.setForeground (Color.decode("#FC1A03"));
		label9.setBorder(BorderFactory.createEmptyBorder(20, 340, 20, 0));
		
		label10.setFont(new Font("arial", Font.PLAIN, 24));
		label10.setForeground (Color.white);
		label10.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		label11.setFont(new Font("arial", Font.BOLD, 40));
		label11.setForeground(Color.decode("#FC6503"));
		label11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label12.setFont(new Font("arial", Font.BOLD, 20));
		label12.setForeground (Color.white);
		label12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label13.setFont(new Font("arial", Font.BOLD, 30));
		label13.setForeground (Color.decode("#FC6503"));
		label13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label14.setFont(new Font("arial", Font.BOLD, 30));
		label14.setForeground (Color.decode("#FC6503"));
		label14.setBorder(BorderFactory.createEmptyBorder(20, 340, 20, 0));
		
		label15.setFont(new Font("arial", Font.BOLD, 40));
		label15.setForeground(Color.decode("#FC03ED"));
		label15.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label16.setFont(new Font("arial", Font.BOLD, 20));
		label16.setForeground (Color.white);
		label16.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label17.setFont(new Font("arial", Font.BOLD, 30));
		label17.setForeground (Color.decode("#FC03ED"));
		label17.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label18.setFont(new Font("arial", Font.BOLD, 30));
		label18.setForeground (Color.decode("#FC03ED"));
		label18.setBorder(BorderFactory.createEmptyBorder(20, 330, 20, 0));
		
		label19.setFont(new Font("arial", Font.PLAIN, 24));
		label19.setForeground (Color.white);
		label19.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		label20.setFont(new Font("arial", Font.BOLD, 40));
		label20.setForeground(Color.decode("#03FCFC"));
		label20.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label21.setFont(new Font("arial", Font.BOLD, 30));
		label21.setForeground (Color.decode("#03FCFC"));
		label21.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		label22.setFont(new Font("arial", Font.BOLD, 30));
		label22.setForeground (Color.decode("#03FCFC"));
		label22.setBorder(BorderFactory.createEmptyBorder(20, 340, 20, 10));
		
		label23.setFont(new Font("arial", Font.BOLD, 24));
		label23.setForeground (Color.decode("#03FCFC"));
		label23.setBorder(BorderFactory.createEmptyBorder(20, 520, 20, 0));
		
		label24.setFont(new Font("arial", Font.PLAIN, 24));
		label24.setForeground (Color.white);
		label24.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		label25.setFont(new Font("arial", Font.BOLD, 40));
		label25.setForeground (Color.yellow);
		label25.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));
		
		label26.setFont(new Font("arial", Font.BOLD, 40));
		label26.setForeground (Color.green);
		label26.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));
		
		img1.setIcon(new ImageIcon("src\\Images\\wash.jpg"));
		img1.setPreferredSize(new Dimension(350, 250));
		img1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow));
		
		img2.setIcon(new ImageIcon("src\\Images\\fuel.jpg"));
		img2.setPreferredSize(new Dimension(350, 250));
		img2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#FC1A03")));
		
		img3.setIcon(new ImageIcon("src\\Images\\battery.jpg"));
		img3.setPreferredSize(new Dimension(350, 250));
		img3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#FC6503")));
		
		img4.setIcon(new ImageIcon("src\\Images\\engine.jpg"));
		img4.setPreferredSize(new Dimension(350, 250));
		img4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#FC03ED")));
		
		img5.setIcon(new ImageIcon("src\\Images\\exterrior.jpg"));
		img5.setPreferredSize(new Dimension(350, 250));
		img5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#03FCFC")));
		
		
		button1.setFont(new Font("Arial", Font.BOLD, 20));
		button1.setForeground (Color.BLACK);
		button1.setBackground (Color.orange);
		button1.setFocusPainted(false);
		button1.setPreferredSize(new Dimension(250, 40));
		
		button2.setFont(new Font("Arial", Font.BOLD, 20));
		button2.setForeground (Color.BLACK);
		button2.setBackground (Color.green);
		button2.setFocusPainted(false);
		button2.setPreferredSize(new Dimension(250, 40));
		button2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		button3.setFont(new Font("Arial", Font.BOLD, 20));
		button3.setForeground (Color.BLACK);
		button3.setBackground (Color.BLUE);
		button3.setFocusPainted(false);
		button3.setPreferredSize(new Dimension(180, 40));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		space1.setPreferredSize(new Dimension(160, 10));
		space2.setPreferredSize(new Dimension(11000, 10));
		space3.setPreferredSize(new Dimension(1100, 10));
		space4.setPreferredSize(new Dimension(1100, 20));
		space5.setPreferredSize(new Dimension(20, 10));
		space6.setPreferredSize(new Dimension(800, 10));
		space7.setPreferredSize(new Dimension(1100, 10));
		space8.setPreferredSize(new Dimension(1100, 100));
		space9.setPreferredSize(new Dimension(1100, 10));
		space10.setPreferredSize(new Dimension(1100, 10));
		space11.setPreferredSize(new Dimension(220, 10));
		space12.setPreferredSize(new Dimension(800, 10));
		space13.setPreferredSize(new Dimension(1100, 10));
		space14.setPreferredSize(new Dimension(125, 10));
		space15.setPreferredSize(new Dimension(1100, 10));
		space16.setPreferredSize(new Dimension(1100, 10));
		space17.setPreferredSize(new Dimension(200, 50));
		space18.setPreferredSize(new Dimension(1100, 80));
		space19.setPreferredSize(new Dimension(1100, 100));
		space20.setPreferredSize(new Dimension(300, 50));
		space21.setPreferredSize(new Dimension(1100, 100));
		space22.setPreferredSize(new Dimension(1100, 20));
		space23.setPreferredSize(new Dimension(1100, 100));
		space24.setPreferredSize(new Dimension(140, 10));
		space25.setPreferredSize(new Dimension(1100, 20));
		space26.setPreferredSize(new Dimension(1100, 20));
		space27.setPreferredSize(new Dimension(800, 50));
		space28.setPreferredSize(new Dimension(1100, 20));
		space.setPreferredSize(new Dimension(1100, 10));
		space29.setPreferredSize(new Dimension(1100, 10));
		space30.setPreferredSize(new Dimension(1100, 10));
		space31.setPreferredSize(new Dimension(1100, 10));
		space32.setPreferredSize(new Dimension(1100, 10));
		space33.setPreferredSize(new Dimension(30, 10));
		space34.setPreferredSize(new Dimension(30, 10));
		
		
		cb1.setPreferredSize(new Dimension(20, 20));
	    cb1.setOpaque(true);
		cb1.setBorderPainted(true);
	    cb1.setBorder(BorderFactory.createLineBorder(Color.green));
	    cb1.setBackground (Color.white);
	    
	    cb2.setPreferredSize(new Dimension(20, 20));
	    cb2.setOpaque(true);
		cb2.setBorderPainted(true);
	    cb2.setBorder(BorderFactory.createLineBorder(Color.green));
	    cb2.setBackground (Color.white);
	    
	    cb3.setPreferredSize(new Dimension(20, 20));
	    cb3.setOpaque(true);
		cb3.setBorderPainted(true);
	    cb3.setBorder(BorderFactory.createLineBorder(Color.green));
	    cb3.setBackground (Color.white);
	    
	    cb4.setPreferredSize(new Dimension(20, 20));
	    cb4.setOpaque(true);
		cb4.setBorderPainted(true);
	    cb4.setBorder(BorderFactory.createLineBorder(Color.green));
	    cb4.setBackground (Color.white);
	    
	    cb5.setPreferredSize(new Dimension(20, 20));
	    cb5.setOpaque(true);
		cb5.setBorderPainted(true);
	    cb5.setBorder(BorderFactory.createLineBorder(Color.green));
	    cb5.setBackground (Color.white);
	    
	    sp1.setOrientation(SwingConstants.HORIZONTAL);
	    sp1.setPreferredSize(new Dimension(950,20));
	    sp1.setBackground(Color.yellow);
	    
	    sp2.setOrientation(SwingConstants.HORIZONTAL);
	    sp2.setPreferredSize(new Dimension(950,20));
	    sp2.setBackground(Color.red);
	    
	    sp3.setOrientation(SwingConstants.HORIZONTAL);
	    sp3.setPreferredSize(new Dimension(950,20));
	    sp3.setBackground(Color.decode("#FC6503"));
	    
	    sp4.setOrientation(SwingConstants.HORIZONTAL);
	    sp4.setPreferredSize(new Dimension(950,20));
	    sp4.setBackground(Color.decode("#FC03ED"));
	    
	    sp5.setOrientation(SwingConstants.HORIZONTAL);
	    sp5.setPreferredSize(new Dimension(950,20));
	    sp5.setBackground(Color.decode("#03FCFC"));
	    
	    
		//frame1.setSize(800,620);
		frame1.setResizable(false);
		frame1.setBounds(100,100,1083,694);
		
		panel2.add(label0);
		
		button4.setFont(new Font("Arial", Font.BOLD, 15));
		button4.setForeground (Color.BLACK);
		button4.setBackground (Color.RED);
		button4.setFocusPainted(false);
		button4.setPreferredSize(new Dimension(150, 40));
		
		panel2.add(label00);
		
		panel1.add(scroll);
		
		panel2.add(space);
		panel2.add(cb1);
		panel2.add(label1);
		panel2.add(space1);
		panel2.add(img1);
		panel2.add(space2);
		panel2.add(table1);
		panel2.add(space3);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(space4);
		panel3.add(label5);
		panel2.add(panel3);
		panel2.add(space23);
		
		panel2.add(sp1);
		
		panel2.add(space29);
		panel2.add(cb2);
		panel2.add(label6);
		panel2.add(space5);
		panel2.add(img2);
		panel2.add(space6);
		panel2.add(table2);
		panel2.add(space7);
		panel2.add(label7);
		panel2.add(label9);
		panel6.add(label10);
		panel2.add(space22);
		panel2.add(panel6);
		panel2.add(space8);
		
		panel2.add(sp2);
		
		panel2.add(space30);
		panel2.add(cb3);
		panel2.add(label11);
		panel2.add(space11);
		panel2.add(img3);
		panel2.add(space9);
		panel2.add(table3);
		panel2.add(space10);
		panel2.add(label13);
		panel2.add(label14);
		panel2.add(space18);
		
		panel2.add(sp3);
		
		panel2.add(space31);
		panel2.add(cb4);
		panel2.add(label15);
		panel2.add(space24);
		panel2.add(img4);
		panel2.add(space12);
		panel2.add(table4);
		panel2.add(space13);
		panel2.add(label17);
		panel2.add(label18);
		panel2.add(space25);
		panel9.add(label19);
		panel2.add(panel9);
		panel2.add(space19);
		
		panel2.add(sp4);
		
		panel2.add(space32);
		panel2.add(cb5);
		panel2.add(label20);
		panel2.add(space14);
		panel2.add(img5);
		panel2.add(space15);
		panel2.add(table5);
		panel2.add(space16);
		panel2.add(label21);
		panel2.add(label22);
		panel2.add(space26);
		panel11.add(label24);
		panel2.add(panel11);
		
		
		panel2.add(space21);
		
		panel2.add(sp5);
		
		panel2.add(label25);
		panel2.add(space20);
		panel2.add(label26);
		panel2.add(space28);
		
		panel2.add(button3);
		panel2.add(space33);
		panel2.add(button1);
		panel2.add(space34);
		panel2.add(button2);
		panel2.add(button4);
		
		frame1.getContentPane().add(panel1);
		frame1.setVisible(true);
		
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				billPrinting();

			}
			
			
		});
		
		
		
		
	}

	
	private void displayingServices() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/carservice","root","12345");
			
			Statement stmt=conn.createStatement();
			
			String sql1 = "SELECT * FROM service WHERE servicecat='detailed wash'";
			ResultSet rs1 = stmt.executeQuery(sql1);
			
			//System.out.println("until rs1");
			
				while (rs1.next()) {
					model1.addRow(new Object[]{"-  "+rs1.getString(2),"LKR     "+rs1.getString(4)});
					subtotal1 = subtotal1 + rs1.getInt(4);
					
					//System.out.println("Connected from 2");	
				}
			
			String sql2 = "SELECT * FROM service WHERE servicecat='fuel system cleaning'";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
				while (rs2.next()) {
					model2.addRow(new Object[]{"-  "+rs2.getString(2),"LKR     "+rs2.getString(4)});
					subtotal2 = subtotal2 + rs2.getInt(4);
				}
			
			String sql3 = "SELECT * FROM service WHERE servicecat='battery test'";
			ResultSet rs3 = stmt.executeQuery(sql3);
			
				while (rs3.next()) {
					model3.addRow(new Object[]{"-  "+rs3.getString(2),"LKR     "+rs3.getString(4)});
					subtotal3 = subtotal3 + rs3.getInt(4);
				}
			
			String sql4 = "SELECT * FROM service WHERE servicecat='engine scanning'";
			ResultSet rs4 = stmt.executeQuery(sql4);
			
				while (rs4.next()) {
					model4.addRow(new Object[]{"-  "+rs4.getString(2),"LKR     "+rs4.getString(4)});
					subtotal4 = subtotal4 + rs4.getInt(4);
				}
			
			String sql5 = "SELECT * FROM service WHERE servicecat='exterrior waxing'";
			ResultSet rs5 = stmt.executeQuery(sql5);
			
				while (rs5.next()) {
					model5.addRow(new Object[]{"-  "+rs5.getString(2),"LKR     "+rs5.getString(4)});
					subtotal5 = subtotal5 + rs5.getInt(4);
				}
			
		}catch (SQLException | ClassNotFoundException e2) {
					System.out.println("Error from 2");	
		}
	
	
		cb1.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	subttl1 = subtotal1;
		        	label4.setText("LKR   "+String.valueOf(subttl1));
		        	
		        } else {
		        	
		        	subttl1 = 0;
		        	label4.setText("LKR   "+String.valueOf(subttl1));
		        
		        }
		    }
		});
		
		cb2.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	subttl2 = subtotal2;
		        	label9.setText("LKR   "+String.valueOf(subttl2));
		        	
		        } else {
		        	
		        	subttl2 = 0;
		        	label9.setText("LKR   "+String.valueOf(subttl2));
		        	
		        }
		    }
		});
		
		cb3.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	subttl3 = subtotal3;
		        	label14.setText("LKR   "+String.valueOf(subttl3));
		        	
		        } else {
		        	
		        	subttl3 = 0;
		        	label14.setText("LKR   "+String.valueOf(subttl3));
		        	
		        };
		    }
		});
		
		cb4.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	subttl4 = subtotal4;
		        	label18.setText("LKR   "+String.valueOf(subttl4));
		        	
		        } else {
		        	
		        	subttl4 = 0;
		        	label18.setText("LKR   "+String.valueOf(subttl4));
		        	
		        }
		    }
		});
		
		cb5.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	subttl5 = subtotal5;
		        	label22.setText("LKR   "+String.valueOf(subttl5));
		        	
		        } else {
		        	
		        	subttl5 = 0;
		        	label22.setText("LKR   "+String.valueOf(subttl5));
		        	
		        };
		    }
		});
		
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				total = subttl1 + subttl2 + subttl3 + subttl4 + subttl5 ;
				label26.setText("LKR  "+String.valueOf(total));	
			}
		
		});
		
		button3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
		
				FullService obj = new FullService();
				obj.toBack();
		
	}
		});
		
		button4.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
		
				Cashier c = new Cashier();
				c.setVisible(true);
				frame1.setVisible(false);
				
				
		
	}
		});
		
		
		
	}
	
	void billPrinting() {
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		LocalDateTime now = LocalDateTime.now();
//        Date = java.time.LocalDate.now().toString();
//        Time = java.time.LocalTime.now().toString();
		
        int billCount = new File("C:\\Users\\user\\Documents\\Java\\teamR Local\\Service Center\\bill\\").list().length;
        int invoiceNo = billCount+1;
        
        Component frame3 = null;
		if(total>0) {
        
	        try{    
	              
	            String firstpart = "| ===================== |"+"\n"+
	            		"Four Wheel Auto Center"+"\n"+"32/B"+"\n"+"Queen's Road"+"\n"+"Colombo 7"+"\n"+
	            		"Contact No - 0362548791"+"\n"+"| ===================== |"+"\n"+"\n"+
	            		//"Date - "+Date+"\n"+
	            		//"Time - "+Time+"\n"+
	            		"Invoice No - "+invoiceNo+"\n"+"\n"+
	            		"| ================|"+"\n"+"\n"+
	            		"CustomerID - "+customerID+"\n"+
	            		"Name - "+cname+"\n"+
	            		"Address - "+cadd+"\n"+
	            		"TP - "+ctp+"\n"+"\n"+
	            		"| ================|"+"\n"+"\n"+
	            		"Vehicle Brand - "+vbrand+"\n"+
	            		"Vehicle Model - "+vmodel+"\n"+
	            		"Vehicle Reg No - "+vno+"\n"+"\n"+
	            		"| ================|"+"\n"+"\n";

	            BufferedWriter bfw = new BufferedWriter(new FileWriter("C:\\Users\\user\\Documents\\Java\\teamR Local\\Service Center\\bill\\"+invoiceNo+".txt"));
	      	  
	            bfw.write(firstpart);
	           
	            if(cb1.isSelected()) {
	            
	            	bfw.write("| Detailed Wash |");
	            	bfw.newLine();
	            	bfw.newLine();
	            	  
	            	for (int row = 0; row < table1.getRowCount(); row++) {
	            		 for (int col = 0; col < table1.getColumnCount(); col++) {
	            	  
	            		    	bfw.write(table1.getValueAt(row,col).toString()+"   ");
	            		    }
	            		    
	            		    bfw.newLine();    
	            	  }
	            	  
	            }
	            
	          
	            if(cb2.isSelected()) {
	                
	        	  bfw.newLine();
	          	  bfw.write("| Fuel System Cleaning |");
	          	  bfw.newLine();
	          	  bfw.newLine();
	          	  
	          	  for (int row = 0; row < table2.getRowCount(); row++) {
	          		    for (int col = 0; col < table2.getColumnCount(); col++) {
	          	  
	          		    	bfw.write(table2.getValueAt(row,col).toString()+"   ");
	          		    }
	          		    
	          		    bfw.newLine();
	          	  }
	
	            }
	            
	            
	            if(cb3.isSelected()) {
	                
	            	  bfw.newLine();
	            	  bfw.write("| Battery Test |");
	            	  bfw.newLine();
	            	  bfw.newLine();
	            	  
	            	  for (int row = 0; row < table3.getRowCount(); row++) {
	            		    for (int col = 0; col < table3.getColumnCount(); col++) {
	            	  
	            		    	bfw.write(table3.getValueAt(row,col).toString()+"   ");
	            		    }
	            		    
	            		    bfw.newLine();
	            	  }
	
	             }
	             
	            
	            if(cb4.isSelected()) {
	                
	            	  bfw.newLine();
	            	  bfw.write("| Engine Scanning |");
	            	  bfw.newLine();
	            	  bfw.newLine();
	            	  
	            	  for (int row = 0; row < table4.getRowCount(); row++) {
	            		    for (int col = 0; col < table4.getColumnCount(); col++) {
	            	  
	            		    	bfw.write(table4.getValueAt(row,col).toString()+"   ");
	            		    }
	            		    bfw.newLine(); 
	            	  }
	
	             }
	            
	            
	            if(cb5.isSelected()) {
	                
	            	  bfw.newLine();
	            	  bfw.write("| Exterrior Waxing |");
	            	  bfw.newLine();
	            	  bfw.newLine();
	            	  
	            	  for (int row = 0; row < table5.getRowCount(); row++) {
	            		    for (int col = 0; col < table5.getColumnCount(); col++) {
	            	  
	            		    	bfw.write(table5.getValueAt(row,col).toString()+"   ");
	            		    }
	            		    bfw.newLine();
	            	  }
	
	             }
	            
	            
	            String finalpart = "\n"+"| Total Price Is : LKR"+total+" |"+"\n"+"\n"+
	            "| ===================== |"+"\n"+
	            "Thanking For Choosing US!"+"\n"+
	            "Have a nice day!"+"\n"+
	            "| ===================== |"+"\n"+
	            "Developed By TeamR";
	              
	             bfw.write(finalpart);
	            bfw.close();
	             
	           // System.out.println("Success..."); 
	            
	            String text;
	            
	            try { text = new String(Files.readAllBytes(Paths.get("C:\\Users\\user\\Documents\\Java\\teamR Local\\Service Center\\bill\\"+invoiceNo+".txt"))); 
	            
	            System.out.println(text);
	            JOptionPane.showMessageDialog(frame3,text,"Invoice Created Successfully!",JOptionPane.INFORMATION_MESSAGE);	
						
	            
	            } catch (Exception e) {
	            	
	            e.printStackTrace();
	            }
	
	       
	        }catch(Exception e){
	        	
	        	   System.out.println(e);
	        }    
 
           
        }
        else {
        	JOptionPane.showMessageDialog(frame3,"No Services Selected. Total Prise is 0","No Selections?",JOptionPane.INFORMATION_MESSAGE);	
		}
		
	}
	
	void toBack() {
		
		frame1.dispose();
		frame1.setVisible(false);
		CustomerInfo obj = new CustomerInfo();
		obj.starting();
		
		}


	public void setVisible(boolean b) {
//		FullService window = new FullService();
//		frame1.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}
	
}