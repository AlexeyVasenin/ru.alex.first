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
    public void csvWriteToDelete() throws Exception {
        File folder = new File("test-csv");
        folder.mkdir();

        String nameFileCsv = "testCSVWrite.csv";
        File fileCsv = new File(folder + "/" + nameFileCsv);

        CSVWriter write = new CSVWriter(new FileWriter(fileCsv), ';');

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
    }

    public void readToDeleteCsv() {
        CSVReader reader = new CSVReader(new FileReader(fileCsv), ';');

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println(Arrays.toString(nextLine));
        }
        reader.close();

        try {
            if (fileCsv.delete()) {
                System.out.println("\n" + "*Файл " + fileCsv.getName() + " " +
                        "удален*");
            } else {
                System.out.println("Файл не существует или не может быть " +
                        "удален");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}