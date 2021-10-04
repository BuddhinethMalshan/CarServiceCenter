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


import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JRadioButton;

public class Inventory extends Admin  {

	private JFrame frame;
	private JTable table;
	private JTextField txtqty;
	private JTextField txtprice;
	private JTextField txtname;
	private JLabel lblmsg;
	private Object[] row ;
	private ButtonGroup group;
	private JRadioButton rbtnitem, rbtnservice;
	private DefaultTableModel model;
	private JTextField txtcat;

	/***
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
		Object[] columns = {" " , " " , " " ,""};
		model.setColumnIdentifiers(columns);
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
	    table.getColumnModel().getColumn(0).setPreferredWidth(6);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory Details Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 17), new java.awt.Color(255, 255, 255))); 
	      
		panel_1.setBounds(0, 0, 258, 655);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item/ Service Name :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 117, 171, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lbqty = new JLabel("Item  Quantity :");
		lbqty.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbqty.setBounds(10, 201, 193, 23);
		panel_1.add(lbqty);
		
		JLabel lblprice = new JLabel("Item/Service Price :");
		lblprice.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblprice.setBounds(10, 366, 179, 20);
		panel_1.add(lblprice);
		
		txtqty = new JTextField();
		
		
		txtqty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtqty.setBounds(77, 235, 126, 39);
		panel_1.add(txtqty);
		txtqty.setColumns(10);
		
		txtprice = new JTextField();
		
		txtprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtprice.setBounds(77, 397, 126, 39);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtname.setBounds(77, 150, 126, 40);
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
		btnnewitem.setBounds(84, 493, 119, 39);
		panel_1.add(btnnewitem);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBackground(new Color(0, 139, 139));
		btnClear.setBounds(84, 557, 119, 39);
		panel_1.add(btnClear);
		
		lblmsg = new JLabel("");
		lblmsg.setForeground(new Color(255, 0, 0));
		lblmsg.setBounds(77, 447, 171, 22);
		panel_1.add(lblmsg);
		
		rbtnitem = new JRadioButton("Item");
		rbtnitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				txtqty.setEnabled(true);
				txtcat.setText("Category zero");
				txtcat.setEnabled(false);
				
			}
		});
		rbtnitem.setForeground(Color.WHITE);
		rbtnitem.setBackground(new Color(0, 139, 139));
		rbtnitem.setBounds(16, 62, 109, 23);
		
		panel_1.add(rbtnitem);
		
		rbtnservice = new JRadioButton("Service");
		rbtnservice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = new JTable();
				model = new DefaultTableModel();
				Object[] columns = {"Service ID" , "Service name" , "Service category" ,"Service Price"};
	     		model.setColumnIdentifiers(columns);
				table.setAutoCreateRowSorter(true);
				table.setModel(model);
				viewDetails();		
		
				table.getColumnModel().getColumn(0).setPreferredWidth(6);
				table.getColumnModel().getColumn(3).setPreferredWidth(10);
				scrollPane.setViewportView(table);
				
				txtcat.setEnabled(true);
				txtqty.setText("0");
				txtqty.setEnabled(false);
				
				
			}
		});
		rbtnservice.setBackground(new Color(0, 139, 139));
		rbtnservice.setForeground(Color.WHITE);
		rbtnservice.setBounds(139, 62, 109, 23);
		panel_1.add(rbtnservice);
		
		group = new ButtonGroup();
		group.add(rbtnservice);
		group.add(rbtnitem);
		
		JLabel lblser = new JLabel("Service Category :");
		lblser.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblser.setBounds(10, 285, 147, 22);
		panel_1.add(lblser);
		
		txtcat = new JTextField();
		txtcat.setBounds(77, 318, 126, 37);
		panel_1.add(txtcat);
		txtcat.setColumns(10);
		
	
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
		lblNewLabel_1.setIcon(new ImageIcon(Inventory.class.getResource("/images/Car_logos.png")));
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
	public void insert() {
		   int itemqty = 0;
		   int itemprice = 0;
		   
		   String itemname,itemserv;
		   
		   
		   
		   if(txtname.getText().length() == 0 ) {
		    	lblmsg.setText("Please Enter a Item or Service name");
		    }
		    
		    
		    else if(txtqty.getText().length() ==0 ||  !txtqty.getText().matches("[0-9]+")) {
		    	lblmsg.setText("Please Enter Valid Quantity");
		    }
		    else if( txtcat.getText().length() == 0) {
		    	lblmsg.setText("Please Enter Category");
		    }
		    else if(txtprice.getText().length() ==0 || !txtprice.getText().matches("[0-9]+")) {
		    	lblmsg.setText("Please Enter Valid Price");
		    }
		    else {
		   try {
			   itemserv = txtcat.getText();
			   itemqty = Integer.parseInt(txtqty.getText());
			   itemname = txtname.getText();
			   itemprice = Integer.parseInt(txtprice.getText());
	       	    
			    super.insert();
			    
			    if (rbtnitem.isSelected()) {
			    	
			    	
			    	String query1 = "INSERT INTO `item`( `Item_name`, `item_qty`, `item_price`) VALUES ('"+itemname +"',"+itemqty+","+itemprice+")";
			    	pst = con.prepareStatement(query1);
		            pst.executeUpdate(query1);
		            JOptionPane.showMessageDialog(null, "Item Information Update");
			    }
			    
			    else if(rbtnservice.isSelected()) {
			    	String query1 = "INSERT INTO `service`( `servicename`, `servicecat`, `serviceprice`) VALUES ('"+itemname +"','"+itemserv+"',"+itemprice+")";
			    	pst = con.prepareStatement(query1);
		            pst.executeUpdate(query1);
		            JOptionPane.showMessageDialog(null, "Service Information Update");
			    }
				 
				 lblmsg.setText("");
                 txtname.setText("");
                 txtqty.setText("");
                 txtprice.setText("");
                 txtcat.setText("");
                 con.close();
	             
	             
	            } 
		   catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
	       
		                       }
		   }
	   }
	
	public void viewDetails() {
		row = new Object[4];
		 try {  
				super.viewDetails();
			    
				
				 if (rbtnitem.isSelected()) {
				    	
			            pst = con.createStatement();				
					    String sql="SELECT * FROM `item` WHERE 1";
						rs=pst.executeQuery(sql);
						while (rs.next()) {
							
							row[0] = rs.getString("item_id");
							row[1] = rs.getString("Item_name");
							row[2] = rs.getString("item_qty");
							row[3] = rs.getString("item_price");
							model.addRow(row);
							}
				    }
				    
				   else if(rbtnservice.isSelected()) {
				    	pst = con.createStatement();			
					    String sql="SELECT * FROM `service` WHERE 1";
						rs=pst.executeQuery(sql);
						while (rs.next()) {
							
							row[0] = rs.getString("serviceID");
							row[1] = rs.getString("servicename");
							row[2] = rs.getString("servicecat");
							row[3] = rs.getString("serviceprice");
							model.addRow(row);
							}
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
        txtcat.setText("");
        
	}
	
	public void delete() {
		   int i = table.getSelectedRow();
		    
			if(i>=0) {
				
				 if (rbtnitem.isSelected()) {
				    	
					 try {
				        	super.delete();
							String delRow = "delete from item where item_id ="+table.getValueAt(i,0);
				            pst = con.prepareStatement(delRow);
				            pst.execute(delRow);
				           
				            JOptionPane.showMessageDialog(null, "Item  " +table.getValueAt(i,1) +" Deleted");
				            model.removeRow(i);
				            con.close();
				        } catch (Exception e) {
				            JOptionPane.showMessageDialog(null,  e.getMessage());
				        }
				    }
				    
				   else if(rbtnservice.isSelected()) {
					   try {
				        	super.delete();
							String delRow = "delete from service where serviceID ="+table.getValueAt(i,0);
				            pst = con.prepareStatement(delRow);
				            pst.execute(delRow);
				           
				            JOptionPane.showMessageDialog(null, "Service  " +table.getValueAt(i,1) +" Deleted");
				            model.removeRow(i);
				            con.close();
				        } catch (Exception e) {
				            JOptionPane.showMessageDialog(null,  e.getMessage());
				        }
				    }
				 
				
		       
			}
			else {
				JOptionPane.showMessageDialog(frame,"Please select a Row");
			}
		   
	   }
	
	public void update() {
	      
	      int i = table.getSelectedRow();
	      int j = table.getSelectedColumn();
	      if(i>=0) {
		    
	    	   try {
	    		  super.update();
	    		  
	    		  if (rbtnitem.isSelected()) {
	    			  
	    			  if(j == 1) {
	    		    	  
		    	           String itemnewname = JOptionPane.showInputDialog("Enter new name");
		    	           if ((itemnewname != null) && (itemnewname.length() > 0)) {
		    	        	   String query = "UPDATE `item` SET `Item_name`='"+itemnewname+"' WHERE `item_id`="+table.getValueAt(i,0);
			    	           pst = con.prepareStatement(query);
			     	           pst.executeUpdate(query);
			    	           JOptionPane.showMessageDialog(null, "Item new name Update");
			    	           con.close();
		    	           }
		    	           else {
		    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
		    	           }
		    	           
		    	  
		              }
		              else if(j == 2){
		    	           String itemnewqty = JOptionPane.showInputDialog("Enter new Quantity");
		    	           if ((itemnewqty != null) && (itemnewqty.length() > 0) && itemnewqty.matches("[0-9]+")) {
		    	        	   String query = "UPDATE `item` SET `item_qty`='"+itemnewqty+"' WHERE `item_id`="+table.getValueAt(i,0);
			    	           pst = con.prepareStatement(query);
			     	           pst.executeUpdate(query);
			    	           JOptionPane.showMessageDialog(null, "Item new quantity Update");
			    	           con.close();
		    	           }
		    	           else {
		    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
		    	           }
		    	           
		    	           
		              }
		               else if(j == 3){
		    	           String itemnewprice = JOptionPane.showInputDialog("Enter new Price");
		    	           if ((itemnewprice != null) && (itemnewprice.length() > 0) && itemnewprice.matches("[0-9]+")) {
		    	        	   String query = "UPDATE `item` SET `item_price`='"+itemnewprice+"' WHERE `item_id`="+table.getValueAt(i,0);
			    	           pst = con.prepareStatement(query);
			     	           pst.executeUpdate(query);
			    	           JOptionPane.showMessageDialog(null, "Item new price Update");
			    	           con.close();
		    	           }
		    	           else {
		    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
		    	           }
		    	           
		                }
		      
		               else {
		            	JOptionPane.showMessageDialog(frame,"Please select item  name, quantity or price ");
				       }
				    	
						 
					    }
					    
					else if(rbtnservice.isSelected()) {
						
						if(j == 1) {
		    		    	  
			    	           String itemnewname = JOptionPane.showInputDialog("Enter new name");
			    	           if ((itemnewname != null) && (itemnewname.length() > 0)) {
			    	        	   String query = "UPDATE `service` SET `servicename`='"+itemnewname+"' WHERE `serviceID`="+table.getValueAt(i,0);
				    	           pst = con.prepareStatement(query);
				     	           pst.executeUpdate(query);
				    	           JOptionPane.showMessageDialog(null, "Service new name Update");
				    	           con.close();
			    	           }
			    	           else {
			    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
			    	           }
			    	           
			    	  
			              }
			              else if(j == 2){
			    	           String itemnewcat = JOptionPane.showInputDialog("Enter new Category");
			    	           if ((itemnewcat != null) && (itemnewcat.length() > 0)) {
			    	        	   String query = "UPDATE `service` SET `servicecat`='"+itemnewcat+"' WHERE `serviceID`="+table.getValueAt(i,0);
				    	           pst = con.prepareStatement(query);
				     	           pst.executeUpdate(query);
				    	           JOptionPane.showMessageDialog(null, "Service new category Update");
				    	           con.close();
			    	           }
			    	           else {
			    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
			    	           }
			    	           
			    	           
			              }
			               else if(j == 3){
			    	           String itemnewprice = JOptionPane.showInputDialog("Enter new Price");
			    	           if ((itemnewprice != null) && (itemnewprice.length() > 0) && itemnewprice.matches("[0-9]+") ) {
			    	        	   String query = "UPDATE `service` SET `serviceprice`='"+itemnewprice+"' WHERE `serviceID`="+table.getValueAt(i,0);
				    	           pst = con.prepareStatement(query);
				     	           pst.executeUpdate(query);
				    	           JOptionPane.showMessageDialog(null, "service new price Update");
				    	           con.close();
			    	           }
			    	           else {
			    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
			    	           }
			    	           
			                }
			      
			               else {
			            	JOptionPane.showMessageDialog(frame,"Please select service  name, catergory or price ");
					       }
					    	
							 
						    }
						   
						   
					}
	    	   catch(Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
	    		  
	       }
	         
	       else {
	    	  JOptionPane.showMessageDialog(frame,"Please select cell for update ");
	       }
	
		   
 }

	public void setVisible(boolean b) {
		Inventory window = new Inventory();
		window.frame.setVisible(true);
		
	}
}
