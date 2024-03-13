import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FilmGui extends JFrame
{

	private static final long serialVersionUID = 1L;
	protected JButton btnAsc;
	protected JButton btnDesc;
	protected JButton btnZurueck;
	protected JTextField searchbar;
	protected JComboBox<Sorter> searchtype;
	protected JList<Filme> movielist;
	protected JLabel image;

	public FilmGui()
	{
		initialize();
	}
	
	private void initialize()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 681, 298);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnAsc());
		frame.getContentPane().add(getBtnDesc());
		frame.getContentPane().add(getBtnZurueck());
		frame.getContentPane().add(getSearchbar());
		frame.getContentPane().add(getSearchtype());
		frame.getContentPane().add(getMovielist());
		frame.getContentPane().add(getImage());
        frame.setVisible(true);
	}

	private JButton getBtnAsc()
	{
		if (btnAsc == null)
		{
			btnAsc = new JButton("Aufsteigend");
			btnAsc.setBounds(353, 98, 120, 25);
		}
		return btnAsc;
	}

	private JButton getBtnDesc()
	{
		if (btnDesc == null)
		{
			btnDesc = new JButton("Absteigend");
			btnDesc.setBounds(353, 132, 120, 25);
		}
		return btnDesc;
	}

	private JButton getBtnZurueck()
	{
		if (btnZurueck == null)
		{
			btnZurueck = new JButton("Zurück");
			btnZurueck.setBounds(527, 228, 120, 25);
		}
		return btnZurueck;
	}

	private JTextField getSearchbar()
	{
		if (searchbar == null)
		{
			searchbar = new JTextField();
			searchbar.setBounds(350, 229, 167, 20);
			searchbar.setColumns(10);
		}
		return searchbar;
	}

	protected JComboBox<Sorter> getSearchtype()
	{
		if (searchtype == null)
		{
			searchtype = new JComboBox<Sorter>();
			searchtype.setBounds(353, 168, 120, 22);
		}
		return searchtype;
	}

	protected JList<Filme> getMovielist()
	{
		if (movielist == null)
		{
			movielist = new JList<Filme>();
			movielist.setBounds(10, 10, 333, 241);
		}
		return movielist;
	}
	protected JLabel getImage() {
	    if (image == null) {
	        image = new JLabel("");
	        image.setHorizontalAlignment(SwingConstants.CENTER);
	        image.setBounds(483, 10, 172, 207);
	    }
	    return image;
	}
}
