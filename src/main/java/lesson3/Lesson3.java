package lesson3;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lesson3 {
    public static void csvWriteToDelete() throws Exception {
//TODO:Нет такой папки
        File folder = new File("./test-csv");
        folder.mkdir();

        String nameFile = "testCSVWrite.csv";
        File file = new File("test-csv/" + nameFile);

        CSVWriter write = new CSVWriter(new FileWriter(file), ';');

        List<String[]> theRows = new ArrayList<>();

        String[] header = new String[]{"id", "number"};
        String[] row1 = new String[]{"1", "2"};
        String[] row2 = new String[]{"2", "3"};
        String[] row3 = new String[]{"3", "4"};

        theRows.add(header);
        theRows.add(row1);
        theRows.add(row2);
        theRows.add(row3);

        write.writeAll(theRows);
        write.close();

        CSVReader reader = new CSVReader(new FileReader("test-csv/testCSVWrite.csv"), ';');
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println(Arrays.toString(nextLine));
        }
        reader.close();

        try {
            if (file.delete()) {
                System.out.println("\n" + file.getName() + " удален");
            } else {
                System.out.println("Фаил удалить не удалось");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}