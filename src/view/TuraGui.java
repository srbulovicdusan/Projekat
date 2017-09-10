package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
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
		
		slika = new ImageIcon("res/slika1.jpg"); //t.getImage
	    button = new JButton(slika);
	    opis = new JTextArea();
	    opis.setMaximumSize(new Dimension(700,50));
	    opis.setLineWrap(true);
	    opis.setEditable(false);
	    opis.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); //t.getOpis()
	    
	    this.add(button);
	    this.add(Box.createRigidArea(new Dimension(50,0)));
	    this.add(opis);
	}
}
