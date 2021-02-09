package ru.alex.run;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.alex.lesson1.Lesson1;
import ru.alex.lesson2.Lesson2;
import ru.alex.lesson3.Lesson3;
import ru.alex.lesson4.Lesson4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);
    private static final Scanner input = new Scanner(System.in);
    private static final File FOLDER = new File("Lesson");
    private static final String LESSON1 = "l1";
    private static final String LESSON2 = "l2";
    private static final String LESSON3 = "l3";
    private static final String LESSON4 = "l4";

    public static void main(String[] args) throws Exception {
        String[] fileLessons = FOLDER.list();
        log.info("Список уроков");
        log.info(Arrays.toString(fileLessons), "\n");

        String in = "";

        while (!in.equals(LESSON2) && !in.equals(LESSON3) && !in.equals(LESSON1)
                && !in.equals(LESSON4)) {
            log.info("Введите l1 or l2 or l3 or l4");

            in = input.nextLine().toLowerCase();
            log.info("Вы ввели {}", in);
        }

        switch (in) {
            case "l1":

                Lesson1 text = new Lesson1();
                text.lesson1();

                break;
            case "l2":
                log.info("Текст задания");
                log.info(outTextLesson("Lesson 2.txt"));
                log.info(outTextLesson("Lesson 2.2.txt"));
                log.info(outTextLesson("Lesson 2.3.txt"));
                log.info("\n");
                log.info("Введите cat или dog");

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
            case "l3":
                log.info("Текст задания {}", outTextLesson("Lesson 3.1.txt"));

                Lesson3 fileCsvTest = new Lesson3();
                fileCsvTest.creatingFolder();
                fileCsvTest.checkedAndDeleteFileCsv();

                long starTime = System.currentTimeMillis();

                fileCsvTest.fileWriteCsv();
                fileCsvTest.fileReadCsv();

                long endTime = System.currentTimeMillis();

                log.info("Время выполнения программы {}",
                        ((endTime - starTime) / 1000 + "c"));
                break;
            case "l4":

                log.info("Текст задания {}", outTextLesson("Lesson 4.txt"));

                Lesson4 calcTheFnLn = new Lesson4();
                calcTheFnLn.calcRun();

                break;
            default:
                break;
        }
    }

    public static String outTextLesson(String name) throws IOException {
        StringBuilder outTextLessonAll = new StringBuilder();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FOLDER + "/" + name))) {

            String textLesson = reader.readLine();

            while (textLesson != null) {
                outTextLessonAll.append(textLesson).append("\n");
                textLesson = reader.readLine();
            }
        }
        return outTextLessonAll.toString();
    }
}
