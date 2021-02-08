package ru.alex.lesson6;

import org.apache.logging.log4j.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class RunTheadCsv {

    private static final Logger log = LogManager.getLogger(RunTheadCsv.class);

    private static Map<Integer, Integer> writeMap() throws NoSuchAlgorithmException {
        Map<Integer, Integer> theRows = new ConcurrentHashMap<>();
        Random numRandom = SecureRandom.getInstanceStrong();

        for (int i = 0; i < 10000; i++) {
            Integer value = numRandom.nextInt(10000);

            theRows.put(i, value);
        }
        return theRows;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        log.info("Старт программы");

        for (int i = 0; i < 3; i++) {
            new MyThreadWriteCsv(writeMap()).start();
        }
    }
}