package heap;

import java.io.IOException;

public class dbload {

public static String path;
public static int pagesize;
	
	public static void main (String[] args) {
		
		path = args[2];
		pagesize = Integer.parseInt(args[1]);
		
		ReadData readdata = new ReadData();
		
		try {
			readdata.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
