package ru.kk.stream._main;

import ru.kk.stream.service.CopyFile;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = null; // создаем поток для чтения из консоли
        FileWriter fileWriter = null; // создаем поток вывода в файл
        String s = ""; // создаем пустую строку
        try {
            inputStreamReader = new InputStreamReader(System.in); //объявляем, что считывать
            // строку будем из консоли
            fileWriter = new FileWriter("source.txt"); // объявляем, что записывать символ
            // будем в файл text.txt
            System.out.println("Введите строку в консоль");
            int inChar = inputStreamReader.read(); //считываем первый символ из консоли
            while (inputStreamReader.ready()) { // создаем цикл, который будет посимвольно считывать
                //из консоли, пока все символы в строке не будут считаны
                s += (char) inChar; // добавляем каждый считаный символ в нашу строку
                inChar =  inputStreamReader.read(); // считываем следующий символ
            }
            fileWriter.write(s); // записываем полученную строку в файл
        } catch (IOException e) { // отлавливаем исключение IOException
            System.err.println(e.getMessage()); // записываем в консоль текст исключения,
            // если оно возникает
        } finally {
            if (inputStreamReader != null) {
                inputStreamReader.close(); // если нам удалось открыть поток на чтение из консоли,
                // то нам нужно закрыть его
            }
            if (fileWriter != null) {
                fileWriter.close(); // если нам удалось открыть поток на запись в файл,
                // то нам нужно закрыть его
            }
        }
        CopyFile.copyFile();
    }
}
