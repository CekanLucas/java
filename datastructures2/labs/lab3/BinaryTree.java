package datastructures2.labs.lab3;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @course COSC 2007
 * @Lab 3 - Binary Tree
 * @class BinaryTree
 * @Question The purpose of this lab is to implement binary tree
 * @Exercise
 * 
 *            <pre>
Write a program to construct binary tree using linked list.
You can add 10 nodes by any ways, or you can insert by following rules.
• if the new node’s value is lower than the current node’s, go to the left child
• if the new node’s value is greater than the current node’s, go to the right child
• when the current node is null, you can reach a leaf node then insert the new node in that position


You can perform pre-order, in-order and post-order traversal
 *            </pre>
 * 
 * @pseudoCode Written before I coded
 * 
 *             <pre>
 * Create a Node Class with left, right, parent nodes
 * A tree always has a root -> tree is empty if root == null
 * 
 * BinaryTree or TreeNode methods:
 * hasLeft(Node)
 * hasRight(Node)
 * isLeaf()
 * static isEmpty()
 * 
 * insert(item) {
 * 1st determine if root is null if it is insert new node as root
 * 
 * next loop as long as current node is not leaf
 * each loop choose left or right
 * 
 * }
 * 
 * We use recursion for traversal which can traverse any subtree
 * 
 * we follow the exercise instruction for traversal
 * 
 *             </pre>
 * 
 * @output
 *         NOTE:
 *         Question wording I didn't understand
 *         so I did In Pre and Post Order traversal
 * 
 *         <pre>
This tree is empty ⚠️
List After Inserting 5
In-Order:        5 
Pre-Order:       5 
Post-Order:      5 

List After Inserting 2
In-Order:        2  5 
Pre-Order:       5  2 
Post-Order:      2  5 

List After Inserting 1
In-Order:        1  2  5 
Pre-Order:       5  2  1 
Post-Order:      1  2  5 

List After Inserting 0
In-Order:        0  1  2  5 
Pre-Order:       5  2  1  0 
Post-Order:      0  1  2  5 

List After Inserting 6
In-Order:        0  1  2  5  6 
Pre-Order:       5  2  1  0  6 
Post-Order:      0  1  2  6  5 

List After Inserting 7
In-Order:        0  1  2  5  6  7 
Pre-Order:       5  2  1  0  6  7 
Post-Order:      0  1  2  7  6  5 

List After Inserting 8
In-Order:        0  1  2  5  6  7  8 
Pre-Order:       5  2  1  0  6  7  8 
Post-Order:      0  1  2  8  7  6  5 

List After Inserting 9
In-Order:        0  1  2  5  6  7  8  9 
Pre-Order:       5  2  1  0  6  7  8  9 
Post-Order:      0  1  2  9  8  7  6  5 

List After Inserting 4
In-Order:        0  1  2  4  5  6  7  8  9 
Pre-Order:       5  2  1  0  4  6  7  8  9 
Post-Order:      0  1  4  2  9  8  7  6  5 

List After Inserting 3
In-Order:        0  1  2  3  4  5  6  7  8  9 
Pre-Order:       5  2  1  0  4  3  6  7  8  9 
Post-Order:      0  1  3  4  2  9  8  7  6  5
 *         </pre>
 * 
 * @conclusion
 *             I manually went through the tree during debugging to get the
 *             shape
 *             I printed graphically the tree present in code for convenience
 *             As you can see this is a sorted binary tree its interesting that
 *             printing with in-order traversal would print numbers in order
 * 
 *             <pre>
 *    
                   5
                  / \
                 2   6      height of this tree = 5
                / \   \
              1   4    7
             /   /      \
            0   3        8
                          \
                           9
 *             </pre>
 */

public class BinaryTree {
  TreeNode root = null;

  BinaryTree() { // initialism empty tree
    this.root = null;
  }

  boolean isEmpty() {
    return root == null;
  }

  void print() {
    if (isEmpty()) {
      System.out.println("This tree is empty ⚠️");
    } else {
      System.out.print("In-Order:\t");
      inOrder(root);
      System.out.print("\nPre-Order:\t");
      preOrder(root);
      System.out.print("\nPost-Order:\t");
      postOrder(root);
      System.out.println("\n");
    }
  }

