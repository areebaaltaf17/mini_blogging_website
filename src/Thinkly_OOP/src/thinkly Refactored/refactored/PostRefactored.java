// Smell Found: Presentation logic mixed with business object.
// Original showPost() printed the string directly.
// Refactoring Technique: Move Method (Extract toString())
// Benefit: Cleaner design, reusable string output.

public class PostRefactored {

    private String title;
    private String content;
    private UserRefactored author;

    public PostRefactored(String title, String content, UserRefactored author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Moved representation to toString() for better separation
    @Override
    public String toString() {
        return author.getUsername() + " posted: " + title + " - " + content;
    }

    public void showPost() {
        System.out.println(toString());  // Cleaner, reusable
    }
}
