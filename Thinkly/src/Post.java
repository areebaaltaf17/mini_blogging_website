public class Post {
    private String title;
    private String content;
    private User author;

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getAuthor() { return author; }

    public void showPost() {
        System.out.println(author.getUsername() + " posted: " + title + " - " + content);
    }
}
