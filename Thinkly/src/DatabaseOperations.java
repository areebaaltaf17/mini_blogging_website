public interface DatabaseOperations {
    void connect();
    void insertUser(User user);
    void insertPost(Post post, int authorId);
}
