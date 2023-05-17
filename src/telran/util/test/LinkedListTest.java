package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;

class LinkedListTest extends ListTest {

	@Override
	protected <T> List<T> getList() {
		return new LinkedList<>();
	}

	
}