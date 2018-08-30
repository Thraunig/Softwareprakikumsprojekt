package at.aau.raunig;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.xml.transform.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ManageXML {
File inputFile, outPutfile;
    DocumentBuilderFactory factory;
    DocumentBuilder dBuilder;
    DocumentBuilderFactory dbFactory;
    Document doc = null;

public Document  xmlRead(boolean erstesRead, File file){
    factory = DocumentBuilderFactory.newInstance();
    dBuilder = null;

    if(erstesRead){
        System.out.println(this.getClass());
      InputStream inputStream =  this.getClass().getResourceAsStream("SommersemesterStundenobjekte.xml");

        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            try {
                doc = dBuilder.parse(inputStream);

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("Fehler XML Factory Builder");
        }

        }
    else{

        inputFile = file;
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



    }


    doc.getDocumentElement().normalize();
    //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    //System.out.println("----------------------------");
    return doc;
}
/*
Write the XML File of the Schedule
 */
public void xmlWrite(List<Lehrveranstaltung> lehrveranstaltungList, List<LVLeiter> leiterList){
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    try {
        builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    }
    Document doc = builder.newDocument();

    Element root = doc.createElement( "LVSAMMLUNG");
    doc.appendChild(root);

    //For Test:
   // root.appendChild(createLV(doc, 234342, Lehrveranstaltung.Typ.NONE,"Syssec" , 3,1,"Khan", Lehrveranstaltung.Slot.MI8));
    //root.appendChild(createLeiter(doc,99,"Raunig"));

    for (Lehrveranstaltung lv: lehrveranstaltungList
         ) {
        root.appendChild(createLV(doc,lv.nummer,lv.typ,lv.name,lv.semester,lv.getLVLeiter().LeiterID,lv.getLVLeiter().name,lv.slot));
    }

    for (LVLeiter leiter: leiterList
         ) {
        root.appendChild(createLeiter(doc,leiter.LeiterID,leiter.name));
    }


    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transf = null;
    try {
         transf = transformerFactory.newTransformer();
    } catch (TransformerConfigurationException e) {
        e.printStackTrace();
    }

    transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    DOMSource source = new DOMSource(doc);
    //FileChooser
    JFileChooser chooser = new JFileChooser();
    chooser.setSelectedFile(new File("xml/ExportStundenplan.xml"));
    chooser.setFileFilter(new FileFilter() {

        public String getDescription() {
            return "XML Datein (*.xml)";
        }

        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            } else {
                String filename = f.getName().toLowerCase();
                return filename.endsWith(".xml") || filename.endsWith(".xml") ;
            }
        }
    });
    int rueckgabeWert  = chooser.showSaveDialog(null);
    if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
    {
        // Ausgabe der ausgewaehlten Datei
        System.out.println("Die zu speichernde Datei ist: " +
                chooser.getSelectedFile().getName());
    }

    File myFile = chooser.getSelectedFile();

    StreamResult console = new StreamResult(System.out);
    StreamResult file = new StreamResult(myFile);
    transf.setOutputProperty(OutputKeys.INDENT, "yes");

    try {
        transf.transform(source, console);
        transf.transform(source, file);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

/*
Hinzufügegn von Node LV
 */
    private static Node createLV(Document doc, int nummer, Lehrveranstaltung.Typ typ, String name,
                                 int semester, int leiterID, String leitername,
                                 Lehrveranstaltung.Slot slot) {
        Element lv = doc.createElement("LV");
        lv.appendChild(createUserElement(doc, "NUMMER", Integer.toString(nummer)));
        lv.appendChild(createUserElement(doc, "TYP",typ.name() ));
        lv.appendChild(createUserElement(doc, "Name", name ));
        lv.appendChild(createUserElement(doc, "SEMESTER", Integer.toString(semester) ));
        lv.appendChild(createUserElement(doc, "LEITERID", Integer.toString(leiterID)));
        lv.appendChild(createUserElement(doc, "LEITERNAME",leitername ));
        lv.appendChild(createUserElement(doc, "SLOT",slot.name() ));
        return lv;
    }
    /*
    Hinzufügen von Node LEITER
     */
    private static Node createLeiter(Document doc, int id, String name) {
        Element leiter = doc.createElement("LEITER");
        leiter.appendChild(createUserElement(doc, "ID", Integer.toString(id)));
        leiter.appendChild(createUserElement(doc, "Name",name ));
        return leiter;
    }

/*
Hinzufügen von "Blättern"
 */
    private static Node createUserElement(Document doc, String name,
                                          String value) {

        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }






public List<LVLeiter> getXMLLvLeiter(boolean erstmaligerStart, File file){
    Document doc = xmlRead(erstmaligerStart, file);
    List<LVLeiter> professorenListe = new ArrayList<LVLeiter>();
    NodeList nList = doc.getElementsByTagName("LEITER");

    for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        Element eElement = (Element) nNode;
        LVLeiter tempLeiter = new LVLeiter(eElement.getElementsByTagName("Name").item(0).getTextContent(),Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent()));
        professorenListe.add(tempLeiter);
        // System.out.println(tempLeiter.LeiterID + " " +tempLeiter.LVLeitertoString());
    }
    return professorenListe;
}

    public List<Lehrveranstaltung> getXMLLehrveranstaltungen(boolean erstmaligerStart, File file){
        Document doc = xmlRead(erstmaligerStart, file);
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
                  semester,
                    null,
                    Lehrveranstaltung.Slot.valueOf(eElement.getElementsByTagName("SLOT").item(0).getTextContent()));

            int leiterID = -1;
            if(eElement.getElementsByTagName("LEITERID").item(0).getTextContent() != ""){
                leiterID =Integer.parseInt(eElement.getElementsByTagName("LEITERID").item(0).getTextContent().split("und",10)[0]);

            }
            //  System.out.println("LeiterID " + leiterID);
            tempLV.setLeiterID(leiterID);



            lvListe.add(tempLV);
           // System.out.println(tempLV.LVtoString());
        }

        return lvListe;
    }






}
