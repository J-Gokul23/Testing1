package com.example.Testing1;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestingClass {

    @Mock
    Calculator calculator;

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("Before All Method");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("BeforeEach");
    }

    @Test
    void test1() {
        System.out.println("Test1 Method");
    }

    @Test
    void test2() {
        System.out.println("Test2 Method");
    }

    @Test
    void test3() {

        Mockito.when(calculator.getMessage()).thenReturn("Gokul");
        String name = calculator.getMessage();
        Assertions.assertEquals("Gokul", name);

    }

    @Test
    void test5() {
        Mockito.when(calculator.check1()).thenReturn(true);

        boolean result = calculator.check1();

        Assertions.assertTrue(result);

        System.out.println("Test5 Passed");
    }

    @Test
    void test4() {

        Calculator calculator1 = new Calculator();

        String name = calculator1.getMessage();

        Assertions.assertEquals("Gokul", name);

        System.out.println("Test 4 Passed");

    }

    @Test
    void test6() {

        Mockito.when(calculator.getException(17)).thenThrow(RuntimeException.class);
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                calculator.getException(17);
            }
        };
        Assertions.assertThrows(RuntimeException.class, executable);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void test7(int number) {

        System.out.println(number);

        Calculator calculator1 = new Calculator();

//        Mockito.when(calculator.check2(number)).thenReturn(number);

        Assertions.assertEquals(0, calculator1.check2(number));

        System.out.println("Test 7 Passed");

    }
}
