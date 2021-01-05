/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upzbit.rsa.alg;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author emrejilta
 */
public class main {

    public static void main(String[] args) {
        
        RSA rsaObj = new RSA();
        String keys = rsaObj.KeyGeneration();
        System.out.println(keys);
        
        String plainText = "RSA";
        System.out.println("Açık metin: " + plainText);
        
        String[] cipherText = new String[plainText.length()];
        String cText = "";
        
        String[] asciiText = new String[plainText.length()];
        String aText = "";
        
        for(int i=0; i<plainText.length(); i++){
        
            asciiText[i] = (int) plainText.charAt(i) + "";
            aText += asciiText[i];
        
            cipherText[i] = rsaObj.Encryption(new BigInteger(asciiText[i])).toString();
            cText += "\n" + cipherText[i];
            
        }
        
        System.out.println("Açık metnin ASCII hâli: " + aText);
        System.out.println("Metnin şifrelenmiş hâli: " + cText);
        
        String[] decipherAsciiText = new String[cipherText.length];
        String dAsciiTxt = "";
        String dText = "";
        
        for(int i=0; i<cipherText.length; i++){
        
            decipherAsciiText[i] = rsaObj.Decryption(new BigInteger(cipherText[i])).toString();
            dAsciiTxt += decipherAsciiText[i];
            dText += Character.toString((char) Integer.parseInt(decipherAsciiText[i]));
            
        }
        
        System.out.println("Şifreli metnin çözülmüş hâli: " + dAsciiTxt);
        System.out.println("Açık metin: " + dText);
        
    }
    
}
