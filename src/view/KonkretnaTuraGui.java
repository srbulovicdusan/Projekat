package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.KonkretnaTura;
import model.Tura;

public class KonkretnaTuraGui extends JPanel {

	BufferedImage slika;
    JButton rezervisi;
    JLabel datumPocetka;
    JLabel datumZavrsetka;
    JLabel slLabel;
    JTextArea opis;

	public KonkretnaTuraGui(KonkretnaTura t){ //arg Tura t

		this.setLayout((new BoxLayout(this, BoxLayout.LINE_AXIS)));
	    this.setAlignmentX(Component.LEFT_ALIGNMENT);
	    this.setBackground(Color.white);
		
	    try {
			slika = ImageIO.read(new File("res/slika1.jpg"));//t.getSlika
		} catch (IOException e) {
			e.printStackTrace();
		}
	    rezervisi = new JButton("Rezervisi");
	    slLabel = new JLabel(new ImageIcon(slika)); 
	    opis = new JTextArea();
	    opis.setMaximumSize(new Dimension(700,50));
	    opis.setLineWrap(true);
	    opis.setEditable(false);
	    opis.setText("23.4.2016 - 25.4.2016 " + "\n" + "NAPOMENE: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); 
	  //t.getDatumPoc + "-" + t.getDatumZavr + "\n" + "NAPOMENE: " + t.getOpis/Napo
	    this.add(slLabel);
	    this.add(Box.createRigidArea(new Dimension(50,0)));
	    this.add(opis);
	    this.add(Box.createRigidArea(new Dimension(50,0)));
	    this.add(rezervisi);
	    
	}
}
