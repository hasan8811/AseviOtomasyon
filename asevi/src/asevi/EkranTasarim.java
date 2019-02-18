package asevi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import asevi.bl.kullanici;
import asevi.db.kullaniciDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class EkranTasarim extends JFrame {
	private JPanel panel;
	
	private JTextField username;
	
	private JPasswordField password;
	
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EkranTasarim frame = new EkranTasarim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EkranTasarim() {
		super("Çorlu Belediyesi Aþevi Otomasyonu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 0, 1024, 710);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1024, 710);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		username.setToolTipText("");
		username.setForeground(new Color(0, 0, 0));
		username.setBackground(new Color(255, 255, 240));
		username.setBounds(428, 310, 158, 31);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(428, 350, 158, 31);
		panel.add(password);
		
		/*Menu = new JPanel();
		Menu.setBounds(100, 200, 782, 553);
		
		Menu.setLayout(null);
		
		JButton btnlogin = new JButton("Kiþi");
		btnlogin.setBounds(348, 276, 97, 25);
		Menu.add(btnlogin);*/
		
		JButton login = new JButton("Giri\u015F");
		login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		login.setForeground(Color.BLACK);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] p=password.getPassword();
				String pass=String.valueOf(p);
				kullaniciDAO dao =new kullaniciDAO(username.getText(),pass);
				if(dao.login()){
					panel.removeAll();
					if(kullanici.id==1){
						
					Menu _s = new Menu();
					panel.add(_s.profil);
					panel.add(_s.Menu);
					panel.revalidate();
					panel.repaint();
					}
					if(kullanici.id==2){
						Ýhtiyacsahibi _ih = new Ýhtiyacsahibi();
						
						panel.add(_ih.ih_sahibisag);
						panel.revalidate();
						panel.repaint();
						}
					if(kullanici.id==3){
						Dagitim _dag = new Dagitim();
						
						panel.add(_dag.dagitim_panel);
						panel.revalidate();
						panel.repaint();
						}
					
				}
				else {JOptionPane.showMessageDialog(null, "Kullanýcý adýnýz veya þifreniz yanlýþ");}
			}
		});
		login.setBounds(470, 394, 77, 31);
		panel.add(login);
		
		label = new JLabel("New label");
		label.setBackground(Color.BLUE);
		label.setIcon(new ImageIcon("C:\\Users\\B\u00FC\u015Fra SERVAN\\Desktop\\Yeni klas\u00F6r\\asevi\\icon\\loginpanel.jpg"));
		label.setBounds(0, 0, 1024, 710);
		panel.add(label);
		
		
		
		
	}
	
}
