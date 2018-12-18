import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class TextLineDeal {

	
	public static void main(String[] args) {
		String folderpath = "C:\\Users\\qinmp\\Desktop\\wordfile_20181213_4\\txt\\";
		
		File dealFolder = new File(folderpath);
		File[] filelist = dealFolder.listFiles();
		try {
				for(File tempFile:filelist){
					if(!tempFile.getName().contains("better")){
						String oldName = tempFile.getName().substring(0, tempFile.getName().indexOf("."));
						File betterfile = new File(folderpath + oldName + "-better.txt");
						if(!betterfile.exists()){
							try {
								betterfile.createNewFile();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						BufferedReader reader;
						String lineTxt = null;
						List<Liner> liners;
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile),"GBK"));
						liners = new LinkedList<Liner>();
						String preLine = "";
						while((lineTxt=reader.readLine()) != null){
							if(StringUtils.isNotBlank(lineTxt.trim())){
								if(preLine.contains("诊断") && !preLine.contains("临床诊断")){
									Liner templiner = liners.get(liners.size() - 1);
									templiner.setValue(templiner.getValue() + "#" + lineTxt);
									preLine = lineTxt;
									continue;
								}
								preLine = lineTxt;
								if(!isSatisfy(lineTxt)){
									continue;
								}
								Liner liner = new Liner();
								liner.setValue(lineTxt.replaceAll(" ", ""));
								liners.add(liner);
							}
						}
						reader.close();
						PrintWriter pwriter = new PrintWriter(betterfile);
						for (Liner liner:liners) {
							pwriter.println(liner.getValue());
						}
						pwriter.println("end");
						pwriter.flush();
						pwriter.close();
						System.out.println("==================finished==================");
					}
				}
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	private static boolean isSatisfy(String lineTxt) {
		
		Boolean isYes = false;
		if(lineTxt.contains("姓") && lineTxt.contains("名") ){
			isYes = true;
		} else if(lineTxt.contains("年") && lineTxt.contains("龄")){
			isYes = true;
		} else if(lineTxt.contains("总胆固醇")){
			isYes = true;
		} else if(lineTxt.contains("甘油三脂")){
			isYes = true;
		} else if(lineTxt.contains("高密度脂蛋白")){
			isYes = true;
		} else if(lineTxt.contains("低密度脂蛋白")){
			isYes = true;
		} else if(lineTxt.contains("血糖")){
			isYes = true;
		} else if(lineTxt.contains("糖化血红蛋白")){
			isYes = true;
		} else if(lineTxt.contains("糖化血红蛋白(IFCC)")){
			isYes = true;
		} else if(lineTxt.contains("糖化血红蛋白(IFCC)")){
			isYes = true;
		} else if(lineTxt.contains("糖化血清白蛋白")){
			isYes = true;
		} else if(lineTxt.contains("餐后血糖120分钟")){
			isYes = true;
		} else if(lineTxt.contains("餐后血糖60分钟")){
			isYes = true;
		}else if(lineTxt.contains("住院号")){
			isYes = true;
		} else if(lineTxt.contains("联系方式")){
			isYes = true;
		} else if(lineTxt.contains("出血")){
			isYes = true;
		} else if(lineTxt.contains("生儿")){
			isYes = true;
		} else if(lineTxt.contains("诊断") && !lineTxt.contains("临床诊断")){
			isYes = true;
		} else if(lineTxt.contains("临床诊断")) {
			isYes = false;
		} else {
			isYes = false;
		}
		return isYes;
	}
	
	
}
