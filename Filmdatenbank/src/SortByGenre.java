public class SortByGenre extends Sorter
{
    @Override
    public int compare(Filme o1, Filme o2) {
        return  o1.getGenre().compareTo(o2.getGenre());
    }
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Genre";
	}
}