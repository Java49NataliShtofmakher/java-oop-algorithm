package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public void add(int index, T obj) {
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T res = array[index];

		System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
		return res;
	}

	@Override
	public T get(int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		T res = array[index];
		return res;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = indexOf(pattern);
		if (index > -1) {
			res = true;
			remove(index);
		}
		return res;
	}

	@Override
	public T[] toArray(T[] ar) {
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		System.arraycopy(array, 0, ar, 0, size);
		if (ar.length > size) {
			ar[size] = null;
		}

		return ar;
	}

	@Override
	public int indexOf(T pattern) {
		return indexOf(obj -> isEqual(obj, pattern));
	}

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

	@Override
	public int lastIndexOf(T pattern) {
		return lastIndexOf(obj -> isEqual(obj, pattern));
	}

	@Override
	public void sort() {
		Arrays.sort(array, 0, size);

	}

	@Override
	public void sort(Comparator<T> comp) {
		int size = size();

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 1; i < size; i++) {
				if (comp.compare(get(i - 1), get(i)) > 0) {
					T temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					flag = true;
				}
			}
			size--;
		}
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index--;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		int oldSize =size;
		int i = 0;
		while(i<size) {
			if(predicate.test(array[i])) {
				remove(i);
			}else {
				i++;
			}
		}
		
		return oldSize < size;
	}

}