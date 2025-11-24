// No smell: Class follows SRP & proper inheritance.
// Shows Method Overriding cleanly.

public class NormalUserRefactored extends UserRefactored {

    public NormalUserRefactored(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Normal User - Can create and view posts.");
    }
}
