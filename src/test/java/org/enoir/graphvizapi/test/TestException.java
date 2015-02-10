package org.enoir.graphvizapi.test;
import org.enoir.graphvizapi.Attribute;
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
            node.addAttribute(new Attribute("color", "#000"));
            node.removeAttribute("label");
        }catch (AttributeNotFondException e) {
            Assert.assertTrue(true);
        }catch (Exception ex){
            Assert.assertTrue(false);
        }
    }
}

