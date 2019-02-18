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

public class �htiyacsahibi extends JFrame {
	public JPanel pnl_sag;
	public JPanel pnl_sol;
	public JPanel ih_sahibisol;
	public JPanel ih_sahibisag;
	private JLabel label;
	private final static String[] Aramalist = { "�sim", "Mahalle", "Cadde",
			"Sokak" };
	public static JTable table= new JTable();
	private JTextField txt_ara;
	JPanel Aramapanel;
	private JTextField txt_ba�vuranad;
	private JTextField txt_ba�vuransoyad;
	private JTextField txt_ba�vuruno;
	private JTextField txt_tc;
	private JTextField txt_annead�;
	private JTextField txt_babad�;
	private JTextField txt_dogumyeri;
	private JTextField txt_dogumtarihi;
	private JTextField txt_medenidurum;
	private JTextField txt_uyruk;
	private JTextField txt_Telefon;
	private JTextField txt_mahalle;
	private JTextField txt_cadde;
	private JTextField txt_sokak;
	private JTextField txt_e�itimdurumu;
	private JTextField txt_melesgi;
	private JTextField txt_e�ininmeslek;
	private JTextField txt_maa�;
	private JTextField txt_bak�mayl���;
	private JTextField txt_ya�l�l�kayl�g�;
	private JTextField txt_dulmaas;
	private JTextField txt_emeklimaas;
	private JTextField txt_isinmat�r�;
	private JTextField toplamgelir;

	public �htiyacsahibi() {
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
		AnaSayfayaD�n();
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
			AnaSayfayaD�n();
			}
		Profil();

		ih_sahibisag.revalidate();
		ih_sahibisag.repaint();
		txt_ba�vuranad = new JTextField();
		txt_ba�vuranad.setBounds(315, 108, 116, 22);
		ih_sahibisag.add(txt_ba�vuranad);
		txt_ba�vuranad.setColumns(10);

		JLabel lbl_ba�vuranad = new JLabel("Ba\u015Fvuran ad\u0131:");
		
		lbl_ba�vuranad.setOpaque(false);
		lbl_ba�vuranad.setBounds(208, 108, 86, 24);
		ih_sahibisag.add(lbl_ba�vuranad);

		JLabel lbl_ba�vuransoyad = new JLabel("Ba\u015Fvuran soyad\u0131:");
		lbl_ba�vuransoyad.setBounds(208, 132, 109, 22);
		lbl_ba�vuransoyad.setOpaque(false);
		ih_sahibisag.add(lbl_ba�vuransoyad);

		txt_ba�vuransoyad = new JTextField();
		txt_ba�vuransoyad.setBounds(315, 132, 116, 22);
		ih_sahibisag.add(txt_ba�vuransoyad);
		txt_ba�vuransoyad.setColumns(10);

		JLabel lbl_ba�vuruno = new JLabel("Ba\u015Fvuru no:");
		lbl_ba�vuruno.setBounds(451, 130, 113, 24);
		lbl_ba�vuruno.setOpaque(false);
		ih_sahibisag.add(lbl_ba�vuruno);

		txt_ba�vuruno = new JTextField();
		txt_ba�vuruno.setBounds(565, 132, 116, 22);
		ih_sahibisag.add(txt_ba�vuruno);
		txt_ba�vuruno.setColumns(10);

		JLabel lbl_tc = new JLabel("TC kimlik no:");
		lbl_tc.setBounds(208, 183, 109, 24);
		lbl_tc.setOpaque(false);
		ih_sahibisag.add(lbl_tc);

		txt_tc = new JTextField();
		txt_tc.setBounds(315, 183, 116, 22);
		ih_sahibisag.add(txt_tc);
		txt_tc.setColumns(10);

		JLabel lbl_annead� = new JLabel("Anne ad\u0131:");
		lbl_annead�.setBounds(208, 206, 70, 24);
		lbl_annead�.setOpaque(false);
		ih_sahibisag.add(lbl_annead�);

		txt_annead� = new JTextField();
		txt_annead�.setBounds(315, 206, 116, 22);
		ih_sahibisag.add(txt_annead�);
		txt_annead�.setColumns(10);

