package ru.geekbrains.main.site.at.example.exception;

import java.util.ArrayList;
import java.util.List;

public class MemoryGrabber {

    static final List<Object[]> arrays = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            arrays.add(new Object[1000000000]);
        }
    }
}

