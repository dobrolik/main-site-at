package ru.geekbrains.main.site.at.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> records = new HashMap<String, String>();

    public void add(String phone, String name) {
        records.put(phone, name);
    }

    public String[] getPhones(String name) {
        List<String> result = new ArrayList<>();
        for (Map.Entry entry : records.entrySet()) {
            if (name.equalsIgnoreCase((String)entry.getValue())){
                result.add((String)entry.getKey());
            }
        }
        if (result.size() == 0) result.add("Не найдено");
        return result.toArray(new String[0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : records.entrySet()) {
            sb.append(entry.getValue() + "\t- " + entry.getKey() + "\n");
        }
        return sb.toString();
    }
}
