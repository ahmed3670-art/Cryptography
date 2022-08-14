/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoalphabitc;

/**
 *
 * @author MaaDy
 */
public class Monoalphabitc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char org[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char org1[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char cipher[] = {'m', 'n', 'b', 'v', 'c', 'x', 'z', 'l', 'k', 'j', 'h', 'g', 'f', 'd', 's', 'a', 'p', 'o', 'i', 'u', 'y', 't', 'r', 'e', 'w', 'q'};
        char cipher1[] = {'M', 'N', 'B', 'V', 'C', 'X', 'Z', 'L', 'K', 'J', 'H', 'G', 'F', 'D', 'S', 'A', 'P', 'O', 'I', 'U', 'Y', 'T', 'R', 'E', 'W', 'Q'};

        System.out.println(encrypt("AbCd", org, cipher, org1, cipher1));
        System.out.println(decrypt("MnBv", org, cipher, org1, cipher1));
    }

    public static String encrypt(String plainText, char org[], char cipher[], char org1[], char cipher1[]) {
        String plain = "";

        for (int i = 0; i < plainText.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (plainText.charAt(i) >= 'A' && plainText.charAt(i) <= 'Z') {

                    if (plainText.charAt(i) == org1[j]) {
                        plain += cipher1[j];
                        break;
                    }

                } else {

                    if (plainText.charAt(i) == org[j]) {
                        plain += cipher[j];
                        break;
                    }

                }
            }

        }

        return plain;
    }

    public static String decrypt(String cipherText, char org[], char cipher[], char org1[], char cipher1[]) {
        String cipherr = "";

        for (int i = 0; i < cipherText.length(); i++) {
            for (int j = 0; j < 26; j++) {

                if (cipherText.charAt(i) >= 'A' && cipherText.charAt(i) <= 'Z') {
                    if (cipherText.charAt(i) == cipher1[j]) {
                        cipherr += org1[j];
                        break;
                    }
                } else {
                    if (cipherText.charAt(i) == cipher[j]) {
                        cipherr += org[j];
                        break;
                    }
                }

            }
        }

        return cipherr;
    }

}
