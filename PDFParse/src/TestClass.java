import java.io.File;

public class TestClass {
	static String personFilePath = "C:\\Users\\qinmp\\Desktop\\wordfile\\name-txt\\";
	public static void main(String[] args) {
		File dealFolder = new File("C:\\Users\\qinmp\\Desktop\\大卡体重数据\\产检大卡1-txt\\1-12A.txt");
		String aa = "23 56.00kg";
		System.out.println(dealFolder.getName());
	}
}
