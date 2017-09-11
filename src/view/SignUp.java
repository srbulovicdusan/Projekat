package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp extends JFrame{
	JButton btnSignup;
	private JTextField nameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	public JTextField getUserNameField() {
		return userNameField;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(JTextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public void setUserNameField(JTextField userNameField) {
		this.userNameField = userNameField;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("SignUp");
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(39, 46, 61, 21);
		this.getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(111, 43, 115, 27);
		this.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(247, 49, 52, 14);
		this.getContentPane().add(lblNewLabel_1);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(309, 43, 115, 27);
		this.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 96, 35, 14);
		this.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(111, 90, 152, 27);
		this.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(39, 150, 61, 14);
		this.getContentPane().add(lblNewLabel_2);
		
		userNameField = new JTextField();
		userNameField.setBounds(111, 144, 115, 27);
		this.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(247, 150, 46, 14);
		this.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 144, 115, 27);
		this.getContentPane().add(passwordField);
		
		btnSignup = new JButton("SignUp");
		btnSignup.setBounds(174, 202, 92, 34);
		this.getContentPane().add(btnSignup);
		
		this.setVisible(true);

	}

	public void addOkButtonListener(ActionListener al){
		btnSignup.addActionListener(al);
	}
	public boolean checkEmptyFields(){
		if (nameField.getText().compareTo("") == 0 
				|| lastNameField.getText().compareTo("") == 0
				|| emailField.getText().compareTo("") == 0
				|| userNameField.getText().compareTo("") == 0
				|| passwordField.getText().compareTo("") == 0){
			return true;
		}
		return false;
	}
	public void displayFieldErrorMessage(){
		
		JOptionPane.showMessageDialog(this, "You need to fill all fields");
	}
	public void displayUserErrorMessage(){
		
		JOptionPane.showMessageDialog(this, "Username you entered already exists. Try another one.");
	}

}
