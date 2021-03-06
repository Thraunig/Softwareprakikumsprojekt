package at.aau.raunig;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class LVListCellRenderer extends JLabel implements ListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {

        // Wert aus der Liste wird als Person interpretiert (gecastet)
        Lehrveranstaltung lehrveranstaltung = (Lehrveranstaltung) value;

        // Name der Person wird als Text gesetzt
        this.setText(lehrveranstaltung.LVtoString());

        // Muss aufgerufen werden ansonsten hat this.setBackground keine Wirkung
        this.setOpaque(true);

        // Element aus der Liste ist markiert
        if(isSelected){
            // Schriftfarbe
            // UIManager.getColor("List.selectionForeground") gibt die
            // Standard Schriftfarbe für ein markiertes Listen Element zurück
            this.setForeground(UIManager.getColor("List.selectionForeground"));
            // Hintergrund
            // UIManager.getColor("List.selectionBackground") gibt die
            // Standard Hintergrundfarbe für ein markiertes Listen Element zurück
            this.setBackground(UIManager.getColor("List.selectionBackground"));
        }
        // Element aus der Liste ist nicht markiert
        else{
            // Schriftfarbe
           // this.setForeground(person.getSchriftfarbe());
            // Hintergrund
           //this.setBackground(UIManager.getColor("List.background"));
            this.setBackground(lehrveranstaltung.farbe);
        }

        // Das Label wird zurückgegeben und nun angezeigt
        return this;
    }
}

