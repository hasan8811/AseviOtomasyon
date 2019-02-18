package asevi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComponent;

import asevi.bl.kullanici;
import asevi.db.dagitimDAO;







import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Dagitim extends JFrame {
	public JPanel dagitim_panel;
	public JLabel arkaplanresim;
	static final String db_url = "jdbc:mysql://localhost:3306/corlu_asevi";
	public String sorgu;
	public static ArrayList  akisiler;
	public  String adi,soyadi;
	
	public static String dizi[][];
	private JTable jtable1;

	public static JTable dagitimtable;
	public ArrayList kisiler;

	public Dagitim() {
		dagitim_panel = new JPanel();
		dagitim_panel.setBounds(0, 0, 1024, 710);
		getContentPane().add(dagitim_panel);
		dagitim_panel.setLayout(null);
	//	if (kullanici.id== 1) { }
			AnasayfayaDön();
		
		d_menuu();

		Profil();

		Arkaplan();

	}
	
	//import edilen class tan nesne türetme
	dagitimDAO  d_sorgu= new dagitimDAO();
	

	public void Profil() {

		Menu _m = new Menu();
		dagitim_panel.add(_m.profil);
	}

	public void d_menuu() {
	//	if (kullanici.id == 1) { }

			JButton btn_s_ayarla = new JButton("");

			btn_s_ayarla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					s_ayar_fonk();
				}
			});

			btn_s_ayarla.setBounds(45, 141, 135, 45);
			btn_s_ayarla.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\servis_ayarlama.png"));
			dagitim_panel.add(btn_s_ayarla);
		

		// servis görüntüleme butonu oluþturma
		JButton btn_s_goruntule = new JButton("");
		// buton týklama olayý
		btn_s_goruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				s_goruntule_fonk();
			}
		});

		// servis görüntüleme butonu özellikleri
		//if (kullanici.id == 1) {}
			btn_s_goruntule.setBounds(45, 205, 135, 45);
		
		//if (kullanici.id == 3) { }
		//	btn_s_goruntule.setBounds(45, 141, 135, 45);
		

		btn_s_goruntule.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\servis_görüntüle.png"));
		
		dagitim_panel.add(btn_s_goruntule);

	}
   

	public void s_ayar_fonk() {

		dagitim_panel.removeAll();

		AnasayfayaDön();
		Profil();
		dagitim_panel.revalidate();
		dagitim_panel.repaint();
		final JComboBox Aranacak_türseçimi = new JComboBox();
		Aranacak_türseçimi.setModel(new DefaultComboBoxModel(new String[] {
				"Tümü", "Ýsim", "Mahalle", "Cadde", "Sokak" }));
		Aranacak_türseçimi.setBounds(232, 130, 97, 22);
		dagitim_panel.add(Aranacak_türseçimi);
		
		
		

		JLabel Aranacak_tür = new JLabel("Aranacak:");
		Aranacak_tür.setForeground(Color.DARK_GRAY);
		Aranacak_tür.setToolTipText("");
		Aranacak_tür.setBounds(238, 110, 80, 23);
		dagitim_panel.add(Aranacak_tür);

		JLabel suanaranan = new JLabel("\u0130sim \u0130le Arama:");
		suanaranan.setBounds(330, 110, 127, 16);
		dagitim_panel.add(suanaranan);

		 final JTextField txt_ara = new JTextField();
		txt_ara.setBounds(330, 130, 116, 22);
		dagitim_panel.add(txt_ara);
		txt_ara.setColumns(10);

		//secilme sartlari
	  
	
		
		
		JLabel lbl_sofor = new JLabel("Þoför seç:");
		lbl_sofor.setBounds(855, 165, 90, 22);
		dagitim_panel.add(lbl_sofor);

		JPanel pnl_dagýtýmseç = new JPanel();
		pnl_dagýtýmseç.setBounds(205, 165, 790, 350);
		pnl_dagýtýmseç.setOpaque(false);
		dagitim_panel.add(pnl_dagýtýmseç);
		pnl_dagýtýmseç.setLayout(null);

		/*JComboBox comboBox_0 = new JComboBox();
		comboBox_0.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_0.setBounds(650, 22, 120, 22);
		pnl_dagýtýmseç.add(comboBox_0);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox.setBounds(650, 44, 120, 22);
		pnl_dagýtýmseç.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_1.setBounds(650, 66, 120, 22);
		pnl_dagýtýmseç.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_2.setBounds(650, 88, 120, 22);
		pnl_dagýtýmseç.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_3.setBounds(650, 110, 120, 22);
		pnl_dagýtýmseç.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_4.setBounds(650, 132, 120, 22);
		pnl_dagýtýmseç.add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_5.setBounds(650, 154, 120, 22);
		pnl_dagýtýmseç.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_6.setBounds(650, 176, 120, 22);
		pnl_dagýtýmseç.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_7.setBounds(650, 198, 120, 22);
		pnl_dagýtýmseç.add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_8.setBounds(650, 220, 120, 22);
		pnl_dagýtýmseç.add(comboBox_8);

		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_9.setBounds(650, 242, 120, 22);
		pnl_dagýtýmseç.add(comboBox_9);

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {
				"Seçiniz.", "Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_10.setBounds(650, 264, 120, 22);
		pnl_dagýtýmseç.add(comboBox_10);

		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {
				"Seçiniz.", "Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_11.setBounds(650, 286, 120, 22);
		pnl_dagýtýmseç.add(comboBox_11);

		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setModel(new DefaultComboBoxModel(new String[] {
				"Seçiniz.", "Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_12.setBounds(650, 308, 120, 22);
		pnl_dagýtýmseç.add(comboBox_12);

		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setModel(new DefaultComboBoxModel(new String[] {
				"Seçiniz.", "Ali Bayýr", "Ahmet Kayýr", "Hakký Çayýr" }));
		comboBox_13.setBounds(650, 330, 120, 22);
		pnl_dagýtýmseç.add(comboBox_13);*/

		
		pnl_dagýtýmseç.setLayout(null);

		
		dagitimtable = new JTable();
		
		

		JScrollPane scrollPane = new JScrollPane(dagitimtable);
		scrollPane.setBounds(0, 0, 790, 350);
		pnl_dagýtýmseç.add(scrollPane);
		
		JButton btn_Ara = new JButton("Ara");
		btn_Ara.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mousePressed(MouseEvent arg0) {
				
				dagitimDAO.servis_ayarlama(Aranacak_türseçimi.getSelectedItem().toString(),txt_ara.getText()); 
				
				
			/*if(Aranacak_türseçimi.getSelectedItem().toString()=="Tümü"){
				try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection(db_url, "root", "");
						
						 Statement stmt = conn.createStatement();
						
						sorgu ="select adi,soyadi from basvuran";
							ResultSet rs = stmt.executeQuery(sorgu);
						
							// 	akisiler.add(rs.getInt("basvuran_id"));
						
								 int colcount = 2; //Veritabanýndaki tabloda kaç tane sütun var?
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
					}*/
				/*if(Aranacak_türseçimi.getSelectedItem().toString()=="Tümü"){
					try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(db_url, "root", "");
							
							 Statement stmt = conn.createStatement();
							
							sorgu ="select adi,soyadi from basvuran";
								ResultSet rs = stmt.executeQuery(sorgu);
							
								// 	akisiler.add(rs.getInt("basvuran_id"));
							
									 int colcount = 2; //Veritabanýndaki tabloda kaç tane sütun var?
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
				else if(Aranacak_türseçimi.getSelectedItem().toString()=="Ýsim"){
					try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(db_url, "root", "");
							
							 Statement stmt = conn.createStatement();
							
							sorgu ="select adi,soyadi from basvuran where adi='" + txt_ara.getText() + "'";
								ResultSet rs = stmt.executeQuery(sorgu);
							
								// 	akisiler.add(rs.getInt("basvuran_id"));
							
									 int colcount = 2; //Veritabanýndaki tabloda kaç tane sütun var?
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
				}*/
				
				
				
				
				}
				

		
			 
			
			
			
		});
		
		//veri cekme fonk bitisi
		
		btn_Ara.setBounds(446, 130, 97, 25);
		dagitim_panel.add(btn_Ara);

		JButton btn_pdfçýktýsý = new JButton("Kaydet");
		btn_pdfçýktýsý.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\kaydet.png"));
		btn_pdfçýktýsý.setBounds(781, 525, 144, 45);
		dagitim_panel.add(btn_pdfçýktýsý);

		d_menuu();

		Arkaplan();
		// s_goruntule_fonk();

	}

	protected void servis_ayarlama(Object selectedItem, String text) {
		// TODO Auto-generated method stub
		
	}

	protected Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public void s_goruntule_fonk() {

		dagitim_panel.removeAll();
		//if (kullanici.id == 1) { }
			AnasayfayaDön();
		
		Profil();
		dagitim_panel.revalidate();
		dagitim_panel.repaint();

		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setBounds(800, 116, 70, 32);
		dagitim_panel.add(lbl_Tarih);

		Date tarih = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		JTextField d_txt_tarih = new JTextField(df.format(tarih));
		d_txt_tarih.setBounds(844, 120, 116, 22);
		dagitim_panel.add(d_txt_tarih);
		d_txt_tarih.setColumns(10);

		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(210, 220, 800, 290);
		dagitim_panel.add(pnl_table);

		String[] columnNames = { "Sýra No", "Yemek Adedi",
				"Ýhtiyaç sahibi adi", "Mahalle", "Açýk Adres", "Telefon",
				"Ek Bilgi" };

		Object[][] data = { { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "" } };
		pnl_table.setLayout(null);

		JTable table = new JTable(data, columnNames);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" },
						{ "", "", "", "", "", "", "" } }, new String[] { "No",
						"Kiþi", "Ýhtiyaç sahibi adý", "Mahalle", "Açýk Adres",
						"Telefon", "Ek Bilgi" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMaxWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(120);

		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setMinWidth(140);
		table.getColumnModel().getColumn(3).setMaxWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(230);
		table.getColumnModel().getColumn(4).setMinWidth(230);
		table.getColumnModel().getColumn(4).setMaxWidth(230);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(6).setMaxWidth(150);

		// tablo bilgileri
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 780, 290);
		pnl_table.add(scrollPane);
		//
		JLabel lbl_sofor = new JLabel("Þoför adý:");
		lbl_sofor.setBounds(252, 176, 56, 16);
		dagitim_panel.add(lbl_sofor);

		JComboBox acListe = new JComboBox();
		acListe.setBounds(318, 173, 200, 22);
		acListe.addItem("Ali Bayýr");
		acListe.addItem("Ahmet Kayýr");
		acListe.addItem("Hakký Çayýr");

		dagitim_panel.add(acListe);

		JLabel lbl_plaka = new JLabel("Plaka No:");
		lbl_plaka.setBounds(600, 176, 100, 16);
		dagitim_panel.add(lbl_plaka);

		JComboBox acListe1 = new JComboBox();
		acListe1.setBounds(680, 173, 100, 22);
		acListe1.addItem("34 AE 158");
		acListe1.addItem("34 ERT 45");
		acListe1.addItem("34 MG 534");

		dagitim_panel.add(acListe1);

		JButton btn_ihalekaydet = new JButton("PDF AL");
		btn_ihalekaydet.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\kaydet.png"));
		btn_ihalekaydet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ihalekaydet.setBounds(843, 518, 135, 52);
		dagitim_panel.add(btn_ihalekaydet);

		d_menuu();
		Arkaplan();

	}

	public void AnasayfayaDön() {

		JButton btn_anasayfadön = new JButton("");
		btn_anasayfadön.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dagitim_panel.removeAll();
				Menu menu = new Menu();
				dagitim_panel.add(menu.Menu);
				dagitim_panel.revalidate();
				dagitim_panel.repaint();
			}
		});
		btn_anasayfadön.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Anasayfa_icon.png"));
		btn_anasayfadön.setBounds(473, 591, 70, 65);
		dagitim_panel.add(btn_anasayfadön);

		JLabel lblNewLabel_3 = new JLabel("Ana Sayfa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setBounds(455, 650, 109, 25);
		dagitim_panel.add(lblNewLabel_3);

	}

	public void Arkaplan() {
		JLabel lbl_depologo = new JLabel("");
		lbl_depologo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\icon_dagýtým.png"));
		lbl_depologo.setBounds(0, -30, 240, 275);
		dagitim_panel.add(lbl_depologo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(25, 90, 175, 500);
		dagitim_panel.add(lblNewLabel_1);

		JLabel sagarkaplan = new JLabel("");
		sagarkaplan.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplan.png"));
		sagarkaplan.setBounds(200, 90, 800, 500);
		dagitim_panel.add(sagarkaplan);
		arkaplanresim = new JLabel();
		arkaplanresim.setBounds(0, 0, 1024, 706);
		dagitim_panel.add(arkaplanresim);
		arkaplanresim.setBackground(Color.BLUE);
		arkaplanresim.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Arkaplan.jpg"));

	}
}
