package telran.algorithm.recursion.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.algorithm.recursion.LineRecursion;

class LineRecursionTest {

	@Test
	@Disabled
	void test() {
		f(6);
	}

	private void f(int a) {
		if (a > 5) {
			f(a - 1);
		}
	}

	@Test
	void factorialTest() {
		assertEquals(6, LineRecursion.factorial(3));
		assertEquals(24, LineRecursion.factorial(4));
	}
	
	@Test
void powTest() {
		assertEquals(100,LineRecursion.pow(10,2));
		assertEquals(1000,LineRecursion.pow(10,3));
		assertEquals(-1000,LineRecursion.pow(-10,3));
	}
}
