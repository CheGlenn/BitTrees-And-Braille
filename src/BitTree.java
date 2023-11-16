import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

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

  // /**
  //  * Builds an empty BitTree
  //  */
  // public BitTree(){
  //   this.size = 0;
  //   this.root = null;
   
  // }

  /**
   * Builds a BitTree that will store mappings from strings of n bits to strings
   * @param n
   */
  public BitTree(int n){
    this.root = null;
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

    this.root = new BitTreeNode();

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
    for(int i = 0; i <= bits.length(); i++){
      if((int) bits.charAt(i) == '0'){
        current.left = new BitTreeNode();
        current = current.left;
      }
      else if(bits.charAt(i) == '1'){
        current = new BitTreeNode();
        current = current.right;
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
   * @return
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
    for(int i = 0; i <= bits.length(); i++){
      if(((int) bits.charAt(i)) == 0){
        /**
         * Check that the next node on the left is not null, if it is throw exception
         * If not move to the next node
         */
        if(current.left == null){
          throw new Exception("Invalid input, no such path");
        }
        current = current.left;
      } 
      else if (((int) bits.charAt(i)) == 1){
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

  BitTreeNode makeTree(){
    //STUB
    return null;
  }



}