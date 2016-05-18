import java.util.Random;
import java.util.Arrays;

class OddEven {
	public static void main(String[] args) {
		Integer[] array = new Integer[10];

		randomValues(array);

		System.out.println("Before: ");
		printArray(array);

		sort(array);

		System.out.println("After: ");
		printArray(array);
	}

	private static void sort(Integer[] arr) {
		int size = arr.length;

		for(int i = 0; i < size / 2; i++) {
			for(int j = 0; j < size; j += 2) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];

					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			for(int j = 1; j + 1 < size; j += 2) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];

					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	private static void randomValues(Integer[] arr) {
		Random random = new Random();

		for(int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(random.nextInt() % 100);
		}
	}

	private static void printArray(Integer[] arr) {
		(Arrays.asList(arr)).stream().forEach(System.out::println);
	}
}
