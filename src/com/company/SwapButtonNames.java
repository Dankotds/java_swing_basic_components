package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapButtonNames extends JPanel {
    //JPanel contents = new JPanel();
    private JButton placeTextBt, swapBt;
    private JTextField fieldForText;
    private String text_1, text_2;

    public SwapButtonNames(){
        //super("Panel 2");
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        // Создание панели
        //contents.setLayout(null);
        this.setLayout(null);
        fieldForText = new JTextField();
        fieldForText.setBounds(400, 0, 300, 50);
        //contents.add(fieldForText);
        this.add(fieldForText);
        placeTextBt = new JButton("Place text in 2nd button");
        placeTextBt.setBounds(400, 70, 300, 50);
        //contents.add(placeTextBt);
        this.add(placeTextBt);
        swapBt = new JButton("Swap names");
        swapBt.setBounds(400, 140, 300, 50);
        //contents.add(swapBt);
        this.add(swapBt);
        // Замена панели содержимого
        //setContentPane(this);
        // Определение размера окна
        //setSize(300, 350);

        action();
        // Открытие окна
        this.setVisible(true);
    }

    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }

    private void action(){
        placeTextBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fieldForText.getText().equals("")) {
                    text_1 = fieldForText.getText();
                    swapBt.setText(text_1);
                    fieldForText.setText("");
                } else {
                    error_empty();
                }
            }
        });

        swapBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    text_1 = swapBt.getText();
                    text_2 = placeTextBt.getText();
                    placeTextBt.setText(text_1);
                    swapBt.setText(text_2);
            }
        });
    }
}
