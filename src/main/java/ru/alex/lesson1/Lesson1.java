package ru.alex.lesson1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lesson1 {

    private static final Logger log = LogManager.getLogger(Lesson1.class);

    public void lesson1() {

        //Строковые переменные a & b
        String a = "Hello";
        String b = "World!";

        //Сложение строк
        String ab = a + " " + b;

        //Вывод переменной ab
        log.info(ab);

        //Сложение строк через StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ").append(b);

        //Вывод текста из перемменной sb
        log.info(sb.toString());

        //Сравнение через equals
        log.info(ab.equals(sb));

        //Переменные float и double
        float x = 3.1f;
        float y = 3.1f;
        float result1 = multiply(x, y);
        double x1 = 3.1;
        double y1 = 3.1;
        double result2 = multiply(x1, y1);

        //Результаты методов
        log.info(result1);
        log.info(result2);

        //Сравениен результатов через equals.
        log.info(equals(result1, result2));
    }

    //Метод Float
    private static Float multiply(float x, float y) {
        return x * y;
    }

    //Метод Double
    private static Double multiply(double x1, double y1) {
        return x1 * y1;
    }

    //Метод сравнения equals
    public static Boolean equals(float x, double y) {
        return x == y;
    }
}
