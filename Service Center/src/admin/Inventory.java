package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.event.ActionEvent;

public class Inventory {

	private JFrame frame;
	private JTable table;
	private JTextField txtqty;
	private JTextField txtprice;
	private JTextField txtname;
	private Object[] row ;
	
	
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();
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
	public Inventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(172, 0, 420, 195);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 420, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] columns = {"Item ID" , "Item name" , "Item Quantity" ,"Item Price"};
		model.setColumnIdentifiers(columns);
		table.setAutoCreateRowSorter(true);
		table.setModel(model);

		row = new Object[4];
		 try {  
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
			    Statement stmt = con.createStatement();				
			    String sql="SELECT * FROM `item` WHERE 1";
				ResultSet rs=stmt.executeQuery(sql);
				while (rs.next()) {
					
					row[0] = rs.getString("item_id");
					row[1] = rs.getString("Item_name");
					row[2] = rs.getString("item_qty");
					row[3] = rs.getString("item_price");
					model.addRow(row);
					}
				con.close();
			 } 			
		 catch(Exception e1) {
				System.out.print(e1);
			 }
	
		table.getColumnModel().getColumn(0).setPreferredWidth(6);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(0, 0, 173, 337);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item Name");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 22, 80, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lbqty = new JLabel("Item Quantity");
		lbqty.setBounds(10, 79, 80, 14);
		panel_1.add(lbqty);
		
		JLabel lblprice = new JLabel("Item Price");
		lblprice.setBounds(10, 135, 80, 14);
		panel_1.add(lblprice);
		
		txtqty = new JTextField();
		txtqty.setBounds(77, 104, 86, 20);
		panel_1.add(txtqty);
		txtqty.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(77, 160, 86, 20);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(77, 47, 86, 20);
		panel_1.add(txtname);
		txtname.setColumns(10);
		
		JButton btnnewitem = new JButton("New Item");
		btnnewitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert() ;
			}
		});
		btnnewitem.setBounds(74, 222, 99, 23);
		panel_1.add(btnnewitem);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(172, 192, 424, 145);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
	}
	private void insert() {
		   int itemqty = 0;
		   int itemprice = 0;
		   String itemname;
		   
		   
		   try {
			   
			   itemqty = Integer.parseInt(txtqty.getText());
			   itemname = txtname.getText();
			   itemprice = Integer.parseInt(txtprice.getText());
	       	    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
				 String query1 = "INSERT INTO `item`( `Item_name`, `item_qty`, `item_price`) VALUES ('"+itemname +"',"+itemqty+","+itemprice+")";
	             Statement ps = con.prepareStatement(query1);
	             ps.executeUpdate(query1);
	             
	             JOptionPane.showMessageDialog(null, "Item Information Update");
	            
	             
	             
	             
	             
	             
	             
	             con.close();
	           
	       } catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
	       }
	   }

	public void setVisible(boolean b) {
		Inventory window = new Inventory();
		window.frame.setVisible(true);
		
	}

	
	   


}
