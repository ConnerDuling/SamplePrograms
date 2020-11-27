public class flipping {
	public static void main(String[] args) {

		// Good morning! Here's your coding interview problem for today. Given a list,
		// sort it using this method: reverse(lst, i, j), which reverses lst from i to j.

		int max_size = 20;

		int[] characters = new int[max_size];
		for (int i = 0; i < max_size; i++) {
			characters[i] = i;
			System.out.print(characters[i] + ", ");
		}
		System.out.println();

		int result = flipCall(characters, 0, 5);
		if (result == 1) {
			System.out.print("Invald indexes given, program stopped.");
			return;
		}

		for (int i = 0; i < max_size; i++) {
			System.out.print(characters[i] + ", ");
		}
	}

	/*
	 * flipCall class implpiments desired functionality by starting at the given
	 * indexes and working inwards via increment and decrement of indexes until i
	 * and j meet.
	 */
	public static int flipCall(int[] array, int i, int j) {

		if (i < 0 || j < 0 || i > array.length - 1 || j > array.length - 1) {
			return 1;
		}

		while (j > i) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		return 0;
	}
}
