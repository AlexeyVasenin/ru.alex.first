package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main4 {

    private static final BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static double x;

    //TODO: У тебя функция бесконечно убывающая от 1 до 0, как точность может
    // быть >=1?
    private static void inputNumberToPower()
    {
        System.out.println("Введите число членов разложения от 2 до ∞");
        while (true) {
            try {
                n = Integer.parseInt(in.readLine());
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число или число дробное, " +
                        "введите повторно число от 2 до ∞");
            }
        }

    }

    private static void inputNumberToValue()
    {
        System.out.println("Введите значение x больше -1 до 1 включительно");
        while (true) {
            try {
                x = Double.parseDouble(in.readLine());
                //TODO: какое условие сходимости ряда?
                // TODO: 01.10.2020 Сделл условия
                if (x > 1 || x <= -1) {
                    throw new Exception("Вы введи число больше 1 или меньше " +
                            "и равное -1 повторите ввод"); // TODO: 30.0.2020 Сделал вызов ошибки
                    //TODO: сделай выозов ошибки. (throw new Exception()) с
                    // описанием ошибки и выведи это описание
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Повторите ввод число больше -1 или меньше" +
                        "и равное 1");
            }
        }
    }

    //TODO: n-константа и n-как параметр метода?
    //TODO: Не понятно по имени метода за что отвечает метод

    // TODO: 30.09.2020 Изменил имя метода
    // TODO: 01.10.2020 Изменил имя переменной с "n" -> "k"
    private static double RecursiveOfCalcTheFuncLn(int k) throws IOException
    {
        if (k == 1) {
            return (x);
        }
        //TODO: Почему нельзя присвоить значение сразу переменной?
        //TODO: Почему нельзя сразу вернуть result?
        return RecursiveOfCalcTheFuncLn(k - 1) - ((Math.pow(-1, k) * Math.pow(x, k)) / k); // TODO: 30.09.2020 Сократил код
    }

    //TODO: n-константа и n-как параметр метода?
    //TODO: Не понятно по имени метода за что отвечает метод

    // TODO: 01.10.2020 Изменил имя метода
    private static double CycleOfCalcTheFuncLn()
    {
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result -= (float) ((Math.pow(-1, i) * Math.pow(x, i)) / i);
        }

        return result;
    }

    //TODO: Не верное решение
    public static void main(String[] args) throws IOException
    {
        System.out.println("Программа для вычисления функции Ln(1+x)=... \n");
        inputNumberToPower();
        inputNumberToValue();
        //TODO: Зачем n используешь как константу?
        System.out.println("Result recursive func Ln(1+x) \n" + RecursiveOfCalcTheFuncLn(n));
        System.out.println("\nResult cycle func Ln(1+x) \n" + CycleOfCalcTheFuncLn());
    }
}
