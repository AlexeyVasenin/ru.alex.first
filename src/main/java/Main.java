import Lesson2.Lesson2;
import lesson3.Lesson3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        File lessons = new File("./Lesson");
        String[] fileLessons = lessons.list();
        System.out.println(Arrays.toString(fileLessons));
        System.out.println();

        System.out.println("Введите Cat or Dog or Csv");

        switch (input.nextLine().toUpperCase()) {
            case "DOG": {
                Lesson2.dogInput();
                break;
            }
            case "CAT": {
                Lesson2.catInput();
                break;
            }
            case "CSV": {
                Lesson3.csvWriteToDelete();
            }

        }
    }
}
