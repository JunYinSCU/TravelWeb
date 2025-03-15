package entity;

public class Province
{
    int id;
    String provinceName;

    public Province(String shiqu, int id)
    {
        this.id = id;
        this.provinceName = shiqu;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }
}
