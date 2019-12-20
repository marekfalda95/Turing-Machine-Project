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
	public List<String> relacjaPrzejscia= new ArrayList<String>();
	
	plikReader (BufferedReader bufferedReader)
	{
		if (getLine(bufferedReader)=="alfabet: tasmowy:")
			alfabetTasmowy=getLine(bufferedReader);
		if (getLine(bufferedReader)=="alfabet: wejsciowy:")
			alfabetWejsciowy=getLine(bufferedReader);
		if (getLine(bufferedReader)=="slowo wejsciowe:")
			slowoWejsciowe=getLine(bufferedReader);
		if(getLine(bufferedReader)=="stany:")
			stany=getLine(bufferedReader);
		if(getLine(bufferedReader)=="stan poczatkowy:")
			stanPoczatkowy=getLine(bufferedReader);
		if(getLine(bufferedReader)=="stany akceptujace:")
			stanyAkceptujace=getLine(bufferedReader);
		
		if(getLine(bufferedReader)=="relacja przejscia:")
		{
			relacjaPrzejscia.add(getLine(bufferedReader));
			while(relacjaPrzejscia.get(relacjaPrzejscia.size())!=null)
			{
				relacjaPrzejscia.add(getLine(bufferedReader));
			}
		}
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
