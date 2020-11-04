package ru.alex.lesson5;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Lesson5 {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private int numberOfContributors;

    private static final String NAME_FOLDER = "depositor";
    private static final String DIRECTORY = "depositor/";
    private static final String FILE_NAME = "depositor.csv";


    private void creatingFolder() throws IOException
    {
        Files.createDirectories(Paths.get(NAME_FOLDER));
    }

    private void inputNumberOfContributors()
    {
        System.out.println("Введите число вкладчиков(число должно быть целое)");
        while (true) {
            try {
                numberOfContributors = parseInt(in.readLine());
                if (numberOfContributors == 0) {
                    return;
                } else break;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число, или число дробное, " +
                        "повторите ввод");
            }
        }
    }

    public void dataRecordingInCsv() throws IOException,
            CsvDataTypeMismatchException, CsvRequiredFieldEmptyException,
            ParseException
    {
        creatingFolder();
        inputNumberOfContributors();

        List<Depositor> listDepositor = new LinkedList<>();

        Writer writer = new FileWriter(DIRECTORY + FILE_NAME);

        MyMappingStrategy<Depositor> mappingStrategy =
                new MyMappingStrategy<>();
        mappingStrategy.setType(Depositor.class);

        StatefulBeanToCsv<Depositor> beanToCsv =
                new StatefulBeanToCsvBuilder<Depositor>(writer)
                        .withMappingStrategy(mappingStrategy)
                        .build();


        for (int i = 0; i < numberOfContributors; i++) {
            Depositor depositor = new Depositor();

            depositor.setId(i + 1);

            System.out.println("Введите ФИО вкладчика");
            depositor.setName(in.readLine());

            System.out.println("Введите номер счета");
            depositor.setAccountNumber(parseInt(in.readLine()));

            System.out.println("Введите сумму влада");
            depositor.setAmount(parseInt(in.readLine()));

            System.out.println("Введите год открытия вклада в формате " +
                    "XXXX");
            depositor.setAge(Integer.parseInt(in.readLine()));

            listDepositor.add(depositor);
        }

        beanToCsv.write(listDepositor);
        writer.close();

    }

    public void dataReadInsideCsv() throws FileNotFoundException
    {
        File file = new File(DIRECTORY + FILE_NAME);
        Reader reader = new BufferedReader(new FileReader(file));
        CsvToBean<Depositor> csvReader =
                new CsvToBeanBuilder<Depositor>(reader)
                        .withType(Depositor.class)
                        .withSeparator(',')
                        .withIgnoreLeadingWhiteSpace(true)
                        .withIgnoreEmptyLine(true)
                        .build();

        List<Depositor> results = csvReader.parse();


    }

}

