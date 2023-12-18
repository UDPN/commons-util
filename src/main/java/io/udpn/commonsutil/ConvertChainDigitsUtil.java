// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)
package io.udpn.commonsutil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
* Convert chain digital
* @author yf
* @Date: 2022/4/2
* @version 1.0.0
*
* @history date, modifier,and description
**/
public class ConvertChainDigitsUtil {

  /**
   * Get chain digits
   *
   * @date 2022/4/28
   * @param chainIndex
   * @param b
   * @return java.math.BigInteger
   */
  public static BigInteger getChainDigits(Integer chainIndex, BigDecimal b) {
    BigDecimal chainUnit = new BigDecimal(Math.pow(10, chainIndex) + "");

    return b.multiply(chainUnit).toBigInteger();
  }

  /**
   * Get user digits
   *
   * @date 2022/4/28
   * @param chainIndex
   * @param b
   * @return java.math.BigDecimal
   */
  public static BigDecimal getUserDigits(Integer chainIndex, BigDecimal b) {
    BigDecimal chainUnit = new BigDecimal(Math.pow(10, chainIndex) + "");

    return b.divide(chainUnit);
  }

  /**
   * Get amount from precision
   *
   * @date 2022/4/28
   * @param currencyPrecision
   * @param b
   * @return java.lang.String
   */
  public static String getAmountFromPrecision(Integer currencyPrecision,BigDecimal b){
    String amount;
    if(b.scale() > currencyPrecision){
      amount = b.setScale(currencyPrecision, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }else{
      amount = b.stripTrailingZeros().toPlainString();
    }
    return amount;
  }
}
