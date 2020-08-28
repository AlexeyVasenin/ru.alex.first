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

        Random numRandom = new Random();

        Integer number = numRandom.nextInt();

        List<Integer[]> theRows = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Integer[] numbers = new Integer[];
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