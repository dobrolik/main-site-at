package ru.geekbrains.main.site.at.example.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExampleException {
    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Том");
        cats.add("Барсик");
        cats.add("Бармаглот");

        Iterator<String> iterator = cats.iterator();

        while (iterator.hasNext()) {
            String cat = iterator.next();

            System.out.println(cat);
        }
    }
}
