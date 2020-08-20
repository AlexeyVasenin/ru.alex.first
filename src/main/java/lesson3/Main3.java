package lesson3;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Main3 {
    public static void main(String[] args) throws Exception {
//TODO:Нет такой папки
        CSVWriter write = new CSVWriter(new FileWriter("test-csv\\testCSVWrite.csv"), ';');
        List<String[]> theRows = new ArrayList<>();
        String[] header = new String[]{"id", "number"};
        theRows.add(header);

        String[] row1 = new String[]{"1", "2"};
        String[] row2 = new String[]{"2", "3"};
        String[] row3 = new String[]{"3", "4"};
        theRows.add(row1);
        theRows.add(row2);
        theRows.add(row3);

        write.writeAll(theRows);
        write.close();

    }
}