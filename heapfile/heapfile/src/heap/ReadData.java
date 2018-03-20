package heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadData {

/*	public File getFilePath() {
		
		URL url = getClass().getResource("/temp1.txt");
		System.out.println(url.getPath());
		File file = new File(url.getPath());
		
		return file;
	}
*/
	
	public String[] readFile() throws IOException {
		
		String[] tokens = null;
		
		//File file = getFilePath();
		
		File file = new File (dbload.path);
		String line;
		
		try {
			BufferedReader br = new BufferedReader (new FileReader(file));
			
			br.readLine();
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				tokens = line.split("	", 9);
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
		
		
		MyFile myfile = new MyFile(dbload.pagesize);

		ByteArrayOutputStream record = new ByteArrayOutputStream();
		
		for (String token: tokens) {
			//convert record string to a byte then add to ByteArrayOutputStream
			record.write(token.getBytes());
		}
		
		myfile.createPage(record);
		
		
		bos.w
		FileOutputStream fos = new FileOutputStream("output.dat");
		DataOutputStream os = new DataOutputStream(fos);

		

		byte[] stream = new byte[9];
		
		//Need to parse integer
		for (int i=0; i<9; i++) {
			bos.write(cols[i].getBytes());
		}
		
		
		
		Integer test = 5;		
				
		byte[] reg_name = cols[0].getBytes();
		byte[] bus_name = cols[1].
		String reg_status = cols[2];
		String reg_date = cols[3];
		String can_date = cols[4];
		String ren_date = cols[5];
		String cur_state = cols[6];
		String reg_state = cols[7];
		long abn = Long.parseLong(cols[8]);
		

		
		try {
			DataOutputStream os = new DataOutputStream(new FileOutputStream("output.dat"));
			for (int i=0; i<9; i++) {
				os.writeBytes(cols[i]);
			}
			
			os.writeBytes(reg_name);
			
			
			myfile.createPage(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
