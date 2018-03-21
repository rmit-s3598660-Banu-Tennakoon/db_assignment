package heap;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class Page {
public DataOutputStream os;
public int pagesize;
public int currentsize;
public ByteArrayOutputStream baos;

	public Page (int pagesize) {
		
		this.baos = new ByteArrayOutputStream();
		this.pagesize = pagesize;
		
	}

	public boolean addRecord(ByteArrayOutputStream record) {
		
		boolean addnewpage = true;
				
		if (record.size() + baos.size() > pagesize){
			writePage();
			return addnewpage;
		} else {
			try {
				record.writeTo(baos);;
			} catch (IOException e) {
				e.printStackTrace();
			}


			//Copy new record on to the existing page
			//System.out.println(record.toString());
			//byte[] temp = new byte[page.length + record.toByteArray().length];
			//System.arraycopy(page,0,temp,0,page.length);
			//System.arraycopy(record.toByteArray(),0,temp,page.length,record.toByteArray().length);
			//System.out.println(temp.length);
			//System.out.println(temp.toString());			
			//for (int i=0; i<temp.length; i++) System.out.println(temp[i]);
			//update current size of file
			return !addnewpage;
		}	
	}
	
	public boolean writePage() {
		//If page is full, write everything to output file
		try {
			os = new DataOutputStream(new FileOutputStream("output.dat", true));
			baos.writeTo(os);
			System.out.println(baos.toString());
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
