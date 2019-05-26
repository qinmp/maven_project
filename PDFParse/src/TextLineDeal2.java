import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class TextLineDeal2 {
	
	static String personFilePath = "C:\\Users\\qinmp\\Desktop\\需求-整合201905\\txt\\name-txt\\";
	
	public static void main(String[] args) {
		File dealfolder = new File("C:\\Users\\qinmp\\Desktop\\需求-整合201905\\txt\\");
		File[] filelist = dealfolder.listFiles();
		try {
			for(File tempFile:filelist){
				if(tempFile.getName().contains("better")){
					String txtFolderName = tempFile.getName().substring(0, tempFile.getName().lastIndexOf("-"));
					File txtFolderFile = new File(personFilePath + txtFolderName.trim() + "\\");
					txtFolderFile.mkdirs();
					String tempFolderPath = txtFolderFile.getAbsolutePath() + "\\";
					
					BufferedReader reader;
					String lineTxt = null;
					List<Liner> liners;
					Map<String, String> countMap;
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile)));
					liners = new LinkedList<Liner>();
					countMap = new HashMap<String, String>();
					while((lineTxt=reader.readLine()) != null){
						if(StringUtils.isNotBlank(lineTxt.trim())){
							if("end".equals(lineTxt.trim())){
								if(!liners.isEmpty()){
									writeLinersToFile(liners, tempFolderPath);
								}
								break;
							}
							if(lineTxt.contains("姓名")){
								String name = getName(lineTxt);
								if(countMap.get(name) != null){
									Liner liner = new Liner();
									liner.setValue(lineTxt);
									liners.add(liner);
								}else{
									countMap.clear();
									countMap.put(name, name);
									if(!liners.isEmpty()){
										writeLinersToFile(liners, tempFolderPath);
									}
									liners.clear();
									Liner liner = new Liner();
									liner.setValue(lineTxt);
									liners.add(liner);
								}
							}else{
								Liner liner = new Liner();
								liner.setValue(lineTxt);
								liners.add(liner);
							}
							
						}
					}
					reader.close();
					System.out.println("==================finished==================");
				}
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeLinersToFile(List<Liner> liners, String tempFolderPath) {
		String fileName = "";
		for(Liner liner:liners){
			if(liner.getValue().contains("姓名")){
				fileName = getName(liner.getValue());
				break;
			}
		}
		File file = new File(tempFolderPath + fileName + ".txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter pwriter;
		try {
			pwriter = new PrintWriter(file);
			for (Liner liner:liners) {
				pwriter.println(liner.getValue());
			}
			pwriter.flush();
			pwriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String getName(String lineTxt){
		String name = "";
		if(lineTxt.contains("姓名")){
			name = lineTxt.substring(lineTxt.indexOf(":") + 1, lineTxt.indexOf("性别"));
		}
		return name.trim();
	}
	
}
