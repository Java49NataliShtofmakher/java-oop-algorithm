package telran.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import telran.util.ArrayList;
import telran.util.List;

public class PrimitiveStreams {

	public static int[] randomUnique(int nNumbers, int minInclusive, int maxExclusive) {

		if (maxExclusive - minInclusive < nNumbers) {
			throw new IllegalArgumentException();
		}
		return new Random().ints(minInclusive, maxExclusive).distinct().limit(nNumbers).toArray();
	}

	public static int[] shuffle(int[] array) {
		List<Integer> list = new ArrayList<>();
		new Random().ints(0, array.length).distinct().limit(array.length)
		.forEach(i -> list.add(array[i]));
		
		return list.stream().mapToInt(n -> n).toArray();
	}
}
