/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenère_cipher;

import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class Vigenère_Cipher {

    /**
     * @param args the command line arguments
     */
    static int arr[];

    public static void main(String[] args) {
        // TODO code application logic here

        int flag;
        String plaintext = "hellothere";
        String ciphertext = "pxplabairq";
        String key;
        Scanner input = new Scanner(System.in);
        System.out.println("Encryptin(1) or decryption(2)");
        flag = input.nextInt();
        System.out.println("Enter the key" );
        key = input.next();
        if (flag == 1) {

            encryption(plaintext, keysize(plaintext, key));
        } else {
            decrption(ciphertext, keysize(ciphertext, key));
        }
    }

    static void encryption(String plain, String key) {
        System.out.println("Encryption text is");
        for (int i = 0; i < plain.length(); i++) {

            System.out.print((char) (((((plain.charAt(i) - 97) + (key.charAt(i)) - 97) % 26)) + 97));

        }
    }

    static void decrption(String cipher, String key) {
        System.out.println("Decription text is");
        for (int i = 0; i < cipher.length(); i++) {

            System.out.print((char) (((cipher.charAt(i) - key.charAt(i) + 26) % 26) + 97));

        }
    }

    static String keysize(String str, String key) {
        int x = str.length();

        for (int i = 0;; i++) {
            
            if (key.length() == str.length()) {
                break;
            }
            key += (key.charAt(i));
        }
        return key;
    }

}
