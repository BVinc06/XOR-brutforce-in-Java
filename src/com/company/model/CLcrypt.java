package com.company.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLcrypt {
    public String m_crypt(String inputString,String key){
        StringBuilder c = new StringBuilder();
        while (key.length() < inputString.length()/2) {
            key += key;
        }

        for (int i=0;i<inputString.length();i+=2) {
            String hexValueString = inputString.substring(i, i+2);
            int value1 = Integer.parseInt(hexValueString, 16);
            int value2 = key.charAt(i/2);

            int xorValue = value1 ^ value2;

            c.append(Character.toString((char) xorValue));

        }
        return c.toString();

    }

}
