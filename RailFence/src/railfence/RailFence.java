/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railfence;

/**
 *
 * @author MaaDy
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RailFence {

    static String g_data = "";
    static String g_data1="";

    public RailFence(File keyFile) throws Exception {
        try {

            Scanner myReader = new Scanner(keyFile);
            while (myReader.hasNextLine()) {
                g_data += myReader.nextLine();
                //  System.out.print(g_data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       // System.out.print(g_data);
    }

    public File encrypt(File plainTextFile) throws Exception {
        //read
        try {

            Scanner myReader = new Scanner(plainTextFile);
            while (myReader.hasNextLine()) {
                g_data1 += myReader.nextLine();
               // System.out.println(g_data1);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //encrypt
         
        g_data1="jjjjjj";
        System.out.print(g_data1);

        
        
        //(write in file)
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\MaaDy\\Desktop\\cipher\\RailFence\\plain.txt");
            myWriter.write(g_data1);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }

    public File decrypt(File cipherTextFile) throws Exception {
        return null;
    }

    public static void main(String[] args) throws Exception {
        File key = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\RailFence\\key.txt");
        File plian = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\RailFence\\plain.txt");
        RailFence base = new RailFence(key);
        base.encrypt(plian);

    }

}
