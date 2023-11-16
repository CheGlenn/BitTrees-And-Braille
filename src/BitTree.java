import java.io.InputStream;
import java.io.PrintWriter;

public class BitTree<T>{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree
   */
  BitTreeNode<T> root;

  /**
   * The size of the BitTree
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds an empty BitTree
   */
  public BitTree(){
    this.size = 0;
    this.root = null;
  }

  /**
   * Builds a BitTree that will store mappings from strings of n bits to strings
   * @param n
   */
  public BitTree(int n){
    //STUB
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or replaces the value at the end with value. 
   * Throw an exception if bits is the inappropriate length or contains values other than 0 or 1.
   * @param bits
   * @param value
   */
  public void set(String bits, String value) throws Exception{
    //STUB
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end. 
   * If there is no such path, or if bits is the incorrect length, get should throw an exception.
   * @param bits
   * @return
   */
  public String get(String bits){
    //STUB
    return null;
  }

  /**
   * Prints out the contents of the tree in CSV format. For example, one row of our braille tree will be “101100,M”
   * @param pen
   */
  public void dump(PrintWriter pen){
    //STUB
  }

  /**
   * Reads a series of lines of the form bits,value and stores them in the tree.
   * @param source
   */
  public void load(InputStream source){
    //STUB
  }

  /**
   * 
   */

  BitTreeNode<T> makeTree(){
    
  }

}