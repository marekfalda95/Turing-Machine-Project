import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class Maszyna {
	
	private static final int dlugoscTasmy = 32;
	public LinkedList<Character> tasma;
	private plikReader plik;
	int indeksGlowicy;
	String alfabet_wejsciowy;
	String alfabet_tasmowy;
	String stany;
	public char stan_poczatkowy;
	HashMap<Character, Stan> nazwyStanow_stany;
	//private String outputFileName= "result.txt";
	//private PrintWriter plikOut;
	
	void rozszerzKoniecTasmy() {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addLast('#');
		}
	}
	void rozszerzPoczatekTasmy() {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addFirst('#');
		}
		indeksGlowicy += dlugoscTasmy;
	}
	
	public void wypiszMape(PrintWriter plikOut) {
		
		System.out.println("obecny stan mapy");
		for (int i = 0; i < stany.length(); ++i)  {
            System.out.println("Nazwa stanu: " + stany.charAt(i));
            nazwyStanow_stany.get(stany.charAt(i)).wypisz();
		}
	}
	public void wypiszTasmeZindeksemGlowicy() {
		System.out.print('[');
		for(int i = 0; i < tasma.size(); ++i) {
			if(i != 0) {
				System.out.print(", ");
			}
			if(i == indeksGlowicy) {
				System.out.print("(");
			}
			System.out.print(tasma.get(i));
			if(i == indeksGlowicy) {
				System.out.print(")");
			}
		}
		System.out.println(']');
	}
	
	void wczytajRelacjePrzejscia(List<String> relacjaPrzejscia) {
		relacjaPrzejscia.forEach(i -> {
				char nazwaStanu = i.charAt(0);
				Stan stan = new Stan(nazwyStanow_stany.get(nazwaStanu));
				RelacjaPrzejscia relacja = new RelacjaPrzejscia();
				relacja.znakPobierany = i.charAt(2);
				relacja.nastepnyStan = i.charAt(4);
				relacja.znakZapisywany = i.charAt(6);
				relacja.kierunekPrzejcia = i.charAt(8);
				
				stan.relacjePrzejscia.add(relacja);
				
				nazwyStanow_stany.replace(nazwaStanu, stan);
			}
	    );
	}
	
	void wczytajSlowoNaTasme(String slowo) {
		for (int i = 0; i < slowo.length(); ++i) {
			if(i == tasma.size()) {
				rozszerzKoniecTasmy();
			}
			tasma.set(i, slowo.charAt(i));
		}
	}
	
	
	
	public Maszyna(PrintWriter plikOut) throws FileNotFoundException {
		indeksGlowicy = 0;
		stany = "";
		tasma = new LinkedList<Character>();
		nazwyStanow_stany = new HashMap<Character, Stan>(); //Mapa nazwa stanu -> Stan
		rozszerzKoniecTasmy(); //inicujemy taœmê 32 pustymi znakami
		
		//plikOut= new PrintWriter(outputFileName);
		String testFile=System.getProperty("user.dir")+"\\test.txt";
		plik = new plikReader(new BufferedReader(new FileReader(testFile)));
		System.out.println
		(
				"Alfabet taœmowy: \n" +
				plik.alfabetTasmowy + "\n" +
				"Alfabet wejœciowy: \n" + 
				plik.alfabetWejsciowy + "\n" +
				"S³owo wejsciowe: \n" +
				plik.slowoWejsciowe + "\n" +
				"Stany: \n" +
				plik.stany + "\n" +
				"Stan pocz¹tkowy: \n" +
				plik.stanPoczatkowy + "\n" +
				"Stany akceptuj¹ce: \n" +
				plik.stanyAkceptujace + "\n" +
				"Relacja przejscia: \n" +
				plik.relacjaPrzejscia
		);
		alfabet_tasmowy = plik.alfabetTasmowy;
		alfabet_wejsciowy = plik.alfabetWejsciowy;
		stan_poczatkowy = plik.stanPoczatkowy.charAt(0);
		
		
		
		//Wczytaj relacje i przejscia
		for (int i = 0; i < plik.stany.length(); ++i) { //Wczytujemy nazwy stanów i na razie przypisujemy im defalutowy obiekt Stan.
			char c = plik.stany.charAt(i);
			if(c != ' ') { //W tym forze pomijamy spacje
				stany += c;
				nazwyStanow_stany.put(c, new Stan());
			}
		}
		
		
		//System.out.println(nazwyStanow_stany);
		
		wypiszMape(plikOut);
		
		
		for (int i = 0; i < plik.stanyAkceptujace.length(); ++i) { //Iterujemy po stanach akceptuj¹cych i dodajemy stanowi true, je¿eli jest ackpetuj¹cy.
			char c = plik.stanyAkceptujace.charAt(i);
			if(c != ' ') { //W tym forze pomijamy spacje
				Stan new_stan = new Stan((Stan) nazwyStanow_stany.get(c), true);
				System.out.println("Nowy stan, który jest akceptujacy");
				System.out.println("Nazwa: " + c);
				new_stan.wypisz();
				//nazwyStanow_stany.replace(c, new Stan(nazwyStanow_stany.get(c), true));
				nazwyStanow_stany.replace(c, new_stan);
			}
		}
		
		System.out.println("\n Stan mapy po dodaniu stanów akceptuj¹cych");
		
		wypiszMape(plikOut);
		
		wczytajRelacjePrzejscia(plik.relacjaPrzejscia);
		
		wypiszMape(plikOut);
		
		wczytajSlowoNaTasme(plik.slowoWejsciowe);
		
		System.out.println("Wczytana tasma");
		System.out.println(tasma);
		System.out.println("Dlugosc tasmy: " + tasma.size());
		
	}
	

	char wykonajObliczenie(Stan obecnyStan, RelacjaPrzejscia r) {
		tasma.set(indeksGlowicy, r.znakZapisywany);
		if(r.kierunekPrzejcia == 'P') {
			indeksGlowicy++;
			if(indeksGlowicy == tasma.size()) {
				rozszerzPoczatekTasmy();
			}
		}
		if(r.kierunekPrzejcia == 'L') {
			indeksGlowicy--;
			if(indeksGlowicy == -1) {
				rozszerzKoniecTasmy();
			}
		}
		return r.nastepnyStan;
	}
	
	
	void rekurencyjnieWykonujObliczenia(char s, PrintWriter plikOut) {
		
			RelacjaPrzejscia r = new RelacjaPrzejscia();
			
			
			plikOut.println("\n Stan poczatkowy: " + this.stan_poczatkowy);
			plikOut.println("\n Tasma:");
			plikOut.println(this.tasma);
			plikOut.println("Dlugosc tasmy: " + this.tasma.size());
			
			Stan obecnyStan = new Stan(nazwyStanow_stany.get(s));
			while(true) {
				if(obecnyStan.akceptujacy) {
					System.out.println("Osi¹gniêto stan akceptuj¹cy " + s);
					System.out.println("Wynik obliczenia:");
					wypiszTasmeZindeksemGlowicy();
					System.exit(0);
				}else {
					ArrayList<RelacjaPrzejscia> mozliweRelacje = new ArrayList<RelacjaPrzejscia>(obecnyStan.relacjePrzejscia);
					//Znajdz relacjê tak¹, ¿e znak pobierany = obecny znak pod glowica.
					char znakPodGlowica = tasma.get(indeksGlowicy);
					boolean znalezionoPasujacaRelacje = false;
					/*
					mozliweRelacje.forEach(relacja ->{
						if(relacja.znakPobierany == znakPodGlowica) {
							wykonajObliczenie();
							znalezionoPasujacaRelacje = true;
						}
					});
					*/
					for(int i = 0; i < mozliweRelacje.size(); ++i) {
						if(mozliweRelacje.get(i).znakPobierany == znakPodGlowica) {
							char nastepnyStanNazwa = wykonajObliczenie(obecnyStan, mozliweRelacje.get(i));
							obecnyStan = nazwyStanow_stany.get(nastepnyStanNazwa);
							System.out.println("Tasma i stan po wykonaniu obliczenia:");
							wypiszTasmeZindeksemGlowicy();
							System.out.println(nastepnyStanNazwa);
							s = nastepnyStanNazwa;
							znalezionoPasujacaRelacje = true;
							break;
						}
					}
					if(!znalezionoPasujacaRelacje) {
						System.out.println("Obliczenie zakonczono bledem");
						System.exit(0);
					}
					
				}
			}
	}
	
	void obliczSlowo(PrintWriter plikOut) {
		char obecnyStanNazwa = stan_poczatkowy;
		rekurencyjnieWykonujObliczenia(obecnyStanNazwa, plikOut);
	}
	
}

