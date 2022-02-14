package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.*;

public class KullaniciDAO {

    public static boolean giriseYetkilimi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtSifre = null;

        Connection conn = VTBaglanti.baglantiGetir();

        //bu postgresql den kullanici adi kimse (admin yada user) sifresini getir demek
        String sorgu = "select sifre from kullanici where kullanici_adi=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setString(1,kullanici.getKullaniciAdi());

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            vtSifre = rs.getString("sifre");
        }

        rs.close();
        ps.close();
        VTBaglanti.baglantiKapat(conn);

        /*burda gelen şifreyle bizim gircegimiz sifre aynı mı kodu yazılıyor
        duğruysa true
        yanlışsa false
         */

        if (kullanici.getSifre().equals(vtSifre))
            return true;
        else
            return false;

    }
}
