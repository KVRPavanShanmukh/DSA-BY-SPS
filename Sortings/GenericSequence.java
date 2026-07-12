package edu.ycp.cs201.sort;

public class GenericSequence<E> implements Sequence<E> {
	private Object[] storage;
	
	public GenericSequence(int size) {
		storage = new Object[size];
	}

	public int size() {
		return storage.length;
	}

	public void put(int index, E value) {
		storage[index] = value;
	}

	public E get(int index) {
		return (E) storage[index];
	}

	public void swap(int index1, int index2) {
		E left = get(index1);
		E right = get(index2);
		put(index2, left);
		put(index1, right);
	}

}
