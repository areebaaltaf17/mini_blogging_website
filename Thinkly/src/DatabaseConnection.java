import java.sql.*;

public class DatabaseConnection implements DatabaseOperations {

    private static volatile DatabaseConnection instance;
    private Connection conn;

    private final String URL = "jdbc:mysql://localhost:3306/thinklydb?useSSL=false&allowPublicKeyRetrieval=true";
    private final String USER = "root";
    private final String PASSWORD = "";

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) instance = new DatabaseConnection();
            }
        }
        return instance;
    }

    @Override
    public void connect() {
        if (conn != null) {
            System.out.println("Connected to database.");
        }
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement stmt =
                conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) System.out.println("User inserted with ID: " + rs.getInt(1));

        } catch (SQLException e) {
            System.out.println("Insert User Error: " + e.getMessage());
        }
    }

    @Override
    public void insertPost(Post post, int authorId) {
        String sql = "INSERT INTO posts(title, content, author_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt =
                conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setInt(3, authorId);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) System.out.println("Post inserted with ID: " + rs.getInt(1));

        } catch (SQLException e) {
            System.out.println("Insert Post Error: " + e.getMessage());
        }
    }

    public Connection getConnection() { return conn; }
}
