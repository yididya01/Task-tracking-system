package com.ttracker.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private static final String LOG_FILE = "logs.txt";
    
    public static void log(String message) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE, true));
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                System.err.println("Failed to close log file: " + e.getMessage());
            }
        }
    }
}
