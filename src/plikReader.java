import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class plikReader {

	public String alfabetTasmowy;
	public String alfabetWejsciowy;
	public String slowoWejsciowe;
	public String stany;
	public String stanPoczatkowy;
	public String stanyAkceptujace;
	public List<String> relacjaPrzejscia = new ArrayList<String>();
	
	plikReader (BufferedReader bufferedReader)
	{
		System.out.println("wchodzi tu?");
		
		//=="alfabet: tasmowy:")
		getLine(bufferedReader);
			alfabetTasmowy=getLine(bufferedReader);
		//=="alfabet: wejsciowy:")
		getLine(bufferedReader);
			alfabetWejsciowy=getLine(bufferedReader);
		//=="slowo wejsciowe:")
		getLine(bufferedReader);
			slowoWejsciowe=getLine(bufferedReader);
		//=="stany:")
		getLine(bufferedReader);
			stany=getLine(bufferedReader);
		//=="stan poczatkowy:")
		getLine(bufferedReader);
			stanPoczatkowy=getLine(bufferedReader);
		//=="stany akceptujace:")
		getLine(bufferedReader);
			stanyAkceptujace=getLine(bufferedReader);
		//=="relacja przejscia:")
		getLine(bufferedReader);
		
			relacjaPrzejscia.add(getLine(bufferedReader));
			while(relacjaPrzejscia.get(relacjaPrzejscia.size()-1)!=null)
			{
				relacjaPrzejscia.add(getLine(bufferedReader));
			}
		//usuniêcie ostatniego nulla	
		relacjaPrzejscia.remove(relacjaPrzejscia.size()-1);
	}
	public String getLine(BufferedReader bufferedReader)
	{
		String line = null;
		try 
		{
			line =bufferedReader.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return line;
	}
}
