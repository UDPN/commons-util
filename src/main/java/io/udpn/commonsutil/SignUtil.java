// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)
package io.udpn.commonsutil;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * Sign util
 *
 * @author yf
 * @version 1.0.0
 * @Date: 2022/7/14$
 * @history date, modifier,and description
 **/
public class SignUtil {

  /**
   * Signature field
   */
  public final static String SIGN = "sign";

  /**
   * Signature check
   * In the signature parameters, sign is the encrypted value used for verification,
   * other parameters are sorted alphabetically, encrypted, and their contents are linked together
   *
   * @param params
   * @param key
   * @return
   */
  public static boolean signCheck(Map<String, String> params, String key) {
    String sign = params.get(SIGN);
    if (null == sign) {
      return false;
    }
    String signTemp = getSignString(params, key);
    if (null == signTemp) {
      return false;
    }

    return signTemp.equals(sign);
  }

  /**
   * Get the signed string
   *
   * @date 2022/7/15
   * @param params
   * @param key
   * @return java.lang.String
   */
  public static String getSignString(Map<String, String> params, String key) {
    if (null == params || params.size() == 0) {
      return null;
    }
    key = (null == key) ? "" : key;

    Set<String> keySet = params.keySet();
    String[] keyArray = keySet.toArray(new String[keySet.size()]);
    Arrays.sort(keyArray);

    StringBuffer sb = new StringBuffer();
    for (String k : keyArray) {
      String value = params.get(k);
      if (!StringUtils.isEmpty(value)) {
        sb.append(params.get(k).trim()).append("&");
      }
    }
    sb.append(key);
    String signTemp = null;
    try {
      signTemp = MD5Util.getMD5Code(sb.toString()).toLowerCase();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return signTemp;
  }

}
