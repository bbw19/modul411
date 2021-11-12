import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAXLesen extends DefaultHandler {
    static final String neueZeile = System.getProperty("line.separator");

    static private Writer out = null;

    private StringBuffer textBuffer = null;

    public static void main(String[] argv) {

        // SAX-EventHandler erstellen
        DefaultHandler handler = new SAXLesen();

        // Inhalt mit dem Default-Parser parsen
        SAXParser saxParser;

        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(new File("src/main/resources/xml_file.xml"), handler);
        } catch (ParserConfigurationException pe) {
            pe.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    // SAX DefaultHandler Methoden

    public void startDocument() throws SAXException {
        ausgabe("auf geht's!" + neueZeile);
    }

    public void endDocument() throws SAXException {
        ausgabe("finito!" + neueZeile);
    }

    // Starttag auslesen
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attrs) throws SAXException {
        textPuffer();
        String eName = ("".equals(localName)) ? qName : localName;
        ausgabe("<" + eName);

        // Erfassen der Attribute in den Starttags
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                String aName = attrs.getLocalName(i);
                if ("".equals(aName))
                    aName = attrs.getQName(i);
                ausgabe(" " + aName + "=\"" + attrs.getValue(i) + "\"");
            }
        }
        ausgabe(">");
    }

    // Schlusstags auslesen
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        textPuffer();
        String eName = ("".equals(localName)) ? qName : localName;
        ausgabe("</" + eName + ">");
    }

    // Erzeugt einen String aus den Char-Arrays und liest
    // diesen in einen StringBuffer ein
    public void characters(char[] buf, int offset, int len) throws SAXException {
        String s = new String(buf, offset, len);
        if (textBuffer == null)
            textBuffer = new StringBuffer(s);
        else
            textBuffer.append(s);
    }

    /** ************** Hilfsmethoden ******************* */

    // Wandelt den StringBuffer in einen String und
    // &uuml;bergibt ihn zur Ausgabe
    // "xxx" verdeutlicht die Arbeitsweise
    private void textPuffer() throws SAXException {
        if (textBuffer == null)
            return;
        ausgabe("xxx" + textBuffer.toString());
        textBuffer = null;
    }

    // Ausgabe des Strings
    // "+++" verdeutlicht die Arbeitsweise
    private void ausgabe(String s) throws SAXException {
        try {
            if (out == null)
                out = new OutputStreamWriter(System.out, "UTF8");
            out.write(s + "+++");
            out.flush();
        } catch (IOException ex) {
            throw new SAXException("Ein-/Ausgabefehler", ex);
        }
    }
}
