package ru.geekbrains.main.site.at.example.annot;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.geekbrains.main.site.at.base.BaseTest;

import org.junit.jupiter.api.*;

class StandartTest extends BaseTest

    {

        @BeforeAll
        static void initAll() {
            System.out.println("initAll");
        }

        @BeforeEach
        void init() {
            System.out.println("init");
        }

        @Test
        void succeedingTest1() {
            System.out.println("succeedingTest");
        }

        @Test
        void succeedingTest2() {
            System.out.println("succeedingTest");
        }

//    @Test
//    void failingTest() {
//        fail("a failing test");
//    }
//
//    @Test
//    @Disabled("for demonstration purposes")
//    void skippedTest() {
//    }

        @AfterEach
        void tearDown() {
            System.out.println("tearDown");
        }

        @AfterAll
        static void tearDownAll() {
            System.out.println("tearDownAll");
        }

    }
}
