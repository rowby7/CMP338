import java.util.Arrays;

public class TestTimes implements TestTimesInterface{

	
	private static final int MAX_TEST_TIMES = 10;
	private long[] testTimes = new long[MAX_TEST_TIMES];
	private int testTimeCount = 0;
	
	public static void main(String[] args) {

		

	}

	@Override
	public long getLastTestTime() {
		
	    if (testTimeCount > 0) {
	    	
	        return testTimes[testTimeCount - 1];
	        
	    } 
	    else {
	    	
	        return 0;
	    }
	    
	}

	@Override
	public long[] getTestTimes() {
		
	    long[] times = new long[MAX_TEST_TIMES];
	    int start = testTimeCount < MAX_TEST_TIMES ? 0 : testTimeCount - MAX_TEST_TIMES;
	    System.arraycopy(testTimes, start, times, 0, Math.min(testTimeCount, MAX_TEST_TIMES));
	    return times;
	    
	    
	}

	@Override
	public void resetTestTimes() {
	    testTimes = new long[MAX_TEST_TIMES];
	    testTimeCount = 0;
	}

	@Override
	public void addTestTime(long testTime) {
		
		
		if (testTimeCount < MAX_TEST_TIMES) {
	        testTimes[testTimeCount] = testTime;
	        testTimeCount++;
	    } else {
	   
	        for (int i = 0; i < MAX_TEST_TIMES - 1; i++) {
	            testTimes[i] = testTimes[i + 1];
	        }
	        testTimes[MAX_TEST_TIMES - 1] = testTime;
	    }
		
	}

	
	@Override
	public double getAverageTestTime() {
	    if (testTimeCount == 0) {
	        return 0;
	    }
	    long sum = 0;
	    for (int i = 0; i < testTimeCount; i++) {
	        sum += testTimes[i];
	    }
	    return (double) sum / testTimeCount;
	}

}

