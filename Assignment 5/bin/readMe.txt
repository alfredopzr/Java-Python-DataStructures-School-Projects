My program receives an array of strings and sorts them lexiographically.

Project5.java:
This is the entrance to the program. All classes containing sorting algorithms get called from this
class. The Project5.java class also handles the timing of runtime of each individual algorithm.
All outputs are handled in this class.

SelectionSort.java:
The SelectionSort.java class implements Selection Sort on a string array. Selection Sort runs in O(n^2) time.
It contains the selectionSort Method and the swap method. SelectionSort handles comparisons and swap handles
the movement within the array.

InsertionSort.java:
The InsertionSort.java class implements Insertion Sort on a string array. Insertion Sort runs in O(n^2) time.
InsertionSort includes the insertionSort method. This method handles the comparisons and relabeling of items in array.


MergeSort.java:
The MergeSort.java class implements Merge Sort on a string array. Merge Sort runs in O(n log n ) time.
MergeSort includes the merge and mergeSort methods. MergeSort is a recursive method which itself, and once
sorting is completed it is merged with the merge method.

QuickSort.java:
The QuickSort.java class implements Quick Sort on a string array. Quick Sort runs in O(n log n) time.
QuickSort includes the sorting method and the swap method. The sorting method does the comparisons between
elements, and swap does the changing of positions.

HeapSort.java:
The HeapSort.java class implements Heap Sort on a string array. Heap Sort runs in O(n log n ) time.
HeapSort includes the heapSort method, build Heap and heapForm. This is also a comparison based
algorithm.

