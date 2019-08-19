import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import excel.ExportExcel;

public class ExcelUtil3 {
	
	public static String sumExcelPath = "C:\\Users\\qinmp\\Desktop\\txt\\excel\\1.检验信息.xlsx";
	public List<Map<String, Object>> getDefaultTable() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] headers = { "姓名", "年龄", "建卡时空腹总胆固醇(TC)（mmol/L）", "建卡时甘油三脂(TG)（mmol/L）", "建卡时高密度脂蛋白胆固醇(HDL-C)（mmol/L）", "建卡时低密度脂蛋白胆固醇(LDL-C)（mmol/L）"
				, "建卡时空腹血糖（mmol/L）", "建卡时糖化血红蛋白(%)", "建卡时糖化血红蛋白(IFCC)（mmol/mol）", "建卡时糖化血清白蛋白(%)", 
				"OGTT空腹血糖（mmol/L）", "OGTT餐后60分钟血糖（mmol/L）", "OGTT餐后120分钟血糖（mmol/L）", 
				"血糖测定0分钟","血糖测定30分钟","血糖测定60分钟","血糖测定120分钟","血糖测定180分钟", 
				"胰岛素0分钟","胰岛素30分钟","胰岛素60分钟","胰岛素120分钟","胰岛素180分钟", 
				"孕37周空腹血糖（mmol/L）", "孕37周糖化血清白蛋白(%)", "孕37周空腹总胆固醇(TC)（mmol/L）", "孕37周甘油三醋(TG)（mmol/L）", 
				"孕37周高密度脂蛋白胆固醇(HDL-C)（mmol/L）", "孕37周低密度脂蛋白胆固醇(LDL-C)（mmol/L）", "住院号", "联系电话","产后出血量（ml）", "新生儿出生体重（g）", "产后诊断", "备注"};
		for (int i = 0; i < headers.length; i++) {
			Map<String, Object> fieldMap = new HashMap<String, Object>();
			fieldMap.put("formName", headers[i]);
			result.add(fieldMap);
		}
		return result;
	}
	
	public static boolean isNumeric(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        return true;
    }
	
	public void exportToExcel(){
			System.out.println("======================填充excel开始======================");
			List<Map<String, Object>> headers = getDefaultTable();
			List<String> headerList = new ArrayList<String>();
			for (Map<String, Object> header : headers) {
				headerList.add(header.get("formName").toString());
			}
			String title = "体成份收集";
			ExportExcel exportExcel = new ExportExcel(title, headerList);
			List<ExcelMapDTO> excelMapDTOs = TextLineDeal3.getExcelMapData();
			for (ExcelMapDTO data : excelMapDTOs) {
				Row row = exportExcel.addRow();
				exportExcel.addCell(row, 0, data.getName());
				exportExcel.addCell(row, 1, isNumeric(data.getAge())?Double.valueOf(data.getAge()):data.getAge());
				exportExcel.addCell(row, 2, isNumeric(data.getTc())?Double.valueOf(data.getTc()):data.getTc());
				exportExcel.addCell(row, 3, isNumeric(data.getTg())?Double.valueOf(data.getTg()):data.getTg());
				exportExcel.addCell(row, 4, isNumeric(data.getHdl_c())?Double.valueOf(data.getHdl_c()):data.getHdl_c());
				exportExcel.addCell(row, 5, isNumeric(data.getLdl_c())?Double.valueOf(data.getLdl_c()):data.getLdl_c());
				exportExcel.addCell(row, 6, isNumeric(data.getBlood_sugar())?Double.valueOf(data.getBlood_sugar()):data.getBlood_sugar());
				exportExcel.addCell(row, 7, isNumeric(data.getGlycosylated_hemoglobin())?Double.valueOf(data.getGlycosylated_hemoglobin()):data.getGlycosylated_hemoglobin());
				exportExcel.addCell(row, 8, isNumeric(data.getIfcc_glycosylated_hemoglobin())?Double.valueOf(data.getIfcc_glycosylated_hemoglobin()):data.getIfcc_glycosylated_hemoglobin());
				exportExcel.addCell(row, 9, isNumeric(data.getGlycated_albumin())?Double.valueOf(data.getGlycated_albumin()):data.getGlycated_albumin());
				exportExcel.addCell(row, 10,isNumeric(data.getOgtt_blood_sugar())?Double.valueOf(data.getOgtt_blood_sugar()):data.getOgtt_blood_sugar());
				exportExcel.addCell(row, 11, isNumeric(data.getAfter_60_min_blood_sugar())?Double.valueOf(data.getAfter_60_min_blood_sugar()):data.getAfter_60_min_blood_sugar());
				exportExcel.addCell(row, 12, isNumeric(data.getAfter_120_min_blood_sugar())?Double.valueOf(data.getAfter_120_min_blood_sugar()):data.getAfter_120_min_blood_sugar());
				//血糖测定0~180分钟
				exportExcel.addCell(row, 13, isNumeric(data.getBlood_sugar_test_0_min())?Double.valueOf(data.getBlood_sugar_test_0_min()):data.getBlood_sugar_test_0_min());
				exportExcel.addCell(row, 14, isNumeric(data.getBlood_sugar_test_30_min())?Double.valueOf(data.getBlood_sugar_test_30_min()):data.getBlood_sugar_test_30_min());
				exportExcel.addCell(row, 15, isNumeric(data.getBlood_sugar_test_60_min())?Double.valueOf(data.getBlood_sugar_test_60_min()):data.getBlood_sugar_test_60_min());
				exportExcel.addCell(row, 16, isNumeric(data.getBlood_sugar_test_120_min())?Double.valueOf(data.getBlood_sugar_test_120_min()):data.getBlood_sugar_test_120_min());
				exportExcel.addCell(row, 17, isNumeric(data.getBlood_sugar_test_180_min())?Double.valueOf(data.getBlood_sugar_test_180_min()):data.getBlood_sugar_test_180_min());
				
				//胰岛素0~180分钟
				exportExcel.addCell(row, 18, isNumeric(data.getIletin_test_0_min())?Double.valueOf(data.getIletin_test_0_min()):data.getIletin_test_0_min());
				exportExcel.addCell(row, 19, isNumeric(data.getIletin_test_30_min())?Double.valueOf(data.getIletin_test_30_min()):data.getIletin_test_30_min());
				exportExcel.addCell(row, 20, isNumeric(data.getIletin_test_60_min())?Double.valueOf(data.getIletin_test_60_min()):data.getIletin_test_60_min());
				exportExcel.addCell(row, 21, isNumeric(data.getIletin_test_120_min())?Double.valueOf(data.getIletin_test_120_min()):data.getIletin_test_120_min());
				exportExcel.addCell(row, 22, isNumeric(data.getIletin_test_180_min())?Double.valueOf(data.getIletin_test_180_min()):data.getIletin_test_180_min());
				
				
				exportExcel.addCell(row, 23,isNumeric(data.getAfter_37_week_blood_sugar())?Double.valueOf(data.getAfter_37_week_blood_sugar()):data.getAfter_37_week_blood_sugar());
				exportExcel.addCell(row, 24,isNumeric(data.getAfter_37_week_glycated_albumin())?Double.valueOf(data.getAfter_37_week_glycated_albumin()):data.getAfter_37_week_glycated_albumin());
				exportExcel.addCell(row, 25,isNumeric(data.getAfter_37_week_tc())?Double.valueOf(data.getAfter_37_week_tc()):data.getAfter_37_week_tc());
				exportExcel.addCell(row, 26,isNumeric(data.getAfter_37_week_tg())?Double.valueOf(data.getAfter_37_week_tg()):data.getAfter_37_week_tg());
				exportExcel.addCell(row, 27,isNumeric(data.getAfter_37_week_hdl_c())?Double.valueOf(data.getAfter_37_week_hdl_c()):data.getAfter_37_week_hdl_c());
				exportExcel.addCell(row, 28,isNumeric(data.getAfter_37_week_ldl_c())?Double.valueOf(data.getAfter_37_week_ldl_c()):data.getAfter_37_week_ldl_c());
				exportExcel.addCell(row, 29,isNumeric(data.getMedical_record_no())?Double.valueOf(data.getMedical_record_no()):data.getMedical_record_no());
				exportExcel.addCell(row, 30,isNumeric(data.getMobile())?Double.valueOf(data.getMobile()):data.getMobile());
				exportExcel.addCell(row, 31,isNumeric(data.getPostpartum_hemorrhage())?Double.valueOf(data.getPostpartum_hemorrhage()):data.getPostpartum_hemorrhage());
				exportExcel.addCell(row, 32,isNumeric(data.getWeight())?Double.valueOf(data.getWeight()):data.getWeight());
				exportExcel.addCell(row, 33,data.getPostpartum_diagnosis());
				exportExcel.addCell(row, 34,data.getRemark());
			}
			try {
				exportExcel.writeFile(sumExcelPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("======================填充excel结束======================");
	}
	
	public static void main(String[] args){
		new ExcelUtil3().exportToExcel();
	}
}
