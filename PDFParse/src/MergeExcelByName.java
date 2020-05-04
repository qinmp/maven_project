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

public class MergeExcelByName {
	
	public static String excel1Path = "/Users/qinmp/Downloads/工作簿1/工作簿1.xlsx";
	public static String excel2Path = "/Users/qinmp/Downloads/工作簿1/工作薄2.xlsx";
	public static String sumExcelPath1 = "/Users/qinmp/Downloads/工作簿1/sumExcel1.xlsx";

	public static void main(String[] args) {
		
		Map<String, List<String>> buildCardInfo = readBuildCardInfoMap();
		Map<String, List<String>> bodyInfo = readBodyInfoMap();
		merge1(buildCardInfo, bodyInfo);
	}

	private static void merge1(Map<String, List<String>> buildCardInfo, Map<String, List<String>> bodyInfo) {
		for(String key:buildCardInfo.keySet()){
			List<String> data1List = buildCardInfo.get(key);
			List<String> data2List = bodyInfo.get(key);
			if(data2List != null){
                data1List.addAll(data2List);
			}else{
				for(int i=0;i<=40;i++){
                    data1List.add(" ");
				}
			}
		}
		ExportExcel exportExcel = null;
		for(String key:buildCardInfo.keySet()){
			List<String> headers = buildCardInfo.get(key);
			exportExcel = new ExportExcel("", headers);
			break;
		}
		for(String key:buildCardInfo.keySet()){
			Row row = exportExcel.addRow();
			List<String> templist = buildCardInfo.get(key);
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

	public static Map<String, List<String>> readBodyInfoMap(){

        return getStringListMap(excel2Path,0);
    }

    private static Map<String, List<String>> getStringListMap(String path, Integer nameKeyIndex) {
        Map<String, List<String>> mergeMap = new LinkedMap();
        try {
            ImportExcel importExcel = new ImportExcel(path, 0, 0);
            Integer lastNum = importExcel.getLastDataRowNum();
            for(int i=0;i<=lastNum;i++){
                Row row = importExcel.getRow(i);
                if(null == row){
                    continue;
                }
                short lastColum = row.getLastCellNum();
                List<String> dataList = new LinkedList<String>();
                Cell nameKeyCell = row.getCell(nameKeyIndex);
                String nameKey = null != nameKeyCell?nameKeyCell.toString():"";
                if(StringUtils.isBlank(nameKey)){
                    continue;
                }
                System.out.println(" nameKey is:" + nameKey);
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

    public static Map<String, List<String>> readBuildCardInfoMap(){

        return getStringListMap(excel1Path,0);
	}

}
