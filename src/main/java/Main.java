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
    private static final File folderLessons = new File("Lesson");
    private static final String[] fileLessons = folderLessons.list();
    private static String in = "";
    private static final String cat = "cat";
    private static final String dog = "dog";
    private static final String csv = "csv";
    private static final String lesson1 = "lesson1";

    public static void main(String[] args) throws Exception {

        System.out.println(Arrays.toString(fileLessons));
        System.out.println();

        //TODO: лучше приводить к нижнему регистру, т.к. в в верхнем регистре пишутся имена констант
        //TODO: Т.к. ты используешь сравнение с заранее известными константами, их лучше вынести из тела программы
        // TODO: 25.08.2020 Вынес переменные из тела программы
        while (!in.equals(cat) && !in.equals(dog) && !in.equals(csv) && !in.equals(lesson1)) {
            System.out.println("Введите Cat or Dog or Csv or lesson1");
            in = input.nextLine().toLowerCase();

        }

        //TODO:Нет Lesson 1
        // TODO: 25.08.2020 Сделал Lesson 1
        switch (in) {
            case "lesson1": {
                System.out.println(outTextLesson("Lesson 1.txt"));

                Lesson1 text = new Lesson1();
                text.lesson1();
                break;
            }
            case "dog": {
                System.out.println(outTextLesson("Lesson 2.txt"));
                System.out.println(outTextLesson("Lesson 2.2.txt"));
                System.out.println(outTextLesson("Lesson 2.3.txt"));

                Lesson2 dog = new Lesson2();
                dog.dogInputToWrite();
                break;
            }
            case "cat": {
                System.out.println(outTextLesson("Lesson 2.txt"));
                System.out.println(outTextLesson("Lesson 2.2.txt"));
                System.out.println(outTextLesson("Lesson 2.3.txt"));

                Lesson2 cat = new Lesson2();
                cat.catInputToWrite();
                break;
            }
            case "csv": {
                System.out.println(outTextLesson("Lesson 3.1.txt"));

                Lesson3 fileCsvTest = new Lesson3();
                fileCsvTest.csvWriteToDelete();
                break;
            }

        }
    }

    // TODO: 25.08.2020 Вынес вывод задания в отдельный метод.
    public static String outTextLesson(String name) throws Exception {

        assert fileLessons != null;
        BufferedReader reader = new BufferedReader(new FileReader(folderLessons + "/" + name));

        StringBuilder outTextLessonAll = new StringBuilder();
        String textLesson = reader.readLine();

        while (textLesson != null) {
            outTextLessonAll.append(textLesson);
            outTextLessonAll.append("\n");
            textLesson = reader.readLine();
        }
        reader.close();
        return outTextLessonAll.toString();
    }

}
