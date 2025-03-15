package entity;

public class Brief {
    private int id;
    private String text;

    public Brief() {
    }

    public Brief(int id, String text) {
        this.id = id;
        this.text = text;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Brief{id = " + id + ", text = " + text + "}";
    }
}
