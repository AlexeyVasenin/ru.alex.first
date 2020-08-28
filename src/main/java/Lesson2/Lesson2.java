package Lesson2;

import java.util.*;

public class Lesson2 {

    private static final Scanner in = new Scanner(System.in);

    public void dogInputToWrite() {
        System.out.println("Введите кол-во собак(не менее 1)");

        //TODO: А если я 2 раза введу не правильно?
        // TODO: 27.08.2020 Наконец-то до меня дошло как это сделать Оо.
        int n;

        while (true) {

            try {
                n = Integer.parseInt(in.nextLine());
                if (n == 0) {
                    return;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();

                System.out.println("Вы ввели не число, повторите ввод");
            }
        }

        ArrayList<Dog> dogList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

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
            System.out.println("Собка #" + (dogList.indexOf(dog) + 1) + "\n" + dog.printOut());
            System.out.println();
        }

        List<Dog> list = new ArrayList<>();

        Random random = new Random();

        int sumObject = random.nextInt(n) + 1;

        for (int x = 0; x < sumObject; x++) {
            list.add(dogList.get(random.nextInt(n)));
        }

        for (Dog dog : list) {
            System.out.println("Собка #" + (list.indexOf(dog) + 1) + "\n" + dog.printOut());
            System.out.println();
        }
    }

    public void catInputToWrite() {
        System.out.println("Введите кол-во кошек(не менее 1)");

        int n;

        while (true) {
            try {
                n = Integer.parseInt(in.nextLine());
                if (n == 0) {
                    return;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вы ввели не число, повторите ввод");
            }
        }

        HashMap<Integer, Cat> catList = new HashMap<>();

        for (int i = 0; i < n; i++) {

            try {
                Cat cat = new Cat();

                System.out.println("Введите кличку кота/кошки");

                cat.setName(in.nextLine());

                System.out.println("Введите цвет");

                cat.setColor(in.nextLine());

                System.out.println("Введите место проживания");

                cat.setAddress(in.nextLine());

                System.out.println("Введите Мать");

                cat.setMom(in.nextLine());

                System.out.println("Введите Отца");

                cat.setDad(in.nextLine());

                System.out.println("Введите место проживания");

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
            System.out.println("Кот/кошка #" + (cat.getKey() + 1) + "\n" + cat.getValue().printOut());
        }
    }
}


