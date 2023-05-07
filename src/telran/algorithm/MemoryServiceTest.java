package telran.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MemoryServiceTest {

	byte[] array;

	@Test
	void test() {

		int size = MemoryService.getMaxAvailableSize();
		array = new byte[size];
		boolean flException = false;

		try {
			array = null;
			array = new byte[size + 1];
		} catch (OutOfMemoryError e) {
			flException = true;
		}
		assertTrue(flException);

	}

	@Test
	void allocationMemoryTest() {
		byte[] array;
		Runtime runtime = Runtime.getRuntime();
		while (true) {
			displayMemoryMap(runtime);
			long freeMemory = runtime.freeMemory();
			int size = freeMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) freeMemory;
			array = new byte[size];
		}
	}

	@Test
	void allocationMemoryTestNoGc() {
		List<byte[]> list = new ArrayList<>();
		Runtime runtime = Runtime.getRuntime();
		try {
			while (true) {
				long freeMemory = runtime.freeMemory();
				int size = freeMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE : 
															(int) freeMemory;
				list.add( new byte[size]);
			}
		} catch (OutOfMemoryError e) {

		}
	}

	private void displayMemoryMap(Runtime runtime) {
		System.out.printf("free memory: %d, total memory: %d, maximal memory %d\n", runtime.freeMemory(),
				runtime.totalMemory(), runtime.maxMemory());

	}

}
