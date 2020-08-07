package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Arrays;
import structures.Queue; 
import structures.UnboundedQueueInterface;


/**
 * An iterator to perform a level order traversal of part of a filesystem. A level-order traversal
 * is equivalent to a breadth- first search.
 */
public class LevelOrderIterator extends FileIterator<File> {

  /**
   * Instantiate a new LevelOrderIterator, rooted at the rootNode.
   *
   * @param rootNode
   * @throws FileNotFoundException if the rootNode does not exist
   */
  UnboundedQueueInterface<File> queue;

  public LevelOrderIterator(File rootNode) throws FileNotFoundException {
    if(!rootNode.exists()){
      throw new FileNotFoundException();
    }
    queue = new Queue<File>();
    queue.enqueue(rootNode);
  }

  @Override
  public boolean hasNext() {
    // TODO implement hasNext()
    return !queue.isEmpty();
  }

  @Override
  public File next() throws NoSuchElementException {
    // TODO implement next()
    if(queue.isEmpty()){
      throw new NoSuchElementException();
    }
    File file = queue.dequeue();
    if(file.isDirectory()){
      File[] children = file.listFiles(); 
        Arrays.sort(children); 
        for(File child : children){
          queue.enqueue(child); 
        }
    }
    return file; 
      
    }
  

  @Override
  public void remove() {
    // Leave this one alone.
    throw new UnsupportedOperationException();
  }
}
