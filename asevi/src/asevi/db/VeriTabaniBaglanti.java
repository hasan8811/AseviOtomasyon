package asevi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class VeriTabaniBaglanti 
{
	public String vt_surucu;
	public String vt_kulAdi;
	public String vt_sifre;
	public String vt_yol;
	public String hata_mesaji;
	public String tablo;
	public Connection baglanti;
	
	public VeriTabaniBaglanti(String veritabani, String kullanici, String sifre, String surucu)
	{
		vt_kulAdi = kullanici;
		vt_yol = veritabani;
		vt_surucu = surucu;
		baglanti = BaglantiOlustur(vt_yol,vt_kulAdi,vt_sifre,vt_surucu);
	}
	
	public Connection BaglantiOlustur(String link, String kul_adi, String kul_sifre , String surucu)
	{
		Connection baglantif = null;
		try 
		{
			Class.forName(surucu);
			baglantif = DriverManager.getConnection(link, kul_adi, kul_sifre);
			hata_mesaji = "baglanti_basarili";
		} 
		catch (Exception e) 
		{
			hata_mesaji = e.getMessage();
		}
		
		return baglantif;
	}
	
	public ResultSet sorgu_tablo(String sorgu)
	{
		ResultSet sonuc = null;
		try 
		{
			Statement ifade = baglanti.createStatement();
			sonuc = ifade.executeQuery(sorgu);
			hata_mesaji = Integer.toString(sonuc.getRow());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return sonuc;
	}
	
	
	
	
	

}
