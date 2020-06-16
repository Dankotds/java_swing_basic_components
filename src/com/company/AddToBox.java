package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddToBox extends JPanel {
    private String textToAdd;
    private List<String> list = new ArrayList<>();
    private JButton addToBoxBt = new JButton("Внести данные в ComboBox");
    private JTextField fieldForNewWords = new JTextField();
    private JComboBox box = new JComboBox();

    public AddToBox() {
        // Создание панели
        this.setLayout(null);

        addToBoxBt.setBounds(400, 70, 300, 50);
        this.add(addToBoxBt);
        fieldForNewWords.setBounds(400, 0, 300, 50);
        this.add(fieldForNewWords);
        box.setEditable(true);
        box.setBounds(400, 140, 300, 50);
        this.add(box);

        action();

        // Открытие окна
        this.setVisible(true);
    }

    private void error_replay() {
        JOptionPane.showMessageDialog(this, "Ошибка!\nТакое слово уже добавлено!");
    }
    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }
    private void addToComboBox(String word) {
        if (list.contains(word)) {
            error_replay();
        } else {
            list.add(word);
            box.addItem(word);
        }
    }

    private void action() {
        addToBoxBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fieldForNewWords.getText().equals("")) {
                    textToAdd = fieldForNewWords.getText();
                    addToComboBox(textToAdd);
                    fieldForNewWords.setText("");
                } else {
                    error_empty();
                }
            }
        });
    }
}
