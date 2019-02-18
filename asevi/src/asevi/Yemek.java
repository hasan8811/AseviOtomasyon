package asevi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

public class Yemek extends JFrame {

	public JPanel yemek_panel;
	public JLabel Arkaplanresmi;
	private JTextField txt_no;
	private JTextField txt_depo;
	private JTextField txt_tarih;
	private JTextField txt_toplamverilecekyemek;
	private JTextField txt_depodaolmayan;

	public Yemek() {
		yemek_panel = new JPanel();
		yemek_panel.setBounds(0, 0, 1024, 710);
		getContentPane().add(yemek_panel);
		yemek_panel.setLayout(null);
		Menu();
		AnaSayfayaDön();

		 //Profil();

		
		Arkaplanresimleri();

	}
	
	public void aylikmenu(){
		yemek_panel.removeAll();
		
		Menu();
		AnaSayfayaDön();
		//Profil();
		
		yemek_panel.revalidate();
		yemek_panel.repaint();
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(446, 112, 200, 30);
		yemek_panel.add(dateChooser);
		JLabel lbl_tarihseç = new JLabel("G\u00F6r\u00FCnt\u00FClenen Tarih:");
		lbl_tarihseç.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tarihseç.setBounds(252, 115, 182, 27);
		yemek_panel.add(lbl_tarihseç);

		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(236, 167, 200, 173);
		yemek_panel.add(pnl_table);

		String[] columnNames = { "Menüdeki Yemekler" };

		Object[][] data = { { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, };
		pnl_table.setLayout(null);

		JTable depotable = new JTable(data, columnNames);
		depotable.setModel(new DefaultTableModel(new Object[][] { { "" },
				{ "" }, { "" }, { "" }, { "" }, { "" }, },
				new String[] { "Menüdeki Yemekler" }));
		depotable.setRowHeight(25);
		depotable.getColumnModel().getColumn(0).setPreferredWidth(70);
		depotable.getColumnModel().getColumn(0).setMinWidth(200);
		depotable.getColumnModel().getColumn(0).setMaxWidth(200);

		JScrollPane scrollPane = new JScrollPane(depotable);
		scrollPane.setBounds(0, 0, 200, 173);
		pnl_table.add(scrollPane);
		
		

		JPanel pnl_tablemalzeme = new JPanel();
		pnl_tablemalzeme.setOpaque(false);
		pnl_tablemalzeme.setBounds(460, 270, 500, 400);
		yemek_panel.add(pnl_tablemalzeme);

		String[] columnNamesmalzeme = { "Depo", "Malzeme","Birim","Kiþi baþý"};

		Object[][] datamalzeme = { { "","","","" }, { "","","",""  }, { "","","",""  }, { "","","",""  }, { "","","","" }, { "","","",""  },
				{ "","","",""  },{ "","","",""  },{ "","","",""  },{ "","","",""  },{ "","","",""  },{ "","","",""  }};
		pnl_tablemalzeme.setLayout(null);

		JTable depotablemalzeme = new JTable(datamalzeme, columnNamesmalzeme);
		depotablemalzeme.setModel(new DefaultTableModel(new Object[][] { { "","","","" },
				{ "","","","" }, { "","","","" }, { "","","","" }, {"","","","" }, { "","","","" },
				{ "","","",""  },{ "","","",""  },{ "","","",""  },{ "","","",""  },{ "","","",""  },
				{ "","","",""  },},
				new String[] { "Depo", "Malzeme","Birim","Kiþi baþý"}));
		depotablemalzeme.setRowHeight(25);
		depotablemalzeme.getColumnModel().getColumn(0).setPreferredWidth(70);
		depotablemalzeme.getColumnModel().getColumn(0).setMinWidth(60);
		depotablemalzeme.getColumnModel().getColumn(0).setMaxWidth(60);
		depotablemalzeme.getColumnModel().getColumn(1).setPreferredWidth(70);
		depotablemalzeme.getColumnModel().getColumn(1).setMinWidth(200);
		depotablemalzeme.getColumnModel().getColumn(1).setMaxWidth(200);
		depotablemalzeme.getColumnModel().getColumn(2).setPreferredWidth(70);
		depotablemalzeme.getColumnModel().getColumn(2).setMinWidth(90);
		depotablemalzeme.getColumnModel().getColumn(2).setMaxWidth(90);
		depotablemalzeme.getColumnModel().getColumn(3).setPreferredWidth(70);
		depotablemalzeme.getColumnModel().getColumn(3).setMinWidth(150);
		depotablemalzeme.getColumnModel().getColumn(3).setMaxWidth(150);

		JScrollPane scrollPanemalzeme = new JScrollPane(depotablemalzeme);
		scrollPanemalzeme.setBounds(0, 0, 500, 250);
		pnl_tablemalzeme.add(scrollPanemalzeme);
		
		JButton btn_ihalekaydet = new JButton("Kaydet");
		btn_ihalekaydet
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\kaydet.png"));
		btn_ihalekaydet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ihalekaydet.setBounds(800, 525, 135, 52);
		yemek_panel.add(btn_ihalekaydet);
		
		JComboBox cmbox_malzemeseç = new JComboBox();
		cmbox_malzemeseç.setModel(new DefaultComboBoxModel(new String[] {"Birini seçiniz",
				"Kuru Fasulye","Nohut"}));
		cmbox_malzemeseç.setBounds(641, 178, 200, 25);
		yemek_panel.add(cmbox_malzemeseç);
		
		JLabel lbl_malzemeseç = new JLabel("Depodan malzeme se\u00E7:");
		lbl_malzemeseç.setBounds(473, 182, 135, 16);
		yemek_panel.add(lbl_malzemeseç);
		
		JLabel lbl_Depodaolmayan = new JLabel("Depoda olmayan malzeme:");
		lbl_Depodaolmayan.setBounds(473, 234, 175, 16);
		yemek_panel.add(lbl_Depodaolmayan);
		
		txt_depodaolmayan = new JTextField();
		txt_depodaolmayan.setBounds(641, 231, 200, 22);
		yemek_panel.add(txt_depodaolmayan);
		txt_depodaolmayan.setColumns(10);
		
		JButton btn_ekle = new JButton("Ekle");
		btn_ekle.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_ekle.setBounds(853, 221, 127, 42);
		yemek_panel.add(btn_ekle);
		
		JButton btn_ekle0 = new JButton("Ekle");
		btn_ekle0.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_ekle0.setBounds(853, 167, 127, 42);
		yemek_panel.add(btn_ekle0);
		Arkaplanresimleri();
		
	}

	public void Gunlukuretim() {

		yemek_panel.removeAll();
		yemek_panel.revalidate();
		yemek_panel.repaint();

		Menu();
		//Profil();

		JPanel pnl_table = new JPanel();
		pnl_table.setOpaque(false);
		pnl_table.setBounds(354, 186, 596, 330);
		yemek_panel.add(pnl_table);

		JLabel lbl_no = new JLabel("No:");
		lbl_no.setBounds(263, 126, 56, 16);
		yemek_panel.add(lbl_no);

		txt_no = new JTextField();
		txt_no.setBounds(354, 123, 116, 22);
		yemek_panel.add(txt_no);
		txt_no.setColumns(10);

		JLabel lbl_depo = new JLabel("Depo:");
		lbl_depo.setBounds(263, 156, 56, 16);
		yemek_panel.add(lbl_depo);

		txt_depo = new JTextField();
		txt_depo.setBounds(354, 153, 116, 22);
		yemek_panel.add(txt_depo);
		txt_depo.setColumns(10);

		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setBounds(767, 126, 56, 16);
		yemek_panel.add(lbl_Tarih);

		txt_tarih = new JTextField();
		txt_tarih.setBounds(847, 123, 116, 22);
		yemek_panel.add(txt_tarih);
		txt_tarih.setColumns(10);

		JLabel lbl_toplamverilecekyemek = new JLabel(
				"Toplam Ki\u015Fi Say\u0131s\u0131:");
		lbl_toplamverilecekyemek.setBounds(486, 156, 116, 16);
		yemek_panel.add(lbl_toplamverilecekyemek);

		txt_toplamverilecekyemek = new JTextField();
		txt_toplamverilecekyemek.setBounds(603, 151, 116, 22);
		yemek_panel.add(txt_toplamverilecekyemek);
		txt_toplamverilecekyemek.setColumns(10);

		String[] columnNames = { "Sýra No:", "Baðýþlanan Türü", "Miktar",
				"Birim" };

		Object[][] data = { { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, };
		pnl_table.setLayout(null);

		JTable depotable = new JTable(data, columnNames);
		depotable.setModel(new DefaultTableModel(new Object[][] {
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, },
				new String[] { "Birim", "Ki\u015Fi ba\u015F\u0131na miktar",
						"A\u00E7\u0131klama", "Toplam Miktar" }));
		depotable.setRowHeight(22);
		depotable.getColumnModel().getColumn(0).setPreferredWidth(70);
		depotable.getColumnModel().getColumn(0).setMinWidth(70);
		depotable.getColumnModel().getColumn(0).setMaxWidth(70);
		depotable.getColumnModel().getColumn(1).setPreferredWidth(100);
		depotable.getColumnModel().getColumn(1).setMinWidth(130);
		depotable.getColumnModel().getColumn(1).setMaxWidth(130);
		depotable.getColumnModel().getColumn(2).setPreferredWidth(285);
		depotable.getColumnModel().getColumn(2).setMinWidth(255);
		depotable.getColumnModel().getColumn(2).setMaxWidth(255);
		depotable.getColumnModel().getColumn(3).setPreferredWidth(140);
		depotable.getColumnModel().getColumn(3).setMinWidth(140);
		depotable.getColumnModel().getColumn(3).setMaxWidth(140);

		JScrollPane scrollPane = new JScrollPane(depotable);
		scrollPane.setBounds(0, 0, 726, 330);
		pnl_table.add(scrollPane);
		JLabel lbl_Malzeme = new JLabel("Malzeme adý:");
		lbl_Malzeme.setBounds(234, 183, 120, 22);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox.setBounds(234, 205, 120, 22);
		yemek_panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_1.setBounds(234, 227, 120, 22);
		yemek_panel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_2.setBounds(234, 249, 120, 22);
		yemek_panel.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç" }));
		comboBox_3.setBounds(234, 271, 120, 22);
		yemek_panel.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç" }));
		comboBox_4.setBounds(234, 293, 120, 22);
		yemek_panel.add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_5.setBounds(234, 315, 120, 22);
		yemek_panel.add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_6.setBounds(234, 337, 120, 22);
		yemek_panel.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_7.setBounds(234, 359, 120, 22);
		yemek_panel.add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç" }));
		comboBox_8.setBounds(234, 381, 120, 22);
		yemek_panel.add(comboBox_8);

		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] { "Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_9.setBounds(234, 403, 120, 22);
		yemek_panel.add(comboBox_9);

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç" }));
		comboBox_10.setBounds(234, 425, 120, 22);
		yemek_panel.add(comboBox_10);

		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_11.setBounds(234, 447, 120, 22);
		yemek_panel.add(comboBox_11);

		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç"}));
		comboBox_12.setBounds(234, 469, 120, 22);
		yemek_panel.add(comboBox_12);

		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz.",
				"Kuru Fasulye", "Bulgur", "Soðan" ,"Patates" ,"Patlýcan","Süt","Pirinç" }));
		comboBox_13.setBounds(234, 491, 120, 22);
		yemek_panel.add(comboBox_13);
		JButton btn_pdfçýktýsý = new JButton(
				"PDF \u00E7\u0131kt\u0131s\u0131 al");
		btn_pdfçýktýsý
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\pdf_icon.png"));
		btn_pdfçýktýsý.setBounds(781, 525, 144, 45);
		yemek_panel.add(btn_pdfçýktýsý);
		// Profil();
		AnaSayfayaDön();
		Arkaplanresimleri();
	}

	public void AnaSayfayaDön() {
		JButton btn_anasayfadön = new JButton("");
		btn_anasayfadön.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				yemek_panel.removeAll();
				Menu menu = new Menu();
				yemek_panel.add(menu.Menu);
				yemek_panel.revalidate();
				yemek_panel.repaint();
			}
		});
		btn_anasayfadön.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Anasayfa_icon.png"));
		btn_anasayfadön.setBounds(473, 591, 70, 65);
		yemek_panel.add(btn_anasayfadön);

		JLabel lblNewLabel_3 = new JLabel("Ana Sayfa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setBounds(455, 650, 109, 25);
		yemek_panel.add(lblNewLabel_3);
	}

	//public void Profil() {

	//	Menu _m = new Menu();
	//	yemek_panel.add(_m.profil);
	//}

	public void Menu() {

		yemek_panel.removeAll();
		yemek_panel.revalidate();
		yemek_panel.repaint();

		JButton btn_günlüküretim = new JButton("");
		btn_günlüküretim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gunlukuretim();
			}
		});
		btn_günlüküretim
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\g\u00FCnl\u00FCk_\u00FCretim.png"));
		btn_günlüküretim.setBounds(45, 141, 135, 45);
		yemek_panel.add(btn_günlüküretim);

		JButton btn_AylýkMenu = new JButton("");
		btn_AylýkMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aylikmenu();
			}
		});
		btn_AylýkMenu
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Ayl\u0131k_menu.png"));
		btn_AylýkMenu.setBounds(45, 205, 135, 45);
		yemek_panel.add(btn_AylýkMenu);

	}

	public void Arkaplanresimleri() {
		JLabel lbl_depologo = new JLabel("");
		lbl_depologo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yemek_icon.png"));
		lbl_depologo.setBounds(0, -40, 240, 275);
		yemek_panel.add(lbl_depologo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(25, 90, 175, 500);
		yemek_panel.add(lblNewLabel_1);

		JLabel sagarkaplan = new JLabel("");
		sagarkaplan.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplan.png"));
		sagarkaplan.setBounds(200, 90, 800, 500);
		yemek_panel.add(sagarkaplan);
		Arkaplanresmi = new JLabel();
		Arkaplanresmi.setBounds(0, 0, 1024, 706);
		yemek_panel.add(Arkaplanresmi);
		Arkaplanresmi.setBackground(Color.BLUE);
		Arkaplanresmi.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Arkaplan.jpg"));
		
		

	}
}
