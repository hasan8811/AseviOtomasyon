package asevi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class MultipleSelectionList extends JFrame
{
    private JList multiple;
    private JList single;
    private JButton copyButton;
    //liste üzerinde iþlem yapmayý kolaylaþtýrýr.Eleman ekleme ,silme vb...
    private DefaultListModel listModel;
 
    private final static String[] values={ "C", "C++", "C#.NET", "Java","Pyhton", "Delphi", "VB.NET",
                                            "PHP", "Javascript","HTML", "AJAX", "MySQL" };
 
    public MultipleSelectionList()
    {
        super("Multiple Selection List");
        setLayout( new FlowLayout() );
         
        multiple = new JList( values );
        add( new JScrollPane( multiple ) );
 
        copyButton = new JButton("Copy>>>");
        add( copyButton );
 
        listModel = new DefaultListModel();
 
        single = new JList( listModel );
        single.setFixedCellHeight(18);
        single.setFixedCellWidth(80);
        add( new JScrollPane(single) );
 
 
        Handler handler = new Handler();
        copyButton.addActionListener( handler );
 
    }
 
    private class Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int size = multiple.getSelectedValues().length;
 
            for( int i=0;i<size;i++ )
                listModel.addElement( multiple.getSelectedValues()[i] );
 
        }
    }


	 
    public static void main(String[] args)
    {
        MultipleSelectionList form = new MultipleSelectionList();
        form.setVisible( true );
        form.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        form.setSize( 300, 200 );
 
    }
 

}