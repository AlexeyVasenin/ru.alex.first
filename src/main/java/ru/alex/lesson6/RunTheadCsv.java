package ru.alex.lesson6;


public class RunTheadCsv {
    public static void main(String[] args)

    {

        for (int i = 0; i < 3; i++) {
            MyThreadWriteCsv myThreadWriteCsv = new MyThreadWriteCsv();
            myThreadWriteCsv.start();

        }
    }
}
