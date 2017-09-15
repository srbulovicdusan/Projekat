package view;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Tura;

public class KreiranjeOpsteTureGui extends JFrame {
	private JTextField nameField;
	private JTextField cityField;
	private JTextArea textAreaDesc;
	private JButton btnCreate;
	private JButton setPicture;
	private JLabel pictureLabel;
	private Tura tura;
	
	public JTextField getNameField() {
		return nameField;
	}
	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
	public JTextField getCityField() {
		return cityField;
	}
	public void setCityField(JTextField cityField) {
		this.cityField = cityField;
	}
	public JTextArea getTextAreaDesc() {
		return textAreaDesc;
	}
	public void setTextAreaDesc(JTextArea textAreaDesc) {
		this.textAreaDesc = textAreaDesc;
	}
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}
	
	
	public KreiranjeOpsteTureGui() {
		this.tura = new Tura();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setBounds(100, 100, 600, 450);
		setTitle("Create general tour");
		getContentPane().setLayout(null);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(47, 62, 35, 29);
		getContentPane().add(lblCity);
		
		nameField = new JTextField();
		nameField.setBounds(136, 22, 232, 29);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNameOfTour = new JLabel("Tour name");
		lblNameOfTour.setBounds(47, 22, 119, 29);
		getContentPane().add(lblNameOfTour);
		
		cityField = new JTextField();
		cityField.setBounds(136, 62, 232, 29);
		getContentPane().add(cityField);
		cityField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(47, 102, 90, 22);
		getContentPane().add(lblNewLabel);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setBounds(136, 102, 411, 101);
		getContentPane().add(textAreaDesc);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(441, 363, 105, 38);
		getContentPane().add(btnCreate);
		
		setPicture = new JButton("Set picture");
		//setPicture.setBounds(22, 228, 156, 124);
		setPicture.setBounds(48, 363, 105, 38);
		getContentPane().add(setPicture);
		

		
		this.setVisible(true);
	}
	
	public void addCreateButtonListener(ActionListener al){
		this.btnCreate.addActionListener(al);
	}
	public void addPictureButtonListener(ActionListener al){
		this.setPicture.addActionListener(al);
	}
	public boolean checkEmptyFields(){
		if (nameField.getText().compareTo("") == 0 
				|| cityField.getText().compareTo("") == 0
				|| textAreaDesc.getText().compareTo("") == 0){
			return true;
		}
		return false;
	}
	
	public void displayFieldErrorMessage(){
		JOptionPane.showMessageDialog(this, "You need to fill all fields");
	}
	
	public void displayNameErrorMessage(){
		JOptionPane.showMessageDialog(this, "A tour with the same name already exists. Enter another name.");
	}
	public Tura getTura() {
		return tura;
	}
	public void setTura(Tura tura) {
		this.tura = tura;
	}
	public void setPicture(Tura t){
		BufferedImage slika = null;
		try {
			//slika = ImageIO.read(new File(k.getSlika()));
	        ImageIcon ii = new ImageIcon(t.getSlika());//path to image
	        slika = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) slika.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, 200, 200, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pictureLabel = new JLabel(new ImageIcon(slika));
		pictureLabel.setBounds(22, 228, 156, 124);
		getContentPane().add(pictureLabel);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	
}
