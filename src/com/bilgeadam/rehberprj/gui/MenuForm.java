package com.bilgeadam.rehberprj.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame{
    private JButton ekleButton;
    private JPanel jPanel1;

    public MenuForm()
    {
        add(jPanel1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menü Ekranı");
        setSize(300,200);
        setLocationRelativeTo(null);


        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EkleForm ekle = new EkleForm();
                ekle.setVisible(true);
            }
        });
    }
}
