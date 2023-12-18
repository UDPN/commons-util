// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description Generator Random Password
 */
public class GeneratorPwdUtil {
  private static final String LOW_STR = "abcdefghijklmnopqrstuvwxyz";
  private static final String SPECIAL_STR = "~!$%&*_.";
  private static final String NUM_STR = "0123456789";

  /**
   * @Description Generator Random Password
   * @param num
   * @result java.lang.String
   */
  public static String getRandomPwd(int num) {
    List<Character> list = new ArrayList<>(num);
    list.add(getLowChar());
    list.add(getUpperChar());
    list.add(getNumChar());
    list.add(getSpecialChar());

    for (int i = 4; i < num; i++) {
      SecureRandom random = new SecureRandom();
      int funNum = random.nextInt(4);
      list.add(getRandomChar(funNum));
    }

    Collections.shuffle(list);
    StringBuilder stringBuilder = new StringBuilder(list.size());
    for (Character c : list) {
      stringBuilder.append(c);
    }

    return stringBuilder.toString();
  }

  /**
   * @Description get random char
   * @param
   * @result
   */
  private static char getRandomChar(int funNum) {
    switch (funNum) {
      case 0:
        return getLowChar();
      case 1:
        return getUpperChar();
      case 2:
        return getNumChar();
      default:
        return getSpecialChar();
    }
  }

  /**
   * @Description Get random lowercase characters
   * @param
   * @result
   */
  private static char getLowChar() {
    return getRandomChar(LOW_STR);
  }

  /**
   * @Description Get random uppercase characters
   * @param
   * @result
   */
  private static char getUpperChar() {
    return Character.toUpperCase(getLowChar());
  }

  /**
   * @Description Gets random numeric characters
   * @param
   * @result
   */
  private static char getNumChar() {
    return getRandomChar(NUM_STR);
  }

  /**
   * @Description Get special characters randomly
   * @param
   * @result
   */
  private static char getSpecialChar() {
    return getRandomChar(SPECIAL_STR);
  }

  /**
   * @Description Gets random string characters
   * @param
   * @result
   */
  private static char getRandomChar(String str) {
    SecureRandom random = new SecureRandom();
    return str.charAt(random.nextInt(str.length()));
  }
}
