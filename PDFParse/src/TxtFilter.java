
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TxtFilter {
	
	public static Set<String> unitSet = null;
	public static ExecutorService executorService = null;
	
	static {
		
		unitSet = new HashSet<String>();
		for (int i = 0; i < PdfUtil.charaterStr.length; i++) {
			unitSet.add(PdfUtil.charaterStr[i]);
		}
		executorService = Executors.newFixedThreadPool(15);
	}

	public static void txtFileFilter(String txtDirectorPath, String toPath){
		File txtFileDirector = new File(txtDirectorPath);
		if(txtFileDirector.exists()){
			if(txtFileDirector.isDirectory()){
				File[] files = txtFileDirector.listFiles();
				for(int i=0; i < files.length; i++){
					File file = files[i];
					FileDealThread thread1 = new FileDealThread(file, toPath);
					executorService.execute(thread1);
				}
				executorService.shutdown();
			}
		}

	}	

	public  static void main(String[] args)
	{
		TxtFilter.txtFileFilter("C:\\Users\\qinmp\\Desktop\\pdffile4\\txt\\",
				"C:\\Users\\qinmp\\Desktop\\pdffile4\\txt2\\");
		while(!executorService.isTerminated()){
			
		}
		System.out.println("===============转化完成===============");
//		String aa = "孕周： 9周 + 3天 检测时间： 2015-07-13 贫血： 否";
//		String temp = aa.substring(0, aa.indexOf("检测时间")) ;
//		String temp1 = aa.substring(aa.indexOf("检测时间"), aa.indexOf("贫血")) ;
//		String temp2 = aa.substring(aa.indexOf("贫血"), aa.length()) ;
//		System.out.println(temp);
//		System.out.println(temp1);
//		System.out.println(temp2);
//		String aa = "xx.pdf";
//		String temp = aa.substring(0, aa.indexOf("."));
//		System.out.println(temp);
	}

}
