import java.sql.*;

public class UserDAO {

    private Connection conn;

    public UserDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    // Insert a new user into DB
    public boolean insertUser(User user) {
        // VALIDATION --------------------------------------

// Empty fields
if (user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
    System.out.println("Fields cannot be empty!");
    return false;
}

// Email format check
boolean validEmail = user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$");
if (!validEmail) {
    System.out.println("Invalid email format!");
    return false;
}

// Password length
if (user.getPassword().length() < 5) {
    System.out.println("Password must be at least 5 characters.");
    return false;
}

        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("User Insert Error: " + e.getMessage());
            return false;
        }
    }

    // Check login credentials
    public boolean checkLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
    System.out.println("Email and password cannot be empty!");
    return false;
}

boolean validEmail = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
if (!validEmail) {
    System.out.println("Invalid email format!");
    return false;
}

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }

    // Get user ID by email
    public int getUserId(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("GetUserId Error: " + e.getMessage());
        }
        return -1;
    }

    // Check if email already exists
    public boolean checkEmailExists(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Email Check Error: " + e.getMessage());
        }

        return false;
    }
}
