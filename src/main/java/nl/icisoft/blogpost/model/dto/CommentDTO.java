package nl.icisoft.blogpost.model.dto;

public class CommentDTO {

    private int id;
    private String user;
    private String content;

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + ", user='" + user + "'" + ", content='" + content + "'" + "}";
    }

}