/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere_cipher_attack;

/**
 *
 * @author MaaDy
 */
public class Vigenere_cipher_attack {

    
    public static void main(String[] args) {
        String plaintext="hellothere";
        String ciphertext="pxplabairq";
        attack(plaintext,ciphertext);
    }

    private static void attack(String plaintext, String ciphertext) {
                for(int i = 0 ; i<plaintext.length(); i++){
            System.out.print((char)(((ciphertext.charAt(i)- plaintext.charAt(i)+26)%26)+97));
        }
    }
    
}
