package edu.ycp.cs201.sort;

import java.util.Comparator;

/**
 * Insertion sort algorithm.
 *
 * @param <E> type of element to be sorted
 */
public class InsertionSort<E> implements Sort<E> {

	public void sort(Sequence<E> sequence, Comparator<E> comparator) {
		for (int p = 1; p < sequence.size(); p++) {
			
			E cur = sequence.get(p);
			int j = p;
			
			for (; j > 0 && comparator.compare(cur, sequence.get(j - 1)) < 0; j--) {
				sequence.put(j, sequence.get(j - 1));
			}
			
			sequence.put(j, cur);
			
		}
	}

	public String toString() {
		return "Insertion Sort";
	}
	
}
