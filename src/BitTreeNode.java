/**
 * BitTreeNode class for creating BitTrees, adapted from BinaryTreeNode in Tree Traversal Lab
 * @author Sam R.
 * @author Che Glenn
 */

public class BitTreeNode{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+


  /**
   * value stored in the node
   */

   String value;
  
  /**
   * Left subtree
   */

   BitTreeNode left;

  /**
   * Right subtree
   */

  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeNode(){
    this.left = null;
    this.right = null;
  } //BitTreeNode(T value, BitTreeNode, BitTreeNode)

}