/* Michael Gerrard Guerrero
 * Computer Science 282 advance data structures
 * Project 3
 * Description: Simulate Changing 234Tree into BTree
 * November 19 2013
 */
package Tree;
////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataItem extends Tree234App
   {
   public long dData;          // one data item
   String record;
//--------------------------------------------------------------
   public DataItem(long dd)    // constructor
      { dData = dd; }
//--------------------------------------------------------------
   public void displayItem()   // display item, format "/27"
      { System.out.print("/"+dData); }
//--------------------------------------------------------------
       
   }  // end class DataItem
////////////////////////////////////////////////////////////////
