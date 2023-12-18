// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.net.URI;

/**
 * Url parsing related tools
 *
 * @author yf
 * @version 1.0.0
 **/
public class UDPNUrlUtil {

  /**
   * Url parsing
   *
   * @date 2022/4/20
   * @param url
   * @return network.udpn.common.utils.UrlUtil
   */
  public static UDPNUrlUtil getUrl(String url) {
    URI uri = URI.create(url);
    UDPNUrlUtil urlUtil = new UDPNUrlUtil();
    urlUtil.setHost(uri.getHost());
    urlUtil.setPort(uri.getPort());
    urlUtil.setSchema(uri.getScheme());
    return urlUtil;
  }

    private String schema;
    private String host;
    private int port;

    public String getSchema() {
      return schema;
    }

    public void setSchema(String schema) {
      this.schema = schema;
    }

    public String getHost() {
      return host;
    }

    public void setHost(String host) {
      this.host = host;
    }

    public int getPort() {
      return port;
    }

    public void setPort(int port) {
      this.port = port;
    }
}
