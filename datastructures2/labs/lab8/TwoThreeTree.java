package datastructures2.labs.lab8;

import java.util.Arrays;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @course C.O.S.C. 2007
 * @Lab 8 - AVL Tree and 2-3 Trees
 * @class Graph
 * @Question The purpose of this lab is to implement 2-3 trees and AVL tree
 * @Exercise1 What is 2-3 tree? Write the details algorithm for search,
 *            insertion and deletion operations of 2-3
 *            tree
 * @Exercise2 What is AVL? Write the details algorithm for balancing the AVL
 *            tree with suitable examples
 * 
 *            <pre>
Pseudo-code/Algorithm:
Exercise1 What is 2-3 tree? Write the details algorithm for search, insertion and deletion operations of 2-3


Conclusion
 Exercise1 - What is 2-3 tree? Write the details algorithm for search, insertion and deletion operations of 2-3

A 2-3 tree a tree that has two types of nodes 
1) A 2-node which is standard just like in a normal binary tree
2) A 3-node which has two data items and three children
   - here leftChild < data items
   - rightChild > data items
   - dataItem1 < middleChild < dataItem2

This tree structure is used because it is easy to keep balanced

search(item or node) 
 Start at root 
 keep make comparisons until traversing left, right, or for 3-nodes even middle until element found or not

insertion(item or node)                  
 case 1 : terminating on a leaf        (30)           (30)
     Example inserting 39             /   \   -->    /   \
                                 (10 20)  (40)   (10 20) ('39' 40) 

 case 2 : 2-node to 3-node conversion  (30)                (30   39)
     Example inserting 38             /   \   -->         /    |   \
                                 (10 20)  (39 40)   (10 20)  (38)  (40)


deletion(item or node)
    inverse of the insertion strategy
 *            </pre>
 */

public class TwoThreeTree {
  Node root;

  boolean search(int search) {
    if (root == null)
      return false;

    Node currentNode = root;

    while (!currentNode.isLeaf()) {
      if (currentNode.searchNode(search))
        return true;
      else {
        currentNode = currentNode.traverse(search);
      }
    }

    return currentNode.searchNode(search);
  }

  void insertion(int item) {
    if (root == null) {
      root = new TwoNode(item, null, null, null);
      return;
    }

    Node currentNode = root;

    while (!currentNode.isLeaf()) // traverse to leaf
      currentNode = currentNode.traverse(item);

    if (currentNode instanceof TwoNode) { // split 2-node leaf into double value 3-node
      TwoNode oldNode = (TwoNode) currentNode;
      split(oldNode, item);
    } else { // current leaf node is a 3-node
      ThreeNode oldNode = (ThreeNode) currentNode;
      split(oldNode, item);
    }
  }

  private void split(TwoNode node, int item) {
    ThreeNode newNode = node.item <= item
        ? new ThreeNode(node.item, item, null, null, null, node.parent)
        : new ThreeNode(item, node.item, null, null, null, node.parent);
    // need to set relevant parent's child to newNode make sure you got type right
    if (node.parent == null) {
      root = newNode;
      return;
    }
    
    Node parent = node.parent;

    if (parent instanceof ThreeNode) {
      ThreeNode parent = (ThreeNode) parent;
      if (parent.leftChild.equals(node))
        parent.leftChild = newNode;
      else if (parent.middleChild.equals(node))
        parent.middleChild = newNode;
      else if (parent.rightChild.equals(node))
        parent.rightChild = newNode;
    } else { // parent is a TwoNode
      TwoNode parent = (TwoNode) parent;
      if (parent.leftChild.equals(node))
        parent.leftChild = newNode;
      else if (parent.rightChild.equals(node))
        parent.rightChild = newNode;
    }
  }

  private void split(ThreeNode node, int item) {
    if (node.isRoot()) {
      int[] arr = { item, node.lowerItem, node.higherItem };
      Arrays.sort(arr);
      int smallest = arr[0];
      int middle = arr[1]; // middle goes up to parent
      int largest = arr[2];

      if (node.isLeaf()) {
        root = new TwoNode(middle, null, null, null);
        root.leftChild = new TwoNode(smallest, null, null, root);
        root.rightChild = new TwoNode(largest, null, null, root);
        return;
      } else {
        root = new ThreeNode(smallest, largest, null, null, null, null);
        root.leftChild = new TwoNode(middle, null, null, root);
        root.rightChild = node;
        node.parent = root;
        return;
      }

    }

    if (node.parent instanceof ThreeNode) {
      ThreeNode oldParent = (ThreeNode) node.parent;
      int[] arr = { item, oldParent.lowerItem, oldParent.higherItem };
      Arrays.sort(arr);
      int middle = arr[1];
      split(oldParent, middle); // recursively split parent
      return;
    }

    // else parent is TwoNode

    int[] arr = { item, node.lowerItem, node.higherItem };
    Arrays.sort(arr);
    int smallest = arr[0];
    int middle = arr[1]; // middle goes up to parent
    int largest = arr[2];

    TwoNode oldParent = (TwoNode) node.parent;
    ThreeNode newParent = new ThreeNode();

    // move middle up to parent determine if insertion is left or right
    if (middle <= oldParent.item) { // split left
      newParent.lowerItem = middle;
      newParent.higherItem = oldParent.item;
      newParent.leftChild = oldParent.leftChild;
      newParent.leftChild = new TwoNode(
          smallest, null, null, newParent);
      newParent.middleChild = new TwoNode(
          largest, null, null, newParent);
      newParent.rightChild = oldParent.rightChild;
      if (newParent.isRoot())
        root = newParent;
    } else if (oldParent.item < middle) { // split right
      newParent.lowerItem = oldParent.item;
      newParent.higherItem = middle;
      newParent.leftChild = oldParent.leftChild;
      newParent.middleChild = new TwoNode(
          smallest, null, null, newParent);
      newParent.rightChild = new TwoNode(
          largest, null, null, newParent);
      if (newParent.isRoot())
        root = newParent;
    }
  }

