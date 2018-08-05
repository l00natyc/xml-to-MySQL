/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecb_java;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author stefan
 */
public class ReadValues {

    private String[] currencyListe;
    private String[] rateListe;
    private String datum;

    public String[] ausgabeliste() {
        try {

            InputStream is = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml").openStream(); // täglich aktualisierte Wechselkurse der EZB 
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            NodeList nodeList = doc.getElementsByTagName("Cube");

            rateListe = new String[nodeList.getLength()];
            currencyListe = new String[nodeList.getLength()];

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String dasDatum = element.getAttribute("time");

                if (i == 1) {
                    System.out.println("Datum = " + dasDatum);
                }

                if (i > 1) {

                    rateListe[i] = element.getAttribute("rate");
                    currencyListe[i] = element.getAttribute("currency");
                    //              myDoublelist[i] = Double.parseDouble(rateListe[i]); //String auf double casten und in Array speichern
                    //              System.out.println("1 EUR = " + rateListe[i] + " " + currencyListe[i]);
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {

        }
        return rateListe;
    }

    public String[] currencyListe() {
        return currencyListe;
    }

    public String[] rateListe() {
        return rateListe;
    }

    public String dateMethod() {
        try {

            InputStream is = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml").openStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            NodeList nodeList = doc.getElementsByTagName("Cube");
            Node node = nodeList.item(1);
            Element element = (Element) node;
            String dasDatum = element.getAttribute("time");
            datum = dasDatum;

        } catch (IOException | ParserConfigurationException | SAXException e) {

        }
        return datum;
    }
}
