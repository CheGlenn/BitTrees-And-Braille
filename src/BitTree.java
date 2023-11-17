import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;


/**
 * BitTree class that creates a BinaryTree using 0 and 1 to navigate left and right nodes. Depending on the "path" taken, a final nodes value will be set
 * @author Che Glenn
 */
public class BitTree{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree
   */
  BitTreeNode root;

  /**
   * The size of the BitTree
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+


  /**
   * Builds a BitTree that will store mappings from strings of n bits to strings
   * @param n
   */
  public BitTree(int n){
    this.root = new BitTreeNode();
    this.size = n;
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

    /**
     * current to track what node we are on
     */
    BitTreeNode current = this.root;

    /**
     * check if the length of bits is equal to depth of BitTree
     * throws an exception otherwise
     */
    if(bits.length() != this.size){
      throw new Exception("Invalid input, input is of inappropriate length");
    }

    /**
     * Loop through bits, and check the number at current index i
     * If 0, create a new node on the left.
     * If 1, create a new node on the right.
     * Else, throw exception
     */
    for(int i = 0; i < bits.length(); i++){
      if(bits.charAt(i) == '0'){
        if(current.left != null){
        current = current.left;
        } else{
        current.left = new BitTreeNode();
        current = current.left;
        }
      }
      else if(bits.charAt(i) == '1'){
        if(current.right != null){
          current = current.right;
        } else{
        current.right = new BitTreeNode();
        current = current.right;
        }
      }else{
        throw new Exception("Invalid input, input contains value other than 0 or 1");
      }
    }

    /**Set the current nodes value to inputted value */
    current.value = value;
  }

  /**
   * Follows the path through the tree given by bits, returning the value at the end. 
   * If there is no such path, or if bits is the incorrect length, get should throw an exception.
   * @param bits
   * @return value
   */
  public String get(String bits) throws Exception{
    /**
     * current to track position in tree
     */
    BitTreeNode current = this.root;

    if(bits.length() != this.size){

    }
    /**
     * Loop through bits string, checking char at index i
     */
    for(int i = 0; i < bits.length(); i++){
      if( bits.charAt(i) == '0'){
        /**
         * Check that the next node on the left is not null, if it is throw exception
         * If not move to the next node
         */
        if(current.left == null){
          throw new Exception("Invalid input, no such path");
        }
        current = current.left;
      } 
      else if ( bits.charAt(i) == '1'){
        if(current.right == null){
          throw new Exception("Invalid input, no such path");
        }
        current = current.right;
      }else{
        /**If input is neither 0 nor 1, throw an exception */
        throw new Exception("Invalid input, input contains value other than 0 or 1");
      }
    }

    return current.value;
  }



  /**
   * Prints out the contents of the tree in CSV format. For example, one row of our braille tree will be “101100,M”
   * @param pen
   */
  public void dump(PrintWriter pen){
    dump(pen, this.root, "");
  }

  /**
   * Helper for dump, traverses the nodes and recursively calls dump to print path and final value
   * @param pen
   * @param node
   * @param path
   */
  void dump(PrintWriter pen, BitTreeNode node, String path){
    /**
     * Check if the current nodes value is null, if it is not null, then we can print the value and end the path
     */
    if (node.value != null){
      pen.println(path + "," + node.value);
    } else{
      /**
       * Check if the nodes to the left and right are null, recursively calling dump on the sides that are not null
       */
      if (node.left != null && node.right != null){
        dump(pen, node.left, path + "0");
        dump(pen, node.right, path + "1");
      }
      else if (node.left != null){
        dump(pen, node.left, path + "0");
      }
      else if (node.right != null){
        dump(pen, node.right, path + "1");
      }
    }
  }

  /**
   * Reads a series of lines of the form bits, value and stores them in the tree.
   * @param source
   */
  public void load(InputStream source) throws Exception{
    /*
     * First we convert our source input stream into something thats easier to manipulate
     */
    InputStreamReader inputStreamReader = new InputStreamReader(source);
    BufferedReader reader = new BufferedReader(inputStreamReader);
    /**
     * continually check if the current line is null, if its not we call set on the two halves of the line
     */
    String readString = "";
    while ((readString = reader.readLine()) != null){
      String[] setter = readString.split(",");
      set(setter[0], setter[1]);
      }
  }
}



