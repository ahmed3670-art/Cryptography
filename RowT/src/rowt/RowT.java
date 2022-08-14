/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class RowT {

    /**
     * @param args the command line arguments
     */
    static char arr[][];
    static char arrdec[][];
    

    static String key1 ="";
    static int kl = 0;
    static int num_of_row;
    static String tamp = "";

    public static void main(String[] args) {
        //read plain and key from file
        String plain =getplain();
        key1=getkey();
        //****** for fast test ya doctor ************///
       // String plain ="attackpostponeduntiltwoam";
        //key1="4312567";
        kl=key1.length();
        
        if (plain.length() % key1.length() == 0) {
            num_of_row = plain.length() / key1.length() + 1;
        } else {
            num_of_row = plain.length() / key1.length() + 2;
        }
        
        System.out.println(encrypt(key1, plain));
        System.out.print(decrypt(encrypt(key1, plain), key1));

    }

    public static String encrypt(String key, String plain) {
        arr = new char[num_of_row][kl];
        int index = 0;
        String cipher = "";
        for (int i = 0; i < kl; i++) {
            arr[0][i] = key.charAt(i);
        }
        for (int i = 1; i < num_of_row; i++) {
            for (int j = 0; j < kl; j++) {
                if (index < plain.length()) {
                    arr[i][j] = plain.charAt(index++);
                    //System.out.print(arr[i][j]);
                }
            }
        }
        for (int i = 1; i < num_of_row; i++) {
            for (int j = 0; j < kl; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 'x';
                }
            }
        }

        for (int j = 0; j < kl - 1; j++) {
            for (int k = j + 1; k < kl; k++) {
                if (arr[0][j] > arr[0][k]) {
                    for (int row = 0; row < num_of_row; row++) {
                        tamp += arr[row][j];
                    }
                    for (int row = 0; row < num_of_row; row++) {
                        arr[row][j] = arr[row][k];
                    }
                    for (int row = 0; row < num_of_row; row++) {
                        arr[row][k] = tamp.charAt(row);
                    }

                    tamp = "";
                }
            }
        }

        for (int i = 0; i < kl; i++) {
            for (int j = 1; j < num_of_row; j++) {
                cipher += arr[j][i];

            }

        }
        return cipher;

    }

    public static String decrypt(String encrypt, String key1) {
        char temp;
        char sort[] = key1.toCharArray();
        arrdec = new char[num_of_row][kl];
        String plain = "";
        int index1 = 0;

        for (int i = 0; i < key1.length(); i++) {
            for (int j = i + 1; j < key1.length(); j++) {
                if (sort[i] > sort[j]) {

                    temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;

                }

            }

        }
        String sorting_key = "";
        for (int i = 0; i < sort.length; i++) {
            sorting_key += sort[i];
        }

        for (int i = 0; i < kl; i++) {
            arrdec[0][i] = sorting_key.charAt(i);
        }

        for (int i = 0; i < kl; i++) {
            for (int j = 1; j < num_of_row; j++) {
                if (index1 < encrypt.length()) {
                    arrdec[j][i] = encrypt.charAt(index1++);
                }
            }
        }

        int pointer = 1;
        for (int f = 1; f < num_of_row; f++) {
            for (int l = 0; l < kl; l++) {
                for (int n = 0; n < kl; n++) {
                    if (key1.charAt(l) == arrdec[0][n]) {
                        plain += arrdec[pointer][n];

                    }
                }

            }
            pointer++;
        }
        return plain;

    }

    

    private static String getplain() {
         String g_data ="";
         try {
             File plian = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\RowTransposition\\plain.txt");
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

    private static String getkey() {
         String g_data ="";
         try {
             File key = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\RowTransposition\\key.txt");
            Scanner myReader = new Scanner(key);
            while (myReader.hasNextLine()) {
                g_data += myReader.nextLine();
                //  System.out.print(g_data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       
         return g_data;
       
    }
}
