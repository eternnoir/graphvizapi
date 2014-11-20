package example;

import java.io.File;
import java.io.FileOutputStream;

import org.enoir.graphvizapi.*;

/**
 * Created by frank on 2014/11/20.
 */
public class apiExample {
    public static void main(String[] args)
    {
        apiExample ex = new apiExample ();
        ex.draw();
    }
    private void draw()
    {
        Graphviz gv = new Graphviz();
        Graph graph = new Graph("g1", GraphType.DIGRAPH);
        Node n1 = new Node("N1");
        n1.addAttributes(new Attributes("label","\" Node1 \""));
        Node n2 = new Node("N2");
        Node n3 = new Node("N3");

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addEdge(new Edge("", n1, n2));
        graph.addEdge(new Edge("", n2, n3));
        graph.addEdge(new Edge("",n3,n1));


        String type = "png";

        File out = new File("/tmp/out."+ type);
        this.writeGraphToFile( gv.getGraphByteArray(graph, type, "100"), out );
    }

    public int writeGraphToFile(byte[] img, File to)
    {
        try {
            FileOutputStream fos = new FileOutputStream(to);
            fos.write(img);
            fos.close();
        } catch (java.io.IOException ioe) { return -1; }
        return 1;
    }
}
