package Lesson2;

import java.util.*;

public class Lesson2 {

    private static int n;
    private static final Scanner in = new Scanner(System.in);

    public void dogInputToWrite() {

        //Ввод количества объектов в листе и Map
        System.out.println("Введите кол-во собак(не менее 1)");

        //TODO: А если я 2 раза введу не правильно?
        // TODO: 27.08.2020 С этим вопросом хочу поговорить по дискорд.

        try {

            n = Integer.parseInt(in.nextLine());
            if (n == 0) {
                return;
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Допущена ошибка");

        }

        //ArrayList Объектов типа Dog
        ArrayList<Dog> dogList = new ArrayList<>();

        //Цикл создания и запись обектов типа Dog
        for (int i = 0; i < n; i++) {
            Dog dog = new Dog();

            try {
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
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: а если i = 0?
                // TODO: 27.08.2020 С этим вопросом хочу поговорить по дискорду
                if (i == 0) {
                    return;
                } else {
                    i--;
                }
            }

            dogList.add(i, dog);
        }

        //Вывод всех объектов типа Dog
        for (Dog dog : dogList) {
            System.out.println("Собка #" + (dogList.indexOf(dog) + 1) + "\n" + dog.printOut());
            System.out.println();
        }
        //Лист с типом объекта Dog
        List<Dog> list = new ArrayList<>();

        //Генерируем рандомное число обектов в зависимости от размера ArrayList
        Random random = new Random();
        int sumObject = random.nextInt(n) + 1;

        //Цикл изъятия кол-во объектов (sumObject) и рандомных объекто из
        // ArrayList-a и запись этих объектов в List.
        for (int x = 0; x < sumObject; x++) {
            list.add(dogList.get(random.nextInt(n)));
        }

        //Вывод листа
        for (Dog dog : list) {
            System.out.println("Собка #" + (list.indexOf(dog) + 1) + "\n" + dog.printOut());
            System.out.println();
        }
    }

    public void catInputToWrite() {

        //Ввод количества объектов в листе и Map
        System.out.println("Введите кол-во кошек(не менее 1)");

        //TODO: А если я 2 раза введу не правильно?

        try {

            n = Integer.parseInt(in.nextLine());
            if (n == 0) {
                return;
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Допущенна ошибка!");

        }

        //Map объектов типа Cat
        HashMap<Integer, Cat> catList = new HashMap<>();

        //Цикл создания и запись объектов типа Cat.
        for (int i = 0; i < n; i++) {
            Cat cat = new Cat();

            try {
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
            } catch (Exception e) {
                e.printStackTrace();
                if (i == 0) {
                    return;
                } else {
                    i--;
                }

            }

            catList.put(i, cat);
        }

        //Вывод всех обектов типа Cat
        for (Map.Entry<Integer, Cat> cat : catList.entrySet()) {
            System.out.println("Кот/кошка #" + (cat.getKey() + 1) + "\n" + cat.getValue().printOut());
        }
    }
}


