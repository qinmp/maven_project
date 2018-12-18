package com.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.PrivinceHospitalDTO;
import com.exception.MyException;
import com.util.FtlUtils;
import com.util.excel.ImportExcel;
import com.util.session.SessionUtil;

@Controller("PortalIndexController")
@RequestMapping(value = "/")
public class PortalIndexController extends BaseController {
	
	
	@RequestMapping(value = "/xinfeng/index.html", method = RequestMethod.GET)
	public String basicIndex(HttpServletRequest request, ModelMap modelMap){
		modelMap.put("param1", "993933");
		modelMap.put("param2", "江苏省射阳县发宏街27号");
		modelMap.put("param3", "射阳县人民医院");
		System.out.println("xxx");
		return "/index";
	}

	public static void main(String[] args) {
		try {
			String rFolder = "D:\\Develop\\DeveloperEnv\\git\\medical_assistant\\null\\temp\\doc";
			Map<String, List<PrivinceHospitalDTO>> dateMaps = getDatesFromExcel();
			for(String key:dateMaps.keySet()){
				List<PrivinceHospitalDTO> tempDtos = dateMaps.get(key);
				int k = 0;
				for(PrivinceHospitalDTO dto:tempDtos){
					ModelMap modelMap1 = new ModelMap();
					if(dto.getEmailCode().contains(".")){
						modelMap1.put("param1", dto.getEmailCode().substring(0, dto.getEmailCode().indexOf(".")));
					}else{
						modelMap1.put("param1", dto.getEmailCode());
					}
					modelMap1.put("param2", dto.getAddressDetail());
					modelMap1.put("param3", dto.getHospitalName());
					String folderPath = rFolder + "\\" + key;
					//下载报告
					downloadReport(null, modelMap1, folderPath, key + "-" + dto.getAddressDetail() + k + ".doc" ,null);
					k++;
				}
			}
			
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private static Map<String, List<PrivinceHospitalDTO>> getDatesFromExcel() {
		Map<String, List<PrivinceHospitalDTO>> returnMap = new LinkedHashMap<>();
		try {
			for(int i=0;i<27;i++){
//				if(i != 11){
//					continue;
//				}
				ImportExcel excel1 = new ImportExcel("C:\\Users\\qinmp\\Desktop\\新建文件夹\\全国医院地址大全2018\\全国医院地址大全2018.xls", 0, i);
				Integer rowNum = excel1.getDataRowNum();
				Integer lastRowNum = excel1.getLastDataRowNum();
				List<PrivinceHospitalDTO> dtoList = new LinkedList<>();
				String sheetName = excel1.getRow(1).getSheet().getSheetName();
				for(int j=rowNum;j<=lastRowNum;j++){
					Row rrow = excel1.getRow(j);
					Cell cel3 = rrow.getCell(2);
					Double mailCode = null;
					String cell3 = "";
					if(cel3 != null && cel3.getCellType() == cel3.CELL_TYPE_NUMERIC){
						mailCode = cel3.getNumericCellValue();
					}else if(cel3 != null && cel3.getCellType() == cel3.CELL_TYPE_STRING){
						cell3 = cel3.getStringCellValue();
					}
					Cell cel1 = rrow.getCell(0);
					Cell cel2 = rrow.getCell(1);
					if(cel1 == null){
						continue;
					}
					if(cel2 == null){
						continue;
					}
					String cell1 = rrow.getCell(0).toString();
					String cell2 = rrow.getCell(1).toString();
					PrivinceHospitalDTO tempDto = new PrivinceHospitalDTO();
					tempDto.setHospitalName(cell1);
					tempDto.setAddressDetail(cell2);
					tempDto.setEmailCode(mailCode!=null?mailCode.toString():cell3);
					dtoList.add(tempDto);
				}
				returnMap.put(sheetName, dtoList);
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}

	private static void downloadReport(HttpServletRequest request, ModelMap modelMap, String folderPath, String docName, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String docFilePath;
		try {
			docFilePath = FtlUtils.ftlToHtmlToWord(modelMap, folderPath, docName);
			System.out.println(docFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap modelMap) {
		try {
			SessionUtil.updateSession(request);
		} catch (MyException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return "redirect:/user/index.html"; 
	}
}
