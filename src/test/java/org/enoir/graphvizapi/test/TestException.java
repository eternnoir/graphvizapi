package org.enoir.graphvizapi.test;
import org.enoir.graphvizapi.Attributes;
import org.enoir.graphvizapi.Node;
import org.enoir.graphvizapi.exception.AttributeNotFondException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by frank on 2014/11/27.
 */
public class TestException {
    @Test
    public void TestAttributeNotFond(){
        try {
            Node node = new Node("testId");
            node.addAttributes(new Attributes("color", "#000"));
            node.removeAttributes("label");
        }catch (AttributeNotFondException e) {
            Assert.assertTrue(true);
        }catch (Exception ex){
            Assert.assertTrue(false);
        }
    }
}

