// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.util.Base64;
import java.util.Base64.Decoder;

/**
*  Base64 utils
* @author Dong-Jianguo
* @Date: 2023/3/30
* @version 1.0.0
*
* @history date, modifier,and description
**/
public class Base64Utils {

  public static String Base64ToJsonString(String base64Str) {

    Decoder decoder = Base64.getDecoder();

    byte[] decode = decoder.decode(base64Str);

    String result = new String(decode);

    return result;
  }
}
