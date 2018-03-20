package heap;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Page {
DataOutputStream os;

int pagesize;
int currentsize;
//int record_count;
byte[] page;

	public Page (int pagesize) {
		
		this.page = new byte[pagesize];
		this.pagesize = pagesize;
		this.currentsize = 0;
		
	}

	public boolean addRecord(ByteArrayOutputStream record) {
		
		boolean addnewpage = true;
		
		if (record.size() + currentsize > pagesize){
			writePage();
			return addnewpage;
		} else {
			//Copy new record on to the existing page
			//System.out.println(record.toString());
			byte[] temp = new byte[page.length + record.toByteArray().length];
			System.arraycopy(page,0,temp,0,page.length);
			System.arraycopy(record.toByteArray(),0,temp,page.length,record.toByteArray().length);
			//System.out.println(temp.length);
			//System.out.println(temp.toString());			
			for (int i=0; i<temp.length; i++) System.out.println(temp[i]);
			//update current size of file
			currentsize = currentsize + record.size();
			addnewpage = false;
			return addnewpage;
		}	
	}
	
	public boolean writePage() {
		//If page is full, write everything to output file
		try {
			os = new DataOutputStream(new FileOutputStream("output.dat"));
			os.write(page);
			return true;
		} catch (IOException e) {
			System.out.println("Error creating DataOutputStream and FileOutputStream and/or writing to page");
			e.printStackTrace();
			return false;
		}
	}

	
	public void deleteRecord() {
		
	}


}
