package view;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import datechooser.beans.DateChooserCombo;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class KreiranjeKonkretneTureGui extends JFrame{
	private JTextField priceField;
	private JTextArea remarkTextArea;
	private JButton btnCreate;
	private DateChooserCombo startDateChooser;
	private DateChooserCombo endDateChooser;
	private JComboBox genTourComboBox;
	
	public DateChooserCombo getStartDateChooser() {
		return startDateChooser;
	}
	public void setStartDateChooser(DateChooserCombo startDateChooser) {
		this.startDateChooser = startDateChooser;
	}
	public DateChooserCombo getEndDateChooser() {
		return endDateChooser;
	}
	public void setEndDateChooser(DateChooserCombo endDateChooser) {
		this.endDateChooser = endDateChooser;
	}
	public JComboBox getGenTourComboBox() {
		return genTourComboBox;
	}
	public void setGenTourComboBox(JComboBox genTourComboBox) {
		this.genTourComboBox = genTourComboBox;
	}
	public JTextField getPriceField() {
		return priceField;
	}
	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}
	public JTextArea getRemarkTextArea() {
		return remarkTextArea;
	}
	public void setRemarkTextArea(JTextArea remarkTextArea) {
		this.remarkTextArea = remarkTextArea;
	}
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}
	
	public KreiranjeKonkretneTureGui() {
		setTitle("Create specific tour");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setBounds(10, 13, 79, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(10, 54, 69, 14);
		getContentPane().add(lblEndDate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 94, 79, 14);
		getContentPane().add(lblPrice);
		
		priceField = new JTextField();
		priceField.setBounds(67, 88, 99, 26);
		getContentPane().add(priceField);
		priceField.setColumns(10);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setBounds(10, 129, 46, 14);
		getContentPane().add(lblRemark);
		
		remarkTextArea = new JTextArea();
		remarkTextArea.setBounds(66, 124, 357, 60);
		getContentPane().add(remarkTextArea);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(320, 212, 91, 39);
		getContentPane().add(btnCreate);
		
		startDateChooser = new DateChooserCombo();
		startDateChooser.setBounds(68, 11, 155, 20);
		getContentPane().add(startDateChooser);
		
		endDateChooser = new DateChooserCombo();
		endDateChooser.setBounds(68, 52, 155, 20);
		getContentPane().add(endDateChooser);
		
		JLabel lblGeneralTour = new JLabel("General tour");
		lblGeneralTour.setBounds(10, 195, 79, 14);
		getContentPane().add(lblGeneralTour);
		
		genTourComboBox = new JComboBox();
		genTourComboBox.setBounds(87, 195, 147, 20);
		getContentPane().add(genTourComboBox);
		
		this.setVisible(true);
	}
	
	public void addbtnCreateSpecTourListener(ActionListener al){
		btnCreate.addActionListener(al);
	}
	
	public boolean checkEmptyFields(){
		if (priceField.getText().compareTo("") == 0 
				|| startDateChooser.getText().compareTo("") == 0
				|| endDateChooser.getText().compareTo("") == 0
				//|| genTourComboBox.? == 0
				){
			return true;
		}
		return false;
	}
	
	public void displayFieldErrorMessage(){	
		JOptionPane.showMessageDialog(this, "You need to fill all fields");
	}
}
