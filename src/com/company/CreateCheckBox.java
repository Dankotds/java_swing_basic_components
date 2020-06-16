package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCheckBox extends JPanel {
    private JTextField fieldForTheNumberOfBoxes;
    private JButton createChBoxesBt, startOrContinueBt, stopBt;
    private JCheckBox[] checkBoxes;
    private int checkboxNum = 0, checkboxToCheck, checkboxToUncheck;
    private boolean scriptIsStopped = false;

    public CreateCheckBox(){
        this.setLayout(null);

        fieldForTheNumberOfBoxes = new JTextField();
        fieldForTheNumberOfBoxes.setBounds(400,0, 300, 50);
        this.add(fieldForTheNumberOfBoxes);

        createChBoxesBt = new JButton("Create JCheckBoxes");
        createChBoxesBt.setBounds(400, 70, 300, 50);
        this.add(createChBoxesBt);

        startOrContinueBt = new JButton("Start/Continue script");
        startOrContinueBt.setBounds(400, 140, 300, 50);
        this.add(startOrContinueBt);

        stopBt = new JButton("Pause script");
        stopBt.setBounds(400, 210, 300, 50);
        this.add(stopBt);

        action();

        setVisible(true);
    }

    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }
    private void error(){ JOptionPane.showMessageDialog(this, "Ошибка!\nЧто-то пошло не так!"); }

    private void addBox(int y, int i){
        checkBoxes[i] = new JCheckBox("JCheckBox number " + (i+1));
        checkBoxes[i].setBounds(720, 0+y, 300,50);
        this.add(checkBoxes[i]);
    }

    private void selectBox(boolean state, int i, int j){
        while(!scriptIsStopped) {
                checkBoxes[i].setSelected(state);
                checkBoxes[j].setSelected(state);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    error();
                }
                return;
        }
    }

    private void action(){
        createChBoxesBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int y = 0;
                checkboxToCheck = 0;
                checkboxToUncheck = 0;
                if (!fieldForTheNumberOfBoxes.getText().equals("")) {
                    if(checkboxNum !=0){
                        for(int i = 0; i< checkboxNum; i++){
                            checkBoxes[i].setVisible(false);
                        }
                    }
                    checkboxNum = Integer.parseInt(fieldForTheNumberOfBoxes.getText());
                    checkBoxes = new JCheckBox[checkboxNum];
                    for(int i = 0; i < checkboxNum; i++){
                        addBox(y, i);
                        y+=70;
                    }
                    fieldForTheNumberOfBoxes.setText("");
                } else {
                    error_empty();
                }
            }
        });

        startOrContinueBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                scriptIsStopped = false;
                if (!scriptIsStopped) {
                    new Thread(() -> {
                        while(checkboxToCheck < checkboxNum - checkboxToCheck){
                            selectBox(true, checkboxToCheck, (checkboxNum -1- checkboxToCheck));
                            if(scriptIsStopped) {
                                checkboxToCheck++;
                                break;
                            }
                            checkboxToCheck++;
                        }
                        while(checkboxToUncheck < checkboxNum - checkboxToUncheck){
                            selectBox(false, checkboxToUncheck, (checkboxNum -1- checkboxToUncheck));
                            if(scriptIsStopped) {
                                break;
                            }
                            checkboxToUncheck++;
                        }
                        if(!scriptIsStopped){
                            checkboxToCheck = 0;
                            checkboxToUncheck = 0;
                        }
                    }).start();
                }
            }
        });

        stopBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!scriptIsStopped){
                    scriptIsStopped = true;
                }
            }
        });
    }
}
