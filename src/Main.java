
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		
		
		
		//FileChooser fileChooser = new FileChooser();
		//fileChooser.setTitle("Open Resource File");
		//fileChooser.showOpenDialog(jf);
		FileDialog dialog = new FileDialog((Frame)null, "Wybierz plik");
	    dialog.setMode(FileDialog.LOAD);
	    dialog.setVisible(true);
	    String file = dialog.getFile();
	    System.out.println(file + " chosen.");

		
		
		Window window = new Window(file);
		window.frame.setVisible(true);
	  }
}
