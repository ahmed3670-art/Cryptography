/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desencrypt_1827308;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class DESEncrypt_1827308 {

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
    static int ip[][] = {{58, 50, 42, 34, 26, 18, 10, 2},
    {60, 52, 44, 36, 28, 20, 12, 4},
    {62, 54, 46, 38, 30, 22, 14, 6},
    {64, 56, 48, 40, 32, 24, 16, 8},
    {57, 49, 41, 33, 25, 17, 9, 1},
    {59, 51, 43, 35, 27, 19, 11, 3},
    {61, 53, 45, 37, 29, 21, 13, 5},
    {63, 55, 47, 39, 31, 23, 15, 7},};
    static int E[][] = {{32, 1, 2, 3, 4, 5},
    {4, 5, 6, 7, 8, 9},
    {8, 9, 10, 11, 12, 13},
    {12, 13, 14, 15, 16, 17},
    {16, 17, 18, 19, 20, 21},
    {20, 21, 22, 23, 24, 25},
    {24, 25, 26, 27, 28, 29},
    {28, 29, 30, 31, 32, 1}

};
    static String s1[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "14", "4", "13", "1", "2", "15", "11", "8", "3", "10", "6", "12", "5", "9", "0", "7"},
    {"01", "0", "15", "7", "4", "14", "2", "13", "1", "10", "6", "12", "11", "9", "5", "3", "8"},
    {"10", "4", "1", "14", "8", "13", "6", "2", "11", "15", "12", "9", "7", "3", "10", "5", "0"},
    {"11", "15", "12", "8", "2", "4", "9", "1", "7", "5", "11", "3", "14", "10", "0", "6", "13"}
    };
    static String s2[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "15", "1", "8", "14", "6", "11", "3", "4", "9", "7", "2", "13", "12", "0", "5", "10"},
    {"01", "3", "13", "4", "7", "15", "2", "8", "14", "12", "0", "1", "10", "6", "9", "11", "5"},
    {"10", "0", "14", "7", "11", "10", "4", "13", "1", "5", "8", "12", "6", "9", "3", "2", "15"},
    {"11", "13", "8", "10", "1", "3", "15", "4", "2", "11", "6", "7", "12", "0", "5", "14", "9"}};

    static String s3[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "10", "0", "9", "14", "6", "3", "15", "5", "1", "13", "12", "7", "11", "4", "2", "8"},
    {"01", "13", "7", "0", "9", "3", "4", "6", "10", "2", "8", "5", "14", "12", "11", "15", "1"},
    {"10", "13", "6", "4", "9", "8", "15", "3", "0", "11", "1", "2", "12", "5", "10", "14", "7"},
    {"11", "1", "10", "13", "0", "6", "9", "8", "7", "4", "15", "14", "3", "11", "5", "2", "12"}};

    static String s4[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "7", "13", "14", "3", "0", "6", "9", "10", "1", "2", "8", "5", "11", "12", "4", "15"},
    {"01", "13", "8", "11", "5", "6", "15", "0", "3", "4", "7", "2", "12", "1", "10", "14", "9"},
    {"10", "10", "6", "9", "0", "12", "11", "7", "13", "15", "1", "3", "14", "5", "2", "8", "4"},
    {"11", "3", "15", "0", "6", "10", "1", "13", "8", "9", "4", "5", "11", "12", "7", "2", "14"}};

    static String s5[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "2", "12", "4", "1", "7", "10", "11", "6", "8", "5", "3", "15", "13", "0", "14", "9"},
    {"01", "14", "11", "2", "12", "4", "7", "13", "1", "5", "0", "15", "10", "3", "9", "8", "6"},
    {"10", "4", "2", "1", "11", "10", "13", "7", "8", "15", "9", "12", "5", "6", "3", "0", "14"},
    {"11", "11", "8", "12", "7", "1", "14", "2", "13", "6", "15", "0", "9", "10", "4", "5", "3"}};

    static String s6[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "12", "1", "10", "15", "9", "2", "6", "8", "0", "13", "3", "4", "14", "7", "5", "11"},
    {"01", "10", "15", "4", "2", "7", "12", "9", "5", "6", "1", "13", "14", "0", "11", "3", "8"},
    {"10", "9", "14", "15", "5", "2", "8", "12", "3", "7", "0", "4", "10", "1", "13", "11", "6"},
    {"11", "4", "3", "2", "12", "9", "5", "15", "10", "11", "14", "1", "7", "6", "0", "8", "13"}};

    static String s7[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "4", "11", "2", "14", "15", "0", "8", "13", "3", "12", "9", "7", "5", "10", "6", "1"},
    {"01", "13", "0", "11", "7", "4", "9", "1", "10", "14", "3", "5", "12", "2", "15", "8", "6"},
    {"10", "1", "4", "11", "13", "12", "3", "7", "14", "10", "15", "6", "8", "0", "5", "9", "2"},
    {"11", "6", "11", "13", "8", "1", "4", "10", "7", "9", "5", "0", "15", "14", "2", "3", "12"}};

    static String s8[][] = {{"0", "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"},
    {"00", "13", "2", "8", "4", "6", "15", "11", "1", "10", "9", "3", "14", "5", "0", "12", "7"},
    {"01", "1", "15", "13", "8", "10", "3", "7", "4", "12", "5", "6", "11", "0", "14", "9", "2"},
    {"10", "7", "11", "4", "1", "9", "12", "14", "2", "0", "6", "10", "13", "15", "3", "5", "8"},
    {"11", "2", "1", "14", "7", "4", "10", "8", "13", "15", "12", "9", "0", "3", "5", "6", "11"}};
    static int p[][] = {{16, 7, 20, 21},
    {29, 12, 28, 17},
    {1, 15, 23, 26},
    {5, 18, 31, 10},
    {2, 8, 24, 14},
    {32, 27, 3, 9},
    {19, 13, 30, 6},
    {22, 11, 4, 25}

};
    static int IP_1[][] = {{40, 8, 48, 16, 56, 24, 64, 32},
    {39, 7, 47, 15, 55, 23, 63, 31},
    {38, 6, 46, 14, 54, 22, 62, 30},
    {37, 5, 45, 13, 53, 21, 61, 29},
    {36, 4, 44, 12, 52, 20, 60, 28},
    {35, 3, 43, 11, 51, 19, 59, 27},
    {34, 2, 42, 10, 50, 18, 58, 26},
    {33, 1, 41, 9, 49, 17, 57, 25}

};

    static int temp[][] = new int[8][7];
    static String ci = "";
    static String di = "";
    static String ci1 = "";
    static String di1 = "";
    static String LI = "";
    static String RI = "";

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter key");
        //String hex = input.next();
        System.out.println("Enter palin text");

        //String plain = input.next();
         String plain = "0123456789ABCDEF";             
        String hex = "133457799BBCDFF1";

        String key = hexToBinary(hex);

        String k_pluse = permitution_1(key);

        ci = k_pluse.substring(0, 28);
        di = k_pluse.substring(28, 56);
        String k1 = generat(ci, di, 1);

        String k2 = generat(ci1, di1, 1);

        String k3 = generat(ci1, di1, 2);

        String k4 = generat(ci1, di1, 2);

        String k5 = generat(ci1, di1, 2);

        String k6 = generat(ci1, di1, 2);

        String k7 = generat(ci1, di1, 2);

        String k8 = generat(ci1, di1, 2);

        String k9 = generat(ci1, di1, 1);

        String k10 = generat(ci1, di1, 2);

        String k11 = generat(ci1, di1, 2);

        String k12 = generat(ci1, di1, 2);

        String k13 = generat(ci1, di1, 2);

        String k14 = generat(ci1, di1, 2);

        String k15 = generat(ci1, di1, 2);

        String k16 = generat(ci1, di1, 1);

        String m = hexToBinary(plain);
        String ip = ip_permitution(m);
        String L0 = ip.substring(0, 32);
        String R0 = ip.substring(32, 64);
        encrypt(L0, R0, k1);
        encrypt(LI, RI, k2);
       System.out.println( encrypt(LI, RI, k3));
       System.out.println(encrypt(LI, RI, k4));
        System.out.println(encrypt(LI, RI, k5));
        System.out.println(encrypt(LI, RI, k6));
        System.out.println(encrypt(LI, RI, k7));
        System.out.println(encrypt(LI, RI, k8));
        System.out.println(encrypt(LI, RI, k9));
        System.out.println(encrypt(LI, RI, k10));
        System.out.println(encrypt(LI, RI, k11));
        System.out.println(encrypt(LI, RI, k12));
        System.out.println(encrypt(LI, RI, k13));
        System.out.println(encrypt(LI, RI, k14));
        System.out.println(encrypt(LI, RI, k15));
        String Round_16 = encrypt(LI, RI, k16);
        //  System.out.print(Round_16);
        String final_cipher = "";
        String cipher = ip_1_pemution(Round_16);
        String cipher_1 = cipher.substring(0, 4);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(4, 8);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(8, 12);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(12, 16);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(16, 20);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(20, 24);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(24, 28);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(28, 32);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(32, 36);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(36, 40);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(40, 44);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(44, 48);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(48, 52);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(52, 56);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(56, 60);
        final_cipher += binary_to_dec(cipher_1);
        cipher_1 = "";
        cipher_1 = cipher.substring(60, 64);
        final_cipher += binary_to_dec(cipher_1);

        System.out.println("cipher text is"+final_cipher);

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\MaaDy\\Desktop\\cipher\\desciper\\descipher.txt");
            myWriter.write("cipher text is " +" "+ final_cipher);
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

    public static String hexToBinary_s_box(String hex) {

        String binary = "";

        if (hex.equals("0")) {
            binary += "0000";
        } else if (hex.equals("1")) {
            binary += "0001";
        } else if (hex.equals("2")) {
            binary += "0010";
        } else if (hex.equals("3")) {
            binary += "0011";
        } else if (hex.equals("4")) {
            binary += "0100";
        } else if (hex.equals("5")) {
            binary += "0101";
        } else if (hex.equals("6")) {
            binary += "0110";
        } else if (hex.equals("7")) {
            binary += "0111";
        } else if (hex.equals("8")) {
            binary += "1000";
        } else if (hex.equals("9")) {
            binary += "1001";
        } else if (hex.equals("10")) {
            binary += "1010";
        } else if (hex.equals("11")) {
            binary += "1011";
        } else if (hex.equals("12")) {
            binary += "1100";
        } else if (hex.equals("13")) {
            binary += "1101";
        } else if (hex.equals("14")) {
            binary += "1110";
        } else if (hex.equals("15")) {
            binary += "1111";
        }

        return binary;
    }

    public static String binary_to_dec(String hex) {

        String binary = "";

        if (hex.equals("0000")) {
            binary += "0";
        } else if (hex.equals("0001")) {
            binary += "1";
        } else if (hex.equals("0010")) {
            binary += "2";
        } else if (hex.equals("0011")) {
            binary += "3";
        } else if (hex.equals("0100")) {
            binary += "4";
        } else if (hex.equals("0101")) {
            binary += "5";
        } else if (hex.equals("0110")) {
            binary += "6";
        } else if (hex.equals("0111")) {
            binary += "7";
        } else if (hex.equals("1000")) {
            binary += "8";
        } else if (hex.equals("1001")) {
            binary += "9";
        } else if (hex.equals("1010")) {
            binary += "A";
        } else if (hex.equals("1011")) {
            binary += "B";
        } else if (hex.equals("1100")) {
            binary += "C";
        } else if (hex.equals("1101")) {
            binary += "D";
        } else if (hex.equals("1110")) {
            binary += "E";
        } else if (hex.equals("1111")) {
            binary += "F";
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

    private static String ip_permitution(String m) {
        String Ip = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Ip += m.charAt(ip[i][j] - 1);
            }
        }
        return Ip;

    }

    private static String encrypt(String L0, String R0, String ki) {
        LI = "";
        RI = "";

        String kxorR = "";
        String block = "";
        String after_s_box = "";
        String after_p_permution = "";
        String round_i = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {

                RI += R0.charAt(E[i][j] - 1);
            }
        }
        LI = R0;
        //xor
        for (int i = 0; i < ki.length(); i++) {
            if (RI.charAt(i) == ki.charAt(i)) {
                kxorR += 0;
            } else {
                kxorR += 1;
            }
        }
        //s-box
        block = kxorR.substring(0, 6);
        after_s_box += s_box(block, s1);
        block = "";
        block = kxorR.substring(6, 12);
        //System.out.print(block);
        after_s_box += s_box(block, s2);
        block = "";
        block = kxorR.substring(12, 18);
        after_s_box += s_box(block, s3);
        block = "";
        block = kxorR.substring(18, 24);
        after_s_box += s_box(block, s4);
        block = "";
        block = kxorR.substring(24, 30);
        after_s_box += s_box(block, s5);
        block = "";
        block = kxorR.substring(30, 36);
        after_s_box += s_box(block, s6);
        block = "";
        block = kxorR.substring(36, 42);
        after_s_box += s_box(block, s7);
        block = "";
        block = kxorR.substring(42, 48);
        after_s_box += s_box(block, s8);

        after_p_permution = p_pemution(after_s_box);

        //l xor f
        RI = "";

        for (int i = 0; i < after_p_permution.length(); i++) {
            if (L0.charAt(i) == after_p_permution.charAt(i)) {
                RI += 0;
            } else {
                RI += 1;
            }
        }

        round_i = RI + LI;

        return round_i;

    }

    private static String s_box(String block, String[][] s1) {
        char[] ch = block.toCharArray();
        String temp = "";
        String med = "";
        String four_bit_box = "";
        temp += ch[0];
        temp += ch[5];
        for (int i = 1; i < 5; i++) {
            med += ch[i];

        }
        int row = 0;
        for (int i = 0; i < 5; i++) {

            if (temp.equals(s1[i][0])) {
                row = i;
            }
        }
        int col = 0;
        for (int i = 0; i < 17; i++) {

            if (med.equals(s1[0][i])) {
                col = i;
            }

        }

        four_bit_box = hexToBinary_s_box(s1[row][col]);

        return four_bit_box;

    }

    private static String p_pemution(String after_s_box) {
        String P = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {

                P += after_s_box.charAt(p[i][j] - 1);
            }
        }
        return P;

    }

    private static String ip_1_pemution(String round16) {
        String P = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                P += round16.charAt(IP_1[i][j] - 1);
            }
        }
        return P;

    }
}
