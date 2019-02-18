package asevi.db;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.mysql.jdbc.ResultSetMetaData;

import asevi.Dagitim;
import asevi.EkranTasarim;


public class dagitimDAO {
	
	static final String db_url = "jdbc:mysql://localhost:3306/asevi?useUnicode=true&characterEncoding=UTF-8";
	public static String sorgu;
	public static ArrayList  akisiler;
	
	
	
	
	//secim1 (mahalle,sokak,isim,cad,tümü)
	//secim2 (mah adi,sok adi,isim,cad adi,tümü)
	public static void setUpSportColumn(JTable table,
            TableColumn depotable) {
//Set up the editor for the sport cells.
JComboBox comboBox = new JComboBox();
comboBox.addItem("Snowboarding");
comboBox.addItem("Rowing");
comboBox.addItem("Knitting");
comboBox.addItem("Speed reading");
comboBox.addItem("Pool");
comboBox.addItem("None of the above");
depotable.setCellEditor(new DefaultCellEditor(comboBox));

//Set up tool tips for the sport cells.
DefaultTableCellRenderer renderer =
new DefaultTableCellRenderer();
renderer.setToolTipText("Click for combo box");
depotable.setCellRenderer(renderer);
}

	 
	 public static void servis_ayarlama(String secim1, String secim2) {
		 //akisiler = new ArrayList();
		 
		 
		 if(secim1.toString() == "Tümü"){
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(db_url, "root", "");
				
				 Statement stmt = conn.createStatement();
				
				  sorgu="SELECT b.adi as Adi,b.soyadi,m.mahalle_ad as mahalle, c.cadde,s.sokak FROM adres a "
							+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
							+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
							+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
							+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
							+ "ORDER By b.adi";
					ResultSet rs = stmt.executeQuery(sorgu);
						// 	akisiler.add(rs.getInt("basvuran_id"));
					
							
							
	 						   
							 
							 int colcount = 5; //Veritabanýndaki tabloda kaç tane sütun var?
					            DefaultTableModel tm = new DefaultTableModel();
					            for(int i = 1;i<=colcount;i++) {
					                tm.addColumn(rs.getMetaData().getColumnLabel(i)); 
					                
					            }
					            
					           
							 while(rs.next())
				                {
				                    Object[] row = new Object[colcount];
				                    for(int i=1;i<=colcount;i++)
				                        row[i-1] = rs.getObject(i);
				                    tm.addRow(row);
				                }
							
				            Dagitim.dagitimtable.setModel(tm);
				            
				            
					
					
					
					
						
						
					conn.close();
				}
					catch (Exception e) {
					e.getMessage();
				}
				}
		 else if(secim1.toString() == "Ýsim" && secim2.toString() != null){
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(db_url, "root", "");
				
				 Statement stmt = conn.createStatement();
				
				  sorgu ="SELECT b.adi as Adi,b.soyadi,m.mahalle_ad as mahalle, c.cadde,s.sokak FROM adres a "
							+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
							+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
							+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
							+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id " 
							+ "where b.adi='"+secim2.toString()+"'";
					ResultSet rs = stmt.executeQuery(sorgu);
						// 	akisiler.add(rs.getInt("basvuran_id"));
					
						
							 int colcount = 5; //Veritabanýndaki tabloda kaç tane sütun var?
					            DefaultTableModel tm = new DefaultTableModel();
					            for(int i = 1;i<=colcount;i++)
					                tm.addColumn(rs.getMetaData().getColumnName(i)); 
						
							 while(rs.next())
				                {
				                    Object[] row = new Object[colcount];
				                    for(int i=1;i<=colcount;i++)
				                        row[i-1] = rs.getObject(i);
				                    tm.addRow(row);
				                }
				            Dagitim.dagitimtable.setModel(tm);
					
					
					
					
						
						
					conn.close();
				}
					catch (Exception e) {
					e.getMessage();
				}
				}
		 else if(secim1.toString() == "Mahalle" && secim2.toString() != null){
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(db_url, "root", "");
				
				 Statement stmt = conn.createStatement();
				  sorgu ="SELECT m.mahalle_ad as mahalle,b.adi as Adi,b.soyadi, c.cadde,s.sokak FROM adres a "
					+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
					+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
					+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
					+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
					+ "WHERE m.mahalle_ad='"+secim2.toString()+"' ORDER By b.adi";
					ResultSet rs = stmt.executeQuery(sorgu);
						// 	akisiler.add(rs.getInt("basvuran_id"));
					
						
							 int colcount = 5; //Veritabanýndaki tabloda kaç tane sütun var?
					            DefaultTableModel tm = new DefaultTableModel();
					             
					            for(int i = 1;i<=colcount;i++)
					                tm.addColumn(rs.getMetaData().getColumnLabel(i)); 
						
							 while(rs.next())
				                {
				                    Object[] row = new Object[colcount];
				                    
				                    for(int i=1;i<=colcount;i++){
				                        row[i-1] = rs.getObject(i);
				                        
				                		
				                    }
				                    tm.addRow(row);
				                }
				            Dagitim.dagitimtable.setModel(tm);
					
					
					
					
						
						
					conn.close();
				}
					catch (Exception e) {
					e.getMessage();
				}
				}
		 else if(secim1.toString() == "Cadde" && secim2.toString() != null){
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(db_url, "root", "");
				
				 Statement stmt = conn.createStatement();
				  sorgu ="SELECT c.cadde,b.adi as Adi,b.soyadi,m.mahalle_ad as mahalle, s.sokak FROM adres a "
					+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
					+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
					+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
					+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
					+ "WHERE c.cadde='"+secim2.toString()+"' ORDER By b.adi";
					ResultSet rs = stmt.executeQuery(sorgu);
						
					 
				
						
							 int colcount =5; //Veritabanýndaki tabloda kaç tane sütun var?
					            DefaultTableModel tm = new DefaultTableModel();
					        	
								
								
					            for(int i = 1;i<=colcount;i++){
					                tm.addColumn(rs.getMetaData().getColumnLabel(i)); }
					            
						
							 while(rs.next())
				                {
				                    Object[] row = new Object[colcount];
				                    for(int i=1;i<=colcount;i++){
				                    	//if(i==5) {
				                    		// TableColumn sportColumn = Dagitim.dagitimtable.getColumnModel().getColumn(5);
				 							//JComboBox comboBox = new JComboBox();
				 							//comboBox.addItem("Snowboarding");
				 							//comboBox.addItem("Rowing");
				 							//comboBox.addItem("Chasing toddlers");
				 							//comboBox.addItem("Speed reading");
				 							//comboBox.addItem("Teaching high school");
				 							//comboBox.addItem("None");
				 							//sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
				 							// DefaultTableCellRenderer renderer =
				 						      //          new DefaultTableCellRenderer();
				 						       // renderer.setToolTipText("Click for combo box");
				 						       // sportColumn.setCellRenderer(renderer);
				 						       // Dagitim.dagitimtable.getCellEditor(i,5);
				                    	//}
				                        row[i-1] = rs.getObject(i);}
				                    tm.addRow(row);
				                    
				                }
							 
								
				            Dagitim.dagitimtable.setModel(tm);
					
				           
					
					
						
						
					conn.close();
				}
					catch (Exception e) {
					e.getMessage();
				}
				}
		 else	 if(secim1.toString() == "Sokak" && secim2.toString() != null){
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(db_url, "root", "");
				
				 Statement stmt = conn.createStatement();
				
				  sorgu="SELECT s.sokak ,b.adi,b.soyadi,m.mahalle_ad as mahalle, c.cadde FROM adres a "
							+ "INNER JOIN basvuran b ON a.basvuran_id=b.basvuran_id "
							+ "INNER JOIN mahalle m ON a.mahalle_id = m.mahalle_id "
							+ "INNER JOIN sokak s ON a.sokak_id = s.sokak_id "
							+ "INNER JOIN cadde c ON c.cadde_id = a.cadde_id "
							+ "WHERE s.sokak='"+secim2.toString()+"' ORDER By b.adi";
					ResultSet rs = stmt.executeQuery(sorgu);
						// 	akisiler.add(rs.getInt("basvuran_id"));
					
						
							 int colcount = 5; //Veritabanýndaki tabloda kaç tane sütun var?
					            DefaultTableModel tm = new DefaultTableModel();
					            
					            for(int i = 1;i<=colcount;i++)
					                tm.addColumn(rs.getMetaData().getColumnLabel(i)); 
						
							 while(rs.next())
				                {
				                    Object[] row = new Object[colcount];
				                    for(int i=1;i<=colcount;i++)
				                        row[i-1] = rs.getObject(i);
				                    tm.addRow(row);
				                }
				            Dagitim.dagitimtable.setModel(tm);
					
					
					
					
						
						
					conn.close();
				}
					catch (Exception e) {
					e.getMessage();
				}
				}
		 
		

		
				

	}
	

}
