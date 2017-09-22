package contoller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Application;
import model.KonkretnaTura;
import model.Korisnik;
import model.Rezervacija;
import model.Tura;
import model.Turista;
import model.Vodic;
import view.ChangeProfileGui;
import view.KonkretnaTuraGui;
import view.KonkretneTurePanel;
import view.KreiranjeKonkretneTureGui;
import view.KreiranjeOpsteTureGui;
import view.LogIn;
import view.MainWindow;
import view.ProfilPanel;
import view.ProfilPanelVodic;
import view.QuestionWindow;
import view.SignUp;
import view.TuraGui;
import view.TuraPanel;

public class Controller {
	private MainWindow mainWindow; //viewer
	private LogIn logIn;
	private SignUp signUp;
	private ChangeProfileGui changeProfileGui;
	private Application application; //model
	private KreiranjeOpsteTureGui generalTourWindow;
	private KreiranjeKonkretneTureGui specificTourWindow;
	private QuestionWindow qw;
	
	public Controller(MainWindow mainWindow, Application application){
		this.mainWindow = mainWindow;
		this.application = application;
		mainWindow.addLoginListener(new LoginListener());
		mainWindow.addSignListener(new SignUpListener());
		mainWindow.getFilterPanel().addPretraziListener(new FilterSearchButton());
		this.addListenerToGeneralTours();

	}
	
	//Dodavanje OpenGeneralTourListener TuraGui-ju
	public void addListenerToGeneralTours(){
		for(Component opstaTuraGui : mainWindow.getTuraPanel().getComponents()) {
			if(opstaTuraGui instanceof TuraGui){
				((TuraGui) opstaTuraGui).getOpen().addActionListener(new OpenGeneralTourListener());
			}
		}
	}
	
	class OpenGeneralTourListener implements ActionListener{
		private TuraGui turaGui;
		private Tura tura;
		
		public OpenGeneralTourListener(){
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton button = (JButton)arg0.getSource();
			turaGui = (TuraGui) button.getParent();
			tura = turaGui.getTura();
			KonkretneTurePanel kTurePanel = new KonkretneTurePanel(tura.getKonkretneTure());
			for(KonkretnaTuraGui ktG : kTurePanel.getKonkretneTureGui()){
				ktG.addReservationListener(new reserveSpecTour());
			}
			
			JScrollPane scrollPane = new JScrollPane(kTurePanel);
			mainWindow.getTabbedPane().addTab(tura.getNaziv(), scrollPane);
			
		}
		
	}
	
