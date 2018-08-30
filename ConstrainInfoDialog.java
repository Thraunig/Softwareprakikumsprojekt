package at.aau.raunig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstrainInfoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public ConstrainInfoDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        ConstrainInfoDialog dialog = new ConstrainInfoDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}
