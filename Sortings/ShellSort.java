package edu.ycp.cs201.sort;

import java.util.Comparator;

/**
 * Shell sort algorithm.
 * 
 * @param <E> type of element to be sorted
 */
public class ShellSort<E> implements Sort<E> {

	public void sort(Sequence<E> sequence, Comparator<E> comparator) {
		for (int gap = sequence.size() / 2;
				gap > 0;
				gap = (gap == 2) ? 1 : (int) (gap / 2.2)) {
			

			for (int start = 0; start < gap; start++) {
				
				// Do an insertion sort of elements starting at i separated by gap elements
				
				for (int p = start + gap; p < sequence.size(); p += gap) {
					
					E cur = sequence.get(p);
					int j = p;
					
					for (; j > start && comparator.compare(cur, sequence.get(j - gap)) < 0; j -= gap) {
						sequence.put(j, sequence.get(j - gap));
					}
					sequence.put(j, cur);
					
				}
				
				
			}
			
//			for (int i = gap; i < sequence.size(); i++) {
//				
//				E tmp = sequence.get(i);
//				int j = i;
//				
//				for ( ; j >= gap && comparator.compare(tmp, sequence.get(j - gap)) < 0; j -= gap) {
//					sequence.put(j, sequence.get(j - gap));
//				}
//				sequence.put(j, tmp);
//			}
			
		}
	}
	
	public String toString() {
		return "Shell Sort";
	}
//	
//	public static void main(String[] args) {
//		
//		IntSequence sequence = new IntSequence(20);
//		
//		Random random = new Random();
//		for (int i = 0; i < sequence.size(); i++) {
//			sequence.put(i, random.nextInt(100));
//		}
//		
//		dump("Before sorting", sequence);
//		
//		ShellSort<Integer> shellSort = new ShellSort<Integer>();
//		shellSort.sort(sequence, new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		
//		dump("After sorting", sequence);
//		
//	}
//
//	private static void dump(String msg, IntSequence sequence) {
//		System.out.println(msg + ":");
//		for (int i = 0; i < sequence.size(); i++) {
//			if (i > 0)
//				System.out.print(", ");
//			System.out.print(sequence.get(i));
//		}
//		System.out.println();
//	}

}
