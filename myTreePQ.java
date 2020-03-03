//implement the Priority Queue ADT using 'our' Binary Search Tree


import java.util.*;   // Iterator, Comparator
import support.BSTNode;      
import ch09.priorityQueues.*;

public class myTreePQ<T> implements PriQueueInterface<T>  {
   protected BSTNode<T> root;      // reference to the root of this BST
   protected Comparator<T> comp;   // used for all comparisons

   public myTreePQ() {
      // Precondition: T implements Comparable
      // Creates an empty BST object - uses the natural order of elements.
    
      root = null;
      comp = new Comparator<T>() {
         public int compare(T element1, T element2) {
            return ((Comparable)element1).compareTo(element2);
         }
      };
   }

   public myTreePQ(Comparator<T> comp) {
      // Creates an empty BST object - uses Comparator comp for order
      // of elements.
   
      root = null;
      this.comp = comp;
   }

   public void enqueue(T element) {
      // adds element to this priority BST.
      //implemented as standard BST insert method 
      
      BSTNode<T> newNode = new BSTNode<T>(element);
      BSTNode<T> prev = null, curr = null;
       
      if (root == null) { 
         root = newNode;
       } else {
         curr = root;
         while (curr != null) {
            if (comp.compare(element, curr.getInfo()) <= 0) {
               prev = curr;
               curr = curr.getLeft();
            } else {
               prev = curr;
               curr = curr.getRight();
            }
         }
         if (comp.compare(element, prev.getInfo()) <= 0)
            prev.setLeft(newNode);
         else
            prev.setRight(newNode);
      }
  }   
  

   public T dequeue() {
      // Throws PriQUnderflowException if this priority queue is empty;
      // otherwise, removes element with highest priority from this 
      // priority queue and returns it.
      //highest priority element would be the right most element from the tree
      
      T nodeToRemove = null;
      BSTNode<T> prev = null, curr = null;      
      
      if(!isEmpty()) {
         //get the right most element
         
         curr = root;
         while (curr != null) {
            if (curr.getRight() != null) {
               // if there's a right element, iterate to it
               prev = curr;
               curr = curr.getRight();
            } else {
               // dequeue the curr
               nodeToRemove = curr.getInfo();
               prev.setRight(curr.getLeft());
               break;
            }
         }
      } else {
          throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
      }
      return nodeToRemove;
   }

   public boolean isEmpty() {
      // Returns true if this BST is empty; otherwise, returns false.
      return (root == null);
   }

   public boolean isFull() {
      // Returns false; this link-based BST is never full.
      return false;
   }
   
   private int recSize(BSTNode<T> node)
   // Returns the number of elements in subtree rooted at node.
   {
    if (node == null)    
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
   }
  
   public int size() {
      // Returns the number of elements in this BST.
      return recSize(root);
   }

   public String toString() {
      return recursePrint(root);
   }

   public String recursePrint(BSTNode<T> root) { 
      String tempString = "";
      if(root != null){
          tempString += recursePrint(root.getLeft());
          tempString += root.getInfo();
          tempString += recursePrint(root.getRight());
      }
      return tempString;
   }
}