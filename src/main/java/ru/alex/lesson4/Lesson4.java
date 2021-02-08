package ru.alex.lesson4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;

public class Lesson4 {

    private static final BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
    private static double accuracy; // сalculation accuracy specified by the
    // user
    private static double x; // "x" value in function Ln(1+x)=...

    private static final Logger log = LogManager.getLogger(Lesson4.class);


    private static void inputNumberToPower() {
        log.info("Введите степень точности \"accuracy\" не более 0" +
                ".1");

        while (true) {
            try {
                accuracy = Double.parseDouble(in.readLine());
                if (accuracy >= 0.1 || accuracy == 0) {
                    throw new IOException("Введеное число не удовлетворяет " +
                            "требованию, повторите ввод");
                } else break;
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
                log.info("Повторите ввод, число должно быть в " +
                        "пределах 0 < accuracy <= 0.1");
            }
        }
    }

    private static void inputNumberToValue() {
        log.info("Введите значение \"x\" больше -1 до 1 ");

        while (true) {
            try {
                x = Double.parseDouble(in.readLine());
                if (x >= 1 || x <= -1) {
                    throw new IOException("Введеное число не удовлетворяет " +
                            "требованию, повторите ввод");
                } else break;
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
                log.info("Вводимое число должно удовлетворять " +
                        "требованию -1 < x < 1");
            }
        }
    }

    private static double recursiveCalcFuncLn(int n) {
        double result = ((Math.pow(-1, n) * Math.pow(x, n)) / n);

        if (abs(result) > accuracy) {

            result = recursiveCalcFuncLn(n + 1) - result;

        }
        return result;
    }

    private static double cycleFuncCalcLn(int n) {
        double result = 0;
        double i;
        do {
            i = ((Math.pow(-1, n) * Math.pow(x, n)) / n);
            result -= i;
            n++;
        } while (abs(i) > accuracy);
        return result;
    }

    public void calcRun() {
        log.info("Программа для вычисления функции Ln(1+x)=...\n");

        inputNumberToPower();
        inputNumberToValue();

        log.info("\nResult recursive func Ln(1+x)\n {}",
                recursiveCalcFuncLn(1));
        log.info("\nResult cycle func Ln(1+x)\n {}",
                cycleFuncCalcLn(1));
    }
}
