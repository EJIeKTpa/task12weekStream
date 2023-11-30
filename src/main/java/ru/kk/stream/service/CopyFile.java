package ru.kk.stream.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void copyFile() {
        File sourceFile = new File("source.txt");
        File destFile = new File("dest.txt");
        try (FileInputStream input = new FileInputStream(sourceFile);
             FileOutputStream output = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead =input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

