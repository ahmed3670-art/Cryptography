/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetimepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author MaaDy
 */
public class OneTimePad {

    static int arr[];

    public static void main(String[] args) {
        // TODO code application logic here

        
        String key = "";
        String plaintext =getplain() ;
        //for fast test
        //String plaintext = "hellothere";
      
        key = getAlphaNumericString(plaintext.length());

        System.out.println("Random key is: " + key);

        encryption(plaintext, key);

       
    }

   public static String encryption(String plain, String key) {
      String  encrypt="";
        System.out.print("Encryption text is"+" ");
        for (int i = 0; i < plain.length(); i++) {
            

           encrypt+= (char) (((((plain.charAt(i) - 97) + (key.charAt(i)) - 97) % 26)) + 97);
        }
        System.out.println(encrypt);
        decrption(encrypt,key);
return encrypt;
    }

    static void decrption(String cipher, String key) {
        System.out.print("Decription text is"+" ");
        for (int i = 0; i < cipher.length(); i++) {

            System.out.print((char) (((cipher.charAt(i) - key.charAt(i) + 26) % 26) + 97));

        }
    }

    static String getAlphaNumericString(int n) {

       
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

        
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

           
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
     private static String getplain() {
         String g_data ="";
         try {
             File plian = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\onetime\\plain.txt");
            Scanner myReader = new Scanner(plian);
            while (myReader.hasNext()) {
                g_data += myReader.next();
                  

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         
       System.out.println(g_data);
         return g_data;
    }

}
