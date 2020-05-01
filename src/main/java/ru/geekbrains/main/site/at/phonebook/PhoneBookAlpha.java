package ru.geekbrains.main.site.at.phonebook;

import java.util.Arrays;

public class PhoneBookAlpha {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+7(901)111-11-11", "Торин");
        phoneBook.add("+7(902)222-22-22", "Балин");
        phoneBook.add("+7(903)333-33-33", "Глоин");
        phoneBook.add("+7(904)444-44-44", "Глоин");
        phoneBook.add("+7(905)555-55-55", "Дурин");


        String[] results = phoneBook.getPhones("Глоин");
        System.out.printf("Результаты поиска:\n%s\n", Arrays.toString(results));
        System.out.println();

    }
}
