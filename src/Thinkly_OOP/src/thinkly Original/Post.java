public class Post {
    private String title;
    private String content;
    private User author; // Composition: post has a user

    public Post(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void showPost() {
        System.out.println(author.getUsername() + " posted: " + title + " - " + content);
    }
}


