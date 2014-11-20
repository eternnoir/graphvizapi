package org.enoir.graphvizapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2014/11/20.
 */
public class Graph extends BaseGraphObject {

    private GraphType graphType;
    private List<Node> nodeList;
    private List<Edge> edgeList;
    private List<Graph> subgraphList;

    public Graph(String id,GraphType graphType){
        super(id);
        this.graphType = graphType;
        this.nodeList = new ArrayList<Node>();
        this.edgeList = new ArrayList<Edge>();
        this.subgraphList = new ArrayList<Graph>();
    }

    public void addNode(Node node){
        this.nodeList.add(node);
    }

    public void addEdge(Edge edge){
        this.edgeList.add(edge);
    }

    public void addSubgraph(Graph graph){
        this.subgraphList.add(graph);
    }

    @Override
    public String genDotString() {
        StringBuilder dotString = new StringBuilder();
        return dotString.toString();
    }

    private String genNodesString(){
        StringBuilder nodeString = new StringBuilder();
        for(Node node: nodeList){
            nodeString.append(node.genDotString());
        }
        return nodeString.toString();
    }
}

