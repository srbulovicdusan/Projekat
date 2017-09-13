package contoller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import model.Application;
import model.Korisnik;
import model.Turista;
import model.Vodic;
import view.ChangeProfileGui;
import view.LogIn;
import view.MainWindow;
import view.ProfilPanel;
import view.SignUp;
public class Controller {
	private MainWindow mainWindow; //viewer
	private LogIn logIn;
	private SignUp signUp;
	private ChangeProfileGui changeProfileGui;
	private Application application; //model
	
	public Controller(MainWindow mainWindow, Application application){
		this.mainWindow = mainWindow;
		this.application = application;
		mainWindow.addLoginListener(new LoginListener());
		mainWindow.addSignListener(new SignUpListener());

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
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println(file.toPath());
                File dest = new File("res/" + file.getName());
                
                System.out.println(dest.toPath());
                try {
					Files.copy(file.toPath(),
					        dest.toPath());
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
}
