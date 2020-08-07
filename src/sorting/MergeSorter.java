package sorting;

import structures.Queue;

/**
 * A class containing methods to sort queues and merge sorted queues.
 *
 * <p>"Sorted" means in ascending order: the front of the queue is the smallest element, and the
 * rear of the queue is the largest.
 *
 * <p>e1 is less than or equal to e2 if and only if (e1.compareTo(e2) <= 0)
 *
 * <p>You may not use loops (for, while, do, etc.) in this class. You must instead use recursion.
 */
public class MergeSorter<T extends Comparable<T>> {
  /**
   * Returns a new queue containing the elements from the input queue in sorted order.
   *
   * <p>Do not modify the input queue! Work on a copy of the input.
   *
   * <p>Implement this method recursively:
   *
   * <p>In the base case, return the sorted queue.
   *
   * <p>Otherwise:
   *
   * <p>First, divide the input queue into two smaller output queues.
   *
   * <p>Then, recursively mergeSort each of these smaller queues.
   *
   * <p>Finally, return the result of merging these two queues.
   *
   * @param queue an input queue
   * @return a sorted copy of the input queue
   */
  public Queue<T> mergeSort(Queue<T> queue) {
    // TODO implement the mergeSort method
    Queue<T> copy = new Queue<T>(queue); 
    if(copy.size() == 1 || copy.size() == 0) {
      return copy; 
    } else{
      Queue<T> var1 = new Queue<T>();
      Queue<T> var2 = new Queue<T>();
      divide(copy,var1,var2);
      var1 = mergeSort(var1);
      var2 = mergeSort(var2);
      return merge(var1,var2); 
    }
  }

  /**
   * Places elements from the input queue into the output queues, roughly half and half.
   *
   * <p>Implement this method recursively:
   *
   * <p>In the base case, there's nothing left to do.
   *
   * <p>Otherwise:
   *
   * <p>Make progress on moving elements from the input to the output.
   *
   * <p>Then make a recursive call to divide.
   *
   * @param input a queue
   * @param output1 a queue into which about half of the elements in input should go
   * @param output2 a queue into which the other half of the elements in input should go
   */
  public void divide(Queue<T> input, Queue<T> output1, Queue<T> output2) {
    // TODO implement the divide method
    if(input.isEmpty()){
      return;
    }
    else{
      output1.enqueue(input.dequeue());
    }
    if(input.isEmpty()){
      return;
    } 
    else{
      output2.enqueue(input.dequeue());
      divide(input,output1,output2);
    }
  }

  /**
   * Merges sorted input queues into an output queue in sorted order, and returns that queue.
   *
   * <p>Use mergeHelper to accomplish this goal.
   *
   * @param input1 a sorted queue
   * @param input2 a sorted queue
   * @return a sorted queue consisting of all elements from input1 and input2
   */
  public Queue<T> merge(Queue<T> input1, Queue<T> input2) {
    // TODO implement the merge method
    Queue<T> mergeQueue = new Queue<T>();
    mergeHelper(input1,input2,mergeQueue);
    return mergeQueue;
  }

  /**
   * Merges the sorted input queues into the output queue in sorted order.
   *
   * <p>Implement this method recursively:
   *
   * <p>In the base case, there's nothing left to do.
   *
   * <p>Otherwise:
   *
   * <p>Make progress on moving elements from an input to the output.
   *
   * <p>Then make a recursive call to mergeHelper.
   *
   * @param input1 a sorted queue
   * @param input2 a sorted queue
   * @param output a sorted queue containing the accumulated progress so far
   */
  void mergeHelper(Queue<T> input1, Queue<T> input2, Queue<T> output) {
    // TODO implement the mergeHelper method
    if(input2.isEmpty() && input1.isEmpty()) return;

    if(input2.isEmpty()){
      output.enqueue(input1.dequeue());
    } else if(input1.isEmpty()){
      output.enqueue(input2.dequeue());
    } else{
      T temp;
      if(input2.peek().compareTo(input1.peek()) >= 0){
        temp = input1.dequeue();
      } else{ 
      temp = input2.dequeue();
    }
    output.enqueue(temp); 
  }
    mergeHelper(input1,input2,output);
  }
}
