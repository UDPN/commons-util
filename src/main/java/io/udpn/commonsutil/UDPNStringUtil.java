// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)
package io.udpn.commonsutil;

import java.math.BigDecimal;

/**
* String utility class
* @author yf
* @Date: 2021/9/29
* @version 1.0.0
*
* @history date, modifier,and description
**/
public class UDPNStringUtil {

    /**
     * Checks if the string is null
     *
     * @date 2021/9/29
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        return str == null || str.trim().length() == 0;
    }


    /**
     * Checks if the string is not null
     *
     * @date 2021/9/29
     * @param str
     * @return boolean
     */
    public static boolean isNotNull(String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * Checks if the string is numeric and alphabetic
     *
     * @date 2021/9/29
     * @param str
     * @return boolean
     */
    public static boolean isNumberOrCharacter(String str) {
        String regex =  "^[0-9A-Za-z]+$";
        return str.matches(regex) ;
    }

    public static boolean isServiceFee(BigDecimal value) {
        final String str = value.stripTrailingZeros().toPlainString();
        final int index = str.indexOf('.');
        if (index < 0 && str.length() > 18) {
            return false;
        }else if(index > 0) {
            if (index > 18 || (str.length()-index-1) > 18) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAmount(BigDecimal value) {
        final String str = value.stripTrailingZeros().toPlainString();
        final int index = str.indexOf('.');
        if (index < 0 && str.length() > 32) {
            return false;
        }else if(index > 0) {
            if (index > 32 || (str.length()-index-1) > 18) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAmount(BigDecimal value,int currencyPrecision) {
        final String str = value.stripTrailingZeros().toPlainString();
        final int index = str.indexOf('.');
        if (index < 0 && str.length() > 32) {
            return false;
        }else if(index > 0) {
            if (index > 32 || (str.length()-index-1) > currencyPrecision) {
                return false;
            }
        }
        return true;
    }


    /**
     * Get precision
     *
     * @date 2022/4/28
     * @param bd
     * @return int
     */
    public static int getPrecision(BigDecimal bd){
        int precision = 0;
        String textBD = bd.toPlainString();
        int radixLoc = textBD.indexOf('.');
        if(radixLoc > 0) {
            precision = textBD.substring(radixLoc + 1).length();
        }
        return precision;
    }

}
