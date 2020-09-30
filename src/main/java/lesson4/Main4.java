package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main4 {
    private static final BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static float value;

    private static void inputNumberToPower()
    {
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
                if (value >= 1) {
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

    private static float func(int n) throws IOException
    {
        float x = value;
        if (n == 1) {
            return (-x);
        }

        float result;
        result =
                (float) (func(n - 1) - ((Math.pow(-1, n) * Math.pow(-x, n)) / n));

        return result;
    }

    public static void main(String[] args) throws IOException
    {
        inputNumberToPower();
        inputNumberToValue();
        System.out.println("Result \n" + func(n));
    }
}
