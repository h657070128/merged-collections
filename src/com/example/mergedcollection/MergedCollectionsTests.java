package com.example.mergedcollection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MergedCollectionsTests {

	@Test
	void test() {
		Integer[] a = new Integer[]{1,3,5,7,9,17,43};
		Integer[] b = new Integer[]{2,4,6,8,10,44,55,88};
		Collection<Integer> merged = MergedCollections.sort(Arrays.asList(a), Arrays.asList(b), new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		Iterator<Integer> it = merged.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		assertTrue(isSorted(merged));
		

		Set<Integer> aSet = new LinkedHashSet<Integer>(a.length);
		for (int i = 0; i < a.length ; i++) {
			aSet.add(a[i]);
		}
		Set<Integer> bSet = new LinkedHashSet<Integer>(b.length);
		for (int i = 0; i < b.length ; i++) {
			bSet.add(b[i]);
		}
		Collection<Integer> mergedSet = MergedCollections.sort(aSet, bSet, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		Iterator<Integer> itSet = mergedSet.iterator();
		while (itSet.hasNext()) {
			System.out.println(itSet.next());
		}
		assertTrue(isSorted(mergedSet));
	}
	
	public static boolean isSorted(Collection<Integer> collection) {
	    if (collection.size() == 0 || collection.size() == 1) {
	        return true;
	    }
	 
	    Iterator<Integer> it = collection.iterator();
	    Integer current, previous = it.next();
	    while (it.hasNext()) {
	        current = it.next();
	        if (previous.compareTo(current) > 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}

}
