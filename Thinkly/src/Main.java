public class Main {
    public static void main(String[] args) {

        ThinklyFacade facade = new ThinklyFacade();

        // Register user
        User user1 = facade.registerUser("normal", "Areeba", "areeba@example.com", "12345");
        user1.displayRole();

        // Create post
        facade.createPost("My First Blog", "This is my first post on Thinkly!", user1, 1);
    }
}
