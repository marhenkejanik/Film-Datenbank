public class SortByName extends Sorter
{

    @Override
    public int compare(Filme o1, Filme o2) {
        return o1.getName().compareTo(o2.getName());
    }
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Name";
	}
}
