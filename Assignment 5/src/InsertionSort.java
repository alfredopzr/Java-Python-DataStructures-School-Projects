import java.util.Arrays;

public class InsertionSort {
	static int counter = 0;
	public static void insertionSort(Comparable[] objArray) {
		final long startTime = System.nanoTime();
		
		for(int i = 0; i< objArray.length; i++) {
			Comparable objectToSort = objArray[i];
			int j = i;
			counter++;
			while(j > 0 && objArray[j-1].compareTo(objectToSort) > 0) {
				counter++;
				if(objArray[j-1].compareTo(objectToSort) > 0) {					
				}
				objArray[j] = objArray[j-1];
				j--;
			}
			objArray[j]= objectToSort;
		}
	}
	
}
