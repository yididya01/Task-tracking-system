package src.main.java.com.ttracker.interfaces;

public interface Storable {
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}
