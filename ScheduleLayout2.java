package at.aau.raunig;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.List;


public class ScheduleLayout2 {
    private JPanel hauptPanel;
     JList list1;
     JList list2;
     JList list3;
     JList list4;
     JList list5;
     JList list6;
     JList list7;
     JList list8;
     JList list9;
     JList list10;
     JList list11;
     JList list12;
     JList list13;
     JList list14;
     JList list15;
     JList list16;
     JList list17;
     JList list18;
     JList list19;
     JList list20;
     JList list21;
     JList list22;
     JList list23;
     JList list24;
     JList list25;
     JList list26;
     JList list27;
     JList list28;
     JList list29;
     JList list30;
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
    private JButton neuButton;
    private JButton bearbeitenButton;
    private JButton importBasisXMLButton;
    private JButton exportInXMLButton;
    private JButton farbenZurücksetzenButton;
    private JButton zeigeLVLeiterlisteButton;
    private JButton zeigeLVListeButton;
    private JButton ausblendenDerNummernButton;
    private JButton ausblendenDerNamenButton;
    private JButton importNeuesXMLButton;
    private JButton probierenButton;
    private JButton infoButton;
    private JScrollPane ScrollPaneMain;
    private JLabel labelZeit;
    private JButton filterButton;
    private JButton slotVorschlägeButton;
    private JToolBar kopfToolbar;
    private JButton exitButton;
    private JPanel panel;
    private JButton extrasButton;
    static List<LVLeiter> lvLeiterList;
    static  List<Lehrveranstaltung> lehrveranstaltungList;
    static Plan stundenPlan;
    JList aktuellMarkierteListe = listM8;
    //Monospaced im Artifact sehbar, hier nicht
   // Font myFont = new Font("Courier", Font.PLAIN, 11);
    Font myFont = new Font("Arial", Font.PLAIN, 11);

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
    ArrayList<DefaultListModel> defaultListModels = new ArrayList<>();
    ListTransferHandler lh;


