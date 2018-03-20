package heap;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {

MyFile myfile; 
	
	public String[] readFile() throws IOException {
		
		myfile = new MyFile(dbload.pagesize);
		String[] tokens = null;
		//File file = getFilePath();
		File file = new File (dbload.path);
		String line;
		
		try {
			BufferedReader br = new BufferedReader (new FileReader(file));
			
			br.readLine();
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				tokens = line.split("\\r?\\n");
				writeFile(tokens);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return tokens;	
	}
	
	
	public void writeFile(String[] tokens) {
		
		ByteArrayOutputStream record = new ByteArrayOutputStream();
		
		for (String token: tokens) {
			//convert tokens to bytes then add to ByteArrayOutputStream
			try {
				record.write(token.getBytes());
				myfile.createPage(record);
			} catch (IOException e) {
				System.out.println("Can't write tokens");
				e.printStackTrace();
			}
		}

		
		
	}
	
/*	public void writeFile(String string) throws IOException {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("output.txt", true);
			bw = new BufferedWriter(fw);
			bw.write(string);
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}*/
	
}
