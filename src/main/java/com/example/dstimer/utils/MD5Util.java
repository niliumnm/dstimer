package com.example.dstimer.utils;

import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;

public class MD5Util {
    public static String generateMD5(String input) throws UnsupportedEncodingException {
        //获取MD5机密实例
        return Hashing.md5().hashBytes(input.getBytes("UTF-8")).toString();
    }

}