    public ScheduleLayout2() {
        lh = new ListTransferHandler();
        //hauptPanel.setFocusable(true);

        /*
        Lehrveranstaltungen in Listen speichern statt Strings + Cell Renderer nutzen um die Farbe der ELemente zu ändern"!
         */


        /*
        Check Key Listener:
        Enter: Check Constraints
        Back Space: Reset Colors
         */

        hauptPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                    checkConstraints();
                } else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    resetColorSlots();
                }
                else{
                    //NO Default Function
            }
            }
        });

        /*
        Listener zum Zurücksetzen der Farben
         */

        farbenZurücksetzenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetColorSlots();
            }
        });
        zeigeLVLeiterlisteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] choices = new String[lvLeiterList.size()];
                int i = 0;
                for (LVLeiter leiter: lvLeiterList
                     ) {
                    choices[i] = leiter.LVLeitertoStringMitID();
                    i++;
                }
                String input = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter.",
                        "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        choices, // Array of choices
                        choices[1]); // Initial choice
                System.out.println(input);
            }
        });
        zeigeLVListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] choices = new String[lehrveranstaltungList.size()];
                int i = 0;
                for (Lehrveranstaltung lv: lehrveranstaltungList
                        ) {
                    choices[i] = lv.LVtoString() + " \t \t \t \t \t \t"  + lv.slot;
                    i++;
                }
                String input = (String) JOptionPane.showInputDialog(null, "List der Lehrveranstaltungen.",
                        "LV Liste", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        choices, // Array of choices
                        choices[1]); // Initial choice
            }
        });


        /*
        Etwas neues Anlegen
         */
        neuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lehrveranstaltung.Slot slot;
                Lehrveranstaltung.Typ typ;
                Object[] options =  Lehrveranstaltung.Typ.NONE.getDeclaringClass().getEnumConstants();
                LVLeiter lvLeiter;
                int selected;
                String[] choices = {"Lehrveranstaltung", "LV-Leiter","Raum","Eintrag LV Leiter keine Zeit", "Eintrag LV Leiter Präferenzen"};
                //String input = (String) JOptionPane.showInputDialog(null,"Was wollen Sie hinzufügen?","Wählen Sie",JOptionPane.DEFAULT_OPTION,null,choices,choices[0]);

                selected  =  JOptionPane.showOptionDialog(null,
                        "Was wollen Sie dem Stundenplan hinzufügen??",
                        "Neu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, choices, choices[0]);
                if(selected == -1){return;}
                String input = choices[selected];



                 if(input == "LV-Leiter"){
                 String name;
                 name = (String) JOptionPane.showInputDialog(null,"Name des LV Leiters?","Neuen LV-Leiter anlegen", JOptionPane.PLAIN_MESSAGE);
                     if(name == null){return;}
                 lvLeiter = new LVLeiter(name,lvLeiterList.size()-1);
                 lvLeiterList.add(lvLeiter);
                 System.out.println(lvLeiter.LVLeitertoStringMitID());
                 }
                 else if (input == "Lehrveranstaltung"){
                    Lehrveranstaltung neueLV;
                    String name;
                    int nummer,semester;

                    name = (String)JOptionPane.showInputDialog(null,"Name der Lehrverantaltung?","LVName?", JOptionPane.PLAIN_MESSAGE);
                    if(name == null){                                return;                            }
                    String in = (String) JOptionPane.showInputDialog(null,"LVNummer?","LVNummer?", JOptionPane.PLAIN_MESSAGE);
                    if(in == null){                                return;                            }
                    if(!isInt(in)){
                        return;
                    }
                    nummer = Integer.parseInt(in);
                    in = JOptionPane.showInputDialog(null,"Semester?","Semester?", JOptionPane.PLAIN_MESSAGE);
                    if(in == null){                                return;                            }
                    semester = Integer.parseInt(in);
                    selected =  JOptionPane.showOptionDialog(null,
                            "Typ der Lehrveranstaltung?",
                            "Typ",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    typ = (Lehrveranstaltung.Typ) options[selected];

                    options =  Lehrveranstaltung.Slot.F8.getDeclaringClass().getEnumConstants();

                    selected  =  JOptionPane.showOptionDialog(null,
                            "Zeitslot?",
                            "Zeitslot",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);

                    slot = (Lehrveranstaltung.Slot) options [selected];


                    String[] choices2 = new String[lvLeiterList.size()];
                    int i = 0;
                    for (LVLeiter leiter: lvLeiterList
                            ) {
                        choices2[i] = leiter.LVLeitertoStringMitID();
                        i++;
                    }
                    String leiterwahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter.",
                            "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null, // Use
                            // default
                            // icon
                            choices2, // Array of choices
                            choices2[1]); // Initial choice
                    if(leiterwahl == null) {return;}
                    String[] split  = leiterwahl.split(" ",7);
                    lvLeiter = lvLeiterList.get(Integer.parseInt(split[0])+1);
                    neueLV = new Lehrveranstaltung(nummer,typ,name,semester,lvLeiter,slot);
                    //Lehrveranstaltung zum Plan hinzufügen
                     stundenPlan.neueLV(neueLV);
                    lehrveranstaltungList.add(neueLV);
                    insertOneLehrveranstaltung(neueLV);

                    System.out.println(neueLV.LVtoString());
                }
                else if(input == "Eintrag LV Leiter keine Zeit") {
                     String[] choices2 = new String[lvLeiterList.size()];
                     int i = 0;
                     for (LVLeiter leiter : lvLeiterList
                             ) {
                         choices2[i] = leiter.LVLeitertoStringMitID();
                         i++;
                     }
                     String leiterwahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter.",
                             "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null, // Use
                             // default
                             // icon
                             choices2, // Array of choices
                             choices2[1]); // Initial choice
                     if (leiterwahl == null) {
                         return;
                     }
                     String[] split = leiterwahl.split(" ", 7);
                     lvLeiter = lvLeiterList.get(Integer.parseInt(split[0]) + 1);
                     options = Lehrveranstaltung.Slot.F8.getDeclaringClass().getEnumConstants();

                     selected = JOptionPane.showOptionDialog(null,
                             "Zu welcher Zeit hat der LV-Leiter keine Zeit?",
                             "Zeitslot",
                             JOptionPane.DEFAULT_OPTION,
                             JOptionPane.INFORMATION_MESSAGE,
                             null, options, options[0]);
                     slot = (Lehrveranstaltung.Slot) options[selected];
                     lvLeiter.setKeineZeit(slot);

                     JOptionPane.showMessageDialog(null, lvLeiter.name + " hat nun im Slot: " + slot + " keine Zeit");
                 }else if(input == "Eintrag LV Leiter Präferenzen"){
                     String[] choices2 = new String[lvLeiterList.size()];
                     int i = 0;
                     for (LVLeiter leiter : lvLeiterList
                             ) {
                         choices2[i] = leiter.LVLeitertoStringMitID();
                         i++;
                     }
                     String leiterwahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter!",
                             "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null, // Use
                             // default
                             // icon
                             choices2, // Array of choices
                             choices2[1]); // Initial choice
                     if (leiterwahl == null) {
                         return;
                     }
                     String[] split = leiterwahl.split(" ", 7);
                     lvLeiter = lvLeiterList.get(Integer.parseInt(split[0]) + 1);
                     options = Lehrveranstaltung.Slot.F8.getDeclaringClass().getEnumConstants();

                     selected = JOptionPane.showOptionDialog(null,
                             "Welche Zeit will die Lehrperson gerne vorwiegend unterrichten?",
                             "Zeitslot Präferenz",
                             JOptionPane.DEFAULT_OPTION,
                             JOptionPane.INFORMATION_MESSAGE,
                             null, options, options[0]);
                     slot = (Lehrveranstaltung.Slot) options[selected];
                     lvLeiter.setPraeferenzen(slot);

                     JOptionPane.showMessageDialog(null, lvLeiter.name + " hat nun im Slot: " + slot + " seinen Präferenzzeitslot");

                }else if(input == "Raum"){
                     options =  Lehrveranstaltung.Slot.F8.getDeclaringClass().getEnumConstants();
                     selected  =  JOptionPane.showOptionDialog(null,
                             "In welchen Zeitslot soll der Raum hinzugefügt werden?",
                             "Zeitslot",
                             JOptionPane.DEFAULT_OPTION,
                             JOptionPane.INFORMATION_MESSAGE,
                             null, options, options[0]);
                     slot = (Lehrveranstaltung.Slot) options [selected];

                     JList jlist = translateSlotToList(slot);

                     String raumName = (String)JOptionPane.showInputDialog(null,"Name des Raumes?","Raumname?", JOptionPane.PLAIN_MESSAGE);
                     if(raumName == null){                                return;                            }

                     DefaultListModel<String> defaultListModel = (DefaultListModel<String>) jlist.getModel();
                     defaultListModel.addElement(raumName);

                }
            }
        });

        /*
        Exportieren des Stundenplans
         */
        exportInXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageXML manageXML = new ManageXML();
                manageXML.xmlWrite(lehrveranstaltungList,lvLeiterList);
            }
        });

        /*
        Importieren eines Stundenplanes
         */
        importNeuesXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
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
                chooser.setSelectedFile(new File("xml/ExportStundenplan.xml"));
                int rueckgabeWert  = chooser.showOpenDialog(null);
                File file = null;


                if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
                {
                    // Ausgabe der ausgewaehlten Datei
                    System.out.println("Die zu speichernde Datei ist: " +
                            chooser.getSelectedFile().getName());
                    file = chooser.getSelectedFile();
                }
                else {return;}

                ManageXML manageXML = new ManageXML();
               lvLeiterList = manageXML.getXMLLvLeiter(false,file);
              lehrveranstaltungList = manageXML.getXMLLehrveranstaltungen(false,file);
              connectLeiterToLehrveranstaltungen();
              resetDefaultListModels();
              insertLehrveranstaltungen(lehrveranstaltungList);
              stundenPlan.createMapping(lehrveranstaltungList);

            }
        });

        /*
        Importieren des Default Stundenplanes
         */
        importBasisXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageXML manageXML = new ManageXML();
                lvLeiterList = manageXML.getXMLLvLeiter(true,null);
                lehrveranstaltungList = manageXML.getXMLLehrveranstaltungen(true,null);
                connectLeiterToLehrveranstaltungen();
                resetDefaultListModels();
                insertLehrveranstaltungen(lehrveranstaltungList);
                stundenPlan.createMapping(lehrveranstaltungList);
            }
        });


        probierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            checkConstraints();

            }
        });

        /*
        Ausblenden aller LV Nummern
         */
        ausblendenDerNummernButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                resetDefaultListModels();
                insertLehrveranstaltungenOhneNummern(lehrveranstaltungList);
            }
        });

        /*
        Einblenden der Nummern, nach Button Release
         */
        ausblendenDerNummernButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                resetDefaultListModels();
                insertLehrveranstaltungen(lehrveranstaltungList);

            }
        });
        ausblendenDerNamenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                resetDefaultListModels();
                insertLehrveranstaltungenNurLVLeiterName(lehrveranstaltungList);
            }
        });
        ausblendenDerNamenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                resetDefaultListModels();
                insertLehrveranstaltungen(lehrveranstaltungList);
            }
        });

        listM8.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            int selectedIndex = listM8.getSelectedIndex();aktuellMarkierteListe= listM8;

                list1.setSelectedIndex(selectedIndex);
            }
        });
        listM10.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listM10.getSelectedIndex();aktuellMarkierteListe= listM10;

                list2.setSelectedIndex(selectedIndex);
            }
        });
        listM12.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listM12.getSelectedIndex();aktuellMarkierteListe= listM12;

                list3.setSelectedIndex(selectedIndex);
            }
        });
        listM14.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listM14.getSelectedIndex();aktuellMarkierteListe= listM14;

                list4.setSelectedIndex(selectedIndex);
            }
        });
        listM16.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listM16.getSelectedIndex();aktuellMarkierteListe= listM16;

                list5.setSelectedIndex(selectedIndex);
            }
        });
        listM18.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listM18.getSelectedIndex();aktuellMarkierteListe= listM18;

                list6.setSelectedIndex(selectedIndex);
            }
        });
        listD8.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD8.getSelectedIndex();aktuellMarkierteListe= listD8;

                list7.setSelectedIndex(selectedIndex);
            }
        });
        listD10.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD10.getSelectedIndex();aktuellMarkierteListe= listD10;

                list8.setSelectedIndex(selectedIndex);
            }
        });
        listD12.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD12.getSelectedIndex();aktuellMarkierteListe= listD12;

                list9.setSelectedIndex(selectedIndex);
            }
        });
        listD14.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD14.getSelectedIndex();aktuellMarkierteListe= listD14;

                list10.setSelectedIndex(selectedIndex);
            }
        });
        listD16.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD16.getSelectedIndex();aktuellMarkierteListe= listD16;

                list11.setSelectedIndex(selectedIndex);
            }
        });
        listD18.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listD18.getSelectedIndex();aktuellMarkierteListe= listD18;

                list12.setSelectedIndex(selectedIndex);
            }
        });
        listMI8.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI8.getSelectedIndex();aktuellMarkierteListe= listMI8;

                list13.setSelectedIndex(selectedIndex);
            }
        });
        listMI10.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI10.getSelectedIndex();aktuellMarkierteListe= listMI10;

                list14.setSelectedIndex(selectedIndex);
            }
        });
        listMI12.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI12.getSelectedIndex();aktuellMarkierteListe= listMI12;

                list15.setSelectedIndex(selectedIndex);
            }
        });
        listMI14.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI14.getSelectedIndex();aktuellMarkierteListe= listMI14;

                list16.setSelectedIndex(selectedIndex);
            }
        });
        listMI16.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI16.getSelectedIndex();aktuellMarkierteListe= listMI16;

                list17.setSelectedIndex(selectedIndex);
            }
        });
        listMI18.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listMI18.getSelectedIndex();aktuellMarkierteListe= listMI18;

                list18.setSelectedIndex(selectedIndex);
            }
        });
        listDO8.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO8.getSelectedIndex();aktuellMarkierteListe= listDO8;

                list19.setSelectedIndex(selectedIndex);
            }
        });
        listDO10.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO10.getSelectedIndex();aktuellMarkierteListe= listDO10;

                list20.setSelectedIndex(selectedIndex);
            }
        });
        listDO12.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO12.getSelectedIndex();aktuellMarkierteListe= listDO12;

                list21.setSelectedIndex(selectedIndex);
            }
        });
        listDO14.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO14.getSelectedIndex();aktuellMarkierteListe= listDO14;

                list22.setSelectedIndex(selectedIndex);
            }
        });
        listDO16.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO16.getSelectedIndex();aktuellMarkierteListe= listDO16;

                list23.setSelectedIndex(selectedIndex);
            }
        });
        listDO18.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listDO18.getSelectedIndex();aktuellMarkierteListe= listDO18;

                list24.setSelectedIndex(selectedIndex);
            }
        });
        listF8.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listF8.getSelectedIndex();aktuellMarkierteListe= listF8;

                list25.setSelectedIndex(selectedIndex);
            }
        });
        listF10.addListSelectionListener(e -> {
            int selectedIndex = listF10.getSelectedIndex();aktuellMarkierteListe= listF10;

            list26.setSelectedIndex(selectedIndex);
        });
        listF12.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listF12.getSelectedIndex();aktuellMarkierteListe= listF12;

                list27.setSelectedIndex(selectedIndex);
            }
        });
        listF14.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listF14.getSelectedIndex();aktuellMarkierteListe= listF14;

                list28.setSelectedIndex(selectedIndex);
            }
        });
        listF16.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listF16.getSelectedIndex();aktuellMarkierteListe= listF16;

                list29.setSelectedIndex(selectedIndex);
            }
        });
        listF18.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listF18.getSelectedIndex();aktuellMarkierteListe= listF18;

                list30.setSelectedIndex(selectedIndex);
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConstrainInfoDialog.main(null);
            }
        });

        //Bearbeiten bzw. Löschen einer LV
        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lehrveranstaltung.Slot slot;
                Lehrveranstaltung.Typ typ;
                Object[] options =  Lehrveranstaltung.Typ.NONE.getDeclaringClass().getEnumConstants();
                LVLeiter lvLeiter;
                int selected;
                String[] choices = {"Lehrveranstaltung bearbeiten", "Lehrveranstaltung löschen","Raum löschen"};
               // String input = (String) JOptionPane.showInputDialog(null,"Bearbeiten oder Löschen?","Wählen Sie",JOptionPane.DEFAULT_OPTION,null,choices,choices[0]);
                selected  =  JOptionPane.showOptionDialog(null,"Was wollen Sie dem Stundenplan hinzufügen??",  "Neu",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, choices, choices[0]);
                if(selected == -1){return;}
                String input = choices[selected];

                if(input == "Raum löschen"){
                    options =  Lehrveranstaltung.Slot.F8.getDeclaringClass().getEnumConstants();
                    selected  =  JOptionPane.showOptionDialog(null,
                            "In welchen Zeitslot befindet sich der zu löschende Raum?",  "Zeitslot", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
                    slot = (Lehrveranstaltung.Slot) options [selected];

                    JList jlist = translateSlotToList(slot);

                    choices = new String[jlist.getModel().getSize()];

                    for(int i = 0; i< jlist.getModel().getSize(); i++){
                        choices[i] = (String) jlist.getModel().getElementAt(i);
                    }
                    String raum =  (String) JOptionPane.showInputDialog(null, "Wählen Sie den zu löschenden Raum.",
                            "Raum Liste", JOptionPane.QUESTION_MESSAGE, null,   choices, choices[1]); // Initial choice
                    ( (DefaultListModel<String>) jlist.getModel()).removeElement(raum);

                    return;
                }

                //Auswahl Lehrveranstaltung
                String[] auswahlLehrveranstaltungen = new String[lehrveranstaltungList.size()];
                int i = 0;
                for (Lehrveranstaltung lv: lehrveranstaltungList
                        ) {
                    auswahlLehrveranstaltungen[i] = lv.LVtoString();
                    i++;
                }
                String inputLV = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen Lehrveranstaltung.","LV Liste", JOptionPane.QUESTION_MESSAGE, null,
                        auswahlLehrveranstaltungen, auswahlLehrveranstaltungen[0]); // Initial choice
                if(inputLV == null){return;}
                boolean bereitsGefunden = false;
                Lehrveranstaltung ausgewaehlteLV = null ;
                for (Lehrveranstaltung lv: lehrveranstaltungList
                        ) {
                    if(!bereitsGefunden){
                        if(inputLV.equals(lv.LVtoString())){
                            ausgewaehlteLV = lv;
                            bereitsGefunden = true;
                        }}
                }
                //Bearbeiten
                if(input == choices[0]){
                   String[] choicesAttribute = {"Nummer", "Name","Typ","LV Leiter","Semester"};
                    String in;
                    input = eingabeFormularAttribute();
                    if(input == null){return;}


                   if(input == choicesAttribute[0]){
                       in = (String) JOptionPane.showInputDialog(null,"LVNummer?","LVNummer?", JOptionPane.PLAIN_MESSAGE);
                       if(!isInt(in) | in == null){return;}
                       int nummer = Integer.parseInt(in);
                       stundenPlan.remove(ausgewaehlteLV);
                       ausgewaehlteLV.nummer = nummer;

                   }else if(input == choicesAttribute[1]){
                       String name = (String)JOptionPane.showInputDialog(null,"Name der Lehrverantaltung?","LVName?", JOptionPane.PLAIN_MESSAGE);
                       if(name == null){return; }
                       ausgewaehlteLV.name = name;
                       }else if(input == choicesAttribute[2]){
                       selected =  JOptionPane.showOptionDialog(null, "Typ der Lehrveranstaltung?","Typ",JOptionPane.DEFAULT_OPTION,
                               JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
                       typ = (Lehrveranstaltung.Typ) options[selected];
                       stundenPlan.remove(ausgewaehlteLV);
                       ausgewaehlteLV.typ = typ;
                   }else if(input == choicesAttribute[3]){
                           String[] choices3 = new String[lvLeiterList.size()];
                           i = 0;
                           for (LVLeiter leiter: lvLeiterList
                                   ) {
                               choices3[i] = leiter.LVLeitertoStringMitID();
                               i++;
                           }
                           String leiterwahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter.",
                                   "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null, choices3, choices3[1]);
                           if(leiterwahl == null) {return;}
                           String[] split  = leiterwahl.split(" ",7);
                           lvLeiter = lvLeiterList.get(Integer.parseInt(split[0])+1);
                            stundenPlan.remove(ausgewaehlteLV);
                           ausgewaehlteLV.leiter = lvLeiter;
                   }else if(input == choicesAttribute[4]){
                       in = JOptionPane.showInputDialog(null,"Semester?","Semester?", JOptionPane.PLAIN_MESSAGE);
                       if(in == null){                                return;                            }
                       int semester = Integer.parseInt(in);
                       stundenPlan.remove(ausgewaehlteLV);
                       ausgewaehlteLV.semester = semester;
                   }

                   stundenPlan.neueLV(ausgewaehlteLV);
                }

                //Löschen
                else if(input == choices[1]){
                    boolean lvBereitsGeloescht = false;
                    Lehrveranstaltung zuLoeschendeLV = null ;
                    for (Lehrveranstaltung lv: lehrveranstaltungList
                            ) {
                        if(!lvBereitsGeloescht){
                        if(inputLV.equals(lv.LVtoString())){
                         zuLoeschendeLV = lv;
                         lvBereitsGeloescht = true;
                        }}
                    }
                    stundenPlan.remove(zuLoeschendeLV);
                    lehrveranstaltungList.remove(zuLoeschendeLV);
                }
                resetDefaultListModels();
                insertLehrveranstaltungen(lehrveranstaltungList);
                }
        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Set<String> namenListe = new HashSet<String>();
                    Set<Integer> lvNummernListe = new HashSet<Integer>();
                    //Semester (1-10), LV Leiter: LV Leiterlist, Typ: alle Typen
                    
                    String eingabe;
                    String[] choicesAttribute = {"Nummer", "Name","Typ","LV Leiter","Semester"};
                    String in;
                    eingabe = (String)JOptionPane.showInputDialog(null,"Nach welchem Kriterium wollen Sie filtern?","Filter",
                            JOptionPane.DEFAULT_OPTION,null,choicesAttribute,choicesAttribute[0]);
                    if(eingabe == null){return;}
                    
                    if(eingabe == choicesAttribute [0]){
                        for (Lehrveranstaltung lehrveranstaltung:lehrveranstaltungList
                             ) {
                            if(lehrveranstaltung.nummer!= 0){
                        lvNummernListe.add(lehrveranstaltung.nummer);}
                        }

                        String[] choices = new String[lvNummernListe.size()];
                        int i = 0;
                        for(int nummer: lvNummernListe){
                            choices[i] = Integer.toString(nummer);
                            i++;
                        }
                        Arrays.sort(choices);

                        String nummernWahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie den Namen der LV aus.",
                                "LV-Namenliste", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
                        if(nummernWahl == null){return;}
                        resetColorSlots();
                        resetDefaultListModels();
                        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                                )
                            if (lehrveranstaltung.nummer == Integer.parseInt(nummernWahl)) {
                                insertOneLehrveranstaltung(lehrveranstaltung);
                                colorSlot(lehrveranstaltung.slot, Color.GREEN);
                            }
                        
                    }else if(eingabe == choicesAttribute [1]){
                        for (Lehrveranstaltung lehrveranstaltung:lehrveranstaltungList
                                ) {
                            namenListe.add(lehrveranstaltung.name);
                        }
                        String[] choices = new String[namenListe.size()];
                        int i = 0;
                        for (String name: namenListe
                             ) {
                            choices[i] = name;
                            i++;
                        }

                        Arrays.sort(choices);
                        String namenWahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie den Namen der LV aus.",
                                "LV-Namenliste", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
                        if( namenWahl == null) {return;}
                        resetDefaultListModels();
                        resetColorSlots();
                        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                             ) {
                            if(lehrveranstaltung.name.equals(namenWahl)){
                                insertOneLehrveranstaltung(lehrveranstaltung);
                                colorSlot(lehrveranstaltung.slot,Color.GREEN);
                            }
                        }


                    }else if(eingabe == choicesAttribute [2]){
                        Object[] options =  Lehrveranstaltung.Typ.NONE.getDeclaringClass().getEnumConstants();
                        int selected =  JOptionPane.showOptionDialog(null,"Typ der Lehrveranstaltung?", "Typ", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
                        Lehrveranstaltung.Typ typ = (Lehrveranstaltung.Typ) options[selected];
                        resetColorSlots();
                        resetDefaultListModels();
                        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                                ) {
                            if(lehrveranstaltung.typ == typ){
                                insertOneLehrveranstaltung(lehrveranstaltung);
                                colorSlot(lehrveranstaltung.slot,Color.GREEN);
                            }
                        }
                    }else if(eingabe == choicesAttribute [3]){
                        String[] choices3 = new String[lvLeiterList.size()];
                        int i = 0;
                        for (LVLeiter leiter: lvLeiterList
                                ) {
                            choices3[i] = leiter.LVLeitertoStringMitID();
                            i++;
                        }
                        String leiterwahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie einen LV Leiter.",
                                "LV Leiterliste", JOptionPane.QUESTION_MESSAGE, null,choices3,  choices3[1]); // Initial choice
                        if(leiterwahl == null) {return;}
                        String[] split  = leiterwahl.split(" ",7);
                        LVLeiter lvLeiter = lvLeiterList.get(Integer.parseInt(split[0])+1);

                        resetColorSlots();
                        resetDefaultListModels();
                        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                                ) {
                            if(lehrveranstaltung.leiter.equals(lvLeiter)){
                                insertOneLehrveranstaltung(lehrveranstaltung);
                                colorSlot(lehrveranstaltung.slot,Color.GREEN);
                            }
                        }
                    }else if(eingabe == choicesAttribute [4]){
                        String[] choices3 = new String[10];
                        for (int i = 1; i<=10;i++){
                            choices3[i-1] = Integer.toString(i);
                        }
                        String semesterAuswahl = (String) JOptionPane.showInputDialog(null, "Wählen Sie ein Semester.",
                                "Semesterliste", JOptionPane.QUESTION_MESSAGE, null,  choices3, choices3[0]); // Initial choice
                        if(semesterAuswahl == null) {return;}
                        int semester = Integer.parseInt(semesterAuswahl);

                        resetColorSlots();
                        resetDefaultListModels();
                        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                                ) {
                            if(lehrveranstaltung.semester== semester){
                                insertOneLehrveranstaltung(lehrveranstaltung);
                                colorSlot(lehrveranstaltung.slot,Color.GREEN);
                            }
                        }
                    }
            }
        });

        slotVorschlägeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String ausgewaehlteLV = (String) aktuellMarkierteListe.getSelectedValue();
                    Lehrveranstaltung.Slot aktuellerSlot = ListTransferHandler.translateSlot(aktuellMarkierteListe);
                    if(aktuellMarkierteListe.getSelectedValue() == null){return;}
                    Lehrveranstaltung aktuelleLehrveranstaltung = stundenPlan.getLVfromHashcode(ausgewaehlteLV.hashCode() + aktuellerSlot.hashCode());

               // System.out.println(aktuelleLehrveranstaltung.LVtoString());
                resetColorSlots();
                Set<Lehrveranstaltung.Slot> vorschlaege = new HashSet<Lehrveranstaltung.Slot>();
                Set<Lehrveranstaltung.Slot> constraint = new HashSet<Lehrveranstaltung.Slot>();
                for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                     ) {
                    if(lehrveranstaltung.slot != aktuelleLehrveranstaltung.slot){
                        vorschlaege.add(lehrveranstaltung.slot);
                        if(lehrveranstaltung.leiter.equals(aktuelleLehrveranstaltung.leiter)
                                | (lehrveranstaltung.semester == aktuelleLehrveranstaltung.semester && aktuelleLehrveranstaltung.semester != 0)
                                |lehrveranstaltung.name.equals(aktuelleLehrveranstaltung.name)
                                | aktuelleLehrveranstaltung.leiter.keineZeit[(int) LVLeiter.mapSlotToArray(lehrveranstaltung.slot).getKey()]
                                [(int) LVLeiter.mapSlotToArray(lehrveranstaltung.slot).getValue()] ){
                        constraint.add(lehrveranstaltung.slot);}
                    }
                }
                System.out.println("Vorschläge " + vorschlaege.size());
                System.out.println(constraint.size());
                for (Lehrveranstaltung.Slot slot: constraint) {
                    vorschlaege.remove(slot);
                }
                for (Lehrveranstaltung.Slot slot: vorschlaege
                     ) {colorSlot(slot, Color.GREEN);

                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(999);
            }
        });
        extrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EingabeDialog.main(null, lvLeiterList);
            }
        });
    }

    public String eingabeFormularAttribute(){
        String[] choicesAttribute = {"Nummer", "Name","Typ","LV Leiter","Semester"};

        int selected  =  JOptionPane.showOptionDialog(null,"Was wollen Sie dem Stundenplan hinzufügen??", "Neu",
                JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, choicesAttribute, choicesAttribute[0]);
        if(selected == -1){return  null;}
        String eingabe = choicesAttribute[selected];
        return eingabe;
    }

    public void initialLists() {
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

    public void checkConstraints(){
        resetColorSlots();
        //Generieren aller Slotlisten
        HashMap<Lehrveranstaltung.Slot,List<Lehrveranstaltung>> generierteListe = generateSlotListHashMap(lehrveranstaltungList);

        List<Lehrveranstaltung> slotlist = null;

        for (Lehrveranstaltung.Slot slot : Lehrveranstaltung.Slot.values()
             ) {
            slotlist = generierteListe.get(slot);

            if(checkLeiter(slotlist)){
                colorSlot(slot,new Color(Integer.decode("#A51000")));

            }
            else if(checkGleicherKurs(slotlist)){
                colorSlot(slot,new Color(Integer.decode("#46E3D6")));
            }
            else if(checkSemester(slotlist)){
                colorSlot(slot,new Color(Integer.decode("#FF4D07")));
            }
            else if (checkLeiterKeineZeit(slotlist)){
                colorSlot(slot, new Color(Integer.decode("#E3DE17")));
            }
        }

       checkMaximal4ausdemgleichemSemesterProTag(generierteListe, Lehrveranstaltung.Slot.M8, Lehrveranstaltung.Slot.M10, Lehrveranstaltung.Slot.M12,
                Lehrveranstaltung.Slot.M14, Lehrveranstaltung.Slot.M16, Lehrveranstaltung.Slot.M18);
        checkMaximal4ausdemgleichemSemesterProTag(generierteListe,Lehrveranstaltung.Slot.D8, Lehrveranstaltung.Slot.D10, Lehrveranstaltung.Slot.D12,
                Lehrveranstaltung.Slot.D14, Lehrveranstaltung.Slot.D16, Lehrveranstaltung.Slot.D18);
       checkMaximal4ausdemgleichemSemesterProTag(generierteListe,Lehrveranstaltung.Slot.MI8, Lehrveranstaltung.Slot.MI10, Lehrveranstaltung.Slot.MI12,
                Lehrveranstaltung.Slot.MI14, Lehrveranstaltung.Slot.MI16, Lehrveranstaltung.Slot.MI18);
        checkMaximal4ausdemgleichemSemesterProTag(generierteListe,Lehrveranstaltung.Slot.DO8, Lehrveranstaltung.Slot.DO10, Lehrveranstaltung.Slot.DO12,
                Lehrveranstaltung.Slot.DO14, Lehrveranstaltung.Slot.DO16, Lehrveranstaltung.Slot.DO18);
       checkMaximal4ausdemgleichemSemesterProTag(generierteListe, Lehrveranstaltung.Slot.F8, Lehrveranstaltung.Slot.F10, Lehrveranstaltung.Slot.F12,
                Lehrveranstaltung.Slot.F14, Lehrveranstaltung.Slot.F16, Lehrveranstaltung.Slot.F18);



    }

    /*
    kontrolliert ob mehr als 4 Lehrveranstaltungen aus dem selben Semester sind
     */
    private void checkMaximal4ausdemgleichemSemesterProTag(HashMap<Lehrveranstaltung.Slot,List<Lehrveranstaltung>> generierteListe ,Lehrveranstaltung.Slot s1,Lehrveranstaltung.Slot s2,Lehrveranstaltung.Slot s3,
                                                              Lehrveranstaltung.Slot s4,Lehrveranstaltung.Slot s5,Lehrveranstaltung.Slot s6) {
        List<Lehrveranstaltung> slotlist = null;

        int [] semesterArray = new int[10];
        boolean semesterKommtvor = false;
        slotlist = generierteListe.get(s1);
        for (int i = 0; i < 10; i++) {
            semesterArray[i] = 0; //0 gleiche Kurse
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        slotlist = generierteListe.get(s2);
        for (int i = 0; i < 10; i++) {
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        slotlist = generierteListe.get(s3);
        for (int i = 0; i < 10; i++) {
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        slotlist = generierteListe.get(s4);
        for (int i = 0; i < 10; i++) {
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        slotlist = generierteListe.get(s5);
        for (int i = 0; i < 10; i++) {
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        slotlist = generierteListe.get(s6);
        for (int i = 0; i < 10; i++) {
            for (Lehrveranstaltung lehrveranstaltung: slotlist
                    ) {
                if(lehrveranstaltung.semester == i+1){
                    semesterKommtvor = true; }
            }
            if(semesterKommtvor){
                semesterArray[i]++;   //Wenn es in Slot vorkommt dann counter um 1 erhöhen
                semesterKommtvor = false;
            }
        }
        boolean maximalErreicht = false;
        for (int i = 0; i < 10; i++) {
            if(semesterArray[i] > 4){
                maximalErreicht = true;
                System.out.println("In Slot " + s1 + " kommt Semester " + (i+1) + " mehr als 4 mal vor");
            }
        }
        if(maximalErreicht) {
            colorSlot(s1, new Color(Integer.decode("#9F00F2")));
            colorSlot(s2, new Color(Integer.decode("#9F00F2")));
            colorSlot(s3, new Color(Integer.decode("#9F00F2")));
            colorSlot(s4, new Color(Integer.decode("#9F00F2")));
            colorSlot(s5, new Color(Integer.decode("#9F00F2")));
            colorSlot(s6, new Color(Integer.decode("#9F00F2")));
        }


    }

    /*
    Generieren einer Hashmap von Slotlisten um den Constraint Aufwand zu verringern
     */
    public HashMap<Lehrveranstaltung.Slot,List<Lehrveranstaltung>> generateSlotListHashMap(List<Lehrveranstaltung> lehrveranstaltungList){
        HashMap<Lehrveranstaltung.Slot,List<Lehrveranstaltung>> slotListHashMap = new   HashMap<Lehrveranstaltung.Slot,List<Lehrveranstaltung>>();

        slotListHashMap.put(Lehrveranstaltung.Slot.M8     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.M10     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.M12     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.M14     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.M16     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.M18      , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D8     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D10     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D12     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D14     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D16     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.D18     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI8     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI10     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI12     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI14     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI16     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.MI18     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO8     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO10     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO12     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO14     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO16     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.DO18     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F8     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F10     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F12     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F14     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F16     , new ArrayList<Lehrveranstaltung>() );
        slotListHashMap.put(Lehrveranstaltung.Slot.F18     , new ArrayList<Lehrveranstaltung>() );



        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
             ) {
            slotListHashMap.get(lehrveranstaltung.slot).add(lehrveranstaltung);
        }

        return slotListHashMap;
    }
    /*
    Check ob gleicher LV Leiter
     */
    public boolean checkLeiter(List<Lehrveranstaltung> lehrveranstaltungList){
        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                ){
            for (Lehrveranstaltung lehrveranstaltung2: lehrveranstaltungList
                    ) {
                if(!lehrveranstaltung.equals(lehrveranstaltung2)){
                    if(lehrveranstaltung.leiterID != -1 && lehrveranstaltung.leiterID != 0 )
                    if(lehrveranstaltung.leiterID == lehrveranstaltung2.leiterID){
                        return  true;
                    }
                }
            }
        }
        return false;

    }

    /*
    Check ob gleiches Semester
     */
    public boolean checkSemester(List<Lehrveranstaltung> lehrveranstaltungList){
        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                ){
            for (Lehrveranstaltung lehrveranstaltung2: lehrveranstaltungList
                    ) {
                if(!lehrveranstaltung.equals(lehrveranstaltung2)){
                    if(lehrveranstaltung.semester != 0){
                    if(lehrveranstaltung.semester == lehrveranstaltung2.semester){
                        return  true;
                    }
                }
                }
            }
        }
        return false;
    }
    /*
    Check ob gleicher Kurs (Über Kursname)
     */
    public boolean checkGleicherKurs(List<Lehrveranstaltung> lehrveranstaltungList){
        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
             ){
            for (Lehrveranstaltung lehrveranstaltung2: lehrveranstaltungList
                 ) {
                if(!lehrveranstaltung.equals(lehrveranstaltung2)){
                    if(lehrveranstaltung.name.equals(lehrveranstaltung2.name) && !lehrveranstaltung.name.equals("Privatisimum")){
                        return  true;
                    }
                }
            }
        }
        return false;
    }
    /*
    Check ob LV Leiter keine Zeit zu dieser Zeit hat
     */
    public boolean checkLeiterKeineZeit(List<Lehrveranstaltung> lehrveranstaltungList){
        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
                ){
            int a = (int) LVLeiter.mapSlotToArray(lehrveranstaltung.slot).getKey();
            int b = (int) LVLeiter.mapSlotToArray(lehrveranstaltung.slot).getValue();
            if(lehrveranstaltung.getLVLeiter().keineZeit[a][b]){
                return true;
            }
        }
    return  false;
    }



   /*
   Name Lists
    */
   public void benenneJListen(){
       listM8.setName("M8");
       listM10.setName("M10");
       listM12.setName("M12");
       listM14.setName("M14");
       listM16.setName("M16");
       listM18.setName("M18");
       listD8.setName("D8");
       listD10.setName("D10");
       listD12.setName("D12");
       listD14.setName("D14");
       listD16.setName("D16");
       listD18.setName("D18");
       listMI8.setName("MI8");
       listMI10.setName("MI10");
       listMI12.setName("MI12");
       listMI14.setName("MI14");
       listMI16.setName("MI16");
       listMI18.setName("MI18");
       listDO8.setName("DO8");
       listDO10.setName("DO10");
       listDO12.setName("DO12");
       listDO14.setName("DO14");
       listDO16.setName("DO16");
       listDO18.setName("DO18");
       listF8.setName("F8");
       listF10.setName("F10");
       listF12.setName("F12");
       listF14.setName("F14");
       listF16.setName("F16");
       listF18.setName("F18");

   }

    /*
       Color the Connstraint Slots Red
        */
    public void colorSlot(Lehrveranstaltung.Slot slotnumber, Color farbe){
        switch (slotnumber) {
            case M8:
                listM8.setBackground(farbe);
                break;
            case M10:
                listM10.setBackground(farbe);
                break;
            case M12:
                listM12.setBackground(farbe);
                break;
            case M14:
                listM14.setBackground(farbe);
                break;
            case M16:
                listM16.setBackground(farbe);
                break;
            case M18:
                listM18.setBackground(farbe);
                break;
            case D8:
                listD8.setBackground(farbe);
                break;
            case D10:
                listD10.setBackground(farbe);
                break;
            case D12:
                listD12.setBackground(farbe);
                break;
            case D14:
                listD14.setBackground(farbe);
                break;
            case D16:
                listD16.setBackground(farbe);
                break;
            case D18:
                listD18.setBackground(farbe);
                break;
            case MI8:
                listMI8.setBackground(farbe);
                break;
            case MI10:
                listMI10.setBackground(farbe);
                break;
            case MI12:
                listMI12.setBackground(farbe);
                break;
            case MI14:
                listMI14.setBackground(farbe);
                break;
            case MI16:
                listMI16.setBackground(farbe);
                break;
            case MI18:
                listMI18.setBackground(farbe);
                break;
            case DO8:
                listDO8.setBackground(farbe);
                break;
            case DO10:
                listDO10.setBackground(farbe);
                break;
            case DO12:
                listDO12.setBackground(farbe);
                break;
            case DO14:
                listDO14.setBackground(farbe);
                break;
            case DO16:
                listDO16.setBackground(farbe);
                break;
            case DO18:
                listDO18.setBackground(farbe);
                break;
            case F8:
                listF8.setBackground(farbe);
                break;
            case F10:
                listF10.setBackground(farbe);
                break;
            case F12:
                listF12.setBackground(farbe);
                break;
            case F14:
                listF14.setBackground(farbe);
                break;
            case F16:
                listF16.setBackground(farbe);
                break;
            case F18:
                listF18.setBackground(farbe);
                break;
        }


    }

    static boolean isInt(String s) {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }

    public void insertOneLehrveranstaltung(Lehrveranstaltung temp){
        Lehrveranstaltung.Slot slot = temp.slot;
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
                ;
                listModeM14.addElement(temp.LVtoString());
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
            case F14:
                listModeF14.addElement(temp.LVtoString());
                break;
            case F16:
                listModeF16.addElement(temp.LVtoString());
                break;
            case F18:
                listModeF18.addElement(temp.LVtoString());
                break;
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

    public void insertLehrveranstaltungenOhneNummern (List<Lehrveranstaltung> lehrveranstaltungList) {
        Lehrveranstaltung.Slot slot;
        for (Lehrveranstaltung temp : lehrveranstaltungList
                ) {
            slot = temp.slot;

            switch (slot) {
                case M8:
                    listModeM8.addElement(temp.ohneLVNummertoString());
                    break;
                case M10:
                    listModeM10.addElement(temp.ohneLVNummertoString());
                    break;
                case M12:
                    listModeM12.addElement(temp.ohneLVNummertoString());
                    break;
                case M14:
                    ;listModeM14.addElement(temp.ohneLVNummertoString());
                    break;
                case M16:
                    listModeM16.addElement(temp.ohneLVNummertoString());
                    break;
                case M18:
                    listModeM18.addElement(temp.ohneLVNummertoString());
                    break;
                case D8:
                    listModeD8.addElement(temp.ohneLVNummertoString());
                    break;
                case D10:
                    listModeD10.addElement(temp.ohneLVNummertoString());
                    break;
                case D12:
                    listModeD12.addElement(temp.ohneLVNummertoString());
                    break;
                case D14:
                    listModeD14.addElement(temp.ohneLVNummertoString());
                    break;
                case D16:
                    listModeD16.addElement(temp.ohneLVNummertoString());
                    break;
                case D18:
                    listModeD18.addElement(temp.ohneLVNummertoString());
                    break;
                case MI8:
                    listModeMI8.addElement(temp.ohneLVNummertoString());
                    break;
                case MI10:
                    listModeMI10.addElement(temp.ohneLVNummertoString());
                    break;
                case MI12:
                    listModeMI12.addElement(temp.ohneLVNummertoString());
                    break;
                case MI14:
                    listModeMI14.addElement(temp.ohneLVNummertoString());
                    break;
                case MI16:
                    listModeMI16.addElement(temp.ohneLVNummertoString());
                    break;
                case MI18:
                    listModeMI18.addElement(temp.ohneLVNummertoString());
                    break;
                case DO8:
                    listModeDO8.addElement(temp.ohneLVNummertoString());
                    break;
                case DO10:
                    listModeDO10.addElement(temp.ohneLVNummertoString());
                    break;
                case DO12:
                    listModeDO12.addElement(temp.ohneLVNummertoString());
                    break;
                case DO14:
                    listModeDO14.addElement(temp.ohneLVNummertoString());
                    break;
                case DO16:
                    listModeDO16.addElement(temp.ohneLVNummertoString());
                    break;
                case DO18:
                    listModeDO18.addElement(temp.ohneLVNummertoString());
                    break;
                case F8:
                    listModeF8.addElement(temp.ohneLVNummertoString());
                    break;
                case F10:
                    listModeF10.addElement(temp.ohneLVNummertoString());
                    break;
                case F12:
                    listModeF12.addElement(temp.ohneLVNummertoString());
                    break;
                case F14: listModeF14.addElement(temp.ohneLVNummertoString());
                    break;
                case F16:
                    listModeF16.addElement(temp.ohneLVNummertoString());
                    break;
                case F18:
                    listModeF18.addElement(temp.ohneLVNummertoString());
                    break;
            }
        }}

    public void insertLehrveranstaltungenNurLVLeiterName (List<Lehrveranstaltung> lehrveranstaltungList) {
        Lehrveranstaltung.Slot slot;
        for (Lehrveranstaltung temp : lehrveranstaltungList
                ) {
            slot = temp.slot;

            switch (slot) {
                case M8:
                    listModeM8.addElement(temp.nurLeiterNametoString());
                    break;
                case M10:
                    listModeM10.addElement(temp.nurLeiterNametoString());
                    break;
                case M12:
                    listModeM12.addElement(temp.nurLeiterNametoString());
                    break;
                case M14:
                    listModeM14.addElement(temp.nurLeiterNametoString());
                    break;
                case M16:
                    listModeM16.addElement(temp.nurLeiterNametoString());
                    break;
                case M18:
                    listModeM18.addElement(temp.nurLeiterNametoString());
                    break;
                case D8:
                    listModeD8.addElement(temp.nurLeiterNametoString());
                    break;
                case D10:
                    listModeD10.addElement(temp.nurLeiterNametoString());
                    break;
                case D12:
                    listModeD12.addElement(temp.nurLeiterNametoString());
                    break;
                case D14:
                    listModeD14.addElement(temp.nurLeiterNametoString());
                    break;
                case D16:
                    listModeD16.addElement(temp.nurLeiterNametoString());
                    break;
                case D18:
                    listModeD18.addElement(temp.nurLeiterNametoString());
                    break;
                case MI8:
                    listModeMI8.addElement(temp.nurLeiterNametoString());
                    break;
                case MI10:
                    listModeMI10.addElement(temp.nurLeiterNametoString());
                    break;
                case MI12:
                    listModeMI12.addElement(temp.nurLeiterNametoString());
                    break;
                case MI14:
                    listModeMI14.addElement(temp.nurLeiterNametoString());
                    break;
                case MI16:
                    listModeMI16.addElement(temp.nurLeiterNametoString());
                    break;
                case MI18:
                    listModeMI18.addElement(temp.nurLeiterNametoString());
                    break;
                case DO8:
                    listModeDO8.addElement(temp.nurLeiterNametoString());
                    break;
                case DO10:
                    listModeDO10.addElement(temp.nurLeiterNametoString());
                    break;
                case DO12:
                    listModeDO12.addElement(temp.nurLeiterNametoString());
                    break;
                case DO14:
                    listModeDO14.addElement(temp.nurLeiterNametoString());
                    break;
                case DO16:
                    listModeDO16.addElement(temp.nurLeiterNametoString());
                    break;
                case DO18:
                    listModeDO18.addElement(temp.nurLeiterNametoString());
                    break;
                case F8:
                    listModeF8.addElement(temp.nurLeiterNametoString());
                    break;
                case F10:
                    listModeF10.addElement(temp.nurLeiterNametoString());
                    break;
                case F12:
                    listModeF12.addElement(temp.nurLeiterNametoString());
                    break;
                case F14:
                    listModeF14.addElement(temp.nurLeiterNametoString());
                    break;
                case F16:
                    listModeF16.addElement(temp.nurLeiterNametoString());
                    break;
                case F18:
                    listModeF18.addElement(temp.nurLeiterNametoString());
                    break;
            }
        }}

    /*
    Reset Color to White
     */
    public void resetColorSlots(){
                listM8.setBackground(Color.WHITE);
                listM10.setBackground(Color.WHITE);
                listM12.setBackground(Color.WHITE);
                listM14.setBackground(Color.WHITE);
                listM16.setBackground(Color.WHITE);
                listM18.setBackground(Color.WHITE);
                listD8.setBackground(Color.WHITE);
                listD10.setBackground(Color.WHITE);
                listD12.setBackground(Color.WHITE);
                listD14.setBackground(Color.WHITE);
                listD16.setBackground(Color.WHITE);
                listD18.setBackground(Color.WHITE);
                listMI8.setBackground(Color.WHITE);
                listMI10.setBackground(Color.WHITE);
                listMI12.setBackground(Color.WHITE);
                listMI14.setBackground(Color.WHITE);
                listMI16.setBackground(Color.WHITE);
                listMI18.setBackground(Color.WHITE);
                listDO8.setBackground(Color.WHITE);
                listDO10.setBackground(Color.WHITE);
                listDO12.setBackground(Color.WHITE);
                listDO14.setBackground(Color.WHITE);
                listDO16.setBackground(Color.WHITE);
                listDO18.setBackground(Color.WHITE);
                listF8.setBackground(Color.WHITE);
                listF10.setBackground(Color.WHITE);
                listF12.setBackground(Color.WHITE);
                listF14.setBackground(Color.WHITE);
                listF16.setBackground(Color.WHITE);
                listF18.setBackground(Color.WHITE);

        }

    public void resetDefaultListModels(){
        for (DefaultListModel dummy: defaultListModels
                ) {
            dummy.clear();
        }
    }

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

    public void stickDefaultliststogether() {

        defaultListModels.add(listModeM8);
        defaultListModels.add(listModeM10);
        defaultListModels.add(listModeM12);
        defaultListModels.add(listModeM14);
        defaultListModels.add(listModeM16);
        defaultListModels.add(listModeM18);
        defaultListModels.add(listModeD8);
        defaultListModels.add(listModeD10);
        defaultListModels.add(listModeD12);
        defaultListModels.add(listModeD14);
        defaultListModels.add(listModeD16);
        defaultListModels.add(listModeD18);
        defaultListModels.add(listModeMI8);
        defaultListModels.add(listModeMI10);
        defaultListModels.add(listModeMI12);
        defaultListModels.add(listModeMI14);
        defaultListModels.add(listModeMI16);
        defaultListModels.add(listModeMI18);
        defaultListModels.add(listModeDO8);
        defaultListModels.add(listModeDO10);
        defaultListModels.add(listModeDO12);
        defaultListModels.add(listModeDO14);
        defaultListModels.add(listModeDO16);
        defaultListModels.add(listModeDO18);
        defaultListModels.add(listModeF8);
        defaultListModels.add(listModeF10);
        defaultListModels.add(listModeF12);
        defaultListModels.add(listModeF14);
        defaultListModels.add(listModeF16);
        defaultListModels.add(listModeF18);
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
    /*
       Slot to RaumlistTranslator
        */
    public JList translateSlotToList(Lehrveranstaltung.Slot slot){
        JList list = null;
        switch (slot){
            case M8:
                return list1;
            case M10:
                return list2;
            case M12:
                return list3;
            case M14:
                return list4;
            case M16:
                return list5;
            case M18:
                return list6;
            case D8:
                return list7;
            case D10:
                return list8;
            case D12:
                return list9;
            case D14:
                return list10;
            case D16:
                return list11;
            case D18:
                return list12;
            case MI8:
                return list13;
            case MI10:
                return list14;
            case MI12:
                return list15;
            case MI14:
                return list16;
            case MI16:
                return list17;
            case MI18:
                return list18;
            case DO8:
                return list19;
            case DO10:
                return list20;
            case DO12:
                return list21;
            case DO14:
                return list22;
            case DO16:
                return list23;
            case DO18:
                return list24;
            case F8:
                return list25;
            case F10:
                return list26;
            case F12:
                return list27;
            case F14:
                return list28;
            case F16:
                return list29;
            case F18:
                return list30;
        }
        return null;
    }
    /*
    Verbinden der Leiter mit den Lehrveranstaltungen. Zu Tun bei jedem neu Einlesen der XML
     */
    public void connectLeiterToLehrveranstaltungen(){
        for (Lehrveranstaltung lehrveranstaltung: lehrveranstaltungList
             ) {
          lehrveranstaltung.leiter = lvLeiterList.get(lehrveranstaltung.leiterID+1);

        }
    }

    public void setListsFont(){
        //myfont
       // myFont = new Font("monospaced", Font.PLAIN,11);
        listM8.setFont(myFont);
        listM10.setFont(myFont);
        listM12.setFont(myFont);
        listM14.setFont(myFont);
        listM16.setFont(myFont);
        listM18.setFont(myFont);
        listD8.setFont(myFont);
        listD10.setFont(myFont);
        listD12.setFont(myFont);
        listD14.setFont(myFont);
        listD16.setFont(myFont);
        listD18.setFont(myFont);
        listMI8.setFont(myFont);
        listMI10.setFont(myFont);
        listMI12.setFont(myFont);
        listMI14.setFont(myFont);
        listMI16.setFont(myFont);
        listMI18.setFont(myFont);
        listDO8.setFont(myFont);
        listDO10.setFont(myFont);
        listDO12.setFont(myFont);
        listDO14.setFont(myFont);
        listDO16.setFont(myFont);
        listDO18.setFont(myFont);
        listF8.setFont(myFont);
        listF10.setFont(myFont);
        listF12.setFont(myFont);
        listF14.setFont(myFont);
        listF16.setFont(myFont);
        listF18.setFont(myFont);
        list1.setFont(myFont);
        list2.setFont(myFont);
        list3.setFont(myFont);
        list4.setFont(myFont);
        list5.setFont(myFont);
        list6.setFont(myFont);
        list7.setFont(myFont);
        list8.setFont(myFont);
        list9.setFont(myFont);
        list10.setFont(myFont);
        list11.setFont(myFont);
        list12.setFont(myFont);
        list13.setFont(myFont);
        list14.setFont(myFont);
        list15.setFont(myFont);
        list16.setFont(myFont);
        list17.setFont(myFont);
        list18.setFont(myFont);
        list19.setFont(myFont);
        list20.setFont(myFont);
        list21.setFont(myFont);
        list22.setFont(myFont);
        list23.setFont(myFont);
        list24.setFont(myFont);
        list25.setFont(myFont);
        list26.setFont(myFont);
        list27.setFont(myFont);
        list28.setFont(myFont);
        list29.setFont(myFont);
        list30.setFont(myFont);
        for(int i = 0; i <kopfToolbar.getComponentCount(); i++){
            kopfToolbar.getComponent(i).setFont(myFont);
        }
        exitButton.setFont(new Font("Courier", Font.BOLD, 16));
    }

    private static void createAndShowGUI(javax.swing.JFrame frame, ScheduleLayout2 scheduleLayout, String input) {
        if(input == "1080p"){
            frame.setSize(new Dimension(1900,999));
        }
        frame.setContentPane(scheduleLayout.hauptPanel);

        scheduleLayout.hauptPanel.setFocusable(true);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        //XML inputRead
        ManageXML manageXML = new ManageXML();
        lvLeiterList = manageXML.getXMLLvLeiter(true,null);
        lehrveranstaltungList = manageXML.getXMLLehrveranstaltungen(true,null);


        JFrame frame = new JFrame("Informatik Stundenplan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);

        ScheduleLayout2 scheduleLayout = new ScheduleLayout2();

        //Leiter den Lehrveranstaltungen hinzufügen
        scheduleLayout.connectLeiterToLehrveranstaltungen();

        //Zusammenfügen der Jlists in Arrayliste
        scheduleLayout.stickJListtogether();
        scheduleLayout.stickDefaultliststogether();
        scheduleLayout.initialLists();
        scheduleLayout.insertLehrveranstaltungen(lehrveranstaltungList);

        //Bennenne Lists fürs Translaten
        scheduleLayout.benenneJListen();
        scheduleLayout.setListsFont();

        String[] choices = {"720p", "1080p (1920x1200"};
      //  String input = "720p";
        String input = (String) JOptionPane.showInputDialog(null,"LV oder LV Leiter?","Wählen Sie",JOptionPane.DEFAULT_OPTION,null,choices,choices[0]);
        if(input == null){return;}
        if(input == choices[1]){
            scheduleLayout.hauptPanel.setMinimumSize(new Dimension(1920,1120));
            scheduleLayout.hauptPanel.setMaximumSize(new Dimension(1920,1120));
            scheduleLayout.hauptPanel.setPreferredSize(new Dimension(1920,1120));

            scheduleLayout.panel.setMinimumSize(new Dimension(1920,1120));
            scheduleLayout.panel.setMaximumSize(new Dimension(1920,1120));
            scheduleLayout.panel.setPreferredSize(new Dimension(1920,1120));

            scheduleLayout.ScrollPaneMain.setMinimumSize(new Dimension(1920,1120));
            scheduleLayout.ScrollPaneMain.setMaximumSize(new Dimension(1920,1120));
            scheduleLayout.ScrollPaneMain.setPreferredSize(new Dimension(1920,1120));

            //scheduleLayout.ScrollPaneMain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
          //  scheduleLayout.ScrollPaneMain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        }

        //Hintergrundstundenplan erzeugen
        stundenPlan = new Plan(scheduleLayout);
        stundenPlan.createMapping(lehrveranstaltungList);

        //setModels
        scheduleLayout.setModels4All();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createAndShowGUI(frame,scheduleLayout,input);
            }
        });


    }

}
