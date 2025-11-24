public class UserFactory {
    public static User createUser(String type, String username, String email, String password) {
        if (type.equalsIgnoreCase("normal")) {
            return new NormalUser(username, email, password);
        }
        return null; // future roles here
    }
}
