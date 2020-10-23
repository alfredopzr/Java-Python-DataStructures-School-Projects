
public class SelectionSort {
 	static int comparisons = 0;
 	
    static void selectionSort(String[] array)
    {
         int smallindex;
         for(int i = 0; i < array.length; i++)
         {
              smallindex = i; // set first element as smallest
              for(int j = i + 1; j < array.length; j++) {
            	  // find smallest
            	  //comparisons++;
                  if(array[j].compareTo(array[smallindex]) < 0) {
               	   smallindex = j;
               	   comparisons++;
                  }
              }
              if(smallindex != i) {
            	  swap(array, smallindex, i);
              }
         }
    }

    static void swap(Object[] array, int index1, int index2)
    {
         Object temp = array[index1];
         array[index1] = array[index2];
         array[index2] = temp;
    }
}
