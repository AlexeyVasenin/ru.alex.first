import Lesson1.Lesson1;
import Lesson2.Lesson2;
import lesson3.Lesson3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final File FOLDER = new File("Lesson");
    private static final String LESSON1 = "les1";
    private static final String LESSON2 = "les2";
    private static final String LESSON3 = "les3";

    public static void main(String[] args) throws Exception {
        String[] fileLessons = FOLDER.list();

        System.out.println(Arrays.toString(fileLessons));
        System.out.println();

        String in = "";

        while (!in.equals(LESSON2) && !in.equals(LESSON3) && !in.equals(LESSON1)) {
            System.out.println("Введите les1 or les2 or les3");

            in = input.nextLine().toLowerCase();
        }

        switch (in) {
            case "les1": {
                System.out.println(outTextLesson("Lesson 1.txt"));

                Lesson1 text = new Lesson1();

                text.lesson1();
                break;
            }
            case "les2": {
                System.out.println(outTextLesson("Lesson 2.txt"));
                System.out.println(outTextLesson("Lesson 2.2.txt"));
                System.out.println(outTextLesson("Lesson 2.3.txt"));
                System.out.println("\n");
                System.out.println("Введите cat или dog");

                Lesson2 dog = new Lesson2();
                Lesson2 cat = new Lesson2();

                String inputLesson2 = "";

                while (!inputLesson2.equals("cat") &&
                        !inputLesson2.equals("dog")) {

                    inputLesson2 = input.nextLine();
                }
                if (inputLesson2.equals("dog")) {
                    dog.writeDogInList();
                }
                if (inputLesson2.equals("cat")) {
                    cat.writeCatInMap();
                }
                break;
            }
            case "les3": {
                System.out.println(outTextLesson("Lesson 3.1.txt"));

                Lesson3 fileCsvTest = new Lesson3();

                fileCsvTest.creatingFolder();
                fileCsvTest.checkedAndDeleteFileCsv();
                fileCsvTest.fileWriteCsv();
                fileCsvTest.fileReadCsv();
                //fileCsvTest.checkedAndDeleteFileCsv();
                break;
            }
        }
    }

    public static String outTextLesson(String name) throws Exception {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(FOLDER + "/" + name));
        StringBuilder outTextLessonAll = new StringBuilder();
        String textLesson = reader.readLine();

        while (textLesson != null) {
            outTextLessonAll.append(textLesson).append("\n");
            textLesson = reader.readLine();
        }
        reader.close();
        return outTextLessonAll.toString();
    }
}
