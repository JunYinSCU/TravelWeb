package entity;

public class Order {
    private long id;
    private String youkezhanghao;
    private String lianxifangshi;
    private String shenfenzheng;
    private String jingdianmingcheng;
    private int piaoshu;
    private String zongjine;
    private String goupiaoshijian;


    public Order() {
    }

    public Order(long id, String youkezhanghao, String lianxifangshi, String shenfenzheng, String jingdianmingcheng, int piaoshu, String zongjine, String goupiaoshijian) {
        this.id = id;
        this.youkezhanghao = youkezhanghao;
        this.lianxifangshi = lianxifangshi;
        this.shenfenzheng = shenfenzheng;
        this.jingdianmingcheng = jingdianmingcheng;
        this.piaoshu = piaoshu;
        this.zongjine = zongjine;
        this.goupiaoshijian = goupiaoshijian;
    }

    /**
     * 获取
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return youkezhanghao
     */
    public String getYoukezhanghao() {
        return youkezhanghao;
    }

    /**
     * 设置
     * @param youkezhanghao
     */
    public void setYoukezhanghao(String youkezhanghao) {
        this.youkezhanghao = youkezhanghao;
    }

    /**
     * 获取
     * @return lianxifangshi
     */
    public String getLianxifangshi() {
        return lianxifangshi;
    }

    /**
     * 设置
     * @param lianxifangshi
     */
    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi;
    }

    /**
     * 获取
     * @return shenfenzheng
     */
    public String getShenfenzheng() {
        return shenfenzheng;
    }

    /**
     * 设置
     * @param shenfenzheng
     */
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    /**
     * 获取
     * @return jingdianmingcheng
     */
    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }

    /**
     * 设置
     * @param jingdianmingcheng
     */
    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng;
    }

    /**
     * 获取
     * @return piaoshu
     */
    public int getPiaoshu() {
        return piaoshu;
    }

    /**
     * 设置
     * @param piaoshu
     */
    public void setPiaoshu(int piaoshu) {
        this.piaoshu = piaoshu;
    }

    /**
     * 获取
     * @return zongjine
     */
    public String getZongjine() {
        return zongjine;
    }

    /**
     * 设置
     * @param zongjine
     */
    public void setZongjine(String zongjine) {
        this.zongjine = zongjine;
    }

    /**
     * 获取
     * @return goupiaoshijian
     */
    public String getGoupiaoshijian() {
        return goupiaoshijian;
    }

    /**
     * 设置
     * @param goupiaoshijian
     */
    public void setGoupiaoshijian(String goupiaoshijian) {
        this.goupiaoshijian = goupiaoshijian;
    }

    public String toString() {
        return "Order{id = " + id + ", youkezhanghao = " + youkezhanghao + ", lianxifangshi = " + lianxifangshi + ", shenfenzheng = " + shenfenzheng + ", jingdianmingcheng = " + jingdianmingcheng + ", piaoshu = " + piaoshu + ", zongjine = " + zongjine + ", goupiaoshijian = " + goupiaoshijian + "}";
    }
}
