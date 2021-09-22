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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
  
public class Employee {
   
   private JFrame frame;
   private  JTable table;
   private Object[] row ;
   private DefaultTableModel model;
   private JTextField txt_name;
   private JTextField txttel;
   private JTextPane txtadd ;
   
    Employee()
    {
       
    	table = new JTable();
        Object[] columns = {"Employee ID" , "Employee name" , "Address" ,"Contect"};
        model = new DefaultTableModel();
        frame = new JFrame();
        frame.setTitle("Employee Details");
        //frame.getContentPane().setBackground(new Color(0,0,0));
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100,100,100,100);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null); 
        frame.setSize(603, 375);
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.blue);
        table.setGridColor(Color.black);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Serif", Font.BOLD, 11));
        
       // table.setFont(new Font("Tahoma", Font,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        pane.setBounds(0,12,587,163);
        frame.getContentPane().add(pane);
        
        JButton btnNewButton = new JButton("View");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewDetails();
        	}
        });
        btnNewButton.setBounds(20, 186, 89, 23);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		delete();
        	}
        });
        btnNewButton_1.setBounds(20, 230, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblEmployeeName = new JLabel("Employee name");
        lblEmployeeName.setBounds(148, 188, 107, 19);
        frame.getContentPane().add(lblEmployeeName);
        JLabel lbladd = new JLabel(" Address");
        lbladd.setBounds(148, 232, 89, 19);
        frame.getContentPane().add(lbladd);
        
        JLabel lbltel = new JLabel("Tel-phone");
        lbltel.setBounds(371, 190, 78, 14);
        frame.getContentPane().add(lbltel);
        
        txt_name = new JTextField();
        txt_name.setBounds(254, 186, 86, 20);
        frame.getContentPane().add(txt_name);
        txt_name.setColumns(10);
        
        txttel = new JTextField();
        txttel.setBounds(459, 187, 86, 20);
        frame.getContentPane().add(txttel);
        txttel.setColumns(10);
        
        txtadd = new JTextPane();
        txtadd.setBounds(254, 230, 163, 53);
        frame.getContentPane().add(txtadd);
        
        JButton btninsert = new JButton("New Employee ");
        btninsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		insert();
        	}
        });
        btninsert.setBounds(444, 230, 129, 29);
        frame.getContentPane().add(btninsert);
        
        JButton btnupdate = new JButton("Update");
        btnupdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update();
        	}
        });
        btnupdate.setBounds(20, 278, 89, 23);
        frame.getContentPane().add(btnupdate);
        
        JLabel bgpic = new JLabel("");
        bgpic.setIcon(new ImageIcon("E:\\education\\UOC\\3rd Year\\1st Sem\\IT 3003\\teamr_repository\\bin\\image\\employee.jpg"));
        bgpic.setBounds(0, 0, 587, 336);
        frame.getContentPane().add(bgpic);
        
        
        
        
        
        
        
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
			JOptionPane.showConfirmDialog(frame,"Please select employee");
		}
	   
   }
   
   private void insert() {
	   int telnum = 0;
	   String empname,empadd;
	   
	   
	   try {
		   telnum = Integer.parseInt(txttel.getText());
		   empname = txt_name.getText();
		   empadd = txtadd.getText();
       	    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
			 String query1 = "INSERT INTO `employee`( `Employee_name`, `Employee_add`, `Employee_tel`) VALUES ('"+empname+"','"+empadd+"',"+telnum+")";
             Statement ps = con.prepareStatement(query1);
             ps.executeUpdate(query1);
          
             JOptionPane.showMessageDialog(null, "Employee Information Update");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,  e.getMessage());
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
    // Driver  method
    public static void main(String[] args)
    {
        new Employee();
    }
}