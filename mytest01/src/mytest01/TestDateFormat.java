package mytest01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDateFormat {
	/**
	 * 比较当前时间是否在有效期内,注意是包头包尾 
	 * 注意:
	 * 	1. 2017-05-01转换成毫秒时取的是2017-05-01 00:00:00
	 *  2. 2017-05-01 00:00:00至2017-05-01 23:59:59全天转换成yyyy-MM-dd都是2017-05-01	
	 *  但一般有效期包含beginDate全天和endDate全天
	 * @throws ParseException
	 */
	@Test
	public void test1() throws ParseException {
		String beginDate = "2017-05-01";
		String endDate = "2017-05-02";
		System.out.println(checkDate1(beginDate, endDate));
		System.out.println(checkDate2(beginDate, endDate));

	}

	public boolean checkDate1(String beginDate, String endDate) throws ParseException {
		boolean flag = false;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// new Date()带有时分秒的当前时间,转换成yyyy-MM-dd截取掉了时分秒, 这样2017-05-03就能表示全天
		String now = format.format(new Date());
		// 转换为统一格式的Date对象
		Date date1 = format.parse(beginDate);// 2017-05-01
		Date date2 = format.parse(endDate);// 2021-03-21
		Date nowDate = format.parse(now);// 2017-05-03
		// 比较方式1,用Date的before和after方法,不包含相等的情况
		if (nowDate.before(date1) || nowDate.after(date2)) {
			// 在有效期之外,处理1
		} else {
			// 有效期之内,处理2
			flag = true;
		}
		return flag;
	}

	public boolean checkDate2(String beginDate, String endDate) throws ParseException {
		boolean flag = false;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// new Date()带有时分秒的当前时间,转换成yyyy-MM-dd截取掉了时分秒, 这样2017-05-03就能表示全天
		String now = format.format(new Date());
		// 转换为统一格式的Date对象
		Date date1 = format.parse(beginDate);// 2017-05-01
		Date date2 = format.parse(endDate);// 2021-03-21
		Date nowDate = format.parse(now);// 2017-05-03
		// 比较方式2,用Date的CompareTo方法,只返回0,1,-1
		if (nowDate.compareTo(date1) >= 0 && nowDate.compareTo(date2) <= 0) {
			// 有效期之内,处理2
			flag = true;
		} else {
			// 有效期之外,处理1
		}
		return flag;
	}

	@Test
	public void test2() {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(format1.format(new Date()));
		System.out.println(format2.format(new Date()));
	}

}
