import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

class ChampoinshipFinder {

    public static void main(String[] args) {

        Document doc = null;

        File f = new File("src/main/resources/newtest.xml");

        try {
            // Das Dokument erstellen
            SAXBuilder builder = new SAXBuilder();
            doc = builder.build(f);
            XMLOutputter fmt = new XMLOutputter();

            // komplettes Dokument ausgeben
            //fmt.output(doc, System.out);

            // Wurzelelement ausgeben
            Element element = doc.getRootElement();
            System.out.println("\nWurzelelement: " + element);

            // Wurzelelementnamen ausgeben
            System.out.println("Wurzelelementname: " + element.getName());

            // Eine Liste aller direkten Kindelemente eines Elementes erstellen
            List<Element> alleKinder = element.getChildren();

            //ListIterator<Element> listIterator = alleKinder.listIterator();
            //while (listIterator.hasNext())
            //{
            //    System.out.println(listIterator.next().getChild("title").getValue());
            //}

            alleKinder.stream().filter(c -> c.getAttribute("id").getValue().equals("421"))
                    .forEach(c -> c.getChildren("event").stream().
                            forEach(cc -> System.out.println(cc.getChild("issftitle").getValue())));

            alleKinder.stream().forEach(c -> c.getChildren("event").stream()
                    .filter(cc -> cc.getChild("issftitle").getValue().equals("Final Double Trap Men"))
                    .forEach(cc -> System.out.println(cc.getAttribute("id"))));

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

