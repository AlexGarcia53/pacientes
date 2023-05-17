/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.utils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author jegav
 */
public class Encriptacion {
    
    private SecretKey secretKey;
    private static Encriptacion instance;
    
    private Encriptacion(){
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            
        }
    }
    
    public static Encriptacion getInstance(){
        if(instance == null){
            instance = new Encriptacion();
        }
        return instance;
    }
    
    
    
    public String encriptar(String mensaje){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // Tamaño de clave de 256 bits (también puede ser 128 o 192 bits)
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] secretKeyBytes = secretKey.getEncoded();
            
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoPlanoBytes = mensaje.getBytes();
            byte[] textoEncriptadoBytes = cipher.doFinal(textoPlanoBytes);
            return Base64.getEncoder().encodeToString(textoEncriptadoBytes);
        } catch (NoSuchAlgorithmException | 
                NoSuchPaddingException | 
                InvalidKeyException | 
                IllegalBlockSizeException |
                BadPaddingException ex) {
            return "";
        }
    }
    
    public String desencriptar(String mensaje){
        
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return "";
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            return "";
        }
    }
    
    
    
}
