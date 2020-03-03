//Question 8. Implement the Priority Queue ADT using an Unsorted Linked List

//driver for Unsorted Linked List

import ch09.priorityQueues.*;
import support.LLNode;
 
public class myUnSortedLLPQDriver  {
  public static void main(String[] args) {
  
      PriQueueInterface<Integer> pq = new myUnSortedLLPQ<Integer>();
      
      //add nodes 
      pq.enqueue(100);
      pq.enqueue(22);
      pq.enqueue(350);
      pq.enqueue(45);
      pq.enqueue(55);
      pq.enqueue(1050);
      pq.enqueue(225);
      pq.enqueue(35);
      pq.enqueue(451);
      pq.enqueue(559);
      
      //output toString
      System.out.println("\nThe current queue is: ");
      System.out.println(pq);
      
      System.out.println();
      System.out.println(pq.dequeue());
      System.out.println(pq.dequeue());

      System.out.println("\nThe current queue is: ");
      System.out.println(pq);
  } 
}