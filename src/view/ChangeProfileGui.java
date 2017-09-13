package view;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Korisnik;

public class ChangeProfileGui extends JFrame{
	private JButton btnOk;
	private JButton btnChange;
	private JTextField nameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField userNameField;
	private JTextField passwordField;
	private BufferedImage slika;
	private JLabel slLabel;
	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Korisnik k) {
		this.setTitle("Profile");
		this.setBounds(100, 100, 500, 400);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(39, 22, 61, 21);
		this.getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(110, 19, 115, 27);
		nameField.setText(k.getOsoba().getIme());
		this.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(275, 25, 70, 18);
		this.getContentPane().add(lblNewLabel_1);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(350, 19, 121, 27);
		lastNameField.setText(k.getOsoba().getPrezime());
		this.getContentPane().add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 70, 35, 14);
		this.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(110, 64, 152, 27);
		emailField.setText(k.getEmail());
		this.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(39, 116, 61, 14);
		this.getContentPane().add(lblNewLabel_2);
		
		userNameField = new JTextField();
		userNameField.setBounds(110, 110, 115, 27);
		userNameField.setText(k.getKorisnickoIme());
		this.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(280, 116, 70, 14);
		this.getContentPane().add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(350, 110, 115, 27);
		passwordField.setText(k.getLozinka());
		this.getContentPane().add(passwordField);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(360, 300, 98, 43);
		this.getContentPane().add(btnOk);
		
		btnChange = new JButton("Change");
		btnChange.setBounds( 65 ,310,98, 25);
		this.getContentPane().add(btnChange);
		if (k.getSlika() == null){
			k.setSlika("res/slika3.png"); //set default picture
		}
	    try {
			//slika = ImageIO.read(new File(k.getSlika()));
	        ImageIcon ii = new ImageIcon(k.getSlika());//path to image
	        slika = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) slika.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, 150, 150, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		slLabel = new JLabel(new ImageIcon(slika));
		slLabel.setBounds(39, 150, 150, 150);
		this.add(slLabel);
		
		/*
		rdbtnGuide = new JRadioButton("Guide");
		rdbtnGuide.setBounds(41, 162, 109, 23);
		rdbtnTourist = new JRadioButton("Tourist");
		rdbtnTourist.setBounds(41, 210, 109, 23);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnGuide);
		group.add(rdbtnTourist);
		rdbtnGuide.setSelected(true);
		getContentPane().add(rdbtnGuide);
		getContentPane().add(rdbtnTourist);
		
		
		*/
		this.setVisible(true);
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnChange() {
		return btnChange;
	}

	public void setBtnChange(JButton btnChange) {
		this.btnChange = btnChange;
	}

	public BufferedImage getSlika() {
		return slika;
	}

	public void setSlika(BufferedImage slika) {
		this.slika = slika;
	}

	public JLabel getSlLabel() {
		return slLabel;
	}

	public void setSlLabel(JLabel slLabel) {
		this.slLabel = slLabel;
	}

	public void addOkButtonListener(ActionListener al){
		btnOk.addActionListener(al);
	}
	public void addChangeButtonListener(ActionListener al){
		btnChange.addActionListener(al);
	}
	public ChangeProfileGui(Korisnik k) {
		initialize(k);
	}

	public JButton getBtnSignup() {
		return btnOk;
	}

	public void setBtnSignup(JButton btnSignup) {
		this.btnOk = btnOk;
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

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

	public void setUserNameField(JTextField userNameField) {
		this.userNameField = userNameField;
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
	public void changeImage(Korisnik k){
	    try {
			//slika = ImageIO.read(new File(k.getSlika()));
	        ImageIcon ii = new ImageIcon(k.getSlika());//path to image
	        slika = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) slika.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, 150, 150, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    this.remove(slLabel);
		slLabel = new JLabel(new ImageIcon(slika));
		slLabel.setBounds(39, 150, 150, 150);
		this.add(slLabel);
	}
	

	public void displayFieldErrorMessage(){
		
		JOptionPane.showMessageDialog(this, "You need to fill all fields");
	}
	public void displayUserErrorMessage(){
		
		JOptionPane.showMessageDialog(this, "Username you entered already exists. Try another one.");
	}

}
