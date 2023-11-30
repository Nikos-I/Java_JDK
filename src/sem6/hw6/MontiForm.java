package sem6.hw6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("unused")
public class MontiForm extends JDialog {
    final String GOAT="Коза";
    final String PRIZE="Приз";
    final Integer WIN=1;
    final Integer LOSS=0;
    Random generator=new Random();
    int userDoor, openDoor, otherDoor;
    int goatDoor1, goatDoor2, prizeDoor;
    Map<Integer, Integer> gameStatistic=new HashMap<Integer, Integer>();
    Integer step=1;

    private JPanel contentPane;
    private JButton btnStatistic;
    private JButton btnFinish;
    private JPanel gamePane;
    private JButton btnDoor1;
    private JButton btnDoor2;
    private JButton btnDoor3;
    private JButton btnRun;
    private JButton btnChoice;
    private JLabel lblHint;
    private JTextArea txtHelp;
    private JLabel lblAction;
    private JButton btnResult;


    public MontiForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnStatistic);

        initForm();

        btnStatistic.addActionListener(e -> onStatistic());

        btnFinish.addActionListener(e -> onFinish());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onFinish();
            }
        });
        // call onCancel() on ESCAPE

        contentPane.registerKeyboardAction(e -> onFinish(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnRun.addActionListener(e -> onRun());

        btnChoice.addActionListener(e -> onChoice());

        btnResult.addActionListener(e -> onResult());

        btnDoor1.addActionListener(e -> {
            btnDoor1.setBackground(Color.MAGENTA);
            btnDoor2.setBackground(Color.LIGHT_GRAY);
            btnDoor3.setBackground(Color.LIGHT_GRAY);
            userDoor=1;
        });
        btnDoor2.addActionListener(e -> {
            btnDoor1.setBackground(Color.LIGHT_GRAY);
            btnDoor2.setBackground(Color.MAGENTA);
            btnDoor3.setBackground(Color.LIGHT_GRAY);
            userDoor=2;
        });
        btnDoor3.addActionListener(e -> {
            btnDoor1.setBackground(Color.LIGHT_GRAY);
            btnDoor2.setBackground(Color.LIGHT_GRAY);
            btnDoor3.setBackground(Color.MAGENTA);
            userDoor=3;
        });
    }

    public static void main(String[] args) {

        MontiForm dialog=new MontiForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onStatistic() {
        // add your code here
        int statSize=gameStatistic.size();
        int countWine=Collections.frequency(gameStatistic.values(), WIN);
        int countLoss=Collections.frequency(gameStatistic.values(), LOSS);
        float procWin=(float) ((float) countWine / (float) statSize * 100.0);
        float procLoss=(float) ((float) countLoss / (float) statSize * 100.0);
        String hint=String.format("Шагов: %d, Побед: %d (%5.2f%%), Поражений: %d (%5.2f%%)", statSize, countWine, procWin, countLoss, procLoss);
//        String hint =  String.format("Шагов: %d, Побед: %d (%f), Поражений: %d (%f)", statSize, countWine, countWine/statSize*100, countLoss, countLoss/statSize*100);
        lblHint.setText(hint);

    }

    private void onFinish() {
        // add your code here if necessary
        dispose();
    }

    private void onRun() {
        // Начальные установки формы
        setInitialForm();

        // Генерация дверей
        prizeDoor=generator.nextInt(3) + 1;
        goatDoor1=prizeDoor;

        while (goatDoor1 == prizeDoor) {
            goatDoor1=generator.nextInt(3) + 1;
        }
        goatDoor2=goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2=generator.nextInt(3) + 1;
        }
        lblHint.setText("");
        lblHint.setText("Выберите дверь (1, 2 или 3)");


        btnRun.setEnabled(false);
        btnChoice.setEnabled(true);
        btnResult.setEnabled(false);
    }

    void onChoice() {
        if (userDoor == goatDoor1) {
            openDoor=goatDoor2;
            otherDoor=prizeDoor;
        } else if (userDoor == goatDoor2) {
            openDoor=goatDoor1;
            otherDoor=prizeDoor;
        } else {
            openDoor=goatDoor1;
            otherDoor=goatDoor2;
        }
        switch (openDoor) {
            case 1 -> btnDoor1.setText(GOAT);
            case 2 -> btnDoor2.setText(GOAT);
            case 3 -> btnDoor3.setText(GOAT);
        }
        lblHint.setText("Вы можете сменить выбранную дверь");
        btnRun.setEnabled(false);
        btnChoice.setEnabled(false);
        btnResult.setEnabled(true);
    }

    void onResult() {
        btnRun.setEnabled(true);
        btnChoice.setEnabled(false);
        btnResult.setEnabled(false);

        String Hint="Приз находится за дверью номер: " + prizeDoor;

        if (userDoor == prizeDoor) {
            gameStatistic.put(step, WIN);
            Hint=Hint + " Поздравляем! Вы выиграли приз!";
        } else {
            Hint=Hint + " Извините. Вы проиграли игру.";
            gameStatistic.put(step, LOSS);
        }
        step++;

        switch (prizeDoor) {
            case 1 -> btnDoor1.setText(PRIZE);
            case 2 -> btnDoor2.setText(PRIZE);
            case 3 -> btnDoor3.setText(PRIZE);
        }
        lblHint.setText(Hint);
    }

    void setInitialForm() {
        btnDoor1.setBackground(Color.LIGHT_GRAY);
        btnDoor2.setBackground(Color.LIGHT_GRAY);
        btnDoor3.setBackground(Color.LIGHT_GRAY);
        btnDoor1.setText("1");
        btnDoor2.setText("2");
        btnDoor3.setText("3");
        userDoor=0;
        btnDoor1.setEnabled(true);
        btnDoor2.setEnabled(true);
        btnDoor3.setEnabled(true);
    }

    void initForm() {
        btnDoor1.setEnabled(false);
        btnDoor2.setEnabled(false);
        btnDoor3.setEnabled(false);
    }
}
