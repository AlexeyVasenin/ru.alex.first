package Lesson1;

public class Lesson1 {
    public static void main(String[] args) {


        //TODO(готово) сделай так что перед выводом строки, собрать эту строку в переменну (со StringBuilder не надо), передать в метод equals для сравнения
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

        //TODO(готово) Посмотри что возвращает метод append (ctrl+ПКМ по append) он возвращает StringBuilder, а вывести ты пытаешься String
        //TODO(готово) нужно сделать с.append("World!").toString()
        //TODO(готово) но тебе нужно сначала из String a = "Hello" и String b = "World" составить в StringBuilder предложение, потом выводить

        c.append(a);
        c.append(" ");
        c.append(b);
        System.out.println(c.toString());

        //Сравнение через equals
        System.out.println(ab.equals(c));

        //TODO(готово) используй переменные типа float и double, методы так же возвращают результаты, результаты передавай в result
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

        //TODO не понял как передать результаты в "result"
        //TODO (Ответ) result это переменная, которая принимает знчение из метода (Пример: float result = multiply(x, y))
        //Сравениен результатов через equals.
        System.out.println(equals(result1, result2));


    }

    //TODO по поводу названия методов почитай про перегрузку методов, очень полезная штука
    //TODO (Правка) почитал по перегрузку методов, изменил название
    //Метод Float
    private static Float multiply(float x, float y) {
        return x * y;

    }

    //Метод Double
    private static Double multiply(double x1, double y1) {
        return x1 * y1;
    }


    //Метод сравнения equals
    //TODO(готово) (Ответ) Нет. Метод должен принимать 2 числа, возвращать tru или false, используй ветвление if(){}else{}
    //TODO у тебя здесь должно быть сравнение, равны ли они или нет. В возвращат тебе лучше значение не boolean, а Boolean
    public static Boolean equals(float x, double y) {
        if (x == y) {
            return true;
        } else {
            return false;
        }

    }
}
