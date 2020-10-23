// The CharImage class will store the private data structure which must be some form of a
// two-dimensional array (lots of choices here). It must also have public methods to read an
// image from standard input, find the connected components, and write the results to standard
// output. Other public and private methods may be included accordingly per your solution
// (i.e. sorting method, tabulation method, etc.).

// Two pass pseudocode:
// algorithm TwoPass(data) is
//     linked = []
//     labels = structure with dimensions of data, initialized with the value of Background
  
//     First pass
  
//     for row in data do
//         for column in row do
//             if data[row][column] is not Background then
  
//                 neighbors = connected elements with the current element's value
  
//                 if neighbors is empty then
//                     linked[NextLabel] = set containing NextLabel
//                     labels[row][column] = NextLabel
//                     NextLabel += 1
  
//                 else
  
//                     Find the smallest label
  
//                     L = neighbors labels
//                     labels[row][column] = min(L)
//                     for label in L do
//                         linked[label] = union(linked[label], L)
  
//     Second pass
  
//     for row in data do
//         for column in row do
//             if data[row][column] is not Background then
//                 labels[row][column] = find(labels[row][column])
  
//     return labels


//This algorithm uses the union-find data structure which provides excellent performance for keeping track of equivalence relationships.[13] Union-find essentially stores labels which correspond to the
//same blob in a disjoint-set data structure, making it easy to remember the equivalence of two labels by the use of an interface method
//E.g.: findSet(l). findSet(l) returns the minimum label value that is equivalent to the function argument 'l'.

// Once the initial labeling and equivalence recording is completed, the second pass merely replaces each pixel label with its equivalent disjoint-set representative element.


// The important part here seems to be the data structure representing the disjoint set (union-find): a list of list of ints, indexed by the label.

// In lines 30-35, since it has no neighbours, it is assigning itself a value and adding itself to it's own lone set. 
// This same cell/pixel can later on be 'unioned' with another list when it is deemed a neighbour in lines 41-49. This will happen in a later iteration.

// On the first pass:

// Iterate through each element of the data by column, then by row (Raster Scanning)
// If the element is not the background
// Get the neighboring elements of the current element
// If there are no neighbors, uniquely label the current element and continue
// Otherwise, find the neighbor with the smallest label and assign it to the current element
// Store the equivalence between neighboring labels

// On the second pass:

// Iterate through each element of the data by column, then by row
// If the element is not the background
// Relabel the element with the lowest equivalent label
// Here, the background is a classification, specific to the data, used to distinguish salient elements from the foreground. If the background variable is omitted, then the two-pass algorithm will treat the background as another region.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {

    public int[][] labeledMatrix; //Array of links
    public int currentLetter = (char)65;

    public ConnectedComponents(int[][] matrix) {
        ArrayList<ArrayList<Integer>> linked = new ArrayList<ArrayList<Integer>>();
        int[][] labels = new int[matrix.length][matrix[0].length]; //Matrix is the input array
        int NextLabel = 0;

       // First pass, (assigns temporary labels and record equivalences)

        for(int x=0; x<matrix.length; x++) {
            for(int y=0; y<matrix[0].length; y++) { //Iterate through length of column (y)
                if(matrix[x][y] == '*') { // If the pixel is a background pixel, skip background until it has a value of 1 (not 0) (or any other criteria)
                  checkConnected(x,y);
                  currentLetter++;
                	
                    //Construct Neighbors list
                    ArrayList<Integer> neighbors = new ArrayList<Integer>(); //Connected elements with the current element's value
                    //Checks pixels N,S,E,W of the current pixel           

                    //If there are no neighbors, uniquely label the current element and continue
                    if(neighbors.isEmpty()) { //if it has no neighboring pixels of the same value, use new label
                        ArrayList<Integer> tempArrayList = new ArrayList<Integer>();//Temporary array to add to linked array list
                        tempArrayList.add(NextLabel);//add current label to a temporary array
                        linked.add(NextLabel, tempArrayList);//add what the label is and the temporary array
                        labels[x][y] = NextLabel;// adds label to the current pixel of the array
                        NextLabel++; //Increment label for next pass through
                    }
                  
                    //Otherwise, find the neighbor with the smallest label and assign it to the current element
                    //the label value that was the smallest for a given region "floods" throughout the connected region and gives two distinct labels, and hence two distinct labels.
                    else {
                        labels[x][y]=1000*1000;
                        for(int neighbor : neighbors) { //for each neighbor of the current pixel
                            if(neighbor < labels[x][y]) labels[x][y] = neighbor;// if neighbor is less than the label, then add the neighbor to the current label
                        }
                        //Store the equivalence between neighboring labels
                        for(int neighbor : neighbors) {//for each neighbor of the current pixel
                            linked.set(neighbor,union(linked.get(neighbor),neighbors));                              
                 }
               }
            }
          }
       }

        //Second pass
        for(int x=0; x<matrix.length; x++) {
            for(int y=0; y<matrix[0].length; y++) {
                ArrayList<Integer> EquivalentLabels = linked.get(labels[x][y]);
                labels[x][y]=1000*1000;
                //for each label in equivalent labels
                for(int label : EquivalentLabels) {
                  //if the element is not in the background
                    if(label < labels[x][y]){
                      //relabel the element with the lowest equivalent label
                      labels[x][y] = label;
                    }
                }
            }
        }
        labeledMatrix = labels;
    }

  
//union: http://stackoverflow.com/questions/5283047/intersection-and-union-of-arraylists-in-java
    public <T> ArrayList<T> union(ArrayList<T> list1, ArrayList<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public int[][] getLabeledMatrix() {
        return labeledMatrix;
    }
  
    public void checkConnected(int r, int c) {
        //must be recursive
        //checks connected pixels for more * symbols
        if (matrix[r][c] == '*'){
            //increment current group
            groupsize++;
            //assign a letter to the current pixel to prevent overcounting
            matrix[r][c] = currentLetter;
            
    try{
        //checks north
            checkConnected(r-1, c);
            //checks west
            checkConnected(r, c-1);
            //checks south
            checkConnected(r+1, c);
            //checks east
            checkConnected(r, c+1);
    }catch(Exception e) {
            //System.out.println("error at index ("+r+", "+c+")");
        	}
        }
    }
  

    public static void main(String[] args) {
        int[][] matrix = {
          {0,0,1,0,0,0,0},
          {1,0,1,1,1,0,1},
          {0,0,1,0,1,0,0},
          {0,0,0,1,0,0,0},
          {0,1,0,0,1,0,0},
          {0,1,1,0,0,1,0},
          {1,0,1,1,0,0,0}
        };
      
        ConnectedComponents matrixComponents = new ConnectedComponents(matrix);
        int[][] newMatrix = matrixComponents.getLabeledMatrix();

        System.out.println("{");
        for(int x=0; x<newMatrix.length; x++) {
            System.out.print("{");
            for(int y=0; y<newMatrix[0].length; y++) {
                if(y != newMatrix[0].length-1)
                    System.out.print(newMatrix[x][y]+", ");
                else
                    System.out.print(newMatrix[x][y]);
            }
            if(x != newMatrix.length-1)
                System.out.println("},");
            else
                System.out.println("}");
        }
        System.out.print("}");
    }
}