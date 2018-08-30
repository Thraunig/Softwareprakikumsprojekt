package at.aau.raunig;

import sun.security.util.LegacyAlgorithmConstraints;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EingabeDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonNaechste;
    private JButton buttonCancel;
    private JTextField textFieldnummer;
    private JTextField textFieldtyp;
    private JTextField textFieldsemester;
    private JTextField textFieldleitername;
    private JTextField textFieldleiterID;
    private JTextField textFieldslot;
    private JTextField textFieldname;
    private JButton eingabeAbschliessenButton;
    private JList listLeiter;
    private JButton neuerLVLeiterButton;
    List<Lehrveranstaltung> einfuegelehrveranstaltungList = new ArrayList<Lehrveranstaltung>();
    List<LVLeiter> einfuegeLeiterList = new ArrayList<LVLeiter>();
    List<LVLeiter> lvLeiterList= new ArrayList<LVLeiter>();
    DefaultListModel<String> defaultListModel= new DefaultListModel<String>();

    ManageXML manageXML = new ManageXML();

    public EingabeDialog(List<LVLeiter> lvLeiterList) {
        this.lvLeiterList = lvLeiterList;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonNaechste);


        for (LVLeiter lvLeiter: lvLeiterList
             ) {
            defaultListModel.addElement(lvLeiter.LVLeitertoStringMitID());
        }
        listLeiter.setModel(defaultListModel);
        listLeiter.setSelectedIndex(1);


        buttonNaechste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nummer, semester;
                if(ScheduleLayout2.isInt(textFieldnummer.getText()) && ScheduleLayout2.isInt(textFieldsemester.getText())){
                nummer = Integer.parseInt(textFieldnummer.getText());
                semester = Integer.parseInt(textFieldsemester.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Bitte korrekte Nummern (Zahl) und keine Strings eingeben!!" );
                    return;
                }
                String name = textFieldname.getText();
                String typString = textFieldtyp.getText();
                Lehrveranstaltung.Typ type = Lehrveranstaltung.Typ.NONE;
                Lehrveranstaltung.Slot slot = Lehrveranstaltung.Slot.M8;
                try {
                     type = Lehrveranstaltung.Typ.valueOf(typString);
                     slot = Lehrveranstaltung.Slot.valueOf(textFieldslot.getText());
                } catch (java.lang.IllegalArgumentException variablenname) {
                    JOptionPane.showMessageDialog(null, "Bitte Korrekte Typs bzw. Slots angeben!!");
                    return;
                }



                String[] split  = ((String) listLeiter.getSelectedValue()).split(" ",7);
                LVLeiter lvLeiter = lvLeiterList.get(Integer.parseInt(split[0])+1);
                Lehrveranstaltung neueLehrveranstaltung = new Lehrveranstaltung(nummer,type,name,semester, lvLeiter, slot);
                einfuegelehrveranstaltungList.add(neueLehrveranstaltung);

                textFieldnummer.setText("");
                textFieldname.setText("");
                textFieldslot.setText("");
                textFieldtyp.setText("");
                textFieldsemester.setText("");
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        eingabeAbschliessenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageXML.xmlWrite(einfuegelehrveranstaltungList,lvLeiterList);
            }
        });
        neuerLVLeiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                name = (String) JOptionPane.showInputDialog(null,"Name des LV Leiters?","Neuen LV-Leiter anlegen", JOptionPane.PLAIN_MESSAGE);
                if(name == null){return;}
                LVLeiter lvLeiter = new LVLeiter(name,lvLeiterList.size()-1);
                lvLeiterList.add(lvLeiter);
                defaultListModel.addElement(lvLeiter.LVLeitertoStringMitID());
                listLeiter.setModel(defaultListModel);            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args, List<LVLeiter> lvLeiterList) {
        EingabeDialog dialog = new EingabeDialog(lvLeiterList);
        dialog.setTitle("Eingabeformular für Masseneingabe eines ganz neuen Stundenplanes");
        dialog.pack();
        dialog.setVisible(true);
    }
}
