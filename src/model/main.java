package model;
import view.MainWindow;
import view.TuraWindowGui;
public class main {

	public static void main(String[] args) {

		Application app = new Application();
		MainWindow mainW = new MainWindow(app.getTure());
		//TuraWindowGui tGui = new TuraWindowGui(null);
	}

}
