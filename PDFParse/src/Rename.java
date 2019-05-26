import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

import org.apache.commons.lang.StringUtils;

public class Rename {
    public void reName(File dealFile, String destPath){
    	try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dealFile)));
			String lineTxt = null;
			String num = null;
			try {
				while((lineTxt=reader.readLine()) != null){
					if(lineTxt.contains("编号")){
						String[] keyValue = lineTxt.split("：");
						if(keyValue.length == 2){
							num = keyValue[1].trim();
						}
						break;
					}
				}
				reader.close();
				if(StringUtils.isNotBlank(num)){
					File tempFile = new File(destPath + num + ".txt");
					if(!tempFile.exists()){
						tempFile.createNewFile();
					}
					copyFileUsingFileChannels(dealFile, tempFile);
				}else{
					System.out.println("not rename file is :" + dealFile.getName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    @SuppressWarnings("resource")
	private void copyFileUsingFileChannels(File source, File dest)
			throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
    }
    
    public static void main(String[] args){
    	Rename rename = new Rename();
		File txtFileDirector = new File("C:\\Users\\qinmp\\Desktop\\pdffile3\\txt2\\");
		if(txtFileDirector.exists()){
			if(txtFileDirector.isDirectory()){
				File[] files = txtFileDirector.listFiles();
				for(int i=0; i < files.length; i++){
					File file = files[i];
					System.out.println("current rename file is: " + file.getName());
					rename.reName(file, "C:\\Users\\qinmp\\Desktop\\pdffile3\\txt3\\");
				}
			}
		}
    }
    
}
