package entity;

public class Feedback
{
    String content;
    String reply;
    long id;

    String username;

    public Feedback(String content, long id, String reply, String username)
    {
        this.content = content;
        this.reply = reply;
        this.id = id;
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getReply()
    {
        return reply;
    }

    public void setReply(String reply)
    {
        this.reply = reply;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
