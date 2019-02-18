package asevi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.List;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import asevi.bl.ihtiyacsahibibl;
import asevi.bl.kullanici;
import asevi.db.ihtiyacsahibiDAO;

import java.awt.Label;
import java.awt.Scrollbar;
import java.sql.SQLException;

public class Ýhtiyacsahibi extends JFrame {
	public JPanel pnl_sag;
	public JPanel pnl_sol;
	public JPanel ih_sahibisol;
	public JPanel ih_sahibisag;
	private JLabel label;
	private final static String[] Aramalist = { "Ýsim", "Mahalle", "Cadde",
			"Sokak" };
	public static JTable table= new JTable();
	private JTextField txt_ara;
	JPanel Aramapanel;
	private JTextField txt_baþvuranad;
	private JTextField txt_baþvuransoyad;
	private JTextField txt_baþvuruno;
	private JTextField txt_tc;
	private JTextField txt_anneadý;
	private JTextField txt_babadý;
	private JTextField txt_dogumyeri;
	private JTextField txt_dogumtarihi;
	private JTextField txt_medenidurum;
	private JTextField txt_uyruk;
	private JTextField txt_Telefon;
	private JTextField txt_mahalle;
	private JTextField txt_cadde;
	private JTextField txt_sokak;
	private JTextField txt_eðitimdurumu;
	private JTextField txt_melesgi;
	private JTextField txt_eþininmeslek;
	private JTextField txt_maaþ;
	private JTextField txt_bakýmaylýðý;
	private JTextField txt_yaþlýlýkaylýgý;
	private JTextField txt_dulmaas;
	private JTextField txt_emeklimaas;
	private JTextField txt_isinmatürü;
	private JTextField toplamgelir;

	public Ýhtiyacsahibi() {
		getContentPane().setLayout(null);

		ih_sahibisag = new JPanel();
		ih_sahibisag.setBounds(0, 0, 1018, 688);
		getContentPane().add(ih_sahibisag);
		ih_sahibisag.setOpaque(true);
		ih_sahibisag.setLayout(null);

		MenuEkleme();
		Ekle();
		Profil();
		if(kullanici.id==1){
		AnaSayfayaDön();
		}
		BasCompenentler();

		

		

	}

