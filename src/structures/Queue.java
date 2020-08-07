package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size; 
  
  public Queue() {
    // TODO implement the constructor
  }

  public Queue(Queue<T> other) {
    // TODO implement another constructor
    Node<T> temp = other.head; 
    while (temp != null){
      this.enqueue(temp.getData());
      temp = temp.getNext(); 
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO implement the isEmpty method
    return head == null;
  }

  @Override
  public int size() {
    // TODO implement the size method
    return size;
  }

  @Override
  public void enqueue(T element) {
    // TODO implement the enqueue method
    Node<T> newNode = new Node<T>(element); 
    size++;
    if(tail == null){
      head = newNode; 
    } else{
      tail.setNext(newNode);
    }
    tail = newNode; 
  }

  @Override
  public T dequeue() throws NoSuchElementException {
    // TODO implement the dequeue method
    if(isEmpty()){
      throw new NoSuchElementException(); 
    }
      
    T removedNode = head.getData();
    head = head.getNext();
    size--;
    if(isEmpty())tail = null; 
    return removedNode;  
  }

  @Override
  public T peek() throws NoSuchElementException {
    // TODO implement the peek method
    if(head == null) throw new NoSuchElementException(); 

    return head.getData();
  }

  @Override
  public UnboundedQueueInterface<T> reversed() {
    // TODO implement the reversed method
    Queue<T> revQueue = new Queue<T>();
    reverseHelper(revQueue,head);
    return revQueue;
  }

  private void reverseHelper(Queue<T> queue,Node<T> node){
    if(node == null){
      return;
    } else{
      reverseHelper(queue,node.getNext());
      queue.enqueue(node.getData());
    }
  }
}
