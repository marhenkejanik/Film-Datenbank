import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//import javax.swing.JFileChooser;

public class DHnio extends Dateihandler {
	//JFileChooser chooser = new JFileChooser();
	Path path;
//	private HashSet<Filme> filmSet = new HashSet<>();
	private ArrayList<Filme> film = new ArrayList<Filme>();

	@Override
	public ArrayList<Filme> lesen() {
		//chooser.showOpenDialog(null);
		//path = chooser.getSelectedFile().toPath();
		path = Paths.get("src", "list" , "FilmListe2.txt");
		try (BufferedReader br = Files.newBufferedReader(path)) {
			try {
				br.readLine();
				String line;
				while ((line = br.readLine()) != null) {
					String[] s = line.split(";");
					Filme newFilm = new Filme(Integer.valueOf(s[0]), s[1], s[2], Integer.valueOf(s[3]));

					if (!film.contains(newFilm)) {
						film.add(newFilm);
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// film = new ArrayList<>(filmSet);
		return film;
	}
}
