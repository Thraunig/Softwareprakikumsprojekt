package at.aau.raunig;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.awt.*;
import java.util.ArrayList;

public class Lehrveranstaltung {
    public int nummer;
    public Typ typ;
    public String name;
    public int semester;
    public LVLeiter leiter;
    int leiterID;
    public Slot slot;
    public boolean typMathematik;
    public boolean block;
    //hängt später von Klassifizierung ab
    public Color farbe = Color.white;
    java.util.List<Raum.Ausstattung> anforderungen = new ArrayList<Raum.Ausstattung>();
    int geschaetzteAnzahlBeleger = 0;


    public enum Slot {
        M8, M10, M12, M14, M16, M18,
        D8, D10, D12, D14, D16, D18,
        MI8, MI10, MI12, MI14, MI16, MI18,
        DO8, DO10, DO12, DO14, DO16, DO18,
        F8, F10, F12, F14, F16, F18;
    }

    public enum Typ {
        UE, VK, VC, KU, KS, VO, TU, CT, PV, PR, VU, SE, PVSE, NONE;
    }

    public  enum Klassifizierung{
        Semester12, Semester34, Semester56, VertiefendesWahlfach,
        GebundenesWahlfachAnwendungsfachSpezialisierung, SonstigesBWLInfoManagementDoktorat,
        Tutorium, Lehramt
    }

    public Lehrveranstaltung(int nummer, Typ typ, String name, int semester, LVLeiter leiter, Slot slot) {
        this.nummer = nummer;
        this.typ = typ;
        this.name = name;
        this.semester = semester;
        this.leiter = leiter;
        this.slot = slot;
    }

    public Lehrveranstaltung(int nummer, Typ typ, String name, int semester, LVLeiter leiter, Slot slot, Color farbe) {
        this.nummer = nummer;
        this.typ = typ;
        this.name = name;
        this.semester = semester;
        this.leiter = leiter;
        this.slot = slot;
        this.farbe = farbe;
    }

    public LVLeiter getLVLeiter() {
        if (this.leiter == null) {
            return new LVLeiter("", -1);
        } else {
            return this.leiter;
        }

    }

    public void setLeiterID(int leiterID) {
        this.leiterID = leiterID;
    }


    public String LVtoString() {

        String ausgabe = "";

        if (nummer != 0) {
            ausgabe = ausgabe + nummer + " ";
        }
        if (typ != Typ.NONE) {
            if(!(name.startsWith(typ.toString() + " "))) {
                ausgabe = ausgabe + typ + " ";
            }
        }

        ausgabe = ausgabe + name + " ";
        if (leiter != null) {
            if (leiter.name.length() >= 2)
                ausgabe = ausgabe + "|" + leiter.LVLeitertoString();
        }

        if (semester != 0) {

            //return String.format("%-30s %6d", name, semester);

            return  ausgabe + " | " + semester;

        }
        return ausgabe;
    }

    /*
    To String Methode um nur die LV Leiter anzeigen zu lassen
     */
    public String nurLeiterNametoString() {
        if (this.leiter == null) {
            return "Kein LV Leiter notwendig oder eingetragen!!!";
        } else {
            if(this.leiter.name == ""){
                return  " ";
            }
            return this.leiter.name;
        }
    }


    /*
    To String Methode um LV`s ohne Nummern im Plan anzuzeigen
     */
    public String ohneLVNummertoString() {

        String ausgabe = "";

        if (typ != Typ.NONE) {
            if(!(name.startsWith(typ.toString() + " "))) {
                ausgabe = ausgabe + typ + " ";
            }

        }

        ausgabe = ausgabe + name + " ";
        if (leiter != null) {
            if (leiter.name.length() >= 2)
                ausgabe = ausgabe + "|" + leiter.LVLeitertoString();
        }
        if (semester != 0) {
            ausgabe = ausgabe + "| " + semester;
        }
        return ausgabe;

    }
}


	

