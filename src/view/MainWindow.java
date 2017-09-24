package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import model.Korisnik;
import model.Tura;
import model.Vodic;

public class MainWindow extends JFrame {

	// treba da se doda FilterPanel u atr

	private JButton logInB;
	private JButton signUpB;

	private JToolBar toolbar;
	private ProfilPanel profilePanel;
	private TuraPanel MyToursPanel;
	private KonkretneTurePanel MyReservationsPanel;
	
	private FilterPanel filterPanel;
	private KonkretneTurePanel konkretneTure;

	private JScrollPane scrollPanel;
	private TuraPanel turaPanel;
	
	private JTabbedPane tabbedPane;
	
	
	public JButton getLogInB() {
		return logInB;
	}
	public void setLogInB(JButton logInB) {
		this.logInB = logInB;
	}
	public JButton getSignUpB() {
		return signUpB;
	}
	public void setSignUpB(JButton signUpB) {
		this.signUpB = signUpB;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}
	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}
	public ProfilPanel getProfilePanel() {
		return profilePanel;
	}
	public void setProfilePanel(ProfilPanel profilePanel) {
		this.profilePanel = profilePanel;
	}
	public MainWindow(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		
		//this.setLocationRelativeTo(null);//centrira u odnosu na ekran
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setSize(dim.width, dim.height);
		this.setLocation(0,0);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mite");
		this.tabbedPane = new JTabbedPane();
		this.addToolBar();
		this.addFilterPanel();
		this.addTuraPanel(ture);
		//this.tabbedPane.addTab("All Tours", scrollPanel);
		this.add(tabbedPane, BorderLayout.CENTER);
		//creating empty profile panel
		this.profilePanel = new ProfilPanel();
		this.add(this.profilePanel, BorderLayout.EAST);
		this.setVisible(true);
		
	}
	public void addFilterPanel(){
		filterPanel = new FilterPanel();
		this.add(filterPanel,BorderLayout.WEST);
	}
	public void addToolBar(){
		toolbar = new JToolBar();
		toolbar.setRollover(true);
		logInB = new JButton("LogIn");
		signUpB = new JButton("SignUp");
		toolbar.add(logInB);
		toolbar.add(signUpB);
		toolbar.addSeparator();
		this.add(toolbar,BorderLayout.NORTH);
	}
	
	public void addTuraPanel(ArrayList<Tura> ture){ //arg ArrayList<Tura>
		turaPanel = new TuraPanel(ture);
		scrollPanel = new JScrollPane(turaPanel);
		scrollPanel.setName("All Tours");
		this.tabbedPane.add(scrollPanel, 0);
		//this.add(turaPanel, BorderLayout.CENTER);
		
	}
	
	public TuraPanel getTuraPanel() {
		return turaPanel;
	}
	
	
	public void setTuraPanel  (ArrayList<Tura> p_ture) {
		//this.tabbedPane.remove(turaPanel);
		this.tabbedPane.remove(scrollPanel);
		this.addTuraPanel(p_ture);
	}
	
	
	
	public void addProfilePanel(Korisnik k){
		ProfilPanel newProfilPanel;
		if (k.getOsoba() instanceof Vodic){
			newProfilPanel = new ProfilPanelVodic(k);
		}else{
			//new ProfilPanelTurista
			newProfilPanel = new ProfilPanel(k);
		}
		//dodato
		this.remove(profilePanel);
		this.profilePanel = newProfilPanel;
		//
		
		this.add(newProfilPanel, BorderLayout.EAST);
	}
	public void addLoginListener(ActionListener al){
		this.logInB.addActionListener(al);
	}
	public void addSignListener(ActionListener al){
		this.signUpB.addActionListener(al);
	}
	/*public Korisnik getTrenutniKorisnik() {
		return trenutniKorisnik;
	}
	public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
		this.trenutniKorisnik = trenutniKorisnik;
	}
	*/
	
	public FilterPanel getFilterPanel() {
		return filterPanel;
	}
	public TuraPanel getMyToursPanel() {
		return MyToursPanel;
	}
	public void setMyToursPanel(TuraPanel myToursPanel) {
		MyToursPanel = myToursPanel;
	}
	public KonkretneTurePanel getMyReservationsPanel() {
		return MyReservationsPanel;
	}
	public void setMyReservationsPanel(KonkretneTurePanel myReservationsPanel) {
		MyReservationsPanel = myReservationsPanel;
	}
	public KonkretneTurePanel getKonkretneTure() {
		return konkretneTure;
	}
	public void setKonkretneTure(KonkretneTurePanel konkretneTure) {
		this.konkretneTure = konkretneTure;
	}



}
