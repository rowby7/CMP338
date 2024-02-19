
public class SearchDriver implements SearchDriverInterface {

	
	public static void main(String[] args) {
		
		
		
	}

	@Override
	public int[] getListOfNumbers() {
		int [] numbers = new int[10000000];
		for(int i = 0; i < numbers.length; i++) {
			
			numbers[i] = i + 1;
		}
		return numbers;
	}

	@Override
	public int[] getTargets() {
		
		return new int []{500,10000,100000,1000000,5000000,7500000,10000000};
		
	}

	@Override
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		
		LinearSearch linearSearch = new LinearSearch();
		
		TestTimes testTimes = new TestTimes();
		 for (int i = 0; i < numberOfTimes; i++) {
		        long startTime = System.nanoTime();
		        linearSearch.search(listOfNumbers, target);
		        
		        long endTime = System.nanoTime();
		        testTimes.addTestTime(endTime - startTime);
		    }

		    return testTimes;
		}

	@Override
	public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		BinarySearch binarySearch = new BinarySearch();
	    TestTimes testTimes = new TestTimes();

	    for (int i = 0; i < numberOfTimes; i++) {
	        long startTime = System.nanoTime();
	        binarySearch.search(listOfNumbers, target);
	        
	        long endTime = System.nanoTime();
	        testTimes.addTestTime(endTime - startTime);
	    }

	    return testTimes;
	}
}
