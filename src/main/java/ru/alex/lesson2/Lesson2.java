package ru.alex.lesson2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class Lesson2 extends Animal implements IAnimal {

    Logger logger = LogManager.getLogger(Lesson2.class);

    private static final Scanner in = new Scanner(System.in);
    Integer amount;

    private void enteringTheNumberOfAnimals() {
        logger.info("Введите кол-во животных(не менее 1)");

        boolean isCorrect = false;

        while (!isCorrect) {
            try {
                String n = in.nextLine();

                if (n.equals("0")) {
                    System.exit(0);
                } else {
                    amount = Integer.valueOf(n);
                    isCorrect = (amount >= 0);
                }
            } catch (Exception e) {
                isCorrect = false;
                e.printStackTrace();
                logger.error(e);

            }
            if (!isCorrect) {
                logger.info("Вы ввели не число," +
                        "отрицательное число или не целое");
            }
        }
    }


    public void writeDogInList() throws NoSuchAlgorithmException {
        ArrayList<Dog> dogList = new ArrayList<>();

        List<Dog> list = new ArrayList<>();

        Random random = SecureRandom.getInstanceStrong();

        enteringTheNumberOfAnimals();

        int sumObject = random.nextInt(amount) + 1;

        for (int i = 0; i < amount; i++) {
            try {
                Dog dog = new Dog();

                logger.info("Введите кличку собаки");
                dog.setName(in.nextLine());

                logger.info("Введите цвет");
                dog.setColor(in.nextLine());

                logger.info("Введите место проживания");
                dog.setAddress(in.nextLine());

                logger.info("Введите Мать");
                dog.setMom(in.nextLine());

                logger.info("Введите Отца");
                dog.setDad(in.nextLine());

                logger.info("Введите Породу");
                dog.setBreed(in.nextLine());

                logger.info("Кастрирован(1)/ не кастрирован(0)");
                dog.setCastrate(Integer.parseInt(in.nextLine()));

                dogList.add(i, dog);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e);
                logger.error("Допущена ошибка, повторите ввод");
                i--;
            }
        }

        for (Dog dog : dogList) {
            logger.info("Собка #" + (dogList.indexOf(dog) + 1) + "\n" + dog +
                    "\n");
        }

        for (int x = 0; x < sumObject; x++) {
            list.add(dogList.get(random.nextInt(amount)));
        }

        for (Dog dog : list) {
            logger.info("Собка #" + (list.indexOf(dog) + 1) + "\n" + dog + "\n");
        }
    }

    public void writeCatInMap() {
        HashMap<Integer, Cat> catList = new HashMap<>();

        enteringTheNumberOfAnimals();

        for (int i = 0; i < amount; i++) {
            try {

                Cat cat = new Cat();

                logger.info("Введите кличку животного");
                cat.setName(in.nextLine());

                logger.info("Введите цвет");
                cat.setColor(in.nextLine());

                logger.info("Введите место проживания");
                cat.setAddress(in.nextLine());

                logger.info("Введите Мать");
                cat.setMom(in.nextLine());

                logger.info("Введите Отца");
                cat.setDad(in.nextLine());

                logger.info("Введите породу");
                cat.setBreed(in.nextLine());

                logger.info("Введите привит(1)/ не привит(0)");
                cat.setVaccinated(Integer.parseInt(in.nextLine()));

                catList.put(i, cat);

            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e);
                logger.error("Допущена ошибка, повторите ввод");
                i--;
            }
        }

        for (Map.Entry<Integer, Cat> cat : catList.entrySet()) {
            logger.info("Кот/кошка #" + (cat.getKey() + 1) + "\n" + cat.getValue());
        }
    }
}


