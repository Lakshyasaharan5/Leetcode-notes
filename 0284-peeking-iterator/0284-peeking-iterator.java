// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    /**
    
        1 2 3 
              i

        c = 3

     */
    Iterator<Integer> it;
    Integer curr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
        this.curr = it.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {        
        return curr;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {    
        Integer t = curr;
        if (it.hasNext())    
	        curr = it.next();
        else 
            curr = null;
        return t;
	}
	
	@Override
	public boolean hasNext() {
	    return curr != null || it.hasNext();
	}
}