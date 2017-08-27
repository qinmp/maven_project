package com.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @Description:日期处理函数
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016-3-16
 * @author jcf
 * @vesion 2.0
 */
public class DateUtil {

	public static String DEFAULT_PATTERN_YYMMMMDD = "yyyy-MM-dd";
	public static String DEFAULT_PATTERN_YYYY年MM月DD="yyyy年MM月dd日";
	/**
	 * @Description: 计算两日期相差的天数
	 * @Create: 2012-12-21 下午3:45:44
	 * @author jcf
	 * @update logs
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		long intervalMilli = oDate.getTime() - fDate.getTime();
		int distDay = (int) (intervalMilli / (24 * 60 * 60 * 1000));
		return distDay;
	}

	/**
	 * @Description: 计算两日期相差的分钟数
	 * @Create: 2014-9-28 下午10:39:33
	 * @author jcf
	 * @update logs
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static long minutesOfTwo(Date oDate, java.sql.Timestamp fDate) {
		long intervalMilli = oDate.getTime() - fDate.getTime();
		long minutes = intervalMilli / (60 * 1000);
		return minutes;
	}

	/**
	 * @Description: 按pattern格式化输出Date
	 * @Create: 2012-12-21 下午3:53:48
	 * @author jcf
	 * @update logs
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * @Description: 日期按yyyy-MM-dd格式化
	 * @Create: 2012-12-21 下午3:55:39
	 * @author jcf
	 * @update logs
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}

	/**
	 * @Description: 将类型是pattern的日期字符串转化成Date型数据
	 * @Create: 2013-1-14 下午11:58:24
	 * @author jcf
	 * @update logs
	 * @param pattern
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String pattern, String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description:将类型是yyyy-MM-dd的日期字符串转化成Date型数据
	 * @Create: 2013-1-14 下午11:59:34
	 * @author jcf
	 * @update logs
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String dateString) {
		return toDate("yyyy-MM-dd", dateString);
	}

	/**
	 * @Description:将类型是yyyy-MM-dd的日期字符串转化成java.sql.Date型数据
	 * @Create: 2013-1-14 下午11:59:34
	 * @author jcf
	 * @update logs
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Date toSqlDate(String dateString) throws ParseException {
		return toSqlDate("yyyy-MM-dd", dateString);
	}

	/**
	 * @Description:将类型是pattern的日期字符串转化成java.sql.Date型数据
	 * @Create: 2013-1-14 下午11:59:34
	 * @author jcf
	 * @update logs
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Date toSqlDate(String pattern, String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = sdf.parse(dateString);
		return new java.sql.Date(date.getTime());
	}

	/**
	 * @Description: 取得当前时间的Timestamp
	 * @Created Time: 2013-4-16 下午4:40:59
	 * @Author jcf
	 * @return
	 */
	public static Timestamp getNowTimestamp() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * @Description: 取得当前时间的Timestamp,由于SqlServer 时间的精度为1/300秒 将 datetime 值舍入到
	 *               .000、.003、或 .007 秒的增量
	 *               http://www.fengfly.com/plus/view-172343-1.html
	 * @Created Time: 2013-4-16 下午4:40:59
	 * @Author jcf
	 * @return
	 */
	public static Timestamp getNowTimestampSqlServer() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = Calendar.getInstance().getTime();
		try {
			return new Timestamp(df.parse(df.format(now)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description: 取得当前时间的Timestamp,由于SqlServer 时间的精度为1/300秒 将 datetime 值舍入到
	 *               .000、.003、或 .007 秒的增量
	 *               http://www.fengfly.com/plus/view-172343-1.html
	 * @Created Time: 2013-4-16 下午4:40:59
	 * @Author jcf
	 * @return
	 */
	public static String getNowTimestampSqlServerStr() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = Calendar.getInstance().getTime();
		return df.format(now);
	}

	/**
	 * @Description: 计算n小时后的时间
	 * @Create: 2014-1-22 下午03:07:56
	 * @author jcf
	 * @update logs
	 * @param n
	 * @return
	 */
	public static Timestamp getNTimestampSqlServer(int n) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + n);
		Date now = calendar.getTime();
		try {
			return new Timestamp(df.parse(df.format(now)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description: 取得当前时间的Date
	 * @Created: 2013-8-18 下午5:46:52
	 * @Author jcf
	 * @return
	 */
	public static Date getNowDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * @Description: 取得当前时间的SqlDate
	 * @Created: 2013-8-18 下午5:46:52
	 * @Author jcf
	 * @return
	 */
	public static java.sql.Date getNowSqlDate() {
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * @Description: 日期加一天
	 * @Create: 2013-10-9 下午02:22:25
	 * @author jcf
	 * @update logs
	 * @param s
	 * @param n
	 * @return
	 */
	public static Date addDay(Date d, int n) {
		try {
			Calendar cd = Calendar.getInstance();
			cd.setTime(d);
			cd.add(Calendar.DATE, n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return cd.getTime();

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <b>概要：</b> 获取minute分钟后日期 <b>作者：</b>SUXH </br> <b>日期：</b>2015-3-31 </br>
	 * 
	 * @param minute
	 *            多少分钟后
	 * @return 多少分钟后的日期
	 */
	public static Date getDate4Minute(int minute) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MINUTE, minute);
		Date dd = c.getTime();
		return dd;
	}

	public static java.sql.Timestamp str2TimeStamp(String strDate) {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
		Timestamp ts = Timestamp.valueOf(strDate);
		return ts;
	}

	public static boolean isInTimeSecond(Date startdate, Date enddate, int second) {
		long start = startdate.getTime();
		long end = enddate.getTime();
		long pass = end - start;
		long passminute = pass / 1000;
		if (passminute > second)
			return false;
		else
			return true;
	}
	
	/**
     * 根据传入的模式参数返回当天的日期
     * @param pattern 传入的模式
     * @return 按传入的模式返回一个字符串
     */
    public static String getToday ( String pattern )
    {
        Date date = new Date () ;
        SimpleDateFormat sdf = new SimpleDateFormat ( pattern ) ;
        return sdf.format ( date ) ;
    }
    
    /**
     * <b>概要：</b>
     * 	获取date中前或后nDay天的日期
     * <b>作者：</b>SUXH </br>
     * <b>日期：</b>2015-5-20 </br>
     * @param date 开始日期
     * @param nDay 天数
     * @param type 正为后nDay天的日期，否则为前nDay天的日期。
     * @return  前或后nDay天的日期
     */
    private static Date getDate(Date date, int nDay, int type){
        long millisecond = date.getTime(); //从1970年1月1日00:00:00开始算起所经过的微秒数
        long msel = nDay * 24 * 3600 * 1000l; //获取nDay天总的毫秒数
        millisecond = millisecond + ((type > 0) ? msel : (-msel));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millisecond);
        return calendar.getTime();
    }
	
    /**
     * <b>概要：</b>
     * 	获取n天后的日期
     * <b>作者：</b>SUXH </br>
     * <b>日期：</b>2015-3-14 </br>
     * @param date 选取起始的日期
     * @param nDay 间隔天数
     * @param format 日期格式字符串
     * @return n天后的日期
     */
    public static Date dateAfterNDate(Date date, int nDay,String format){
        return getDate(date, nDay, 1);
    }
    
    /**
     * 用途：以指定的格式格式化日期字符串
     * @param pattern 字符串的格式
     * @param currentDate 被格式化日期
     * @return String 已格式化的日期字符串
     * @throws NullPointerException 如果参数为空
     */
    public static String formatDate ( Date currentDate , String pattern ) {
        SimpleDateFormat sdf = new SimpleDateFormat ( pattern ) ;
        return sdf.format ( currentDate ) ;
    }
    
    /**
     * <b>概要：</b>
     *  将指定格式的时间String转为Date类型
     * <b>作者：</b>SUXH </br>
     * <b>日期：</b>2015-5-20 </br>
     * @param dateStr 待转换的时间String
     * @param pattern 转换的类型
     * @return 字符串转换成Date类型数据
     */
    public static Date convertStringToDate ( String dateStr , String pattern ){
        if ( dateStr == null ){
            return null ;
        }
        SimpleDateFormat sdf = new SimpleDateFormat ( pattern ) ;
        Date date=null;
        try {
			date= sdf.parse ( dateStr ) ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date;
    }
    
	public static void main(String[] args) {
//		System.out.println(DateUtil.dateToString(DateUtil.addDay(new Date(), -10)));
//		System.out.println(toDate(getToday("yyyy-MM-dd")));
		
//		MemCached cache = MemCached.getInstance();
//		cache.delete("helloqinmp");
//		cache.add("helloqinmp", "aaaa");
//		System.out.println(cache.get("helloqinmp"));
//		System.out.println(cache.add("helloqinmp", "bbbb"));
//		System.out.println(cache.get("helloqinmp"));
//		System.out.println(cache.add("helloqinmp", "cccx"));
//		System.out.println(cache.get("helloqinmp"));
//		cache.delete("helloqinmp");
//		System.out.println(cache.add("helloqinmp", "dddd"));
//		System.out.println(cache.get("helloqinmp"));
	}
}
