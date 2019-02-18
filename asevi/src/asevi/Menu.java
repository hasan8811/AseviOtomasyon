package asevi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import asevi.bl.kullanici;

import java.awt.SystemColor;

public class Menu extends JFrame {

	public JPanel Menu;
	public JPanel A��lacakpnl;
	public JLabel lb;
	public JPanel profil;
	public JPanel �htiya�sahibiMenu;

	public Menu() {

		profil = new JPanel();
		profil.setBounds(860, 0, 150, 50);
		getContentPane().add(profil);
		profil.setLayout(null);

		Menu = new JPanel();
		Menu.setBounds(0, 0, 1024, 710);
		getContentPane().add(Menu);
		Menu.setLayout(null);

		JButton ih_sah = new JButton("�htiya� Sahibi");
		ih_sah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				�htiyacsahibi _ih = new �htiyacsahibi();
				panela�(_ih.ih_sahibisag);

			}
		});
		ih_sah.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\ihtiya\u00E7_sahibi.png"));
		ih_sah.setBounds(225, 140, 200, 175);
		Menu.add(ih_sah);

		JButton Yemek = new JButton("Yemek");
		Yemek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Yemek _yemek = new Yemek();
				panela�(_yemek.yemek_panel);
			}
		});
		Yemek.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yemek.png"));
		Yemek.setBounds(575, 140, 200, 175);
		Menu.add(Yemek);

		JButton Depo = new JButton("Depo");
		Depo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Depo _depo = new Depo();
				panela�(_depo.depo_panel);
			}
		});
		Depo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\depo.png"));
		Depo.setBounds(225, 375, 200, 175);
		Menu.add(Depo);

		JButton Da��t�m = new JButton("Da\u011F\u0131t\u0131m");
		Da��t�m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dagitim _dagitim = new Dagitim();
				panela�(_dagitim.dagitim_panel);
			}
		});
		Da��t�m.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Da\u011F\u0131t\u0131m.png"));
		Da��t�m.setBounds(575, 375, 200, 175);
		Menu.add(Da��t�m);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 150, 50);
		profil.add(menuBar);

		JMenu Ki�isel_men� = new JMenu(kullanici.username);
		Ki�isel_men�.setForeground(SystemColor.textHighlight);
		Ki�isel_men�
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\personel_icon.png"));
		menuBar.add(Ki�isel_men�);

		JMenuItem Yetki = new JMenuItem("Yetkilendirme");
		Yetki.setIcon(new ImageIcon(
				"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yetki.png"));
		Ki�isel_men�.add(Yetki);
		JMenuItem cikis = new JMenuItem("��k��");
		cikis.setIcon(new ImageIcon(
				"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\\u00E7\u0131k\u0131\u015F.png"));
		Ki�isel_men�.add(cikis);

		lb = new JLabel();
		lb.setBackground(Color.BLUE);
		lb.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Arkaplan.jpg"));
		lb.setBounds(0, 0, 1024, 710);
		Menu.add(lb);

	}

	public void panela�(JPanel jp) {

		Menu.removeAll();
		Menu.add(jp);
		
		Menu.revalidate();
		Menu.repaint();

	}

	public void ihtiya�sahibiMenu() {
		�htiya�sahibiMenu = new JPanel();
		�htiya�sahibiMenu.setBounds(25, 83, 175, 497);
		�htiya�sahibiMenu.setBackground(new Color(0, 0, 0, 0));

		�htiya�sahibiMenu.setLayout(null);
		JButton btn_ykyt = new JButton("Yeni Kay\u0131t");
		btn_ykyt.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_ykyt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_ykyt.setBounds(20, 51, 135, 45);
		�htiya�sahibiMenu.add(btn_ykyt);

		JButton btn_arama = new JButton("Arama");
		btn_arama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				

			}
		});
		btn_arama.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\arama.png"));
		btn_arama.setBounds(20, 115, 135, 45);
		�htiya�sahibiMenu.add(btn_arama);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(0, 0, 175, 497);
		�htiya�sahibiMenu.add(lblNewLabel_1);

	}
}
