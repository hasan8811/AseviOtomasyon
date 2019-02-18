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
	public JPanel Açýlacakpnl;
	public JLabel lb;
	public JPanel profil;
	public JPanel ÝhtiyaçsahibiMenu;

	public Menu() {

		profil = new JPanel();
		profil.setBounds(860, 0, 150, 50);
		getContentPane().add(profil);
		profil.setLayout(null);

		Menu = new JPanel();
		Menu.setBounds(0, 0, 1024, 710);
		getContentPane().add(Menu);
		Menu.setLayout(null);

		JButton ih_sah = new JButton("Ýhtiyaç Sahibi");
		ih_sah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Ýhtiyacsahibi _ih = new Ýhtiyacsahibi();
				panelaç(_ih.ih_sahibisag);

			}
		});
		ih_sah.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\ihtiya\u00E7_sahibi.png"));
		ih_sah.setBounds(225, 140, 200, 175);
		Menu.add(ih_sah);

		JButton Yemek = new JButton("Yemek");
		Yemek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Yemek _yemek = new Yemek();
				panelaç(_yemek.yemek_panel);
			}
		});
		Yemek.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yemek.png"));
		Yemek.setBounds(575, 140, 200, 175);
		Menu.add(Yemek);

		JButton Depo = new JButton("Depo");
		Depo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Depo _depo = new Depo();
				panelaç(_depo.depo_panel);
			}
		});
		Depo.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\depo.png"));
		Depo.setBounds(225, 375, 200, 175);
		Menu.add(Depo);

		JButton Daðýtým = new JButton("Da\u011F\u0131t\u0131m");
		Daðýtým.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dagitim _dagitim = new Dagitim();
				panelaç(_dagitim.dagitim_panel);
			}
		});
		Daðýtým.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Da\u011F\u0131t\u0131m.png"));
		Daðýtým.setBounds(575, 375, 200, 175);
		Menu.add(Daðýtým);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 150, 50);
		profil.add(menuBar);

		JMenu Kiþisel_menü = new JMenu(kullanici.username);
		Kiþisel_menü.setForeground(SystemColor.textHighlight);
		Kiþisel_menü
				.setIcon(new ImageIcon(
						"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\personel_icon.png"));
		menuBar.add(Kiþisel_menü);

		JMenuItem Yetki = new JMenuItem("Yetkilendirme");
		Yetki.setIcon(new ImageIcon(
				"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yetki.png"));
		Kiþisel_menü.add(Yetki);
		JMenuItem cikis = new JMenuItem("Çýkýþ");
		cikis.setIcon(new ImageIcon(
				"C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\\u00E7\u0131k\u0131\u015F.png"));
		Kiþisel_menü.add(cikis);

		lb = new JLabel();
		lb.setBackground(Color.BLUE);
		lb.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\Arkaplan.jpg"));
		lb.setBounds(0, 0, 1024, 710);
		Menu.add(lb);

	}

	public void panelaç(JPanel jp) {

		Menu.removeAll();
		Menu.add(jp);
		
		Menu.revalidate();
		Menu.repaint();

	}

	public void ihtiyaçsahibiMenu() {
		ÝhtiyaçsahibiMenu = new JPanel();
		ÝhtiyaçsahibiMenu.setBounds(25, 83, 175, 497);
		ÝhtiyaçsahibiMenu.setBackground(new Color(0, 0, 0, 0));

		ÝhtiyaçsahibiMenu.setLayout(null);
		JButton btn_ykyt = new JButton("Yeni Kay\u0131t");
		btn_ykyt.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\yenikayit.png"));
		btn_ykyt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_ykyt.setBounds(20, 51, 135, 45);
		ÝhtiyaçsahibiMenu.add(btn_ykyt);

		JButton btn_arama = new JButton("Arama");
		btn_arama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				

			}
		});
		btn_arama.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\arama.png"));
		btn_arama.setBounds(20, 115, 135, 45);
		ÝhtiyaçsahibiMenu.add(btn_arama);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\panelarkaplanmen\u00FC.png"));
		lblNewLabel_1.setBounds(0, 0, 175, 497);
		ÝhtiyaçsahibiMenu.add(lblNewLabel_1);

	}
}
