package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

public class Customer {

	private JFrame frame;
	private JTable table;
    private DefaultTableModel model;
    private JTextField txtcusname;
    private JTextField txtcustel;
    private JTextField txtcusveh;
    private Object[] row ;

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
		frame.setBounds(100, 100, 615, 375);
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
		
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBackground(Color.WHITE);
		pane.setBounds(10,11,568,163);
		frame.getContentPane().add(pane);
		
		JLabel lblNewLabel = new JLabel("Customer name");
		lblNewLabel.setBounds(10, 194, 110, 24);
		frame.getContentPane().add(lblNewLabel);
		
		txtcusname = new JTextField();
		txtcusname.setBounds(124, 196, 110, 20);
		frame.getContentPane().add(txtcusname);
		txtcusname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer address");
		lblNewLabel_1.setBounds(10, 243, 110, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtcusadd = new JTextPane();
		txtcusadd.setBounds(130, 243, 104, 51);
		frame.getContentPane().add(txtcusadd);
		
		JLabel lblNewLabel_2 = new JLabel("Tel-number");
		lblNewLabel_2.setBounds(254, 199, 90, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtcustel = new JTextField();
		txtcustel.setBounds(354, 196, 86, 20);
		frame.getContentPane().add(txtcustel);
		txtcustel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vehicle Type");
		lblNewLabel_3.setBounds(254, 246, 74, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtcusveh = new JTextField();
		txtcusveh.setBounds(354, 243, 86, 20);
		frame.getContentPane().add(txtcusveh);
		txtcusveh.setColumns(10);
		
		JButton btnnewcus = new JButton("New Customer");
		btnnewcus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnnewcus.setBounds(254, 283, 136, 29);
		frame.getContentPane().add(btnnewcus);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(489, 242, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(489, 286, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewDetails();
			}
		});
		btnView.setBounds(489, 195, 89, 23);
		frame.getContentPane().add(btnView);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Customer.class.getResource("/image/Service.jpg")));
		lblNewLabel_4.setBounds(0, 0, 599, 336);
		frame.getContentPane().add(lblNewLabel_4);
		
		
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
		   
		   try {
			   telnum = Integer.parseInt(txtcustel.getText());
			   cusname = txtcusname.getText();
			   cusadd = txtcusveh.getText();
			   custype = txtcusveh.getText();
			   
	       	    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
				String query1  = "INSERT INTO `customer`(`customer_name`, `customer_add`, `customer_tel`, `customer_vhty`) VALUES ('"+cusname+"','"+ cusadd+"',"+telnum+",'"+custype+"')";				
				Statement ps = con.prepareStatement(query1);
	            ps.executeUpdate(query1);
	            JOptionPane.showMessageDialog(null, "Customer Information Update");
	             
	           
	       } catch (Exception e) {
	           JOptionPane.showMessageDialog(null,  e.getMessage());
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
		           
		            JOptionPane.showMessageDialog(null, "Employee" +table.getValueAt(i,1) +"Deleted");
		            model.removeRow(i);
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
			}
			else {
				JOptionPane.showMessageDialog(frame,"Please select Customer");
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
	    	           String query = "UPDATE `customer` SET `customer_name`='"+cusnewname+"' WHERE `customer_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	    	           
	    	  
	            }
	            else if(j == 2){
	    	           String empnewadd = JOptionPane.showInputDialog("Enter new Address");
	    	           String query = "UPDATE `customer` SET `customer_add`='"+empnewadd+"' WHERE `customer_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	            }
	            else if(j == 3){
	    	           String empnewtel = JOptionPane.showInputDialog("Enter new Telephone number");
	    	           String query = "UPDATE `customer` SET `customer_tel`='"+empnewtel+"' WHERE `customer_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	    	           
	            }
	            else if(j == 4){
	    	           String empnewtel = JOptionPane.showInputDialog("Enter new Vhicle Type");
	    	           String query = "UPDATE `customer` SET `customer_vhty`='"+empnewtel+"' WHERE `customer_id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Customer Information Update");
	    	           
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
	    	  JOptionPane.showMessageDialog(frame,"Please select employee name address or telephone number ");
	    	  
	       }
	
		   
   }

public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}
