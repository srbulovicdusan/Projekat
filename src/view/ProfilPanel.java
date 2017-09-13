package view;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Korisnik;

public class ProfilPanel extends JPanel{

		JLabel imeLabel;
		JLabel slLabel;
		BufferedImage slika;
		JTextArea opis;
		JButton changeProfile;
	public ProfilPanel(Korisnik k){//arg Korisnik k

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0,10,30,20));
		imeLabel = new JLabel(k.getOsoba().getIme() + " "  + k.getOsoba().getPrezime()); //k.getOsoba().getIme() + " " + k.getOsoba().getPrezime()
		if (k.getSlika() == null){
			k.setSlika("res/slika3.png"); //set default picture
		}
	    try {
			//slika = ImageIO.read(new File(k.getSlika()));
	        ImageIcon ii = new ImageIcon(k.getSlika());//path to image
	        slika = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) slika.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, 200, 200, null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("aaa");
		}
		slLabel = new JLabel(new ImageIcon(slika));
		changeProfile = new JButton("Change profile");
	    this.add(slLabel);
	    this.add(Box.createRigidArea(new Dimension(0,50)));
	    this.add(imeLabel);
	    this.add(Box.createRigidArea(new Dimension(0,50)));
	    this.add(changeProfile);
	    changeProfile.setAlignmentX(CENTER_ALIGNMENT);
	    slLabel.setAlignmentX(CENTER_ALIGNMENT);
	    imeLabel.setAlignmentX(CENTER_ALIGNMENT);
	    
	}
	//creating empty profile panel
	public ProfilPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(0,10,30,220));
		
	}
	public void addChangeButtonListener(ActionListener al){
		this.changeProfile.addActionListener(al);
	}
}
