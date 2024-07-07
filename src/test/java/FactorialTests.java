package test.java;

import main.java.Factorial;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FactorialTests {
    private int number;

    @BeforeClass
    public void setup() {
        number = 12;
    }

    @AfterClass
    public void tearDown() {
        number = 0;
    }

    @Test(testName = "Простой тест для Before/After")
    public void givenNumber_whenEven_thenTrue() {
        assertTrue(number % 2 == 0);
    }

    @Test(testName = "Tест факториала 5")
    void factorialFiveAssertTrueTest() {
        long factFive = Factorial.factorial(5);
        assertEquals(120, factFive);
    }

    @Test(testName = "Tест на неверный факториал 5")
    void factorialFiveAssertFalseTest() {
        long factFive = Factorial.factorial(5);
//        assertNotEquals(120, factFive);
        Assert.assertNotEquals(121, factFive);
    }

    @DataProvider(name = "getFactorialData", parallel = true)
    public static Object[][] getFactorialData() {
        return new Object[][]{
                {1},
                {2},
                {6},
                {24},
                {120},
                {6402373705728000L}
        };
    }

    @Test(testName = "Параметризованный тест факториала (только для значения факториала)",
            dataProvider = "getFactorialData", threadPoolSize = 2, invocationCount = 2)
    public void isFactorial_ParameterizedTest(long number){
        final Thread thread = Thread.currentThread();
        System.out.printf("#%d: %s, %d\n", thread.getId(), thread.getName(), number);

        assertTrue(number > 0);

        long i = 1, fact = Factorial.factorial(i);
        while(fact < number){
            i++;
            fact = Factorial.factorial(i);
        }

        Assert.assertEquals(fact, number);
    }

    @DataProvider(name = "getFactorialDataKeyValue", parallel = true)
    public static Object[][] getFactorialDataKeyValue() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {18, 6402373705728000L}
        };
    }

    @Test(testName = "Параметризованный тест факториала (для пар показателя и значения факториала)",
            dataProvider = "getFactorialDataKeyValue", threadPoolSize = 5, invocationCount = 2)
    public void isFactorial_Csv_ParameterizedTest(long number, long fact){
        final Thread thread = Thread.currentThread();
        System.out.printf("#%d: %s, %d\n", thread.getId(), thread.getName(), fact);

        assertEquals(fact, Factorial.factorial(number));
    }

}