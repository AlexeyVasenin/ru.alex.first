public class Main {
    public static void main(String[] args) {

        //Сложение сторок
        String a = "Hello ";
        String b = "World!";
        System.out.println(a + b);

        StringBuilder c = new StringBuilder(a);
//        System.out.println(c.append("df"));
        System.out.println(c.insert(6, "World!"));


        //Результаты методов
        System.out.println(multiply(3.1f, 3.1f));
        System.out.println(multiply2(3.1, 3.1));

        //Сравениен результатов

    }

    // Метод Float
    private static Float multiply(float x, float y) {
        return x * y;
    }

    //Метод Double
    private static Double multiply2(double x, double y) {
        return x * y;
    }


}
