package model;
import view.MainWindow;
public class main {

	public static void main(String[] args) {

		Application app = new Application();
		MainWindow mainW = new MainWindow(app.getTure());
		
	}

}