		txt_babad� = new JTextField();
		txt_babad�.setBounds(315, 230, 116, 22);
		ih_sahibisag.add(txt_babad�);
		txt_babad�.setColumns(10);

		JLabel lbl_babaad� = new JLabel("Baba ad\u0131:");
		lbl_babaad�.setOpaque(false);
		lbl_babaad�.setBounds(208, 230, 70, 24);
		ih_sahibisag.add(lbl_babaad�);

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

		txt_e�itimdurumu = new JTextField();
		txt_e�itimdurumu.setBounds(315, 392, 116, 22);
		ih_sahibisag.add(txt_e�itimdurumu);
		txt_e�itimdurumu.setColumns(10);

		JLabel lbl_e�itimdurumu = new JLabel("E\u011Fitim durumu:");
		lbl_e�itimdurumu.setBounds(208, 390, 101, 24);
		lbl_e�itimdurumu.setOpaque(false);
		ih_sahibisag.add(lbl_e�itimdurumu);

		final JComboBox cbx_cinsiyet = new JComboBox();
		cbx_cinsiyet.setModel(new DefaultComboBoxModel(new String[] { "Erkek",
				"Kad�n" }));
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

		txt_e�ininmeslek = new JTextField();
		txt_e�ininmeslek.setBounds(315, 467, 116, 22);
		ih_sahibisag.add(txt_e�ininmeslek);
		txt_e�ininmeslek.setColumns(10);

		JLabel lbl_e�ininmeslegi = new JLabel("E\u015Finin Mesle\u011Fi:");
		lbl_e�ininmeslegi.setBounds(208, 467, 101, 24);
		lbl_e�ininmeslegi.setOpaque(false);
		ih_sahibisag.add(lbl_e�ininmeslegi);
		
		toplamgelir = new JTextField();
		toplamgelir.setColumns(10);
		toplamgelir.setBounds(565, 332, 116, 22);
		ih_sahibisag.add(toplamgelir);

		txt_maa� = new JTextField();
		txt_maa�.setBounds(565, 357, 116, 22);
		ih_sahibisag.add(txt_maa�);
		txt_maa�.setColumns(10);

		txt_bak�mayl��� = new JTextField();
		txt_bak�mayl���.setBounds(565, 382, 116, 22);
		ih_sahibisag.add(txt_bak�mayl���);
		txt_bak�mayl���.setColumns(10);

		txt_ya�l�l�kayl�g� = new JTextField();
		txt_ya�l�l�kayl�g�.setBounds(565, 407, 116, 22);
		ih_sahibisag.add(txt_ya�l�l�kayl�g�);
		txt_ya�l�l�kayl�g�.setColumns(10);

		txt_dulmaas = new JTextField();
		txt_dulmaas.setBounds(565, 431, 116, 22);
		ih_sahibisag.add(txt_dulmaas);
		txt_dulmaas.setColumns(10);

		txt_emeklimaas = new JTextField();
		txt_emeklimaas.setBounds(565, 455, 116, 22);
		ih_sahibisag.add(txt_emeklimaas);
		txt_emeklimaas.setColumns(10);

		JLabel lbl_ayl�kgelirtop = new JLabel("Ayl\u0131k gelir toplam\u0131:");
		lbl_ayl�kgelirtop.setBounds(455, 332, 109, 24);
		lbl_ayl�kgelirtop.setOpaque(false);
		ih_sahibisag.add(lbl_ayl�kgelirtop);

		JLabel lbl_maas = new JLabel("Maa\u015F:");
		lbl_maas.setBounds(455, 358, 70, 24);
		lbl_maas.setOpaque(false);
		ih_sahibisag.add(lbl_maas);

		JLabel lbl_bak�mayl�g� = new JLabel("Bak\u0131m ayl\u0131\u011F\u0131:");
		lbl_bak�mayl�g�.setBounds(455, 382, 88, 24);
		lbl_bak�mayl�g�.setOpaque(false);
		ih_sahibisag.add(lbl_bak�mayl�g�);

