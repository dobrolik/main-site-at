package ru.geekbrains.main.site.at.example.annot;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatTest {

    //количество повторений
    @RepeatedTest(10)
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}
