package ru.alex.lesson3;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Lesson3 {

    private static final Logger log = LogManager.getLogger(Lesson3.class);
    private static final Scanner input = new Scanner(System.in);
    private static final String DIRECTORY = "src/main/resources/test_csv/";
    private static final String NAME_FILE_CSV = "Csv.csv";
    private int n;

    public void creatingFolder() throws IOException {
        log.info("Создание папки для хранения файлт");

        Files.createDirectories(Paths.get(DIRECTORY));
    }

    public void checkedAndDeleteFileCsv() throws IOException {
        log.info("Удаление файлов *.csv");

        Files.deleteIfExists(Paths.get(DIRECTORY + NAME_FILE_CSV));
    }

    private void enteringTheNumberLine() {
        log.info("Введите число от 0 до оо");

        while (true) {
            try {
                n = parseInt(input.nextLine());
                if (n == 0 || n < 0) {
                    System.exit(0);
                } else break;
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
                log.error("Вы ввели не число, повторите ввод");
            }
        }
        log.info("Вы ввели число {}", n);
    }

    public void fileWriteCsv() throws IOException {
        try (CSVWriter write =
                     new CSVWriter(new FileWriter(DIRECTORY + NAME_FILE_CSV))) {

            Random numRandom = SecureRandom.getInstanceStrong();

            enteringTheNumberLine();

            for (int i = 0; i < n; i++) {
                write.flush();

                Map<String, String> theRows = new LinkedHashMap<>();
                String value = Integer.toString(numRandom.nextInt(n));

                if (value.equals("0")) {
                    theRows.put(Integer.toString(i), null);
                } else {
                    theRows.put(Integer.toString(i), value);
                }

                for (Map.Entry<String, String> row : theRows.entrySet()) {
                    write.writeNext(new String[]{row.getKey(), row.getValue()});
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error(e);
        }
    }

    public void fileReadCsv() throws IOException {
        Map<Integer, Integer> repeat = new HashMap<>();

        File fileCsv = new File(DIRECTORY + NAME_FILE_CSV);

        try (CSVReader reader = new CSVReader(new FileReader(fileCsv))) {
            for (String[] row : reader.readAll()) {

                if (row[1].equals("")) {
                    row[1] = "0";
                }
                if (repeat.containsKey(parseInt(row[1]))) {
                    repeat.put(parseInt(row[1]),
                            repeat.get(parseInt(row[1])) + 1);
                } else {
                    repeat.put(parseInt(row[1]), 1);
                }
            }
        } catch (CsvException e) {
            e.printStackTrace();
            log.error(e);
        }

        log.info("Вывод число повторений\n");

        for (Map.Entry<Integer, Integer> key : repeat.entrySet()) {
            log.info("Значение #{}", key.getKey() + " повторяется");
            log.info(repeat.get(key.getKey()));
        }
    }
}