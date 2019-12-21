
public class RelacjaPrzejscia {
	public char znakPobierany;
	public char znakZapisywany;
	public char nastepnyStan;
	public char kierunekPrzejcia;
	
	public void wypisz() {
		System.out.println("[" + znakPobierany + ", " + nastepnyStan + ", " + znakZapisywany + ", " +
				kierunekPrzejcia + "]");
	}
}
