package org.enoir.graphvizapi;

/**
 * Created by frank on 2014/11/19.
 */
public class BaseGraphObject {
    private String id;
    public BaseGraphObject(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
}
