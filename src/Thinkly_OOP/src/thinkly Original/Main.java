public class Main {
    public static void main(String[] args) {
        // Create a normal user
        NormalUser user1 = new NormalUser("Areeba", "areeba@example.com", "12345");
        user1.displayRole();

        // Create database connection
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();
        db.insertData("New User: " + user1.getUsername());

        // Create post
        Post p1 = new Post("My First Blog", "This is my first post on Thinkly!", user1);
        p1.showPost();
    }
}
