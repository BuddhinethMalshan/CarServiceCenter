package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JPasswordField;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Settings {

	private JFrame frame;
	private JPasswordField curpwd;
	private JPasswordField confpwd;
	private JPasswordField newpwd;
    private JCheckBox checkshow;
    private JLabel lblpasserr;
    private JTextField txtname;
	/***
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/***
	 * 
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 681, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setForeground(Color.BLACK);
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 36), new java.awt.Color(153, 208, 249)));
		panel.setBounds(0, 0, 665, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel pane2 = new JPanel();
		pane2.setBackground(new Color(102, 205, 170));
		pane2.setForeground(Color.BLACK);
		pane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 15), new java.awt.Color(255, 255, 255)));
		pane2.setBounds(36, 60, 567, 289);
		panel.add(pane2);
		pane2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Current Password :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 106, 134, 29);
		pane2.add(lblNewLabel);
		
		JLabel lblcnew = new JLabel("Confirm New Password :\\");
		lblcnew.setFont(new Font("Arial", Font.BOLD, 12));
		lblcnew.setBounds(38, 186, 150, 29);
		pane2.add(lblcnew);
		
		JLabel lblnewpwd = new JLabel("New Password :");
		lblnewpwd.setFont(new Font("Arial", Font.BOLD, 12));
		lblnewpwd.setBounds(38, 146, 134, 29);
		pane2.add(lblnewpwd);
		
		curpwd = new JPasswordField();
		curpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		curpwd.setBounds(196, 112, 162, 25);
		pane2.add(curpwd);
		
		confpwd = new JPasswordField();
		confpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		confpwd.setBounds(196, 187, 162, 25);
		pane2.add(confpwd);
		
		newpwd = new JPasswordField();
		newpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		newpwd.setBounds(196, 148, 162, 25);
		pane2.add(newpwd);
		
		checkshow = new JCheckBox("Show Passwords");
		checkshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showpwd();
			}
		});
		checkshow.setBackground(new Color(32, 178, 170));
		checkshow.setBounds(18, 252, 134, 29);
		pane2.add(checkshow);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
			
		});
		btnclear.setBounds(317, 255, 89, 23);
		pane2.add(btnclear);
		
		JButton btnchange = new JButton("Change");
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
				
			}
		});
		btnchange.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnchange.setBounds(438, 255, 89, 23);
		pane2.add(btnchange);
		
		lblpasserr = new JLabel("");
		lblpasserr.setForeground(new Color(255, 0, 0));
		lblpasserr.setBounds(196, 223, 210, 24);
		pane2.add(lblpasserr);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBounds(38, 66, 134, 29);
		pane2.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(196, 70, 162, 25);
		pane2.add(txtname);
		txtname.setColumns(10);
		
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
		btnback.setBackground(new Color(0, 139, 139));
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBounds(546, 360, 95, 31);
		panel.add(btnback);
	}
	
	private void showpwd() {
		if(checkshow.isSelected()){
			curpwd.setEchoChar('\u0000');
			confpwd.setEchoChar('\u0000');
			newpwd.setEchoChar('\u0000');
           
        }else if(!checkshow.isSelected()){
        	curpwd.setEchoChar('\u25cf');
            confpwd.setEchoChar('\u25cf');
            newpwd.setEchoChar('\u25cf');
        }
		
	}
	@SuppressWarnings("deprecation")
	private void change() {
		
		String name,oldpass, newpass,conpass;
		name = txtname.getText();
		oldpass = curpwd.getText();
		newpass = newpwd.getText();
		conpass = confpwd.getText();
		
		if(txtname.getText().length() == 0 ) {
			lblpasserr.setText("Please Enter a your name");
	    }
 	    else if(!(Pattern.matches("^[a-zA-Z]+$", txtname.getText()))) {
 	    	lblpasserr.setText("Please Enter a valid name Ex: TOM");
 	    }
//		else if(curpwd.getText().length()==0){
//			lblpasserr.setText("Please Enter Old Password");
//        }
//        else if(newpwd.getText().length()==0){
//            lblpasserr.setText("Please Enter New Password");
//        }
//        else if(confpwd.getText().length()==0){
//            lblpasserr.setText("Please Confirm New Password");
//        }
        else {
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/carservice", "root", "");
			Statement stmt = con.createStatement();
			String sql="SELECT  pass_admin FROM admin WHERE name_admin ='"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				if(oldpass.equals(rs.getString("pass_admin"))){
	                if(newpass.length()<6){
	                    lblpasserr.setText("Password is Too Short");
	                }else{
	                    if(conpass.equals(newpass)){
	                        if(JOptionPane.showConfirmDialog(new JOptionPane(), "Are you sure you want to change your password?", "Confirmation", JOptionPane.OK_CANCEL_OPTION)==0){    
	                        String query = "UPDATE `admin` SET `pass_admin`='"+conpass+"' WHERE `name_admin` ='"+name+"'";
	      	    	           Statement ps = con.prepareStatement(query);
	      	     	           ps.executeUpdate(query);
	      	     	           JOptionPane.showMessageDialog(null,"Your Password changed");
	      	     	           clear();
	                        }    
	                    }
	                    else{
	                        lblpasserr.setText("New Passwords Don't Match");
	                    }
	                }
	            }
	            else{
	                lblpasserr.setText("Old Password is Wrong");
	            }
				
				}
			
        	}
        	catch(Exception e1) {
				System.out.print(e1);
				}
        }
		
	}
	private void clear() {
		txtname.setText("");
        curpwd.setText("");
        newpwd.setText("");
        confpwd.setText("");
        lblpasserr.setText("");
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		Settings window = new Settings();
		window.frame.setVisible(true);
		
	}
}
