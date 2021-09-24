package admin;





import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;



public class Employee {
   
   private JFrame frame;
   private  JTable table;
   private Object[] row ;
   private DefaultTableModel model;
   private JTextField txt_name;
   private JTextField txttel;
   private JTextPane txtadd ;
   private  JLabel lblmsg;
   
    Employee()
    {
       
    	table = new JTable();
        Object[] columns = {"Employee ID" , "Employee name" , "Address" ,"Contect"};
        model = new DefaultTableModel();
        frame = new JFrame();
        frame.setTitle("Employee Details");
        //frame.getContentPane().setBackground(new Color(0,0,0));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100,100,1083,694);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null); 
        frame.setSize(1083, 694);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.blue);
        table.setGridColor(Color.black);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Serif", Font.BOLD, 11));
        
      
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        viewDetails();
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        pane.setBounds(0,0,769,248);
        frame.getContentPane().add(pane);
        
        JLabel bgpic = new JLabel("");
        bgpic.setIcon(new ImageIcon(Employee.class.getResource("/image/Customer.jpg")));
        bgpic.setBounds(0, 0, 769, 408);
        frame.getContentPane().add(bgpic);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 139, 139));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 17), new java.awt.Color(255, 255, 255)));
        panel.setBounds(0, 407, 769, 248);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("Clear");
        btnNewButton.setBounds(476, 151, 89, 23);
        panel.add(btnNewButton);
        
        txtadd = new JTextPane();
        txtadd.setBounds(546, 40, 186, 68);
        panel.add(txtadd);
        txtadd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btninsert = new JButton("New Employee ");
        btninsert.setBounds(600, 148, 129, 29);
        panel.add(btninsert);
        
        JLabel lblEmployeeName = new JLabel("Employee name");
        lblEmployeeName.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblEmployeeName.setBounds(10, 41, 131, 29);
        panel.add(lblEmployeeName);
        JLabel lbladd = new JLabel(" Address");
        lbladd.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lbladd.setBounds(408, 48, 99, 22);
        panel.add(lbladd);
        
        txt_name = new JTextField();
        txt_name.setBounds(182, 46, 149, 26);
        panel.add(txt_name);
        txt_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txt_name.setColumns(10);
        
        txttel = new JTextField();
        txttel.setBounds(182, 103, 149, 20);
        panel.add(txttel);
        txttel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txttel.setColumns(10);
        
        JLabel lbltel = new JLabel("Tel-phone");
        lbltel.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lbltel.setBounds(10, 104, 99, 16);
        panel.add(lbltel);
        
        lblmsg = new JLabel("");
        lblmsg.setBounds(178, 134, 218, 27);
        panel.add(lblmsg);
        lblmsg.setForeground(new Color(255, 0, 0));
        btninsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		insert();
        		DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				viewDetails();
        	}
        });
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clear();
        	}
        });
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(102, 205, 170));
        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 16), new java.awt.Color(255, 255, 255)));
        panel_1.setBounds(768, 0, 299, 655);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnupdate = new JButton("Update");
        btnupdate.setBounds(10, 484, 89, 23);
        panel_1.add(btnupdate);
        
        
       
        
        JButton btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.setBounds(10, 542, 89, 23);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		delete();
        	}
        });
        btnupdate.addActionListener(new ActionListener() {
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
   private void viewDetails() {
	   row = new Object[4];
	   try {  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
			Statement stmt = con.createStatement();
			String sql="SELECT * FROM `employee` WHERE 1";
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				
				row[0] = rs.getString("Employee_Id");
				row[1] = rs.getString("Employee_name");
				row[2] = rs.getString("Employee_add");
				row[3] = rs.getString("Employee_tel");
				
				model.addRow(row);
			}
			con.close();
			} 
		catch(Exception e1) {
			System.out.print(e1);
			}
   }
   
   private void delete() {
	   int i = table.getSelectedRow();
	  
		if(i>=0) {
			
			
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
				String delRow = "delete from employee where Employee_Id ="+table.getValueAt(i,0);
	            Statement ps = con.prepareStatement(delRow);
	            ps.execute(delRow);
	           
	            JOptionPane.showMessageDialog(null, "Employee" +table.getValueAt(i,1) +"Deleted");
	            model.removeRow(i);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null,  e.getMessage());
	        }
		}
		else {
			JOptionPane.showMessageDialog(frame,"Please select employee");
		}
	   
   }
   
   private void insert() {
	   
	 

 	    
	   
	   int telnum = 0;
	   String empname,empadd;
	   if(txt_name.getText().length() == 0 ) {
	    	lblmsg.setText("Please Enter a customer name");
	    }
	    else if(!(Pattern.matches("^[a-zA-Z]+$", txt_name.getText()))) {
	    	lblmsg.setText("Please Enter a valid name Ex: Johon");
	    }
	    
	    else if(txtadd.getText().length() ==0) {
	    	lblmsg.setText("Please Enter Customer Address");
	    }
	    else if(txttel.getText().length() != 10) {
	    	lblmsg.setText("Please Enter Valid Phone number Ex:07xxxxxxxx");
	    }
	   
	    else {
	           try {
		            telnum = Integer.parseInt(txttel.getText());
		            empname = txt_name.getText();
		            empadd = txtadd.getText();
       	            Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
			        String query1 = "INSERT INTO `employee`( `Employee_name`, `Employee_add`, `Employee_tel`) VALUES ('"+empname+"','"+empadd+"',"+telnum+")";
                    Statement ps = con.prepareStatement(query1);
                    ps.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Employee  " +empname+  " Information Update");
                    lblmsg.setText("");
                    txt_name.setText("");
                    txtadd.setText("");
                    txttel.setText("");
                    con.close();
             
           
              } 
	          catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  e.getMessage());
              }
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
	    	  
	    	           String empnewname = JOptionPane.showInputDialog("Enter new name");
	    	           String query = "UPDATE `employee` SET `Employee_name`='"+empnewname+"' WHERE `Employee_Id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Employee Information Update");
	    	           
	    	  
	            }
	            else if(j == 2){
	    	           String empnewadd = JOptionPane.showInputDialog("Enter new Address");
	    	           String query = "UPDATE `employee` SET `Employee_add`='"+empnewadd+"' WHERE `Employee_Id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Employee Information Update");
	            }
	            else if(j == 3){
	    	           String empnewtel = JOptionPane.showInputDialog("Enter new Telephone number");
	    	           String query = "UPDATE `employee` SET `Employee_tel`='"+empnewtel+"' WHERE `Employee_Id`="+table.getValueAt(i,0);
	    	           Statement ps = con.prepareStatement(query);
	     	           ps.executeUpdate(query);
	    	           JOptionPane.showMessageDialog(null, "Employee Information Update");
	    	           
	            }
	      
	            else {
	            	JOptionPane.showMessageDialog(frame,"Please select employee name address or telephone number ");
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
   private void clear() {
       lblmsg.setText("");
       txt_name.setText("");
       txtadd.setText("");
       txttel.setText("");
     }
    // Driver  method
   
	public void setVisible(boolean b) {
		}
	
}