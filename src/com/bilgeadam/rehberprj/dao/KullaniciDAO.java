package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.sec.AES;
import com.bilgeadam.rehberprj.util.Sabitler;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.*;

public class KullaniciDAO {

    public static boolean giriseYetkilimi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtSifre = null;

        Connection conn = VTBaglanti.baglantiGetir();

        //bu postgresql den kullanici adi kimse (admin yada user) sifresini getir demek
        String sorgu = "select sifre from kullanici where kullanici_adi=? and aktif=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        //Burdaki 1 yukarıdaki 1.soru işaretini değeri
        ps.setString(1,kullanici.getKullaniciAdi());
        //Buda 2.soru işaretinin değeri yani aktifin
        ps.setInt(2,kullanici.getAktif());

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            vtSifre = rs.getString("sifre");
        }

        rs.close();
        ps.close();
        VTBaglanti.baglantiKapat(conn);


        String cozulmus_sifre =null;


        if(vtSifre!=null)

        {
            cozulmus_sifre = AES.decrypt(vtSifre, Sabitler.SECRET_KEY);
        }

        else
        {
            //vtSifre null ise aşağıdaki eşitliği kontrol etmeye gerek yok
            //Buradan metod sonucunu false olarak döndürüyorum.
            return false;
        }


        /*burda gelen şifreyle bizim gircegimiz sifre aynı mı kodu yazılıyor
        duğruysa true
        yanlışsa false
         */

        if (kullanici.getSifre().equals(cozulmus_sifre))
            return true;
        else
            return false;

    }
}
