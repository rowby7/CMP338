
public class LinearSearch implements SearchInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int search(int[] listOfNumbers, int target) {
		int key = target;
		for(int i = 0; i < listOfNumbers.length; i++) {
				if(listOfNumbers[i] == key) {
					return i;
				}
		}
		return -1;
	}

}