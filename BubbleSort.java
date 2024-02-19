
public class BubbleSort implements SortInterface{

	@Override
	public void sort(Integer[] arrayToSort) {
	    int numbersSize = arrayToSort.length;
	    for (int i = 0; i < numbersSize - 1; i++) {
	        for (int j = 0; j < numbersSize - i - 1; j++) {
	            if (arrayToSort[j] > arrayToSort[j+1]) {
	                int temp = arrayToSort[j];
	                arrayToSort[j] = arrayToSort[j + 1];
	                arrayToSort[j + 1] = temp;
	            }
	        }
	    }
	}


	
	
}
