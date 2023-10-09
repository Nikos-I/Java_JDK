package sem1.hw1;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
public class ChatWindow extends JDialog {

    public static String server = "";
    public static String port = "";
    public static String login = "";
    public static String password = "";

    public final String FILENAMELOG = "./chat.log";
    private final LogHandler log;

    private JPanel pnlMain1;
    private JButton btnSend;
    private JButton btnCancel;
    private JButton btnConnect;
    private JButton btnSave;
    private JTextArea areaChat;
    private JToolBar tbMain;
    private JPanel pnlServer;
    private JPanel pnlLog;
    private JButton btnDisconnect;
    private JButton btnLoad;
    private JPanel pnlContent;
    private JPanel pnlMessage;
    private JPanel pnlChat;
    private JButton btnExit;
    private JScrollPane scrollArea;
    private JTextField txtMessage;

    public ChatWindow() throws IOException {
        log = new LogHandler(FILENAMELOG);

        setContentPane(pnlMain1);
        setModal(true);
        getRootPane().setDefaultButton(btnSend);

        btnSend.addActionListener(e -> {
            try {
                onSend();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        pnlMain1.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnConnect.addActionListener(e -> {
            try {
                onConnect();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnDisconnect.addActionListener(e -> {
            try {
                onDisConnect();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnSave.addActionListener(e -> {
            try {
                log.write(areaChat.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        btnLoad.addActionListener(e -> onload());
        btnExit.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);

    }

    private void onSend() throws IOException {
        String msgText = String.format("%s: %s\n", login, txtMessage.getText());
        areaChat.append(msgText);
        log.write(msgText);
    }

    private void onCancel() {
        txtMessage.setText("");
    }

    private void onConnect() throws IOException {
        Connect dialog = new Connect();
        dialog.pack();
        dialog.setVisible(true);
        areaChat.setText("");
        onload();
        String msgText = String.format("Пользователь %s вошел в чат\n", login);
//        pnlMessage.setToolTipText(String.format("Сообщение от %s", login));
        areaChat.append(msgText);
        log.write(msgText);
        txtMessage.setEnabled(true);
        btnSend.setEnabled(true);
        btnCancel.setEnabled(true);
    }

    private void onDisConnect() throws IOException {
        String msgText = String.format("Пользователь %s покинул чат\n", login);
        areaChat.append(msgText);
        log.write(msgText);
        txtMessage.setEnabled(false);
        btnSend.setEnabled(false);
        btnCancel.setEnabled(false);

    }

    private void onload() {
        List<String> logString;
        try {
            logString = log.read();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        for (String str : logString) {
            areaChat.append(str + "\n");
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
