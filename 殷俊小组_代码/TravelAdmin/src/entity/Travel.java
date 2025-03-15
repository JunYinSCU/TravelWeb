package entity;

public class Travel {
    private int id;
    private String travelTitle;
    private String travelTime;
    private String travelContent;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTravelTitle() {
        return travelTitle;
    }

    public void setTravelTitle(String travelTitle) {
        this.travelTitle = travelTitle;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getTravelContent() {
        return travelContent;
    }

    public void setTravelContent(String travelContent) {
        this.travelContent = travelContent;
    }

    public Travel(int id, String youkezhanghao, String youkexingming, String xianluguihua) {
        this.id = id;
        this.travelTitle = youkezhanghao;
        this.travelTime = youkexingming;
        this.travelContent = xianluguihua;
    }

}
