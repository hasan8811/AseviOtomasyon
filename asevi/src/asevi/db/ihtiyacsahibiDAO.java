package asevi.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import asevi.Ýhtiyacsahibi;
import asevi.bl.ihtiyacsahibibl;
import asevi.bl.kullanici;

public class ihtiyacsahibiDAO {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/asevi?useUnicode=true&characterEncoding=UTF-8";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	public static String[] mahalle;
	public static String döndürülen="boþ";

	

	public static void ihsahibikaydet() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO basvuran"+ "(basvuru_tarihi,tc,adi,soyadi,anne_adi," +
				"baba_adi,dogum_yeri,dogum_tarihi,medeni_durum,uyruk,tel_no,egitim_durumu,cinsiyet," +
				"meslek,es_meslek,calisan_sayi,calisan_ad,toplam_gelir,maas,bakim_ayligi," +
				"yaslilik_ayligi,dul_maasi,emekli_maasi,kronik_hastalik,mal_varligi,mesken_turu," +
				"konut_turu,isinma_turu,kendisi_esi,cocuk_sayisi,anne_baba_sayisi,diger," +
				"toplam_kisi_sayisi,borc_turu,sosyalg_durum,degerlendirme_sonuc," +
				"engel_durumu,basvuruno)" +
		" VALUES"+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
						"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			
			preparedStatement.setTimestamp(1,getCurrentTimeStamp());
			preparedStatement.setString(2, ihtiyacsahibibl.tc);
			preparedStatement.setString(3,ihtiyacsahibibl.baþvuranad);
			preparedStatement.setString(4,ihtiyacsahibibl.baþvuransoyad);
			preparedStatement.setString(5,ihtiyacsahibibl.annead);
			preparedStatement.setString(6,ihtiyacsahibibl.babaad);
			preparedStatement.setString(7,ihtiyacsahibibl.dogumyeri);
			preparedStatement.setString(8,ihtiyacsahibibl.dogumtarihi);
			preparedStatement.setString(9,ihtiyacsahibibl.medenidurum);
			preparedStatement.setString(10,ihtiyacsahibibl.uyruk);
			preparedStatement.setString(11,ihtiyacsahibibl.telno);
			preparedStatement.setString(12,ihtiyacsahibibl.eðitim_durumu);
			preparedStatement.setString(13,ihtiyacsahibibl.cinsiyet);
			preparedStatement.setString(14,ihtiyacsahibibl.meslek);
			preparedStatement.setString(15,ihtiyacsahibibl.eþmeslek);
			preparedStatement.setString(16,ihtiyacsahibibl.ailedeçalýþansayýsý);
			preparedStatement.setString(17,ihtiyacsahibibl.çalýþanlaradsoyad);
			preparedStatement.setString(18,ihtiyacsahibibl.aylýkgelirtoplami);
			preparedStatement.setString(19,ihtiyacsahibibl.maas);
			preparedStatement.setString(20,ihtiyacsahibibl.bakýmaylýgý);
			preparedStatement.setString(21,ihtiyacsahibibl.yaslýlýk);
			preparedStatement.setString(22,ihtiyacsahibibl.dulmaas);
			preparedStatement.setString(23,ihtiyacsahibibl.emeklimaas);
			preparedStatement.setString(24,ihtiyacsahibibl.kronikhastalýk);
			preparedStatement.setString(25,ihtiyacsahibibl.malvarlýgý);
			preparedStatement.setString(26,ihtiyacsahibibl.mesken_turu);
			preparedStatement.setString(27,ihtiyacsahibibl.konut_turu);
			preparedStatement.setString(28,ihtiyacsahibibl.isinma_turu);
			preparedStatement.setString(29,ihtiyacsahibibl.kendisiveeþi);
			preparedStatement.setString(30,ihtiyacsahibibl.cocuksayisi);
			preparedStatement.setString(31,ihtiyacsahibibl.annnebabasayisi);
			preparedStatement.setString(32,ihtiyacsahibibl.diðerkiþiler);
			preparedStatement.setString(33,ihtiyacsahibibl.toplamkiþisayýsý);
			preparedStatement.setString(34,ihtiyacsahibibl.borctaksit);
			preparedStatement.setString(35,ihtiyacsahibibl.sosyalgdurum);
			preparedStatement.setInt(36,1);
			preparedStatement.setString(37,ihtiyacsahibibl.özürdurumu);
			preparedStatement.setString(38,ihtiyacsahibibl.baþvuruno);
			
			
			
			
		

			// execute insert SQL stetement
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.executeQuery();
		ihtiyacsahibibl.basvuru_id=rs.getInt("basvuran_id");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	public static String mahalledöndür(String aranacak) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sorgu = "SELECT * from mahalle";

		try {
			dbConnection = getDBConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			 int deger=0;
			while (rs.next()) {

				
				if(aranacak.equals(rs.getString("mahalle_ad"))){
					döndürülen=aranacak;
					ihtiyacsahibibl.mahalle_id=rs.getInt("mahalle_id");
				}


			}

			dbConnection.close();
			stmt.close();
			rs.close();
			
		

			
			

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
	
		return döndürülen;

	}
	public static void basvuruid(String tc) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sorgu = "SELECT basvuran_id,tc from basvuran";

		try {
			dbConnection = getDBConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			 
			while (rs.next()) {

				if(tc.equals(rs.getString("tc"))){
					ihtiyacsahibibl.basvuru_id=rs.getInt("basvuran_id");
					
				}
				

			}

			dbConnection.close();
			stmt.close();
			rs.close();
			
		

			
			

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		

	}	
	public static String caddedöndür(String aranacak) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sorgu = "SELECT * from cadde";

		try {
			dbConnection = getDBConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			 int deger=0;
			while (rs.next()) {

				
				if(aranacak.equals(rs.getString("cadde"))){
					döndürülen=aranacak;
					ihtiyacsahibibl.cadde_id=rs.getInt("cadde_id");
				}


			}

			dbConnection.close();
			stmt.close();
			rs.close();
			
		

			
			

			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
	
		return döndürülen;

	}
	public static String sokakdöndür(String aranacak) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sorgu = "SELECT * from sokak";

		try {
			dbConnection = getDBConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			 int deger=0;
			while (rs.next()) {

				
				if(aranacak.equals(rs.getString("sokak"))){
					döndürülen=aranacak;
					ihtiyacsahibibl.sokak_id=rs.getInt("sokak_id");
				}


			}

			dbConnection.close();
			stmt.close();
			rs.close();
			
		

			
			

			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
	
		return döndürülen;

	}
	public static String adresgeridöndür(String aranacak) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sorgu = "SELECT * from adres";

		try {
			dbConnection = getDBConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			
			while (rs.next()) {

				
				if(aranacak.equals(rs.getString("ayrintili_adres"))){
					döndürülen=aranacak;
				}


			}

			dbConnection.close();
			stmt.close();
			rs.close();
			
		

			
			

			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
	
		return döndürülen;

	}
	public static void adreskaydet(String mahalle,String cadde,String sokak,String gerikalan) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String insertTableSQL;
		//String insertTableSQL = "INSERT INTO basvuran(basvuran_id) SELECT basvuran_id FROM tablo_Adi2 WHERE sutun25 = ";

		try {
			dbConnection = getDBConnection();
			
			
			//preparedStatement.setTimestamp(1,getCurrentTimeStamp());
			////////////
			for(int i=0;i<4;i++){
			if(mahalle==mahalledöndür(mahalle)){
				if(cadde==caddedöndür(cadde)){
					if(sokak==sokakdöndür(sokak)){
						if(gerikalan==adresgeridöndür(gerikalan)){
							JOptionPane.showMessageDialog(null, "Bu adreste baþka bir kayýt bulunmaktadýr.");
						}else{
							
							insertTableSQL="INSERT INTO adres ( cadde_id, mahalle_id, sokak_id, ayrintili_adres, basvuran_id) VALUES (?, ?, ?, ?, ?)";
							preparedStatement = dbConnection.prepareStatement(insertTableSQL);
							preparedStatement.setInt(1, ihtiyacsahibibl.cadde_id);
							preparedStatement.setInt(2, ihtiyacsahibibl.mahalle_id);
							preparedStatement.setInt(3, ihtiyacsahibibl.sokak_id);
							preparedStatement.setString(4, gerikalan);
							preparedStatement.setInt(5, ihtiyacsahibibl.basvuru_id);
							preparedStatement.executeUpdate();
						}
					}else
					{
						insertTableSQL="INSERT INTO sokak (sokak) VALUES ('"+sokak+"')";
						Statement stmt = dbConnection.createStatement();
						stmt.executeUpdate(insertTableSQL);
					}
					
				}else
				{
					insertTableSQL="INSERT INTO cadde (cadde) VALUES ('"+cadde+"')";
					Statement stmt = dbConnection.createStatement();
					stmt.executeUpdate(insertTableSQL);
				}
				
			}
			else {
				insertTableSQL="INSERT INTO mahalle (mahalle_ad) VALUES ('"+mahalle+"')";
				Statement stmt = dbConnection.createStatement();
				stmt.executeUpdate(insertTableSQL);

			}
			}
			////////////
			// execute insert SQL stetement
			//preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	
			//select adi,soyadi from basvuran where adi='"+isim+"'"
			
	public static void isimarama(String arama,String kriter) throws SQLException {
		if(kriter=="isim"){
		try {
			Connection baglanti = getDBConnection();
			String sorgu = "SELECT b.adi,b.soyadi,m.mahalle_ad as mahalle,s.sokak,c.cadde,a.ayrintili_adres FROM adres a "
					+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
					+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
					+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
					+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
					+ "WHERE b.adi='"+arama+"'";
			Statement stmt = baglanti.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			DefaultTableModel tm = new DefaultTableModel();
			  for(int i = 1;i<=6;i++){
	                tm.addColumn(rs.getMetaData().getColumnName(i));
			  }
			while (rs.next()) {
				Object[] row = new Object[6];
                for(int i=1;i<=6;i++)
                    row[i-1] = rs.getObject(i);
                tm.addRow(row);
				

			}
			 Ýhtiyacsahibi.table.setModel(tm);
			
			stmt.close();
			rs.close();
			

		} catch (Exception e) {
			
		}}
		
		if(kriter=="Sokak"){
			try {
				Connection baglanti = getDBConnection();
				String sorgu = "SELECT s.sokak,b.adi,b.soyadi,m.mahalle_ad as mahalle,c.cadde,a.ayrintili_adres FROM adres a "
						+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
						+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
						+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
						+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
						+ "WHERE s.sokak='"+arama+"'";
				Statement stmt = baglanti.createStatement();
				ResultSet rs = stmt.executeQuery(sorgu);
				DefaultTableModel tm = new DefaultTableModel();
				  for(int i = 1;i<=6;i++){
		                tm.addColumn(rs.getMetaData().getColumnName(i));
				  }
				while (rs.next()) {
					Object[] row = new Object[6];
	                for(int i=1;i<=6;i++)
	                    row[i-1] = rs.getObject(i);
	                tm.addRow(row);
					

				}
				 Ýhtiyacsahibi.table.setModel(tm);
				
				stmt.close();
				rs.close();
				

			} catch (Exception e) {
				
			}}
		
		if(kriter=="Mahalle"){
			try {
				Connection baglanti = getDBConnection();
				String sorgu = "SELECT m.mahalle_ad as mahalle,b.adi,b.soyadi,s.sokak,c.cadde,a.ayrintili_adres FROM adres a "
						+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
						+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
						+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
						+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
						+ "WHERE m.mahalle_ad='"+arama+"'";
				Statement stmt = baglanti.createStatement();
				ResultSet rs = stmt.executeQuery(sorgu);
				DefaultTableModel tm = new DefaultTableModel();
				  for(int i = 1;i<=6;i++){
		                tm.addColumn(rs.getMetaData().getColumnName(i));
				  }
				while (rs.next()) {
					Object[] row = new Object[6];
	                for(int i=1;i<=6;i++)
	                    row[i-1] = rs.getObject(i);
	                tm.addRow(row);
					

				}
				 Ýhtiyacsahibi.table.setModel(tm);
				
				stmt.close();
				rs.close();
				

			} catch (Exception e) {
				
			}}
		
		if(kriter=="Cadde"){
			try {
				Connection baglanti = getDBConnection();
				String sorgu = "SELECT c.cadde,b.adi,b.soyadi,m.mahalle_ad as mahalle,s.sokak,a.ayrintili_adres FROM adres a "
						+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
						+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
						+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
						+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
						+ "WHERE c.cadde='"+arama+"'";
				Statement stmt = baglanti.createStatement();
				ResultSet rs = stmt.executeQuery(sorgu);
				DefaultTableModel tm = new DefaultTableModel();
				  for(int i = 1;i<=6;i++){
		                tm.addColumn(rs.getMetaData().getColumnName(i));
				  }
				while (rs.next()) {
					Object[] row = new Object[6];
	                for(int i=1;i<=6;i++)
	                    row[i-1] = rs.getObject(i);
	                tm.addRow(row);
					

				}
				 Ýhtiyacsahibi.table.setModel(tm);
				
				stmt.close();
				rs.close();
				

			} catch (Exception e) {
				
			}}

	}
	
	
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

}