  // boolean deletion(int item) {

  // }

  abstract class Node {
    Node parent;
    Node leftChild;
    Node rightChild;

    abstract boolean isRoot();

    abstract boolean isLeaf();

    abstract Node traverse(int value);

    abstract boolean searchNode(int search);
  }

  class TwoNode extends Node {
    int item;

    TwoNode() {
    }

    TwoNode(int item, Node leftChild, Node rightChild, Node parent) {
      this.item = item;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
      this.parent = parent;
    }

    boolean isRoot() {
      return parent == null;
    }

    boolean isLeaf() {
      return leftChild == null && rightChild == null;
    }

    @Override /* choose a child to traverse */
    Node traverse(int value) {
      return value < item ? leftChild : rightChild;
    }

    @Override
    boolean searchNode(int search) {
      return item == search || leftChild.searchNode(search) || rightChild.searchNode(search);
    }

  }

  class ThreeNode extends Node {
    int lowerItem;
    int higherItem;

    Node middleChild;

    ThreeNode() {
    }

    ThreeNode(int lowerItem, int higherItem, Node leftChild, Node rightChild, Node middleChild, Node parent) {
      this.lowerItem = lowerItem;
      this.higherItem = higherItem;
      this.leftChild = leftChild;
      this.middleChild = middleChild;
      this.rightChild = rightChild;
      this.parent = parent;
    }

    boolean isRoot() {
      return parent == null;
    }

    boolean isLeaf() {
      return leftChild == null && middleChild == null && rightChild == null;
    }

    @Override /* choose a child to traverse */
    Node traverse(int value) {
      if (value <= lowerItem)
        return leftChild;
      else if (value >= higherItem)
        return rightChild;
      else
        return middleChild;
    }

    @Override
    boolean searchNode(int search) {
      return lowerItem == search || higherItem == search ||
          leftChild.searchNode(search) ||
          middleChild.searchNode(search) ||
          rightChild.searchNode(search);
    }
  }

  public static void main(String[] args) {
    int[] items = { 60, 30, 90, 10, 50, 80, 100, 40, 70, 20 };
    TwoThreeTree tree = new TwoThreeTree();

    for (int item : items) {
      tree.insertion(item);
      System.out.println("Inserted " + item + " into tree");
      tree.print();
    }

    // important insertions from textbook
    System.out.println("Inserted 39 into tree");
    tree.insertion(39);
    tree.print();
    System.out.println("Inserted 38 into tree");
    tree.insertion(38);
    tree.print();
    System.out.println("Inserted 37 into tree");
    tree.insertion(37);
    tree.print();
    System.out.println("Inserted 36 into tree");
    tree.insertion(36);
    tree.print();
    System.out.println("Inserted 35 into tree");
    tree.insertion(35);
    tree.print();
    System.out.println("Inserted 34 into tree");
    tree.insertion(34);
    System.out.println("Inserted 33 into tree");
    tree.insertion(33);
    System.out.println("Inserted 32 into tree");
    tree.insertion(32);
    tree.print();

  }

  void print() {
    if (root == null) {
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

  private void inOrder(Node node) {
    if (node instanceof TwoNode) {
      TwoNode twoNode = (TwoNode) node;
      inOrder(twoNode.leftChild);
      System.out.print("(" + twoNode.item + ")");
      inOrder(twoNode.rightChild);
    } else if (node instanceof ThreeNode) {
      ThreeNode threeNode = (ThreeNode) node;
      inOrder(threeNode.leftChild);
      System.out.print("(" + threeNode.lowerItem + " " + threeNode.higherItem + ")");
      inOrder(threeNode.middleChild);
      inOrder(threeNode.rightChild);
    }
  }

  private void preOrder(Node node) {
    if (node instanceof TwoNode) {
      TwoNode twoNode = (TwoNode) node;
      System.out.print("(" + twoNode.item + ")");
      preOrder(twoNode.leftChild);
      preOrder(twoNode.rightChild);
    } else if (node instanceof ThreeNode) {
      ThreeNode threeNode = (ThreeNode) node;
      System.out.print("(" + threeNode.lowerItem + " " + threeNode.higherItem + ")");
      preOrder(threeNode.leftChild);
      preOrder(threeNode.middleChild);
      preOrder(threeNode.rightChild);
    }
  }

  private void postOrder(Node node) {
    if (node instanceof TwoNode) {
      TwoNode twoNode = (TwoNode) node;
      postOrder(twoNode.leftChild);
      postOrder(twoNode.rightChild);
      System.out.print("(" + twoNode.item + ")");
    } else if (node instanceof ThreeNode) {
      ThreeNode threeNode = (ThreeNode) node;
      postOrder(threeNode.leftChild);
      postOrder(threeNode.middleChild);
      postOrder(threeNode.rightChild);
      System.out.print("(" + threeNode.lowerItem + " " + threeNode.higherItem + ")");
    }
  }

}
