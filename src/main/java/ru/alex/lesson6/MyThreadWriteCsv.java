package ru.alex.lesson6;

import org.apache.logging.log4j.*;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class MyThreadWriteCsv extends Thread {

    private static final Logger logger =
            LogManager.getLogger(MyThreadWriteCsv.class);

    private static final String DIRECTORY = "src/main/resources/test_csv/";

    private final Map<Integer, Integer> theRows;

    public MyThreadWriteCsv(Map<Integer, Integer> theRows) {
        this.theRows = theRows;
    }

    /*Проверка сущечтвования папки для csv файлов, если нет то создаем */
    private void creatingDirectiry() throws IOException {
        Files.createDirectories(Paths.get(DIRECTORY));
        logger.info("Проверка директории и создание папки для хранения файлов");
    }

    /*Проверка старых файлов, если есть то удаляем*/
    private void checkedAndDeleteFileCsv() throws IOException {
        File dir = new File(DIRECTORY);
        File[] lst = dir.listFiles();
        Files.deleteIfExists(Paths.get(Arrays.toString(lst)));
        logger.info("Проверка наличия файлов в директории и удаление " +
                "имеющихся");
    }

    /*Счетчик строк в кончном файле*/
    private void rowCounter() {
        try (Stream<String> lines =
                     Files.lines(Paths.get(DIRECTORY + getName() +
                             ".csv"))) {

            long linesCount = lines.count();

            logger.info("Число строк в файле {}", linesCount);

        } catch (IOException e) {
            logger.error(e);
        }
    }

    /*Чтение мапы и запсь в csv файл*/
    public void writeCsv() throws IOException {

        logger.info("Запись файла {}", getName() + ".csv");

        try (CSVWriter write =
                     new CSVWriter(new FileWriter(DIRECTORY +
                             getName() + ".csv"))) {
            logger.info("Чтение Мапы и запись файл {}", getName() + ".csv");
            for (Map.Entry<Integer, Integer> row : theRows.entrySet()) {
                write.writeNext(new String[]{
                        Integer.toString(row.getKey()),
                        Integer.toString(row.getValue())});
            }

        } catch (IOException e) {
            logger.error(e);
        }
        logger.info("Файл {}", getName() + ".csv успешно записан");

        rowCounter();
    }

    @Override
    public void run() {
        logger.info("Поток {}", getName());

        try {
            writeCsv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}