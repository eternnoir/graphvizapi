package org.enoir.graphvizapi.exception;

/**
 * Created by frank on 2014/11/27.
 */
public class AttributeNotFondException extends BaseException {
    private final String IDTAG = "GRAPH ID:";
    private final String ATTRTAG = "Attrbute :";
    public AttributeNotFondException(String message) {
        super(message);
    }
}
