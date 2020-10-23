import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project5 {
	
	public static void main(String[] args)
    {
		InsertionSort insertion = new InsertionSort();
		SelectionSort selection = new SelectionSort();
		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		HeapSort heap = new HeapSort();
		
		
        Scanner scan = new Scanner(System.in);
 
        System.out.println("\nUser Input: ");
        
        String input = scan.next();
        
        int numOfWords = Integer.parseInt(input);
        String[] wordList = new String[numOfWords]; 
        
        
        for(int i = 0; i<numOfWords; i++) {
        	wordList[i] = scan.next();
        }
        String[] wordList1 = wordList;
        String[] wordList2 = wordList;
        String[] wordList3 = wordList;
        String[] wordList4 = wordList;
        String[] wordList5 = wordList;
        
        //Call for Selection Sort 
        long selectionStartTime = System.nanoTime();
        selection.selectionSort(wordList1);
        double selectionElapsedTime = (System.nanoTime() - selectionStartTime) / 1000000.0;
        System.out.println("_________________SELECTION SORT___________________");

        System.out.printf("Total execution time is %.2f ms\n", selectionElapsedTime);
        System.out.println("Number of Comparisons: " + selection.comparisons);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //Call for Insertion Sort
        long insertionStartTime = System.nanoTime();
        insertion.insertionSort(wordList2);
        double insertionElapsedTime = (System.nanoTime() - insertionStartTime) / 1000000.0;
        System.out.println("_________________INSERTION SORT___________________");
        System.out.printf("Total execution time is %.2f ms\n", insertionElapsedTime);
        System.out.println("Number of Comparisons: " + insertion.counter);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        //Call for Merge Sort
        long mergeStartTime = System.nanoTime();
        merge.mergeSort(wordList3, 0, wordList3.length - 1);
        double mergeElapsedTime = (System.nanoTime() - mergeStartTime) / 1000000.0;
        System.out.println("_________________MERGE SORT_______________________");
        System.out.printf("Total execution time is %.2f ms\n", mergeElapsedTime);
        System.out.println("Number of Comparisons: " + merge.comparisons);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        //Call for Quick Sort
        long quickStartTime = System.nanoTime();
        quick.sorting(wordList4, 0, wordList4.length - 1);
        double quickElapsedTime = (System.nanoTime() - quickStartTime) / 1000000.0;
        System.out.println("_________________QUICK SORT_______________________");
        System.out.printf("Total execution time is %.2f ms\n", quickElapsedTime);    
        System.out.println("Number of Comparisons: " + quick.comparisons);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //Call for HeapSort
        long heapStartTime = System.nanoTime();
        heap.heapSort(wordList5);
        double heapElapsedTime = (System.nanoTime() - heapStartTime) / 1000000.0;
        System.out.println("_________________HEAP SORT___________________");
        System.out.printf("Total execution time is %.2f ms\n", heapElapsedTime);
        System.out.println("Number of Comparisons: " + heap.comparisons);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
}