  private void inOrder(TreeNode node) {
    if (node == null)
      return;

    inOrder(node.getLeftChild());
    System.out.print(" " + node.item + " ");
    inOrder(node.getRightChild());
  }

  private void preOrder(TreeNode node) {
    if (node == null)
      return;

    System.out.print(" " + node.item + " ");
    preOrder(node.getLeftChild());
    preOrder(node.getRightChild());
  }

  private void postOrder(TreeNode node) {
    if (node == null)
      return;

    postOrder(node.getLeftChild());
    postOrder(node.getRightChild());
    System.out.print(" " + node.item + " ");
  }

  void insert(int item) {

    if (isEmpty()) { // if tree empty, insert item as root
      root = new TreeNode(item);
      return;
    }

    TreeNode currentNode = root;
    int currentValue = root.item;

    while (!currentNode.isLeaf()) { // traverse if current is not a leaf node
      // left or right subtree
      if (item <= currentValue) { // insert left
        if (currentNode.getLeftChild() == null) {
          TreeNode newNode = new TreeNode(item, null, null, currentNode);
          currentNode.setLeftChild(newNode);
          return;
        }

        currentNode = currentNode.getLeftChild();
        currentValue = currentNode.item;
      } else { // insert right
        if (currentNode.getRightChild() == null) {
          TreeNode newNode = new TreeNode(item, null, null, currentNode);
          currentNode.setRightChild(newNode);
          return;
        }

        currentNode = currentNode.getRightChild();
        currentValue = currentNode.item;
      }
    }

    // We are at leaf insert left or right
    if (item <= currentValue) { // insert left if item less than current nodes's item
      TreeNode newNode = new TreeNode(item, null, null, currentNode);
      currentNode.setLeftChild(newNode);
    } else { // else if item is greater than current nodes's item
      TreeNode newNode = new TreeNode(item, null, null, currentNode);
      currentNode.setRightChild(newNode);
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.print();
    System.out.println("List After Inserting 5");
    tree.insert(5);
    tree.print();
    System.out.println("List After Inserting 2");
    tree.insert(2);
    tree.print();
    System.out.println("List After Inserting 1");
    tree.insert(1);
    tree.print();
    System.out.println("List After Inserting 0");
    tree.insert(0);
    tree.print();
    System.out.println("List After Inserting 6");
    tree.insert(6);
    tree.print();
    System.out.println("List After Inserting 7");
    tree.insert(7);
    tree.print();
    System.out.println("List After Inserting 8");
    tree.insert(8);
    tree.print();
    System.out.println("List After Inserting 9");
    tree.insert(9);
    tree.print();
    System.out.println("List After Inserting 4");
    tree.insert(4);
    tree.print();
    System.out.println("List After Inserting 3");
    tree.insert(3);
    tree.print();
  }
}

class TreeNode {
  int item = 0;
  private TreeNode leftChild = null;
  private TreeNode rightChild = null;
  private TreeNode parent = null;

  TreeNode(int item) {
    this.leftChild = null;
    this.rightChild = null;
    this.parent = null;
    this.item = item;
  }

  TreeNode(int item, TreeNode leftChild, TreeNode rightChild, TreeNode parent) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.parent = parent;
    this.item = item;
  }

  public TreeNode getLeftChild() {
    return leftChild;
  }

  public TreeNode getRightChild() {
    return rightChild;
  }

  public TreeNode getParent() {
    return parent;
  }

  boolean isRoot() {
    return parent == null;
  }

  boolean isLeaf() {
    return leftChild == null && rightChild == null;
  }

  boolean hasLeftChild() {
    return (leftChild != null);
  }

  boolean hasRightChild() {
    return (rightChild != null);
  }

  public void setLeftChild(TreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public void setRightChild(TreeNode rightChild) {
    this.rightChild = rightChild;
  }

  public void setParent(TreeNode parent) {
    this.parent = parent;
  }
}
