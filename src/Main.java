import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
	    
		String outputFileName= "result.txt";
		
	    
	    
	    System.out.println("\n \n \n \n POCZ¥TEK OBLICZENIA \n");
	    try(PrintWriter plikOut=new PrintWriter(outputFileName))
	    {
	    	Maszyna maszyna = new Maszyna(plikOut);
	    	plikOut.println("hoho");
	    maszyna.wypiszMape(plikOut);
	    maszyna.obliczSlowo(plikOut);
	    }catch (FileNotFoundException e)
		{
		System.out.println("Error");
		}
	  }
}
