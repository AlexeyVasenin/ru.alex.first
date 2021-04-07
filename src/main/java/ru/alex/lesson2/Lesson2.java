package ru.alex.lesson2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class Lesson2 extends Animal implements IAnimal {

    private static final Scanner in = new Scanner(System.in);
    Integer amount;

    private void enteringTheNumberOfAnimals() {
        System.out.println("Введите кол-во животных(не менее 1)");

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
            }
            if (!isCorrect) {
                System.out.println("Вы ввели не число," +
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

                System.out.println("Введите кличку собаки");
                dog.setName(in.nextLine());

                System.out.println("Введите цвет");
                dog.setColor(in.nextLine());

                System.out.println("Введите место проживания");
                dog.setAddress(in.nextLine());

                System.out.println("Введите Мать");
                dog.setMom(in.nextLine());

                System.out.println("Введите Отца");
                dog.setDad(in.nextLine());

                System.out.println("Введите Породу");
                dog.setBreed(in.nextLine());

                System.out.println("Кастрирован(1)/ не кастрирован(0)");
                dog.setCastrate(Integer.parseInt(in.nextLine()));

                dogList.add(i, dog);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Допущена ошибка, повторите ввод");
                i--;
            }
        }

        for (Dog dog : dogList) {
            System.out.println("Собка #" + (dogList.indexOf(dog) + 1) + "\n" + dog);
            System.out.println();
        }

        for (int x = 0; x < sumObject; x++) {
            list.add(dogList.get(random.nextInt(amount)));
        }

        for (Dog dog : list) {
            System.out.println("Собка #" + (list.indexOf(dog) + 1) + "\n" + dog);
            System.out.println();
        }
    }

    public void writeCatInMap() {
        HashMap<Integer, Cat> catList = new HashMap<>();

        enteringTheNumberOfAnimals();

        for (int i = 0; i < amount; i++) {
            try {

                Cat cat = new Cat();

                System.out.println("Введите кличку животного");
                cat.setName(in.nextLine());

                System.out.println("Введите цвет");
                cat.setColor(in.nextLine());

                System.out.println("Введите место проживания");
                cat.setAddress(in.nextLine());

                System.out.println("Введите Мать");
                cat.setMom(in.nextLine());

                System.out.println("Введите Отца");
                cat.setDad(in.nextLine());

                System.out.println("Введите породу");
                cat.setBreed(in.nextLine());

                System.out.println("Введите привит(1)/ не привит(0)");
                cat.setVaccinated(Integer.parseInt(in.nextLine()));

                catList.put(i, cat);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Допущена ошибка, повторите ввод");
                i--;
            }
        }

        for (Map.Entry<Integer, Cat> cat : catList.entrySet()) {
            System.out.println("Кот/кошка #" + (cat.getKey() + 1) + "\n" + cat.getValue());
        }
    }
}


