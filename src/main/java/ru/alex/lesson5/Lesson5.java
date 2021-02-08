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

import static java.util.Comparator.comparing;

public class Lesson5 {

    private static final String DIRECTORY = "src/main/resources/depositor/";
    private static final String FILE_NAME_CSV = "depositor.csv";
    private static final String FILE_NAME_TXT = "depositor.txt";

    private void creatingFolder() throws IOException {
        Files.createDirectories(Paths.get(DIRECTORY));
    }

    public void dataReadToWriteCsv() throws IOException {

        creatingFolder();

        List<Depositor> listMan = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DIRECTORY + FILE_NAME_TXT));
             CSVWriter writer =
                     new CSVWriter(new FileWriter(DIRECTORY + FILE_NAME_CSV))) {

            String depositorData = reader.readLine();
            Integer id = 1;

            while (depositorData != null) {
                String[] strings = depositorData.split(",");
                listMan.add(new Depositor(strings[0],
                        Integer.parseInt(strings[1]),
                        Integer.parseInt(strings[2]),
                        Integer.parseInt(strings[3]),
                        id));
                depositorData = reader.readLine();
                id++;
            }

            String[] column = new String[]{"id", "name", "accountNumber",
                    "amount", "age"};

            ColumnPositionMappingStrategy<Depositor> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(Depositor.class);

            mappingStrategy.setColumnMapping(column);

            StatefulBeanToCsvBuilder<Depositor> builder =
                    new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Depositor> beanToCsv =
                    builder
                            .withMappingStrategy(mappingStrategy)
                            .build();

            beanToCsv.write(listMan);

        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    public void readCsvToShow() throws FileNotFoundException {

        String[] column = new String[]{"id", "name", "accountNumber",
                "amount", "age"};

        ColumnPositionMappingStrategy<Depositor> mappingStrategy =
                new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Depositor.class);

        mappingStrategy.setColumnMapping(column);

        List<Depositor> beans;

        beans = new CsvToBeanBuilder(new FileReader(DIRECTORY + FILE_NAME_CSV))
                .withMappingStrategy(mappingStrategy)
                .build()
                .parse();

        beans.sort(comparing(Depositor::getAge));

        for (Depositor i : beans) {
            System.out.println(i);

        }
    }
}