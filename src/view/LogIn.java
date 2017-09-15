package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogIn extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("LogIn");
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(54, 47, 64, 36);
		this.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 102, 64, 36);
		this.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(166, 51, 127, 28);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 106, 127, 28);
		this.getContentPane().add(passwordField);
		
		btnLogin = new JButton("LogIn");
		btnLogin.setBounds(166, 184, 94, 36);
		this.getContentPane().add(btnLogin);
		this.getRootPane().setDefaultButton(btnLogin);
		this.setVisible(true);
		
	}
	public String getUserNameText(){
		return this.textField.getText();
	}
	public String getPassword(){
		return this.passwordField.getText();
	}
	public void addOkButtonListener(ActionListener al){
		this.btnLogin.addActionListener(al);
	}
	public void displayErrorMessage(){
		
		JOptionPane.showMessageDialog(this, "Wrong username or password, please try again.");
	}
	
	
	
}
