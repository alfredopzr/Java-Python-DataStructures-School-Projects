import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
	char[][][] matrix;
    //the number of test cases
	int test_cases;
	int z;
	int m;
	int counter;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	
	public Solution() {
	  
		readFile();
		setLabels();
		outputFinal();
		
	}
    
  //Method for reading the txt file from standard input
   void readFile(){
	  
     //Scanner to read from standard input
	   Scanner scanner = new Scanner(System.in);
	   
			   //Getting the number of test cases
			   z = scanner.nextInt();
         //Getting the dimensions of the required arrays
			   int d = scanner.nextInt();
			   int f = scanner.nextInt();
			   String text = scanner.toString();

			   matrix = new char[z][d][f];
			   int b = 1;
			   //Building 3d array to be used in recursion
			   for (int i = 0; i <z; i++)
			   {
			     for(int j = 0; j < d; j++){
			       for(int k = 0; k < f; k++){
			        matrix[i][j][k] = text.charAt(b);  
			        b++;
			       }
			     }
			   }
   }
   //Method to color the pixels
   void setLabels(){
       this.m = 65;
        //For loop to iterate through all individual pixels in 3d array
       for( z=0; z<test_cases; z++){
       for(int y=0; y<matrix[0].length; y++){
           for(int x=0; x<matrix[0][1].length; x++){
             //Bounds checks
        	   if((y<0)|| (y>matrix[0].length)|| (x<0)|| ( x>matrix[0][1].length - 1)) {
        		   return;
        		   }
        		   else {
                 //Make recursive call to count total connected components
        			   counter += findNeighbors(x,y,m++);
                 map.put(counter, counter);
        		   }      
            }   
           }
       }
   }
   //Recursive Method, find item in array which is equal to *
   //Check N, S, E, W neighbors of that pixel recursively
   int findNeighbors(int i, int j, int m){
       if(matrix[z][i][j] == '*'){
           char r = (char)m;
           matrix[test_cases][i][j] = r;
           //recursive call for each of the 4 directions of current pixel:
           //N, S, E, W
           return 1 + findNeighbors(i-1,j,m) + findNeighbors(i,j-1,m) + findNeighbors(i,j+1,m) + findNeighbors(i+1, j, m);   
           
       }
       return 0;
   }
      //Output method
   void outputFinal() {
	   //Changing the array into a String
	   //Output method still needs to be fixed
	   String formattedString = matrix.toString();
	   
	   System.out.println(formattedString);
	   for (Integer name : this.map.keySet()) {
		    System.out.println(name);
		}
     System.out.println(matrix);
   }
}
