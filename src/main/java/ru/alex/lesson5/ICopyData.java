package ru.alex.lesson5;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.util.Comparator.comparing;

public interface ICopyData {

    void creatingFolder() throws IOException;

    boolean checkData(String i);

    void dataFileRead() throws IOException;

    void beanToCsv();

    void readCsvToShow() throws FileNotFoundException;

    void sortClient();

    void run() throws IOException;
}
