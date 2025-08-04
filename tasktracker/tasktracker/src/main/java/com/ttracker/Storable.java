package src.main.java.com.ttracker;

public interface Storable {
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}
