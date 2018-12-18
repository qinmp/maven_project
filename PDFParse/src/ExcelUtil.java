import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import excel.ExportExcel;

public class ExcelUtil {
	
	public static String sumExcelPath = "C:\\Users\\qinmp\\Desktop\\pdffile4\\excel\\体成分数据采集专用.xlsx";
	public static String txtFileDirectoryPath = "C:\\Users\\qinmp\\Desktop\\pdffile4\\txt2\\";
	public List<Map<String, Object>> getDefaultTable() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] headers = { "姓名", "年龄（岁）", "体成分编号", "身高（cm）", "孕前体重(kg)", "孕周-体成分检测时（周+天）"
				, "体成分检测时间", "当前体重（kg）-体成分检测时", "当前体重增长（kg）", "与孕期推荐体重增长关系（低于0、符合1、高于2）", 
				"细胞内液（kg）", "细胞外液（kg）", "蛋白质（kg）", "无机盐（kg）", "体脂肪（kg）", "体脂百分百(%)", "能量建议值（kcal/d）", 
				"细胞内外液量比（%）", "总体水（kg）", "肌肉量（kg）", "去脂体重（kg）"};
		for (int i = 0; i < headers.length; i++) {
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			fieldMap.put("formName", headers[i]);
			result.add(fieldMap);
		}
		return result;
	}
	
	public void exportToExcel(){
			System.out.println("======================填充excel开始======================");
			List<Map<String, Object>> headers = getDefaultTable();
			List<String> headerList = new ArrayList<String>();
			for (Map<String, Object> header : headers) {
				headerList.add(header.get("formName").toString());
			}
			String title = "体成分统计";
			ExportExcel exportExcel = new ExportExcel(title, headerList);
			List<Map<String, String>> txtFileMapList = getListMapFromTxtFiles(txtFileDirectoryPath);;
			for (Map<String, String> data : txtFileMapList) {
				Row row = exportExcel.addRow();
				exportExcel.addCell(row, 0, data.get("姓名"));
				exportExcel.addCell(row, 1, data.get("年龄"));
				exportExcel.addCell(row, 2, data.get("编号"));
				exportExcel.addCell(row, 3, data.get("身高"));
				exportExcel.addCell(row, 4, data.get("孕前体重"));
				exportExcel.addCell(row, 5, data.get("孕周"));
				exportExcel.addCell(row, 6, data.get("检测时间"));
				exportExcel.addCell(row, 7, data.get("当前体重增长"));
				exportExcel.addCell(row, 8, data.get("当前体重增长"));
				exportExcel.addCell(row, 9, 0);
				exportExcel.addCell(row, 10,data.get("细胞内液"));
				exportExcel.addCell(row, 11,data.get("细胞外液"));
				exportExcel.addCell(row, 12,data.get("蛋白质"));
				exportExcel.addCell(row, 13,data.get("无机盐"));
				exportExcel.addCell(row, 14,data.get("体脂肪"));
				exportExcel.addCell(row, 15,data.get("体脂百分比"));
				exportExcel.addCell(row, 16,data.get("能量建议值"));
				exportExcel.addCell(row, 17,0);
				exportExcel.addCell(row, 18,data.get("总体水"));
				exportExcel.addCell(row, 19,data.get("肌肉量"));
				exportExcel.addCell(row, 20,data.get("去脂重"));
			}
			try {
				exportExcel.writeFile(sumExcelPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("======================填充excel结束======================");
	}

	private List<Map<String, String>> getListMapFromTxtFiles(String txtFileDirectoryPath2) {
		File file = new File(txtFileDirectoryPath2);
		List<Map<String, String>> list = new LinkedList<Map<String,String>>();
		if(file.isDirectory()){
			File[] files = file.listFiles(); 
			for (int i = 0; i < files.length; i++) {
				try {
					File tempFile = files[i];
					//不处理文件夹
					if(tempFile.isDirectory()){
						continue;
					}
					System.out.println("正在读取文件-------》》" + tempFile.getName());
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile)));
					String lineTxt = null;
					try {
						Map<String, String> tempMap = new HashMap<String, String>();
						while((lineTxt=reader.readLine()) != null){
							if(StringUtils.isNotBlank(lineTxt)){
								String[] keyValue = lineTxt.split("：");
								if(keyValue.length == 2){
									tempMap.put(keyValue[0].trim(), keyValue[1].trim());
								}
							}
						}
						list.add(tempMap);
						reader.close();
						System.out.println("读取完成-------》》" + tempFile.getName());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		new ExcelUtil().exportToExcel();
	}
}