		JLabel lbl_dulmaas = new JLabel("Dul maa\u015F\u0131:");
		lbl_dulmaas.setBounds(455, 431, 70, 24);
		lbl_dulmaas.setOpaque(false);
		ih_sahibisag.add(lbl_dulmaas);

		JLabel lbl_emeklimaas = new JLabel("Emekli maa\u015F\u0131:");
		lbl_emeklimaas.setBounds(455, 455, 88, 24);
		lbl_emeklimaas.setOpaque(false);
		ih_sahibisag.add(lbl_emeklimaas);

		JLabel lbl_yasl�l�kayl�g� = new JLabel(
				"Ya\u015Fl\u0131l\u0131k ayl\u0131\u011F\u0131:");
		lbl_yasl�l�kayl�g�.setBounds(455, 407, 109, 24);
		lbl_yasl�l�kayl�g�.setOpaque(false);
		ih_sahibisag.add(lbl_yasl�l�kayl�g�);

		JLabel lbl_meskendurumu = new JLabel("Mesken durumu:");
		lbl_meskendurumu.setBounds(721, 130, 101, 24);
		lbl_meskendurumu.setOpaque(false);
		ih_sahibisag.add(lbl_meskendurumu);

		final JComboBox cmbox_meskendurumu = new JComboBox();
		cmbox_meskendurumu.setModel(new DefaultComboBoxModel(new String[] {
				"Ev sahibi", "Kira", "Di�er" }));
		cmbox_meskendurumu.setBounds(841, 132, 116, 22);
		ih_sahibisag.add(cmbox_meskendurumu);

		final JComboBox cmbox_konutturu = new JComboBox();
		cmbox_konutturu
				.setModel(new DefaultComboBoxModel(new String[] { "Daire",
						"M�stakil Ev", "Cad�r/baraka", "Gecekondu", "Di�er" }));
		cmbox_konutturu.setBounds(841, 160, 116, 22);
		ih_sahibisag.add(cmbox_konutturu);

		JLabel lbl_konutturu = new JLabel("Konut t\u00FCr\u00FC:");
		lbl_konutturu.setBounds(721, 158, 70, 24);
		lbl_konutturu.setOpaque(false);
		ih_sahibisag.add(lbl_konutturu);

		txt_isinmat�r� = new JTextField();
		txt_isinmat�r�.setBounds(841, 183, 116, 22);
		ih_sahibisag.add(txt_isinmat�r�);
		txt_isinmat�r�.setColumns(10);

		JLabel lbl_isinmaturu = new JLabel("Is\u0131nma t\u00FCr\u00FC:");
		lbl_isinmaturu.setBounds(721, 183, 86, 24);
		lbl_isinmaturu.setOpaque(false);
		ih_sahibisag.add(lbl_isinmaturu);

		JLabel lbl_hanedeyasayanlar = new JLabel("Hanede Ya\u015Fayanlar:");
		lbl_hanedeyasayanlar.setBounds(721, 208, 127, 24);
		lbl_hanedeyasayanlar.setOpaque(false);
		ih_sahibisag.add(lbl_hanedeyasayanlar);

		JLabel lbl_kendisivee�i = new JLabel("Kendisi ve E\u015Fi:");
		lbl_kendisivee�i.setBounds(721, 230, 101, 24);
		lbl_kendisivee�i.setOpaque(false);
		ih_sahibisag.add(lbl_kendisivee�i);

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

		final JComboBox cmbox_di�er = new JComboBox();
		cmbox_di�er.setModel(new DefaultComboBoxModel(new String[] { "0", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
		cmbox_di�er.setBounds(841, 301, 116, 20);
		ih_sahibisag.add(cmbox_di�er);

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

		final JComboBox cmbox_soyalg�venlik = new JComboBox();
		cmbox_soyalg�venlik.setModel(new DefaultComboBoxModel(new String[] {
				"Yok", "Var" }));
		cmbox_soyalg�venlik.setBounds(841, 400, 116, 20);
		ih_sahibisag.add(cmbox_soyalg�venlik);

		JLabel lbl_sosyalg�venlik = new JLabel("Sosyal g\u00FCvenlik:");
		lbl_sosyalg�venlik.setBounds(721, 400, 109, 24);
		lbl_sosyalg�venlik.setOpaque(false);
		ih_sahibisag.add(lbl_sosyalg�venlik);

		JLabel lbl_Ailede�al��an = new JLabel("Ailede \u00C7al\u0131\u015Fan :");
		lbl_Ailede�al��an.setBounds(206, 489, 109, 24);
		lbl_Ailede�al��an.setOpaque(false);
		ih_sahibisag.add(lbl_Ailede�al��an);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "0", "1",
				"2", "3", "4", "5" }));
		comboBox.setBounds(315, 491, 116, 20);
		ih_sahibisag.add(comboBox);

