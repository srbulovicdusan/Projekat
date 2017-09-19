package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

import model.Korisnik;

public class ProfilPanelVodic extends ProfilPanel {
	
	private JButton createGeneralTour;
	private JButton createSpecificTour;
	
	public ProfilPanelVodic(Korisnik k){
		super(k);
		createGeneralTour = new JButton("Create general tour");
		createSpecificTour = new JButton("Create specific tour");
	    this.add(createGeneralTour);
	    this.add(Box.createRigidArea(new Dimension(0,20)));
	    this.add(createSpecificTour);
	    this.add(Box.createRigidArea(new Dimension(0,20)));
	    createGeneralTour.setAlignmentX(CENTER_ALIGNMENT);
	    createSpecificTour.setAlignmentX(CENTER_ALIGNMENT);
	    
	}
	public void addCreateGenTourButtonListener(ActionListener al){
		createGeneralTour.addActionListener(al);
	}
	public void addCreateSpecTourButtonListener(ActionListener al){
		this.createSpecificTour.addActionListener(al);
	}

}
