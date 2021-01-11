package ru.alex.lesson5;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lesson5 {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static final String NAME_FOLDER = "depositor";
    private static final String DIRECTORY = "src/main/resources/";
    private static final String FILE_NAME_CSV = "depositor.csv";
    private static final String FILE_NAME_TXT = "depositor.txt";

    private void creatingFolder() throws IOException
    {
        Files.createDirectories(Paths.get(DIRECTORY + NAME_FOLDER));
    }

    public void dataReadToWriteCsv() throws IOException
    {
        creatingFolder();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DIRECTORY + FILE_NAME_TXT));
             CSVWriter writer =
                     new CSVWriter(new FileWriter(DIRECTORY + NAME_FOLDER +
                             "/" +
                             FILE_NAME_CSV))) {

            String depositorData = reader.readLine();

            while (depositorData != null) {
                String[] strings = depositorData.split(",");
                writer.writeNext(strings);
                depositorData = reader.readLine();
            }
        }
    }

//        CsvToBean<Depositor> csvReader =
//                new CsvToBeanBuilder<Depositor>(reader)
//                        .withType(Depositor.class)
//                        .withSeparator(',')
//                        .withIgnoreLeadingWhiteSpace(true)
//                        .withIgnoreEmptyLine(true)
//                        .build();
//
//        List<Depositor> results = csvReader.parse();
}


