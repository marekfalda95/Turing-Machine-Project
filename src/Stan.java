import java.io.BufferedWriter;
import java.io.IOException;
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
	
	public void wypiszDoWr(BufferedWriter bw) throws IOException {
		bw.write("Relacje przejscia");
		bw.newLine();
		relacjePrzejscia.forEach(relacja -> {
			try {
				relacja.wypisz(bw);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		bw.write("Akceptujacy: " + akceptujacy);
		bw.newLine();
	}
}


