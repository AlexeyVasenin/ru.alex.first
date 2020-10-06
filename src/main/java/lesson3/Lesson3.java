package lesson3;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Lesson3 {

    private static final Scanner input = new Scanner(System.in);
    private static final String NAME_FOLDER = "test_csv";
    private static final String DIRECTORY = "test_csv/";
    private static final String NAME_FILE_CSV = "Csv.csv";
    private static int n;

    public void creatingFolder()
    {
        File folder = new File(NAME_FOLDER);
        folder.mkdir();
    }

    public void checkedAndDeleteFileCsv()
    {
        boolean fileCsv = new File(DIRECTORY + NAME_FILE_CSV).isFile();

        if (fileCsv) {
            new File(DIRECTORY + NAME_FILE_CSV).delete();
        } else {
            System.out.println("Файл не существует");
        }
    }

    private void enteringTheNumberLine()
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

    public void fileWriteCsv() throws IOException
    {
        try (CSVWriter write =
                     new CSVWriter(new FileWriter(DIRECTORY + NAME_FILE_CSV)
                             , ';')) {

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
        }
    }

    public void fileReadCsv() throws IOException
    {
        Map<Integer, Integer> repeat = new HashMap<>();

        File fileCsv = new File(DIRECTORY + NAME_FILE_CSV);

        try (CSVReader reader = new CSVReader(new FileReader(fileCsv), ';')) {
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
        }

        System.out.println("\nВывод число повторений\n");

        for (Integer key : repeat.keySet()) {
            System.out.println("Значение #" + key + " повторяется");
            System.out.println(repeat.get(key));
        }
    }
}