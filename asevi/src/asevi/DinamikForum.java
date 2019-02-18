package asevi;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class DinamikForum extends JFrame implements ActionListener, ListSelectionListener{
private JPanel anaPanlemizi;
private JList listBox;
private Vector vek;
private JButton eklemeButtonu;
private JButton silButtonu;
private JTextField textAlani;
private JScrollPane dinamikPanel;
private JButton guncelButtonu;

public DinamikForum(){
//form boyutlandir ve deger ekleme
setTitle( "Dinamaik Uygulama" );
setBounds(400, 200, 400, 300);
anaPanlemizi = new JPanel();
getContentPane().add( anaPanlemizi );

vek = new Vector();

//listbox olusturuken vectoru aliyor parametre olarak
//listbox secileni dinlemeye aliyor
listBox = new JList( vek );
listBox.addListSelectionListener( this );

//listebox i dinamik panele ve dinamik panelde anapanele eklenmis
//bu anapanelde frameye eklenece islemelerden sonra
dinamikPanel = new JScrollPane();
dinamikPanel.getViewport().add( listBox );
anaPanlemizi.add( dinamikPanel, BorderLayout.CENTER );
//Panel olustur metodunu yapici icinde cagirdik
panelOlustur();
}
public void panelOlustur(){
//verileri tutan panel 
JPanel veriPaneli = new JPanel();
veriPaneli.setLayout( new BorderLayout() );
anaPanlemizi.add(veriPaneli);
//ekleme buttonu tanimlanmis ve tiklanmasini dinlemeye aliniyor
//yani button tiklaninca yapilacak islemler
eklemeButtonu = new JButton( "Ekle" );
veriPaneli.add( eklemeButtonu, BorderLayout.BEFORE_LINE_BEGINS);
eklemeButtonu.addActionListener( this );

guncelButtonu=new JButton("Guncelle");
guncelButtonu.addActionListener(this);
veriPaneli.add(guncelButtonu, BorderLayout.CENTER);

silButtonu = new JButton( "Sil" );
veriPaneli.add( silButtonu, BorderLayout.AFTER_LINE_ENDS );
silButtonu.addActionListener( this );


textAlani = new JTextField();
veriPaneli.add( textAlani, BorderLayout.BEFORE_FIRST_LINE );
}

//Listboxta secilen degeri textalanina agetiriyor
//guncelelem silem islemleri sonra gerceklestiriliyor
public void valueChanged( ListSelectionEvent olay ){
if( olay.getSource() == listBox && !olay.getValueIsAdjusting()){
String secilenDeger = (String)listBox.getSelectedValue();
if( secilenDeger != null )
textAlani.setText( secilenDeger );
}
}
//getSoruce olayin kaynagaini yani hangi button tiklandi
//ona ozgu islemler gerceklestirilir
public void actionPerformed( ActionEvent olay ){
if( olay.getSource() == eklemeButtonu ){
String textDegerEkle= textAlani.getText();
if( textDegerEkle != null ){
vek.addElement(textDegerEkle);
textAlani.setText(null);
listBox.setListData( vek );
dinamikPanel.revalidate();
dinamikPanel.repaint();
}
if(textDegerEkle.equals("")){
JOptionPane.showMessageDialog(null, "Eklenecek Deger Yok ki");
}
}
if(olay.getSource()==guncelButtonu){
String listBoxDeger=textAlani.getText();
int guncKonum=listBox.getSelectedIndex();
if(listBoxDeger!=null){
if(guncKonum>=0){
vek.removeElementAt(guncKonum);
listBox.setListData(vek);
dinamikPanel.repaint();
String girilenDeger=textAlani.getText();
vek.add(guncKonum, girilenDeger);
listBox.setListData(vek);
textAlani.setText(null);
dinamikPanel.revalidate();
dinamikPanel.repaint(); 
}else{
JOptionPane.showMessageDialog(null, "Guncellenecek Deger Yok ki");
}

}
}
if( olay.getSource() == silButtonu ){
int silinecekKonum = listBox.getSelectedIndex();
if( silinecekKonum >= 0 ){ 
vek.removeElementAt( silinecekKonum );
textAlani.setText(null);
listBox.setListData( vek );
dinamikPanel.revalidate();
dinamikPanel.repaint();
}else{
JOptionPane.showMessageDialog(null, "Silinecek Deger Yok ki");
}
}
}

public static void main( String[] args){
//Siniftan nesne olusturuyor ve setVisible() 
//gorunurlugunu aktiflestiriyor
DinamikForum formnesnesi = new DinamikForum();
formnesnesi.setVisible( true );
}
}