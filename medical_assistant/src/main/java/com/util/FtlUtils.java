package com.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.util.string.MyStringUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FtlUtils {
	
	private static String FtlPath = "D:\\Develop\\DeveloperEnv\\git\\medical_assistant\\src\\main\\java\\com\\report\\template";
	private static String FtlFileName = "自助小诊所设计 -病史录.ftl";
	private static String ENCODER = "UTF-8";
	private static final String tempPath = System.getProperty("catalina.home") + File.separator + "temp" + File.separator;
	public static void main(String[] args) throws Exception{
//      HashMap<String,Object> map = new HashMap<String, Object>();  
//      BasicInfo info = new BasicInfo();
//      info.setAge("20");
//      info.setCreateTime(DateUtil.getNowTimestamp());
//      info.setName("qinmp");
//      info.setNativePlace("guangxi");
//      info.setPresentResidence("shenzhen");
//      info.setRealBirthDay(DateUtil.getNowTimestamp());
//      info.setSerialNo("sfasdfsadfa");
//      info.setSex(1);
//      info.setUpdateTime(DateUtil.getNowTimestamp());
//      map.put("basicInfo", info); 
//      ftlToHtmlToWord(map);  
	}

	@SuppressWarnings("deprecation")
	public static String ftlToHtmlToWord(HashMap<String, Object> map) throws Exception {
		 Configuration configuration = new Configuration();
         configuration.setDirectoryForTemplateLoading(new File(FtlPath));  
         configuration.setDefaultEncoding("UTF-8");  
         // 获取或创建一个模版。    
         Template template = configuration.getTemplate(FtlFileName);  
         
         // 获取或创建一个模版。    
         // 获取html静态页面文件  
         //设置文件输入流编码，不然生成的html文件会中文乱码  
         String htmlFolderPath = tempPath + "html" + File.separator;
         File htmlFolderFile = new File(htmlFolderPath);
         if(!htmlFolderFile.exists()){
        	 htmlFolderFile.mkdirs();
         }
         String htmlFilePath = htmlFolderPath + getTempHtmlFileName();;
         File htmlFile = new File(htmlFilePath);
         if(!htmlFile.exists()){
        	 htmlFile.createNewFile();
         }
         FileWriterWithEncoding out = new FileWriterWithEncoding(htmlFilePath, ENCODER);  
         // 将页面中要展示的数据放入一个map中  
         //将map中的数据输入到index.ftl这个模板文件中并遍历出来，最后再将整个模板的数据写入到index.html中。  
         template.process(map, out);
         out.close();
         String docFilePath = htmlToWord2(htmlFilePath);
         if(htmlFile.exists()){
        	 htmlFile.delete();
         }
         return docFilePath;
	}
	
	private static String getTempHtmlFileName() {
		// TODO Auto-generated method stub
		return "temp-" + System.currentTimeMillis() + "-" + MyStringUtil.gen4RandomNumber() + ".html";
	}

	public static String htmlToWord2(String htmlFilePath) throws Exception { 
	    InputStream bodyIs = new FileInputStream(htmlFilePath);  
	    String body = getContent(bodyIs);  
	    bodyIs.close();
	    //拼一个标准的HTML格式文档  
	    InputStream is = new ByteArrayInputStream(body.getBytes("GBK"));
	    
	    String docFolderPath = tempPath + "doc" + File.separator;
        File docFolderFile = new File(docFolderPath);
        if(!docFolderFile.exists()){
        	docFolderFile.mkdirs();
        }
        String docFilePath = docFolderPath + getTempDocFileName();;
        File docFile = new File(docFilePath);
        if(!docFile.exists()){
        	docFile.createNewFile();
        }
	    OutputStream os = new FileOutputStream(docFile);  
	    inputStreamToWord(is, os);  
	    return docFilePath;
	}  
	
	private static String getTempDocFileName() {
		// TODO Auto-generated method stub
		return "temp-" + System.currentTimeMillis() + "-" + MyStringUtil.gen4RandomNumber() + ".doc";
	}

	/** 
	* 把is写入到对应的word输出流os中 
	* 不考虑异常的捕获，直接抛出 
	* @param is 
	* @param os 
	* @throws IOException 
	*/  
	@SuppressWarnings("resource")
	private static void inputStreamToWord(InputStream is, OutputStream os) throws IOException {  
	    POIFSFileSystem fs = new POIFSFileSystem();  
	    //对应于org.apache.poi.hdf.extractor.WordDocument  
	    fs.createDocument(is, "WordDocument");  
	    fs.writeFilesystem(os);  
	    os.close();  
	    is.close();  
	}  
	  
	/** 
	* 把输入流里面的内容以UTF-8编码当文本取出。 
	* 不考虑异常，直接抛出 
	* @param ises 
	* @return 
	* @throws IOException 
	*/  
	private static String getContent(InputStream... ises) throws IOException {  
	    if (ises != null) {  
	        StringBuilder result = new StringBuilder();  
	        BufferedReader br;  
	        String line;  
	        for (InputStream is : ises) {  
	            br = new BufferedReader(new InputStreamReader(is, ENCODER));  
	            while ((line=br.readLine()) != null) {  
	                result.append(line);  
	            }  
	        }  
	        return result.toString();  
	    }  
	    return null;  
	}  
	
}
