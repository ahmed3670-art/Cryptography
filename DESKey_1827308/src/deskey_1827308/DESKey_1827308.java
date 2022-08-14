/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deskey_1827308;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class DESKey_1827308 {

    /**
     * @param args the command line arguments
     */
    static int pc_1[][] = {{57, 49, 41, 33, 25, 17, 9},
    {1, 58, 50, 42, 34, 26, 18},
    {10, 2, 59, 51, 43, 35, 27},
    {19, 11, 3, 60, 52, 44, 36},
    {63, 55, 47, 39, 31, 23, 15},
    {7, 62, 54, 46, 38, 30, 22},
    {14, 6, 61, 53, 45, 37, 29},
    {21, 13, 5, 28, 20, 12, 4}
    };
    static int pc_2[][] = {{14, 17, 11, 24, 1, 5},
    {3, 28, 15, 6, 21, 10},
    {23, 19, 12, 4, 26, 8},
    {16, 7, 27, 20, 13, 2},
    {41, 52, 31, 37, 47, 55},
    {30, 40, 51, 45, 33, 48},
    {44, 49, 39, 56, 34, 53},
    {46, 42, 50, 36, 29, 32}
    };
    static int temp[][] = new int[8][7];
    static String ci = "";
    static String di = "";
    static String ci1 = "";
    static String di1 = "";

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String hex = input.next();
             
        //String hex = "133457799BBCDFF1";

        String key = hexToBinary(hex);
        //System.out.println(key);
        String k_pluse = permitution_1(key);
        //System.out.println(k_pluse);
        ci = k_pluse.substring(0, 28);
        di = k_pluse.substring(28, 56);
        String k1 = generat(ci, di, 1);
        //System.out.println("the key 1 is" + " " + k1);

        String k2 = generat(ci1, di1, 1);
        //System.out.println("the key 2 is" + " " + k2);
        String k3 = generat(ci1, di1, 2);
        //System.out.println("the key 3 is" + " " + k3);
        String k4 = generat(ci1, di1, 2);
        //System.out.println("the key 4 is" + " " + k4);
        String k5 = generat(ci1, di1, 2);
        //System.out.println("the key 5 is" + " " + k5);
        String k6 = generat(ci1, di1, 2);
        //System.out.println("the key 6 is" + " " + k6);
        String k7 = generat(ci1, di1, 2);
        //System.out.println("the key 7 is" + " " + k7);
        String k8 = generat(ci1, di1, 2);
        //System.out.println("the key 8 is" + " " + k8);
        String k9 = generat(ci1, di1, 1);
        //System.out.println("the key 9 is" + " " + k9);
        String k10 = generat(ci1, di1, 2);
        //System.out.println("the key 10 is" + " " + k10);
        String k11 = generat(ci1, di1, 2);
        //System.out.println("the key 11 is" + " " + k11);
        String k12 = generat(ci1, di1, 2);
        //System.out.println("the key 12 is" + " " + k12);
        String k13 = generat(ci1, di1, 2);
        //System.out.println("the key 13 is" + " " + k13);
        String k14 = generat(ci1, di1, 2);
        //System.out.println("the key 14 is" + " " + k14);
        String k15 = generat(ci1, di1, 2);
        //System.out.println("the key 15 is" + " " + k15);
        String k16 = generat(ci1, di1, 1);
        //System.out.println("the key 16 is" + " " + k16);

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\MaaDy\\Desktop\\cipher\\deskey\\deskey.txt");
            myWriter.write("k1=" + k1 + "\n" + "k2=" + k2 + "\n" + "k3=" + k3 + "\n" + "k4=" + k4 + "\n" + "k5=" + k5 + "\n" + "k6=" + k6 + "\n" + "k7=" + k7 + "\n" + "k8=" + k8 + "\n" + "k9=" + k9 + "\n" + "k10=" + k10 + "\n" + "k11=" + k11 + "\n" + "k12=" + k12 + "\n" + "k13=" + k13 + "\n" + "k14=" + k14 + "\n" + "k15=" + k15 + "\n" + "k16=" + k16 + "\n");
            myWriter.close();
           System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String hexToBinary(String hex) {

        String binary = "";

        hex = hex.toUpperCase();
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) == '0') {
                binary += "0000";
            } else if (hex.charAt(i) == '1') {
                binary += "0001";
            } else if (hex.charAt(i) == '2') {
                binary += "0010";
            } else if (hex.charAt(i) == '3') {
                binary += "0011";
            } else if (hex.charAt(i) == '4') {
                binary += "0100";
            } else if (hex.charAt(i) == '5') {
                binary += "0101";
            } else if (hex.charAt(i) == '6') {
                binary += "0110";
            } else if (hex.charAt(i) == '7') {
                binary += "0111";
            } else if (hex.charAt(i) == '8') {
                binary += "1000";
            } else if (hex.charAt(i) == '9') {
                binary += "1001";
            } else if (hex.charAt(i) == 'A') {
                binary += "1010";
            } else if (hex.charAt(i) == 'B') {
                binary += "1011";
            } else if (hex.charAt(i) == 'C') {
                binary += "1100";
            } else if (hex.charAt(i) == 'D') {
                binary += "1101";
            } else if (hex.charAt(i) == 'E') {
                binary += "1110";
            } else if (hex.charAt(i) == 'F') {
                binary += "1111";
            }
        }

        return binary;
    }

    public static String permitution_1(String key) {
        String key_pluse = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {

                key_pluse += key.charAt(pc_1[i][j] - 1);
            }
        }
        return key_pluse;

    }

    private static String generat(String ci, String di, int shift) {
        String ctemp = "";
        String dtemp = "";
        ci1 = "";
        di1 = "";

        char arrc[] = new char[ci.length()];
        char arrd[] = new char[di.length()];
        for (int i = 0; i < ci.length(); i++) {
            arrc[i] = ci.charAt(i);
        }
        for (int i = 0; i < ci.length(); i++) {
            arrd[i] = di.charAt(i);
        }
        for (int i = 0; i < shift; i++) {
            ctemp += ci.charAt(i);
        }
        for (int i = 0; i < shift; i++) {
            dtemp += di.charAt(i);
        }
        if (shift == 1) {
            for (int i = 0; i < ci.length() - 1; i++) {
                arrc[i] = arrc[i + 1];
            }
            arrc[ci.length() - 1] = ctemp.charAt(0);
            for (int i = 0; i < di.length() - 1; i++) {
                arrd[i] = arrd[i + 1];
            }
            arrd[di.length() - 1] = dtemp.charAt(0);
        } else if (shift == 2) {
            int index = 2;
            for (int i = 0; i < ci.length() - 2; i++) {
                arrc[i] = arrc[index++];
            }
            arrc[ci.length() - 2] = ctemp.charAt(0);
            arrc[ci.length() - 1] = ctemp.charAt(1);
            index = 2;
            for (int i = 0; i < di.length() - 2; i++) {
                arrd[i] = arrd[index++];
            }
            arrd[di.length() - 2] = dtemp.charAt(0);
            arrd[di.length() - 1] = dtemp.charAt(1);

        }
        String key = "";

        for (int i = 0; i < ci.length(); i++) {
            ci1 += arrc[i];
            key += arrc[i];
        }
        for (int i = 0; i < ci.length(); i++) {
            di1 += arrd[i];
            key += arrd[i];
        }
        String final_key = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {

                final_key += key.charAt(pc_2[i][j] - 1);
            }
        }

        return final_key;

    }

}