	//Listener za rezervaciju
	class reserveSpecTour implements ActionListener{
		private Turista turista;
		private KonkretnaTuraGui konkretnaTuraGui;
		private KonkretnaTura konkretnaTura;
		private Rezervacija rezervacija;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mainWindow.getTrenutniKorisnik().getOsoba() instanceof Turista){
				turista = (Turista) mainWindow.getTrenutniKorisnik().getOsoba();
				JButton button = (JButton)e.getSource();
				konkretnaTuraGui = (KonkretnaTuraGui) button.getParent();
				konkretnaTura = konkretnaTuraGui.getKonkretnaTura();
				
				rezervacija = new Rezervacija();
				rezervacija.setKonkretnaTura(konkretnaTura);
				rezervacija.setTurista(turista);
				
				turista.rezervisiTuru(rezervacija);
				konkretnaTura.dodajRezervaciju(rezervacija);
				konkretnaTuraGui.remove(button);
				//konkretnaTuraGui.addCancelReservetionListener(new CancelReservationListener());
				mainWindow.getMyReservationsPanel().add(konkretnaTuraGui);
				mainWindow.getMyReservationsPanel().add(Box.createRigidArea(new Dimension(0,100)));
				
				
			}
			
		}
		
	}
	
	class CancelReservationListener implements ActionListener{
		private Turista turista;
		private KonkretnaTuraGui konkretnaTuraGui;
		private KonkretnaTura konkretnaTura;
		private Rezervacija rezervacija;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mainWindow.getTrenutniKorisnik().getOsoba() instanceof Turista){
				turista = (Turista) mainWindow.getTrenutniKorisnik().getOsoba();
				JButton button = (JButton)e.getSource();
				konkretnaTuraGui = (KonkretnaTuraGui) button.getParent();
				konkretnaTura = konkretnaTuraGui.getKonkretnaTura();
				
				for(Rezervacija rez : turista.getRezervacije()){
					if(rez.getKonkretnaTura().equals(konkretnaTura)){
						rezervacija = rez;
					}
				}
				turista.getRezervacije().remove(rezervacija);
				konkretnaTura.getRezervacije().remove(rezervacija);
				
				mainWindow.getMyReservationsPanel().remove(konkretnaTuraGui);
				
				
			}
		}
		
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			logIn = new LogIn();
			logIn.addOkButtonListener(new OkLoginListener());
		}
	}
	class SignUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			signUp = new SignUp();
			signUp.addOkButtonListener(new OkSignListener());
		}
		
	}
	class OkLoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (application.getKorisnici() != null) {
				for (Korisnik k: application.getKorisnici()){
					if (k.getKorisnickoIme().compareTo(logIn.getUserNameText()) == 0 && k.getLozinka().compareTo(logIn.getPassword()) == 0){
						mainWindow.setTrenutniKorisnik(k);
						mainWindow.addProfilePanel(k);
						mainWindow.getProfilePanel().addChangeButtonListener(new ChangeProfileListener());// dodaj listener za dugme "change profile"
						if (mainWindow.getProfilePanel() instanceof ProfilPanelVodic){
							((ProfilPanelVodic)mainWindow.getProfilePanel()).addCreateGenTourButtonListener(new CreateGeneralTourListener());
							((ProfilPanelVodic)mainWindow.getProfilePanel()).addCreateSpecTourButtonListener(new CreateSpecificTourListener());
							loadGuideTours();
							mainWindow.getMyToursPanel().addGuideButtons();
							mainWindow.getMyToursPanel().addGuideListeners(new ChangeTourListener(),new DeleteTourListener());
						}else{
							loadTouristReservations();	
						}

						SwingUtilities.updateComponentTreeUI(mainWindow);
						logIn.setVisible(false);
						return;
					}
				}
			}
			logIn.displayErrorMessage(); // if password and username dont match
		}
		
	}
	class OkSignListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (signUp.checkEmptyFields()){
				signUp.displayFieldErrorMessage();
				return;
			}
			if (application.checkIfKorisnikExists(signUp.getUserNameField().getText())){
				signUp.displayUserErrorMessage();
				return;
			}
			Korisnik korisnik;
			if(signUp.UserIsTouristGuide()){
				korisnik = new Korisnik(signUp.getUserNameField().getText(), 
						signUp.getPasswordField().getText(),
						signUp.getEmailField().getText(), null, 
						new Vodic(signUp.getNameField().getText(), 
									signUp.getLastNameField().getText()));
			}else{
				korisnik = new Korisnik(signUp.getUserNameField().getText(), 
						signUp.getPasswordField().getText(),
						signUp.getEmailField().getText(), null, 
						new Turista(signUp.getNameField().getText(), 
								signUp.getLastNameField().getText()));
			}
			application.addKorisnik(korisnik);
			signUp.setVisible(false);
		}
		
	}
	class ChangeProfileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			changeProfileGui = new ChangeProfileGui(mainWindow.getTrenutniKorisnik());
			changeProfileGui.addOkButtonListener(new OkButtonChangeListener());
			changeProfileGui.addChangeButtonListener(new ChangeButtonListener());
		}
		
	}
	// ok dugme kada se menja profil
	class OkButtonChangeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//ovde
			if (changeProfileGui.checkEmptyFields()){
				changeProfileGui.displayFieldErrorMessage();
				return;
			}
			System.out.println(mainWindow.getTrenutniKorisnik().getKorisnickoIme());
			System.out.println(changeProfileGui.getUserNameField().getText());
			if (mainWindow.getTrenutniKorisnik().getKorisnickoIme().compareTo(changeProfileGui.getUserNameField().getText()) != 0){ 
				if (application.checkIfKorisnikExists(changeProfileGui.getUserNameField().getText())){
					changeProfileGui.displayUserErrorMessage();
					return;
				}
			}
			mainWindow.getTrenutniKorisnik().setKorisnickoIme(changeProfileGui.getUserNameField().getText());
			mainWindow.getTrenutniKorisnik().setEmail(changeProfileGui.getEmailField().getText());
			mainWindow.getTrenutniKorisnik().setLozinka(changeProfileGui.getPasswordField().getText());
			mainWindow.getTrenutniKorisnik().getOsoba().setIme(changeProfileGui.getNameField().getText());
			mainWindow.getTrenutniKorisnik().getOsoba().setPrezime(changeProfileGui.getLastNameField().getText());
			mainWindow.remove(mainWindow.getProfilePanel());
			mainWindow.setProfilePanel(new ProfilPanel(mainWindow.getTrenutniKorisnik()));
			mainWindow.getProfilePanel().addChangeButtonListener(new ChangeProfileListener());// dodaj listener za dugme "change profile"
			mainWindow.add(mainWindow.getProfilePanel(), BorderLayout.EAST);
			SwingUtilities.updateComponentTreeUI(mainWindow.getProfilePanel());
			changeProfileGui.setVisible(false);	
		}
		
	}
	// dugme za promenu slike
	class ChangeButtonListener implements ActionListener{

		@Override
        public void actionPerformed(ActionEvent ae) {
			JFileChooser fc = new JFileChooser();
			FileFilter imageFilter = new FileNameExtensionFilter(
				    "Image files", ImageIO.getReaderFileSuffixes());
			fc.setFileFilter(imageFilter);
			//fc.addChoosableFileFilter(new ImageFilter());
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                File dest = new File("res/" + file.getName());
                try {
                	if (!dest.exists()){
                		Files.copy(file.toPath(), dest.toPath());
                	}
					mainWindow.getTrenutniKorisnik().setSlika("res/" + file.getName());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            //refresuj sliku
            
            changeProfileGui.changeImage(mainWindow.getTrenutniKorisnik());
			SwingUtilities.updateComponentTreeUI(changeProfileGui);
        }
	}
	
	//prozor za formiranje opste ture
	class CreateGeneralTourListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			generalTourWindow = new KreiranjeOpsteTureGui();
			generalTourWindow.addCreateButtonListener(new CreateGenTourBtnListener());
			generalTourWindow.addPictureButtonListener(new SetPictureBtnListener());
		}
	}
	
	//dugme za kreiranje opste ture
		class CreateGenTourBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO cuvanje nove opste ture
				if(generalTourWindow.checkEmptyFields()){
					generalTourWindow.displayFieldErrorMessage();
					return;
				}
				if(application.checkTourName(generalTourWindow.getNameField().getText())){
					generalTourWindow.displayNameErrorMessage();
					return;
				}
				Tura tura = new Tura(new ArrayList<Integer>(),
						generalTourWindow.getTextAreaDesc().getText(),
						generalTourWindow.getCityField().getText(),
						generalTourWindow.getNameField().getText(), generalTourWindow.getTura().getSlika(),
						new ArrayList<String>(), new ArrayList<KonkretnaTura>());
				generalTourWindow.setTura(tura);
				Vodic v  = (Vodic) mainWindow.getTrenutniKorisnik().getOsoba();
				v.addTour(tura);
				tura.setVodic(v);
				application.addTour(tura);
				mainWindow.getTuraPanel().addTura(tura);
				
				mainWindow.getMyToursPanel().addTura(tura);
				mainWindow.getMyToursPanel().addGuideButtons();
				mainWindow.getMyToursPanel().addGuideListeners(new ChangeTourListener(), new DeleteTourListener());
				
				
				//SwingUtilities.updateComponentTreeUI(mainWindow.getScrollPanel());
				
				generalTourWindow.setVisible(false);
				qw = new QuestionWindow();
				qw.addYesButtonListener(new CreateYesButtonListener());
				qw.addNoButtonListener(new CreateNoBtnListener());
				
			}
		}
		
		
	//prozor za formiranje konkretne ture
	class CreateSpecificTourListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			specificTourWindow = new KreiranjeKonkretneTureGui(application.getTure());
			specificTourWindow.addbtnCreateSpecTourListener(new CreateSpecTourBtnListener());
		}
	}
	
	class CreateSpecTourBtnListener implements ActionListener{

		private double price;
		private String remark;
		private Calendar startDate;
		private Calendar endDate;
		private String tura;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			price = Double.parseDouble(specificTourWindow.getPriceField().getText());
			remark = specificTourWindow.getRemarkTextArea().getText();
			startDate = specificTourWindow.getStartDateChooser().getSelectedDate();
			endDate = specificTourWindow.getEndDateChooser().getSelectedDate();
			tura = specificTourWindow.getGenTourComboBox().getSelectedItem().toString();
		   	
		    for (Tura t : application.getTure()) {
		    	if (t.getNaziv().equalsIgnoreCase(tura)) {
		    		t.addKonkretnaTura(new KonkretnaTura(t,price,startDate,endDate,remark));
		    	}
		    }
		    
			specificTourWindow.setVisible(false);
		}	
	}
	
	class CreateNoBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			qw.setVisible(false);
		}
		
	}
	class CreateYesButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			qw.setVisible(false);
			specificTourWindow = new KreiranjeKonkretneTureGui();
			specificTourWindow.addbtnCreateSpecTourListener(new CreateSpecTourBtnListener());

		}
		
	}
	class SetPictureBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fc = new JFileChooser();
			FileFilter imageFilter = new FileNameExtensionFilter(
				    "Image files", ImageIO.getReaderFileSuffixes());
			fc.setFileFilter(imageFilter);
			//fc.addChoosableFileFilter(new ImageFilter());
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                File dest = new File("res/" + file.getName());
                try {
                	if (!dest.exists()){
                		Files.copy(file.toPath(), dest.toPath());
                	}
					generalTourWindow.getTura().setSlika("res/" + file.getName());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            //refresuj sliku
            generalTourWindow.setPicture(generalTourWindow.getTura());
            //changeProfileGui.changeImage(mainWindow.getTrenutniKorisnik());
			//SwingUtilities.updateComponentTreeUI(changeProfileGui);
			
		}
		
	}
	
	
	class FilterSearchButton implements ActionListener {

		private String searchTextMesto = "";
		private String searchTextNaziv = "";
		ArrayList<Tura> searchResults;
		ListIterator<Tura> iter;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			searchResults = new ArrayList<Tura>();
			searchTextMesto = mainWindow.getFilterPanel().getMestoTxt().getText();
			searchTextMesto = searchTextMesto.replaceAll("\\n", "");
			searchTextNaziv = mainWindow.getFilterPanel().getNazivTureTxt().getText();
			
			mainWindow.getFilterPanel().getMestoTxt().setText("");
			mainWindow.getFilterPanel().getNazivTureTxt().setText("");
			if (application.getTure().isEmpty() == true){
				System.out.println("prazna lista");
			}
			for (Tura tura : application.getTure()) {
				searchResults.add(tura);
				
			}
			
			// remove from results if the city doesn't match
			
			//ako ne radi, vrati ovde
			//ListIterator<Tura> iter;
			
			if(!searchTextMesto.isEmpty()) {
				
				for (iter = searchResults.listIterator(); iter.hasNext(); )
				{
					if (!searchTextMesto.equalsIgnoreCase(iter.next().getGrad())) {
						iter.remove();
					}
				}
			}
			
			// remove from results if tour name doesn't match
			if (!searchTextNaziv.isEmpty()) {
				for (iter = searchResults.listIterator(); iter.hasNext(); )
				{
					if (!searchTextNaziv.equalsIgnoreCase(iter.next().getNaziv())) {
						iter.remove();
					}
				}
			}
			
			mainWindow.setTuraPanel(searchResults);
			SwingUtilities.updateComponentTreeUI(mainWindow);
			
		}
		
		
	}
	public void loadGuideTours(){
		TuraPanel turaPanel = new TuraPanel(((Vodic)mainWindow.getTrenutniKorisnik().getOsoba()).getTure());
		JScrollPane scrollPane = new JScrollPane(turaPanel);
		mainWindow.setMyToursPanel(turaPanel);
		mainWindow.getMyToursPanel().addGuideButtons();
		mainWindow.getMyToursPanel().addGuideListeners(new ChangeTourListener(), new DeleteTourListener());
		mainWindow.getTabbedPane().add("MyTours", scrollPane);
	}
	
	//otvaranje rezervacija prilikom logIna
	public void loadTouristReservations(){
		ArrayList<KonkretnaTura> konkretneTure = new ArrayList<KonkretnaTura>();
		Turista turista = ((Turista)mainWindow.getTrenutniKorisnik().getOsoba());
		
		for(Rezervacija rez : turista.getRezervacije()){
			konkretneTure.add(rez.getKonkretnaTura());
		}
		
		KonkretneTurePanel turaPanel = new KonkretneTurePanel(konkretneTure);
		JScrollPane scrollPane = new JScrollPane(turaPanel);
		mainWindow.setMyReservationsPanel(turaPanel);
		mainWindow.getTabbedPane().add("MyReservations", scrollPane);
	}
	
	public class DeleteTourListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			for (Component tura: mainWindow.getMyToursPanel().getComponents()){
				if (tura instanceof TuraGui){
					if (((TuraGui) tura).getDelete() == (JButton)actionEvent.getSource()){
						
						application.removeTour(((TuraGui) tura).getTura());
						((Vodic)mainWindow.getTrenutniKorisnik().getOsoba()).removeTour(((TuraGui) tura).getTura());
						mainWindow.setTuraPanel(application.getTure());
						mainWindow.getTabbedPane().removeAll();
						mainWindow.getTabbedPane().add("All Tours", new JScrollPane(mainWindow.getTuraPanel()));
						loadGuideTours();
						mainWindow.getTabbedPane().setSelectedIndex(1);
						//mainWindow.remove(mainWindow.getTuraPanel());
						//mainWindow.addTuraPanel(application.getTure());
						
						
						
						
						System.out.println("aa");
					}
				}
			}
			SwingUtilities.updateComponentTreeUI(mainWindow.getMyToursPanel());
			SwingUtilities.updateComponentTreeUI(mainWindow.getTuraPanel());
			SwingUtilities.updateComponentTreeUI(mainWindow.getScrollPanel());
		}
		
		
	}
	public class ChangeTourListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
}
