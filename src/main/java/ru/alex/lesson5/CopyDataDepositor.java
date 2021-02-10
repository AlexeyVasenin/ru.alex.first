package ru.alex.lesson5;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Comparator.comparing;

public class CopyDataDepositor implements ICopyData {

    private final Logger log = LogManager.getLogger(CopyDataDepositor.class);

    private static final String DIRECTORY = "src/main/resources/depositor/";
    private static final String DATA_FILE_CSV = "depositor.csv";
    private static final String DATA_FILE_IN = "depositor.txt";

    private List<Depositor> listMan;
    private String[] column;

    @Override
    public void creatingFolder() throws IOException {
        Files.createDirectories(Paths.get(DIRECTORY));
    }

    @Override
    public boolean checkData(String i) {
        Pattern pattern = Pattern.compile("^([0-9]{6,12})$");
        Matcher matcher = pattern.matcher(i);
        return matcher.matches();
    }

    @Override
    public void dataFileRead() throws IOException {

        listMan = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DIRECTORY + DATA_FILE_IN))) {

            String depositorData = reader.readLine();
            Integer id = 1;

            while (depositorData != null) {
                String[] strings = depositorData.split(",");

                if (checkData(strings[1])) {
                    log.info(checkData(strings[1]));
                    listMan.add(new Depositor(strings[0],
                            Integer.parseInt(strings[1]),
                            Integer.parseInt(strings[2]),
                            Integer.parseInt(strings[3]),
                            id));
                    depositorData = reader.readLine();
                    id++;
                } else {
                    log.info("Данные пользователя {}{}", strings,
                            " не корректы");
                    depositorData = reader.readLine();
                }
            }
        }
    }

    @Override
    public void beanToCsv() {

        try (CSVWriter writer =
                     new CSVWriter(new FileWriter(DIRECTORY + DATA_FILE_CSV))) {

            column = new String[]{"id", "name", "accountNumber",
                    "amount", "age"};

            ColumnPositionMappingStrategy<Depositor> mappingStrategy =
                    new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(Depositor.class);

            mappingStrategy.setColumnMapping(column);

            StatefulBeanToCsvBuilder<Depositor> builder =
                    new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Depositor> beanToCsv =
                    builder
                            .withMappingStrategy(mappingStrategy)
                            .build();

            beanToCsv.write(listMan);

        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            e.printStackTrace();
            log.error(e);
        }
    }

    @Override
    public void readCsvToShow() throws FileNotFoundException {

        column = new String[]{"id", "name", "accountNumber",
                "amount", "age"};

        /*Создаем пользовательскую карту столбцов*/
        ColumnPositionMappingStrategy<Depositor> mappingStrategy =
                new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Depositor.class);
        mappingStrategy.setColumnMapping(column);

        /*Читаем *.csv фаил записываем в лист и сортируме по параметрам*/
        listMan =
                new CsvToBeanBuilder<Depositor>(new FileReader(DIRECTORY + DATA_FILE_CSV))
                        .withMappingStrategy(mappingStrategy)
                        .build()
                        .parse();
    }

    @Override
    public void sortClient() {

        /*Сортируем по сумме вклада*/
        listMan.sort(comparing(Depositor::getAmount));

        log.info("Список вкладчиков отсортированных по сумме вклада");

        for (Depositor i : listMan) {
            log.info(i);
        }

        /*Сортируем по году вклада*/
        listMan.sort(comparing(Depositor::getAge));

        log.info("Список вкладчиков отсортированных по году вклада");

        for (Depositor i : listMan) {
            log.info(i);

        }
    }

    @Override
    public void run() throws IOException {
        creatingFolder();
        dataFileRead();
        beanToCsv();
        readCsvToShow();
        sortClient();
    }
}