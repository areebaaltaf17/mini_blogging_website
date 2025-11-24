// Inheritance from abstract class User
public class NormalUser extends User {

    public NormalUser(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Normal User - Can create and view posts.");
    }
}


