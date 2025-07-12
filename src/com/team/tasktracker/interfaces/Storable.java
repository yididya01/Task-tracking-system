package com.team.tasktracker.interfaces;

public interface Storable {
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}
