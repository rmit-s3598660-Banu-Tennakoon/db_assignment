package heap;

import java.io.ByteArrayOutputStream;


public class MyFile {

//public List<Page> pages = new LinkedList<>();
public int pagesize;
Page lastpage;
//ListIterator<Page> it;

	public MyFile(int pagesize) {
		this.pagesize = pagesize;
		lastpage = new Page(pagesize);
	}
	
	public void createPage(ByteArrayOutputStream record) {
		
		//The below if statement will return true if the last page is full. In that case we
		//create a new page.
		if(lastpage.addRecord(record)) {

		} else {
			lastpage = new Page(pagesize);
			lastpage.addRecord(record);
		}
		
		//Need to implement what happens to the final page in the db when the data stream stops.

	}

	

	
	
	
}
