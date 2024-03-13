import java.util.Objects;

public class Filme
{
	private int nummer;
	private String name;
	private String genre;
	private int dauer;
	
	public Filme()
	{}
	

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Filme other = (Filme) obj;
        return this.getNummer() == other.getNummer() &&
                Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getGenre(), other.getGenre()) &&
                this.getDauer() == other.getDauer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer, name, genre, dauer);
    }
	
	public Filme(int nummer, String name, String genre, int dauer)
	{
		super();
		this.nummer = nummer;
		this.name = name;
		this.genre = genre;
		this.dauer = dauer;
	}

	public int getNummer()
	{
		return nummer;
	}

	public void setNummer(int nummer)
	{
		this.nummer = nummer;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public int getDauer()
	{
		return dauer;
	}

	public void setDauer(int dauer)
	{
		this.dauer = dauer;
	}

	@Override
	public String toString()
	{
		return nummer + " | " + name + " | "+ genre+ " | "+dauer;
	}	
}
