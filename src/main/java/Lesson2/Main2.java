package Lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Dog> dogList = new ArrayList<>();

        System.out.println("Введите число обьектов");
        int n;
        try {
            n = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("Допущенна ошибка! повторите ввод число обьектов");
            n = Integer.parseInt(in.nextLine());
        }


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
                System.out.println("Вводимые значения могут быть только 0 или 1");
                dog.setCastrate(Integer.parseInt(in.nextLine()));
            }

            dogList.add(i, dog);
        }

        for (int x = 0; x < n; x++) {
            System.out.println("Животное № " + x + "\n" + dogList.get(x).printOut());
        }

        HashMap<Integer, Cat> catList = new HashMap<>();

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
                System.out.println("Значение могут быть только 0 или 1");
                cat.setVaccinated(Integer.parseInt(in.nextLine()));
            }

            catList.put(i, cat);
        }

        for (Cat cat : catList.values()) {
            System.out.println("Животное" + "\n" + cat.printOut());
        }


    }
}
