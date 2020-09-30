package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main4 {
    private static final BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static float value;

    //TODO: У тебя функция бесконечно убывающая от 1 до 0, как точность может быть >=1?
    private static void inputNumberToPower() {
        System.out.println("Введите степень точности от 1 до ∞");
        while (true) {
            try {
                n = Integer.parseInt(in.readLine());
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число или число дробное, " +
                        "введите повторно число от 1 до ∞");
            }
        }
    }

    private static void inputNumberToValue()
    {
        System.out.println("Введите число меньше 1");
        while (true) {
            try {
                value = Float.parseFloat(in.readLine());
                //TODO: какое условие сходимости ряда?
                if (value >= 1) {
                    //TODO: сделай выозов ошибки. (throw new Exception()) с описанием ошибки и выведи это описание
                    System.out.println("Вы введи число больше или равное 1 " +
                            "повторите " +
                            "ввод число меньше 1");
                    value = Float.parseFloat(in.readLine());
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число" +
                        "введите повторно число от 1 до ∞");
            }
        }
    }

    //TODO: n-константа и n-как параметр метода?
    //TODO: Не понятно по имени метода за что отвечает метод
    private static float func(int n) throws IOException {
        float x = value;
        if (n == 1) {
            return (-x);
        }

        //TODO: Почему нельзя присвоить значение сразу переменной?
        float result;
        result = (float) (func(n - 1) - ((Math.pow(-1, n) * Math.pow(-x, n)) / n));
        //TODO: Почему нельзя сразу вернуть result?
        return result;
    }

    //TODO: n-константа и n-как параметр метода?
    //TODO: Не понятно по имени метода за что отвечает метод
    private static float func1(int n) {
        float x = value;
        float result = 0;

        for (int i = 1; i <= n; i++) {
            result -= (float) ((Math.pow(-1, i) * Math.pow(-x, i)) / i);
        }

        return (result);
    }

    //TODO: Не верное решение
    public static void main(String[] args) throws IOException {
        inputNumberToPower();
        inputNumberToValue();
        //TODO: Зачем n используешь как константу?
        System.out.println("Result recursive func \n" + func(n));
        System.out.println("\n Result cycle func1 \n" + func1(n));
    }
}
