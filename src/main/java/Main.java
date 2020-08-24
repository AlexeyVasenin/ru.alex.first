import Lesson2.Lesson2;
import lesson3.Lesson3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        File lessons = new File("./Lesson");
        String[] fileLessons = lessons.list();
        System.out.println(Arrays.toString(fileLessons));
        System.out.println();


        String in = "";
        while (!in.equals("CAT") && !in.equals("DOG") && !in.equals("CSV")) {
            System.out.println("Введите Cat or Dog or Csv");
            in = input.nextLine().toUpperCase();
        }

        switch (in) {
            case "DOG": {
                Lesson2.dogInput();
                break;
            }
            case "CAT": {
                Lesson2.catInput();
                break;
            }
            case "CSV": {
                BufferedReader reader = new BufferedReader(new FileReader("Lesson/Lesson 3.1.txt"));
                StringBuilder stringBuilder = new StringBuilder();
                String value = reader.readLine();
                while (value != null) {
                    stringBuilder.append(value);
                    stringBuilder.append("\n");
                    value = reader.readLine();
                }
                reader.close();
                System.out.println(stringBuilder.toString());

                Lesson3.csvWriteToDelete();
            }


        }
    }
}
