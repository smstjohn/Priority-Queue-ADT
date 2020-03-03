//driver code for myTreePQ<T>

import ch09.priorityQueues.*;

public class myTreePQDriver {

   public static void main(String[] args ) {
      
    PriQueueInterface<String> pqTree = new myTreePQ<String>();
    
   
    pqTree.enqueue("J");
    pqTree.enqueue("A");
    pqTree.enqueue("M");
    pqTree.enqueue("B");
    pqTree.enqueue("L");
    pqTree.enqueue("E");
    
    System.out.println(pqTree);
    
    System.out.println();
    System.out.println(pqTree.dequeue() + "\n");
    
    System.out.println(pqTree);
  }
}    