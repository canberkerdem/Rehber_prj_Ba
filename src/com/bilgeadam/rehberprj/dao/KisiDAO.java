package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.sec.AES;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;
import com.bilgeadam.rehberprj.util.Sabitler;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KisiDAO {

    public static boolean ekle (KisiDTO kisi) throws SQLException, ClassNotFoundException {


        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "insert into kisi(no,ad,soyad,maas,dogtar,mobil_tel)values(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        //Burdaki 1 yukarıdaki 1.soru işaretini değeri
        ps.setInt(1,kisi.getNo());
        ps.setString(2, kisi.getAd());
        ps.setString(3, kisi.getSoyad());
        ps.setDouble(4,kisi.getMaas());
        ps.setDate(5, CevirmeIslemleri.utilToSqlDate(kisi.getDogtar()));
        //ps.setDate(5,new java.sql.Date(kisi.getDogtar().getTime())); başka bir yöntem
        ps.setString(6, kisi.getMobilTel());

        int sonuc = ps.executeUpdate();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        if (sonuc>0)
            return true;
        else
            return false;



    }
    public static List<KisiDTO> listele()
    {
            List<KisiDTO> kisiListesi = new ArrayList<>();
            return kisiListesi;
    }
}
