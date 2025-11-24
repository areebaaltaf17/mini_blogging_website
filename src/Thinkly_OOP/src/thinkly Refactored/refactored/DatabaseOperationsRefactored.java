// No smell: Interface correctly defines required behavior.
// Supports Abstraction & loose coupling.

public interface DatabaseOperationsRefactored {
    void connect();
    void insertData(String data);
    void fetchData();
}
