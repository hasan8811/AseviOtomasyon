package asevi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import asevi.bl.*;
public class Depo extends JFrame {
	public JButton btn_ihale;
	public JButton btn_bagis;
	public JPanel depo_panel;
	private JTextField txt_Serino;
	private JTextField txt_sira;
	private JTextField txt_Baðýþyapanadsoyad;
	private JTextField txt_Tcno;
	private JTextField txt_vergidairesi;
	private JTextField txt_vergino;
	private JTextField txt_telefon;
	private JTextField txt_eposta;
	private JTable table;
	private JTextField txt_tarih;
	private JTextField txt_ihaleadi;
	public JLabel arkaplanresim;
	public Depobl depovt;
	public boolean ihale;
	public Depo() {
		depo_panel = new JPanel();
		depo_panel.setBounds(0, 0, 1024, 710);
		getContentPane().add(depo_panel);
		depo_panel.setOpaque(true);
		depo_panel.setLayout(null);
		depovt = new Depobl();
		Menu();
		// Profil();
		AnasayfayaDön();
		
		


		Arkaplan();

	}
	public void DepoGoruntule() throws SQLException{
		depo_panel.removeAll();
		AnasayfayaDön();
		Profil();

		

		depo_panel.revalidate();
		depo_panel.repaint();
		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(233, 186, 726, 252);
		depo_panel.add(pnl_table);

		String[] columnNames = { "Sýra No:", "Baðýþlanan Türü", "Miktar",
				"Birim" };

		Object[][] data = { { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" },{ "", "", "", "" },
				{ "", "", "", "" },{ "", "", "", "" },{ "", "", "", "" },
				{ "", "", "", "" },
				{ "", "", "", "" },
				{ "", "", "", "" },
				{ "", "", "", "" },};
		pnl_table.setLayout(null);

		JTable depotable = new JTable(data, columnNames);
		depotable.setModel(new DefaultTableModel(depovt.listele(), new String[] { "S\u0131ra No:",
				"Depodaki ürün", "Miktar", "Birim" }));
		depotable.getColumnModel().getColumn(0).setPreferredWidth(59);
		depotable.getColumnModel().getColumn(0).setMaxWidth(59);
		depotable.getColumnModel().getColumn(1).setPreferredWidth(300);
		depotable.getColumnModel().getColumn(1).setMinWidth(400);
		depotable.getColumnModel().getColumn(1).setMaxWidth(400);
		depotable.getColumnModel().getColumn(3).setPreferredWidth(80);
		depotable.getColumnModel().getColumn(3).setMinWidth(80);
		depotable.getColumnModel().getColumn(3).setMaxWidth(80);
		
		

		JScrollPane scrollPane = new JScrollPane(depotable);
		scrollPane.setBounds(0, 0, 726, 250);
		pnl_table.add(scrollPane);
		JLabel lblDepomuzdaBulunanrnler = new JLabel("Depomuzda Bulunan \u00DCr\u00FCnler");
		lblDepomuzdaBulunanrnler.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDepomuzdaBulunanrnler.setBounds(400, 123, 436, 38);
		depo_panel.add(lblDepomuzdaBulunanrnler);
		

		Menu();
		Arkaplan();
	}
	public void urunekleihale() throws SQLException {
		depo_panel.removeAll();
		AnasayfayaDön();
		Profil();

		uruneklemesecenekleri();
		btn_ihale.setBackground(new Color(50, 205, 50));

		depo_panel.revalidate();
		depo_panel.repaint();
		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setBounds(625, 168, 70, 32);
		depo_panel.add(lbl_Tarih);

		txt_tarih = new JTextField();
		txt_tarih.setBounds(705, 173, 116, 22);
		depo_panel.add(txt_tarih);
		txt_tarih.setColumns(10);

		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(252, 230, 726, 165);
		depo_panel.add(pnl_table);

		String[] columnNames = { "Sýra No:", "Ýhale ile alýnan malýn türü", "Miktar",
				"Birim" };

		Object[][] data = { { "", "", "", "" } };
		pnl_table.setLayout(null);

		final JTable table = new JTable(data, columnNames);
		table.setModel(new DefaultTableModel(data, new String[] { "S\u0131ra No:",
				"Ýhale ile alýnan malýn türü", "Miktar", "Birim" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(0).setMaxWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(400);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 726, 250);
		pnl_table.add(scrollPane);
		JLabel lbl_Ýhaleadi = new JLabel("\u0130hale ad\u0131:");
		lbl_Ýhaleadi.setBounds(252, 176, 56, 16);
		depo_panel.add(lbl_Ýhaleadi);

		txt_ihaleadi = new JTextField();
		txt_ihaleadi.setBounds(318, 173, 295, 22);
		depo_panel.add(txt_ihaleadi);
		txt_ihaleadi.setColumns(10);

		final JButton btn_ihalekaydet = new JButton("Kaydet");
		btn_ihalekaydet
				.setIcon(new ImageIcon(
						"icon\\kaydet.png"));
		btn_ihalekaydet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ihalekaydet.setBounds(843, 518, 135, 52);
		depo_panel.add(btn_ihalekaydet);
		//ihale malzemesi ekleme
		btn_ihalekaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
					{   
					    int birim_id = 0;
					    String ihaleAdi = txt_ihaleadi.getText().toString();
					    String tarih = txt_tarih.getText().toString();
						
						int ihale_id = depovt.ihaleEkle(ihaleAdi,tarih);
						   
						
							String malzeme = table.getValueAt(0, 1).toString();
							int miktar = Integer.parseInt(table.getValueAt(0, 2).toString());
							String birim = table.getValueAt(0, 3).toString();
							if(birim == "tane") {birim_id =1;}
							else if(birim == "kilogram") {birim_id =2;}
							else if(birim == "litre") {birim_id =3;}
							depovt.ihaleMalzemeEkle(malzeme,miktar,birim_id,ihale_id);
							
							
						
						
					} 
					 catch (SQLException e) 
					 {
						e.printStackTrace();
					 }
			}
		});

		JButton btn_ihaleiptal = new JButton("\u0130ptal");
		btn_ihaleiptal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ihaleiptal
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\\u00E7\u0131k\u0131\u015F.png"));
		btn_ihaleiptal.setBounds(686, 518, 135, 52);
		depo_panel.add(btn_ihaleiptal);
		

		Menu();
		Arkaplan();

	}

