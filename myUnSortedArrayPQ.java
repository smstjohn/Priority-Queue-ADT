//class for unsorted Array

import ch09.priorityQueues.*;
import java.util.Comparator;


public class myUnSortedArrayPQ<T> implements PriQueueInterface<T> {
   protected final int DEFCAP = 100; // default capacity
   protected T[] elements;           // array to hold priority queue’s elements
   protected int numElements = 0;    // number of elements in this priority queue
   
   protected Comparator<T> comp;

   public myUnSortedArrayPQ() {
   // Precondition: T implements Comparable
      elements = (T[]) new Object[DEFCAP];
      comp = new Comparator<T>() {
         public int compare(T element1, T element2) {
           return ((Comparable)element1).compareTo(element2);
         }
      };
    }
  
   public myUnSortedArrayPQ(Comparator<T> comp) {
      elements = (T[]) new Object[DEFCAP];
      this.comp = comp;
    }

  protected void enlarge() {
  // Increments the capacity of the priority queue by an amount 
  // equal to the original capacity.
  
   // Create the larger array.
   T[] larger = (T[]) new Object[elements.length + DEFCAP];
    
   // Copy the contents from the smaller array into the larger array.
   for (int i = 0; i < numElements; i++) {
      larger[i] = elements[i];
   }
    
   // Reassign priority queue reference.
   elements = larger;
  }

   public void enqueue(T element) {
   // Adds element to this priority queue.
    
      if (numElements == elements.length)
         enlarge();
      int index = numElements;
      elements[index] = element;
     
      numElements++;  
   }
  
   public T dequeue() {
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
  
      if (!isEmpty()) {
    
         T tempHighest = null;
         int temp = 0;
         for(int i=1; i <numElements; i++) {
            if (comp.compare(elements[temp], elements[i]) < 0){
               temp = i;
            }
         }
         tempHighest = elements[temp];
         // shifting elements
          for(int j = temp; j < elements.length - 1; j++){
              elements[j] = elements[j+1];
          }
         numElements--;
         return tempHighest;
       }
       else
         throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
   } 
  
   public int size() {
   // Returns the number of elements on this priority queue. 
      return numElements;
   }

   public boolean isEmpty() {
   // Returns true if this priority queue is empty; otherwise, returns false.
    return (numElements == 0);  
   }

   public boolean isFull() {
   // This priority queue is unbounded so always returns false.
    return false;
   }

   public String toString() {
   // Returns a nicely formatted string that represents this priority queue.
    
      String temp = "\nPriority Queue: ";
         for (int i = 0; i < numElements; i++)
            temp = temp + "  " + elements[i];
            temp = temp + "\n";
         return temp;
   }
}