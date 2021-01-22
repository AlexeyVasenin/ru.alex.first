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
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static final String NAME_FOLDER = "depositor";
    private static final String DIRECTORY = "src/main/resources/";
    private static final String FILE_NAME_CSV = "depositor.csv";
    private static final String FILE_NAME_TXT = "depositor.txt";

    private void creatingFolder() throws IOException {
        Files.createDirectories(Paths.get(DIRECTORY + NAME_FOLDER));
    }

    public void dataReadToWriteCsv() throws IOException {
        creatingFolder();

        List<Depositor> listman = new ArrayList<>();


        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DIRECTORY + FILE_NAME_TXT))) {

            String depositorData = reader.readLine();

            while (depositorData != null) {
                String[] strings = depositorData.split(",");
                depositorData = reader.readLine();
                listman.add(new Depositor(strings[0],
                        Integer.parseInt(strings[1]),
                        Integer.parseInt(strings[2]), strings[3]));

            }

            CSVWriter writer =
                    new CSVWriter(new FileWriter(DIRECTORY + NAME_FOLDER +"/"+ FILE_NAME_CSV));

            ColumnPositionMappingStrategy mappingStrategy =
                    new ColumnPositionMappingStrategy();
            mappingStrategy.setType(Depositor.class);

            StatefulBeanToCsvBuilder<Depositor> builder =
                    new StatefulBeanToCsvBuilder<Depositor>(writer);
            StatefulBeanToCsv beanToCsv =
                    builder.withMappingStrategy(mappingStrategy).build();
            beanToCsv.write(listman);


//            CsvToBean<Depositor> csvReader =
//                    new CsvToBeanBuilder<Depositor>(reader)
//                            .withType(Depositor.class)
//                            .withSeparator(',')
//                            .withIgnoreLeadingWhiteSpace(true)
//                            .withIgnoreEmptyLine(true)
//                            .build();
//
//            listman = csvReader.parse();
//        }


        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }


    }
}


//


