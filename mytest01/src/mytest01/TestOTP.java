package mytest01;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestOTP {
	@Test
	public void test1() {

	}

	/**
	 * @param request
	 * @param sTime
	 *            手机验证码,有效时间,单位为s
	 * @return 校验是否通过,通过发送验证码,不通过不发送
	 */
	public boolean timeValidator(HttpServletRequest request, String sTime) {
		final String OTP_TIME = "OTP_TIME";
		boolean flag = true;// 是否校验通过
		if (StringUtils.isBlank(sTime)) {// 为空通过校验,不控制
			return flag;
		}
		long currentTimeInMillions = System.currentTimeMillis();
		String preTimeInMillions = (String) request.getSession().getAttribute(OTP_TIME);
		// 第一次或者过期了,重新设置,校验通过
		if (preTimeInMillions == null
				|| ((currentTimeInMillions - Long.parseLong(preTimeInMillions)) / 1000)>Long.parseLong(sTime)) {
			request.setAttribute(OTP_TIME, currentTimeInMillions + "");
		} else {
			flag = false;// session上一次时间有,且间隔小于sTime,校验不通过
		}
		return flag;
	}
}
