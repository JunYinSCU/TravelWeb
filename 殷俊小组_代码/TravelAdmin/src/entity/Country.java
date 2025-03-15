package entity;

public class Country
{
    private String countyName;

    private int id;

    public Country(String shengqu, int id)
    {
        this.countyName = shengqu;
        this.id = id;
    }

    public String getCountyName()
    {
        return countyName;
    }

    public void setCountyName(String countyName)
    {
        this.countyName = countyName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
