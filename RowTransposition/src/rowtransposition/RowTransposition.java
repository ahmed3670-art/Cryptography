/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowtransposition;

/**
 *
 * @author MaaDy
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RowTransposition {

    /**
     * @param args the command line arguments
     */
      public RowTransposition(File keyFile) throws Exception {
           try {
            
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                 g_data = myReader.nextLine();
              
               
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
  }

  public File encrypt(File plainTextFile) throws Exception {
    return null;
  }

  public File decrypt(File cipherTextFile) throws Exception {
    return null;
  }
    public static void main(String[] args) {
        // TODO code application logic here
        File input = new File("C:\\Users\\MaaDy\\Desktop\\cipher\\wheel chiphr\\Wheel.txt");
    }
    
}
