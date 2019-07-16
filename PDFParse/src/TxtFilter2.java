
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TxtFilter2 {
	
	public static ExecutorService executorService = null;
	
	static {
		executorService = Executors.newFixedThreadPool(15);
	}
	
	public static void txtFileFilter(String txtDirectorPath, String toPath){
		Set<String> unitSet = new HashSet<String>();
		for (int i = 0; i < PdfUtil.charaterStr.length; i++) {
			unitSet.add(PdfUtil.charaterStr[i]);
		}
		File txtFileDirector = new File(txtDirectorPath);
		if(txtFileDirector.exists()){
			if(txtFileDirector.isDirectory()){
				File[] files = txtFileDirector.listFiles();
				for(int i=0; i < files.length; i++){
					File file = files[i];
					TxtFilter2Thread txtFilter2Thread = new TxtFilter2Thread(file, toPath, unitSet);
					executorService.execute(txtFilter2Thread);
//					dealEachFile(unitSet, file);
				}
				executorService.shutdown();
			}
		}
	}


//	private static void dealEachFile(Set<String> unitSet, File file) {
//		System.out.println("current filter txt file is " + file.getName());
//		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//			String lineTxt = null;
//			try {
//				List<Liner> liners = new LinkedList<Liner>();
//				while((lineTxt=reader.readLine()) != null){
//					dealEachLineEliminateUnit(lineTxt, liners, unitSet);
//				}
//				linersIntoFile(liners, file);
//				reader.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}	
	
//	
//	private static void dealEachLineEliminateUnit(String lineTxt, List<Liner> liners, Set<String> unitSet) {
//		String filterStr = null;
//		Boolean isReplace = false;
//		for (String str : unitSet) {
//			if(lineTxt.contains(str)){
//				filterStr = lineTxt.replace(str, "");
//				isReplace = true;
//				break;
//			}
//		}
//		if(isReplace){
//			lineTxt = filterStr;
//		}
//		Liner liner = new Liner();
//		liner.setValue(lineTxt);
//		liners.add(liner);
//	}
//
//
//	private static void linersIntoFile(List<Liner> liners, File file) {
//		String toPath = "C:\\Users\\qinmp\\Desktop\\体成分数据-提取201907\\201907-txt3\\";
//		PrintWriter out = null;
//		String fileName = file.getName();
//		String txtFileName = fileName.substring(0, fileName.indexOf(".")) + ".txt";
//		File txtFile = new File(toPath + txtFileName);
//		if(!txtFile.exists()){
//			try {
//				txtFile.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			out = new PrintWriter(new BufferedWriter(new FileWriter(txtFile, true)));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		if(!liners.isEmpty()){
//			for (Liner liner : liners) {
//				out.println(liner.getValue());
//			}
//		}
//		out.flush();
//		out.close();
//		
//	}


	public  static void main(String[] args)
	{

		TxtFilter2.txtFileFilter("C:\\Users\\qinmp\\Desktop\\体成分数据-提取201907\\201907-txt2\\",
"C:\\Users\\qinmp\\Desktop\\体成分数据-提取201907\\201907-txt3\\");
	while(!executorService.isTerminated()){
			
		}
		System.out.println("===============转化完成===============");
	}

}
