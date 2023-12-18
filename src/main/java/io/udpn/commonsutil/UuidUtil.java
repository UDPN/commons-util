// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public class UuidUtil {

  private static AtomicInteger atomicInteger = new AtomicInteger();


  public static String generateUUID32() {
    synchronized (atomicInteger) {
      return UUID.randomUUID().toString().replace("-", "");
    }
  }

}
