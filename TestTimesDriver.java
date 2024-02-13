import java.util.Arrays;

public class TestTimesDriver {
    public static void main(String[] args) {
        TestTimes testTimes = new TestTimes();

        // Add some test times
        for (int i = 1; i <= 15; i++) {
            testTimes.addTestTime(i * 1000000000L); // nanoseconds
        }

        // Print the last test time
        System.out.println("Last test time: " + testTimes.getLastTestTime() + " ns");

        // Print all test times
        System.out.println("All test times: " + Arrays.toString(testTimes.getTestTimes()));

        // Print the average test time
        System.out.println("Average test time: " + testTimes.getAverageTestTime() + " ns");

        // Reset test times
        testTimes.resetTestTimes();
        System.out.println("After reset, all test times: " + Arrays.toString(testTimes.getTestTimes()));
    }
}
