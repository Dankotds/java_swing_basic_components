package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCheckBox extends JPanel {
    private JTextField fieldForTheNumberOfBoxes;
    private JButton createChBoxesBt, startOrContinueBt, stopBt;
    private JCheckBox[] checkBoxes;
    private int digit = 0, value_true, value_false;
    private boolean stop = false;

    public CreateCheckBox(){
        this.setLayout(null);
        //contents.setLayout(new BorderLayout());
        fieldForTheNumberOfBoxes = new JTextField();
        fieldForTheNumberOfBoxes.setBounds(400,0, 300, 50);
        //contents.add(field1);
        this.add(fieldForTheNumberOfBoxes);
        createChBoxesBt = new JButton("Create JCheckBoxes");
        createChBoxesBt.setBounds(400, 70, 300, 50);
        //contents.add(createChBoxesBt);
        this.add(createChBoxesBt);
        startOrContinueBt = new JButton("Start/Continue script");
        startOrContinueBt.setBounds(400, 140, 300, 50);
        //contents.add(startOrContinueBt);
        this.add(startOrContinueBt);
        stopBt = new JButton("Pause script");
        stopBt.setBounds(400, 210, 300, 50);
        //contents.add(stopBt);
        this.add(stopBt);

        action();

        // Открытие окна
        setVisible(true);
    }

    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }
    private void error(){ JOptionPane.showMessageDialog(this, "Ошибка!\nЧто-то пошло не так!"); }

    private void add_box(int y, int i){
        checkBoxes[i] = new JCheckBox("JCheckBox number " + (i+1));
        checkBoxes[i].setBounds(720, 0+y, 300,50);
        this.add(checkBoxes[i]);
    }

    private void select_box(boolean state, int i, int j){
        while(!stop) {
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
                value_true = 0;
                value_false = 0;
                if (!fieldForTheNumberOfBoxes.getText().equals("")) {
                    if(digit!=0){
                        for(int i = 0; i<digit; i++){
                            checkBoxes[i].setVisible(false);
                        }
                    }
                    digit = Integer.parseInt(fieldForTheNumberOfBoxes.getText());
                    checkBoxes = new JCheckBox[digit];
                    for(int i = 0; i < digit; i++){
                        add_box(y, i);
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
                stop = false;
                if (!stop) {
                    new Thread(() -> {
                        while(value_true < digit-value_true){
                            select_box(true, value_true, (digit-1-value_true));
                            if(stop) {
                                value_true++;
                                break;
                            }
                            value_true++;
                        }
                        while(value_false < digit-value_false){
                            select_box(false, value_false, (digit-1-value_false));
                            if(stop) {
                                break;
                            }
                            value_false++;
                        }
                        if(!stop){
                            value_true = 0;
                            value_false = 0;
                        }
                    }).start();
                }
            }
        });

        stopBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!stop){
                    stop = true;
                    //ПАУЗА
                }
            }
        });
    }
}