	public void Profil()
	{
		
			Menu _m = new Menu();
				ih_sahibisag.add(_m.profil);
	}
	public void Ekle() {
		
		ih_sahibisag.removeAll();
		MenuEkleme();

		if(kullanici.id==1){
			AnaSayfayaDön();
			}
		Profil();

		ih_sahibisag.revalidate();
		ih_sahibisag.repaint();
		txt_baþvuranad = new JTextField();
		txt_baþvuranad.setBounds(315, 108, 116, 22);
		ih_sahibisag.add(txt_baþvuranad);
		txt_baþvuranad.setColumns(10);

		JLabel lbl_baþvuranad = new JLabel("Ba\u015Fvuran ad\u0131:");
		
		lbl_baþvuranad.setOpaque(false);
		lbl_baþvuranad.setBounds(208, 108, 86, 24);
		ih_sahibisag.add(lbl_baþvuranad);

		JLabel lbl_baþvuransoyad = new JLabel("Ba\u015Fvuran soyad\u0131:");
		lbl_baþvuransoyad.setBounds(208, 132, 109, 22);
		lbl_baþvuransoyad.setOpaque(false);
		ih_sahibisag.add(lbl_baþvuransoyad);

		txt_baþvuransoyad = new JTextField();
		txt_baþvuransoyad.setBounds(315, 132, 116, 22);
		ih_sahibisag.add(txt_baþvuransoyad);
		txt_baþvuransoyad.setColumns(10);

		JLabel lbl_baþvuruno = new JLabel("Ba\u015Fvuru no:");
		lbl_baþvuruno.setBounds(451, 130, 113, 24);
		lbl_baþvuruno.setOpaque(false);
		ih_sahibisag.add(lbl_baþvuruno);

		txt_baþvuruno = new JTextField();
		txt_baþvuruno.setBounds(565, 132, 116, 22);
		ih_sahibisag.add(txt_baþvuruno);
		txt_baþvuruno.setColumns(10);

		JLabel lbl_tc = new JLabel("TC kimlik no:");
		lbl_tc.setBounds(208, 183, 109, 24);
		lbl_tc.setOpaque(false);
		ih_sahibisag.add(lbl_tc);

		txt_tc = new JTextField();
		txt_tc.setBounds(315, 183, 116, 22);
		ih_sahibisag.add(txt_tc);
		txt_tc.setColumns(10);

		JLabel lbl_anneadý = new JLabel("Anne ad\u0131:");
		lbl_anneadý.setBounds(208, 206, 70, 24);
		lbl_anneadý.setOpaque(false);
		ih_sahibisag.add(lbl_anneadý);

		txt_anneadý = new JTextField();
		txt_anneadý.setBounds(315, 206, 116, 22);
		ih_sahibisag.add(txt_anneadý);
		txt_anneadý.setColumns(10);

		txt_babadý = new JTextField();
		txt_babadý.setBounds(315, 230, 116, 22);
		ih_sahibisag.add(txt_babadý);
		txt_babadý.setColumns(10);

		JLabel lbl_babaadý = new JLabel("Baba ad\u0131:");
		lbl_babaadý.setOpaque(false);
		lbl_babaadý.setBounds(208, 230, 70, 24);
		ih_sahibisag.add(lbl_babaadý);

		txt_dogumyeri = new JTextField();
		txt_dogumyeri.setBounds(315, 254, 116, 22);
		ih_sahibisag.add(txt_dogumyeri);
		txt_dogumyeri.setColumns(10);

		JLabel lbl_dogumyeri = new JLabel("Dogum yeri:");
		lbl_dogumyeri.setBounds(208, 252, 70, 24);
		lbl_dogumyeri.setOpaque(false);
		ih_sahibisag.add(lbl_dogumyeri);

		txt_dogumtarihi = new JTextField();
		txt_dogumtarihi.setText("");
		txt_dogumtarihi.setBounds(315, 277, 116, 22);
		ih_sahibisag.add(txt_dogumtarihi);
		txt_dogumtarihi.setColumns(10);

		JLabel lbl_dogumtarihi = new JLabel("Do\u011Fum Tarihi:");
		lbl_dogumtarihi.setBounds(208, 277, 86, 24);
		lbl_dogumtarihi.setOpaque(false);
		ih_sahibisag.add(lbl_dogumtarihi);

		txt_medenidurum = new JTextField();
		txt_medenidurum.setBounds(315, 301, 116, 22);
		ih_sahibisag.add(txt_medenidurum);
		txt_medenidurum.setColumns(10);

		JLabel lbl_medenidurum = new JLabel("Medeni durumu:");
		lbl_medenidurum.setBounds(208, 301, 101, 24);
		lbl_medenidurum.setOpaque(false);
		ih_sahibisag.add(lbl_medenidurum);

		txt_uyruk = new JTextField();
		txt_uyruk.setBounds(315, 325, 116, 22);
		ih_sahibisag.add(txt_uyruk);
		txt_uyruk.setColumns(10);

		JLabel lbl_uyruk = new JLabel("Uyru\u011Fu:");
		lbl_uyruk.setBounds(208, 325, 70, 24);
		lbl_uyruk.setOpaque(false);
		ih_sahibisag.add(lbl_uyruk);

		txt_Telefon = new JTextField();
		txt_Telefon.setBounds(315, 349, 116, 22);
		ih_sahibisag.add(txt_Telefon);
		txt_Telefon.setColumns(10);

		JLabel lbl_telefon = new JLabel("Telefon numaras\u0131:");
		lbl_telefon.setBounds(208, 349, 109, 24);
		lbl_telefon.setOpaque(false);
		ih_sahibisag.add(lbl_telefon);

		txt_mahalle = new JTextField();
		txt_mahalle.setBounds(565, 183, 116, 22);
		ih_sahibisag.add(txt_mahalle);
		txt_mahalle.setColumns(10);

		JLabel lbl_mahalle = new JLabel("Mahalle:");
		lbl_mahalle.setBounds(455, 183, 70, 24);
		lbl_mahalle.setOpaque(false);
		ih_sahibisag.add(lbl_mahalle);

		txt_cadde = new JTextField();
		txt_cadde.setBounds(565, 208, 116, 22);
		ih_sahibisag.add(txt_cadde);
		txt_cadde.setColumns(10);

		JLabel lbl_cadde = new JLabel("Cadde:");
		lbl_cadde.setBounds(455, 205, 70, 24);
		lbl_cadde.setOpaque(false);
		ih_sahibisag.add(lbl_cadde);

		txt_sokak = new JTextField();
		txt_sokak.setBounds(565, 232, 116, 22);
		ih_sahibisag.add(txt_sokak);
		txt_sokak.setColumns(10);

		JLabel lbl_sokak = new JLabel("Sokak:");
		lbl_sokak.setBounds(455, 230, 70, 24);
		lbl_sokak.setOpaque(false);
		ih_sahibisag.add(lbl_sokak);

		final JTextArea txtarea_adresgerikalan = new JTextArea();
		txtarea_adresgerikalan.setLineWrap(true);
		txtarea_adresgerikalan.setTabSize(1);
		txtarea_adresgerikalan.setRows(5);
		txtarea_adresgerikalan.setBounds(565, 259, 116, 65);
		ih_sahibisag.add(txtarea_adresgerikalan);

		JLabel lbl_adresgerikalan = new JLabel("Adres geri kalan:");
		lbl_adresgerikalan.setBounds(455, 260, 109, 24);
		lbl_adresgerikalan.setOpaque(false);
		ih_sahibisag.add(lbl_adresgerikalan);

		txt_eðitimdurumu = new JTextField();
		txt_eðitimdurumu.setBounds(315, 392, 116, 22);
		ih_sahibisag.add(txt_eðitimdurumu);
		txt_eðitimdurumu.setColumns(10);

		JLabel lbl_eðitimdurumu = new JLabel("E\u011Fitim durumu:");
		lbl_eðitimdurumu.setBounds(208, 390, 101, 24);
		lbl_eðitimdurumu.setOpaque(false);
		ih_sahibisag.add(lbl_eðitimdurumu);

		final JComboBox cbx_cinsiyet = new JComboBox();
		cbx_cinsiyet.setModel(new DefaultComboBoxModel(new String[] { "Erkek",
				"Kadýn" }));
		cbx_cinsiyet.setBounds(315, 418, 116, 25);
		ih_sahibisag.add(cbx_cinsiyet);

		JLabel lbl_cinsiyet = new JLabel("Cinsiyet:");
		lbl_cinsiyet.setBounds(208, 419, 70, 24);
		lbl_cinsiyet.setOpaque(false);
		ih_sahibisag.add(lbl_cinsiyet);

		JLabel lbl_meslek = new JLabel("Mesle\u011Fi:");
		lbl_meslek.setBounds(208, 444, 70, 24);
		lbl_meslek.setOpaque(false);
		ih_sahibisag.add(lbl_meslek);

		txt_melesgi = new JTextField();
		txt_melesgi.setBounds(315, 444, 116, 22);
		ih_sahibisag.add(txt_melesgi);
		txt_melesgi.setColumns(10);

		txt_eþininmeslek = new JTextField();
		txt_eþininmeslek.setBounds(315, 467, 116, 22);
		ih_sahibisag.add(txt_eþininmeslek);
		txt_eþininmeslek.setColumns(10);

		JLabel lbl_eþininmeslegi = new JLabel("E\u015Finin Mesle\u011Fi:");
		lbl_eþininmeslegi.setBounds(208, 467, 101, 24);
		lbl_eþininmeslegi.setOpaque(false);
		ih_sahibisag.add(lbl_eþininmeslegi);
		
		toplamgelir = new JTextField();
		toplamgelir.setColumns(10);
		toplamgelir.setBounds(565, 332, 116, 22);
		ih_sahibisag.add(toplamgelir);

		txt_maaþ = new JTextField();
		txt_maaþ.setBounds(565, 357, 116, 22);
		ih_sahibisag.add(txt_maaþ);
		txt_maaþ.setColumns(10);

		txt_bakýmaylýðý = new JTextField();
		txt_bakýmaylýðý.setBounds(565, 382, 116, 22);
		ih_sahibisag.add(txt_bakýmaylýðý);
		txt_bakýmaylýðý.setColumns(10);

		txt_yaþlýlýkaylýgý = new JTextField();
		txt_yaþlýlýkaylýgý.setBounds(565, 407, 116, 22);
		ih_sahibisag.add(txt_yaþlýlýkaylýgý);
		txt_yaþlýlýkaylýgý.setColumns(10);

		txt_dulmaas = new JTextField();
		txt_dulmaas.setBounds(565, 431, 116, 22);
		ih_sahibisag.add(txt_dulmaas);
		txt_dulmaas.setColumns(10);

		txt_emeklimaas = new JTextField();
		txt_emeklimaas.setBounds(565, 455, 116, 22);
		ih_sahibisag.add(txt_emeklimaas);
		txt_emeklimaas.setColumns(10);

		JLabel lbl_aylýkgelirtop = new JLabel("Ayl\u0131k gelir toplam\u0131:");
		lbl_aylýkgelirtop.setBounds(455, 332, 109, 24);
		lbl_aylýkgelirtop.setOpaque(false);
		ih_sahibisag.add(lbl_aylýkgelirtop);

		JLabel lbl_maas = new JLabel("Maa\u015F:");
		lbl_maas.setBounds(455, 358, 70, 24);
		lbl_maas.setOpaque(false);
		ih_sahibisag.add(lbl_maas);

		JLabel lbl_bakýmaylýgý = new JLabel("Bak\u0131m ayl\u0131\u011F\u0131:");
		lbl_bakýmaylýgý.setBounds(455, 382, 88, 24);
		lbl_bakýmaylýgý.setOpaque(false);
		ih_sahibisag.add(lbl_bakýmaylýgý);

		JLabel lbl_dulmaas = new JLabel("Dul maa\u015F\u0131:");
		lbl_dulmaas.setBounds(455, 431, 70, 24);
		lbl_dulmaas.setOpaque(false);
		ih_sahibisag.add(lbl_dulmaas);

		JLabel lbl_emeklimaas = new JLabel("Emekli maa\u015F\u0131:");
		lbl_emeklimaas.setBounds(455, 455, 88, 24);
		lbl_emeklimaas.setOpaque(false);
		ih_sahibisag.add(lbl_emeklimaas);

		JLabel lbl_yaslýlýkaylýgý = new JLabel(
				"Ya\u015Fl\u0131l\u0131k ayl\u0131\u011F\u0131:");
		lbl_yaslýlýkaylýgý.setBounds(455, 407, 109, 24);
		lbl_yaslýlýkaylýgý.setOpaque(false);
		ih_sahibisag.add(lbl_yaslýlýkaylýgý);

		JLabel lbl_meskendurumu = new JLabel("Mesken durumu:");
		lbl_meskendurumu.setBounds(721, 130, 101, 24);
		lbl_meskendurumu.setOpaque(false);
		ih_sahibisag.add(lbl_meskendurumu);

		final JComboBox cmbox_meskendurumu = new JComboBox();
		cmbox_meskendurumu.setModel(new DefaultComboBoxModel(new String[] {
				"Ev sahibi", "Kira", "Diðer" }));
		cmbox_meskendurumu.setBounds(841, 132, 116, 22);
		ih_sahibisag.add(cmbox_meskendurumu);

		final JComboBox cmbox_konutturu = new JComboBox();
		cmbox_konutturu
				.setModel(new DefaultComboBoxModel(new String[] { "Daire",
						"Müstakil Ev", "Cadýr/baraka", "Gecekondu", "Diðer" }));
		cmbox_konutturu.setBounds(841, 160, 116, 22);
		ih_sahibisag.add(cmbox_konutturu);

		JLabel lbl_konutturu = new JLabel("Konut t\u00FCr\u00FC:");
		lbl_konutturu.setBounds(721, 158, 70, 24);
		lbl_konutturu.setOpaque(false);
		ih_sahibisag.add(lbl_konutturu);

		txt_isinmatürü = new JTextField();
		txt_isinmatürü.setBounds(841, 183, 116, 22);
		ih_sahibisag.add(txt_isinmatürü);
		txt_isinmatürü.setColumns(10);

		JLabel lbl_isinmaturu = new JLabel("Is\u0131nma t\u00FCr\u00FC:");
		lbl_isinmaturu.setBounds(721, 183, 86, 24);
		lbl_isinmaturu.setOpaque(false);
		ih_sahibisag.add(lbl_isinmaturu);

		JLabel lbl_hanedeyasayanlar = new JLabel("Hanede Ya\u015Fayanlar:");
		lbl_hanedeyasayanlar.setBounds(721, 208, 127, 24);
		lbl_hanedeyasayanlar.setOpaque(false);
		ih_sahibisag.add(lbl_hanedeyasayanlar);

		JLabel lbl_kendisiveeþi = new JLabel("Kendisi ve E\u015Fi:");
		lbl_kendisiveeþi.setBounds(721, 230, 101, 24);
		lbl_kendisiveeþi.setOpaque(false);
		ih_sahibisag.add(lbl_kendisiveeþi);

		final JComboBox cmbox_kendisiveesi = new JComboBox();
		cmbox_kendisiveesi.setModel(new DefaultComboBoxModel(new String[] {
				"1", "2" }));
		cmbox_kendisiveesi.setBounds(841, 230, 116, 20);
		ih_sahibisag.add(cmbox_kendisiveesi);

		final JComboBox cmbox_cocuksayisi = new JComboBox();
		cmbox_cocuksayisi.setModel(new DefaultComboBoxModel(new String[] { "0",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
		cmbox_cocuksayisi.setBounds(841, 254, 116, 20);
		ih_sahibisag.add(cmbox_cocuksayisi);

		JLabel lbl_cocuksayisi = new JLabel("\u00C7ocuk say\u0131s\u0131:");
		lbl_cocuksayisi.setBounds(721, 254, 86, 24);
		lbl_cocuksayisi.setOpaque(false);
		ih_sahibisag.add(lbl_cocuksayisi);

		final JComboBox cmbox_annebaba = new JComboBox();
		cmbox_annebaba.setModel(new DefaultComboBoxModel(new String[] { "0",
				"1", "2", "3", "4" }));
		cmbox_annebaba.setBounds(841, 277, 116, 20);
		ih_sahibisag.add(cmbox_annebaba);

		JLabel lbl_annebaba = new JLabel("Anne-Baba:");
		lbl_annebaba.setBounds(721, 277, 70, 24);
		lbl_annebaba.setOpaque(false);
		ih_sahibisag.add(lbl_annebaba);

		final JComboBox cmbox_diðer = new JComboBox();
		cmbox_diðer.setModel(new DefaultComboBoxModel(new String[] { "0", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
		cmbox_diðer.setBounds(841, 301, 116, 20);
		ih_sahibisag.add(cmbox_diðer);

		JLabel lbl_diger = new JLabel("Di\u011Fer ki\u015Filer:");
		lbl_diger.setBounds(721, 301, 86, 24);
		lbl_diger.setOpaque(false);
		ih_sahibisag.add(lbl_diger);

		final JComboBox cmbox_toplam = new JComboBox();
		cmbox_toplam.setModel(new DefaultComboBoxModel(new String[] { "0", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25" }));
		cmbox_toplam.setBounds(841, 325, 116, 20);
		ih_sahibisag.add(cmbox_toplam);

		JLabel lbl_toplam = new JLabel("Toplam:");
		lbl_toplam.setBounds(721, 325, 70, 24);
		lbl_toplam.setOpaque(false);
		ih_sahibisag.add(lbl_toplam);

		final JComboBox cmbox_borctaksit = new JComboBox();
		cmbox_borctaksit.setModel(new DefaultComboBoxModel(new String[] {
				"Yok", "Var" }));
		cmbox_borctaksit.setBounds(841, 351, 116, 20);
		ih_sahibisag.add(cmbox_borctaksit);

		JLabel lbl_borctaksit = new JLabel("Borc/Taksit");
		lbl_borctaksit.setBounds(721, 351, 70, 24);
		lbl_borctaksit.setOpaque(false);
		ih_sahibisag.add(lbl_borctaksit);

		final JComboBox cmbox_soyalgüvenlik = new JComboBox();
		cmbox_soyalgüvenlik.setModel(new DefaultComboBoxModel(new String[] {
				"Yok", "Var" }));
		cmbox_soyalgüvenlik.setBounds(841, 400, 116, 20);
		ih_sahibisag.add(cmbox_soyalgüvenlik);

		JLabel lbl_sosyalgüvenlik = new JLabel("Sosyal g\u00FCvenlik:");
		lbl_sosyalgüvenlik.setBounds(721, 400, 109, 24);
		lbl_sosyalgüvenlik.setOpaque(false);
		ih_sahibisag.add(lbl_sosyalgüvenlik);

		JLabel lbl_Ailedeçalýþan = new JLabel("Ailede \u00C7al\u0131\u015Fan :");
		lbl_Ailedeçalýþan.setBounds(206, 489, 109, 24);
		lbl_Ailedeçalýþan.setOpaque(false);
		ih_sahibisag.add(lbl_Ailedeçalýþan);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "0", "1",
				"2", "3", "4", "5" }));
		comboBox.setBounds(315, 491, 116, 20);
		ih_sahibisag.add(comboBox);

		final JTextArea txtarea_çlþnadsoyad = new JTextArea();
		txtarea_çlþnadsoyad.setLineWrap(true);
		txtarea_çlþnadsoyad.setBounds(313, 520, 118, 45);
		ih_sahibisag.add(txtarea_çlþnadsoyad);

		JLabel lbl_çlþnadsoyad = new JLabel("\u00C7al\u0131\u015Fan ad soyad:");
		lbl_çlþnadsoyad.setBounds(208, 515, 109, 24);
		lbl_çlþnadsoyad.setOpaque(false);
		ih_sahibisag.add(lbl_çlþnadsoyad);

		final JTextArea txtarea_özürdurumu = new JTextArea();
		txtarea_özürdurumu.setLineWrap(true);
		txtarea_özürdurumu.setBounds(841, 424, 116, 56);
		ih_sahibisag.add(txtarea_özürdurumu);

		JLabel lbl_özürdurumu = new JLabel("\u00F6z\u00FCr durumu:");
		lbl_özürdurumu.setBounds(721, 418, 116, 25);
		lbl_özürdurumu.setOpaque(false);
		ih_sahibisag.add(lbl_özürdurumu);

		JLabel lbl_özürdereceyknlýk = new JLabel(
				"derecesi/yak\u0131nl\u0131\u011F\u0131:");
		lbl_özürdereceyknlýk.setBounds(721, 444, 109, 24);
		lbl_özürdereceyknlýk.setOpaque(false);
		ih_sahibisag.add(lbl_özürdereceyknlýk);

		final JTextArea txtarea_kronik = new JTextArea();
		txtarea_kronik.setBounds(565, 485, 393, 40);
		ih_sahibisag.add(txtarea_kronik);

		final JTextArea txtarea_mal = new JTextArea();
		txtarea_mal.setLineWrap(true);
		txtarea_mal.setBounds(565, 529, 393, 41);
		ih_sahibisag.add(txtarea_mal);

		JLabel lbl_kronik = new JLabel("Kronik hastal\u0131klar:");
		lbl_kronik.setBounds(455, 485, 109, 24);
		lbl_kronik.setOpaque(false);
		ih_sahibisag.add(lbl_kronik);

		JLabel lbl_malmülk = new JLabel(
				"Ta\u015F\u0131n\u0131r Ta\u015F\u0131nmaz");
		lbl_malmülk.setBounds(455, 529, 109, 24);
		lbl_malmülk.setOpaque(false);
		ih_sahibisag.add(lbl_malmülk);

		JLabel lbl_malmülk2 = new JLabel("mallar:");
		
		lbl_malmülk2.setBounds(473, 546, 70, 24);
		lbl_malmülk2.setOpaque(false);
		ih_sahibisag.add(lbl_malmülk2);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 ihtiyacsahibibl.baþvuranad=txt_baþvuranad.getText();
				 ihtiyacsahibibl.baþvuransoyad=txt_baþvuransoyad.getText();
				 ihtiyacsahibibl.baþvuruno=txt_baþvuruno.getText();
				 ihtiyacsahibibl.tc=txt_tc.getText();
				 ihtiyacsahibibl.annead=txt_anneadý.getText();
				 ihtiyacsahibibl.babaad=txt_babadý.getText();
				 ihtiyacsahibibl.dogumyeri=txt_dogumyeri.getText();
				 ihtiyacsahibibl.dogumtarihi=txt_dogumtarihi.getText();
				 ihtiyacsahibibl.medenidurum=txt_medenidurum.getText();
				 ihtiyacsahibibl.uyruk=txt_uyruk.getText();
				 ihtiyacsahibibl.telno=txt_Telefon.getText();
				 ihtiyacsahibibl.mahalle=txt_mahalle.getText();
				 ihtiyacsahibibl.cadde=txt_cadde.getText();
				 ihtiyacsahibibl.sokak=txt_sokak.getText();
				 ihtiyacsahibibl.Adresgerikalan=txtarea_adresgerikalan.getText();
				 ihtiyacsahibibl.eðitim_durumu=txt_eðitimdurumu.getText();
				 ihtiyacsahibibl.meslek=txt_melesgi.getText();
				 ihtiyacsahibibl.eþmeslek=txt_eþininmeslek.getText();
				 ihtiyacsahibibl.cinsiyet=cbx_cinsiyet.getSelectedItem().toString();
				 ihtiyacsahibibl.ailedeçalýþansayýsý=comboBox.getSelectedItem().toString();
				 ihtiyacsahibibl.çalýþanlaradsoyad=txtarea_çlþnadsoyad.getText();
				 ihtiyacsahibibl.aylýkgelirtoplami=toplamgelir.getText();
				 ihtiyacsahibibl.maas=txt_maaþ.getText();
				 ihtiyacsahibibl.bakýmaylýgý=txt_bakýmaylýðý.getText();
				 ihtiyacsahibibl.yaslýlýk=txt_yaþlýlýkaylýgý.getText();
				 ihtiyacsahibibl.dulmaas=txt_dulmaas.getText();
				 ihtiyacsahibibl.emeklimaas=txt_emeklimaas.getText();
				 
				 ihtiyacsahibibl.mesken_turu=cmbox_meskendurumu.getSelectedItem().toString();
				 ihtiyacsahibibl.konut_turu=cmbox_konutturu.getSelectedItem().toString();
				 ihtiyacsahibibl.isinma_turu=txt_isinmatürü.getText();
				 
				 ihtiyacsahibibl.kendisiveeþi=cmbox_kendisiveesi.getSelectedItem().toString();
				 ihtiyacsahibibl.cocuksayisi=cmbox_cocuksayisi.getSelectedItem().toString();
				 ihtiyacsahibibl.annnebabasayisi=cmbox_annebaba.getSelectedItem().toString();
				 ihtiyacsahibibl.diðerkiþiler=cmbox_diðer.getSelectedItem().toString();
				 ihtiyacsahibibl.toplamkiþisayýsý=cmbox_toplam.getSelectedItem().toString();
				 ihtiyacsahibibl.borctaksit=cmbox_borctaksit.getSelectedItem().toString();
				 ihtiyacsahibibl.sosyalgdurum=cmbox_soyalgüvenlik.getSelectedItem().toString();
				 ihtiyacsahibibl.özürdurumu=txtarea_özürdurumu.getText();
				 ihtiyacsahibibl.kronikhastalýk=txtarea_kronik.getText();
				 ihtiyacsahibibl.malvarlýgý=txtarea_mal.getText();
				 
				 ihtiyacsahibiDAO ihdao =new ihtiyacsahibiDAO();
					try {
						ihdao.ihsahibikaydet();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {						
						String[] str1 = txt_mahalle.getText().toString().split(" "); 
						String[] str2 = txt_cadde.getText().toString().split(" "); 
						String[] str3 = txt_sokak.getText().toString().split(" "); 
						
						
						//JOptionPane.showMessageDialog(null, ihtiyacsahibiDAO.sokakdöndür(str2[0].toString()));
						ihtiyacsahibiDAO.basvuruid(txt_tc.getText());
						ihtiyacsahibiDAO.adreskaydet(str1[0].toString(), str2[0].toString(), str3[0].toString(), txtarea_adresgerikalan.getText().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btn_kaydet.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\kaydet.png"));
		btn_kaydet.setBounds(822, 595, 135, 45);
		ih_sahibisag.add(btn_kaydet);
		
		JButton btn_iptal = new JButton("\u0130ptal");
		btn_iptal.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\\u00E7\u0131k\u0131\u015F.png"));
		btn_iptal.setBounds(672, 595, 135, 45);
		ih_sahibisag.add(btn_iptal);
		
		BasCompenentler();

	}

	

	public void BasCompenentler() {
		JLabel sagarkaplan = new JLabel("");
		sagarkaplan.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplan.png"));
		sagarkaplan.setBounds(200, 90, 800, 500);
		ih_sahibisag.add(sagarkaplan);

		label = new JLabel();
		label.setBounds(0, 0, 1024, 706);
		ih_sahibisag.add(label);
		label.setBackground(Color.BLUE);
		label.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Arkaplan.jpg"));
		
		
		
		
		

	}

	public void MenuEkleme()

	{
		JLabel lbl_ihlogo = new JLabel("");
		lbl_ihlogo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\ih_sahibi_logo.png"));
		lbl_ihlogo.setBounds(25, 0, 175, 110);
		ih_sahibisag.add(lbl_ihlogo);
		
		if(kullanici.id==1){
		JButton btn_arama = new JButton("Arama");
		btn_arama.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				Arama();

			}
		});
		btn_arama.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\arama.png"));
		btn_arama.setBounds(45, 205, 135, 45);
		ih_sahibisag.add(btn_arama);
		}

		JButton btn_ykyt = new JButton("Yeni Kay\u0131t");
		btn_ykyt.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_ykyt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ekle();
			}
		});
		btn_ykyt.setBounds(45, 141, 135, 45);
		ih_sahibisag.add(btn_ykyt);
		
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(25, 90, 175, 500);
		ih_sahibisag.add(lblNewLabel_1);

	}

	public void AnaSayfayaDön() {
		JButton btn_anasayfadön = new JButton("");
		btn_anasayfadön.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ih_sahibisag.removeAll();
				Menu menu = new Menu();
				ih_sahibisag.add(menu.Menu);
				ih_sahibisag.revalidate();
				ih_sahibisag.repaint();
			}
		});
		btn_anasayfadön.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Anasayfa_icon.png"));
		btn_anasayfadön.setBounds(473, 591, 70, 65);
		ih_sahibisag.add(btn_anasayfadön);

		JLabel lblNewLabel_3 = new JLabel("Ana Sayfa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setBounds(455, 650, 109, 25);
		ih_sahibisag.add(lblNewLabel_3);
	}

	public void Arama() {

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplan.png"));
		lblNewLabel.setBounds(0, 0, 800, 500);
		ih_sahibisag.add(lblNewLabel);
		ih_sahibisag.removeAll();
		MenuEkleme();
		Profil();
		AnaSayfayaDön();

		ih_sahibisag.revalidate();
		ih_sahibisag.repaint();
		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(210, 220, 800, 290);
		ih_sahibisag.add(pnl_table);
		

		
		pnl_table.setLayout(null);

		
		
		// tablo bilgileri
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 780, 290);
		pnl_table.add(scrollPane);

		JComboBox Aranacak_tursecimi = new JComboBox();
		Aranacak_tursecimi.setModel(new DefaultComboBoxModel(new String[] {
				"Mahalle", "Cadde", "Sokak", "isim" }));
		Aranacak_tursecimi.setBounds(232, 130, 97, 22);
		ih_sahibisag.add(Aranacak_tursecimi);

		JLabel Aranacak_tür = new JLabel("Aranacak:");
		Aranacak_tür.setForeground(Color.DARK_GRAY);
		Aranacak_tür.setToolTipText("");
		Aranacak_tür.setBounds(238, 110, 80, 23);
		ih_sahibisag.add(Aranacak_tür);

		JLabel suanaranan = new JLabel("Aranacak kelime:");
		suanaranan.setBounds(330, 110, 127, 16);
		ih_sahibisag.add(suanaranan);

		txt_ara = new JTextField();
		txt_ara.setBounds(330, 130, 116, 22);
		ih_sahibisag.add(txt_ara);
		txt_ara.setColumns(10);

		JButton btn_Ara = new JButton("Ara");
		btn_Ara.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//JOptionPane.showMessageDialog(null, Aranacak_tursecimi.getSelectedItem().toString());
				
				try{ihtiyacsahibiDAO.isimarama(txt_ara.getText().toString(),Aranacak_tursecimi.getSelectedItem().toString());}
				catch (Exception e) {
					
				}
			}
		});
		btn_Ara.setBounds(446, 130, 97, 25);
		ih_sahibisag.add(btn_Ara);

		// Bu fonksiyon arkaplan nesnelerini taþýdýðý için en sonda bulunlamsý
		// gerekir.
		// Bu fonskiyonu baþlarda biryere yazmamýz bu fonskiyondan sonraki
		// gelecek
		// compenentleri bu fonskiyondaki resimlerin arkasýna atýlmasýna neden
		// olur.
		BasCompenentler();

	}
}
