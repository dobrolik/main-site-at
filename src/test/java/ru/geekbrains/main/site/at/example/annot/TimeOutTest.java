package ru.geekbrains.main.site.at.example.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeOutTest {

    @Timeout(1)
    @Test()
    void myFirstTest() throws InterruptedException {
        sleep(1000);
        assertEquals(2, 1 + 1);
    }
}
