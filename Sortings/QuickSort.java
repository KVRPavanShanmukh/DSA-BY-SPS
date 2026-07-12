package edu.ycp.cs201.sort;

import java.util.Comparator;

/**
 * Quick sort algorithm.
 *
 * @param <E> type of element to be sorted
 */
public class QuickSort<E> implements Sort<E> {

	public void sort(Sequence<E> sequence, Comparator<E> comparator) {
		doQuickSort(sequence, 0, sequence.size(), comparator);
	}

	private static<E> void doQuickSort(Sequence<E> sequence, int start, int len, Comparator<E> comparator) {
		if (len < 2) {
			return;
		}
		if (len == 2) {
			swapIfOOO(sequence, start, start+1, comparator);
			return;
		}
		if (len == 3) {
			// Bubble sort
			swapIfOOO(sequence, start, start+1, comparator);
			swapIfOOO(sequence, start+1, start+2, comparator);
			swapIfOOO(sequence, start, start+1, comparator);
			return;
		}
		
		int mid = partition(sequence, start, len, comparator);
		doQuickSort(sequence, start, mid - start, comparator);
		doQuickSort(sequence, mid+1, ((start+len) - mid) - 1, comparator);
	}
	
	private static<E> void swapIfOOO(Sequence<E> sequence, int lhs, int rhs, Comparator<E> comparator) {
		if (comparator.compare(sequence.get(lhs), sequence.get(rhs)) > 0) {
			sequence.swap(lhs, rhs);
		}
	}
	
	private static<E> int partition(Sequence<E> sequence, int start, int len, Comparator<E> comparator) {
		// choose pivot as middle element
		int mid = start + (len / 2);
		E pivot = sequence.get(mid);
		
		// last index in range
		int lastIndex = (start + len) - 1;
		
		// stash pivot in last element in range
		sequence.swap(mid, lastIndex);

		// Partition the elements.
		int left = start;
		int right = lastIndex - 1;
		while (left <= right) {
			// Left index refers to an element that should be in the left partition?
			if (left < lastIndex && comparator.compare(sequence.get(left), pivot) < 0) {
				left++;
				continue;
			}
			
			// Right index refers to an element that should be in the right partition?
			if (right >= start && comparator.compare(sequence.get(right), pivot) >= 0) {
				right--;
				continue;
			}
			
			// Swap left and right
			sequence.swap(left, right);
		}
		
		// Swap elements at left and lastIndex (where pivot was stashed).
		sequence.swap(left, lastIndex);
		
		// Left index now contains the pivot.
		// Everything to its left is < than the pivot, and
		// everything to its right is >= than the pivot.
		return left;
	}

	public String toString() {
		return "Quick Sort";
	}
}
