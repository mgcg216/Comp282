/* Michael Gerrard Guerrero
 * Computer Science 282 advance data structures
 * Project 1
 * Description: Simulate Disk Hashtables
 * September 26 2003
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiskPackage;



/*******************************************************
 *
 * Project #1 - Starter code  Command Line Interface version
 *
 *  Hash disk file project
 *
 * copyright 2004 Christopher C. Ferguson
 *
 ****************************************************/


import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;



  
  //Making Text Commands into Int 
 class Project1 {
  public static final int RECORDSIZE = 512;
  public static final int SECTORSIZE = 4096;
  public static final int NUMSECTORS = 256;
  public static final int HASHSIZE = 1001;
  public static final int BUCKETSIZE = 4;

  private  FakeDisk theDisk = new FakeDisk();   // our fake disk drive
  private  boolean openFlag = false;
  
  private String path; //Use this for FileReader

   // main method
  Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, IOException{

        Project1 tpo = new Project1();
        tpo.showMenu();
   }


    // Create and show a menu
  private void showMenu() throws FileNotFoundException, IOException{
   String command = "meh";
   int number = 0;
   // function should loop until the user exits
   
   // read input from user

   while(!command.equals("Exit")){
   System.out.print("Enter a Command  1) Open DB  2) View a bucket  3) Close DB  4) Import a file 5) Exit: ");
   command = scan.nextLine();
   number = commandNumber(command);

   // call processCommand
      processCommand(number);
   }
}
  //This figures out the number line
  int readLines() throws IOException {
      FileReader file_to_read = new FileReader(path);
      BufferedReader bf = new BufferedReader(file_to_read);
      
      String aLine;
      int numberOfLines = 0;
      
      while (( aLine = bf.readLine())!= null) {
          numberOfLines++;
      }
      bf.close();
      
      return numberOfLines;
  }

  //String Splitter (Didn't use)
  public String split(String splito) {
      String output = splito.split(",")[0];
      return output;
  }
  //Making Text Commands into Int 
  public static int commandNumber(String command){
      String a = "Open DB", b = "View a bucket", c = "Close DB", d ="Import a file", e ="Exit", f ="1", g ="2",h ="3",i ="4",j ="5",k="6",l="7",m="8",n="9",o="0";
      int number = 0;
      if(command.equals(a) ) {
         number = 1;
      }
      else if (command.equals(b)) {
         number = 2;
      }
      else if (command.equals(c)) {
         number = 3;
      }    
      else if (command.equals(d)) {
         number = 4;   
      }
      else if (command.equals(e)) {
         number = 5;
      }
      else if (command.equals(f)) {
         number = 1;
      }
      else if (command.equals(g)) {
         number = 2;
      }
      else if (command.equals(h)) {
         number = 3;
      }    
      else if (command.equals(i)) {
         number = 4;   
      }
      else if (command.equals(j)) {
         number = 5;
      }
      else if (command.equals(k)) {
         number = 6;
      }
      else if (command.equals(l)) {
         number = 7;
      }
      else if (command.equals(m)) {
         number = 8;
      }
      else if (command.equals(n)) {
         number = 9;
      }
      else if (command.equals(o)) {
         number = 0;
      }
      else{
         System.out.println("Not a valid input.");
      }
      return number;
  }

    //Layer byte into string
 public String openFileToString(byte[] _bytes){
    String file_string = "";
    for(int i = 0; i < _bytes.length; i++){
        file_string += (char)_bytes[i];
    }
    return file_string;    
}

    //Read Strings 
 public String[] openString(String _string) throws IOException{
     File inputFile = new File(_string);
     Scanner input = new Scanner(inputFile);
     String[] strdata_array = new String[readLines()];
                for (int i = 0; i < readLines(); i++){
            strdata_array[i] = input.nextLine();
        }
     return strdata_array;
 }
    //Spliting byte array (didnt use)
public static byte[][] divideArray(byte[] source, int chunksize) {


        byte[][] ret = new byte[(int)Math.ceil(source.length / (double)chunksize)][chunksize];

        int start = 0;

        for(int i = 0; i < ret.length; i++) {
            ret[i] = Arrays.copyOfRange(source,start, start + chunksize);
            start += chunksize ;
        }

        return ret;
    }
    // Sorting the String (didnt use)
     public static void sortstrings(String x[]){
        String temp;
        for (int i = 0; i<x.length -1; i++){
            for (int j=i+1; j<x.length; j++){
                if(x[i].compareToIgnoreCase(x[j])>0){
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
    }
    // processCommand

    public void processCommand(int commandnumber) throws FileNotFoundException, IOException{

       // Load the file name in the text field
        String dbfilename = "meh";
        String sNumber = "dfu";
        int sectornumber = 0;
        if (/*command is open DB*/commandnumber == 1) {
          // get dbfilename from user
            System.out.print("Please enter the name of the file: ");
            dbfilename = scan.nextLine();
          // use FakeDisk to open the dbfilename (or disk)
            String a ="dbase1.txt", b ="dbase2.txt", c ="dbase3.txt";
          //check for errors
            if (dbfilename.equals(a)||dbfilename.equals(b)||dbfilename.equals(c)) {
                theDisk.openDisk(dbfilename, true);
                
            }
            else {
                System.out.println("Not a valid filename.");
            }
        }
        else if (/*command is view bucket*/commandnumber == 2 ) {
          // get a bucket number from user
            System.out.print("Please enter the sector number: ");
            sNumber = scan.nextLine();
            sectornumber = commandNumber(sNumber);
            // verify a database is open
            byte[] readSector = theDisk.readSector(sectornumber);
            System.out.println(openFileToString(readSector));
        }
        else if (/*command is close DB*/commandnumber == 3 ) {
          // close the disk/file
            theDisk.closeDisk();
            System.out.println("Disk closed.");
        }
        else if (/*command is import*/commandnumber == 4 ) {
          // get dbfilename from user
            System.out.print("What is the name of the file? ");
            dbfilename = scan.nextLine();
            File outputFile = new File(dbfilename);
            PrintWriter output = new PrintWriter(outputFile);
            
            
          // get import text file name from user
            System.out.print("What is the name of text file? ");
            path = scan.nextLine();
            byte[] nameByteArray = Arrays.toString(openString(path)).getBytes("UTF-8");

            theDisk.openDisk(dbfilename, true);
            for (int i=0; i<250; i++){
                for (int j =0; j <4; j++){
                theDisk.writeSector((i+j), nameByteArray);
                }
                break;
            }
            
          // import the text file, create the data base file, check for errors
          // DO NOT implement until phase 2
        }
         else if (/*command is exit*/commandnumber == 5 ) {
          // this should be easy
             System.exit(0);
        }

    }


 // EVERYONE, PLEASE USE THE SAME HASH FUNCTION, DO NOT CHANGE
public static int hashFunc3(String key) {
  int hashval = 0;
  for (int j=0; j< key.length(); j++) {
    int letter = key.charAt(j) - 96;
    if (letter > 0 ) {
      hashval = (hashval * 27 + letter) % HASHSIZE;
    }
  }
  return hashval / BUCKETSIZE;
}

// new variables for project 2

public class BinaryRecord {
     String emailaddress;
	 int bucketnumber;
	 int leftchild = -1;
	 int rightchild = -1;
}

private int lastrecord = 0;
public static final int MAXRECORDS = 1000;
BinaryRecord [] binarytree = new BinaryRecord[ MAXRECORDS ];

// A new method for project 2, call when inserting NEW item into hash bucket

   public void insertBinaryTree(String email, int bucket) {      // inserts ONE item/row
        // creates a 2-D binary tree (rows and cols.)
        BinaryRecord record = new BinaryRecord();  // will ADD this record
        record.emailaddress = email;
        record.bucketnumber = bucket;
        if (lastrecord == 0) {  // this is the root?
          binarytree[lastrecord] = record;  //make it the root
          lastrecord = lastrecord + 1; //bump row in table for NEXT record
        }
        else {
            int current = 0;  // start at the root
            int parent;
            while (true) {     // loop will exit using return below
			
              parent = current;                                 // this 'may' be parent to new node
              if (email.compareToIgnoreCase(binarytree[current].emailaddress) <= 0) {
                // new email is LESS then the parent 
                current = binarytree[current].leftchild;        // go lefty, less then
                if (current == -1) {                            // this is a NULL child, leaf reached
                   binarytree[parent].leftchild = lastrecord;   // parent points to new child
                   binarytree[lastrecord] = record;             // new row added to table
                   lastrecord = lastrecord + 1;                 // bump row in table for NEXT record
                   return;
                }
              }
              else {
                //new email is GREATER then parent
                current = binarytree[current].rightchild;      // go right, greater then
                if (current == -1) {                           // this is a NULL child, leaf reached
                   binarytree[parent].rightchild = lastrecord; // parent points to new child
                   binarytree[lastrecord] = record;            // new row added to table
                   lastrecord = lastrecord + 1;                // bump row in table for NEXT record
                   return;
                }
              }
            }
        }
   } // end insertBinaryTree

}       // end of class Project1

