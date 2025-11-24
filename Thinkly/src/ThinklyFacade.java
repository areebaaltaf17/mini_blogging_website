public class ThinklyFacade {
    private DatabaseConnection db;

    public ThinklyFacade() {
        db = DatabaseConnection.getInstance();
    }

    public User registerUser(String type, String username, String email, String password) {
        User user = UserFactory.createUser(type, username, email, password);
        if (user != null) db.insertUser(user);
        return user;
    }

    public void createPost(String title, String content, User author, int authorId) {
        Post post = new Post(title, content, author);
        post.showPost();
        db.insertPost(post, authorId);
    }
}
