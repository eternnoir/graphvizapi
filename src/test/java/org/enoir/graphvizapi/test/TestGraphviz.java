package org.enoir.graphvizapi.test;

import org.enoir.graphvizapi.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by frank on 2014/11/21.
 */
public class TestGraphviz {

    @Test
    public void testGenImage() {
        Graphviz gz = new Graphviz("/usr/bin/dot","./");
                Graph graph = new Graph("g1", GraphType.DIGRAPH);
        graph.addAttributes(new Attributes(  "rankdir","LR"));
        Node n1 = new Node("N");
        n1.addAttributes(new Attributes("label","\" Node1 \""));
        Node n2 = new Node("N2");
        Node n3 = new Node("N3");

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addEdge(new Edge("", n1, n2));
        graph.addEdge(new Edge("", n2, n3));
        graph.addEdge(new Edge("",n3,n1));
        graph.addEdge(new Edge("",n3,n1));

        String type = "png";
        byte[] bytearray = gz.getGraphByteArray(graph, type, "100");
        String md5str = getByteArrayMd5(bytearray);
        Assert.assertEquals(md5str,"ee8629a6a222af4601d506d005dade81");
    }

    private String getByteArrayMd5(byte[] bytes){
        String ret = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            ret = getChecksumString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    private String getChecksumString(byte[] mdbyte){
        String result = "";
        for (int i=0; i < mdbyte.length; i++) {
            result += Integer.toString( ( mdbyte[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

}
