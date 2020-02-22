/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RWFile;

/// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
 // --------------------------------------------------------------------
 
// Reads student data (name, semester hours, quality points) from a
 // text file, computes the GPA, then writes data to another file
 // if the student is placed on academic warning.
    
 // --------------------------------------------------------------------
 public static void main (String[] args)
 {
    int creditHrs = 0; // number of semester hours earned
    double qualityPts = 0; // number of quality points earned
    double gpa; // grade point (quality point) average
    String line, name, inputName = "students.dat";
    String outputName = "warning.dat"; 
    File fileMhs = new File("D:\\UPUT\\KULIAH\\SEMESTER4\\APPL\\Student.dat");
    File fileWarn = new File("D:\\UPUT\\KULIAH\\SEMESTER4\\APPL\\Warning.dat");
    try {
    // Set up scanner to input file
     Scanner sc = new Scanner(fileMhs);
    // Set up the output file stream
     PrintWriter outFile = new PrintWriter(fileWarn);
    // Print a header to the output file
        outFile.println ();
        outFile.println ("Students on Academic Warning");
        outFile.println ();
    // Process the input file, one token at a time
         while(sc.hasNext()){
           name= sc.next();
           creditHrs = sc.nextInt();
           qualityPts = sc.nextDouble();
          
           
           gpa = qualityPts/creditHrs;
            line = name + " " + creditHrs + " " + gpa;
             if(creditHrs<30){
                  if(gpa<1.5){
                     outFile.println(line);
                  }
             } else if(creditHrs<60 && creditHrs>30){
                  if(gpa<1.75){
                     outFile.println(line);
                  }
            } else {
                  if(gpa<2.0){
                    outFile.println(line);
                  }
            }

        }
         
        outFile.close();
     } catch (FileNotFoundException exception) {
        System.out.println ("The file " + inputName + " was not found.");
     } catch (IOException exception) {
        System.out.println (exception);
     } catch (NumberFormatException e) {
        System.out.println ("Format error in input file: " + e);
        }
 }
} 
