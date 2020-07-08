public class Main {
    public static void main(String[] args) {

        //Сложение сторок
        String a = "Hello ";
        String b = "World!";
        System.out.println(a + b);

//      Слодение строк через StringBuilder
        StringBuilder c = new StringBuilder(a);
        //TODO Посмотри что возвращает метод append (ctrl+ПКМ по append) он возвращает StringBuilder, а вывести ты пытаешься String
        //TODO нужно сделать с.append("World!").toString()
        //TODO но тебе нужно сначала из String a = "Hello" и String b = "World" составить в StringBuilder предложение, потом выводить
      System.out.println(c.append("World!"));
        System.out.println(c.insert(6, "World!"));

        //Результаты методов
        //TODO используй переменные типа float и double, методы так же возвращают результаты, результаты передавай в result
        System.out.println(multiply(3.1f, 3.1f));
        System.out.println(multiply2(3.1, 3.1));
        System.out.println(result());

        //Сравениен результатов?!

    }
//TODO по поводу названия методов почитай про перегрузку методов, очень полезная штука
    //Метод Float
    private static Float multiply(float x, float y) {
        return x * y;

    }

    //Метод Double
    private static Double multiply2(double x, double y) {
        return x * y;
    }
//TODO посомтри библеотеку Math там есть метод equals сделай ещё 1 метод с ним
    //Метод сравнение
    private static Boolean result() {
        return multiply(2.1f, 2.1f) >= multiply2(2.1, 2.1);
    }


}
