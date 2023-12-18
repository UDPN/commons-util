package io.udpn.commonsutil;

import org.apache.commons.lang3.StringUtils;

public class TraceIdeUtil {
  public static String wrapId(String traceId){

    if (StringUtils.isNotEmpty(traceId)){
      StringBuilder stringBuilder=new StringBuilder();
      StringBuilder append = stringBuilder
          .append("ST_")
          .append(traceId)
          .append("_")
          .append(System.currentTimeMillis())
          .append("_ED");

      String join = append.toString();
      return join;
    }else{
      return traceId;
    }

  }
}
