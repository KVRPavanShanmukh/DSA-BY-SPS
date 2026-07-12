package edu.ycp.cs201.sort;

import java.util.Comparator;

/**
 * Bubble sort algorithm.
 * 
 * @param <E> type of element to be sorted
 */
public class BubbleSort<E> implements Sort<E> {

	public void sort(Sequence<E> sequence, Comparator<E> comparator) {

		for (int end = sequence.size(); end > 0; end--) {
			
			for (int i = 0; i < end-1; i++) {
				
				E left = sequence.get(i);
				E right = sequence.get(i + 1);
				
				if (comparator.compare(left, right) > 0) {
					sequence.put(i, right);
					sequence.put(i + 1, left);
				}
				
			}
			
		}
		
	}
	
	public String toString() {
		return "Bubble Sort";
	}

}
