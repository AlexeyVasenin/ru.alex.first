public class Main {
    public static void main(String[] args) {


        //TODO сделай так что перед выводом строки, собрать эту строку в переменну (со StringBuilder не надо), передать в метод equals для сравнения
        //Сложение сторок
        String a = "Hello";
        String b = "World!";
        System.out.println(a + " " + b);

//      Слодение строк через StringBuilder
        StringBuilder c = new StringBuilder();

        //TODO Посмотри что возвращает метод append (ctrl+ПКМ по append) он возвращает StringBuilder, а вывести ты пытаешься String
        //TODO нужно сделать с.append("World!").toString()
        //TODO но тебе нужно сначала из String a = "Hello" и String b = "World" составить в StringBuilder предложение, потом выводить

        c.append(a);
        c.append(" ");
        c.append(b);
        System.out.println(c.toString());


        //TODO используй переменные типа float и double, методы так же возвращают результаты, результаты передавай в result
        //Переменные float и double
        float x = 3.1f;
        float y = 3.1f;
        double x1 = 3.1;
        double y1 = 3.1;
        //Результаты методов
        System.out.println(multiply(x, y));
        System.out.println(multiply2(x1, y1));

        //TODO не понял как передать результаты в "result"
        //TODO (Ответ) result это переменная, которая принимает знчение из метода (Пример: float result = multiply(x, y))
        System.out.println(result());

        //Сравениен результатов через equals.
        //...
    }

    //TODO по поводу названия методов почитай про перегрузку методов, очень полезная штука
    //Метод Float
    private static Float multiply(float x, float y) {
        return x * y;

    }

    //Метод Double
    private static Double multiply2(double x1, double y1) {
        return x1 * y1;
    }

    //TODO осомтри библеотеку Math там есть метод equals сделай ещё 1 метод с ним
    //Метод сравнение Boolean
    private static Boolean result() {
        return false;
    }

    //Метод сравнения equals
    //TODO Я так понимаю в таком виде должен быть реализован метод equals?!
    //TODO (Ответ) Нет. Метод должен принимать 2 числа, возвращать tru или false, используй ветвление if(){}else{}
    //TODO @Override тебе сейчас не нужен. Удали этот метод.
//    @Override
//    public boolean equals(Object obj) {
//
//    }
}
