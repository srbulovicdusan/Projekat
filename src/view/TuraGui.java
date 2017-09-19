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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Tura;
public class TuraGui extends JPanel {

	ImageIcon slika;
    JButton button;
    JTextArea opis;
	//
	//
	//
	//
	public TuraGui(Tura t){ //arg Tura t

		this.setLayout((new BoxLayout(this, BoxLayout.LINE_AXIS)));
	    this.setAlignmentX(Component.LEFT_ALIGNMENT);
	    this.setBackground(Color.white);
		if (t.getSlika() == null){
			slika = new ImageIcon("res/slika1.jpg");
		}else{
			slika = new ImageIcon(t.getSlika());  //t.getImage
		}
		Image img = slika.getImage() ;  
		Image newimg = img.getScaledInstance( 200, 150,  java.awt.Image.SCALE_SMOOTH ) ;  
		slika = new ImageIcon( newimg );
	    button = new JButton(slika);
	    opis = new JTextArea();
	    opis.setMaximumSize(new Dimension(700,150));
	    opis.setLineWrap(true);
	    opis.setEditable(false);
	    opis.setFont(new Font("Default", 0, 14));
	    opis.setText("Naziv: " + t.getNaziv() + "\n\nMesto: " + t.getGrad() + "\n\nVodic: "+ t.getVodic().getIme() + " " + t.getVodic().getPrezime() +"\n\nOpis: " + t.getOpis()); //t.getOpis()

	    this.add(button);
	    this.add(Box.createRigidArea(new Dimension(30,0)));
	    this.add(opis);
	    
	}
}
