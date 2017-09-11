package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Tura;

public class OpstaTuraPanel extends JPanel {

	JLabel imeLabel;
	JLabel slLabel;
	BufferedImage slika;
	JTextArea opis;
	
	public OpstaTuraPanel(Tura t){//Tura t
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	this.setBorder(BorderFactory.createEmptyBorder(0,10,30,20));
	
	imeLabel = new JLabel("OPSTA TURA"); //t.getNaziv
	
    try {
		slika = ImageIO.read(new File("res/slika1.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
    
	slLabel = new JLabel(new ImageIcon(slika)); //t.getImage
	
	opis = new JTextArea("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); //t.getOpis
	opis.setLineWrap(true);
	opis.setEditable(false);
	opis.setBackground(getBackground());
	
    this.add(slLabel);
    this.add(Box.createRigidArea(new Dimension(0,50)));
    this.add(imeLabel);
    this.add(Box.createRigidArea(new Dimension(0,50)));
    this.add(opis);
    this.add(Box.createRigidArea(new Dimension(0,50)));
    slLabel.setAlignmentX(CENTER_ALIGNMENT);
    imeLabel.setAlignmentX(CENTER_ALIGNMENT);
    opis.setAlignmentX(CENTER_ALIGNMENT);
    
	}
}
