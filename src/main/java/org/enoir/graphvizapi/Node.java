package org.enoir.graphvizapi;

/**
 * Created by frank on 2014/11/17.
 */
public class Node extends BaseGraphObject {

    public Node(String id) {
        super(id);
    }

    @Override
    public String genDotString() {
        StringBuilder dotString = new StringBuilder();
        dotString.append("["+this.genAttributeDotString()+"]");
        return dotString.toString();
    }
}
