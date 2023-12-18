// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)
package io.udpn.commonsutil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* SHA-256 encryption util
* @author yf
* @Date: 2023/3/25
* @version 1.0.0
*
* @history date, modifier,and description
**/
public class EncryptSha256Util {

  /**
   * Sha256 encryption
   *
   * @date 2023/3/25
   * @param str
   * @return java.lang.String
   */
  public static String getSha256Str(String str) {
    MessageDigest messageDigest;
    String encodeStr = "";
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
      encodeStr = byte2Hex(messageDigest.digest());
    }catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return encodeStr;
  }

  /**
   * Sha256 encryption converts byte to hexadecimal
   *
   * @date 2023/3/25
   * @param bytes
   * @return java.lang.String
   */
  private static String byte2Hex(byte[] bytes) {
    StringBuilder stringBuilder = new StringBuilder();
    String temp;
    for (byte aByte : bytes){
      temp = Integer.toHexString(aByte & 0xFF);
      if (temp.length() ==1){
        stringBuilder.append("0");
      }
      stringBuilder.append (temp);
    }
    return stringBuilder.toString();
  }

}
