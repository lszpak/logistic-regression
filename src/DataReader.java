import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataReader {
	public static List<Example> readCSV(String fileName) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			List<Example> data = new LinkedList<Example>();
		    String line = br.readLine();   
		    while (line != null) {
		    	data.add(parseCSVLine(line));
		    	line = br.readLine();  
		    }
		    return data;
		}
	}
	
	private static Example parseCSVLine(String line) {
		String[] tokens = line.split(",");
		float[] x = new float[tokens.length-1];
		int y, i;
		for (i = 0; i < tokens.length-1; ++i) {
			x[i] = Float.parseFloat(tokens[i]);
		}
		y = Integer.parseInt(tokens[i]);
		return new Example(x, y);
	}
}
