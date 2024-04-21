package com.backendDemo.emsbackend.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Utilities {
    public static final String HASH_ALG="SHA-256";
    public static String getHash(String data){
        return new DigestUtils(HASH_ALG).digestAsHex(data);
    }
}
