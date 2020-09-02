package lesson3;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class Lesson3 {

    private static final Scanner input = new Scanner(System.in);
    private static final String NAME_FOLDER = "test_csv";
    private static final String DIRECTORY = "test_csv/";
    private static final String NAME_FILE_CSV = "Csv.csv";
    private static int n;

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

    public void enteringTheNumberLine() {
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
    }

    public void fileWriteCsv() throws Exception {
        CSVWriter write;
        write = new CSVWriter(new FileWriter(DIRECTORY + NAME_FILE_CSV)
                , ';');

        Map<String, String> theRows = new HashMap<>();

        Random numRandom = new Random();

        enteringTheNumberLine();

        for (int i = 0; i < n; i++) {

            String value = Integer.toString(numRandom.nextInt(n));

            if (value.equals("0")) {
                theRows.put(Integer.toString(i), null);
            } else {
                theRows.put(Integer.toString(i), value);
            }
        }

        System.out.println("Значение мапы перед записью в csv" + "\n");

        for (Map.Entry<String, String> row : theRows.entrySet()) {
            System.out.println(row.getKey() + " => " + row.getValue());
        }

        for (Map.Entry<String, String> row : theRows.entrySet()) {
            write.writeNext(new String[]{row.getKey(), row.getValue()});
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
                //e.printStackTrace();
                result.put(Integer.parseInt(row[0]), 0);
            }
        }

        reader.close();

        Map<Integer, Integer> replace = new HashMap<>();

        for (Integer i : result.values()) {
            if (replace.containsKey(i)) {
                replace.put(i, replace.get(i) + 1);
            } else {
                replace.put(i, 1);
            }
        }

        Set<Integer> keys = replace.keySet();

        System.out.println("\nВывод число повторений\n");

        for (Integer key : keys) {
            System.out.println("Значение #" + key + " повторяется");
            System.out.println(replace.get(key));
        }
    }
}