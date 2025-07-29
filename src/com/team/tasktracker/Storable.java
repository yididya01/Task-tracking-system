package com.team.tasktracker;

public interface Storable {
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}
