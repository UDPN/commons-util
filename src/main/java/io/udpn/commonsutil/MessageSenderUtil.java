// Copyright 2021 Red Date Technology Ltd.  Licensed under MPLv2
// (https://www.mozilla.org/en-US/MPL/2.0/)

package io.udpn.commonsutil;

import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/**
 * @Description Message sending template parameter replacement
 */
public class MessageSenderUtil {

    public static String sendMsgWrap(Map<String, Object> params, String temp) {

        StringSubstitutor stringSubstitutor = new StringSubstitutor(params);
        String wrapResult = stringSubstitutor.replace(temp);
        return wrapResult;
    }

}
