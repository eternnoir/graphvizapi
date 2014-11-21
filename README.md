# graphvizapi ![](https://travis-ci.org/eternnoir/graphvizapi.svg?branch=master)

A Graphviz Java API.

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
    graph.addAttributes(new Attributes("rankdir","LR"));  //Add some attribute.
    Node n1 = new Node("N1");                               //Create Node Object.
    n1.addAttributes(new Attributes("label","\" Node1 \""));//Add attribute
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

