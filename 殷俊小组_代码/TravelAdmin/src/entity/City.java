package entity;

public class City
{
    int id;
    String cityName;

    public City(String diqu, int id)
    {
        this.id = id;
        this.cityName = diqu;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }
}
