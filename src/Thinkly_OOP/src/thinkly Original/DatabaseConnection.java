public class DatabaseConnection implements DatabaseOperations {
    // Singleton pattern
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database connection created.");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
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

