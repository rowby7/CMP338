import java.util.Random;

public class SortDriver implements SortDriverInterface {

    @Override
    public Integer[] createArray(ArrayType arrayType, int arraySize) {
        Integer[] array = new Integer[arraySize];
        Random random = new Random();

        switch (arrayType) {
            case Equal:
                int equalValue = random.nextInt();
                for (int i = 0; i < arraySize; i++) {
                    array[i] = equalValue;
                }
                break;
            case Random:
                for (int i = 0; i < arraySize; i++) {
                    array[i] = random.nextInt();
                }
                break;
            case Increasing:
                for (int i = 0; i < arraySize; i++) {
                    array[i] = i;
                }
                break;
            case Decreasing:
                for (int i = 0; i < arraySize; i++) {
                    array[i] = arraySize - i;
                }
                break;
            case IncreasingAndRandom:
                int increasingPart = (int) (arraySize * 0.9);
                int randomPart = arraySize - increasingPart;

               
                for (int i = 0; i < increasingPart; i++) {
                    array[i] = i;
                }

                for (int i = increasingPart; i < arraySize; i++) {
                    array[i] = random.nextInt(10000);
                }
                break;
        }
        return array;
    }

    @Override
    public Object[] runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
        TestTimes testTimes = new TestTimes();
        SortInterface sorter;
        Object[] result = new Object[numberOfTimes*2+1];
        switch (sortType) {
            case BubbleSort:
                sorter = new BubbleSort();
                break;
            case SelectionSort:
                sorter = new SelectionSort();
                break;
            case InsertionSort:
                sorter = new InsertionSort();
                break;
            default:
                throw new IllegalArgumentException("Invalid sort type");
        }

        for (int i = 0; i < numberOfTimes; i++) {
            Integer[] arrayToSort = createArray(arrayType, arraySize);
            Integer[] arrayCopy = arrayToSort.clone(); // Make a copy of the unsorted array

            
            long startTime = System.nanoTime();
            sorter.sort(arrayToSort);
            long endTime = System.nanoTime();

            testTimes.addTestTime(endTime - startTime);

            result[i*2] = arrayCopy; 
            result[i*2+1] = arrayToSort; 
        }

        result[numberOfTimes*2] = testTimes; 

        return result;
    }

    public static void main(String[] args) {
        SortDriver sortDriver = new SortDriver();
        ArrayType[] arrayTypes = ArrayType.values();
        SortType[] sortTypes = SortType.values();
        int[] arraySizes = {1000, 10000};

        for (SortType sortType : sortTypes) {
            for (ArrayType arrayType : arrayTypes) {
                for (int arraySize : arraySizes) {
                    System.out.println(sortType + ", " + arrayType + ", " + arraySize);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    Object[] result = sortDriver.runSort(sortType, arrayType, arraySize, 10);
                    for (int i = 0; i < result.length; i++) {
                        if (result[i] instanceof TestTimes) {
                            TestTimes testTimes = (TestTimes) result[i];
                            long[] times = testTimes.getTestTimes();
                            double averageTime = testTimes.getAverageTestTime();
                            for (long time : times) {
                                System.out.printf("%10d ", time);
                            }
                            System.out.println("   " + averageTime);
                        }
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }

}