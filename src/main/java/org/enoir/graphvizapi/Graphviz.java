package org.enoir.graphvizapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 * Created by frank on 2014/11/17.
 */
public class Graphviz {

    private final static String osName = System.getProperty("os.name").replaceAll("\\s", "");
    private final static String cfgProp = "config.properties";
    private final static Properties configFile = new Properties() {
        private final static long serialVersionUID = 1L; {
            try {
                load(new FileInputStream(cfgProp));
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    };
    private static String DOT = configFile.getProperty("dotFor" + osName);
    private static String TMP_PATH = configFile.getProperty("tempDirFor" + osName);

    public Graphviz() {

    }

    public byte[] getGraph(String dot_source, String type, String representationType,String dpi)
    {
        File dot;
        byte[] img_stream = null;

        try {
            dot = writeDotSourceToFile(dot_source);
            if (dot != null)
            {
                img_stream = get_img_stream(dot, type, representationType,dpi);
                if (dot.delete() == false) {

                }
                return img_stream;
            }
            return null;
        } catch (java.io.IOException ioe) { return null; }
    }

    private File writeDotSourceToFile(String str) throws java.io.IOException
    {
        File temp;
        try {
            temp = File.createTempFile("graph_", ".dot.tmp", new File(Graphviz.TMP_PATH));
            FileWriter fout = new FileWriter(temp);
            fout.write(str);
            fout.close();
        }
        catch (Exception e) {
            return null;
        }
        return temp;
    }

    private byte[] get_img_stream(File dot, String type, String representationType,String dpi)
    {
        File imgFile;
        byte[] imgageStream = null;

        try {
            imgFile = File.createTempFile("graphviz_", "."+type, new File(Graphviz.TMP_PATH));
            Runtime rt = Runtime.getRuntime();

            String[] args = {DOT, "-T"+type, "-K"+representationType, "-Gdpi="+dpi, dot.getAbsolutePath(), "-o", imgFile.getAbsolutePath()};
            Process p = rt.exec(args);
            p.waitFor();

            FileInputStream finput = new FileInputStream(imgFile.getAbsolutePath());
            imgageStream = new byte[finput.available()];
            finput.read(imgageStream);
            if( finput != null ){
                finput.close();
            }
            if (imgFile.delete() == false) {
            }
        }
        catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return imgageStream;
    }

}
