
public class InsertionSort implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
	    int numbersSize = arrayToSort.length;
	    for (int i = 1; i < numbersSize; ++i) {
	        int j = i;
	       
	        
	        while (j > 0 && arrayToSort[j] < arrayToSort[j - 1]) {
	            
	            int temp = arrayToSort[j];
	            arrayToSort[j] = arrayToSort[j - 1];
	            arrayToSort[j - 1] = temp;
	            --j;
	        }
	    }
	}


}
