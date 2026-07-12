package edu.ycp.cs201.sort;

import java.util.Comparator;

public class MergeSort<E> implements Sort<E> {
	public void sort(Sequence<E> sequence, Comparator<E> comparator) {
		GenericSequence<E> tmp = new GenericSequence<E>(sequence.size());
		
		mergeSort(sequence, 0, sequence.size(), comparator, tmp);
	}

	private void mergeSort(Sequence<E> sequence,
			int start, int len,
			Comparator<E> comparator,
			GenericSequence<E> tmp) {
		
		if (len < 2) return;
		
		int half = len / 2; 
		
		mergeSort(sequence, start, half, comparator, tmp);
		mergeSort(sequence, start + half, len - half, comparator, tmp);
		merge(sequence, start, half, start + half, len - half, comparator, tmp);
		
		for (int i = start; i < start + len; i++) {
			sequence.put(i, tmp.get(i));
		}
		
	}

	private void merge(Sequence<E> sequence,
			int leftStart,
			int leftLen,
			int rightStart,
			int rightLen,
			Comparator<E> comparator,
			GenericSequence<E> tmp) {
		
		int left = leftStart;
		int right = rightStart;
		
		int j = leftStart;
		
		while ( left < leftStart + leftLen || right < rightStart + rightLen ) {
			
			if ( left == leftStart + leftLen ) {
				tmp.put(j++, sequence.get(right++));
			} else if (right == rightStart + rightLen ) {
				tmp.put(j++, sequence.get(left++));
			} else {
				if (comparator.compare(sequence.get(left), sequence.get(right)) < 0) {
					tmp.put(j++, sequence.get(left++));
				} else {
					tmp.put(j++, sequence.get(right++));
				}
				
			}
			
		}
		
	}
	
	public String toString() {
		return "Merge Sort";
	}

}
