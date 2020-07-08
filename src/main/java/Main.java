public class Main {
    public static void main(String[] args) {

        //Сложение сторок
        String a = "Hello ";
        String b = "World!";
        System.out.println(a + b);

//      Слодение строк через StringBuilder
        StringBuilder c = new StringBuilder(a);
//      System.out.println(c.append("World!"));
        System.out.println(c.insert(6, "World!"));

        //Результаты методов
        System.out.println(multiply(3.1f, 3.1f));
        System.out.println(multiply2(3.1, 3.1));
        System.out.println(result());

        //Сравениен результатов?!

    }

    //Метод Float
    private static Float multiply(float x, float y) {
        return x * y;

    }

    //Метод Double
    private static Double multiply2(double x, double y) {
        return x * y;
    }

    //Метод сравнение
    private static Boolean result() {
        return multiply(2.1f, 2.1f) >= multiply2(2.1, 2.1);
    }


}
