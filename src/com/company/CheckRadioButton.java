package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckRadioButton extends JPanel {
    //JPanel contents = new JPanel();
    private JButton selectBt;
    private JRadioButton rbtTest1, rbtTest2, rbtTest3;
    private JTextField fieldWithRbtnText;
    private String text;

    public CheckRadioButton() {
        //super("Panel 3");
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        // Создание панели
        //contents.setLayout(null);
        this.setLayout(null);
        //contents.setLayout(new BorderLayout());
        fieldWithRbtnText = new JTextField();
        fieldWithRbtnText.setBounds(400,0, 300, 50);
        //contents.add(fieldWithRbtnText);
        this.add(fieldWithRbtnText);
        selectBt = new JButton("Отметить JRadioButton");
        selectBt.setBounds(400, 70, 300, 50);
        //contents.add(selectBt);
        this.add(selectBt);
        rbtTest1 = new JRadioButton("Test1");
        rbtTest1.setBounds(400, 140, 300, 50);
        //contents.add(rbtTest1);
        this.add(rbtTest1);
        rbtTest2 = new JRadioButton("Test2");
        rbtTest2.setBounds(400, 210, 300, 50);
        //contents.add(rbtTest2);
        this.add(rbtTest2);
        rbtTest3 = new JRadioButton("Test3");
        rbtTest3.setBounds(400, 280, 300, 50);
        //contents.add(rbtTest3);
        this.add(rbtTest3);
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


    private void action() {
        selectBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fieldWithRbtnText.getText().equals("")) {
                    text = fieldWithRbtnText.getText();
                    if (rbtTest1.getText().equals(text)){
                        rbtTest1.setSelected(true);
                        rbtTest2.setSelected(false);
                        rbtTest3.setSelected(false);
                    } else{

                        if (rbtTest2.getText().equals(text)){
                            rbtTest1.setSelected(false);
                            rbtTest2.setSelected(true);
                            rbtTest3.setSelected(false);
                        } else{

                            if (rbtTest3.getText().equals(text)){
                                rbtTest1.setSelected(false);
                                rbtTest2.setSelected(false);
                                rbtTest3.setSelected(true);
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
