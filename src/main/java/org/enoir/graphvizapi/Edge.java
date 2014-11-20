package org.enoir.graphvizapi;

/**
 * Created by frank on 2014/11/20.
 */
public class Edge extends BaseGraphObject {
    private Node fromNode;
    private Node toNode;

    public Edge(String id,Node fromNode,Node toNode){
        super(id);
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public Node getFromNode(){
        return this.fromNode;
    }

    public Node getToNode(){
        return this.toNode;
    }

    @Override
    public String genDotString() {
        StringBuilder dotString = new StringBuilder();
        dotString.append("["+this.genAttributeDotString()+"]");
        return dotString.toString();
    }
}
