package sem6.hw6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MontiForm extends JDialog {
    Random generator=new Random();
    int userDoor, openDoor, otherDoor;
    int goatDoor1, goatDoor2, prizeDoor;

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
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
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRun();
            }
        });

        btnChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChoice();
            }
        });
        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRun.setEnabled(true);
                btnChoice.setEnabled(false);
                btnResult.setEnabled(false);
            }
        });
        btnDoor1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDoor1.setBackground(Color.MAGENTA);
                btnDoor2.setBackground(Color.BLACK);
                btnDoor3.setBackground(Color.BLACK);
                userDoor = 1;
            }
        });
        btnDoor2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDoor1.setBackground(Color.BLACK);
                btnDoor2.setBackground(Color.MAGENTA);
                btnDoor3.setBackground(Color.BLACK);
                userDoor = 2;
            }
        });
        btnDoor3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDoor1.setBackground(Color.BLACK);
                btnDoor2.setBackground(Color.BLACK);
                btnDoor3.setBackground(Color.MAGENTA);
                userDoor = 3;
            }
        });
    }

    public static void main(String[] args) {

        MontiForm dialog=new MontiForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onRun() {
        // Генерация дверей
        int prizeDoor=generator.nextInt(3) + 1;
        int goatDoor1=prizeDoor;

        while (goatDoor1 == prizeDoor) {
            goatDoor1=generator.nextInt(3) + 1;
        }
        int goatDoor2=goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2=generator.nextInt(3) + 1;
        }
        lblHint.setText("");
        lblHint.setText("Выберите дверь (1, 2 или 3)");


        btnRun.setEnabled(false);
        btnChoice.setEnabled(true);
        btnResult.setEnabled(false);
    }

    void onChoice(){
        if(userDoor == goatDoor1) {
            openDoor = goatDoor2;
            otherDoor = prizeDoor;
        } else if(userDoor == goatDoor2) {
            openDoor = goatDoor1;
            otherDoor = prizeDoor;
        } else {
            openDoor = goatDoor1;
            otherDoor = goatDoor2;
        }

        switch (openDoor){
            case 1: btnDoor1.setText("Коза");
            case 2: btnDoor2.setText("Коза");
            case 3: btnDoor3.setText("Коза");
        }
        lblHint.setText("Вы можете сменить выбранную дверь");
        btnRun.setEnabled(false);
        btnChoice.setEnabled(false);
        btnResult.setEnabled(true);
    }


    }
