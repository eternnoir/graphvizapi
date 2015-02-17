# graphvizapi ![](https://travis-ci.org/eternnoir/graphvizapi.svg?branch=master)

A Graphviz Java API.Use OO way to create graphviz image.

## Requirements

* Java 1.6+
* Graphviz [Graphviz | Graphviz - Graph Visualization Software](www.graphviz.org/)

## Quick Start

#### Example 1
```java
private void draw()
{
    Graphviz gv = new Graphviz();                           //Graphviz Object.
    Graph graph = new Graph("g1", GraphType.DIGRAPH);       //Create New Gpaph.
    graph.addAttribute(new Attribute("rankdir","LR"));      //Add some attribute.
    Node n1 = new Node("N1");                               //Create Node Object.
    n1.addAttributesnew Attribute("label","\" Node1 \""));  //Add attribute
    Node n2 = new Node("N2");
    Node n3 = new Node("N3");

    graph.addNode(n1);                                      //Add node to graph.
    graph.addNode(n2);
    graph.addNode(n3);
    graph.addEdge(new Edge(n1, n2));                        //Add edge
    graph.addEdge(new Edge(n2, n3));
    graph.addEdge(new Edge(n3,n1));
    String type = "png";
    File out = new File(tmpPath+"/outEX1."+ type);          //Output File.
    this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
}
```
##### Result
![Example 1](https://raw.githubusercontent.com/eternnoir/graphvizapi/master/Sample/outEX1.png)


#### Example 2
```java
public void draw(){
    Graphviz gv = new Graphviz();
    Graph graph = new Graph("g1", GraphType.DIGRAPH);
    Graph cluster_0 = new Graph("cluster_0",GraphType.DIGRAPH);
    cluster_0.addAttribute(new Attribute("style","filled"));
    cluster_0.addAttribute(new Attribute("color","lightgrey"));
    cluster_0.addAttribute(new Attribute("label","\"process #1\""));
    Attribute cn0Attr = new Attribute("style","filled");
    Node a0 = new Node("a0");
    Node a1 = new Node("a1");
    Node a2 = new Node("a2");
    Node a3 = new Node("a3");
    cluster_0.addNode(a0);
    cluster_0.addNode(a1);
    cluster_0.addNode(a2);
    cluster_0.addNode(a3);
    cluster_0.addEdge(new Edge("",a0,a1));
    cluster_0.addEdge(new Edge("",a1,a2));
    cluster_0.addEdge(new Edge("",a2,a3));
    Graph cluster_1 = new Graph("cluster_1",GraphType.DIGRAPH);
    cluster_1.addAttribute(new Attribute("color","blue"));
    cluster_1.addAttribute(new Attribute("label","\"process #1\""));
    Node b0 = new Node("b0");
    Node b1 = new Node("b1");
    Node b2 = new Node("b2");
    Node b3 = new Node("b3");
    cluster_1.addNode(b0);
    cluster_1.addNode(b1);
    cluster_1.addNode(b2);
    cluster_1.addNode(b3);
    cluster_1.addEdge(new Edge("",b0,b1));
    cluster_1.addEdge(new Edge("",b1,b2));
    cluster_1.addEdge(new Edge("",b2,b3));
    Node startNode = new Node("Start");
    startNode.addAttribute(new Attribute("shape","Mdiamond"));
    Node endNode = new Node("End");
    endNode.addAttribute(new Attribute("shape","Msquare"));
    graph.addNode(startNode);
    graph.addNode(endNode);
    graph.addSubgraph(cluster_0);
    graph.addSubgraph(cluster_1);
    graph.addEdge(new Edge("", startNode, a0));
    graph.addEdge(new Edge("", startNode, b0));
    graph.addEdge(new Edge("",a1,b3));
    graph.addEdge(new Edge("",b2,a3));
    graph.addEdge(new Edge("",a3,a0));
    graph.addEdge(new Edge("", a3, endNode));
    graph.addEdge(new Edge("", b3, endNode));
    String type = "png";
    File out = new File(tmpPath+"/outEX3."+ type);
    this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
}
```
##### Result
![Example 2](https://raw.githubusercontent.com/eternnoir/graphvizapi/master/Sample/outEX3.png)

