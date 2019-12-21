import java.util.LinkedList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Maszyna {
	
	private static final int dlugoscTasmy = 32;
	LinkedList<Character> tasma;
	private plikReader plik;
	int indeksGlowicy;
	String alfabet_wejsciowy;
	String alfabet_tasmowy;
	String stany;
	char stan_poczatkowy;
	Map nazwyStanow_stany;
	
	void rozszerzKoniecTasmy(LinkedList<Character> tasma) {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addLast('#');
		}
	}
	void rozszerzPoczatekTasmy(LinkedList<Character> tasma) {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addFirst('#');
		}
		indeksGlowicy += dlugoscTasmy;
	}
	
	void wypiszMape(String nazwy, HashMap<Character, Stan> map) {
		System.out.println("obecny stan mapy");
		for (int i = 0; i < stany.length(); ++i)  {
            System.out.println("Nazwa stanu: " + stany.charAt(i));
            map.get(stany.charAt(i)).wypisz();
		}
	}
	
	public Maszyna() throws FileNotFoundException {
		indeksGlowicy = 0;
		stany = "";
		tasma = new LinkedList<Character>();
		HashMap<Character, Stan> nazwyStanow_stany = new HashMap<Character, Stan>(); //Mapa nazwa stanu -> Stan
		rozszerzKoniecTasmy(tasma); //inicujemy ta�m� 32 pustymi znakami
		
		String testFile=System.getProperty("user.dir")+"\\test.txt";
		plik = new plikReader(new BufferedReader(new FileReader(testFile)));
		System.out.println
		(
				"Alfabet ta�mowy: \n" +
				plik.alfabetTasmowy + "\n" +
				"Alfabet wej�ciowy: \n" + 
				plik.alfabetWejsciowy + "\n" +
				"S�owo wejsciowe: \n" +
				plik.slowoWejsciowe + "\n" +
				"Stany: \n" +
				plik.stany + "\n" +
				"Stan pocz�tkowy: \n" +
				plik.stanPoczatkowy + "\n" +
				"Stany akceptuj�ce: \n" +
				plik.stanyAkceptujace + "\n" +
				"Relacja przejscia: \n" +
				plik.relacjaPrzejscia
		);
		alfabet_tasmowy = plik.alfabetTasmowy;
		alfabet_wejsciowy = plik.alfabetWejsciowy;
		stan_poczatkowy = plik.stanPoczatkowy.charAt(0);
		
		
		
		//Wczytaj relacje i przejscia
		for (int i = 0; i < plik.stany.length(); ++i) { //Wczytujemy nazwy stan�w i na razie przypisujemy im defalutowy obiekt Stan.
			char c = plik.stany.charAt(i);
			if(c != ' ') { //W tym forze pomijamy spacje
				stany += c;
				nazwyStanow_stany.put(c, new Stan());
			}
		}
		
		
		//System.out.println(nazwyStanow_stany);
		
		wypiszMape(stany, nazwyStanow_stany);
		
		
		for (int i = 0; i < plik.stanyAkceptujace.length(); ++i) { //Iterujemy po stanach akceptuj�cych i dodajemy stanowi true, je�eli jest ackpetuj�cy.
			char c = plik.stanyAkceptujace.charAt(i);
			if(c != ' ') { //W tym forze pomijamy spacje
				Stan new_stan = new Stan((Stan) nazwyStanow_stany.get(c), true);
				System.out.println("Nowy stan, kt�ry jest akceptujacy");
				System.out.println("Nazwa: " + c);
				new_stan.wypisz();
				//nazwyStanow_stany.replace(c, new Stan(nazwyStanow_stany.get(c), true));
				nazwyStanow_stany.replace(c, new_stan);
			}
		}
		
		System.out.println("\n Stan mapy po dodaniu stan�w akceptuj�cych");
		
		wypiszMape(stany, nazwyStanow_stany);
		
		
		
		
	}
	
}

