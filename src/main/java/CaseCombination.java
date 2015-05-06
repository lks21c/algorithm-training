public class CaseCombination {
	static int[] printNumbers = null;

	public static void main(String[] args) {

		int[] test = new int[] { 1, 2, 3, 4 };
		printNumbers = new int[test.length];
		numberOfCase(test, 0);
	}

	public static void print(int[] nums) {
		String print = "";
		for (int i = 0; i < nums.length; i++) {
			print += nums[i];
		}

		System.out.println(print);
	}

	public static void numberOfCase(int[] numbers, int index) {
		if (index >= numbers.length) {
			print(printNumbers);
			return;
		}

		printNumbers[printNumbers.length - numbers.length] = numbers[index];

		int[] temp = new int[numbers.length - 1];

		int position = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i == index) {
				continue;
			}

			temp[position++] = numbers[i];

		}

		index++;

		numberOfCase(temp, 0);

		if (index < numbers.length) {
			numberOfCase(numbers, index);
		}
	}

}
