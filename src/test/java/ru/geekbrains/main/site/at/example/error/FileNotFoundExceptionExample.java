package ru.geekbrains.main.site.at.example.error;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExceptionExample {

    public static void main(String[] args) throws FileNotFoundException {
        new FileReader(new File("путь к файлу"));
    }
}
