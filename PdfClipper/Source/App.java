import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
public class App {
	private File file;
	private int pages;
	private File[] files;
	private String path;
	
	public App(File file, File[] files,int pages,String path) {
		
		this.file=file;
		this.files=files;
		this.pages=pages;
		this.path=path;
	    }
	
	public void execute() {
		try { //File file = new File("C:\\Users\\Sourjya\\Desktop\\Graph Theory.pdf"); 
			for(File file:files)
			{PDDocument document = PDDocument.load(file);
			Splitter splitter1 = new Splitter();
			splitter1.setEndPage(pages);
			List<PDDocument> Pages1 = splitter1.split(document);
			Iterator<PDDocument> iterator1 = Pages1.listIterator();
			Splitter splitter2 = new Splitter();
			splitter2.setStartPage(pages+1);
			splitter2.setSplitAtPage(document.getNumberOfPages()-pages);
			List<PDDocument> Pages2 = splitter2.split(document);
			Iterator<PDDocument> iterator2 = Pages2.listIterator();
			
			int i=0;
			while(iterator1.hasNext())
			{
			  iterator1.next().save(path+"\\"+ (++i)+"_"+file.getName()+".pdf");
			 
			}
			
			while(iterator2.hasNext())
			{
			  iterator2.next().save(path+"\\"+ (++i)+"_"+file.getName()+".pdf");
			 
			}	
	    
			}
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
    
}