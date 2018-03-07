/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Project0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 

public class Project0 {
    String firstname;
    String lastname;
    String email;
    int idnumber;
    String color;
    double balance;
           
    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File("instrdata.txt");
        Scanner input = new Scanner(inputFile);
        int arraySize = input.nextInt();
        input.nextLine();
        String[] strdata_array = new String[arraySize];
                for (int i = 0; i < strdata_array.length; i++){
            strdata_array[i] = input.nextLine();
        }
        System.out.print(strdata_array);
    }
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
}
