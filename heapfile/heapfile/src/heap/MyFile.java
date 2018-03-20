package heap;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyFile {

public List<Page> pages = new LinkedList<>();
public int pagesize;
ListIterator<Page> it;

	public MyFile(int pagesize) {
		this.pagesize = pagesize;
		pages.add(new Page(pagesize));
	}
	
	public void createPage(ByteArrayOutputStream record) {
		
		it = pages.listIterator();
		//The below if statement will return true if the last page is full. In that case we
		//create a new page.
		if(it.next().addRecord(record)) {
			Page pg = new Page(pagesize);
			pg.addRecord(record);
			it.add(pg);
		} else {
			System.out.println("Error creating page");
		}
		

	}
	
	public void deletePage() {
		
	}
	
	public void insertRecord() {
		
	}
	
	public void deleteRecord() {
		
	}
	
	
	
}
