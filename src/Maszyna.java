import java.util.LinkedList;
import java.util.List;

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
		rozszerzKoniecTasmy(tasma); //inicujemy taœmê 32 pustymi znakami
	}
	
}

