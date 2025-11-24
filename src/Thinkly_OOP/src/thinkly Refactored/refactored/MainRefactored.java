// Smell Found: Long Method + Multiple Responsibilities
// Main originally created users, DB connections, posts all in one place.
// Refactoring Technique: Extract Method
// Benefit: Cleaner, more readable main method. Each task is isolated.

public class MainRefactored {

    public static void main(String[] args) {

        // Responsibility split using Extract Method
        UserRefactored user = createUser();
        user.displayRole();

        DatabaseConnectionRefactored db = initDB();
        db.insertData("New User: " + user.getUsername());

        PostRefactored post = createPost(user);
        post.showPost();
    }

    // Extracted: User Creation
    private static UserRefactored createUser() {
        return new NormalUserRefactored("Areeba", "areeba@example.com", "12345");
    }

    // Extracted: DB Initialization
    private static DatabaseConnectionRefactored initDB() {
        DatabaseConnectionRefactored db = DatabaseConnectionRefactored.getInstance();
        db.connect();
        return db;
    }

    // Extracted: Post Creation
    private static PostRefactored createPost(UserRefactored user) {
        return new PostRefactored("My First Blog", "This is my first post on Thinkly!", user);
    }
}
