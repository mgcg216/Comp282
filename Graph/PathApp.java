// Programmer: Michael Gerrard Guerrero
// Date: December 3, 2013
// Project 3
// Description: 
package Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


// path.java
// demonstrates shortest path with weighted, directed graphs
// to run this program: C>java PathApp


///////////////////////////////////////////////////////////
class PathApp
   {


   public static void main(String[] args) throws IOException, ClassNotFoundException
      {
          char letter1, letter2;
          int value1, value2, value3;
      Graph theGraph = new Graph();
      theGraph.addVertex('A');     // 0  (start)
      theGraph.addVertex('B');     // 1
      theGraph.addVertex('C');     // 2
      theGraph.addVertex('D');     // 3
      theGraph.addVertex('E');     // 4

      theGraph.addEdge(0, 1, 50);  // AB 50
      theGraph.addEdge(0, 3, 80);  // AD 80
      theGraph.addEdge(1, 2, 60);  // BC 60
      theGraph.addEdge(1, 3, 90);  // BD 90
      theGraph.addEdge(2, 4, 40);  // CE 40
      theGraph.addEdge(3, 2, 20);  // DC 20
      theGraph.addEdge(3, 4, 70);  // DE 70
      theGraph.addEdge(4, 1, 50);  // EB 50
      
            while(true)
         {

      System.out.println("Shortest paths");
      theGraph.path();             // shortest paths
      System.out.println();
      System.out.println("Change the weight of an edge, Add an edge, Delete an edge, Find path(s) from a vertex, Write or Read graph to disk and Quit the program");
      System.out.println("Enter the first capital letter.");
      char choice = getChar();
        switch(choice)
            {
            case 'C':
               System.out.print("From: ");
               letter1 = getChar();
               System.out.print("To: ");
               letter2 = getChar();
               System.out.print("Weight: ");
               value3 = getInt();
               theGraph.addEdge(commandNumber(letter1), commandNumber(letter2), value3);
               break;
            case 'A':
               System.out.print("From: ");
               letter1 = getChar();
               System.out.print("To: ");
               letter2 = getChar();
               System.out.print("Weight: ");
               value3 = getInt();


            if(theGraph.adjMat[commandNumber(letter1)][commandNumber(letter2)] == 1000000){
                   theGraph.addEdge(commandNumber(letter1), commandNumber(letter2), value3);
            } 
              else{
                 System.out.println("Not a valid input");
              }
               break;
            case 'D':
               System.out.print("From: ");
               letter1 = getChar();
               System.out.print("To: ");
               letter2 = getChar();
               System.out.print("Weight: ");
               value3 = getInt();
               theGraph.addEdge(commandNumber(letter1), commandNumber(letter2), 1000000);
               break;
            case 'F':
               System.out.print("From: ");
               letter1 = getChar();
               theGraph.path2(commandNumber(letter1));
               break;
            case 'Q':
               System.out.println("Exiting now");
               System.exit(1);
               break;
            case 'W':
                FileOutputStream fileOut =
                new FileOutputStream("/tmp/graph.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(theGraph);
                fileOut.close();
                System.out.printf("Serialized data is saved in /tmp/graph.ser");
                break;
            case 'R':
         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         theGraph = (Graph) in.readObject();
         in.close();
         fileIn.close();
                break;
            default:
               System.out.print("Invalid entry\n");
            }
         }
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
         public static int commandNumber(char command){
             int number = 0;
       if(command == 'A') {
         number = 0;
      }
      else if (command == 'B') {
         number = 1;
      }
      else if (command == 'C') {
         number = 2;
      }    
      else if (command == 'D') {
         number = 3;   
      }
      else if (command == 'E') {
         number = 4;
      }
             return number;
         }

   }  // end class PathApp
////////////////////////////////////////////////////////////////


