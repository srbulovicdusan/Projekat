package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
	
	JLabel filterLabel;
	JLabel cenaLabel;
	JLabel mestoLabel;
	JTextField cenaTxt;
	JTextField mestoTxt;
	JButton pretraziButton;
	
	public FilterPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 200));
		filterLabel = new JLabel("Filter");
		cenaLabel = new JLabel("Cena");
	    mestoLabel = new JLabel("Mesto");
	    
	    cenaTxt = new JTextField();
	    cenaTxt.setMaximumSize(new Dimension(150,20));
	   // cenaTxt.setMinimumSize(new Dimension(150,20));
	    
	    mestoTxt = new JTextField();
	    mestoTxt.setMaximumSize(new Dimension(300,20));
	   // mestoTxt.setMinimumSize(new Dimension(300,20));
	    
	    pretraziButton = new JButton("Pretrazi");
	    
	    this.add(filterLabel);
	    this.add(Box.createRigidArea(new Dimension(0,50)));
	    this.add(cenaLabel);
	    this.add(cenaTxt);
	    this.add(Box.createRigidArea(new Dimension(0,50)));
	    this.add(mestoLabel);
	    this.add(mestoTxt);
	    this.add(Box.createRigidArea(new Dimension(0,50)));
	    this.add(pretraziButton);
	}

}
