package com.bilgeadam.rehberprj.test;

import com.bilgeadam.rehberprj.dao.KisiDAO;
import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import java.sql.SQLException;
import java.text.ParseException;

public class KisiDAOTest {

    public void ekleTest() throws ParseException, SQLException, ClassNotFoundException {
        KisiDTO kisi = new KisiDTO();
        kisi.setNo(2);
        kisi.setAd("Zalim");
        kisi.setSoyad("Reis");
        kisi.setMaas(0);
        kisi.setDogtar(CevirmeIslemleri.strToUtilDate("21/04/2002"));
        kisi.setMobilTel("+90532saray");

        boolean sonuc = KisiDAO.ekle(kisi);

        if (sonuc)
            System.out.println("Başarıyla eklendi");
        else
            System.out.println("Eklenemedi");

    }
    public static void main(String[] args) {

        try {
            KisiDAOTest kdt = new KisiDAOTest();
            kdt.ekleTest();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
