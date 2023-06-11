package telran.algorithm.recursion;

public class LineRecursion {

	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		long res = 1;
		if (n > 1) {
			res = n * factorial(n - 1);
		}
		return res;
	}

	public static long pow(int a, int b) {
//		if(b<0) {
//			throw new IllegalArgumentException();
//		}
//		long res = 1;
//		if(b>0) {
//			res = a*pow(a,b-1);
//		}
//		return res;

		////////////////////////
		// Limitations:
		if (b < 0) {
			throw new IllegalArgumentException("Exponent must be non-negative");
		}
		if (b == 0) {
			return 1;
		}
		return a * pow(a, b - 1);
	}

	public static long sum(int[] array) {
		return sum(0, array);
	}

	private static long sum(int firstIndex, int[] array) {
		long sum = 0;
		if (firstIndex < array.length) {
			sum = array[firstIndex] + sum(firstIndex + 1, array);
		}
		return sum;
	}

	public static int[] reverse(int[] array) {
		return reverse(array, 0, array.length - 1);
	}

	private static int[] reverse(int[] array, int left, int right) {

		if (left < right) {
			array[left] = array[left] + array[right];
			array[right] = array[left] - array[right];
			array[left] = array[left] - array[right];
			reverse(array, left + 1, right - 1);
		}
		return array;
	}

	public static long square(int x) {
		if (x == 0) {
			return 0;
		}
		if (x < 0) {
			x = -x;
		}
		int oddAdjustment = (x % 2 == 0) ? 0 : x;
		int half = x / 2;
		return (square(half) * 4) + (oddAdjustment * (half * 2)) + 1;
	}

	public static boolean isSubstring(String string, String substr) {
		if (substr.length() > string.length()) {
			return false;
		}
		if (substr.isEmpty()) {
			return true;
		}
		if (string.charAt(0) == substr.charAt(0)) {
			if (string.substring(0, substr.length()).equals(substr)) {
				return true;
			}
		}
		return isSubstring(string.substring(1), substr);
	}
}
