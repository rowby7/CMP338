
public class BinarySearch implements SearchInterface {

	
	
	
	
	
	
	@Override
	public int search(int[] listOfNumbers, int target) {
		int low = 0;
		int mid = 0;
		int high = listOfNumbers.length-1;
		
		while (low <= high) {
			mid = (high + low)/2;
			if(target == listOfNumbers[mid]) {
				return mid;
			}
			else if(target > listOfNumbers[mid]) {
				
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
			
			
			
		}
		return -1;
	}

}