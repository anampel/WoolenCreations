package com.site.woolencreations.misc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Security class is responsible about password hashing
 * */
public class Security {
    /**
     * hashPassword method takes as input the user's password, return it into MD5 type, take it's bytes and convert them into a long string
     * @param passwordToHash Provided password to be encrypted
     * */
    public static String hashPassword(String passwordToHash)  {

        String generatedPassword = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }

}
