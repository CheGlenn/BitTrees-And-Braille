/**
 * BitTreeNode class for creating BitTrees, adapted from BinaryTreeNode in Tree Traversal Lab
 * @author Sam R.
 * @author Che Glenn
 */

public class BitTreeNode<T>{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Value in this node
   */
  T value;

  /**
   * Left subtree
   */

   BitTreeNode<T> left;

  /**
   * Right subtree
   */

  BitTreeNode<T> right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeNode(T value, BitTreeNode<T> left, BitTreeNode<T> right){
    this.value = value;
    this.left = left;
    this.right = right;
  } //BitTreeNode(T value, BitTreeNode, BitTreeNode)

  public BitTreeNode(T value){
    this(value, null, null);

  }
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

}