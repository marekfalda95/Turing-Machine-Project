import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class Maszyna {
	private static final int dlugoscTasmy = 32;
	LinkedList<Character> tasma;
	
	
	void rozszerzKoniecTasmy(LinkedList<Character> tasma) {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addLast('#');
		}
	}
	void rozszerzPoczatekTasmy(LinkedList<Character> tasma) {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.addFirst('#');
		}
	}
	
	public Maszyna() {
		tasma = new LinkedList<Character>();
		Map stany = new HashMap<Character, ArrayList<RelacjaPrzejscia>>();
		rozszerzKoniecTasmy(tasma); //inicujemy taœmê 32 pustymi znakami
	}
	
}

