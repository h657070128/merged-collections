package com.example.mergedcollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class MergedCollections {

	public static <E> Collection<E> sort(Collection<E> a, Collection<E> b, Comparator<E> comparator) {
		Collection<E> merged;
		if (a instanceof List) {
			merged = new ArrayList<E>(a.size() + b.size());
		} else {
			merged = new LinkedHashSet<E>(a.size() + b.size());
		}
			
        Iterator<E> aI = a.iterator();
    	E aNext = aI.hasNext() ? aI.next() : null;
        Iterator<E> bI = b.iterator();
    	E bNext = bI.hasNext() ? bI.next() : null;
        while (aNext != null && bNext != null) {
    		if (comparator.compare(aNext, bNext) < 0) {
    			merged.add(aNext);
    			if (aI.hasNext()) {
        			aNext = aI.next();
    			} else {
    				aNext = null;
    			}
    		} else {
    			merged.add(bNext);
    			if (bI.hasNext()) {
        			bNext = bI.next();
    			} else {
    				bNext = null;
    			}
    		}
        }
        while (aNext != null) {
        	merged.add(aNext);
        	if (aI.hasNext()) {
        		aNext = aI.next();
        	} else {
        		aNext = null;
        	}
        }
        while (bNext != null) {
        	merged.add(bNext);
        	if (bI.hasNext()) {
        		bNext = bI.next();
        	} else {
        		bNext = null;
        	}
        }
        return merged;
    }

}
