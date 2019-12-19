package cn.edu.zjut.convert;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 王凌云
 * ognl表达式对字符串和 date 类型之间的转换
 */
public class DateConvert extends StrutsTypeConverter {
    private SimpleDateFormat[] formats = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy:MM:dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy:MM:dd HH:mm:ss"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    /*
     * 将字符串类型转化成日期类型
     */
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        //获取日期的字符串
        String dateStr=strings[0];
        //遍历日期支持格式，进行转换
        for (SimpleDateFormat format: formats) {
            try {
                return format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //如果遍历完毕后仍没有转换成功，表示出现转换异常
        throw new TypeConversionException();
    }

    /*
     * 将日期类型转化成字符串类型
     */
    @Override
    public String convertToString(Map map, Object o) {
        Date date=(Date) o;
        return formats[0].format(date);
    }
}
