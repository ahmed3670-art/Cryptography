/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesar_cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class Caesar_Cipher {

    /**
     * @param args the command line arguments
     */
    static String g_data = "";

    public static void main(String[] arges) {
        Scanner input1 = new Scanner(System.in);
        System.out.println("please insert key");
        int key = input1.nextInt();

        try {
            File input = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\Caesar_Cipher\\input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                g_data = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Do you want encrypt (e) or dcrypt(d) or attaick(a)");
        char statu = input1.next().charAt(0);
        if (statu == 'e') {
            encryp(g_data, key);

        } else if (statu == 'd') {

            decrypt(g_data, key);
        } else if (statu == 'a') {

            attaick(g_data);
        }

    }

    public static String encryp(String data, int key) {
        String res = "";

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z') {
                res += (char) ('A' + (data.charAt(i) - 'A' + key) % 26);
            } else {
                res += (char) ('a' + (data.charAt(i) - 'a' + key) % 26);

            }
            

        }
        System.out.println(res);
        return res;
    }

    public static String decrypt(String data, int key) {
        String ress = "";

        for (int i = 0; i < data.length(); i++) {
             if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z'){
            ress += (char) ('A' + (data.charAt(i) - 'A' - key + 26) % 26);
        }
             else{
                  ress += (char) ('a' + (data.charAt(i) - 'a' - key + 26) % 26);
             }
        }
        System.out.println(ress);
        return ress;

    }

    public static String attaick(String ciphertext) {

        String result = "";
        for (int j = 0; j < 26; j++) {

            for (int i = 0; i < ciphertext.length(); i++) {
                 if (ciphertext.charAt(i) >= 'A' && ciphertext.charAt(i) <= 'Z'){
                result += (char) ('A' + (ciphertext.charAt(i) - 'A' - j + 26) % 26);
            }
            else{
                     result += (char) ('a' + (ciphertext.charAt(i) - 'a' - j + 26) % 26);
                    }
            

        }
            System.out.println(j + " " + result);
            result = "";
       
    }
 return result;
}
}
