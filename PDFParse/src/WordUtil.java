
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordUtil {
	
public static ExecutorService executorService = null;
	
	static {
		executorService = Executors.newFixedThreadPool(15);
	}
	
	public static String constantStr[] = {"姓名","编号", "年龄", "孕前体重", "血压",
			"身高", "孕期", "孕前BMI", "血糖", "孕周", "检测时间", "贫血", "细胞内液(kg)",
			"细胞外液(kg)", "蛋白质(kg)", "无机盐(kg)", "体脂肪(kg)", "总体水", "肌肉量",
			"去脂重", "体重", "体脂百分比", "基础代谢率", "能量建议值", "推荐孕期体重增长", "推荐孕晚期每周体重增长", 
			"当前体重增长", };
	
	public static String charaterStr[] = {"%", "kcal/d", "kg", "kg/wk", "kg/m²" ,
			 "cm", "岁"};
	
	public static void getTextFromPDF() 
	{
		String pdfPath = "D:\\360极速浏览器下载\\检验信息收集\\顺产检验信息-示例.docx";
		String txtFilePath = "C:\\Users\\qinmp\\Desktop\\wordfile\\txt\\";
		// 文件输入流，生成文本文件
		File files = new File(pdfPath);
//		File[] listFiles = files.listFiles();
//		for (int i = 0; i < listFiles.length; i++) {
			File tempFile = files;
			if(!tempFile.isDirectory()){
				WordFileDealThread wordDealThread = new WordFileDealThread(tempFile, txtFilePath);
				executorService.execute(wordDealThread);
			}
//		}
		executorService.shutdown();
	}
	
	public  static void main(String[] args)
	{
		WordUtil.getTextFromPDF();
		while(!executorService.isTerminated()){
			
		}
		System.out.println("===============转化完成===============");
	
	}

}
