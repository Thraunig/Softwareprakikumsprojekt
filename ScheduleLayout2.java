package at.aau.raunig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ScheduleLayout2 {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;
    private JList list6;
    private JList list7;
    private JList list8;
    private JList list9;
    private JList list10;
    private JList list11;
    private JList list12;
    private JList list13;
    private JList list14;
    private JList list15;
    private JList list16;
    private JList list17;
    private JList list18;
    private JList list19;
    private JList list20;
    private JList list21;
    private JList list22;
    private JList list23;
    private JList list24;
    private JList list25;
    private JList list26;
    private JList list27;
    private JList list28;
    private JList list29;
    private JList list30;
    private JList listM8;
    private JList listM10;
    private JList listM12;
    private JList listM14;
    private JList listM16;
    private JList listM18;
    private JList listD8;
    private JList listD10;
    private JList listD12;
    private JList listD14;
    private JList listD16;
    private JList listD18;
    private JList listMI10;
    private JList listMI12;
    private JList listMI14;
    private JList listMI16;
    private JList listMI18;
    private JList listMI8;
    private JList listDO8;
    private JList listDO10;
    private JList listDO12;
    private JList listDO14;
    private JList listDO16;
    private JList listDO18;
    private JList listF8;
    private JList listF10;
    private JList listF12;
    private JList listF14;
    private JList listF16;
    private JList listF18;
    private JPanel M8;
    private JPanel M10;
    private JPanel M12;
    private JPanel M14;
    private JPanel M16;
    private JPanel M18;
    private JPanel D8;
    private JPanel D10;
    private JPanel D12;
    private JPanel D14;
    private JPanel D16;
    private JPanel D18;
    private JPanel DO8;
    private JPanel DO10;
    private JPanel DO12;
    private JPanel DO14;
    private JPanel DO16;
    private JPanel DO18;
    private JPanel F8;
    private JPanel F10;
    private JPanel F12;
    private JPanel F14;
    private JPanel F16;
    private JPanel F18;
    private JPanel MI8;
    private JPanel MI10;
    private JPanel MI12;
    private JPanel MI14;
    private JPanel MI16;
    private JPanel MI18;

    DefaultListModel listModeM8 = new DefaultListModel();
    DefaultListModel listModeM10 = new DefaultListModel();
    DefaultListModel listModeM12 = new DefaultListModel();
    DefaultListModel listModeM14 = new DefaultListModel();
    DefaultListModel listModeM16 = new DefaultListModel();
    DefaultListModel listModeM18 = new DefaultListModel();
    DefaultListModel listModeD8 = new DefaultListModel();
    DefaultListModel listModeD10 = new DefaultListModel();
    DefaultListModel listModeD12 = new DefaultListModel();
    DefaultListModel listModeD14 = new DefaultListModel();
    DefaultListModel listModeD16 = new DefaultListModel();
    DefaultListModel listModeD18 = new DefaultListModel();
    DefaultListModel listModeMI8 = new DefaultListModel();
    DefaultListModel listModeMI10 = new DefaultListModel();
    DefaultListModel listModeMI12 = new DefaultListModel();
    DefaultListModel listModeMI14 = new DefaultListModel();
    DefaultListModel listModeMI16 = new DefaultListModel();
    DefaultListModel listModeMI18 = new DefaultListModel();
    DefaultListModel listModeDO8 = new DefaultListModel();
    DefaultListModel listModeDO10 = new DefaultListModel();
    DefaultListModel listModeDO12 = new DefaultListModel();
    DefaultListModel listModeDO14 = new DefaultListModel();
    DefaultListModel listModeDO16 = new DefaultListModel();
    DefaultListModel listModeDO18 = new DefaultListModel();
    DefaultListModel listModeF8 = new DefaultListModel();
    DefaultListModel listModeF10 = new DefaultListModel();
    DefaultListModel listModeF12 = new DefaultListModel();
    DefaultListModel listModeF14 = new DefaultListModel();
    DefaultListModel listModeF16 = new DefaultListModel();
    DefaultListModel listModeF18 = new DefaultListModel();

    ArrayList<JList> listJlisten = new ArrayList<>();
    ListTransferHandler lh;


    public ScheduleLayout2() {
        lh = new ListTransferHandler();


        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                list1.setBackground(Color.RED);
            }
        });
    }

    public void initialLists() {

        /*listModeM8.addElement("OMI");

        listModeM16.addElement(new LVLeiter("Hans", 777).LVLeitertoString());


        listModeD8.addElement("WIWI Info");*/

        LVLeiter lvLeiter = new LVLeiter("Schartner", 33);
        Lehrveranstaltung lehrveranstaltung = new Lehrveranstaltung(620004, Lehrveranstaltung.Typ.VK, "Syssec", 3, lvLeiter, Lehrveranstaltung.Slot.F8);

        listModeF8.addElement(lehrveranstaltung.LVtoString());

        /*
        Iterieren über jede jList
         */
        for (JList jList : listJlisten
                ) {
            jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jList.setDragEnabled(true);
            jList.setTransferHandler(lh);
            jList.setDropMode(DropMode.INSERT);
            setMappings(jList);
        }


    }

    public void insertLehrveranstaltungen(List<Lehrveranstaltung> lehrveranstaltungList) {
        Lehrveranstaltung.Slot slot;
        for (Lehrveranstaltung temp : lehrveranstaltungList
                ) {
            slot = temp.slot;

            switch (slot) {
                case M8:
                    listModeM8.addElement(temp.LVtoString());
                    break;
                case M10:
                    listModeM10.addElement(temp.LVtoString());
                    break;
                case M12:
                    listModeM12.addElement(temp.LVtoString());
                    break;
                case M14:
                    ;listModeM14.addElement(temp.LVtoString());
                    break;
                case M16:
                    listModeM16.addElement(temp.LVtoString());
                    break;
                case M18:
                    listModeM18.addElement(temp.LVtoString());
                    break;
                case D8:
                    listModeD8.addElement(temp.LVtoString());
                    break;
                case D10:
                    listModeD10.addElement(temp.LVtoString());
                    break;
                case D12:
                    listModeD12.addElement(temp.LVtoString());
                    break;
                case D14:
                    listModeD14.addElement(temp.LVtoString());
                    break;
                case D16:
                    listModeD16.addElement(temp.LVtoString());
                    break;
                case D18:
                    listModeD18.addElement(temp.LVtoString());
                    break;
                case MI8:
                    listModeMI8.addElement(temp.LVtoString());
                    break;
                case MI10:
                    listModeMI10.addElement(temp.LVtoString());
                    break;
                case MI12:
                    listModeMI12.addElement(temp.LVtoString());
                    break;
                case MI14:
                    listModeMI14.addElement(temp.LVtoString());
                    break;
                case MI16:
                    listModeMI16.addElement(temp.LVtoString());
                    break;
                case MI18:
                    listModeMI18.addElement(temp.LVtoString());
                    break;
                case DO8:
                    listModeDO8.addElement(temp.LVtoString());
                    break;
                case DO10:
                    listModeDO10.addElement(temp.LVtoString());
                    break;
                case DO12:
                    listModeDO12.addElement(temp.LVtoString());
                    break;
                case DO14:
                    listModeDO14.addElement(temp.LVtoString());
                    break;
                case DO16:
                    listModeDO16.addElement(temp.LVtoString());
                    break;
                case DO18:
                    listModeDO18.addElement(temp.LVtoString());
                    break;
                case F8:
                    listModeF8.addElement(temp.LVtoString());
                    break;
                case F10:
                    listModeF10.addElement(temp.LVtoString());
                    break;
                case F12:
                    listModeF12.addElement(temp.LVtoString());
                    break;
                case F14: listModeF14.addElement(temp.LVtoString());
                    break;
                case F16:
                    listModeF16.addElement(temp.LVtoString());
                    break;
                case F18:
                    listModeF18.addElement(temp.LVtoString());
                    break;
            }
        }}

    private void setMappings(JList list) {
        ActionMap map = list.getActionMap();
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),
                TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
                TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
                TransferHandler.getPasteAction());
    }

    public void stickJListtogether() {
        listJlisten.add(listM8);
        listJlisten.add(listM10);
        listJlisten.add(listM12);
        listJlisten.add(listM14);
        listJlisten.add(listM16);
        listJlisten.add(listM18);
        listJlisten.add(listD8);
        listJlisten.add(listD10);
        listJlisten.add(listD12);
        listJlisten.add(listD14);
        listJlisten.add(listD16);
        listJlisten.add(listD18);
        listJlisten.add(listMI8);
        listJlisten.add(listMI10);
        listJlisten.add(listMI12);
        listJlisten.add(listMI14);
        listJlisten.add(listMI16);
        listJlisten.add(listMI18);
        listJlisten.add(listDO8);
        listJlisten.add(listDO10);
        listJlisten.add(listDO12);
        listJlisten.add(listDO14);
        listJlisten.add(listDO16);
        listJlisten.add(listDO18);
        listJlisten.add(listF8);
        listJlisten.add(listF10);
        listJlisten.add(listF12);
        listJlisten.add(listF14);
        listJlisten.add(listF16);
        listJlisten.add(listF18);
    }

    public void setModels4All() {
        listM8.setModel(listModeM8);
        listM10.setModel(listModeM10);
        listM12.setModel(listModeM12);
        listM14.setModel(listModeM14);
        listM16.setModel(listModeM16);
        listM18.setModel(listModeM18);
        listD8.setModel(listModeD8);
        listD10.setModel(listModeD10);
        listD12.setModel(listModeD12);
        listD14.setModel(listModeD14);
        listD16.setModel(listModeD16);
        listD18.setModel(listModeD18);
        listMI8.setModel(listModeMI8);
        listMI10.setModel(listModeMI10);
        listMI12.setModel(listModeMI12);
        listMI14.setModel(listModeMI14);
        listMI16.setModel(listModeMI16);
        listMI18.setModel(listModeMI18);
        listDO8.setModel(listModeDO8);
        listDO10.setModel(listModeDO10);
        listDO12.setModel(listModeDO12);
        listDO14.setModel(listModeDO14);
        listDO16.setModel(listModeDO16);
        listDO18.setModel(listModeDO18);
        listF8.setModel(listModeF8);
        listF10.setModel(listModeF10);
        listF12.setModel(listModeF12);
        listF14.setModel(listModeF14);
        listF16.setModel(listModeF16);
        listF18.setModel(listModeF18);
    }

    private static void createAndShowGUI(javax.swing.JFrame frame, ScheduleLayout2 scheduleLayout) {

        frame.setContentPane(scheduleLayout.panel1);
        frame.pack();
        frame.setVisible(true);
    }




    public static void main(String[] args) {
//XML inputRead
        ManageXML manageXML = new ManageXML();
        List<LVLeiter> lvLeiterList = manageXML.getXMLLvLeiter();
        List<Lehrveranstaltung> lehrveranstaltungList = manageXML.getXMLLehrveranstaltungen();

        JFrame frame = new JFrame("Informatik Stundenplan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ScheduleLayout2 scheduleLayout = new ScheduleLayout2();

        //Zusammenfügen der Jlists in Arrayliste
        scheduleLayout.stickJListtogether();
        scheduleLayout.initialLists();
        scheduleLayout.insertLehrveranstaltungen(lehrveranstaltungList);

        //setModels
        scheduleLayout.setModels4All();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createAndShowGUI(frame,scheduleLayout);
            }
        });


    }
}
