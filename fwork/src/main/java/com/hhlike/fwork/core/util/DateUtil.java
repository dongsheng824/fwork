package com.hhlike.fwork.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS_ORACLE = "yyyymmddHH24miss";
    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyyMMddHH";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYY = "yyyy";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHHMM = "yyyy/MM/dd HH:mm";
    public static final String DATE_FORMAT_EN_A_YYYYMMDDHH = "yyyy/MM/dd HH";
    public static final String DATE_FORMAT_EN_A_YYYYMMDD = "yyyy/MM/dd";
    public static final String DATE_FORMAT_EN_A_YYYYMM = "yyyy/MM";
    public static final String DATE_FORMAT_EN_A_YYYY = "yyyy";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_EN_B_YYYYMMDDHH = "yyyy-MM-dd HH";
    public static final String DATE_FORMAT_EN_B_YYYYMMDD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_EN_B_YYYYMM = "yyyy-MM";
    public static final String DATE_FORMAT_EN_B_YYYY = "yyyy";
    public static final String DATE_FORMAT_CN_YYYYMMDDHHMMSS = "yyyy'年'MM'月'dd'日' HH'时'mm'分'ss'秒'";
    public static final String DATE_FORMAT_CN_YYYYMMDDHHMM = "yyyy'年'MM'月'dd'日' HH'时'mm'分'";
    public static final String DATE_FORMAT_CN_YYYYMMDDHH = "yyyy'年'MM'月'dd'日' HH'时'";
    public static final String DATE_FORMAT_CN_YYYYMMDD = "yyyy'年'MM'月'dd'日'";
    public static final String DATE_FORMAT_CN_YYYYMM = "yyyy'年'MM'月'";
    public static final String DATE_FORMAT_CN_YYYY = "yyyy'年'";
    
    /**
     * 增加获取当前时间的方法，统一使用该接口方便以后转换实现方式
     * 
     * @return
     */
    public static Date now()
    {
        return new Date();
    }
    /**
     * 得到当前日期字符串,根据传入的格式返回
     * 
     * @return
     */
    public static String nowStr(String format)
    {
        Date date = now();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    /**
     * 得到当前日期字符串,yyyymmdd格式
     * 
     * @return
     */
    public static String now8()
    {
        Date date = now();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        return formatter.format(date);
    }
    /**
     * 得到当前日期字符串,yyyy-mm-dd格式
     * 
     * @return
     */
    public static String now10()
    {
        Date date = now();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EN_B_YYYYMMDD);
        return formatter.format(date);
    }
    /**
     * 得到当前日期字符串,yyyymmddhhmmss格式
     * 
     * @return
     */
    public static String now14()
    {
        Date date = now();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMMSS);
        return formatter.format(date);
    }
    /**
     * 得到当前日期字符串,yyyy-mm-dd hh:mm:ss
     * 
     * @return
     */
    public static String now19()
    {
        Date date = now();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_EN_B_YYYYMMDDHHMMSS);
        return formatter.format(date);
    }

    /**
     * 根据一个日期字符串，及其对应的格式，解析成日期对象
     * @param dateStr 日期
     * @param format 模式
     * @return java型的日期
     */
    public static Date parseDate(String dateStr, String format) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try{
            return sdf.parse(dateStr);
        }
        catch (ParseException pe){
            throw new Exception(pe.getMessage());
        }
    }
    
    /**
     * 根据一个日期字符串，自动判别其格式，解析成日期对象。
     * 如果能知道日期格式，最好用parseDate(String dateStr, String format)，自动判别格式会有性能损耗
     * @param strDate 需要进行格式化的日期
     * @return 经过格式化后的字符串
     * @throws Exception
     */
    public static Date parseDate(String strDate) throws Exception
    {
        String formatStr = "yyyyMMdd";
        if (strDate == null || strDate.trim().equals(""))
        {
            return null;
        }
        switch (strDate.trim().length())
        {
        case 6:
            if (strDate.substring(0, 1).equals("0"))
            {
                formatStr = "yyMMdd";
            }
            else
            {
                formatStr = "yyyyMM";
            }
            break;
        case 8:
            formatStr = "yyyyMMdd";
            break;
        case 10:
            if (strDate.indexOf("-") == -1)
            {
                formatStr = "yyyy/MM/dd";
            }
            else
            {
                formatStr = "yyyy-MM-dd";
            }
            break;
        case 11:
            if (strDate.getBytes().length == 14)
            {
                formatStr = "yyyy年MM月dd日";
            }
            else
            {
                return null;
            }
        case 14:
            formatStr = "yyyyMMddHHmmss";
            break;
        case 19:
            if (strDate.indexOf("-") == -1)
            {
                formatStr = "yyyy/MM/dd HH:mm:ss";
            }
            else
            {
                formatStr = "yyyy-MM-dd HH:mm:ss";
            }
            break;
        default:
            throw new Exception("invalid date format : " + strDate);
        }
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
            return formatter.parse(strDate);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 把日期对象格式化成指定格式的字符串
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String formatStr) throws Exception
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            return sdf.format(date);
        }
        catch (Exception ex)
        {
            throw new Exception("fail to format date : [date=" + date + ";format=" + formatStr + "]");
        }
    }
    

    
    /**
     * 获取年份数，比如2014-12-13，则返回2014
     * @param date
     * @return
     */
    public static int getYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    /**
     * 获取月份数，比如2014-12-13，则返回12
     * @param date
     * @return
     */
    public static int getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH)+1;//月份数是从0开始的，因此要加1
    }
    /**
     * 获取月份中的日期数，比如2014-12-13，则返回13
     * @param date
     * @return
     */
    public static int getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取一周中的日期数，比如2014-12-13（周六），则返回6
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int val = cal.get(Calendar.DAY_OF_WEEK);//一周中的日期是从周日开始的，周日是1，周一是2
        return val == 1 ? 7 : val-1;
    }
    /**
     * 返回指定日期所在月的第一天的日期，即当前月1号
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    /**
     * 返回指定日期所在周的第一天的日期，即周一的日期
     * @param date
     * @return
     */
    public static Date getFirstDateOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        return cal.getTime();
    }
    
    /**
     * 获取一年中的日期数，比如2014-12-13（2014年中的第347天），则返回347
     * @param date
     * @return
     */
    public static int getDayOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }
    
    public static void main(String[] args) {
    	Date date = new Date();
    	System.out.println("getYear : "+getYear(date));
    	System.out.println("getMonth : "+getMonth(date));
    	System.out.println("getDay : "+getDay(date));
    	System.out.println("getDayOfWeek : "+getDayOfWeek(date));
    	System.out.println("getDayOfYear : "+getDayOfYear(date));
    	
	}
    
    public static Date getDateEnd(Date date){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return  cal.getTime();
    }
    public static Date getDateBegin(Date date){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }
    
    
    /**
     * 秒钟偏移数。
     * 比如获取某个日期往后7秒钟，可以采用offsetSecond(date,7);
     * 比如获取某个日期往前7秒钟，可以采用offsetSecond(date,-7);
     * @param date
     * @param days
     * @return
     */
    public static Date offsetSecond(Date date,int seconds){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        return  cal.getTime();
    }
    /**
     * 分钟偏移数。
     * 比如获取某个日期往后7分钟，可以采用offsetMinute(date,7);
     * 比如获取某个日期往前7分钟，可以采用offsetMinute(date,-7);
     * @param date
     * @param days
     * @return
     */
    public static Date offsetMinute(Date date,int minutes){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return  cal.getTime();
    }
    /**
     * 小时偏移数。
     * 比如获取某个日期往后7小时，可以采用offsetHour(date,7);
     * 比如获取某个日期往前7小时，可以采用offsetHour(date,-7);
     * @param date
     * @param days
     * @return
     */
    public static Date offsetHour(Date date,int hours){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return  cal.getTime();
    }
    /**
     * 日期偏移天数。
     * 比如获取某个日期往后7天，可以采用offsetDate(date,7);
     * 比如获取某个日期往前7天，可以采用offsetDate(date,-7);
     * @param date
     * @param days
     * @return
     */
    public static Date offsetDate(Date date,int days){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return  cal.getTime();
    }
    
    /**
     * 日期偏移天数。
     * 比如获取某个日期往后7天，可以采用offsetDate(date,7);
     * 比如获取某个日期往前7天，可以采用offsetDate(date,-7);
     * @param date
     * @param days
     * @return
     */
    public static Date offsetYear(Date date,int years){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return  cal.getTime();
    }
    
    public static Date offsetMonth(Date date,int months){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return  cal.getTime();
    }
    
    public static String toYearMonth(Date date){
    	DateFormat fd = new SimpleDateFormat("yyyyMM");
    	return fd.format(date);
    };
}