		final JTextArea txtarea_�l�nadsoyad = new JTextArea();
		txtarea_�l�nadsoyad.setLineWrap(true);
		txtarea_�l�nadsoyad.setBounds(313, 520, 118, 45);
		ih_sahibisag.add(txtarea_�l�nadsoyad);

		JLabel lbl_�l�nadsoyad = new JLabel("\u00C7al\u0131\u015Fan ad soyad:");
		lbl_�l�nadsoyad.setBounds(208, 515, 109, 24);
		lbl_�l�nadsoyad.setOpaque(false);
		ih_sahibisag.add(lbl_�l�nadsoyad);

		final JTextArea txtarea_�z�rdurumu = new JTextArea();
		txtarea_�z�rdurumu.setLineWrap(true);
		txtarea_�z�rdurumu.setBounds(841, 424, 116, 56);
		ih_sahibisag.add(txtarea_�z�rdurumu);

		JLabel lbl_�z�rdurumu = new JLabel("\u00F6z\u00FCr durumu:");
		lbl_�z�rdurumu.setBounds(721, 418, 116, 25);
		lbl_�z�rdurumu.setOpaque(false);
		ih_sahibisag.add(lbl_�z�rdurumu);

		JLabel lbl_�z�rdereceyknl�k = new JLabel(
				"derecesi/yak\u0131nl\u0131\u011F\u0131:");
		lbl_�z�rdereceyknl�k.setBounds(721, 444, 109, 24);
		lbl_�z�rdereceyknl�k.setOpaque(false);
		ih_sahibisag.add(lbl_�z�rdereceyknl�k);

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

		JLabel lbl_malm�lk = new JLabel(
				"Ta\u015F\u0131n\u0131r Ta\u015F\u0131nmaz");
		lbl_malm�lk.setBounds(455, 529, 109, 24);
		lbl_malm�lk.setOpaque(false);
		ih_sahibisag.add(lbl_malm�lk);

		JLabel lbl_malm�lk2 = new JLabel("mallar:");
		
		lbl_malm�lk2.setBounds(473, 546, 70, 24);
		lbl_malm�lk2.setOpaque(false);
		ih_sahibisag.add(lbl_malm�lk2);
		
		JButton btn_kaydet = new JButton("Kaydet");
		btn_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 ihtiyacsahibibl.ba�vuranad=txt_ba�vuranad.getText();
				 ihtiyacsahibibl.ba�vuransoyad=txt_ba�vuransoyad.getText();
				 ihtiyacsahibibl.ba�vuruno=txt_ba�vuruno.getText();
				 ihtiyacsahibibl.tc=txt_tc.getText();
				 ihtiyacsahibibl.annead=txt_annead�.getText();
				 ihtiyacsahibibl.babaad=txt_babad�.getText();
				 ihtiyacsahibibl.dogumyeri=txt_dogumyeri.getText();
				 ihtiyacsahibibl.dogumtarihi=txt_dogumtarihi.getText();
				 ihtiyacsahibibl.medenidurum=txt_medenidurum.getText();
				 ihtiyacsahibibl.uyruk=txt_uyruk.getText();
				 ihtiyacsahibibl.telno=txt_Telefon.getText();
				 ihtiyacsahibibl.mahalle=txt_mahalle.getText();
				 ihtiyacsahibibl.cadde=txt_cadde.getText();
				 ihtiyacsahibibl.sokak=txt_sokak.getText();
				 ihtiyacsahibibl.Adresgerikalan=txtarea_adresgerikalan.getText();
				 ihtiyacsahibibl.e�itim_durumu=txt_e�itimdurumu.getText();
				 ihtiyacsahibibl.meslek=txt_melesgi.getText();
				 ihtiyacsahibibl.e�meslek=txt_e�ininmeslek.getText();
				 ihtiyacsahibibl.cinsiyet=cbx_cinsiyet.getSelectedItem().toString();
				 ihtiyacsahibibl.ailede�al��ansay�s�=comboBox.getSelectedItem().toString();
				 ihtiyacsahibibl.�al��anlaradsoyad=txtarea_�l�nadsoyad.getText();
				 ihtiyacsahibibl.ayl�kgelirtoplami=toplamgelir.getText();
				 ihtiyacsahibibl.maas=txt_maa�.getText();
				 ihtiyacsahibibl.bak�mayl�g�=txt_bak�mayl���.getText();
				 ihtiyacsahibibl.yasl�l�k=txt_ya�l�l�kayl�g�.getText();
				 ihtiyacsahibibl.dulmaas=txt_dulmaas.getText();
				 ihtiyacsahibibl.emeklimaas=txt_emeklimaas.getText();
				 
