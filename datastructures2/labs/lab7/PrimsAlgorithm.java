package datastructures2.labs.lab7;

import java.util.Arrays;
import java.util.Objects;

import datastructures2.labs.lab7.GraphNode.WeightedEdge;

/**
 * @author Lucas Cekan
 * @studentId 239596640
 * @course COSC 2007
 * @Lab 7 - Prim's algorithm
 * @class Graph
 * @Question The purpose of this lab is to implement binary tree
 * @Exercise1 Write a program to implement Prims algorithm
 *            to find the minimum
 *            spanning tree of the
 *            following graph
 */

public class PrimsAlgorithm {
  GraphNode start = null;
  GraphNode[] marked = {};

  PrimsAlgorithm() { // initializes empty at first
    this.start = null;
    this.marked = new GraphNode[0];
  }

  public void setStart(GraphNode start) {
    this.start = start;
  }

  public static void main(String[] args) {
    PrimsAlgorithm graph = new PrimsAlgorithm();

    // initialize all the graph nodes
    char alphabet = 'a';
    GraphNode a = new GraphNode(Character.toString(alphabet++));
    GraphNode b = new GraphNode(Character.toString(alphabet++));
    GraphNode c = new GraphNode(Character.toString(alphabet++));
    GraphNode d = new GraphNode(Character.toString(alphabet++));
    GraphNode e = new GraphNode(Character.toString(alphabet++));
    GraphNode f = new GraphNode(Character.toString(alphabet++));
    GraphNode g = new GraphNode(Character.toString(alphabet++));
    GraphNode h = new GraphNode(Character.toString(alphabet++));
    GraphNode i = new GraphNode(Character.toString(alphabet));

    // link up nodes with weights
    graph.setStart(a);
    a.link(b, 6);
    a.link(f, 4);
    b.link(c, 7);
    b.link(e, 9);
    c.link(e, 3);
    c.link(d, 4);
    d.link(g, 5);
    e.link(g, 8);
    g.link(f, 2);
    h.link(d, 1);
    i.link(a, 2);

    graph.prim(a);
  }

  /** Prims algorithm also outputs the links traversed */
  void prim(GraphNode node) {
    WeightedEdge leastEdge = leastEdge(node);

    while (!Objects.isNull(leastEdge)) {
      System.out.println(
          node.getLabel() +
              " - " + leastEdge.weight + " - " +
              leastEdge.getDestinationNode().getLabel());

      prim(leastEdge.getDestinationNode());
      leastEdge = leastEdge(node);
    }
  }

  /** find return the least cost non marked edge from marked nodes */
  private WeightedEdge leastEdge(GraphNode node) {
    mark(node);
    WeightedEdge leastEdge = null;

    for (GraphNode mark : marked) {
      WeightedEdge[] edges = mark.edges;

      for (WeightedEdge edge : edges) {
        if (!isMarked(edge.getDestinationNode())) {
          if (Objects.isNull(leastEdge))
            leastEdge = edge;
          else {
            if (edge.weight < leastEdge.weight) {
              leastEdge = edge;
            }
          }
        }
      }
    }

    return Objects.isNull(leastEdge) ? null : leastEdge;
  }

  /** add node to marked array to indicate the node has been visited */
  private void mark(GraphNode node) {
    marked = Arrays.copyOf(marked, marked.length + 1);
    marked[marked.length - 1] = node;
  }

  /** Has this node already been visited @return boolean */
  private boolean isMarked(GraphNode node) {
    for (GraphNode alreadyMarked : marked)
      if (Objects.equals(node, alreadyMarked))
        return true;

    return false;
  }
}

class GraphNode {
  private String label = null;
  protected WeightedEdge[] edges = {};

  /* Define a weighted edge between two nodes/vertices */
  public class WeightedEdge {
    protected int weight = 0;
    private GraphNode sourceNode = null;
    private GraphNode destinationNode = null;

    public GraphNode getSourceNode() {
      return sourceNode;
    }

    public GraphNode getDestinationNode() {
      return destinationNode;
    }

    WeightedEdge(int weight, GraphNode sourceNode, GraphNode destinationNode) {
      this.weight = weight;
      this.sourceNode = sourceNode;
      this.destinationNode = destinationNode;
    }
  }

  GraphNode(String label) {
    this.label = label;
    this.edges = new WeightedEdge[0];
  }

  public String getLabel() {
    return label;
  }

  void link(GraphNode linkNode, int weight) {
    WeightedEdge[] newLinks = Arrays.copyOf(edges, edges.length + 1);
    newLinks[edges.length] = new WeightedEdge(weight, this, linkNode);
    edges = newLinks;

    // since link is not directional add link in linkNode as well
    newLinks = Arrays.copyOf(linkNode.edges, linkNode.edges.length + 1);
    newLinks[linkNode.edges.length] = new WeightedEdge(weight, linkNode, this);
    linkNode.edges = newLinks;
  }

}
