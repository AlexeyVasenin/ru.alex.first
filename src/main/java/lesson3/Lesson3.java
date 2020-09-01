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
    int n;

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

        //String[] header = new String[]{"id", "numberTwo"};

        //theRows.add(header);

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
            numbers[0] = Integer.toString(i);

            String two = Integer.toString(numRandom.nextInt(n));

            if (two.equals("0")) {
                numbers[1] = null;
            } else {
                numbers[1] = two;
            }

            theRows.add(numbers);
        }

        write.writeAll(theRows);
        write.close();
    }

    public void fileReadCsv() throws Exception {
        File fileCsv = new File(DIRECTORY + NAMEFILECSV);
        CSVReader reader = new CSVReader(new FileReader(fileCsv), ';');

        List<String> list = new ArrayList<>();

        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            System.out.println(Arrays.toString(new String[]{nextLine[1]}));
            list.add(nextLine[1]); //записываю второй столбец в лист
        }

        reader.close();

        String[] numberStr = list.toArray(new String[0]); // создаю строковый
        // массив из листа

        Integer[] numbers = new Integer[numberStr.length]; // преобразовываю
        // в Integer массив

        for (int i = 0; i < numberStr.length; i++) {
            try {
                numbers[i] = Integer.parseInt(numberStr[i]);
            } catch (NumberFormatException e) {
                numbers[i] = 0;
            }
        }

        System.out.println(Arrays.toString(numbers));

        Integer[] counter = new Integer[n];

        // TODO: 01.09.2020 В этом месте выдает NullPointerException, не могу
        //  понять почему

        for (int i = 0; i < numbers.length; i++) {
            counter[numbers[i]]++;

        }

        System.out.println("value\tcount");

        for (int i = 0; i < counter.length; i++) {
            System.out.println(i + "\t" + counter[i]);
        }
    }
}