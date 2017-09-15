package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Tura;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class KreiranjeOpsteTureGui extends JFrame {
	private JTextField nameField;
	private JTextField cityField;
	private JTextArea textAreaDesc;
	private JButton btnCreate;
	
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
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setBounds(100, 100, 450, 300);
		setTitle("Create general tour");
		getContentPane().setLayout(null);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(47, 62, 35, 29);
		getContentPane().add(lblCity);
		
		nameField = new JTextField();
		nameField.setBounds(136, 22, 136, 29);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNameOfTour = new JLabel("Tour name");
		lblNameOfTour.setBounds(47, 22, 119, 29);
		getContentPane().add(lblNameOfTour);
		
		cityField = new JTextField();
		cityField.setBounds(136, 62, 136, 29);
		getContentPane().add(cityField);
		cityField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(47, 102, 90, 22);
		getContentPane().add(lblNewLabel);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setBounds(136, 102, 275, 101);
		getContentPane().add(textAreaDesc);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(294, 222, 90, 29);
		getContentPane().add(btnCreate);
		
		this.setVisible(true);
	}
	
	public void addCreateButtonListener(ActionListener al){
		this.btnCreate.addActionListener(al);
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
	
	
	
}
