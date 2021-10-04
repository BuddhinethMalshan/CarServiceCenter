package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Customer extends Admin  {

	private JFrame frame;
	private JTable table;
    private DefaultTableModel model;
    private JTextField txtcusname;
    private JTextField txtcustel;
    private JTextField txtcusveh;
    private JTextPane txtcusadd;
    private Object[] row ;
    private JLabel lblmsg;
    private JTextField txtmod;
    private JTextField txtvnum;

	/****
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1083, 694);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		
		
		model = new DefaultTableModel();
		
		model.addColumn("Customer ID");
	    model.addColumn("Customer name");
	    model.addColumn("Customer Address");
	    model.addColumn("Contect number");
	    model.addColumn("Vehical Brand");
	    model.addColumn("Vehical Model");
	    model.addColumn("Vehical RegNum");
	    
	    
	   
	    
		
		table = new JTable();
		table.setBounds(10, 122, 414, -114);
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.blue);
		table.setGridColor(Color.black);
		table.setSelectionForeground(Color.WHITE);
		table.setFont(new Font("Serif", Font.BOLD, 11));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		table.setForeground(Color.black);
		viewDetails();
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBackground(Color.WHITE);
		pane.setBounds(0,0,769,297);
		frame.getContentPane().add(pane);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Customer.class.getResource("/images/Service.jpg")));
		lblNewLabel_4.setBounds(0, 0, 778, 407);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(255, 255, 255)));
		panel.setBounds(768, 0, 299, 655);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnnewcus = new JButton("New Customer");
		btnnewcus.setForeground(new Color(255, 255, 255));
		btnnewcus.setBackground(new Color(0, 139, 139));
		btnnewcus.setBounds(146, 584, 143, 46);
		panel.add(btnnewcus);
		
		txtcustel = new JTextField();
		txtcustel.setBounds(122, 133, 167, 32);
		panel.add(txtcustel);
		txtcustel.setColumns(10);
		
		txtcusveh = new JTextField();
		txtcusveh.setBounds(122, 215, 167, 32);
		panel.add(txtcusveh);
		txtcusveh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tel-number :");
		lblNewLabel_2.setBounds(10, 111, 120, 24);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Vehicle Brand :");
		lblNewLabel_3.setBounds(10, 186, 143, 18);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		txtcusadd = new JTextPane();
		txtcusadd.setBounds(122, 427, 167, 72);
		panel.add(txtcusadd);
		
		JLabel lblNewLabel_1 = new JLabel("Customer address :");
		lblNewLabel_1.setBounds(10, 392, 155, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		txtcusname = new JTextField();
		txtcusname.setBounds(122, 68, 167, 32);
		panel.add(txtcusname);
		txtcusname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer name :");
		lblNewLabel.setBounds(10, 44, 143, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 510, 279, 27);
		panel.add(lblmsg);
		lblmsg.setForeground(new Color(255, 0, 0));
		
		JLabel lblmod = new JLabel("Vehicle model :");
		lblmod.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblmod.setBounds(10, 258, 134, 26);
		panel.add(lblmod);
		
		JLabel lblNewLabel_6 = new JLabel("Vehicle Reg num:");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 326, 127, 27);
		panel.add(lblNewLabel_6);
		
		txtmod = new JTextField();
		txtmod.setBounds(122, 283, 167, 32);
		panel.add(txtmod);
		txtmod.setColumns(10);
		
		txtvnum = new JTextField();
		txtvnum.setBounds(122, 349, 167, 32);
		panel.add(txtvnum);
		txtvnum.setColumns(10);
		btnnewcus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				viewDetails();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(255, 255, 255)));
		panel_1.setBounds(0, 407, 769, 248);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(102, 205, 170));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBounds(496, 43, 106, 41);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(102, 205, 170));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBounds(640, 38, 106, 46);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 174, 769, 74);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Customer.class.getResource("/images/Car_logos.png")));
		lblNewLabel_5.setBounds(151, 0, 618, 74);
		panel_2.add(lblNewLabel_5);
		
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
		btnback.setBackground(new Color(102, 205, 170));
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBounds(642, 108, 104, 41);
		panel_1.add(btnback);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(496, 107, 109, 41);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				viewDetails();
			}
		});
		
		
		frame.revalidate();
        frame.setVisible(true);
		
		
		}
	 public  void viewDetails() {
		   row = new Object[7];
		   try {  
				super.viewDetails();
				pst = con.createStatement();
				String sql="SELECT * FROM `customer` WHERE 1";
				rs=pst.executeQuery(sql);
				while (rs.next()) {
					
					
     				row[0] = rs.getString("customer_id");
					row[1] = rs.getString("customer_name");
					row[2] = rs.getString("customer_add");
					row[3] = rs.getString("customer_tel");
					row[4] = rs.getString("customer_vhty");
					row[5] = rs.getString("customer_vhm");
					row[6] = rs.getString("customer_vhn");
					
					model.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	   }
	 
	 public void insert() {
		   
		   
		   int telnum = 0;
		   String cusname,cusadd,custype,vhymod,vhynum;

     	    if(txtcusname.getText().length() == 0 ) {
     	    	lblmsg.setText("Please Enter a customer name");
		    }
     	    else if(!(Pattern.matches("^[a-zA-Z]+$", txtcusname.getText()))) {
     	    	lblmsg.setText("Please Enter a valid name Ex: Johon");
     	    }
     	    else if(txtcustel.getText().length() != 10 || !txtcustel.getText().matches("[0-9]+")) {
		    	lblmsg.setText("Please Enter Valid Phone number Ex:07xxxxxxxx");
		    }
     	   
		    else if (txtcusveh.getText().length() == 0 ) {
		    	lblmsg.setText("Please Enter Customer Vehicle Brand");
		    }
		    else if ((txtcusveh.getText().length() > 9)) {
		    	lblmsg.setText("Please Enter  valid Customer Vehicle Brand");
		    }
		    else if (txtmod.getText().length() == 0 ) {
		    	lblmsg.setText("Please Enter Customer Vehicle Model");
		    }
		    else if((txtmod.getText().length() > 9)) {
		    	lblmsg.setText("Please Enter Valid Customer Vehicle Model");
		    }
     	    
		    else if ((txtvnum.getText().length() == 0)) {
		    	lblmsg.setText("Please Enter Customer Vehicle Reg Num");
		    }
		    else if((txtvnum.getText().length() > 9)) {
		    	lblmsg.setText("Please Enter  Valid Customer Vehicle Reg Num");
		    }
     	    
		    else if(txtcusadd.getText().length() ==0) {
		    	lblmsg.setText("Please Enter Customer Address");
		    }
		    
		    else {
		   try {
			   telnum  = Integer.parseInt(txtcustel.getText());
			   cusname = txtcusname.getText();
			   cusadd  = txtcusadd.getText();
			   custype = txtcusveh.getText();
			   vhymod  = txtmod.getText();
			   vhynum  = txtvnum.getText();
			    super.insert();
				String query1  = "INSERT INTO `customer`(`customer_name`, `customer_add`, `customer_tel`, `customer_vhty` , `customer_vhm`, `customer_vhn`) VALUES ('"+cusname+"','"+ cusadd+"',"+telnum+",'"+custype+"', '"+vhymod+"', '"+vhynum+"')";				
				pst = con.prepareStatement(query1);
	            pst.executeUpdate(query1);
	            
	            
	            JOptionPane.showMessageDialog(null, "Customer " +cusname+  "  Information Update");
	            
	            con.close();
	            lblmsg.setText("");
	            txtcusname.setText("");
	            txtcusadd.setText("");
	            txtcusveh.setText("");
	            txtcustel.setText("");
	            txtmod.setText("");
	            txtvnum.setText("");
				} 
	           
	        catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
	       }
		    }
	   }
	  public void delete() {
		   int i = table.getSelectedRow();
		  
			if(i>=0) {
				
				
		        try {
		        	super.delete();
					String delRow = "delete from customer where customer_id ="+table.getValueAt(i,0);
		            pst = con.prepareStatement(delRow);
		            pst.execute(delRow);
		           
		            JOptionPane.showMessageDialog(null, "Customer  " +table.getValueAt(i,1) +" Deleted");
		            model.removeRow(i);
		            con.close();
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
			}
			else {
				JOptionPane.showMessageDialog(frame,"Please select a Customer");
			}
		   
	   }
      public void update() {
	      
	      int i = table.getSelectedRow();
	      int j = table.getSelectedColumn();
	      if(i>=0) {
		    
	    	  try {
	    		  super.update();
	            if(j == 1) {
	    	  
	    	          String cusnewname = JOptionPane.showInputDialog("Enter new name");
                        if((cusnewname != null) && (cusnewname.length() > 0) && (Pattern.matches("^[a-zA-Z]+$",cusnewname ))) {
                        	String query = "UPDATE `customer` SET `customer_name`='"+cusnewname+"' WHERE `customer_id`="+table.getValueAt(i,0);
      	    	           pst = con.prepareStatement(query);
      	     	           pst.executeUpdate(query);
      	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
      	    	           con.close();
                        	
                        }
                        else {
                        	JOptionPane.showMessageDialog(null, "Please fill the field with valid value");
                        }    
	    	  
	            }
	            else if(j == 2){
	            	  
	    	           String cusnewadd = JOptionPane.showInputDialog("Enter new Address");
	    	            if((cusnewadd != null) && (cusnewadd.length() > 0)) {
	    	               String query = "UPDATE `customer` SET `customer_add`='"+cusnewadd+"' WHERE `customer_id`="+table.getValueAt(i,0);
	 	    	           pst = con.prepareStatement(query);
	 	     	           pst.executeUpdate(query);
	 	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	 	    	           con.close();
	    	            	
	    	            }
	    	            else {
	    	               JOptionPane.showMessageDialog(null, "Please fill the field");
	    	            }
	    	            
	    	           
	            }
	            else if(j == 3){
	            	
	    	           String cusnewtel = JOptionPane.showInputDialog("Enter new Telephone number");
	    	           if((cusnewtel != null) && (cusnewtel.length() > 0) && cusnewtel.matches("[0-9]+") && cusnewtel.length() == 10) {
	    	        	   String query = "UPDATE `customer` SET `customer_tel`='"+cusnewtel+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           pst = con.prepareStatement(query);
		     	           pst.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update");   
		    	           con.close();
	    	           }
	    	           else {
	    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
	    	           }
	    	           
	    	               
	            }
	            else if(j == 4){
	    	           String cusvehtype = JOptionPane.showInputDialog("Enter new Vhicle Brand");
	    	          
	    	           if((cusvehtype != null) && (cusvehtype.length() > 0) && (cusvehtype.length() < 9)) {
	    	        	   String query = "UPDATE `customer` SET `customer_vhty`='"+cusvehtype+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           pst = con.prepareStatement(query);
		     	           pst.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update"); 
		    	           con.close();
	    	            	
	    	            }
	    	            else {
	    	               JOptionPane.showMessageDialog(null, "Please fill the field");
	    	            }
	    	           
	    	          }
	            else if(j == 5){
	    	           String cusvehmod = JOptionPane.showInputDialog("Enter new Vhicle Model");
	    	          
	    	           if((cusvehmod != null) && (cusvehmod.length() > 0) && (cusvehmod.length() <9)) {
	    	        	   String query = "UPDATE `customer` SET `customer_vhm`='"+cusvehmod+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           pst = con.prepareStatement(query);
		     	           pst.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update"); 
		    	           con.close();
	    	            	
	    	            }
	    	            else {
	    	               JOptionPane.showMessageDialog(null, "Please fill the field");
	    	            }
	    	           
	    	          }
	            else if(j == 6){
	    	           String cusvehrenum = JOptionPane.showInputDialog("Enter new Vhicle Reg num");
	    	          
	    	           if((cusvehrenum != null) && (cusvehrenum.length() > 0) && (cusvehrenum.length() < 9)) {
	    	        	   String query = "UPDATE `customer` SET `customer_vhn`='"+cusvehrenum+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           pst = con.prepareStatement(query);
		     	           pst.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update"); 
		    	           con.close();
	    	            	
	    	            }
	    	            else {
	    	               JOptionPane.showMessageDialog(null, "Please fill the field");
	    	            }
	    	           
	    	          }
	      
	            else {
	            	JOptionPane.showMessageDialog(frame,"Please select Cell for update ");
			    }
	            
	       }
	    	  catch(Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
	         }
	         
	         
           
	       else {
	    	  JOptionPane.showMessageDialog(frame,"Please select Cell for update ");
	    	  
	       }
	
		   
   }
        private void clear() {
	        lblmsg.setText("");
            txtcusname.setText("");
            txtcusadd.setText("");
            txtcusveh.setText("");
            txtcustel.setText("");
            txtmod.setText("");
            txtvnum.setText("");
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
