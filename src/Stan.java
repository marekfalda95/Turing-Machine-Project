import java.util.ArrayList;

public class Stan {
	public ArrayList<RelacjaPrzejscia> relacjePrzejscia;
	public boolean akceptujacy;
	
	public Stan(){
		relacjePrzejscia = new ArrayList<RelacjaPrzejscia>();
		akceptujacy = false;
	}
	
	public Stan(Stan s){
		relacjePrzejscia = new ArrayList<RelacjaPrzejscia>(s.relacjePrzejscia);
		akceptujacy = s.akceptujacy;
	}
	
	public Stan(Stan s, boolean b){
		relacjePrzejscia = new ArrayList<RelacjaPrzejscia>(s.relacjePrzejscia);
		akceptujacy = b;
	}
	
	public void wypisz() {
		System.out.println("Relacje przejscia");
		relacjePrzejscia.forEach(relacja -> relacja.wypisz());
		System.out.println("Akceptujacy: " + akceptujacy);
	}
}


