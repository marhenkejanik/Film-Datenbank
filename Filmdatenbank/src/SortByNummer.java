public class SortByNummer extends Sorter
{
    @Override
    public int compare(Filme o1, Filme o2) {
        return Integer.compare(o1.getNummer() , o2.getNummer());
    }
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Nummer";
	}
}
