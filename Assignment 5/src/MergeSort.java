
public class MergeSort {
	static int comparisons = 0;
	
	public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
            
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }
	// end mergeSort


    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        while (i1 <= mid && i2 <= to) {
        	comparisons++;
			if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
            comparisons++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
            comparisons++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }
    
}

