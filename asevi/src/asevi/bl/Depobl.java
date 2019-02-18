package asevi.bl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asevi.db.VeriTabaniBaglanti;

public class Depobl {
	
	public String[] depo;
	public VeriTabaniBaglanti baglanti;
	public int satir;
	
	public Depobl(String link, String kul_adi, String kul_sifre, String surucu)
	{
		baglanti = new VeriTabaniBaglanti(link, kul_adi, kul_sifre, surucu);
	}
	
	public Depobl()
	{
		String link = "jdbc:mysql://localhost:3306/asevi";
		String surucu = "com.mysql.jdbc.Driver";
		String kul_adi = "root";
		String kul_sifre = "";
		baglanti = new VeriTabaniBaglanti(link, kul_adi, kul_sifre, surucu);
	}
	
	public int ihaleEkle(String ihaleAdi, String tarih)
	{
		int dondur=0;
		String sorgu = ""; 
			try 
	    	{
		    	String ekle = "INSERT INTO ihale (ihale_adi,ihale_tarihi) VALUES ('"+ihaleAdi+"', '" + tarih+ "')";
				PreparedStatement hazirIfade = baglanti.baglanti.prepareStatement(ekle);
				hazirIfade.executeUpdate();
				sorgu = "SELECT ihale_id FROM ihale WHERE ihale_adi = '" + ihaleAdi + "'";
				ResultSet sonuc = baglanti.sorgu_tablo(sorgu);
				while(sonuc.next()){ dondur = sonuc.getInt("ihale_id"); }
				
			} 
	    	catch (SQLException e)
	    	{
				e.printStackTrace();
				
	    	}
			return dondur;
	}
	
	//public boolean bagisYapanEkle(String tcNo, String adiSoyadi, String vergiDairesi, String)
	
	public boolean ihaleMalzemeEkle(String malzemeAdi, int miktar, int birim, int ihaleId) throws SQLException
	{
		PreparedStatement hazirIfade = null;
		boolean snc =false;
		String ekle="";
    	boolean var = false;
    	int malzemeId=0;
		String sorgu = "SELECT malzeme_adi FROM malzeme WHERE malzeme_adi= '" + malzemeAdi + "'";
		ResultSet sonuc = baglanti.sorgu_tablo(sorgu);
		
		try 
		   {
			   while(sonuc.next()) {var=true; if (var)break;}
			    	
					if (var)
					{
						ekle = "UPDATE malzeme SET toplam_depo = toplam_depo + " + Integer.toString(miktar) + ", "
								+ "toplam_ihale = toplam_ihale + " + Integer.toString(miktar) +
								" WHERE malzeme.malzeme_adi = '" + malzemeAdi + "'";  
						hazirIfade = baglanti.baglanti.prepareStatement(ekle);
						hazirIfade.executeUpdate();
						snc=true;
					}
					else
					{
						ekle = "INSERT INTO malzeme (malzeme_adi,birim_id,toplam_depo,toplam_bagis, toplam_ihale)"
							  +" VALUES ('"+malzemeAdi+"', " + birim+ "," + miktar +","+"0,"+miktar + " )"; 
						hazirIfade = baglanti.baglanti.prepareStatement(ekle);
						hazirIfade.executeUpdate();
						snc = true;
					}
					sorgu = "SELECT malzeme_id FROM malzeme WHERE malzeme_adi= '" + malzemeAdi + "'";
					sonuc = baglanti.sorgu_tablo(sorgu);
					if(sonuc.next()) malzemeId = sonuc.getInt("malzeme_id");
					ekle = "INSERT INTO malzeme_ihale (ihale_id,malzeme_id,miktar)"
					+" VALUES ('"+ihaleId+"', " + malzemeId+ "," + miktar + " )";
					hazirIfade = baglanti.baglanti.prepareStatement(ekle);
					hazirIfade.executeUpdate();
					
		    	} 
		    	catch (SQLException e)
		    	{
					e.printStackTrace();
					snc = false;
		    	}
		    
		 
		
		
		return snc;
			
	}
		
	public String[][] listele() throws SQLException 
	{
		int sayac=0;
		String[][] liste = null;
		String sorgu = "SELECT malzeme_id, malzeme_adi, birim_id, toplam_depo FROM malzeme";
		ResultSet sonuc = null;
		sonuc = baglanti.sorgu_tablo(sorgu);
		sonuc.last();
		int uzunluk = sonuc.getRow();
		sonuc.beforeFirst();
		liste = new String[uzunluk][4];
		
			
		while(sonuc.next())
		{
			liste[sayac][0] = Integer.toString(sonuc.getInt(1));
			liste[sayac][1] = sonuc.getString(2);
			liste[sayac][2] = Integer.toString(sonuc.getInt(4));
			liste[sayac][3] = birim(Integer.toString(sonuc.getInt(3)));
			sayac++;
		}
		
		return liste;
	}
	
	
	public String[][] ihaleListele() throws SQLException 
	{
		int sayac=0;
		String[][] liste = null;
		String sorgu = "SELECT malzeme_ihale.ihale_id, malzeme.malzeme_adi, malzeme_ihale.miktar,malzeme.birim_id FROM malzeme_ihale"
				+ " INNER JOIN malzeme ON malzeme_ihale.malzeme_id = malzeme.malzeme_id";
		ResultSet sonuc = null;
		sonuc = baglanti.sorgu_tablo(sorgu);
		sonuc.last();
		int uzunluk = sonuc.getRow();
		sonuc.beforeFirst();
		liste = new String[uzunluk][4];
		
			
		while(sonuc.next())
		{
			liste[sayac][0] = Integer.toString(sonuc.getInt(1));
			liste[sayac][1] = sonuc.getString(2);
			liste[sayac][2] = Integer.toString(sonuc.getInt(4));
			liste[sayac][3] = birim(Integer.toString(sonuc.getInt(3)));
			sayac++;
		}
		
		return liste;
	}
//	
	public String birim(String id) throws SQLException
	{
		String dondur="";
		String sorgu = "SELECT birim_adi FROM birim WHERE birim_id = " + id;
		ResultSet sonuc = baglanti.sorgu_tablo(sorgu);
		while(sonuc.next())
		{
			dondur = sonuc.getString("birim_adi");
		}
		
		return dondur;
	}
	
	
//	public boolean malzemeGuncelle()
//	{
//		
//	}
//	
//	public boolean malzemeSil()
//	{
//		
//	}
//	
	
	

}
