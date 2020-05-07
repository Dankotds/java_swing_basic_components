package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextToTable extends JPanel {
    //JPanel contents = new JPanel();
    private JButton to1ColBt, from1To2Bt, from2To1Bt;
    private JTable mainTable;
    private JTextField fieldForText;

    public TextToTable(){
        //super("Panel 5");
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        // Создание панели
        //contents.setLayout(null);
        this.setLayout(null);
        //contents.setLayout(new BorderLayout());
        fieldForText = new JTextField();
        fieldForText.setBounds(400,0, 300, 50);
        //contents.add(fieldForText);
        this.add(fieldForText);
        to1ColBt = new JButton("Place text in 1st column");
        to1ColBt.setBounds(400, 70, 300, 50);
        //contents.add(to1ColBt);
        this.add(to1ColBt);
        from1To2Bt = new JButton("1st -> 2nd");
        from1To2Bt.setBounds(400, 140, 300, 50);
        //contents.add(from1To2Bt);
        this.add(from1To2Bt);
        from2To1Bt = new JButton("2nd -> 1st");
        from2To1Bt.setBounds(400, 210, 300, 50);
        //contents.add(from2To1Bt);
        this.add(from2To1Bt);
        mainTable = new JTable(1,2);
        mainTable.setBounds(710, 20, 300, 17);
        mainTable.setGridColor(Color.orange);
        //contents.add(mainTable);
        this.add(mainTable);
        // Замена панели содержимого
        //setContentPane(contents);
        // Определение размера окна
        //setSize(620, 310);

        action();

        // Открытие окна
        setVisible(true);
    }

    private void error_empty(){ JOptionPane.showMessageDialog(this, "Ошибка!\nПоле не заполнено!"); }

    private void action(){

        to1ColBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fieldForText.getText().equals("")) {
                mainTable.getModel().setValueAt(fieldForText.getText(), 0,0);
                mainTable.getModel().setValueAt("", 0,1);
                fieldForText.setText("");
                } else {
                    error_empty();
                }
            }
        });

        from1To2Bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!mainTable.getModel().getValueAt(0,0).equals("")){
                    mainTable.getModel().setValueAt(mainTable.getModel().getValueAt(0,0), 0,1);
                    mainTable.getModel().setValueAt("", 0,0);
                }
            }
        });

        from2To1Bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!mainTable.getModel().getValueAt(0,1).equals("")){
                    mainTable.getModel().setValueAt(mainTable.getModel().getValueAt(0,1), 0,0);
                    mainTable.getModel().setValueAt("", 0,1);
                }
            }
        });
    }
}
