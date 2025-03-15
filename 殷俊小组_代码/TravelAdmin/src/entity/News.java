package entity;

public class News {

    private int id;
    private String title;
    private String introduction;
    private String content;

    private String addTime;


    public News() {
    }

    public News(int id, String title, String introduction, String content, String addTime) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.content = content;
        this.addTime = addTime;
    }

    public News(int id, String title, String introduction, String content) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.content = content;
    }

    public News(String title, String introduction, String content) {
        this.title = title;
        this.introduction = introduction;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
