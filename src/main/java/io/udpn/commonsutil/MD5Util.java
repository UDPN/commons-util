package io.udpn.commonsutil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* MD5 encryption
* @author yf
* @Date: 2022/7/18
* @version 1.0.0
*
* @history date, modifier,and description
**/
public class MD5Util {

    private static final String DEFAULT_ = "MD5";

    // Global array
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * Returns the form of a number and a string
     *
     * @date 2022/7/18
     * @param bByte
     * @return java.lang.String
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * Convert byte array to hexadecimal string
     *
     * @date 2022/7/18
     * @param bByte
     * @return java.lang.String
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * Encryption(UTF-8)
     *
     * @date 2022/7/18
     * @param strObj
     * @return java.lang.String
     */
    static String getMD5Code(String strObj) throws NoSuchAlgorithmException {
        String resultString = new String(strObj);
        MessageDigest md = MessageDigest.getInstance(DEFAULT_);
        try {
            // md.digest():The return value of this function is a byte array that stores the result of the hash value
            resultString = byteToString(md.digest(strObj.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
}
