
public class RelacjaPrzejscia {
	public char znakPobierany;
	public char znakZapisywany;
	public char nastepnyStan;
	public char kierunekPrzejcia;
	
	public RelacjaPrzejscia() {
		znakPobierany = '-';
		znakZapisywany = '-';
		nastepnyStan = '-';
		kierunekPrzejcia = '-';
	}
	
	public RelacjaPrzejscia(RelacjaPrzejscia r) {
		znakPobierany = r.znakPobierany;
		znakZapisywany = r.znakZapisywany;
		nastepnyStan = r.nastepnyStan;
		kierunekPrzejcia = r.kierunekPrzejcia;
	}
	
	public void wypisz() {
		System.out.println("[" + znakPobierany + ", " + nastepnyStan + ", " + znakZapisywany + ", " +
				kierunekPrzejcia + "]");
	}
}
