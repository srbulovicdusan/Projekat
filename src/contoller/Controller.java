package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Application;
import model.Korisnik;
import model.Turista;
import view.LogIn;
import view.MainWindow;
import view.SignUp;
public class Controller {
	private MainWindow mainWindow; //viewer
	private LogIn logIn;
	private SignUp signUp;
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
						//k.load profile
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
			}
			if (application.checkIfKorisnikExists(signUp.getUserNameField().getText())){
				signUp.displayUserErrorMessage();
			}
			Korisnik korisnik = new Korisnik(signUp.getUserNameField().getText(), 
					signUp.getPasswordField().getText(),
					signUp.getEmailField().getText(), "asd", 
					new Turista(signUp.getNameField().getText(), 
							signUp.getLastNameField().getText()));
			application.addKorisnik(korisnik);
			signUp.setVisible(false);
		}
		
	}
}
