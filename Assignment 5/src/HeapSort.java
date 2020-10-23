
public class HeapSort<String extends Comparable<String>> {
	
	 private static final int CAPACITY = 2;
	 int comparisons = 0;

	   private int size;            // Number of elements in heap
	   private String[] heap;     // The heap array

	   public HeapSort()
	   {
	      size = 0;
	      heap = (String[]) new Comparable[CAPACITY];
	   }
	   public void Heap(String[] array)
	   {
	      size = array.length;
	      heap = (String[]) new Comparable[array.length+1];

	      System.arraycopy(array, 0, heap, 1, array.length);
	      
	      buildHeap();
	   }
	   
	   private void buildHeap()
	   {
	      for (int k = size/2; k > 0; k--)
	      {
	         percolatingDown(k);
	      }
	   }
	   private void percolatingDown(int k)
	   {
	      String tmp = heap[k];
	      int child;

	      for(; 2*k <= size; k = child)
	      {
	         child = 2*k;

	         if(child != size && heap[child].compareTo(heap[child + 1]) > 0) {
	        	 child++;
	        	 comparisons++;
	        	 
	         }
	         	

	         if(tmp.compareTo(heap[child]) > 0) {
	        	 heap[k] = heap[child];
	        	 comparisons++;
	         }
	         else {
	        	 break;
	         }
	      }
	      heap[k] = tmp;
	   }

	   public void heapSort(String[] array)
	   {
	      size = array.length;
	      heap = (String[]) new Comparable[size+1];
	      System.arraycopy(array, 0, heap, 1, size);
	      buildHeap();

	      for (int i = size; i > 0; i--)
	      {
	         String tmp = heap[i]; //move top item to the end of the heap array
	         heap[i] = heap[1];
	         heap[1] = tmp;
	         size--;
	         percolatingDown(1);
	      }
	      for(int k = 0; k < heap.length-1; k++)
	         array[k] = heap[heap.length - 1 - k];
	   }
}
