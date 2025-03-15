package entity;

public class Product {

private int id;
private String jingdianmingcheng;
private String jingdiandengji;
private String jingdianjieshao;
private String suozaishengqu;
private String suozaishiqu;
private String suozaidiqu;
private String meitiankaifangshijian;
private String meitianguanbishijian;
private String beizhu;
private String jiage;

    public Product(int id, String jingdianmingcheng, String jingdiandengji, String jingdianjieshao, String suozaishengqu, String suozaishiqu, String suozaidiqu, String meitiankaifangshijian, String meitainguanbishijian, String beizhu, String jiage) {
        this.id = id;
        this.jingdianmingcheng = jingdianmingcheng;
        this.jingdiandengji = jingdiandengji;
        this.jingdianjieshao = jingdianjieshao;
        this.suozaishengqu = suozaishengqu;
        this.suozaishiqu = suozaishiqu;
        this.suozaidiqu = suozaidiqu;
        this.meitiankaifangshijian = meitiankaifangshijian;
        this.meitianguanbishijian = meitainguanbishijian;
        this.beizhu = beizhu;
        this.jiage = jiage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }

    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng;
    }

    public String getJingdiandengji() {
        return jingdiandengji;
    }

    public void setJingdiandengji(String jingdiandengji) {
        this.jingdiandengji = jingdiandengji;
    }

    public String getJingdianjieshao() {
        return jingdianjieshao;
    }

    public void setJingdianjieshao(String jingdianjieshao) {
        this.jingdianjieshao = jingdianjieshao;
    }

    public String getSuozaishengqu() {
        return suozaishengqu;
    }

    public void setSuozaishengqu(String suozaishengqu) {
        this.suozaishengqu = suozaishengqu;
    }

    public String getSuozaishiqu() {
        return suozaishiqu;
    }

    public void setSuozaishiqu(String suozaishiqu) {
        this.suozaishiqu = suozaishiqu;
    }

    public String getSuozaidiqu() {
        return suozaidiqu;
    }

    public void setSuozaidiqu(String suozaidiqu) {
        this.suozaidiqu = suozaidiqu;
    }

    public String getMeitiankaifangshijian() {
        return meitiankaifangshijian;
    }

    public void setMeitiankaifangshijian(String meitiankaifangshijian) {
        this.meitiankaifangshijian = meitiankaifangshijian;
    }

    public String getMeitianguanbishijian() {
        return meitianguanbishijian;
    }

    public void setMeitianguanbishijian(String meitainguanbishijian) {
        this.meitianguanbishijian = meitainguanbishijian;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getJiage() {
        return jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", jingdianmingcheng='" + jingdianmingcheng + '\'' +
                ", jingdiandengji='" + jingdiandengji + '\'' +
                ", jingdianjieshao='" + jingdianjieshao + '\'' +
                ", suozaishengqu='" + suozaishengqu + '\'' +
                ", suozaishiqu='" + suozaishiqu + '\'' +
                ", suozaidiqu='" + suozaidiqu + '\'' +
                ", meitiankaifangshijian='" + meitiankaifangshijian + '\'' +
                ", meitianguanbishijian='" + meitianguanbishijian + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", jiage='" + jiage + '\'' +
                '}';
    }


}
