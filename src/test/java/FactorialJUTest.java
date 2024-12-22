
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FactorialJUTest {
    public static long factorialCalculation(int number) {
        // Факториал работает на Long, чтобы протестировать граничные значения/переполнение. Факториал не может высчитываться из входного числа больше, чем 20 (и отрицательного числа)
        long f = 1;
        // Обработка некорректного числа, швыряем ошибку
        if (number < 0) {
            throw new IllegalArgumentException("Факториал не может быть вычислен из отрицательного числа");
        } else if (number > 20){
            throw new IllegalArgumentException("Факториал не может быть вычислен из числа больше, чем 20");
        //Формула факториала
        } else {
            for (int i = 1; i <= number; i++) {
                f *= i;
            }
            return f;
        }
    }

    // ТЕСТЫ:
    @BeforeAll
    public static void welcomeText() {
        System.out.println("Тесты начинаются");
    }
    @Tag("Factorial")
    @Test
    @DisplayName("Тест факториала из 0")
    public void zeroFactorialTest() {
        assertEquals(1, FactorialJUTest.factorialCalculation(0), "Ошибка вычисления факториала из 0");
        System.out.println("Успешно. Факториал 0 равен 1");
    }

    @Tag("Factorial")
    @Test
    @Disabled // Выключил. Ниже тесты всех этих значений через параметризацию
    @DisplayName("Тест некоторых значений")
    public void someArgumentsFactorialTest() {
        assertEquals(1, FactorialJUTest.factorialCalculation(1), "Ошибка вычисления факториала");
        assertEquals(120, FactorialJUTest.factorialCalculation(5), "Ошибка вычисления факториала");
        assertEquals(3628800, FactorialJUTest.factorialCalculation(10), "Ошибка вычисления факториала");
    }

    @Tag("Factorial")
    @RepeatedTest(3) // Тестирование прогона
    @DisplayName("Обработка ошибок недопустимых значений. 3 прогона.")
    public void intLimitValuesFactorialTest() {
        assertEquals(2432902008176640000L, FactorialJUTest.factorialCalculation(20));
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> FactorialJUTest.factorialCalculation(-1));
        assertEquals("Факториал не может быть вычислен из отрицательного числа", exception1.getMessage());

        System.out.println("Ошибка обработана верно. Отрицательное число для вычисления недопустимо.");

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> FactorialJUTest.factorialCalculation(25));
        assertEquals("Факториал не может быть вычислен из числа больше, чем 20", exception2.getMessage());

        System.out.println("Ошибка обработана верно. Число больше 20 для вычисления на long недопустимо.");
    }

    @Tag("Factorial")
    @Timeout(1)
    @DisplayName("Параметризованный тест для всех корректных значений факториала")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800",
            "11, 39916800",
            "12, 479001600",
            "13, 6227020800",
            "14, 87178291200",
            "15, 1307674368000",
            "16, 209227898880001", // Нарочная ошибка
            "17, 355687428096000",
            "18, 6402373705728000",
            "19, 121645100408832000",
            "20, 2432902008176640000"
            })

    public void allCorrectValuesOfFactorialTest(int number, long expected){
        assertEquals(expected, factorialCalculation(number), "Ошибка вычисления факториала для числа " + number);
        System.out.println("Число " + number + " успешно.");
    }

    @AfterAll
    public static void byeText() {
        System.out.println("Тесты закончены");
    }
}
