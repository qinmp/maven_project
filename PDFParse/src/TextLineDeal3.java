import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class TextLineDeal3 {
	
	static String personFilePath = "C:\\Users\\qinmp\\Desktop\\wordfile_20181213_4\\name-txt\\";
	static String tc          					= "总胆固醇";
	static String tg          					= "甘油三脂";
	static String hdl_c       					= "高密度脂蛋白";
	static String ldl_c       					= "低密度脂蛋白";
	static String blood_sugar      				= "血糖";
	static String after_60_min_blood_sugar 		= "餐后血糖60分钟";
	static String after_120_min_blood_sugar 	= "餐后血糖120分钟";
	static String glycosylated_hemoglobin  		= "糖化血红蛋白";
	static String ifcc_glycosylated_hemoglobin 	= "糖化血红蛋白(IFCC)";
	static String glycated_albumin 				= "糖化血清白蛋白";
	static String mobile						= "联系方式";
	static String remark						= "备注";
	static String hospital_no					= "病历号";

	
	public static List<ExcelMapDTO> getExcelMapData(){

		File nameTxtFolder = new File(personFilePath);
		File[] filelist = nameTxtFolder.listFiles();
		List<ExcelMapDTO> excelMap = new LinkedList<ExcelMapDTO>();
		try {
			for(File tempFolder:filelist){
				if(tempFolder.isDirectory()){
					File[] inFolderFileList = tempFolder.listFiles();
					for(File tempFile:inFolderFileList){
						Map<String, Integer> countMap = new HashMap<String, Integer>();
						ExcelMapDTO excelMapDTO = new ExcelMapDTO();
						BufferedReader reader;
						String lineTxt = null;
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile)));
						while((lineTxt=reader.readLine()) != null){
							dealAPersonData(lineTxt, excelMapDTO, countMap);
						}
						excelMap.add(excelMapDTO);
						reader.close();
						System.out.println("==================finished==================");
					}
				}
			}
			System.out.println(excelMap.size());
			return excelMap;
