package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckCheckBox extends JPanel {
    //JPanel contents = new JPanel();
    private JButton selectBt;
    private JCheckBox chbTest1, chbTest2, chbTest3;
    private JTextField fieldWithChbxText;
    private String text;
    private boolean state;

    public CheckCheckBox(){
        //super("Panel 4");
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        // Создание панели
        //contents.setLayout(null);
        this.setLayout(null);
        //contents.setLayout(new BorderLayout());
        fieldWithChbxText = new JTextField();
        fieldWithChbxText.setBounds(400,0, 300, 50);
        //contents.add(fieldWithChbxText);
        this.add(fieldWithChbxText);
        selectBt = new JButton("Отметить JCheckBox");
        selectBt.setBounds(400, 70, 300, 50);
        //contents.add(selectBt);
        this.add(selectBt);
        chbTest1 = new JCheckBox("Test1");
        chbTest1.setBounds(400, 140, 300, 50);
        //contents.add(chbTest1);
        this.add(chbTest1);
        chbTest2 = new JCheckBox("Test2");
        chbTest2.setBounds(400, 210, 300, 50);
        //contents.add(chbTest2);
        this.add(chbTest2);
        chbTest3 = new JCheckBox("Test3");
        chbTest3.setBounds(400, 280, 300, 50);
        //contents.add(chbTest3);
        this.add(chbTest3);
        // Замена панели содержимого
        //setContentPane(contents);
        // Определение размера окна
        //setSize(300, 450);

        action();

        // Открытие окна
        setVisible(true);
    }

    private void error_not_replay() {
        JOptionPane.showMessageDialog(this, "Ошибка!\nНи одного совпадения не найдено!");
    }
    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }

    private void action(){
        selectBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fieldWithChbxText.getText().equals("")) {
                    text = fieldWithChbxText.getText();
                    if (chbTest1.getText().equals(text)){
                        state = chbTest1.isSelected();
                        chbTest1.setSelected(!state);
                    } else{

                        if (chbTest2.getText().equals(text)){
                            state = chbTest2.isSelected();
                            chbTest2.setSelected(!state);
                        } else{

                            if (chbTest3.getText().equals(text)){
                                state = chbTest3.isSelected();
                                chbTest3.setSelected(!state);
                            } else{
                                error_not_replay();
                            }
                        }
                    }
                } else {
                    error_empty();
                }
            }
        });
    }
}