				 ihtiyacsahibibl.mesken_turu=cmbox_meskendurumu.getSelectedItem().toString();
				 ihtiyacsahibibl.konut_turu=cmbox_konutturu.getSelectedItem().toString();
				 ihtiyacsahibibl.isinma_turu=txt_isinmat�r�.getText();
				 
				 ihtiyacsahibibl.kendisivee�i=cmbox_kendisiveesi.getSelectedItem().toString();
				 ihtiyacsahibibl.cocuksayisi=cmbox_cocuksayisi.getSelectedItem().toString();
				 ihtiyacsahibibl.annnebabasayisi=cmbox_annebaba.getSelectedItem().toString();
				 ihtiyacsahibibl.di�erki�iler=cmbox_di�er.getSelectedItem().toString();
				 ihtiyacsahibibl.toplamki�isay�s�=cmbox_toplam.getSelectedItem().toString();
				 ihtiyacsahibibl.borctaksit=cmbox_borctaksit.getSelectedItem().toString();
				 ihtiyacsahibibl.sosyalgdurum=cmbox_soyalg�venlik.getSelectedItem().toString();
				 ihtiyacsahibibl.�z�rdurumu=txtarea_�z�rdurumu.getText();
				 ihtiyacsahibibl.kronikhastal�k=txtarea_kronik.getText();
				 ihtiyacsahibibl.malvarl�g�=txtarea_mal.getText();
				 
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
						
						
						//JOptionPane.showMessageDialog(null, ihtiyacsahibiDAO.sokakd�nd�r(str2[0].toString()));
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

	public void AnaSayfayaD�n() {
		JButton btn_anasayfad�n = new JButton("");
		btn_anasayfad�n.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ih_sahibisag.removeAll();
				Menu menu = new Menu();
				ih_sahibisag.add(menu.Menu);
				ih_sahibisag.revalidate();
				ih_sahibisag.repaint();
			}
		});
		btn_anasayfad�n.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Anasayfa_icon.png"));
		btn_anasayfad�n.setBounds(473, 591, 70, 65);
		ih_sahibisag.add(btn_anasayfad�n);

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
		AnaSayfayaD�n();

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

		JLabel Aranacak_t�r = new JLabel("Aranacak:");
		Aranacak_t�r.setForeground(Color.DARK_GRAY);
		Aranacak_t�r.setToolTipText("");
		Aranacak_t�r.setBounds(238, 110, 80, 23);
		ih_sahibisag.add(Aranacak_t�r);

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

		// Bu fonksiyon arkaplan nesnelerini ta��d��� i�in en sonda bulunlams�
		// gerekir.
		// Bu fonskiyonu ba�larda biryere yazmam�z bu fonskiyondan sonraki
		// gelecek
		// compenentleri bu fonskiyondaki resimlerin arkas�na at�lmas�na neden
		// olur.
		BasCompenentler();

	}
}
