package org.enoir.graphvizapi;

import org.enoir.graphvizapi.exception.AttributeNotFondException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2014/11/19.
 */
public abstract class BaseGraphObject {
    private String id;
    private List<Attribute> attrList;
    public BaseGraphObject(String id) {
        this.id = id;
        attrList = new ArrayList<Attribute>();
    }

    public void addAttribute(Attribute attr){
        this.attrList.add(attr);
    }

    public void removeAttribute(String name){
        List<Attribute> removeList = new ArrayList<Attribute>();
        for(Attribute attr : this.attrList){
            if(attr.getAttrName().equals(name)){
                removeList.add(attr);
            }
        }
        if(removeList.size()==0){
            throw new AttributeNotFondException("ID: "+id+";attribute:"+name);
        }
        for(Attribute attr: removeList){
            this.attrList.remove(attr);
        }
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String genAttributeDotString(){
        StringBuilder attrDotString = new StringBuilder();
        for(Attribute attr : this.attrList){
            attrDotString.append(attr.getAttrName()+"="+attr.getAttrValue()+";\n");
        }
        return attrDotString.toString();
    }

    abstract public String genDotString();

}
