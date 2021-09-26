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
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Inventory {

	private JFrame frame;
	private JTable table;
	private JTextField txtqty;
	private JTextField txtprice;
	private JTextField txtname;
	private JLabel lblmsg;
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
		frame.setBounds(100, 100, 1083, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(258, 0, 809, 366);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 809, 366);
		panel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] columns = {"Item ID" , "Item name" , "Item Quantity" ,"Item Price"};
		model.setColumnIdentifiers(columns);
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
		viewDetails();		
	
		table.getColumnModel().getColumn(0).setPreferredWidth(6);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory Details Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 17), new java.awt.Color(255, 255, 255))); 
	      
		panel_1.setBounds(0, 0, 258, 655);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item Name :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 61, 119, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lbqty = new JLabel("Item Quantity :");
		lbqty.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbqty.setBounds(10, 145, 119, 23);
		panel_1.add(lbqty);
		
		JLabel lblprice = new JLabel("Item Price :");
		lblprice.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblprice.setBounds(10, 229, 99, 20);
		panel_1.add(lblprice);
		
		txtqty = new JTextField();
		txtqty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtqty.setBounds(77, 179, 126, 39);
		panel_1.add(txtqty);
		txtqty.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtprice.setBounds(77, 271, 126, 39);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtname.setBounds(77, 94, 126, 40);
		panel_1.add(txtname);
		txtname.setColumns(10);
		
		JButton btnnewitem = new JButton("New Item");
		btnnewitem.setForeground(new Color(255, 255, 255));
		btnnewitem.setBackground(new Color(0, 139, 139));
		btnnewitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insert();
        		DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				viewDetails();
			}
		});
		btnnewitem.setBounds(77, 374, 119, 39);
		panel_1.add(btnnewitem);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBackground(new Color(0, 139, 139));
		btnClear.setBounds(77, 448, 119, 39);
		panel_1.add(btnClear);
		
		lblmsg = new JLabel("");
		lblmsg.setForeground(new Color(255, 0, 0));
		lblmsg.setBounds(77, 336, 171, 22);
		panel_1.add(lblmsg);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 17), new java.awt.Color(255, 255, 255)));
		panel_2.setBounds(258, 365, 809, 290);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBackground(new Color(102, 205, 170));
		btnDelete.setBounds(10, 54, 119, 39);
		panel_2.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
        		DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				viewDetails();
			}
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(102, 205, 170));
		btnUpdate.setBounds(167, 54, 119, 39);
		panel_2.add(btnUpdate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, 212, 809, 78);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Inventory.class.getResource("/image/Car_logos.png")));
		lblNewLabel_1.setBounds(181, 0, 618, 74);
		panel_3.add(lblNewLabel_1);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin adm = new Admin();
		        adm.setVisible(true);
		        frame.setVisible(false);
		        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(new Color(102, 205, 170));
		btnback.setBounds(656, 54, 110, 39);
		panel_2.add(btnback);
	}
	private void insert() {
		   int itemqty = 0;
		   int itemprice = 0;
		   String itemname;
		   if(txtname.getText().length() == 0 ) {
		    	lblmsg.setText("Please Enter a Item name");
		    }
		    
		    
		    else if(txtqty.getText().length() ==0) {
		    	lblmsg.setText("Please Enter Item quantity");
		    }
		    else if(txtprice.getText().length() ==0) {
		    	lblmsg.setText("Please Enter Price");
		    }
		    else {
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
	             lblmsg.setText("");
                 txtname.setText("");
                 txtqty.setText("");
                 txtprice.setText("");
                 con.close();
	             
	             
	            } 
		   catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
	       
		                       }
		   }
	   }
	
	private void viewDetails() {
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
	}
	
	private void clear() {
		lblmsg.setText("");
        txtname.setText("");
        txtqty.setText("");
        txtprice.setText("");
        
	}
	
	private void delete() {
		   int i = table.getSelectedRow();
		  
			if(i>=0) {
				
				
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
					String delRow = "delete from item where item_id ="+table.getValueAt(i,0);
		            Statement ps = con.prepareStatement(delRow);
		            ps.execute(delRow);
		           
		            JOptionPane.showMessageDialog(null, "Item  " +table.getValueAt(i,1) +" Deleted");
		            model.removeRow(i);
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
			}
			else {
				JOptionPane.showMessageDialog(frame,"Please select a Item");
			}
		   
	   }
	
	private void update() {
	      
	      int i = table.getSelectedRow();
	      int j = table.getSelectedColumn();
	      if(i>=0) {
		    
	    	  try {
	    		       Class.forName("com.mysql.cj.jdbc.Driver");
       		           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
	            if(j == 1) {
	    	  
	    	           String itemnewname = JOptionPane.showInputDialog("Enter new name");
	    	           String query = "UPDATE `item` SET `Item_name`='"+itemnewname+"' WHERE `item_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Item new name Update");
	    	           
	    	  
	            }
	            else if(j == 2){
	    	           String itemnewqty = JOptionPane.showInputDialog("Enter new Address");
	    	           String query = "UPDATE `employee` SET `item_qty`='"+itemnewqty+"' WHERE `item_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Item new quantity Update");
	            }
	            else if(j == 3){
	    	           String itemnewprice = JOptionPane.showInputDialog("Enter new Price");
	    	           String query = "UPDATE `employee` SET `item_price`='"+itemnewprice+"' WHERE `item_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Item new price Update");
	    	           
	            }
	      
	            else {
	            	JOptionPane.showMessageDialog(frame,"Please select item  name, quantity or price ");
			    }
	            
	       }
	    	  catch(Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
	         }
	         
	         
         
	       else {
	    	  JOptionPane.showMessageDialog(frame,"Please select item  name, quantity or price ");
	       }
	
		   
 }

	public void setVisible(boolean b) {
		Inventory window = new Inventory();
		window.frame.setVisible(true);
		
	}
}
