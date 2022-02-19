import java.util.NoSuchElementException;

/* File: Queue2.java
 * 
 * A generic queue class with methods isEmpty, append, and serve.  The queue 
 * is implemented as a circular array which is resized if it becomes full.
 * 
 * Warning: an attempt to serve an empty queue will throw a                       
 * NoSuchElementException 
*/

/**
 * A generic queue class 
*/
public class Queue2<E>
{
   private E[] elements ;        // queue is implemented as a generic array
   private int currentSize ;     // number of items in the queue
   private int head ;            // index of first item in queue
   private int tail ;            // index of last item in queue
   private static final int INITIAL_SIZE = 5 ; // initial number of elements

   /**
      Constructs an empty queue.
   */
   public Queue2() 
   {      
      elements = (E[]) new Object[INITIAL_SIZE];
      currentSize = 0;
      head = 0;
      tail = 0;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty, false if non-empty
   */
   public boolean isEmpty() 
   { 
      return currentSize == 0 ; 
   }

   /**
      Appends an element to the tail of this queue.
      @param newElement the element to add
   */
   public void append(E newElement)
   {
      if (currentSize == elements.length)    // resize array if full
         resize() ;
      currentSize++ ;                        // one more item will be appended
      elements[tail] = newElement ;          // new item goes at end 
      tail = (tail + 1) % elements.length ;  // deal with "wraparound"
   }

   /**
      Removes an element from the head of this queue.
      Precondition: queue must be non-empty
      @return the removed element
   */
   public E serve() 
   {
      if (currentSize == 0) throw new NoSuchElementException() ;
      E removed = elements[head] ;              // save item at head of queue
      head = (head + 1) % elements.length ;     // compute new head
      currentSize-- ;                           // one less item in queue
      return removed ;                          // return item formerly at head
   }

   /**
      Resizes the array if the queue is full
   */
   private void resize()
   {
      // create another array with additional INITIAL_SIZE elements
      E[] newElements = (E[]) new Object[elements.length + INITIAL_SIZE] ;
         
      // copy all elements of this array to new array, beginning at index 0 
      for (int i = 0; i < elements.length ; i++) 
      { 
        newElements[i] = elements[(head + i) % elements.length]; 
      }      
      elements = newElements ;      // point this array at new array
      head = 0 ;                    // reset head index to 0
      tail = currentSize ;          // reset tail index to number of 
                                    // items in the queue (one greater than
                                    // index of last item)
   }
   
   /**
    * Return the queue as a string
    * @return the items in the queue
    */
   public String toString()
   {
      String out = "" ;
      for (int i = 0 ; i < currentSize ; i++ )
      {
         out += elements[ (head + i) % elements.length ] + "  " ;
      }
      return out ;
   }
}