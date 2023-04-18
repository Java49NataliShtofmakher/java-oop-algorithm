package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		if (num1 % 2 == 0 && num2 % 2 == 0) {
			return num1 - num2;
		} else if (num1 % 2 != 0 && num2 % 2 != 0) {
			return num2 - num1;
		} else if (num1 % 2 == 0) {
			return -1;
		} else {
			return 1;
		}
	}

}
