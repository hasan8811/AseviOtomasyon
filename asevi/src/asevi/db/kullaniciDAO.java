package asevi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;





import asevi.bl.kullanici;

public class kullaniciDAO {
	static Connection baglanti;
	static final String db_url = "jdbc:mysql://localhost:3306/asevi";
	public String sorgu;
	public String kontrol;
	public String kulad;
	public String pass;

	public kullaniciDAO(String kulad, String pass) {
		super();
		this.kulad = kulad;
		this.pass = pass;

	}

	public static Connection baglantiAc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			baglanti = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/asevi", "root", "");

		} catch (Exception e) {

			e.printStackTrace();

		}
		return baglanti;

	}

	public static void baglantiKapa() {
		try {
			baglanti.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login() {

		try {
			Connection baglanti = baglantiAc();
			sorgu = "select * from kullanici_bilgileri";
			Statement stmt = baglanti.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);

			while (rs.next()) {

				kullanici kul = new kullanici(rs.getInt("kullanici_id"),
						rs.getString("kul_adi"), rs.getString("kul_sifre"));

				if (kulad.equals(rs.getString("kul_adi"))
						&& pass.equals(rs.getString("kul_sifre"))) {
					return true;
				}

			}
			baglantiKapa();
			stmt.close();
			rs.close();
			return false;

		} catch (Exception e) {
			return false;
		}

	}

}
