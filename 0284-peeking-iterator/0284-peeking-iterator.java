class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer nextElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        nextElement = iterator.next(); // 先把nextElement拿到，此时 iterator 的元素永远少一个
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElement; 
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer returnedElement = nextElement;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }

        return returnedElement;
	}
	
	@Override
	public boolean hasNext() {
	    return nextElement != null; 
	}
}