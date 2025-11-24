// Smell Found: Non-thread-safe Singleton (original).
// Problem: Multiple objects could be created in multi-threading.
// Refactoring Technique: Double-Checked Locking + volatile keyword.
// Benefit: Ensures Singleton is safe, efficient, and correct.

public class DatabaseConnectionRefactored implements DatabaseOperationsRefactored {

    // volatile ensures visibility across threads
    private static volatile DatabaseConnectionRefactored instance;

    private DatabaseConnectionRefactored() {
        System.out.println("Database connection created.");
    }

    public static DatabaseConnectionRefactored getInstance() {

        // First check (improves performance)
        if (instance == null) {

            // Synchronize only when instance is null
            synchronized (DatabaseConnectionRefactored.class) {

                // Second check (ensures correct instance creation)
                if (instance == null) {
                    instance = new DatabaseConnectionRefactored();
                }
            }
        }
        return instance;
    }

    @Override
    public void connect() {
        System.out.println("Connected to MySQL database successfully.");
    }

    @Override
    public void insertData(String data) {
        System.out.println("Inserted: " + data);
    }

    @Override
    public void fetchData() {
        System.out.println("Fetched data from database.");
    }
}
