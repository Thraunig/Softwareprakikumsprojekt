/*
@author: Raunig
 */

package at.aau.raunig;



import java.io.*;
import java.awt.datatransfer.*;
import javax.swing.*;

class LVTransferHandler extends TransferHandler {


    public boolean importData(TransferHandler.TransferSupport info) {
        Lehrveranstaltung data = null;
        if (!canImport(info)) {
            return false;
        }

        JList list = (JList)info.getComponent();
        DefaultListModel model = (DefaultListModel)list.getModel();
        //Fetch the data -- bail if this fails
        try {
            data = (Lehrveranstaltung) info.getTransferable().getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException ufe) {
            System.out.println("importData: unsupported data flavor");
            return false;
        } catch (IOException ioe) {
            System.out.println("importData: I/O exception");
            return false;
        }

        if (info.isDrop()) { //This is a drop
            JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
            int index = dl.getIndex();
            if (dl.isInsert()) {
                model.add(index, data);
                return true;
            } else {
                model.set(index, data);
                return true;
            }
        } else { //This is a paste
            int index = list.getSelectedIndex();
            // if there is a valid selection,
            // insert data after the selection
            if (index >= 0) {
                model.add(list.getSelectedIndex()+1, data);
                // else append to the end of the list
            } else {
                model.addElement(data);
            }
            return true;
        }
    }

    /**
     * Bundle up the data for export.
     */
    protected Transferable createTransferable(JComponent c) {
        JList list = (JList)c;
        int index = list.getSelectedIndex();
        Lehrveranstaltung value = (Lehrveranstaltung) list.getSelectedValue();

        // TO DO: LV Sele
        return new StringSelection("Blablabla");
    }

    /**
     * The list handles both copy and move actions.
     */
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    /**
     * When the export is complete, remove the old list entry if the
     * action was a move.
     */
    protected void exportDone(JComponent c, Transferable data, int action) {
        if (action != MOVE) {
            return;
        }
        JList list = (JList)c;
        DefaultListModel model = (DefaultListModel)list.getModel();
        int index = list.getSelectedIndex();
        model.remove(index);
    }

    /**
     * We only support importing strings.
     */
    public boolean canImport(TransferHandler.TransferSupport support) {
        // we only import Strings
        if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }
}