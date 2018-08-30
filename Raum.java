package at.aau.raunig;

import java.util.ArrayList;
import java.util.List;

public class Raum {
    /*
    Raumtyp
     */
    public enum RaumTyp {
        HS, Seminarraum
    }
    /*
    Ausstattungen
     */
    public enum Ausstattung {
        Beamer, Tafel, WhiteBoard, PCArbeitsplaetze
    }

    List<Ausstattung> ausstattungList = new ArrayList<Ausstattung>();
    RaumTyp raumTyp;
    int anzahlSitzplaetze;
    String verwalteringMitTelefonnummer;

    public Raum() {
    }

    public Raum(RaumTyp raumTyp, int anzahlSitzplaetze, String verwalteringMitTelefonnummer) {
        this.raumTyp = raumTyp;
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.verwalteringMitTelefonnummer = verwalteringMitTelefonnummer;
    }
}
