//class for Unsorted Linked List

import ch09.priorityQueues.*;
import java.util.Comparator;
 import support.LLNode;

public class myUnSortedLLPQ<T> implements PriQueueInterface<T>  {

  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue
  protected Comparator<T> comp;


  public myUnSortedLLPQ() 
  {
      front = null;
      rear = null;
       
      comp = new Comparator<T>() {
         public int compare(T element1, T element2) {
            return ((Comparable)element1).compareTo(element2);
         }
      };
  }

   public void enqueue(T element) { 
   // Adds element to this priority queue.
      LLNode<T> newNode = new LLNode<T>(element);
      
      if (rear == null) {
         front = newNode;
      } else {
         rear.setLink(newNode);
      }
      rear = newNode;
      numElements++;
   }

   public T dequeue() {
   // Throws PriQUnderflowException if this priority queue is empty;
   // otherwise, removes element with highest priority from this 
   // priority queue and returns it.
      
      if (!isEmpty()) {

         LLNode<T> currNode = front.getLink();
         LLNode<T> prevNode = null; //always store prev node so it is available when we find the new highest        
         LLNode<T> highNode = null; //the current highest node
         LLNode<T> prevHighNode = null; // the previous node to the highest node

         //loop through list to find highest element
         while (currNode != null) {
            if (highNode == null && comp.compare(currNode.getInfo(), front.getInfo()) < 0) {
               highNode = front;
            } else if (highNode == null) {
               highNode = currNode;
               prevHighNode = front;
            } else if (comp.compare(currNode.getInfo(), highNode.getInfo()) > 0) {
               highNode = currNode;
               prevHighNode = prevNode;
            }

            prevNode=currNode;   
            currNode=currNode.getLink(); 
         }
         
         //Remove the highNode via prevHighNode
         prevHighNode.setLink(highNode.getLink());
         
         numElements--;
         return highNode.getInfo();
      } else {
         throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
      }
   } 
  
   //remove method removes the front count elements from the queue, 
   //throws exception if less than count elements are in queue
   public void remove(int count) throws PriQUnderflowException {
    if (size() < count) {
      throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
    } else {
         // remove count number of elements from front
         for(int i=1; i<=count; i++) {
            dequeue();
         }
      }
   }
  
   public int size() {
   // Returns the number of elements on this priority queue. 
      return numElements;
   }

   public boolean isEmpty() {
   // Returns true if this priority queue is empty; otherwise, returns false.
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