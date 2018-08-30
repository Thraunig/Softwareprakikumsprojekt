package at.aau.raunig;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

/*
Diese Klasse dient zum Handeln der Übergabe von einer LV in einen anderen Slot.
 Nach jedem Transfer wird die neue Lehrveranstaltungsliste an die GUI übergeben
 und neu befüllt


 */

public class Plan {
    //5 Zeilen 6 Spalten
    DefaultListModel<String>[][] stundenplan = new DefaultListModel[6][5];

    List<Lehrveranstaltung> lehrveranstaltungList;
    HashMap<Integer, Lehrveranstaltung> mappingHashtoLV;
    ScheduleLayout2 scheduleLayout2;


    String a = " sadsa";


    public Plan(ScheduleLayout2 scheduleLayout2) {
        this.scheduleLayout2 = scheduleLayout2;
        this.lehrveranstaltungList = ScheduleLayout2.lehrveranstaltungList;
        mappingHashtoLV = new HashMap<Integer, Lehrveranstaltung>();

    }


    /*
    Mapping befüllen der Hashmap

    Der Hashcode der LVtoString und des Slots der LV
     */
    public void createMapping(List<Lehrveranstaltung> liste) {
        mappingHashtoLV = new HashMap<Integer, Lehrveranstaltung>();
        System.out.println("Create HashCode");
        for (Lehrveranstaltung lehrveranstaltung : liste
                ) {
            //System.out.println(lehrveranstaltung.LVtoString() + " " + lehrveranstaltung.LVtoString().hashCode() + lehrveranstaltung.slot.hashCode());
            mappingHashtoLV.put(lehrveranstaltung.LVtoString().hashCode() + lehrveranstaltung.slot.hashCode(), lehrveranstaltung);
        }
    }

    /*
    Get LV from Hashcode
     */
    public Lehrveranstaltung getLVfromHashcode(int hashcode) {
        return mappingHashtoLV.get(hashcode);
    }

    /*
    Get Hashcode from LV
     */
    public int getHashCodeFromLV(Lehrveranstaltung lehrveranstaltung) {
        return lehrveranstaltung.LVtoString().hashCode() + lehrveranstaltung.slot.hashCode();
    }

    /*
    Hinzufügen eines neuen LV Leiters
     */
    public void neueLV(Lehrveranstaltung lehrveranstaltung){
        int hashCode = getHashCodeFromLV(lehrveranstaltung);
        mappingHashtoLV.put(hashCode,lehrveranstaltung);
    }



    /*
   Hinzufügen eines neuen LV Leiters
    */
    public void remove(Lehrveranstaltung lehrveranstaltung){
        int hashCode = getHashCodeFromLV(lehrveranstaltung);
        mappingHashtoLV.remove(hashCode);
    }

    /*
    Move LV with Hashcode
    Sollte eigentlich gehen.
     */
    public void moveLV(int hashCode, Lehrveranstaltung.Slot neuerSlot) {
        //LV raussuchen

        Lehrveranstaltung dummy = mappingHashtoLV.get(hashCode);
        System.out.println("Alter Slot von Dummy: " + dummy.slot);
        mappingHashtoLV.get(hashCode).slot = neuerSlot;
        //alten removen
        mappingHashtoLV.remove(hashCode);
        //neuen Drauflegen
        mappingHashtoLV.put(getHashCodeFromLV(dummy), dummy);


        System.out.println("Neuer Slot von Dummy: " + dummy.slot);
    }


}
