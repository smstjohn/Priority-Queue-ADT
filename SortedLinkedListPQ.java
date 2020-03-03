//implement the Priority Queue ADT using a Sorted Linked List and sort in decreasing order

import ch09.priorityQueues.*;
import java.util.Comparator;
import support.LLNode;

public class SortedLinkedListPQ<T> implements PriQueueInterface<T>  {

   protected LLNode<T> front;     // reference to the front of this queue
   protected LLNode<T> rear;      // reference to the rear of this queue
   protected LLNode<T> previous;   // node preceding location
   protected int numElements = 0; // number of elements in this queue
   protected Comparator<T> comp;

   public SortedLinkedListPQ() {
      front = null;
      rear = null;
   }

   public void enqueue(T element) {
   // Adds element to this priority queue.
  
      LLNode<T> newNode = new LLNode<T>(element);
      LLNode<T> currNode = front;
      int compare;
      previous = null;

      if ( this.isEmpty() ) {
         front = newNode;
         numElements++;
      } else {
         while (currNode != null) {
            compare = Integer.compare((int)newNode.getInfo(), (int)currNode.getInfo());

            // if they're equal attach to currNode
            if (compare == 0) {
               newNode.setLink(currNode.getLink());
               currNode.setLink(newNode);
               numElements++;
               break;
               
            // if greater than, attach to previous
            } else if (compare > 0) {
               newNode.setLink(currNode);
               if (previous == null) {
                  front = newNode;
               } else {
                  previous.setLink(newNode);
               }
               numElements++;
               break;

            //We reached the end of the list, add this lowest number
            } else if (currNode.getLink() == null) {
               currNode.setLink(newNode);
               numElements++;
               break;
            }
          
            //It was not greater than currNode, loop to the next node
            previous = currNode;
            currNode = currNode.getLink();
         }
      }    
}

   public T dequeue() {
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
   
      if (!isEmpty()) {
         T element;
         element = front.getInfo();
         front = front.getLink();
         if (front == null)
            rear = null;
         numElements--;
         return element;
      }
      else
         throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
   } 
  
   public int size() {
   // Returns the number of elements on this priority queue. 
      return numElements;
   }

  public boolean isEmpty()
  // Returns true if this priority queue is empty; otherwise, returns false.
  {
    return (front == null);
  }

   public boolean isFull() {
   // This priority queue is unbounded so always returns false.
      return false;
   }

   public String toString() {
   // Returns a nicely formatted string that represents this priority queue.
      String result = "";
      if (isEmpty()) {
         return "Queue is empty.";
      }  
      LLNode<T> currNode = front;
         
      while(currNode != null) {
         result += currNode.getInfo().toString() + ", ";
         currNode = currNode.getLink();
      }
      return result;
  }
}
