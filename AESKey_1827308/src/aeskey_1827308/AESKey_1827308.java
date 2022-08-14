/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeskey_1827308;

import java.util.Scanner;

/**
 *
 * @author MaaDy
 */
public class AESKey_1827308 {

    /**
     * @param args the command line arguments
     */
    static String s_box[][] = {{"asd", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"},
    {"0", "63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe", "d7", "ab", "76"},
    {"1", "ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72", "c0"},
    {"2", "b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"},
    {"3", "04", "c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"},
    {"4", "09", "83", "2c", "1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"},
    {"5", "53", "d1", "00", "ed", "20", "fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"},
    {"6", "d0", "ef", "aa", "fb", "43", "4d", "33", "85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"},
    {"7", "51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc", "b6", "da", "21", "10", "ff", "f3", "d2"},
    {"8", "cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e", "3d", "64", "5d", "19", "73"},
    {"9", "60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de", "5e", "0b", "db"},
    {"a", "e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4", "79"},
    {"b", "e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"},
    {"c", "ba", "78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"},
    {"d", "70", "3e", "b5", "66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"},
    {"e", "e1", "f8", "98", "11", "69", "d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"},
    {"f", "8c", "a1", "89", "0d", "bf", "e6", "42", "68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"}};
    static String rcon[] = {"01000000", "02000000", "04000000", "08000000", "10000000", "20000000", "40000000", "80000000", "1b000000", "36000000"};

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the intial key");
        String key = in.next();

        //for speed test
        // String key = "2b7e151628aed2a6abf7158809cf4f3c";
        String key1 = key_gen(key, rcon[0]);
        String key2 = key_gen(key1, rcon[1]);
        String key3 = key_gen(key2, rcon[2]);
        String key4 = key_gen(key3, rcon[3]);
        String key5 = key_gen(key4, rcon[4]);
        String key6 = key_gen(key5, rcon[5]);
        String key7 = key_gen(key6, rcon[6]);
        String key8 = key_gen(key7, rcon[7]);
        String key9 = key_gen(key8, rcon[8]);
        String key10 = key_gen(key9, rcon[9]);

    }

    private static String key_gen(String key, String rcoon) {
        int round;
        int x = 0;
        int y = 2;
        String arr_key[][] = new String[4][4];
        String temp_keys = key;
        String binary_key = "";
        String l_f_xor = "";
        String w0 = "";
        String w1 = "";
        String w2 = "";
        String w3 = "";
        String tempp = "";
        String bin_rcoon = "";
        //key in arr
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                arr_key[j][i] = key.substring(x, y);
                x += 2;
                y += 2;
            }

        }
        //shiftig last col
        String temp = arr_key[0][3];
        for (int i = 0; i < 3; i++) {

            arr_key[i][3] = arr_key[i + 1][3];

        }
        arr_key[3][3] = temp;

        //subbytes
        int row = 0;
        int col = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 17; j++) {
                if (s_box[j][0].charAt(0) == arr_key[i][3].charAt(0)) {
                    row = j;
                }
                if (s_box[0][j].charAt(0) == arr_key[i][3].charAt(1)) {
                    col = j;
                }
            }
            arr_key[i][3] = s_box[row][col];

        }
        //
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // System.out.println(arr_key[j][i]);
                tempp += arr_key[j][i];
            }

        }
        //convert from hex to binary
        binary_key = hex_to_binary(tempp);
        bin_rcoon = hex_to_binary(rcoon);
        //    System.out.print(binary_key);

        //xor last col with first
        l_f_xor = xor_l_f(binary_key);

        //xor l_f_xor with rcon and get w0
        w0 = xor(l_f_xor, bin_rcoon);

// get w1
        w1 = xor(hex_to_binary(temp_keys.substring(8, 16)), w0);
//get w2
        w2 = xor(hex_to_binary(temp_keys.substring(16, 24)), w1);
//get w3
        w3 = xor(hex_to_binary(temp_keys.substring(24, 32)), w2);
//convert to dec

        w0 = binary_to_dec(w0);
        w1 = binary_to_dec(w1);
        w2 = binary_to_dec(w2);
        w3 = binary_to_dec(w3);
        System.out.println(w0 + "\n" + w1 + "\n" + w2 + "\n" + w3);

        return w0 + w1 + w2 + w3;

    }

    private static String hex_to_binary(String hex) {
        String binary = "";

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
            } else if (hex.charAt(i) == 'a') {
                binary += "1010";
            } else if (hex.charAt(i) == 'b') {
                binary += "1011";
            } else if (hex.charAt(i) == 'c') {
                binary += "1100";
            } else if (hex.charAt(i) == 'd') {
                binary += "1101";
            } else if (hex.charAt(i) == 'e') {
                binary += "1110";
            } else if (hex.charAt(i) == 'f') {
                binary += "1111";
            }

        }
        return binary;

    }

    private static String xor_l_f(String binary_key) {
        String first_col = binary_key.substring(0, 32);
        String last_col = binary_key.substring(96, 128);
        String after_xor = "";
        for (int i = 0; i < first_col.length(); i++) {
            if (first_col.charAt(i) == last_col.charAt(i)) {
                after_xor += 0;
            } else {
                after_xor += 1;
            }
        }

        return after_xor;
    }

    public static String binary_to_dec(String hex) {

        String binary = "";
        int start = 0;
        int end = 4;
        for (int i = 0; i < 8; i++) {
            if (hex.substring(start, end).equals("0000")) {
                binary += "0";
            } else if (hex.substring(start, end).equals("0001")) {
                binary += "1";
            } else if (hex.substring(start, end).equals("0010")) {
                binary += "2";
            } else if (hex.substring(start, end).equals("0011")) {
                binary += "3";
            } else if (hex.substring(start, end).equals("0100")) {
                binary += "4";
            } else if (hex.substring(start, end).equals("0101")) {
                binary += "5";
            } else if (hex.substring(start, end).equals("0110")) {
                binary += "6";
            } else if (hex.substring(start, end).equals("0111")) {
                binary += "7";
            } else if (hex.substring(start, end).equals("1000")) {
                binary += "8";
            } else if (hex.substring(start, end).equals("1001")) {
                binary += "9";
            } else if (hex.substring(start, end).equals("1010")) {
                binary += "a";
            } else if (hex.substring(start, end).equals("1011")) {
                binary += "b";
            } else if (hex.substring(start, end).equals("1100")) {
                binary += "c";
            } else if (hex.substring(start, end).equals("1101")) {
                binary += "d";
            } else if (hex.substring(start, end).equals("1110")) {
                binary += "e";
            } else if (hex.substring(start, end).equals("1111")) {
                binary += "f";
            }
            start += 4;
            end += 4;
            if (end > hex.length()) {
                break;
            }
        }
        return binary;
    }

    public static String xor(String col_1, String col_2) {
        String val = "";
        for (int i = 0; i < col_1.length(); i++) {
            if (col_1.charAt(i) == col_2.charAt(i)) {
                val += 0;
            } else {
                val += 1;
            }
        }

        return val;

    }
}
