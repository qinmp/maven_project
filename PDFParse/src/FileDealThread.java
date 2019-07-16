import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FileDealThread implements Runnable {

	public static Set<String> unitSet = null;
	private String toPath = "";
	static {
		unitSet = new HashSet<String>();
		for (int i = 0; i < PdfUtil.charaterStr.length; i++) {
			unitSet.add(PdfUtil.charaterStr[i]);
		}
	}
	
	private File dealFile = null;
	
	public FileDealThread(File file, String toPath){
		dealFile = file;
		this.toPath = toPath;
	}
	
	public void run() {
		System.out.println("current thread is: " + Thread.currentThread().getId() + "=====current filter txt file is " + dealFile.getName());
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dealFile)));
			String lineTxt = null;
			try {
				List<Liner> liners = new LinkedList<Liner>();
				int j = 0;
				while((lineTxt=reader.readLine()) != null){
					j++;
					dealEachLine(lineTxt, j, liners);
				}
				linersIntoFile(liners, dealFile);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void linersIntoFile(List<Liner> liners, File file) {
		String toPath = this.toPath;
		PrintWriter out = null;
		String fileName = file.getName();
		String txtFileName = fileName.substring(0, fileName.indexOf(".")) + ".txt";
		File txtFile = new File(toPath + txtFileName);
		if(!txtFile.exists()){
			try {
				txtFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(txtFile, true)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(!liners.isEmpty()){
			for (Liner liner : liners) {
				dealEachLineEliminateUnit(liner.getValue(), liner, unitSet);
				out.println(liner.getValue());
			}
		}
		out.flush();
		out.close();
		
	}
	
	private void dealEachLineEliminateUnit(String lineTxt, Liner liner, Set<String> unitSet) {
		String filterStr = null;
		Boolean isReplace = false;
		for (String str : unitSet) {
			if(lineTxt.contains(str)){
				filterStr = lineTxt.replace(str, "");
				isReplace = true;
				break;
			}
		}
		if(isReplace){
			lineTxt = filterStr;
		}
		liner.setValue(lineTxt);
	}
	
	private void dealEachLine(String lineTxt, int j, List<Liner> liners) {
		Liner liner = null;
		String temp = null;
		switch (j) {
		case 1:
			
			break;
		case 2:
			temp = lineTxt.substring(0, lineTxt.indexOf("编号")) ;
			liner = new Liner();
			liner.setIndex(1);
			liner.setKey("姓名");
			liner.setValue(temp);
			liners.add(liner);
			temp = lineTxt.substring(lineTxt.indexOf("编号"), lineTxt.length()) ;
			liner = new Liner();
			liner.setIndex(2);
			liner.setKey("编号");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 3:
			liner = new Liner();
			liner.setIndex(3);
			liner.setKey("年龄");
			liner.setValue(lineTxt);
			liners.add(liner);
			break;
		case 4:
			temp = lineTxt.substring(0, lineTxt.indexOf("血压")) ;
			liner = new Liner();
			liner.setIndex(4);
			liner.setKey("孕前体重");
			liner.setValue(temp);
			liners.add(liner);
			
			temp = lineTxt.substring(lineTxt.indexOf("血压"), lineTxt.length()) ;
			liner = new Liner();
			liner.setIndex(5);
			liner.setKey("血压");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 5:
			liner = new Liner();
			liner.setIndex(6);
			liner.setKey("身高");
			liner.setValue(lineTxt);
			liners.add(liner);
			break;
		case 6:
			liner = new Liner();
			liner.setIndex(7);
			liner.setKey("孕期");
			liner.setValue(lineTxt);
			liners.add(liner);
			break;
		case 7:
			temp = lineTxt.substring(0, lineTxt.indexOf("血糖")) ;
			liner = new Liner();
			liner.setIndex(8);
			liner.setKey("孕前BMI");
			liner.setValue(temp);
			liners.add(liner);
			
			temp = lineTxt.substring(lineTxt.indexOf("血糖"), lineTxt.length()) ;
			liner = new Liner();
			liner.setIndex(9);
			liner.setKey("血糖");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 8:
			temp = lineTxt.substring(0, lineTxt.indexOf("检测时间")) ;
			liner = new Liner();
			liner.setIndex(10);
			liner.setKey("孕周");
			liner.setValue(temp);
			liners.add(liner);
			
			temp = lineTxt.substring(lineTxt.indexOf("检测时间"), lineTxt.indexOf("贫血")) ;
			liner = new Liner();
			liner.setIndex(11);
			liner.setKey("检测时间");
			liner.setValue(temp);
			liners.add(liner);
			
			temp = lineTxt.substring(lineTxt.indexOf("贫血"), lineTxt.length()) ;
			liner = new Liner();
			liner.setIndex(12);
			liner.setKey("贫血");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			
			break;
		case 13:
			
			break;
		case 14:
			
			break;
		case 15:
			
			break;
		case 16:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(13);
			liner.setKey("细胞内液");
			liner.setValue("细胞内液：" + temp);
			liners.add(liner);
			break;
		case 17:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(14);
			liner.setKey("细胞外液");
			liner.setValue("细胞外液：" + temp);
			liners.add(liner);
			break;
		case 18:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(15);
			liner.setKey("蛋白质");
			liner.setValue("蛋白质：" + temp);
			liners.add(liner);
			break;
		case 19:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(16);
			liner.setKey("无机盐");
			liner.setValue("无机盐：" + temp);
			liners.add(liner);
			break;
		case 20:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(17);
			liner.setKey("体脂肪");
			liner.setValue("体脂肪：" + temp);
			liners.add(liner);
			break;
		case 21:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(18);
			liner.setKey("总体水");
			liner.setValue("总体水：" + temp);
			liners.add(liner);
			break;
		case 22:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(19);
			liner.setKey("肌肉量");
			liner.setValue("肌肉量：" + temp);
			liners.add(liner);
			break;
		case 23:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(20);
			liner.setKey("去脂重");
			liner.setValue("去脂重：" + temp);
			liners.add(liner);
			break;
		case 24:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(21);
			liner.setKey("体重");
			liner.setValue("体重：" + temp);
			liners.add(liner);
			break;
		case 25:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(22);
			liner.setKey("体脂百分比");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 26:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(23);
			liner.setKey("基础代谢率");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 27:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(24);
			liner.setKey("能量建议值");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 28:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(25);
			liner.setKey("推荐孕期体重增长");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 29:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(26);
			liner.setKey("推荐孕早期体重增长");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 30:
			temp = lineTxt ;
			liner = new Liner();
			liner.setIndex(27);
			liner.setKey("当前体重增长");
			liner.setValue(temp);
			liners.add(liner);
			break;
		case 31:
			break;
		default:
			break;
		}
		
	}
	
}
