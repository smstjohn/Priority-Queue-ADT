//Question 8. Implement the Priority Queue ADT using an Unsorted Array

//driver for myUnSortedArrayPQ

import ch09.priorityQueues.*;

public class UnSortedArrayPQDriver  {
  public static void main(String[] args) { 
  
    PriQueueInterface<String> pq = new myUnSortedArrayPQ<String>();
    
    pq.enqueue("C");   pq.enqueue("O");   pq.enqueue("M");
    pq.enqueue("P");   pq.enqueue("U");   pq.enqueue("T");
    pq.enqueue("E");   pq.enqueue("R");
   
    System.out.println(pq);

    System.out.println(pq.dequeue());
    System.out.println(pq.dequeue());

    System.out.println(pq);
  }
}