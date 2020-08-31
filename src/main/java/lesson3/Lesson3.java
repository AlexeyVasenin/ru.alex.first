package lesson3;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class Lesson3 {

    private static final Scanner input = new Scanner(System.in);
    String NAMEFOLDER = "test_csv";
    String DIRECTORY = "test_csv/";
    String NAMEFILECSV = "Csv.csv";

    public void creatingFolder() {
        File folder = new File(NAMEFOLDER);
        folder.mkdir();
    }

    public void checkedAndDeleteFileCsv() {
        boolean fileCsv = new File(DIRECTORY + NAMEFILECSV).isFile();

        if (fileCsv) {
            new File(DIRECTORY + NAMEFILECSV).delete();
        } else {
            System.out.println("Файл не существует");
        }
    }

    public void fileWriteCsv() throws Exception {
        CSVWriter write;
        write = new CSVWriter(new FileWriter(NAMEFOLDER + "/" + NAMEFILECSV)
                , ';');
        List<String[]> theRows = new ArrayList<>();
        Random numRandom = new Random();

        String[] header = new String[]{"numberOne", "numberTwo"};

        theRows.add(header);

        int n;

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
            String[] numbers = new String[2];
            String one = Integer.toString(numRandom.nextInt(n));
            numbers[0] = one;
            String two = Integer.toString(numRandom.nextInt(n));
            numbers[1] = two;
            theRows.add(numbers);
        }

        write.writeAll(theRows);
        write.close();
    }

    public void fileReadCsv() throws Exception {
        File fileCsv = new File(DIRECTORY + NAMEFILECSV);

        CSVReader reader = new CSVReader(new FileReader(fileCsv), ';');

        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            System.out.println(Arrays.toString(nextLine));
        }
        reader.close();
    }
}