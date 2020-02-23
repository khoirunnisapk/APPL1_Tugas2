/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CopyingAFile;

/**
 *
 * @author User
 */
import java.util.*;
import java.io.*;

public class Copy {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        String fileName;
        File file;
        boolean found = false;
        while(!found){
            Scanner sc = new Scanner(System.in);
            System.out.println("file name: ");
            fileName = sc.next();
            try {
                 file = new File("D:\\UPUT\\KULIAH\\SEMESTER4\\APPL\\"+fileName+".txt");
                 Scanner scanFile = new Scanner(file);
                 String line;
                 while(scanFile.hasNext()){
                     line = scanFile.nextLine();
                     System.out.println(line);
                 }
                 System.out.println("found!!");
                 found = true;
            }catch(FileNotFoundException exception) {
                          
            }
        }
        
    }
    
}
