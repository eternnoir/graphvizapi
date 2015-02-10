package org.enoir.graphvizapi;

/**
 * Created by frank on 2014/11/20.
 */
public class Attribute {
    private String attrName;
    private String attrValue;
    public Attribute(String name, String value){
        this.attrName = name;
        this.attrValue = value;
    }

    public String getAttrName(){
        return this.attrName;
    }
    public String getAttrValue(){
        return this.attrValue;
    }

}
