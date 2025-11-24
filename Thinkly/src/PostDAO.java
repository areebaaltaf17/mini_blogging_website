import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    private Connection conn;

    public PostDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    // Insert a new post
    public boolean insertPost(Post post, int authorId) {
        String sql = "INSERT INTO posts(title, content, author_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setInt(3, authorId);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Insert Post Error: " + e.getMessage());
            return false;
        }
    }

    // Load all posts
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        String sql = "SELECT posts.id, posts.title, posts.content, users.username FROM posts "
                + "INNER JOIN users ON posts.author_id = users.id "
                + "ORDER BY posts.id DESC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                String user = rs.getString("username");

                // Create dummy User for display
                User author = new NormalUser(user, "", "");

                Post p = new Post(title, content, author);
                posts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Load Posts Error: " + e.getMessage());
        }

        return posts;
    }
}
