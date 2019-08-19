import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import excel.ExportExcel;
import excel.ImportExcel;

public class ExcelIntegrateDeal { 
	
	public static String excel1Path = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\1.检验信息.xlsx";
	public static String excel2Path = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\2.体成分.xlsx";
	public static String excel3Path = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\3.产科数据.xlsx";
	public static String excel4Path = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\4.1产检大卡1.xlsx";
	public static String excel5Path = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\4.2产检大卡1-2.xlsx";
	public static String sumExcelPath1 = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\sumExcel1.xlsx";
	public static String sumExcelPath2 = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\sumExcel2.xlsx";
	
	public static void main(String[] args) {
		
		Map<String, List<String>> data1 = readMap1();
		Map<String, List<String>> data2 = readMap2();
		Map<String, List<String>> data3 = readMap3();
		Map<String, List<String>> data4 = readMap4();
		Map<String, List<String>> data5 = readMap5();
		merge1(data1, data2, data3, data4);
		merge2(data1, data2, data3, data5);
	}
	
	private static void merge1(Map<String, List<String>> data1, Map<String, List<String>> data2,
			Map<String, List<String>> data3, Map<String, List<String>> data4) {
		for(String key:data1.keySet()){
			List<String> data1List = data1.get(key);
			List<String> data2List = data2.get(key);
			List<String> data3List = data3.get(key);
			String cardNoKey = "";
			if(data3List != null){
				cardNoKey = data3List.get(2);
			}
			List<String> data4List = data4.get(cardNoKey);
			if(data2List != null){
				data1List.addAll(data2List);
			}else{
				for(int i=0;i<=21;i++){
					data1List.add(" ");
				}
			}
			if(data3List != null){
				data1List.addAll(data3List);
			}else{
				for(int i=0;i<=112;i++){
					data1List.add(" ");
				}
			}
			if(data4List != null){
				data1List.addAll(data4List);
			}else{
				for(int i=0;i<=24;i++){
					data1List.add(" ");
				}
			}
		}
		ExportExcel exportExcel = null;
		for(String key:data1.keySet()){
			List<String> headers = data1.get(key);
			exportExcel = new ExportExcel("", headers);
			break;
		}
		for(String key:data1.keySet()){
			Row row = exportExcel.addRow();
			List<String> templist = data1.get(key);
			for(int jj=0;jj<=templist.size() - 1;jj++){
				exportExcel.addCell(row, jj, templist.get(jj));
			}
		}
		try {
			exportExcel.writeFile(sumExcelPath1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("======================填充excel结束======================");
		
	}

	private static void merge2(Map<String, List<String>> data1, Map<String, List<String>> data2,
			Map<String, List<String>> data3, Map<String, List<String>> data5) {
		for(String key:data1.keySet()){
			List<String> data1List = data1.get(key);
			List<String> data2List = data2.get(key);
			List<String> data3List = data3.get(key);
			String cardNoKey = "";
			if(data3List != null){
				cardNoKey = data3List.get(2);
			}
			List<String> data5List = data5.get(cardNoKey);
			if(data2List != null){
				data1List.addAll(data2List);
			}else{
				for(int i=0;i<=21;i++){
					data1List.add(" ");
				}
			}
			if(data3List != null){
				data1List.addAll(data3List);
			}else{
				for(int i=0;i<=112;i++){
					data1List.add(" ");
				}
			}
			if(data5List != null){
				data1List.addAll(data5List);
			}else{
				for(int i=0;i<=42;i++){
					data1List.add(" ");
				}
			}
		}
		ExportExcel exportExcel = null;
		for(String key:data1.keySet()){
			List<String> headers = data1.get(key);
			exportExcel = new ExportExcel("", headers);
			break;
		}
		for(String key:data1.keySet()){
			Row row = exportExcel.addRow();
			List<String> templist = data1.get(key);
			for(int jj=0;jj<=templist.size() - 1;jj++){
				exportExcel.addCell(row, jj, templist.get(jj));
			}
		}
		try {
			exportExcel.writeFile(sumExcelPath2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("======================填充excel结束======================");
		
	}

	public static Map<String, List<String>> readMap5(){

		Map<String, List<String>> mergeMap = new LinkedMap();
		try {
			ImportExcel importExcel = new ImportExcel(excel5Path, 0, 0);
			Integer lastNum = importExcel.getLastDataRowNum();
			for(int i=0;i<=lastNum;i++){
				Row row = importExcel.getRow(i);
				short lastColum = row.getLastCellNum();
				List<String> dataList = new LinkedList<String>();
				String nameKey = row.getCell(0).toString();
				for(int j=0;j<=lastColum-1;j++){
					Cell cell = row.getCell(j);
					if(cell == null){
						dataList.add(" ");
						continue;
					}
					String cellStr = cell.toString();
					if(StringUtils.isNotBlank(cellStr)){
						if(cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							BigDecimal bigDecimal = new BigDecimal(cell.toString());
							String numStr = bigDecimal.toPlainString();
							if(numStr.lastIndexOf(".0") != -1){
								dataList.add(numStr.substring(0, numStr.lastIndexOf(".0")));
							}else{
								dataList.add(numStr);
							}
						}else{
							dataList.add(cellStr);
						}
					}else{
						dataList.add(" ");
					}
				}
				if(lastColum < 43){
					for(int k=lastColum;k<=42;k++){
						dataList.add(" ");
					}
				}
				mergeMap.put(nameKey, dataList);
			}
			
			System.out.println(mergeMap.size());
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mergeMap;
	}
	public static Map<String, List<String>> readMap4(){
		
		Map<String, List<String>> mergeMap = new LinkedMap();
		try {
			ImportExcel importExcel = new ImportExcel(excel4Path, 0, 0);
			Integer lastNum = importExcel.getLastDataRowNum();
			for(int i=0;i<=lastNum;i++){
				Row row = importExcel.getRow(i);
				short lastColum = row.getLastCellNum();
				List<String> dataList = new LinkedList<String>();
				String nameKey = row.getCell(0).toString();
				for(int j=0;j<=lastColum-1;j++){
					Cell cell = row.getCell(j);
					String cellStr = cell.toString();
					if(StringUtils.isNotBlank(cellStr)){
						if(cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							BigDecimal bigDecimal = new BigDecimal(cell.toString());
							String numStr = bigDecimal.toPlainString();
							if(numStr.lastIndexOf(".0") != -1){
								dataList.add(numStr.substring(0, numStr.lastIndexOf(".0")));
							}else{
								dataList.add(numStr);
							}
						}else{
							dataList.add(cellStr);
						}
					}else{
						dataList.add(" ");
					}
				}
				if(lastColum < 25){
					for(int k=lastColum;k<=24;k++){
						dataList.add(" ");
					}
				}
				mergeMap.put(nameKey, dataList);
			}
			
			System.out.println(mergeMap.size());
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mergeMap;
	}
	
	public static Map<String, List<String>> readMap3(){
		
		Map<String, List<String>> mergeMap = new LinkedMap();
		try {
			ImportExcel importExcel = new ImportExcel(excel3Path, 0, 0);
			Integer lastNum = importExcel.getLastDataRowNum();
			for(int i=0;i<=lastNum;i++){
				Row row = importExcel.getRow(i);
				if(row == null){
					break;
				}
				short lastColum = row.getLastCellNum();
				List<String> dataList = new LinkedList<String>();
				String nameKey = row.getCell(3).toString();
				for(int j=0;j<=lastColum-1;j++){
					Cell cell = row.getCell(j);
					String cellStr = cell.toString();
					if(StringUtils.isNotBlank(cellStr)){
						if(cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							BigDecimal bigDecimal = new BigDecimal(cell.toString());
							String numStr = bigDecimal.toPlainString();
							if(numStr.lastIndexOf(".0") != -1){
								dataList.add(numStr.substring(0, numStr.lastIndexOf(".0")));
							}else{
								dataList.add(numStr);
							}
						}else{
							dataList.add(cellStr);
						}
					}else{
						dataList.add(" ");
					}
				}
				mergeMap.put(nameKey, dataList);
			}
			
			System.out.println(mergeMap.size());
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mergeMap;
	}
	public static Map<String, List<String>> readMap2(){
		
		Map<String, List<String>> mergeMap = new LinkedMap();
		try {
			ImportExcel importExcel = new ImportExcel(excel2Path, 0, 0);
			Integer lastNum = importExcel.getLastDataRowNum();
			for(int i=0;i<=lastNum;i++){
				Row row = importExcel.getRow(i);
				short lastColum = row.getLastCellNum();
				List<String> dataList = new LinkedList<String>();
				String nameKey = row.getCell(0).toString();
				for(int j=0;j<=lastColum-1;j++){
					Cell cell = row.getCell(j);
					String cellStr = cell.toString();
					if(StringUtils.isNotBlank(cellStr)){
						if(cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							BigDecimal bigDecimal = new BigDecimal(cell.toString());
							String numStr = bigDecimal.toPlainString();
							if(numStr.lastIndexOf(".0") != -1){
								dataList.add(numStr.substring(0, numStr.lastIndexOf(".0")));
							}else{
								dataList.add(numStr);
							}
						}else{
							dataList.add(cellStr);
						}
					}else{
						dataList.add(" ");
					}
				}
				
				mergeMap.put(nameKey, dataList);
			}
			
			System.out.println(mergeMap.size());
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mergeMap;
	}
	
	public static Map<String, List<String>> readMap1(){

		Map<String, List<String>> mergeMap = new LinkedMap();
		try {
			ImportExcel importExcel = new ImportExcel(excel1Path, 0, 0);
			Integer lastNum = importExcel.getLastDataRowNum();
			for(int i=0;i<=lastNum;i++){
				Row row = importExcel.getRow(i);
				short lastColum = row.getLastCellNum();
				List<String> dataList = new LinkedList<String>();
				String nameKey = row.getCell(0).toString();
				for(int j=0;j<=lastColum-1;j++){
					Cell cell = row.getCell(j);
					String cellStr = cell.toString();
					if(StringUtils.isNotBlank(cellStr)){
						if(cell.getCellType() == Cell.CELL_TYPE_FORMULA || cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							BigDecimal bigDecimal = new BigDecimal(cell.toString());
							String numStr = bigDecimal.toPlainString();
							if(numStr.lastIndexOf(".0") != -1){
								dataList.add(numStr.substring(0, numStr.lastIndexOf(".0")));
							}else{
								dataList.add(numStr);
							}
						}else{
							dataList.add(cellStr);
						}
					}else{
						dataList.add(" ");
					}
				}
				mergeMap.put(nameKey, dataList);
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mergeMap;
	}

}
