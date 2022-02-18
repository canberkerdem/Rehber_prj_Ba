package com.bilgeadam.rehberprj.test;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import java.sql.SQLException;

public class KullaniciDAOTest {

    public static void main(String[] args) {

        try {
            KullaniciDTO kullanici = new KullaniciDTO();
            kullanici.setKullaniciAdi("admin");
            kullanici.setSifre("admin1234");
            kullanici.setAktif(1);

            boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);

            if (sonuc)
                System.out.println("Girişe Yetkilidir");
            else
                System.out.println("Girişe Yetkili Değildir!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
