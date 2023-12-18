// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Server util
 *
 * @author Dong-Jianguo
 * @version 1.0.0
 * @Date: 2021/9/23
 * @history date, modifier,and description
 **/
public class ServerUtil {


  private static final String IP_REGEX =
      "(((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?))";
  private static final String DOMAIN_REGEX =
      ".*\\.(com|xyz|net|top|tech|org|gov|edu|pub|cn|biz|cc|tv|info|im|io)";
  /**
   * The value must be a combination of letters and digits
   * It must start with a letter and cannot exceed 50 characters
   */
  public static final String NAME_REGEX = "[a-zA-Z]{1}\\w{1,49}";

  /**
   * Verification rule:
   * The value must be a combination of letters and digits
   * It must start with a letter and cannot exceed 50 characters
   *
   * @param param
   * @return boolean
   * @date 2021/12/03
   */
  public static boolean isName(String param) {
    if (param.matches(NAME_REGEX)) {
      return true;
    }
    return false;
  }

  /**
   * method description Is it an IP address
   *
   * @param host
   * @return boolean
   * @date 2021/9/23
   */
  public static boolean isHostIp(String host) {
    if (host.matches(IP_REGEX)) {
      return true;
    }
    return false;
  }

  /**
   * method description Is it a domain name
   *
   * @param host
   * @return boolean
   * @date 2021/9/23
   */
  public static boolean isHostDomain(String host) {
    if (host.matches(String.format("^%s$", DOMAIN_REGEX))) {
      return true;
    }
    return false;
  }

  public static String getScheme(String host) {
    if (host != null) {
      if (host.toLowerCase().startsWith("http://")) {
        return "http";
      } else if (host.toLowerCase().startsWith("https://")) {
        return "https";
      }
    }
    return null;
  }

  /**
   * Determine whether the IP and Port can be connected
   *
   * @date 2022/3/3
   * @param ip
   * @param port
   * @param timeout
   * @return boolean
   */
  public static boolean isReachable(String ip, Integer port, int timeout) {

    boolean reachable = false;
    // If the port is empty, use isReachable to detect, non-empty use socket to detect
    if(port == null) {
      try {
        InetAddress address = InetAddress.getByName(ip);
        reachable = address.isReachable(timeout);
      } catch (Exception e) {
        e.printStackTrace();
        reachable = false;
      }
    } else {
      Socket socket = new Socket();
      try {
        socket.connect(new InetSocketAddress(ip, port), timeout);
        reachable = true;
      } catch (Exception e) {
        e.printStackTrace();
        reachable = false;
      } finally {
        try {
          if(socket != null) {
            socket.close();
          }
        }catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return reachable;
  }

}
