package heap;

import java.io.ByteArrayOutputStream;


public class MyFile {

//public List<Page> pages = new LinkedList<>();
public int pagesize;
public Page currentpage;
public Page lastpage;
//ListIterator<Page> it;

	public MyFile(int pagesize) {
		this.pagesize = pagesize;
		currentpage = new Page(pagesize);
	}
	
	public void createPage(ByteArrayOutputStream record) {
		
		//The below if statement will return true if the last page is full. In that case we
		//create a new page.
		if(currentpage.addRecord(record)) {
			lastpage = currentpage;
			currentpage = new Page(pagesize);
			currentpage.addRecord(record);
		} else {
			return;
		}
		
		//Need to implement what happens to the final page in the db when the data stream stops.

	}

	

	
	
	
}
