public class SortByDauer extends Sorter
{

    @Override
    public int compare(Filme o1, Filme o2) {
        return Integer.compare(o1.getDauer() , o2.getDauer());
    }

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Dauer";
	}
}
