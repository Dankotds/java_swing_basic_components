package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapButtonNames extends JPanel {
    private JButton placeTextBt, swapBt;
    private JTextField fieldForText;
    private String firstName, secondName;

    public SwapButtonNames(){

        this.setLayout(null);
        fieldForText = new JTextField();
        fieldForText.setBounds(400, 0, 300, 50);
        this.add(fieldForText);

        placeTextBt = new JButton("Place text in 2nd button");
        placeTextBt.setBounds(400, 70, 300, 50);
        this.add(placeTextBt);

        swapBt = new JButton("Swap names");
        swapBt.setBounds(400, 140, 300, 50);
        this.add(swapBt);

        action();


        this.setVisible(true);
    }

    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }

    private void action(){
        placeTextBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fieldForText.getText().equals("")) {
                    firstName = fieldForText.getText();
                    swapBt.setText(firstName);
                    fieldForText.setText("");
                } else {
                    error_empty();
                }
            }
        });

        swapBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    firstName = swapBt.getText();
                    secondName = placeTextBt.getText();
                    placeTextBt.setText(firstName);
                    swapBt.setText(secondName);
            }
        });
    }
}
