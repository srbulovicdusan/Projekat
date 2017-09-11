package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import model.Korisnik;
import model.Tura;

public class MainWindow extends JFrame {


	JButton logInB;
	JButton signUpB;
	
	JToolBar toolbar;


	Korisnik k;

	
	public MainWindow(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		
		//this.setLocationRelativeTo(null);//centrira u odnosu na ekran
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
		
		toolbar = new JToolBar();
		toolbar.setRollover(true);
		
		logInB = new JButton("LogIn");
		signUpB = new JButton("SignUp");
		toolbar.add(logInB);
		toolbar.add(signUpB);
		toolbar.addSeparator();
		this.add(toolbar,BorderLayout.NORTH);
	    
		//logInB.addActionListener(this);
		//signUpB.addActionListener(this);
		
		this.addFilterPanel();
		this.addTuraPanel(ture);
		//If loged in
		this.addProfilePanel(k);
		
		
		this.setVisible(true);
		
	}
	public void addFilterPanel(){
		FilterPanel filterPanel = new FilterPanel();
		this.add(filterPanel,BorderLayout.WEST);
	}
	
	public void addTuraPanel(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		TuraPanel turaPanel = new TuraPanel(ture);
		 JScrollPane scrollPane = new JScrollPane(turaPanel);
		 this.add(scrollPane,BorderLayout.CENTER);
		//this.add(turaPanel, BorderLayout.CENTER);
		
	}
	public void addProfilePanel(Korisnik k){
		ProfilPanel profilPanel = new ProfilPanel(k);
		this.add(profilPanel, BorderLayout.EAST);
	}
	public void addLoginListener(ActionListener al){
		this.logInB.addActionListener(al);
	}
	public void addSignListener(ActionListener al){
		this.signUpB.addActionListener(al);
	}

}
