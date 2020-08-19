package com.cssceg.springjpademo.utils;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class NumberUtils  {
    /**
     * 判断当前值是否为数字(包括小数)
     * @param value
     * @return
     */
    public static boolean isDigit(Object value) {
        if (StringUtils.isEmpty(String.valueOf(value))) {
            return false;
        }
        String mstr = String.valueOf(value);
        Pattern pattern = Pattern.compile("^-?[0-9]*.?[0-9]*{1}");
        return pattern.matcher(mstr).matches();
    }

    /**
     * 将数字格式化输出
     *
     * @param value
     *            需要格式化的值
     * @param precision
     *            精度(小数点后的位数)
     * @return
     */
    public static Double formatDouble(Object value, Integer precision) {
        Double number = 0.0;
        if (NumberUtils.isDigit(value)) {
            number = new Double(value.toString());
        }
        precision = (precision == null || precision < 0) ? 2 : precision;
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(precision, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
}
