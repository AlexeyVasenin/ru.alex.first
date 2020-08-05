package Lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Dog> dogList = new ArrayList<>();

        System.out.println("Введите число обьектов");
        int n = in.nextInt();


        for (int i = 0; i < n; i++) {
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
            dog.setCastrate(in.nextBoolean());

            dogList.add(i, dog);


        }

        for (int x = 0; x < n; x++) {
            System.out.println("Животное № " + x + " " + "\n" + dogList.get(x).printOut());
        }




           /*

            HashMap<Cat, String> catList = new HashMap<>();

            Cat ice = new Cat();
            Cat ice1 = new Cat();

            catList.put(ice, "0");
            catList.put(ice1, "1");

            for (Cat cat : catList.keySet()) {
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

                System.out.println("Введите привит(true)/ не привит(false)");
                cat.setVaccinated(in.nextBoolean());

                System.out.println(cat.printOut());
            }*/
    }
}
