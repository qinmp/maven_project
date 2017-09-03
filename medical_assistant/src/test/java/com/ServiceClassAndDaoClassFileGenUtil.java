package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ServiceClassAndDaoClassFileGenUtil {
	
	private static String[] entityClassNameStrArray = new String[]{
		"Account", "Approval","ApprovalAttach","Contact", "ContactGroup","Contract","ContractAttach","ContractEsAccount",
		"ContractExtinfo","ContractTarget","ContractTemplate","Letter","LetterTarget","LoginLog","Mail","MailBak","Msg","MsgBak",
		"MsgTemplate","TempsignFile"
	}; 
	
	private static String[] tempEntityClassNameArray = new String[]{
			"TBirthHistory","TFamilyHistory", "TMarryHistory","TMenstrualHistory","TPersonHistory"
	};
	
	private static String daoPackagePath = "package com.dao;";
	
	private static String baseDaoPackagePath = "import com.dao.BaseDao;";
	
	private static String baseDaoImplPackagePath = "import com.dao.impl.BaseDAOImpl;";
	
	private static String daoImplPackagePath = "package com.dao.impl;";
	
	private static String servicePackagePath = "package com.fdd.service;";
	
	public static String baseServicePackagePath = "import com.service.BaseService;";
	
	public static String baseServiceImplPackagePath = "import com.service.impl.BaseServiceImpl;";
	
	private static String serviceImplPackagePath = "package com.service.impl;";
	
	private static String importEntityPrefixStr = "import com.model.";
	
	private static String importInterfaceDAOPrefixStr = "import com.dao.";

	private static String importInterfaceServicePrefixStr = "import com.service.";
	
	private static String genDaoFilePath = "C://serviceClassAndDaoClassFileDirectory/dao/";
	
	private static String genDaoImplFilePath = "C://serviceClassAndDaoClassFileDirectory/daoimpl/";
	
	private static String genServiceFilePath = "C://serviceClassAndDaoClassFileDirectory/service/";
	
	private static String genServiceImplFilePath = "C://serviceClassAndDaoClassFileDirectory/serviceimpl/";
	
	private static String daoFirstLine = "public interface [daoInterfaceName] extends BaseDAO<[entityName], Long> {";
	
	private static String daoImplFirstLine = "public class [daoImplName] extends BaseDAOImpl<[entityName], Long>  implements [daoIntefaceName]  {";
	
	private static String serviceFirstLine = "public interface [serviceInterfaceName] extends BaseService<[entityName], Long> {";
	
	private static String serviceImplFirstLine = "public class [serviceImplInterfaceName] extends BaseServiceImpl<[entityName], Long>  implements [serviceInterfaceName]  {";
	
	private static String setBaseDaoMethodSig = "public void setBaseDao([daoInterfaceName] [daoInterfaceNameVar]) {";
	private static String setBaseDaoStr = "this.baseDAO = [daoInterfaceNameVar];";
	private static String setBaseDaoMethodEnd = "}";
	
	private static String annotationLibImportStr = "import org.springframework.stereotype.Repository;";
	private static String annotationLibServiceImportStr = "import org.springframework.stereotype.Service;";
	private static String annotationLibResourceImportStr = "import javax.annotation.Resource;";
	private static String repositoryAnnotationStr = "@Repository";
	private static String serviceAnnotationStr = "@Service";
	private static String resourceAnnotationStr = "@Resource";
	
	private static String secondLine = "}";
	
	//填充dao文件
	public static void fillDaoFile(File file, String entityName) throws IOException{
		LinkedList<String> list = new LinkedList<String>();
		String daoIntefaceName = entityName + "DAO";
		String firstLineStr = ServiceClassAndDaoClassFileGenUtil.daoFirstLine.replace("[daoInterfaceName]", daoIntefaceName);
		firstLineStr = firstLineStr.replace("[entityName]", entityName);
		list.add(ServiceClassAndDaoClassFileGenUtil.daoPackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.baseDaoPackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.importEntityPrefixStr + entityName + ";");
		list.add(firstLineStr);
		list.add(ServiceClassAndDaoClassFileGenUtil.secondLine);
		FileWriter out = new FileWriter(file);
		for(String str:list ){
			out.write(str);
			out.write("\r\n");
			out.flush();
		}
		out.close();
	}
	
	//填充service文件
	public static void fillServiceFile(File file, String entityName) throws IOException{
		LinkedList<String> list = new LinkedList<String>();
		String serviceIntefaceName = entityName + "Service";
		String firstLineStr = ServiceClassAndDaoClassFileGenUtil.serviceFirstLine.replace("[serviceInterfaceName]", serviceIntefaceName);
		firstLineStr = firstLineStr.replace("[entityName]", entityName);
		list.add(ServiceClassAndDaoClassFileGenUtil.servicePackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.baseServicePackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.importEntityPrefixStr + entityName + ";");
		list.add(firstLineStr);
		list.add(ServiceClassAndDaoClassFileGenUtil.secondLine);
		FileWriter out = new FileWriter(file);
		for(String str:list ){
			out.write(str);
			out.write("\r\n");
			out.flush();
		}
		out.close();
	}
	
	//填充serviceImpl文件
		public static void fillServiceImplFile(File file, String entityName) throws IOException{
			LinkedList<String> list = new LinkedList<String>();
			String serviceImplName = entityName + "ServiceImpl";
			String serviceInterfaceName = entityName + "Service";
			String daoInterfaceName = entityName + "DAO";
			String firstLineStr = ServiceClassAndDaoClassFileGenUtil.serviceImplFirstLine.replace("[serviceImplInterfaceName]", serviceImplName);
			firstLineStr = firstLineStr.replace("[entityName]", entityName);
			firstLineStr = firstLineStr.replace("[serviceInterfaceName]", serviceInterfaceName);
			list.add(ServiceClassAndDaoClassFileGenUtil.serviceImplPackagePath);
			list.add(ServiceClassAndDaoClassFileGenUtil.baseServiceImplPackagePath);
			list.add(ServiceClassAndDaoClassFileGenUtil.annotationLibServiceImportStr);
			list.add(ServiceClassAndDaoClassFileGenUtil.annotationLibResourceImportStr);
			list.add(ServiceClassAndDaoClassFileGenUtil.importInterfaceServicePrefixStr + serviceInterfaceName + ";");
			list.add(ServiceClassAndDaoClassFileGenUtil.importEntityPrefixStr + entityName + ";");
			list.add(ServiceClassAndDaoClassFileGenUtil.importInterfaceDAOPrefixStr + daoInterfaceName + ";");
			list.add(ServiceClassAndDaoClassFileGenUtil.serviceAnnotationStr);
			list.add(firstLineStr);
			list.add("");
			list.add("    " + ServiceClassAndDaoClassFileGenUtil.resourceAnnotationStr);
			String sig = ServiceClassAndDaoClassFileGenUtil.setBaseDaoMethodSig;
			String setVar = Character.toLowerCase((daoInterfaceName.charAt(0))) + daoInterfaceName.substring(1);
			sig = sig.replace("[daoInterfaceName]", daoInterfaceName);
			sig = sig.replace("[daoInterfaceNameVar]", setVar);
			list.add("    " + sig);
			list.add("        " + ServiceClassAndDaoClassFileGenUtil.setBaseDaoStr.replace("[daoInterfaceNameVar]", setVar));
			list.add("    " + ServiceClassAndDaoClassFileGenUtil.setBaseDaoMethodEnd);
			list.add("");
			list.add(ServiceClassAndDaoClassFileGenUtil.secondLine);
			FileWriter out = new FileWriter(file);
			for(String str:list ){
				out.write(str);
				out.write("\r\n");
				out.flush();
			}
			out.close();
		}
	
	//填充daoImpl文件
	public static void fillDaoImplFile(File file, String entityName) throws IOException{
		LinkedList<String> list = new LinkedList<String>();
		String daoImplName = entityName + "DAOImpl";
		String daoInterfaceName = entityName + "DAO";
		String firstLineStr = ServiceClassAndDaoClassFileGenUtil.daoImplFirstLine.replace("[daoImplName]", daoImplName);
		firstLineStr = firstLineStr.replace("[entityName]", entityName);
		firstLineStr = firstLineStr.replace("[daoIntefaceName]", daoInterfaceName);
		list.add(ServiceClassAndDaoClassFileGenUtil.daoImplPackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.baseDaoImplPackagePath);
		list.add(ServiceClassAndDaoClassFileGenUtil.annotationLibImportStr);
		
		list.add(ServiceClassAndDaoClassFileGenUtil.importInterfaceDAOPrefixStr + daoInterfaceName + ";");
		list.add(ServiceClassAndDaoClassFileGenUtil.importEntityPrefixStr + entityName + ";");
		list.add(ServiceClassAndDaoClassFileGenUtil.repositoryAnnotationStr);
		list.add(firstLineStr);
		list.add(ServiceClassAndDaoClassFileGenUtil.secondLine);
		FileWriter out = new FileWriter(file);
		for(String str:list ){
			out.write(str);
			out.write("\r\n");
			out.flush();
		}
		out.close();
	}
	
	public static File getEmptyJavaFileByName(String fileType, String fileName, String extension) throws IOException{
		String genFilePath = "";
		if("dao".equals(fileType)){
			File daoFoder = new File(genDaoFilePath);
			if(!daoFoder.exists()){
				daoFoder.mkdirs();
			}
			genFilePath = genDaoFilePath + fileName + extension;
		} else if("daoimpl".equals(fileType)){
			File daoFoder = new File(genDaoImplFilePath);
			if(!daoFoder.exists()){
				daoFoder.mkdirs();
			}
			genFilePath = genDaoImplFilePath + fileName + extension;
		} else if("service".equals(fileType)){
			File daoFoder = new File(genServiceFilePath);
			if(!daoFoder.exists()){
				daoFoder.mkdirs();
			}
			genFilePath = genServiceFilePath + fileName + extension;
		} else if("serviceimpl".equals(fileType)){
			File daoFoder = new File(genServiceImplFilePath);
			if(!daoFoder.exists()){
				daoFoder.mkdirs();
			}
			genFilePath = genServiceImplFilePath + fileName + extension;
		}
		File file = new File(genFilePath);
		if(!file.exists()){
			file.createNewFile();
		}
		return file;
	}
	
	public static void main(String[] args){
		try {
			for (int i = 0; i < entityClassNameStrArray.length; i++) {
				File file = getEmptyJavaFileByName("daoimpl" ,entityClassNameStrArray[i] + "DAOImpl", ".java");
				File file2 = getEmptyJavaFileByName("dao" ,entityClassNameStrArray[i] + "DAO", ".java");
				fillDaoImplFile(file, entityClassNameStrArray[i]);
				fillDaoFile(file2, entityClassNameStrArray[i]);
				File file3 = getEmptyJavaFileByName("serviceimpl" ,entityClassNameStrArray[i] + "ServiceImpl", ".java");
				File file4 = getEmptyJavaFileByName("service" ,entityClassNameStrArray[i] + "Service", ".java");
				fillServiceImplFile(file3, entityClassNameStrArray[i]);
				fillServiceFile(file4, entityClassNameStrArray[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
