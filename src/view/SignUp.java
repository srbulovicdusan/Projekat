package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp {

	private JFrame frmSignup;
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignup = new JFrame();
		frmSignup.setTitle("SignUp");
		frmSignup.setBounds(100, 100, 450, 300);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignup.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(39, 46, 61, 21);
		frmSignup.getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(111, 43, 115, 27);
		frmSignup.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(247, 49, 52, 14);
		frmSignup.getContentPane().add(lblNewLabel_1);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(309, 43, 115, 27);
		frmSignup.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 96, 35, 14);
		frmSignup.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(111, 90, 152, 27);
		frmSignup.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(39, 150, 61, 14);
		frmSignup.getContentPane().add(lblNewLabel_2);
		
		userNameField = new JTextField();
		userNameField.setBounds(111, 144, 115, 27);
		frmSignup.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(247, 150, 46, 14);
		frmSignup.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 144, 115, 27);
		frmSignup.getContentPane().add(passwordField);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBounds(174, 202, 92, 34);
		frmSignup.getContentPane().add(btnSignup);
		
		frmSignup.setVisible(true);
	}

}
