package ru.alex.lesson5;

import java.io.IOException;

public class RunReadLstDepositor {
    public static void main(String[] args) throws IOException {
        Lesson5 les5 = new Lesson5();
        les5.dataReadToWriteCsv();
        les5.readCsvToShow();
    }
}