	public void uruneklebagis() {

		depo_panel.removeAll();
		AnasayfayaDön();
		Profil();

		uruneklemesecenekleri();
		btn_bagis.setBackground(new Color(50, 205, 50));

		depo_panel.revalidate();
		depo_panel.repaint();
		JLabel lbl_Serino = new JLabel("Seri no:");
		lbl_Serino.setBounds(785, 164, 77, 16);
		depo_panel.add(lbl_Serino);

		txt_Serino = new JTextField();
		txt_Serino.setBounds(862, 161, 116, 22);
		depo_panel.add(txt_Serino);
		txt_Serino.setColumns(10);

		JLabel lbl_sira = new JLabel("S\u0131ra:");
		lbl_sira.setBounds(785, 193, 56, 16);
		depo_panel.add(lbl_sira);

		txt_sira = new JTextField();
		txt_sira.setBounds(862, 193, 116, 22);
		depo_panel.add(txt_sira);
		txt_sira.setColumns(10);

		JLabel lbl_Baðýþadsoyad = new JLabel("Ad\u0131 soyad\u0131:");
		lbl_Baðýþadsoyad.setBounds(242, 164, 85, 16);
		depo_panel.add(lbl_Baðýþadsoyad);

		txt_Baðýþyapanadsoyad = new JTextField();
		txt_Baðýþyapanadsoyad.setBounds(328, 161, 116, 22);
		depo_panel.add(txt_Baðýþyapanadsoyad);
		txt_Baðýþyapanadsoyad.setColumns(10);

		JLabel lbl_Tcno = new JLabel("TC no:");
		lbl_Tcno.setBounds(242, 193, 56, 16);
		depo_panel.add(lbl_Tcno);

		txt_Tcno = new JTextField();
		txt_Tcno.setBounds(328, 190, 116, 22);
		depo_panel.add(txt_Tcno);
		txt_Tcno.setColumns(10);

		JLabel lbl_Vergidairesi = new JLabel("Vergi Dairesi:");
		lbl_Vergidairesi.setBounds(242, 222, 85, 16);
		depo_panel.add(lbl_Vergidairesi);

		txt_vergidairesi = new JTextField();
		txt_vergidairesi.setBounds(328, 219, 116, 22);
		depo_panel.add(txt_vergidairesi);
		txt_vergidairesi.setColumns(10);

		JLabel lbl_VergiNo = new JLabel("Vergi no:");
		lbl_VergiNo.setBounds(242, 251, 85, 16);
		depo_panel.add(lbl_VergiNo);

		txt_vergino = new JTextField();
		txt_vergino.setBounds(328, 251, 116, 22);
		depo_panel.add(txt_vergino);
		txt_vergino.setColumns(10);

		JLabel lbl_Adres = new JLabel("Adres:");
		lbl_Adres.setBounds(455, 164, 56, 16);
		depo_panel.add(lbl_Adres);

		JTextArea txtarea_adres = new JTextArea();
		txtarea_adres.setLineWrap(true);
		txtarea_adres.setBounds(523, 164, 175, 45);
		depo_panel.add(txtarea_adres);

		JLabel lbl_telefon = new JLabel("Telefon:");
		lbl_telefon.setBounds(455, 222, 56, 16);
		depo_panel.add(lbl_telefon);

		txt_telefon = new JTextField();
		txt_telefon.setBounds(523, 219, 175, 22);
		depo_panel.add(txt_telefon);
		txt_telefon.setColumns(10);

		JLabel lbl_Eposta = new JLabel("e-posta:");
		lbl_Eposta.setBounds(455, 251, 56, 16);
		depo_panel.add(lbl_Eposta);

		txt_eposta = new JTextField();
		txt_eposta.setBounds(523, 248, 175, 22);
		depo_panel.add(txt_eposta);
		txt_eposta.setColumns(10);

		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(252, 290, 726, 165);
		depo_panel.add(pnl_table);

		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setBounds(782, 223, 70, 32);
		depo_panel.add(lbl_Tarih);

		txt_tarih = new JTextField();
		txt_tarih.setBounds(862, 228, 116, 22);
		depo_panel.add(txt_tarih);
		txt_tarih.setColumns(10);

		String[] columnNames = { "Sýra No:", "Baðýþlanan Türü", "Miktar",
				"Birim" };

		Object[][] data = { { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, };
		pnl_table.setLayout(null);

		JTable table = new JTable(data, columnNames);
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, }, new String[] { "S\u0131ra No:",
				"Ba\u011F\u0131\u015Flanan T\u00FCr\u00FC", "Miktar", "Birim" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(0).setMaxWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(400);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 726, 165);
		pnl_table.add(scrollPane);
		JButton btn_bagiskaydet = new JButton("Kaydet");
		btn_bagiskaydet
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\kaydet.png"));
		btn_bagiskaydet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_bagiskaydet.setBounds(843, 518, 135, 52);
		depo_panel.add(btn_bagiskaydet);

		JButton btn_bagisiptal = new JButton("\u0130ptal");
		btn_bagisiptal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_bagisiptal
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\\u00E7\u0131k\u0131\u015F.png"));
		btn_bagisiptal.setBounds(686, 518, 135, 52);
		depo_panel.add(btn_bagisiptal);
		
		Menu();
		Arkaplan();
	}

