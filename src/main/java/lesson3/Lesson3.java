package lesson3;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Lesson3 {

    private static final Scanner input = new Scanner(System.in);
    String NAME_FOLDER = "test_csv";
    String DIRECTORY = "test_csv/";
    String NAME_FILE_CSV = "Csv.csv";
    int n;

    public void creatingFolder() {
        File folder = new File(NAME_FOLDER);
        folder.mkdir();
    }

    public void checkedAndDeleteFileCsv() {
        boolean fileCsv = new File(DIRECTORY + NAME_FILE_CSV).isFile();

        if (fileCsv) {
            new File(DIRECTORY + NAME_FILE_CSV).delete();
        } else {
            System.out.println("Файл не существует");
        }
    }

    public void fileWriteCsv() throws Exception {
        CSVWriter write;
        write = new CSVWriter(new FileWriter(DIRECTORY + NAME_FILE_CSV)
                , ';');

        Map<Integer, String> theRows = new HashMap<>();

        Random numRandom = new Random();

        System.out.println("Введите число строк");

        while (true) {
            try {
                n = Integer.parseInt(input.nextLine());
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

        for (int i = 0; i < n; i++) {

            String value = Integer.toString(numRandom.nextInt(n));

            if (value.equals("0")) {
                theRows.put(i, null);
            } else {
                theRows.put(i, value);
            }
        }

        System.out.println("Test map write to csv");

        for (Map.Entry<Integer, String> row : theRows.entrySet()) {
            System.out.println(row.getKey() + " => " + row.getValue());
        }

        for (Map.Entry<Integer, String> row : theRows.entrySet()) {
            write.writeNext(new String[]{Integer.toString(row.getKey()),
                    row.getValue()});
        }

        write.close();
    }

    public void fileReadCsv() throws Exception {
        File fileCsv = new File(DIRECTORY + NAME_FILE_CSV);
        CSVReader reader = new CSVReader(new FileReader(fileCsv), ';');

        Map<Integer, Integer> result = new HashMap<>();
        for (String[] row : reader.readAll()) {
            try {
                result.put(Integer.parseInt(row[0]), Integer.parseInt(row[1]));
            } catch (NumberFormatException e) {
                //                e.printStackTrace();
                result.put(Integer.parseInt(row[0]), 0);
            }
        }

        System.out.println("Test map write from csv file");

        for (Map.Entry<Integer, Integer> print : result.entrySet()) {

            System.out.println(print.getKey() + " => " + print.getValue());
        }

        reader.close();

        Integer[] counter = new Integer[n];

        //        for (int i = 0; i < numbers.length; i++) {
        //            counter[numbers[i]]++;
        //
        //        }
        //
        //        System.out.println("value\tcount");
        //
        //        for (int i = 0; i < counter.length; i++) {
        //            System.out.println(i + "\t" + counter[i]);
        //        }
    }
}