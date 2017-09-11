package model;
import contoller.Controller;
import view.MainWindow;
public class main {

	public static void main(String[] args) {

		Application app = new Application();
		
		Korisnik k = new Korisnik("p" , "k" , "email", "a", new Vodic("Petar", "Petrovic"));
		app.addKorisnik(k);
		MainWindow mainW = new MainWindow(app.getTure());
		Controller controller = new Controller(mainW, app);
		//TuraWindowGui tGui = new TuraWindowGui(null);
	}

}
