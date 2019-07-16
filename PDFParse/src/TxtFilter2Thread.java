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

public class TxtFilter2Thread implements Runnable {

	public Set<String> unitSet = null;
	private String toPath = "";
	
	private File dealFile = null;
	
	public TxtFilter2Thread(File file, String toPath, Set<String> unitSet){
		dealFile = file;
		this.toPath = toPath;
		this.unitSet = unitSet;
		
	}
	
	public void run() {
		dealEachFile();
	}

	private void dealEachFile() {
		System.out.println("current thread is:" + Thread.currentThread().getName() + " current filter txt file is " + dealFile.getName());
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dealFile)));
			String lineTxt = null;
			try {
				List<Liner> liners = new LinkedList<Liner>();
				while((lineTxt=reader.readLine()) != null){
					dealEachLineEliminateUnit(lineTxt, liners, unitSet);
				}
				linersIntoFile(liners, dealFile, toPath);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void dealEachLineEliminateUnit(String lineTxt, List<Liner> liners, Set<String> unitSet) {
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
		Liner liner = new Liner();
		liner.setValue(lineTxt);
		liners.add(liner);
	}

	private void linersIntoFile(List<Liner> liners, File file, String toPath) {
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
				out.println(liner.getValue());
			}
		}
		out.flush();
		out.close();
		
	}

	
}
