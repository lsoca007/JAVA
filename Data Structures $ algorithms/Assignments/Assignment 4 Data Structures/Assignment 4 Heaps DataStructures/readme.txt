Luis David Socarras


Java standard PriorityQueue⟨⟩ is more efficient than MyBinaryHeap. Through all my tests the java implementation results to be about 5-10 percent faster. MyBinaryheap uses min-heap properties and provides an efficient implementation of a priority queue but Java PriorityQueue⟨⟩ ensure O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add); linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size). 


Output:

Java PriorityQueue, 40110869 ns
MyBinaryHeap, 42691417 ns

Java PriorityQueue, 39538709 ns
MyBinaryHeap, 43456564 ns

Java PriorityQueue, 38307111 ns
MyBinaryHeap, 40967995 ns


