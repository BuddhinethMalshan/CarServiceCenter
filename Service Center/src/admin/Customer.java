package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Customer {

	private JFrame frame;
	private JTable table;
    private DefaultTableModel model;
    private JTextField txtcusname;
    private JTextField txtcustel;
    private JTextField txtcusveh;
    private JTextPane txtcusadd;
    private Object[] row ;
    private JLabel lblmsg;

	/**
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
	    model.addColumn("Vehical type");
	    
	    
	    
	   
	    
		
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
		lblNewLabel_4.setIcon(new ImageIcon(Customer.class.getResource("/image/Service.jpg")));
		lblNewLabel_4.setBounds(0, 0, 778, 407);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(255, 255, 255)));
		panel.setBounds(768, 0, 299, 655);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 428, 101, 36);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 495, 101, 36);
		panel.add(btnDelete);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(255, 255, 255)));
		panel_1.setBounds(0, 407, 769, 248);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer name");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 32, 143, 24);
		panel_1.add(lblNewLabel);
		
		txtcusname = new JTextField();
		txtcusname.setBounds(178, 32, 167, 24);
		panel_1.add(txtcusname);
		txtcusname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer address");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 104, 155, 24);
		panel_1.add(lblNewLabel_1);
		
		txtcusadd = new JTextPane();
		txtcusadd.setBounds(178, 93, 167, 72);
		panel_1.add(txtcusadd);
		
		JLabel lblNewLabel_2 = new JLabel("Tel-number");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(410, 32, 120, 24);
		panel_1.add(lblNewLabel_2);
		
		txtcustel = new JTextField();
		txtcustel.setBounds(561, 36, 120, 20);
		panel_1.add(txtcustel);
		txtcustel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vehicle Type");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(410, 110, 143, 18);
		panel_1.add(lblNewLabel_3);
		
		txtcusveh = new JTextField();
		txtcusveh.setBounds(561, 108, 132, 20);
		panel_1.add(txtcusveh);
		txtcusveh.setColumns(10);
		
		JButton btnnewcus = new JButton("New Customer");
		btnnewcus.setBounds(417, 156, 136, 29);
		panel_1.add(btnnewcus);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(593, 157, 100, 26);
		panel_1.add(btnNewButton);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(178, 176, 214, 27);
		panel_1.add(lblmsg);
		lblmsg.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnnewcus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				viewDetails();
			}
		});
		
		
		frame.revalidate();
        frame.setVisible(true);
		
		
		}
	 private void viewDetails() {
		   row = new Object[5];
		   try {  
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
				Statement stmt = con.createStatement();
				String sql="SELECT * FROM `customer` WHERE 1";
				ResultSet rs=stmt.executeQuery(sql);
				while (rs.next()) {
					
					
     				row[0] = rs.getString("customer_id");
					row[1] = rs.getString("customer_name");
					row[2] = rs.getString("customer_add");
					row[3] = rs.getString("customer_tel");
					row[4] = rs.getString("customer_vhty");
					
					model.addRow(row);
				}
			
				con.close();
				} 
			catch(Exception e1) {
				System.out.print(e1);
				}
	   }
	 
	 private void insert() {
		   
		   
		   int telnum = 0;
		   String cusname,cusadd,custype;

     	    if(txtcusname.getText().length() == 0 ) {
     	    	lblmsg.setText("Please Enter a customer name");
		    }
     	    else if(!(Pattern.matches("^[a-zA-Z]+$", txtcusname.getText()))) {
     	    	lblmsg.setText("Please Enter a valid name Ex: Johon");
     	    }
		    else if (txtcusveh.getText().length() == 0) {
		    	lblmsg.setText("Please Enter Customer Vehicle type");
		    }
		    
		    else if(txtcusadd.getText().length() ==0) {
		    	lblmsg.setText("Please Enter Customer Address");
		    }
		    else if(txtcustel.getText().length() != 10) {
		    	lblmsg.setText("Please Enter Valid Phone number Ex:07xxxxxxxx");
		    }
		    else {
		   try {
			   telnum = Integer.parseInt(txtcustel.getText());
			   cusname = txtcusname.getText();
			   cusadd = txtcusadd.getText();
			   custype = txtcusveh.getText();
			   
	       	    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
				String query1  = "INSERT INTO `customer`(`customer_name`, `customer_add`, `customer_tel`, `customer_vhty`) VALUES ('"+cusname+"','"+ cusadd+"',"+0+telnum+",'"+custype+"')";				
				Statement ps = con.prepareStatement(query1);
	            ps.executeUpdate(query1);
	            
	            
	            JOptionPane.showMessageDialog(null, "Customer " +cusname+  "  Information Update");
	            
	            con.close();
	            lblmsg.setText("");
	            txtcusname.setText("");
	            txtcusadd.setText("");
	            txtcusveh.setText("");
	            txtcustel.setText("");
				} 
	           
	        catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
	       }
		    }
	   }
	  private void delete() {
		   int i = table.getSelectedRow();
		  
			if(i>=0) {
				
				
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
					String delRow = "delete from customer where customer_id ="+table.getValueAt(i,0);
		            Statement ps = con.prepareStatement(delRow);
		            ps.execute(delRow);
		           
		            JOptionPane.showMessageDialog(null, "Customer  " +table.getValueAt(i,1) +" Deleted");
		            model.removeRow(i);
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
			}
			else {
				JOptionPane.showMessageDialog(frame,"Please select a Customer");
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
	    	  
	    	          String cusnewname = JOptionPane.showInputDialog("Enter new name");
                        if(cusnewname.isEmpty() || !(Pattern.matches("^[a-zA-Z]+$",cusnewname ))) {
                        	 JOptionPane.showMessageDialog(null, "Please fill the field");
                        	
                        }
                        else {
                           String query = "UPDATE `customer` SET `customer_name`='"+cusnewname+"' WHERE `customer_id`="+table.getValueAt(i,0);
     	    	           Statement ps = con.prepareStatement(query);
     	     	           ps.executeUpdate(query);
     	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
     	    	           con.close();
                        }
	    	           
	    	           
	    	  
	            }
	            else if(j == 2){
	            	  
	    	           String cusnewadd = JOptionPane.showInputDialog("Enter new Address");
	    	            if(cusnewadd.isEmpty()) {
	    	            	JOptionPane.showMessageDialog(null, "Please fill the field");
	    	            }
	    	            else {
	    	           String query = "UPDATE `customer` SET `customer_add`='"+cusnewadd+"' WHERE `customer_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	    	           con.close();
	    	            }
	            }
	            else if(j == 3){
	            	
	    	           String cusnewtel = JOptionPane.showInputDialog("Enter new Telephone number");
	    	           if(cusnewtel.isEmpty()) {
	    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
	    	           }
	    	           else {
	    	        	   String query = "UPDATE `customer` SET `customer_tel`='"+cusnewtel+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update");   
		    	           con.close();
	    	           }
	    	           
	    	           
	            }
	            else if(j == 4){
	    	           String cusvehtype = JOptionPane.showInputDialog("Enter new Vhicle Type");
	    	           if(cusvehtype.isEmpty()) {
	    	        	   JOptionPane.showMessageDialog(null, "Please fill the field");
	    	           }
	    	           else {
	    	        	   String query = "UPDATE `customer` SET `customer_vhty`='"+cusvehtype+"' WHERE `customer_id`="+table.getValueAt(i,0);
		    	           Statement ps = con.prepareStatement(query);
		     	           ps.executeUpdate(query);
		    	           JOptionPane.showMessageDialog(null, "Customer Information Update"); 
		    	           con.close();
	    	           }
	    	           
	    	           
	    	           
	            }
	      
	            else {
	            	JOptionPane.showMessageDialog(frame,"Please select customer name address or telephone number ");
			    }
	            
	       }
	    	  catch(Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
	         }
	         
	         
           
	       else {
	    	  JOptionPane.showMessageDialog(frame,"Please select customer name address or telephone number ");
	    	  
	       }
	
		   
   }
        private void clear() {
	        lblmsg.setText("");
            txtcusname.setText("");
            txtcusadd.setText("");
            txtcusveh.setText("");
            txtcustel.setText("");
}

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
