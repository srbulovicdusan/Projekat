package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Tura;
public class TuraGui extends JPanel {

	ImageIcon slika;
    JButton open;
    JTextArea opis;
    JButton change;
    JButton delete;
    Tura tura;

	//
	//
	//
	//
	public TuraGui(Tura t){ //arg Tura t
		this.tura = t;
		this.setLayout((new BoxLayout(this, BoxLayout.LINE_AXIS)));
	    this.setAlignmentX(Component.LEFT_ALIGNMENT);
	    this.setBackground(Color.white);
		if (t.getSlika() == null){
			slika = new ImageIcon("res/slika1.jpg");
		}else{
			slika = new ImageIcon(t.getSlika());  //t.getImage
		}
		Image img = slika.getImage() ;  
		Image newimg = img.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);  
		slika = new ImageIcon(newimg);
	    open = new JButton(slika);
	    opis = new JTextArea();
	    opis.setMaximumSize(new Dimension(600,150));
	    opis.setLineWrap(true);
	    opis.setEditable(false);
	    opis.setFont(new Font("Default", 0, 14));
	    opis.setText("Naziv: " + t.getNaziv() + "\n\nMesto: " + t.getGrad() + "\n\nVodic: "+ t.getVodic().getIme() + " " + t.getVodic().getPrezime() +"\n\nOpis: " + t.getOpis()); //t.getOpis()

	    this.add(open);
	    this.add(Box.createRigidArea(new Dimension(30,0)));
	    this.add(opis);
	    
	}
	public void addGuideButtons(){
		if (change == null && delete == null){
			change = new JButton("Change");
			delete = new JButton("Delete");
		    delete.setMaximumSize(change.getMaximumSize());
			JPanel panel = new JPanel();
			panel.setLayout((new BoxLayout(panel, BoxLayout.PAGE_AXIS)));
			panel.setBackground(Color.white);
			panel.add(change);
			panel.add(Box.createRigidArea(new Dimension(0,30)));
			panel.add(delete);
			panel.setAlignmentY(CENTER_ALIGNMENT);
			//this.add(Box.createRigidArea(new Dimension(30,0)));
			this.add(panel);
		}
	}
	
	public JButton getOpen(){
		return open;
	}
	public void setOpen(JButton open){
		this.open = open;
	}
	public JButton getChange() {
		return change;
	}
	public void setChange(JButton change) {
		this.change = change;
	}
	public JButton getDelete() {
		return delete;
	}
	public void setDelete(JButton delete) {
		this.delete = delete;
	}
	public Tura getTura() {
		return tura;
	}
	public void setTura(Tura tura) {
		this.tura = tura;
	}
	
}
