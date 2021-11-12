import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.XMLOutputter;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLCreator {
    public static void main(String[] args) {
        try {
            Element root = new Element("wurzel");
            Document dokument = new Document(root);
            root.addContent(new Element("kind1").addContent("sohn ohne Nachkommen")
                    .addContent(new Element("kind2").addContent(new Element("enkel1")
                            .addContent("enkel")).addContent(new Element("enkel2")
                            .addContent("enkelin"))).addContent(new Element("kind3")
                            .addContent("tochter")));

            XMLOutputter outputter = new XMLOutputter();
            FileOutputStream output;

            output = new FileOutputStream("src/main/resources/muster.xml");
            outputter.output(dokument,output);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
