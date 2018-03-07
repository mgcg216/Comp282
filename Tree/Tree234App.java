/* Michael Gerrard Guerrero
 * Computer Science 282 advance data structures
 * Project 3
 * Description: Simulate Changing 234Tree into BTree
 * November 19 2013
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

// tree234.java
// demonstrates 234 tree
// to run this program: C>java Tree234App
import java.io.*;
import java.util.Scanner;



public class Tree234App
   {
    protected static Tree234 theTree;
    protected static FakeDisk FDisk;
   public static void main(String[] args) throws IOException
      {
      long value;
      Tree234 theTree = new Tree234();
      
      theTree.insert(50);
      theTree.insert(40);
      theTree.insert(60);
      theTree.insert(30);
      theTree.insert(70);

      while(true)
         {
         System.out.print("Enter first letter of ");
         System.out.print("show, insert, find, change order, read, write, view ,or quit: ");
         char choice = getChar();
         switch(choice)
            {
            case 's':
               theTree.displayTree();
               break;
            case 'i':
               System.out.print("Enter value to insert: ");
               value = getInt();
               theTree.insert(value);
               break;
            case 'f':
               System.out.print("Enter value to find: ");
               value = getInt();
               int found = theTree.find(value);
               if(found != -1)
                  System.out.println("Found "+value);
               else
                  System.out.println("Could not find "+value);
               break;
            case 'c' :
                System.out.print("Enter value for order: ");
                value = getInt();
                theTree.root.setOrder((int) value);
                if (value == 4) {
                    theTree = new Tree234();
                    break;
                }
                else if (value > 4) {
                    theTree = new BTree();
                    break;
                }
                else {
                    System.out.println("Not a valid value");
                }
                break;
            case 'r' :
                System.out.print("Enter filename to read: ");
                readData();
            case 'w' :
                writeData();
                break;
            case 'v':
                break;
            case 'q':
                System.out.println("Exiting now");
                System.exit(1);
                break;
            default:
               System.out.print("Invalid entry\n");
            }  // end switch
         }  // end while
      }  // end main()
//--------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//--------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }

//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
    
//-------------------------------------------------------------
          public static void readData() throws FileNotFoundException, IOException{
           System.out.println( "What is the name of the text file to import.");
           String path = getString();
           char answer;
           int answer2;
        File inputFile = new File(path);
        Scanner input = new Scanner(inputFile);
        
        System.out.print("Do you want to change the order? Yes or No");
        answer = getChar();
        switch (answer) {
        case 'y' :
            System.out.print("What is the Order?");
            answer2 = getInt();
            theTree.root.setOrder(answer2);
            break;
        
        case 'n' :
            theTree = new Tree234();
            break;
        
        }
        while(input.hasNext()) {
            String record = input.nextLine();
            String key = record.substring(0, record.indexOf(","));
            long thekey = Long.parseLong(key);
            theTree.insert(thekey);
        }
       } 
          public static void writeData(){
              FDisk = new FakeDisk();
              FDisk.openDisk("btree.db",true);
              FDisk.closeDisk();
              FDisk.writeSector(sectornumber, buffer);
          }

   }  // end class Tree234App
////////////////////////////////////////////////////////////////

