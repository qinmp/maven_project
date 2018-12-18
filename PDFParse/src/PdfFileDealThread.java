import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfFileDealThread implements Runnable {

	private String txtFilePath = "";
	
	private File dealFile = null;
	
	public PdfFileDealThread(File file, String txtPath){
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
		PDDocument document = null;
		try {
			String fileName = tempFile.getName().substring(0, tempFile.getName().indexOf("."));
			String txtFileName = txtFilePath + fileName + ".txt";
			System.out.println(txtFileName);
			File tempTxtFile = new File(txtFileName);
			if (!tempTxtFile.exists()) {
				tempTxtFile.createNewFile();
			}
			output = new OutputStreamWriter(new FileOutputStream(tempTxtFile), encoding);
			is = new FileInputStream(tempFile);
			PDFParser parser = new PDFParser(is);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			// 设置是否排序
			stripper.setSortByPosition(false);
			// 设置起始页
			stripper.setStartPage(1);
			// 设置结束页
			stripper.setEndPage(1);
			stripper.writeText(document, output);
			output.flush();
			output.close();
			is.close();
			document.close();
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
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