//			writeExcelMapToExcel(excelMap);
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void dealAPersonData(String lineTxt, ExcelMapDTO excelMapDTO, Map<String, Integer> countMap) {
			String tmpvar;
			if(StringUtils.isNotBlank(lineTxt.trim())){
				if(lineTxt.contains("姓名")){//姓名
					if(StringUtils.isBlank(excelMapDTO.getName())){
						tmpvar = getName(lineTxt);
						excelMapDTO.setName(tmpvar);
					}
					if(StringUtils.isBlank(excelMapDTO.getAge())){
						tmpvar = getAge(lineTxt);
						excelMapDTO.setAge(tmpvar);
					}
				} else if(lineTxt.contains("病历号") || lineTxt.contains("住院号") || lineTxt.contains("联系方式")){//住院号
					if(StringUtils.isBlank(excelMapDTO.getMedical_record_no()) && lineTxt.contains("住院号")){
						tmpvar = getMedical_record_no(lineTxt);
						excelMapDTO.setMedical_record_no(tmpvar);
					}
					if(StringUtils.isBlank(excelMapDTO.getMobile()) && lineTxt.contains("联系方式")){
						tmpvar = getMobile(lineTxt);
						excelMapDTO.setMobile(tmpvar);
					}
					if(StringUtils.isBlank(excelMapDTO.getMedical_record_no()) && lineTxt.contains("病历号")){
						tmpvar = get_hospital_record_no(lineTxt);
						excelMapDTO.setMedical_record_no(tmpvar);
					}
				} else if(lineTxt.contains("产后出血") || lineTxt.contains("术中出血量")){//术中出血量, 产后出血
					if(StringUtils.isBlank(excelMapDTO.getPostpartum_hemorrhage())){
						tmpvar = getPostpartum_hemorrhage(lineTxt);
						excelMapDTO.setPostpartum_hemorrhage(tmpvar);
					}
				} else if(lineTxt.contains("诊断") || lineTxt.contains("体重")){//诊断, 体重
					if(lineTxt.contains("诊断") && lineTxt.contains("体重") && !lineTxt.contains("出生体重") && !lineTxt.contains("低体重儿")){
						if(StringUtils.isBlank(excelMapDTO.getWeight())){
							String tg1 = getWeight(lineTxt);
							excelMapDTO.setWeight(tg1.trim());
						}
						if(StringUtils.isBlank(excelMapDTO.getPostpartum_diagnosis())){
							tmpvar = getPostpartum_diagnosis(lineTxt);
							excelMapDTO.setPostpartum_diagnosis(tmpvar);
							//处理诊断中的备注
							tmpvar = getRemark(lineTxt);
							if(StringUtils.isBlank(excelMapDTO.getRemark())){
								excelMapDTO.setRemark(tmpvar);
							}
						}
					}else if(lineTxt.contains("体重") && !lineTxt.contains("出生体重") && !lineTxt.contains("低体重儿")){
						if(StringUtils.isBlank(excelMapDTO.getWeight())){
							tmpvar = getWeight(lineTxt);
							excelMapDTO.setWeight(tmpvar);
						}
					}else{
						if(StringUtils.isBlank(excelMapDTO.getPostpartum_diagnosis())){
							tmpvar = getPostpartum_diagnosis(lineTxt);
							excelMapDTO.setPostpartum_diagnosis(tmpvar);
							//处理诊断中的备注
							tmpvar = getRemark(lineTxt);
							if(StringUtils.isBlank(excelMapDTO.getRemark())){
								excelMapDTO.setRemark(tmpvar);
							}
						}
					}

				} else if(lineTxt.contains(tc)){//总胆固醇, 37周空腹总胆固醇
					if(countMap.get(tc) != null){
						countMap.put(tc, countMap.get(tc) + 1);
						if(countMap.get(tc) == 2){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_tc())){
								tmpvar = getTc(lineTxt);
								excelMapDTO.setAfter_37_week_tc(tmpvar);
							}
						}
					}else{
						countMap.put(tc, 1);
						if(StringUtils.isBlank(excelMapDTO.getTc())){
							tmpvar = getTc(lineTxt);
							excelMapDTO.setTc(tmpvar);
						}
					}
				} else if(lineTxt.contains(tg)){//甘油三脂， 37周甘油三脂
					if(countMap.get(tg) != null){
						countMap.put(tg, countMap.get(tg) + 1);
						if(countMap.get(tg) == 2){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_tg())){
								tmpvar = getTg(lineTxt);
								excelMapDTO.setAfter_37_week_tg(tmpvar);
							}
						}
					}else{
						countMap.put(tg, 1);
						if(StringUtils.isBlank(excelMapDTO.getTg())){
							tmpvar = getTg(lineTxt);
							excelMapDTO.setTg(tmpvar);
						}
					}
				} else if(lineTxt.contains(hdl_c)){//高密度脂蛋白
					if(countMap.get(hdl_c) != null){
						countMap.put(hdl_c, countMap.get(hdl_c) + 1);
						if(countMap.get(hdl_c) == 2){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_hdl_c())){
								tmpvar = getHdl_c(lineTxt);
								excelMapDTO.setAfter_37_week_hdl_c(tmpvar);
							}
						}
					}else{
						countMap.put(hdl_c, 1);
						if(StringUtils.isBlank(excelMapDTO.getHdl_c())){
							tmpvar = getHdl_c(lineTxt);
							excelMapDTO.setHdl_c(tmpvar);
						}
					}
				} else if(lineTxt.contains(ldl_c)){//低密度脂蛋白
					if(countMap.get(ldl_c) != null){
						countMap.put(ldl_c, countMap.get(ldl_c) + 1);
						if(countMap.get(ldl_c) == 2){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_ldl_c())){
								tmpvar = getLdl_c(lineTxt);
								excelMapDTO.setAfter_37_week_ldl_c(tmpvar);
							}
						}
					}else{
						countMap.put(ldl_c, 1);
						if(StringUtils.isBlank(excelMapDTO.getLdl_c())){
							tmpvar = getLdl_c(lineTxt);
							excelMapDTO.setLdl_c(tmpvar);
						}
					}
				} else if(lineTxt.contains(blood_sugar) && !lineTxt.contains("血糖测定") && !lineTxt.contains("餐后血糖")){//建卡时血糖（mmol/L）, OGTT空腹血糖, 37周血糖
					if(countMap.get(blood_sugar) != null){
						countMap.put(blood_sugar, countMap.get(blood_sugar) + 1);
						if(countMap.get(blood_sugar) == 2){
							if(StringUtils.isBlank(excelMapDTO.getOgtt_blood_sugar())){
								tmpvar = getBlood_sugar(lineTxt);
								excelMapDTO.setOgtt_blood_sugar(tmpvar);
							}
						}else if(countMap.get(blood_sugar) == 3){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_blood_sugar())){
								tmpvar = getBlood_sugar(lineTxt);
								excelMapDTO.setAfter_37_week_blood_sugar(tmpvar);
							}
						}
					}else{
						countMap.put(blood_sugar, 1);
						if(StringUtils.isBlank(excelMapDTO.getBlood_sugar())){
							tmpvar = getBlood_sugar(lineTxt);
							excelMapDTO.setBlood_sugar(tmpvar);
						}
					}
				} else if(lineTxt.contains(after_60_min_blood_sugar) ){//餐后血糖60分钟
					countMap.put(after_60_min_blood_sugar, 1);
					if(StringUtils.isBlank(excelMapDTO.getAfter_60_min_blood_sugar())){
						tmpvar = getAfter_60_min_blood_sugar(lineTxt);
						excelMapDTO.setAfter_60_min_blood_sugar(tmpvar);
					}
				} else if(lineTxt.contains(after_120_min_blood_sugar) ){//餐后血糖120分钟
					countMap.put(after_120_min_blood_sugar, 1);
					if(StringUtils.isBlank(excelMapDTO.getAfter_120_min_blood_sugar())){
						tmpvar = getAfter_120_min_blood_sugar(lineTxt);
						excelMapDTO.setAfter_120_min_blood_sugar(tmpvar);
					}
				} else if(lineTxt.contains(ifcc_glycosylated_hemoglobin)){//糖化血红蛋白（IFCC）
					countMap.put(ifcc_glycosylated_hemoglobin, 1);
					if(StringUtils.isBlank(excelMapDTO.getIfcc_glycosylated_hemoglobin())){
						tmpvar = getIfcc_glycosylated_hemoglobin(lineTxt);
						excelMapDTO.setIfcc_glycosylated_hemoglobin(tmpvar);
					}
				} else if(lineTxt.contains(glycosylated_hemoglobin)){//糖化血红蛋白
					countMap.put(glycosylated_hemoglobin, 1);
					if(StringUtils.isBlank(excelMapDTO.getGlycosylated_hemoglobin())){
						tmpvar = getGlycosylated_hemoglobin(lineTxt);
						excelMapDTO.setGlycosylated_hemoglobin(tmpvar);
					}
				} else if(lineTxt.contains(glycated_albumin)){//糖化血清蛋白, 37周糖化血清蛋白
					if(countMap.get(glycated_albumin) != null){
						countMap.put(glycated_albumin, countMap.get(glycated_albumin) + 1);
						if(countMap.get(glycated_albumin) == 2){
							if(StringUtils.isBlank(excelMapDTO.getAfter_37_week_glycated_albumin())){
								tmpvar = getGlycated_albumin(lineTxt);
								excelMapDTO.setAfter_37_week_glycated_albumin(tmpvar);
							}
						}
					}else{
						countMap.put(glycated_albumin, 1);
						if(StringUtils.isBlank(excelMapDTO.getGlycated_albumin())){
							tmpvar = getGlycated_albumin(lineTxt);
							excelMapDTO.setGlycated_albumin(tmpvar);
						}
					}

				}  
		}
	}

	private static String get_hospital_record_no(String lineTxt) {
		try {
			if(!lineTxt.contains(hospital_no)){
				return "";
			}
			String tg1 = lineTxt.substring(lineTxt.lastIndexOf(hospital_no) + 4, lineTxt.length());
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getRemark(String lineTxt) {
		try {
			if(!lineTxt.contains(remark)){
				return "";
			}
			String tg1 = lineTxt.substring(lineTxt.lastIndexOf(remark) + 3, lineTxt.length());
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getAge(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf("年龄") + 3, lineTxt.indexOf("岁"));
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getPostpartum_diagnosis(String lineTxt) {
		try {
			if(lineTxt.contains("临床诊断")){
				return "";
			}
			String tg1 = lineTxt.substring(lineTxt.indexOf("诊断") + 3, lineTxt.indexOf("#"));
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getWeight(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf("体重") + 2, lineTxt.indexOf("g"));
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getPostpartum_hemorrhage(String lineTxt) {
		try {
			String tg1 = "";
			if(lineTxt.contains("产后出血")){
				tg1 = lineTxt.substring(lineTxt.indexOf("总计") + 3, lineTxt.lastIndexOf("ml"));
			}else if(lineTxt.contains("术中出血量")){
				tg1 = lineTxt.substring(lineTxt.indexOf("术中出血量") + 5, lineTxt.lastIndexOf("ml"));
			}
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getMobile(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(mobile) + mobile.length() + 1, lineTxt.length());
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getAfter_120_min_blood_sugar(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(after_120_min_blood_sugar) + after_120_min_blood_sugar.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getAfter_60_min_blood_sugar(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(after_60_min_blood_sugar) + after_60_min_blood_sugar.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getGlycated_albumin(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(glycated_albumin) + glycated_albumin.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getGlycosylated_hemoglobin(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(glycosylated_hemoglobin) + glycosylated_hemoglobin.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getIfcc_glycosylated_hemoglobin(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(ifcc_glycosylated_hemoglobin) + ifcc_glycosylated_hemoglobin.length(), lineTxt.indexOf("～")-2);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getBlood_sugar(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(blood_sugar) + blood_sugar.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getLdl_c(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(ldl_c) + ldl_c.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getHdl_c(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(hdl_c) + hdl_c.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	private static String getTg(String lineTxt) {
		try {
			String tg1 = lineTxt.substring(lineTxt.indexOf(tg) + tg.length(), lineTxt.indexOf("～")-4);
			return tg1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getTc(String lineTxt) {
		try {
			String tc1 = lineTxt.substring(lineTxt.indexOf(tc) + tc.length(), lineTxt.indexOf("～")-4);
			return tc1.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getMedical_record_no(String lineTxt) {
		try {
			String medical_record_no = lineTxt.substring(lineTxt.indexOf("住院号") + 4, lineTxt.length());
			return medical_record_no.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String getName(String lineTxt){
		try {
			String name = lineTxt.substring(lineTxt.indexOf(":") + 1, lineTxt.indexOf("性别"));
			return name.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
