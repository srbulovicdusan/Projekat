package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionWindow extends JFrame{
	
	private JButton btnYes;
	private JButton btnNo;
	
	public QuestionWindow() {
		setTitle("Select an option");
		this.setBounds(180, 130, 400, 190);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A general tour was created. Do you want to create a specific tour?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 374, 87);
		getContentPane().add(lblNewLabel);
		
		btnYes = new JButton("Yes");
		btnYes.setForeground(UIManager.getColor("RadioButtonMenuItem.acceleratorSelectionForeground"));
		btnYes.setBounds(100, 89, 89, 35);
		getContentPane().add(btnYes);
		
		btnNo = new JButton("No");
		btnNo.setBounds(199, 89, 89, 35);
		getContentPane().add(btnNo);
	
		this.setVisible(true);
	}
	
	public JButton getBtnYes() {
		return btnYes;
	}
	public void setBtnYes(JButton btnYes) {
		this.btnYes = btnYes;
	}
	public JButton getBtnNo() {
		return btnNo;
	}
	public void setBtnNo(JButton btnNo) {
		this.btnNo = btnNo;
	}
	
	public void addYesButtonListener(ActionListener al){
		btnYes.addActionListener(al);
	}
	public void addNoButtonListener(ActionListener al){
		btnNo.addActionListener(al);
	}
}
