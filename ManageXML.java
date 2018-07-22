package at.aau.raunig;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageXML {
File inputFile, outPutfile;
    DocumentBuilderFactory factory;
    DocumentBuilder dBuilder;
    DocumentBuilderFactory dbFactory;
    Document doc = null;


public Document  xmlRead(){
    inputFile = new File("C:\\Users\\thoma\\IdeaProjects\\SoftwareprakikumsprojektSPLStundenplanRaunigThomas\\src\\at\\aau\\raunig\\SommersemesterStundenobjekte.xml");
    factory = DocumentBuilderFactory.newInstance();
    dBuilder = null;

    try {
         dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();

        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
        System.out.println("Fehler XML Factory Builder");
    }
    doc.getDocumentElement().normalize();
    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    System.out.println("----------------------------");
    return doc;
}

public List<LVLeiter> getXMLLvLeiter(){
    Document doc = xmlRead();
    List<LVLeiter> professorenListe = new ArrayList<LVLeiter>();
    NodeList nList = doc.getElementsByTagName("LEITER");

    for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        Element eElement = (Element) nNode;
        LVLeiter tempLeiter = new LVLeiter(eElement.getElementsByTagName("Name").item(0).getTextContent(),Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent()));
        professorenListe.add(tempLeiter);
        System.out.println(tempLeiter.LeiterID + " " +tempLeiter.LVLeitertoString());
    }

    return professorenListe;
}

    public List<Lehrveranstaltung> getXMLLehrveranstaltungen(){
        Document doc = xmlRead();
        List<Lehrveranstaltung> lvListe = new ArrayList<Lehrveranstaltung>();
        NodeList nList = doc.getElementsByTagName("LV");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            int t = temp+1;

            Lehrveranstaltung.Typ typ;
            String typString = eElement.getElementsByTagName("TYP").item(0).getTextContent();
            if( typString == "" | typString == " " | typString=="."){
                typ = Lehrveranstaltung.Typ.NONE;
            }
            else{
                typ = Lehrveranstaltung.Typ.valueOf(typString);
            }

            int semester = 0;
            if(eElement.getElementsByTagName("SEMESTER").item(0).getTextContent() != ""){
                semester = Integer.parseInt(eElement.getElementsByTagName("SEMESTER").item(0).getTextContent());
            }

            Lehrveranstaltung tempLV = new Lehrveranstaltung(Integer.parseInt(eElement.getElementsByTagName("NUMMER").item(0).getTextContent()),
                    typ,
                    eElement.getElementsByTagName("Name").item(0).getTextContent(),
                  0,
                    null,
                    Lehrveranstaltung.Slot.valueOf(eElement.getElementsByTagName("SLOT").item(0).getTextContent()));


            lvListe.add(tempLV);
            System.out.println(tempLV.LVtoString());
        }

        return lvListe;
    }






}
