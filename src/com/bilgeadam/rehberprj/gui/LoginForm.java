package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JTextField adTF;
    private JPasswordField sifreTF;
    private JButton girisButton;
    private JPanel jpanel1;

    public LoginForm() {
        add(jpanel1);

        //Formun çarpısına basınca programdan çıksın
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ekrana isim verir
        setTitle("Giriş Ekranı");

        //Ekran ölçülerini ayarlar
        setSize(400, 300);

        //Ekrana göre ortala
        //Mutlka setSize dan sonra koy
        setLocationRelativeTo(null);
        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //JOptionPane.showMessageDialog(null,"Butona basıldı");
                if (adTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Ad alanı boş geçilemez");
                    return;
                }
                if (String.valueOf(sifreTF.getPassword()).length() == 0) {
                    JOptionPane.showMessageDialog(null, "Şifre alanı boş geçilemez");
                    return;
                }
                try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifreTF.getPassword()));

                    boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);

                    if (sonuc){
                       MenuForm menu = new MenuForm();
                       //menu ekranını göster
                       menu.setVisible(true);
                       //login ekranını gizle
                       setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Girişe Yetkili değildir");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata:" + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata:" + ex.getMessage());
                }

            }
        });
    }
}
