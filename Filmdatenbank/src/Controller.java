import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Controller implements KeyListener {

	private DefaultComboBoxModel<Sorter> sort = new DefaultComboBoxModel<Sorter>();
	private DefaultListModel<Filme> filmListe = new DefaultListModel<Filme>();
	private DefaultListModel<Filme> originalFilmListe = new DefaultListModel<Filme>();
	private ArrayList<Filme> filme;
	private FilmGui filmGui;
	private DHio dhio;
	private Path path;
	// private DHnio dhnio;

	public Controller() {
		filmGui = new FilmGui();
		dhio = new DHio();
		// dhnio = new DHnio();
		fuellen();
		setModels();
		aktivereListener();
	}

	private void aktivereListener() {
		filmGui.btnAsc.addActionListener(e -> asc());
		filmGui.btnDesc.addActionListener(e -> desc());
		filmGui.btnZurueck.addActionListener(e -> back());
		filmGui.searchbar.addKeyListener(this);
		filmGui.movielist.addListSelectionListener(e -> bild());
	}

	public void bild() {
		// Check if an item is selected in the movielist
		if (filmGui.movielist.getSelectedValue() != null) {
			path = Paths.get("src", "titelbilder", filmGui.movielist.getSelectedValue().getName().toLowerCase().replace(" ", "") + ".jpg");
			ImageIcon icon = new ImageIcon(path.toString());
			icon = new ImageIcon(icon.getImage().getScaledInstance(filmGui.getImage().getWidth(), filmGui.getImage().getHeight(),Image.SCALE_SMOOTH));
			filmGui.getImage().setIcon(icon);
		}
	}

	public void fuellen() {
		// filme = dhnio.lesen();
		filme = dhio.lesen();
		for (Filme film : filme) {
			filmListe.addElement(film);
			originalFilmListe.addElement(film);
		}
		sort.addElement(new SortByNummer());
		sort.addElement(new SortByName());
		sort.addElement(new SortByGenre());
		sort.addElement(new SortByDauer());
	}

	public void setModels() {
		filmGui.getMovielist().setModel(filmListe);
		filmGui.getSearchtype().setModel(sort);
	}

	public void asc() {
		Object selectedSorter = filmGui.searchtype.getSelectedItem();

		if (selectedSorter instanceof Sorter) {
			Sorter sorter = (Sorter) selectedSorter;
			filme.sort(sorter);

			// Update the DefaultListModel
			updateListModel();
		}
	}

	public void desc() {
		Object selectedSorter = filmGui.searchtype.getSelectedItem();

		if (selectedSorter instanceof Sorter) {
			Sorter sorter = (Sorter) selectedSorter;
			filme.sort(sorter.reversed()); // Use reversed() to sort in descending order

			// Update the DefaultListModel
			updateListModel();
		}
	}

	public void suche(KeyEvent e) {
		String searchText = filmGui.searchbar.getText().trim().toLowerCase();
		DefaultListModel<Filme> filteredListModel = new DefaultListModel<>();

		if (searchText.isEmpty()) {
			back();
		} else if (e.equals(KeyEvent.VK_BACK_SPACE)) {

		}
		for (int i = 0; i < filmListe.size(); i++) {
			Filme film = filmListe.getElementAt(i);
			if (film.getName().toLowerCase().startsWith(searchText)) {
				filteredListModel.addElement(film);
			}
		}

		filmListe.clear();
		for (int i = 0; i < filteredListModel.size(); i++) {
			filmListe.addElement(filteredListModel.getElementAt(i));
		}
	}

	public void back() {
		filmListe.clear();
		for (int i = 0; i < originalFilmListe.size(); i++) {
			filmListe.addElement(originalFilmListe.getElementAt(i));
		}
		filmGui.searchbar.setText(null);
	}

	private void updateListModel() {
		filmListe.clear();
		for (Filme film : filme) {
			filmListe.addElement(film);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		suche(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		suche(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		suche(e);
	}
}
