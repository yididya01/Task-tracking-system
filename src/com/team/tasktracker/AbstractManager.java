package com.team.tasktracker;

import java.time.LocalDate;

public abstract class AbstractManager implements Storable {
    protected FileHandler fileHandler;
    protected LogWriter logWriter;

    public AbstractManager(FileHandler fileHandler, LogWriter logWriter) {
        this.fileHandler = fileHandler;
        this.logWriter = logWriter;
    }

    protected void logOperation(String operation) {
        logWriter.logInfo("Operation: " + operation + " at " + AppUtils.formatDate(LocalDate.now()));
    }

    protected int generateId() {
        return AppUtils.generateId();
    }

    protected void handleError(Exception e) {
        logWriter.logError("Error: " + e.getMessage());
        throw new RuntimeException("Operation failed: " + e.getMessage());
    }

    // Abstract methods for subclasses
    abstract void save();

    abstract void load(int id);

    abstract void delete(int id);

    abstract boolean validate(Object entity);
}