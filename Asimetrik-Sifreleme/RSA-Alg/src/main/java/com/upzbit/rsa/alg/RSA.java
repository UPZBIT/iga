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
public class RSA {
    
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
    private final static int Key = 128;
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger mod;
    
    public String KeyGeneration(){
        
        BigInteger p = BigInteger.probablePrime(Key, random);
        BigInteger q = BigInteger.probablePrime(Key, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        
        this.mod = p.multiply(q);
        this.publicKey = new BigInteger("65537");
        this.privateKey = publicKey.modInverse(phi);
        
        return "Public Key: " + this.publicKey + "\nPrivate Key: " + this.privateKey + "\nMod: " + this.mod;
    }
    
    public BigInteger Encryption(BigInteger msg){
        
        return msg.modPow(this.publicKey, this.mod);
        
    }
    
    public BigInteger Decryption(BigInteger msg){
        
        return msg.modPow(this.privateKey, this.mod);
        
    }
    
}
