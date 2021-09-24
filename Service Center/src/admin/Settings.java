package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JPasswordField;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings {

	private JFrame frame;
	private JPasswordField curpwd;
	private JPasswordField confpwd;
	private JPasswordField newpwd;
    private JCheckBox checkshow;
    private JLabel lblpasserr;
	/**
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

	/**
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
		
		frame.setBounds(100, 100, 612, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setForeground(Color.BLACK);
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 36), new java.awt.Color(153, 208, 249)));
		panel.setBounds(0, 0, 596, 337);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel pane2 = new JPanel();
		pane2.setBackground(new Color(102, 205, 170));
		pane2.setForeground(Color.BLACK);
		pane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 15), new java.awt.Color(255, 255, 255)));
		pane2.setBounds(36, 60, 528, 251);
		panel.add(pane2);
		pane2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Current Password");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 59, 134, 29);
		pane2.add(lblNewLabel);
		
		JLabel lblcnew = new JLabel("Confirm New Password");
		lblcnew.setFont(new Font("Arial", Font.BOLD, 12));
		lblcnew.setBounds(38, 139, 150, 29);
		pane2.add(lblcnew);
		
		JLabel lblnewpwd = new JLabel("New Password");
		lblnewpwd.setFont(new Font("Arial", Font.BOLD, 12));
		lblnewpwd.setBounds(38, 99, 134, 29);
		pane2.add(lblnewpwd);
		
		curpwd = new JPasswordField();
		curpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		curpwd.setBounds(196, 63, 162, 25);
		pane2.add(curpwd);
		
		confpwd = new JPasswordField();
		confpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		confpwd.setBounds(198, 139, 162, 25);
		pane2.add(confpwd);
		
		newpwd = new JPasswordField();
		newpwd.setFont(new Font("Tahoma", Font.BOLD, 13));
		newpwd.setBounds(196, 103, 162, 25);
		pane2.add(newpwd);
		
		checkshow = new JCheckBox("Show Passwords");
		checkshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showpwd();
			}
		});
		checkshow.setBackground(new Color(32, 178, 170));
		checkshow.setBounds(20, 206, 134, 29);
		pane2.add(checkshow);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
			
		});
		btnclear.setBounds(269, 209, 89, 23);
		pane2.add(btnclear);
		
		JButton btnchange = new JButton("Change");
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
				
			}
		});
		btnchange.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnchange.setBounds(400, 209, 89, 23);
		pane2.add(btnchange);
		
		lblpasserr = new JLabel("");
		lblpasserr.setForeground(new Color(255, 0, 0));
		lblpasserr.setBounds(196, 174, 162, 24);
		pane2.add(lblpasserr);
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
		if(curpwd.getText().length()==0){
			lblpasserr.setText("Please Enter Old Password");
        }
        else if(newpwd.getText().length()==0){
            lblpasserr.setText("Please Enter New Password");
        }
        else if(confpwd.getText().length()==0){
            lblpasserr.setText("Please Confirm New Password");
        }
	}
	private void clear() {
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
