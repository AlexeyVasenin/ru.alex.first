package ru.alex.lesson6;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyThreadWriteCsv extends Thread {


    private static final Scanner input = new Scanner(System.in);
    private static final String DIRECTORY = "src/main/resources/test_csv/";
    private static final String NAME_FILE_CSV = "Csv";
    private int n;

    public void creatingFolder() throws IOException
    {
        Files.createDirectories(Paths.get(DIRECTORY));
    }

    public void checkedAndDeleteFileCsv() throws IOException
    {
        Files.deleteIfExists(Paths.get(DIRECTORY + NAME_FILE_CSV));
    }

    public void enteringTheNumberLine()
    {
        System.out.println("Введите число строк");

        while (true) {
            try {
                n = parseInt(input.nextLine());
                if (n == 0) {
                    return;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число, повторите ввод");
            }
        }
    }

    @Override
    public void run()
    {
        try (CSVWriter write =
                     new CSVWriter(new FileWriter(DIRECTORY +
                             getName() + ".csv"))) {

            Random numRandom = SecureRandom.getInstanceStrong();

            for (int i = 0; i < 100000; i++) {

                write.flush();

                Map<String, String> theRows = new LinkedHashMap<>();

                String value = Integer.toString(numRandom.nextInt(100000));

                if (value.equals("0")) {
                    theRows.put(Integer.toString(i), null);
                } else {
                    theRows.put(Integer.toString(i), value);
                }

                for (Map.Entry<String, String> row : theRows.entrySet()) {
                    write.writeNext(new String[]{row.getKey(), row.getValue()});
                }
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

    }
}
