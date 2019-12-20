import java.util.LinkedList;
import java.util.List;

public class Maszyna {
	private static final int dlugoscTasmy = 32;
	List<Character> tasma;
	
	void rozszerzTasme(LinkedList<Character> tasma) {
		for(int i = 0; i < dlugoscTasmy; ++i) {
			tasma.add('#');
		}
	}
	
	public Maszyna() {
		tasma = new LinkedList<Character>();
	}
	
}