	public void uruneklemesecenekleri() {
		btn_bagis = new JButton("Baðýþ");

		btn_bagis.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				uruneklebagis();
			}
		});
		btn_bagis.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_bagis
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\bag\u0131s.png"));
		btn_bagis.setBounds(400, 110, 120, 38);
		depo_panel.add(btn_bagis);

		btn_ihale = new JButton("Ýhale");
		btn_ihale.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try 
				{
					urunekleihale();
					ihale = true;
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btn_ihale.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ihale
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\ihale.png"));
		btn_ihale.setBounds(730, 110, 120, 38);
		depo_panel.add(btn_ihale);
	}

	public void Menuurunekle() {

		depo_panel.removeAll();
		AnasayfayaDön();
		Profil();
		Menu();
		uruneklemesecenekleri();

		depo_panel.revalidate();
		depo_panel.repaint();

		Arkaplan();

	}

	public void AnasayfayaDön() {

		JButton btn_anasayfadön = new JButton("");
		btn_anasayfadön.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				depo_panel.removeAll();
				Menu menu = new Menu();
				depo_panel.add(menu.Menu);
				depo_panel.revalidate();
				depo_panel.repaint();
			}
		});
		btn_anasayfadön.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Anasayfa_icon.png"));
		btn_anasayfadön.setBounds(473, 591, 70, 65);
		depo_panel.add(btn_anasayfadön);

		JLabel lblNewLabel_3 = new JLabel("Ana Sayfa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setBounds(455, 650, 109, 25);
		depo_panel.add(lblNewLabel_3);

	}

	public void Menu() {
		JButton btn_urunekle = new JButton("Ürün Ekle");
		btn_urunekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menuurunekle();
			}
		});
		btn_urunekle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_urunekle.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_urunekle.setBounds(45, 206, 135, 45);
		depo_panel.add(btn_urunekle);

		JButton btn_depogörüntüle = new JButton();
		btn_depogörüntüle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DepoGoruntule();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn_depogörüntüle.setHorizontalAlignment(SwingConstants.LEADING);
		btn_depogörüntüle
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\depog\u00F6r\u00FCnt\u00FCleme.png"));
		btn_depogörüntüle.setBounds(45, 150, 135, 45);
		depo_panel.add(btn_depogörüntüle);
	}

	public void Profil() {

		Menu _m = new Menu();
		depo_panel.add(_m.profil);
	}

	public void Arkaplan() {
		JLabel lbl_depologo = new JLabel("");
		lbl_depologo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\depoicon.png"));
		lbl_depologo.setBounds(0, -30, 240, 275);
		depo_panel.add(lbl_depologo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(25, 90, 175, 500);
		depo_panel.add(lblNewLabel_1);

		JLabel sagarkaplan = new JLabel("");
		sagarkaplan.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplan.png"));
		sagarkaplan.setBounds(200, 90, 800, 500);
		depo_panel.add(sagarkaplan);
		arkaplanresim = new JLabel();
		arkaplanresim.setBounds(0, 0, 1024, 706);
		depo_panel.add(arkaplanresim);
		arkaplanresim.setBackground(Color.BLUE);
		arkaplanresim.setIcon(new ImageIcon("icon\\Arkaplan.jpg"));
		
		
		

	}
}
