package entity;

public class Account {
    private long id;
    private String youkezhanghao;
    private String youkexingming;
    private String xingbie;
    private String lianxifangshi;
    private String shenfenzheng;
    private String youxiang;
    private String is_bannedStr;
    public long getId() {return id;};
    public void setId(long id) {this.id=id;};
    public String getYoukezhanghao() {return youkezhanghao;};
    public void setYoukezhanghao(String Youkezhanghao) {this.youkezhanghao=youkezhanghao;};
    public String getYoukexingming() {return youkexingming;};
    public void setYoukexingming(){this.youkexingming=youkexingming;};
    public String getXingbie(){return xingbie;};
    public void setXingbie(String Xingbie){this.xingbie=Xingbie;};
    public String getLianxifangshi() {return lianxifangshi;};
    public void setLianxifangshi(String lianxifangshi) {this.lianxifangshi = lianxifangshi;};
    public String getShenfenzheng() {return shenfenzheng;};
    public void setShenfenzheng(String shenfenzheng) {this.shenfenzheng = shenfenzheng;};
    public String getYouxiang() {return youxiang;};
    public void setYouxiang(String youxiang) {this.youxiang = youxiang;};
    public String getIs_bannedStr() {return is_bannedStr;};
    public void setIs_bannedStr(){this.is_bannedStr=is_bannedStr;};
    public Account(long id,String youkezhanghao,String youkexingming, String xingbie,String lianxifangshi,String shenfenzheng,String youxiang,String is_bannedStr) {
        this.id=id;
        this.youkezhanghao=youkezhanghao;
        this.youkexingming=youkexingming;
        this.xingbie=xingbie;
        this.lianxifangshi=lianxifangshi;
        this.shenfenzheng=shenfenzheng;
        this.youxiang=youxiang;
        this.is_bannedStr=is_bannedStr;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", youkezhanghao='" + youkezhanghao + '\'' +
                ", youkexingming='" + youkexingming + '\'' +
                ", xingbie='" + xingbie + '\'' +
                ", lianxifangshi='" + lianxifangshi + '\'' +
                ", shenfenzheng='" + shenfenzheng + '\'' +
                ", youxiang='" + youxiang + '\'' +
                ", is_bannedStr='" + is_bannedStr + '\'' +
                '}';
    }
}
