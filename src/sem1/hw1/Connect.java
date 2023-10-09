package sem1.hw1;

import javax.swing.*;
import java.awt.event.*;

public class Connect extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel pnlText;
    private JPanel pnlButton;
    private JTextField txtServer;
    private JTextField txtPort;
    private JTextField txtLogin;
    private JTextField txtPassword;

    public Connect() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setLocationRelativeTo(null);
    }

    private void onOK() {
        ChatWindow.server=txtServer.getText();
        ChatWindow.port=txtPort.getText();
        ChatWindow.login=txtLogin.getText();
        ChatWindow.password=txtPassword.getText();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Connect dialog=new Connect();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
