package ru.alex.lesson5;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lesson5 {

    private static final String DIRECTORY = "src/main/resources/depositor";
    private static final String FILE_NAME_CSV = "depositor.csv";
    private static final String FILE_NAME_TXT = "depositor.txt";

    private void creatingFolder() throws IOException
    {
        Files.createDirectories(Paths.get(DIRECTORY));
    }

    public void dataReadToWriteCsv() throws IOException
    {
        creatingFolder();

        List<Depositor> listman = new ArrayList<>();

        CSVWriter writer = new CSVWriter(
                new FileWriter(DIRECTORY + "/" + FILE_NAME_CSV));

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DIRECTORY + "/" + FILE_NAME_TXT))) {

            String depositorData = reader.readLine();

            while (depositorData != null) {
                String[] strings = depositorData.split(",");
                depositorData = reader.readLine();
                listman.add(new Depositor(strings[0],
                        Integer.parseInt(strings[1]),
                        Integer.parseInt(strings[2]),
                        Integer.parseInt(strings[3])));
            }

            System.out.println(listman);

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_ESCAPE_CHARACTER)
                    .build();
            beanToCsv.write(listman);

        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}


//


