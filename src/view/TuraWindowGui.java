package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import model.KonkretnaTura;
import model.Korisnik;
import model.Tura;

public class TuraWindowGui extends JFrame {

	OpstaTuraPanel opstaTuraPanel;
	KonkretneTurePanel turaPanel;
	ProfilPanel profilPanel;
	Korisnik k;
	
	public TuraWindowGui(Tura t){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setSize(dim.width, dim.height);
		this.setLocation(0,0);
		//ovo iznad je isto za centriranje
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mite");
		
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);
		
		JButton logInB = new JButton("LogIn");
		JButton signUpB = new JButton("SignUp");
		toolbar.add(logInB);
		toolbar.add(signUpB);
		toolbar.addSeparator();
		this.add(toolbar,BorderLayout.NORTH);
		
		
		this.addOpstaTura(t);
		this.addKonkretneTure(null); //t.getKonkretneTure()
		//if logedIn
		this.addProfilPanel(k);
		
		
		this.setVisible(true);
	}

	public void addOpstaTura(Tura t){
		opstaTuraPanel = new OpstaTuraPanel(t);
		this.add(opstaTuraPanel,BorderLayout.WEST);
	}
	
	public void addKonkretneTure(ArrayList<KonkretnaTura> ture){
		turaPanel = new KonkretneTurePanel(ture);
		JScrollPane scrollPane = new JScrollPane(turaPanel);
		this.add(scrollPane,BorderLayout.CENTER);
	}
	
	public void addProfilPanel(Korisnik k){
		profilPanel = new ProfilPanel(k);
		this.add(profilPanel, BorderLayout.EAST);
	}
	
}
