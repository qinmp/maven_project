import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import excel.ExportExcel;

public class TextLineDeal_babyweight {
	
	public static String sumExcelPath1_1 = "C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡1.xlsx";
	public static String sumExcelPath1_2 = "C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡1-2.xlsx";
	public static String sumExcelPath2_1 = "C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡2.xlsx";
	public static String sumExcelPath2_2 = "C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡2-2.xlsx";
	
	private static List<Map<String, Object>> getDefaultTable() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] headers = { "产检卡号", "孕周1", "体重1", "孕周2", "体重2", "孕周3", "体重3", "孕周4", "体重4", "孕周5", 
				"体重5", "孕周6", "体重6", "孕周7", "体重7", "孕周8", "体重8", "孕周9", "体重9", "孕周10", "体重10", "孕周11", "体重11", "孕周12", "体重12"};
		for (int i = 0; i < headers.length; i++) {
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			fieldMap.put("formName", headers[i]);
			result.add(fieldMap);
		}
		return result;
	}
	private static List<Map<String, Object>> getDefaultTable2() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] headers = new String[43];
		String title = "";
		for(int i=0;i<=42;i++){
			if(i==0){
				title = "产检卡号";
			}else{
				title = "孕" + (i + 7) + "周体重";
			}
			headers[i] = title;
		}
		for (int i = 0; i < headers.length; i++) {
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			fieldMap.put("formName", headers[i]);
			result.add(fieldMap);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String folderpath = "C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡2-txt\\";
		
		File dealFolder = new File(folderpath);
		File[] filelist = dealFolder.listFiles();
		Map<String, List<Liner>> totalMap = new LinkedHashMap<String, List<Liner>>();
		try {
				for(File tempFile:filelist){
					BufferedReader reader;
					String lineTxt = null;
					List<Liner> liners = new LinkedList<Liner>();;
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile),"UTF-8"));
					while((lineTxt=reader.readLine()) != null){
						if(StringUtils.isNotBlank(lineTxt.trim())){
							if(lineTxt.contains("kg") && lineTxt.contains("日")){
								String temp = lineTxt.substring(lineTxt.indexOf("日") + 1, lineTxt.length());
								temp = temp.trim();
								String needArray[] = temp.split(" ");
								Liner liner = new Liner();
								liner.setKey(needArray[0]);
								liner.setValue(needArray[1].substring(0, needArray[1].indexOf("kg")));
								liners.add(liner);
							}
						}
					}
					totalMap.put(tempFile.getName(), liners);
					reader.close();
				}
				System.out.println(totalMap.size());
				saveMapDataToExcel(totalMap);
				System.out.println("==================finished==================");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	private static void saveMapDataToExcel(Map<String, List<Liner>> totalMap) {
		List<Map<String, Object>> headers = getDefaultTable();
		List<Map<String, Object>> headers2 = getDefaultTable2();
		List<String> headerList = new ArrayList<String>();
		List<String> headerList2 = new ArrayList<String>();
		for (Map<String, Object> header : headers) {
			headerList.add(header.get("formName").toString());
		}
		for (Map<String, Object> header2 : headers2) {
			headerList2.add(header2.get("formName").toString());
		}
		ExportExcel exportExcel = new ExportExcel("", headerList);
		ExportExcel exportExcel2 = new ExportExcel("", headerList2);
		for(String kky:totalMap.keySet()){
			writeExcel1(kky, totalMap.get(kky), exportExcel);
 			writeExcel2(kky, totalMap.get(kky), exportExcel2);
		}
		try {
			exportExcel.writeFile(sumExcelPath2_1);
			exportExcel2.writeFile(sumExcelPath2_2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeExcel2(String kky, List<Liner> list, ExportExcel exportExcel) {
		Row row = exportExcel.addRow();
		exportExcel.addCell(row, 0, kky.substring(0, kky.lastIndexOf(".")));
		for(Liner liner:list){
			Integer weekend = Integer.valueOf(liner.getKey());
			if(weekend >= 8){
				exportExcel.addCell(row, weekend - 7, Double.valueOf(liner.getValue()));
			}
		}
		
	}

	private static void writeExcel1(String kky, List<Liner> list, ExportExcel exportExcel) {
		int i = 1;
		Row row = exportExcel.addRow();
		exportExcel.addCell(row, 0, kky.substring(0, kky.lastIndexOf(".")));
		for(Liner liner:list){
			exportExcel.addCell(row, i, Integer.valueOf(liner.getKey()));
			exportExcel.addCell(row, ++i, Double.valueOf(liner.getValue()));
			i++;
		}
	}
	

}
