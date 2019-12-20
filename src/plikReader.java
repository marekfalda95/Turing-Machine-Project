import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class plikReader {

	public BufferedReader bufferedReader;
	
	plikReader (BufferedReader bufferedReader)
	{
		this.bufferedReader=bufferedReader;
	}
	public String getLine()
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
