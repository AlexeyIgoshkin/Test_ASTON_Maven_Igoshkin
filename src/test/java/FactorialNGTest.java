import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class FactorialNGTest {
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
    @BeforeTest
    public static void welcomeText() {
        System.out.println("Тесты начинаются");
    }

    // Тест факториала из нуля
    @Test (groups = {"Factorial"}, description = "Тест факториала из 0")
    public void zeroFactorialTest() {
        assertEquals(FactorialNGTest.factorialCalculation(0), 1, "Ошибка вычисления факториала из 0");
        System.out.println("Успешно. Факториал 0 равен 1");
    }

    // Выключен. Все значения тестируются ниже через DataProvider
    @Test(enabled = false, description = "Тест некоторых значений")
    public void someArgumentsFactorialTest() {
        assertEquals(FactorialNGTest.factorialCalculation(1), 1, "Ошибка вычисления факториала");
        assertEquals(FactorialNGTest.factorialCalculation(5), 120, "Ошибка вычисления факториала");
        assertEquals(FactorialNGTest.factorialCalculation(10), 3628800, "Ошибка вычисления факториала");
    }

    // Тесты на корректную обработку ошибок
    @Test (groups = {"Factorial"}, description = "Обработка ошибок недопустимых значений. 3 прогона.", invocationCount = 3)
    public void intLimitValuesFactorialTest() {

        try {
            FactorialNGTest.factorialCalculation(-1);
        } catch (IllegalArgumentException exception1) {
            assertEquals(exception1.getMessage(), "Факториал не может быть вычислен из отрицательного числа");
        }
        System.out.println("Ошибка обработана верно. Отрицательное число для вычисления недопустимо.");
        try {
            FactorialNGTest.factorialCalculation(25);
        } catch (IllegalArgumentException exception2) {
            assertEquals(exception2.getMessage(), "Факториал не может быть вычислен из числа больше, чем 20");
        }
        System.out.println("Ошибка обработана верно. Число больше 20 для вычисления на long недопустимо.");
    }

    //Данные для возможных корректных значений
    @DataProvider
    public Object [][] numbersData (){
        return new Object [][] {
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720},
                {7, 5040},
                {8, 40320},
                {9, 362880},
                {10, 3628800},
                {11, 39916800},
                {12, 479001600},
                {13, 6227020800L},
                {14, 87178291200L},
                {15, 1307674368000L},
                {16, 209227898880001L}, // Нарочная ошибка
                {17, 355687428096000L},
                {18, 6402373705728000L},
                {19, 121645100408832000L},
                {20, 2432902008176640000L}
        };
    }
    //Метод проходит через все значения выше
    @Test (groups = {"Factorial"}, description = "Параметризованный тест для всех корректных значений факториала", dataProvider = "numbersData")
    public void allCorrectValuesOfFactorialTest(int number, long expected){
        assertEquals(factorialCalculation(number), expected, "Ошибка вычисления факториала для числа " + number);
        System.out.println("Число " + number + " успешно.");
    }

    @AfterTest
        public static void byeText() {
            System.out.println("Тесты закончены");
    }
}
