package view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.Tura;
public class TuraPanel extends JPanel{

	
	
	public TuraPanel(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 0));
		this.setBackground(Color.white);
		this.addTura(ture);
	}
	
	public void addTura(ArrayList<Tura> ture){ // arg ArrayList<Tura>

		/* Kada budu bile napravljene ture, samo ova for petlja ce stojati
		for(Tura t : ture){
			
			TuraGui turaGui = new TuraGui(t);
			this.add(turaGui);
		    this.add(Box.createRigidArea(new Dimension(0,100)));
		}
		*/
		Tura t = new Tura();
		TuraGui turaGui = new TuraGui(t);
	    this.add(turaGui);
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	    Tura t1 = new Tura();
	    TuraGui turaGui2 = new TuraGui(t1);
	    this.add(turaGui2);
	    this.add(Box.createRigidArea(new Dimension(0,100)));
	}
}
