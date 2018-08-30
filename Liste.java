package at.aau.raunig;




import javax.swing.*;
import java.awt.*;
import java.awt.Color;
        import java.awt.Container;

        import javax.swing.DefaultListModel;
        import javax.swing.JFrame;
        import javax.swing.JList;

public class Liste{

    private JFrame frameApplikation;
    private Container containerApplikation;

    // Liste
    private JList liste;

    // Listen Modell
    private DefaultListModel modell;

    public Liste(){

        //Set Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

        } catch(Exception e) {
            e.printStackTrace();
        }

        frameApplikation = new JFrame();
        frameApplikation.setTitle("Beispiel einer Liste mit bunter Schrift");

        liste = new JList();
        modell = new DefaultListModel();

        liste.setModel(modell);
        liste.setCellRenderer(new LVListCellRenderer());

       // liste.setCellRenderer(new PersonListCellRenderer());

        /*
        Person person1 = new Person("Stefan Raab", new Color(23, 59, 159));
        Person person2 = new Person("Oliver Pocher", Color.GREEN);
        Person person3 = new Person("Elton", new Color(244, 16, 159));
        Person person4 = new Person("Hans-Martin", Color.RED);
        modell.addElement(person1);
        modell.addElement(person2);
        modell.addElement(person3);
        modell.addElement(person4);
        */

        Lehrveranstaltung lv1 = new Lehrveranstaltung(213, Lehrveranstaltung.Typ.NONE,"sda",2,null, Lehrveranstaltung.Slot.MI16,Color.ORANGE);
        Lehrveranstaltung lv2 = new Lehrveranstaltung(213, Lehrveranstaltung.Typ.NONE,"sda",2,null, Lehrveranstaltung.Slot.MI16,Color.BLACK);
        Lehrveranstaltung lv3 = new Lehrveranstaltung(213, Lehrveranstaltung.Typ.NONE,"sda",2,null, Lehrveranstaltung.Slot.MI16,Color.GREEN);
        Lehrveranstaltung lv4 = new Lehrveranstaltung(213, Lehrveranstaltung.Typ.NONE,"sda",2,null, Lehrveranstaltung.Slot.MI16,Color.YELLOW);
        Lehrveranstaltung lv5 = new Lehrveranstaltung(213, Lehrveranstaltung.Typ.NONE,"sda",2,null, Lehrveranstaltung.Slot.MI16,Color.ORANGE);

        modell.addElement(lv1);
        modell.addElement(lv2);
        modell.addElement(lv3);
        modell.addElement(lv4);
        modell.addElement(lv5);



        containerApplikation = frameApplikation.getContentPane();
        containerApplikation.add(liste);

        frameApplikation.pack();
        frameApplikation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameApplikation.setVisible(true);
    }

    public static void main(String[] args) {
        new Liste();
    }
}
