package at.aau.raunig;

import jdk.internal.util.xml.impl.Pair;

public class LVLeiter {
    public String name;
    public int LeiterID;



    public boolean[][] keineZeit = new boolean[][]{{false, false, false, false, false, false}, {false, false, false, false, false, false},
            {false, false, false, false, false, false}, {false, false, false, false, false, false},
            {false, false, false, false, false, false}};

    public boolean[][] praeferenzen = new boolean[][]{{false, false, false, false, false, false}, {false, false, false, false, false, false},
            {false, false, false, false, false, false}, {false, false, false, false, false, false},
            {false, false, false, false, false, false}};


    public LVLeiter(String name, int leiterID) {
        this.name = name;
        LeiterID = leiterID;
    }

    public String LVLeitertoString() {
        return " " + this.name + " ";
    }

    public String LVLeitertoStringMitID() {
        return LeiterID + " " + this.name + " ";
    }

    /*
    Setzt den betreffenden Zeitslot auf "Keine Zeit"
     */
    public void setKeineZeit(Lehrveranstaltung.Slot slot) {
        int a = (int) mapSlotToArray(slot).getKey();
        int b = (int) mapSlotToArray(slot).getValue();
        this.keineZeit[a][b] = true;
    }

    /*
    Setzt Preferenzen des LV Leiters
     */
    public void setPraeferenzen(Lehrveranstaltung.Slot slot) {
        int a = (int) mapSlotToArray(slot).getKey();
        int b = (int) mapSlotToArray(slot).getValue();
        this.praeferenzen[a][b] = true;
    }

    public static javafx.util.Pair mapSlotToArray(Lehrveranstaltung.Slot slot) {

        switch (slot) {
            case M8:
                return new javafx.util.Pair(0, 0);

            case M10:
                return new javafx.util.Pair(0, 1);

            case M12:
                return new javafx.util.Pair(0, 2);

            case M14:
                return new javafx.util.Pair(0, 3);

            case M16:
                return new javafx.util.Pair(0, 4);

            case M18:
                return new javafx.util.Pair(0, 5);

            case D8:
                return new javafx.util.Pair(1, 0);

            case D10:
                return new javafx.util.Pair(1, 1);

            case D12:
                return new javafx.util.Pair(1, 2);

            case D14:
                return new javafx.util.Pair(1, 3);

            case D16:
                return new javafx.util.Pair(1, 4);

            case D18:
                return new javafx.util.Pair(1, 5);

            case MI8:
                return new javafx.util.Pair(2, 0);

            case MI10:
                return new javafx.util.Pair(2, 1);

            case MI12:
                return new javafx.util.Pair(2, 2);

            case MI14:
                return new javafx.util.Pair(2, 3);

            case MI16:
                return new javafx.util.Pair(2, 4);

            case MI18:
                return new javafx.util.Pair(2, 5);

            case DO8:
                return new javafx.util.Pair(3, 0);

            case DO10:
                return new javafx.util.Pair(3, 1);

            case DO12:
                return new javafx.util.Pair(3, 2);

            case DO14:
                return new javafx.util.Pair(3, 3);

            case DO16:
                return new javafx.util.Pair(3, 4);

            case DO18:
                return new javafx.util.Pair(3, 5);

            case F8:
                return new javafx.util.Pair(4, 0);

            case F10:
                return new javafx.util.Pair(4, 1);

            case F12:
                return new javafx.util.Pair(4, 2);

            case F14:
                return new javafx.util.Pair(4, 3);

            case F16:
                return new javafx.util.Pair(4, 4);

            case F18:
                return new javafx.util.Pair(4, 5);

        }
        return null;
    }
}






