package ru.alex.lesson1;

public class Lesson1 {
    public void lesson1() {
        //Сложение сторок

        //Переменные
        String a = "Hello";
        String b = "World!";

        //Результирующая переменная
        String ab = a + " " + b;

        //Вывод
        System.out.println(ab);

        //Сложение строк через StringBuilder
        StringBuilder c = new StringBuilder();
        c.append(a).append(" ").append(b);

        System.out.println(c.toString());

        //Сравнение через equals
        System.out.println(ab.equals(c));

        //Переменные float и double
        float x = 3.1f;
        float y = 3.1f;
        float result1 = multiply(x, y);
        double x1 = 3.1;
        double y1 = 3.1;
        double result2 = multiply(x1, y1);

        //Результаты методов
        System.out.println(result1);
        System.out.println(result2);

        //Сравениен результатов через equals.
        System.out.println(equals(result1, result2));

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
