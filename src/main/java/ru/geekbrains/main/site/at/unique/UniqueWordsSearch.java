package ru.geekbrains.main.site.at.unique;

import java.util.*;

public class UniqueWordsSearch {
    public static void main(String[] args) {
        String[] arrWords = {"это", "пример", "массива", "для", "поиска", "слов",
                "слов", "поиска", "разных", "слов", "массив"};

        String[] arrUnique = getUniques(arrWords);
        System.out.printf("%d уникальных слов в массиве:\n%s\n\n", arrUnique.length, Arrays.toString(arrUnique));

        System.out.printf(countUniques(arrWords));
    }

    private static String[] getUniques(String[] arr) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(arr));
        return Arrays.copyOf(stringSet.toArray(), stringSet.size(), String[].class);
    }

    private static String countUniques(String[] arr) {
        String[] arrUnique = getUniques(arr);
        StringBuilder result = new StringBuilder();

        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(arr));
        result.append("Всего "+ stringArrayList.size() + " слов:\n");
        for (String word:arrUnique) {
            result.append("\"" + word + "\" - " + Collections.frequency(stringArrayList, word) + " раз(а);\n");
        }

        return result.toString();
    }
}
