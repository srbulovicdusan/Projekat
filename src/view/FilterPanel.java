package view;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
	
	private JLabel filterLabel;
	private JLabel mestoLabel;
	private JLabel nazivTureLabel;
	private JTextField mestoTxt;
	private JTextField nazivTxt;
	private JButton pretraziButton;
	
	public FilterPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 200));
		filterLabel = new JLabel("SEARCH");
	    mestoLabel = new JLabel("Destination: ");
	    nazivTureLabel = new JLabel("Tour name: ");
	    
	    mestoTxt = new JTextField();
	    mestoTxt.setMaximumSize(new Dimension(300,20));
	    
	    nazivTxt = new JTextField();
	    nazivTxt.setMaximumSize(new Dimension(300,20));
	
	    pretraziButton = new JButton("Search");
	    
	    
	    this.add(filterLabel);
	    this.add(Box.createRigidArea(new Dimension(0,20)));
	    this.add(mestoLabel);
	    this.add(mestoTxt);
	    this.add(Box.createRigidArea(new Dimension(0,10)));
	    this.add(nazivTureLabel);
	    this.add(nazivTxt);
	    this.add(Box.createRigidArea(new Dimension(0,6)));
	    this.add(pretraziButton);
	}

	public JTextField getMestoTxt() {
		return mestoTxt;
	}

	public void setMestoTxt(JTextField mestoTxt) {
		this.mestoTxt = mestoTxt;
	}
	
	public JTextField getNazivTureTxt() {
		return nazivTxt;
	}
	
	public void setNazivTureTxt(JTextField nazivTureTxt) {
		this.nazivTxt = nazivTureTxt;
	}
	public void addPretraziListener(ActionListener al){
		this.pretraziButton.addActionListener(al);
	}

}
