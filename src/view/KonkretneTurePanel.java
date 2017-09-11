package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.KonkretnaTura;
import model.Tura;

public class KonkretneTurePanel extends JPanel {

	public KonkretneTurePanel(ArrayList<KonkretnaTura> ture){ //arg ArrayList<Tura>
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 0));
		this.setBackground(Color.white);
			    
	    this.addTura(ture);
		
	}
	
	public void addTura(ArrayList<KonkretnaTura> ture){ // arg ArrayList<Tura>

		/* Kada budu bile napravljene ture, samo ova for petlja ce stojati
		for(KonkretnaTura t : ture){
			
			KonkretnaTuraGui turaGui = new KonkretnaTuraGui(t);
			this.add(turaGui);
		    this.add(Box.createRigidArea(new Dimension(0,100)));
		}
		*/
		KonkretnaTura t = new KonkretnaTura();
		KonkretnaTuraGui turaGui = new KonkretnaTuraGui(t);
	    this.add(turaGui);   
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	   
		KonkretnaTura t2 = new KonkretnaTura();
		KonkretnaTuraGui turaGui2 = new KonkretnaTuraGui(t2);
	    this.add(turaGui2);   
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	    
		KonkretnaTura t3 = new KonkretnaTura();
		KonkretnaTuraGui turaGui3 = new KonkretnaTuraGui(t3);
	    this.add(turaGui3);   
	    this.add(Box.createRigidArea(new Dimension(0,100)));

		KonkretnaTura t4 = new KonkretnaTura();
		KonkretnaTuraGui turaGui4 = new KonkretnaTuraGui(t4);
	    this.add(turaGui4);   
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	    
		KonkretnaTura t5 = new KonkretnaTura();
		KonkretnaTuraGui turaGui5 = new KonkretnaTuraGui(t5);
	    this.add(turaGui5);   
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	}
}
