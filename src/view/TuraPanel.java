package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Tura;

public class TuraPanel extends JPanel{	
	
	// izdvoji arraylist<TuraGui>
	
	//private ArrayList<TuraGui>
	
	public TuraPanel(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 0));
		this.setBackground(Color.white);
			    
	    this.addTureGui(ture);
		
	}
	public TuraPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 0));
		this.setBackground(Color.white);
	}
	
	public void addTura(Tura t){
			TuraGui turaGui = new TuraGui(t);
			this.add(turaGui);
		    this.add(Box.createRigidArea(new Dimension(0,100)));
			SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void addTureGui(ArrayList<Tura> ture){ // arg ArrayList<Tura>

		
		for(Tura t : ture){
			TuraGui turaGui = new TuraGui(t);
			this.add(turaGui);
		    this.add(Box.createRigidArea(new Dimension(0,100)));
		}
		
		SwingUtilities.updateComponentTreeUI(this);

	}
	public void addGuideButtons(){
		for (Component turaGui: this.getComponents()){
			if (turaGui instanceof TuraGui){
				((TuraGui) turaGui).addGuideButtons();
			}
		}
	}
	public void addGuideListeners(ActionListener changeListener, ActionListener deleteListener){
		for (Component turaGui: this.getComponents()){
			if (turaGui instanceof TuraGui){
				((TuraGui) turaGui).getChange().addActionListener(changeListener);
				((TuraGui) turaGui).getDelete().addActionListener(deleteListener);
			}
		}
	}
}
