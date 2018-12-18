import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ClassPathResource;

public class WordFileDealThread implements Runnable {

	private String txtFilePath = "C:\\Users\\qinmp\\Desktop\\pdffile2\\txt\\";
	
	private File dealFile = null;
	
	public WordFileDealThread(File file, String txtPath){
		dealFile = file;
		txtFilePath = txtPath;
	}
	
	public void run() {
		System.out.println("current thread is: " + Thread.currentThread().getId() + "=====current filter txt file is " + dealFile.getName());
		dealEachFile(txtFilePath, "utf-8", this.dealFile);

	}
	private void dealEachFile(String txtFilePath, String encoding, File tempFile) {
		Writer output = null;
		FileInputStream is = null;
		try {
			String fileName = tempFile.getName().substring(0, tempFile.getName().indexOf("."));
			String txtFileName = txtFilePath + fileName + ".txt";
			System.out.println(txtFileName);
			File tempTxtFile = new File(txtFileName);
			if (!tempTxtFile.exists()) {
				tempTxtFile.createNewFile();
			}
			output = new OutputStreamWriter(new FileOutputStream(tempTxtFile), encoding);
            XWPFDocument xdoc = new XWPFDocument(new FileInputStream(tempFile));
            POIXMLTextExtractor extractor = new XWPFWordExtractor(xdoc);
            String buffer = extractor.getText();
            System.out.println(buffer);
            output.write(buffer);
            output.flush();
            output.close();
            
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
