import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
	    System.out.print("Hello World");
	    // DASDASDA
	    Maszyna maszyna = new Maszyna();
	    
	    System.out.println("\n \n \n \n POCZ¥TEK OBLICZENIA \n");
	    maszyna.wypiszMape();
	    System.out.println("\n Stan poczatkowy: " + maszyna.stan_poczatkowy);
	    System.out.println("\n Tasma:");
	    System.out.println(maszyna.tasma);
	    System.out.println("Dlugosc tasmy: " + maszyna.tasma.size());
	    maszyna.obliczSlowo();
	  }
}
