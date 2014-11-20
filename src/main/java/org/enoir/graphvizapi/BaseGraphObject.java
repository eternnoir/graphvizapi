package org.enoir.graphvizapi;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2014/11/19.
 */
public abstract class BaseGraphObject {
    private String id;
    private List<Attributes> attrList;
    public BaseGraphObject(String id) {
        this.id = id;
        attrList = new ArrayList<Attributes>();
    }

    public void addAttributes(Attributes attr){
        this.attrList.add(attr);
    }

    public void removeAttributes(String name){
        List<Attributes> removeList = new ArrayList<Attributes>();
        for(Attributes attr : this.attrList){
            if(attr.getAttrName().equals(name)){
                removeList.add(attr);
            }
        }
        if(removeList.size()==0){
            //TODO maybe throw exception
        }
        for(Attributes attr: removeList){
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
        for(Attributes attr : this.attrList){
            attrDotString.append(attr.getAttrName()+"="+attr.getAttrValue()+";\n");
        }
        return attrDotString.toString();
    }

    abstract public String genDotString();

}
