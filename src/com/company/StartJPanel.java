package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StartJPanel {
    private JFrame frame = new JFrame();
    private JPanel contents = new JPanel();
    private JButton task1bt, task2bt, task3bt, task4bt, task5bt, task6bt;
    private List<JPanel> allJPanels = new ArrayList<>();
    private AddToBox addToBox = new AddToBox();
    private SwapButtonNames swapButtonNames = new SwapButtonNames();
    private CheckRadioButton checkRadioButton = new CheckRadioButton();
    private CheckCheckBox checkCheckBox = new CheckCheckBox();
    private TextToTable textToTable = new TextToTable();
    private CreateCheckBox createCheckBox = new CreateCheckBox();

    private void AddToList(){
        allJPanels.add(addToBox);
        allJPanels.add(swapButtonNames);
        allJPanels.add(checkRadioButton);
        allJPanels.add(checkCheckBox);
        allJPanels.add(textToTable);
        allJPanels.add(createCheckBox);
    }

    private void ShowContent(int digit, int width, int height){
        frame.add(allJPanels.get(digit - 1));
        for (JPanel allJPanel : allJPanels) {
            allJPanel.setVisible(false);
        }
        allJPanels.get(digit - 1).setVisible(true);
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    public void initialize() {
        contents.setLayout(null);

        task1bt = new JButton("Task 1");
        task1bt.setBounds(0, 0, 300, 50);
        contents.add(task1bt);
        task2bt = new JButton("Task 2");
        task2bt.setBounds(0, 70, 300, 50);
        contents.add(task2bt);
        task3bt = new JButton("Task 3");
        task3bt.setBounds(0, 140, 300, 50);
        contents.add(task3bt);
        task4bt = new JButton("Task 4");
        task4bt.setBounds(0, 210, 300, 50);
        contents.add(task4bt);
        task5bt = new JButton("Task 5");
        task5bt.setBounds(0, 280, 300, 50);
        contents.add(task5bt);
        task6bt = new JButton("Task 6");
        task6bt.setBounds(0, 350, 300, 50);
        contents.add(task6bt);
        frame.add(contents);
        frame.setSize(300,450);
        frame.setVisible(true);
        AddToList();
        action();
    }

    private void action() {
        task1bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowContent(1, 720, 450);
            }
        });

        task2bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { ShowContent(2, 720, 450); }
        });

        task3bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowContent(3, 720, 450);
            }
        });

        task4bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowContent(4, 720, 450);
            }
        });

        task5bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowContent(5, 1030,450);
            }
        });

        task6bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ShowContent(6, 940,450);
            }
        });
    }



}
