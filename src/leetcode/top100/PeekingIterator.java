package leetcode.top100;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
// Normal iterator only has next and hasNext. We want to add a peek functionality
// which gives next value without calling next. Hence we get the next value and return
// when peek is called. Then when next is called return peeked value and update next value.
class PeekingIterator implements Iterator<Integer> {
 Iterator<Integer> iter;
 Integer next;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
     if (iter.hasNext()) {
         next = iter.next();
     }
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tmp = next;
     next = iter.hasNext() ? iter.next() : null;
     return tmp;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}