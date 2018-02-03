package cn.itheima.ssm.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		// 1.定义格式化对象 xxx-xx-xx xx:xx:xx 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			// 转换成功的时候
			return format.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 失败返回null
		return null;
	}

}
