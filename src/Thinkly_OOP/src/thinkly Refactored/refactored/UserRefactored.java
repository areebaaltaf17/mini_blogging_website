// No major smell: Class already follows Encapsulation & Abstraction.
// Minor Improvement: Added validateEmail() for cleaner responsibility.
// Refactoring Technique: Extract Method
// Reason: Constructor was doing too much (validation + assign values).
// Benefit: Improves readability and Single Responsibility Principle (SRP).

public abstract class UserRefactored {
    private String username;
    private String email;
    private String password;

    public UserRefactored(String username, String email, String password) {
        this.username = username;
        this.email = validateEmail(email); // Extracted to its own method (refactoring)
        this.password = password;
    }

    private String validateEmail(String email) {
        return email;  // placeholder validation
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = validateEmail(email); }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Abstraction: Subclasses will implement different roles
    public abstract void displayRole();
}
