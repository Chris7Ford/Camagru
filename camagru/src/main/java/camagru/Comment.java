package camagru;

public class Comment {
    int userId;
    int postId;
    String content;
    String password;

    public void setPassword(String pass) { this.password = pass; }

    public String getPassword() { return (this.password); }

    public void setUserId(int id) {
        this.userId = id;
    }

    public void setPostId(int id) {
        this.postId = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return (this.userId);
    }

    public int getPostId() {
        return (this.postId);
    }

    public String getContent() {
        return (this.content);
    }
}
