package Lesson2;

import java.util.*;

public class Lesson2 {

    //TODO GLOBAL: Для пользователя не понятно что надо вводить новую собаку/кошку, раздели
    public void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      Ввод количества объектов в листе и Map
        System.out.println("Введите кол-во животных(не менее 1)");
        int n = 0;

        //TODO: А если я 2 раза введу не правильно?

        try {

            n = Integer.parseInt(in.nextLine());

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Допущенна ошибка! повторите ввод число обьектов");
            n = Integer.parseInt(in.nextLine());
            return;
        }

//      ArrayList Объектов типа Dog
        ArrayList<Dog> dogList = new ArrayList<>();

//      Цикл создания и запись обектов типа Dog
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
                i--;
            }

            dogList.add(i, dog);
        }

//      Вывод всех объектов типа Dog
        for (Dog dog : dogList) {
            //TODO:Сделай более читаемый вывод. Весь вывод сливается в 1
            // TODO: 20.08.2020 Сделал более читаемый вывод
            System.out.println("Собка #" + "\n" + dog.printOut());
            System.out.println();
        }
//      Лист с типом объекта Dog
        List<Dog> list = new ArrayList<>();

        //Генерируем рандомное число обектов в зависимости от размера ArrayList
        /*TODO: Не правильно генеришь
        http://developer.alexanderklimov.ru/android/java/random.php*/
        //TODO: 20.08.2020 Исправил генерацию числа обектов.
        Random randomObject;
        randomObject = new Random();
        int sumObject = randomObject.nextInt(n) + 1;

        //Цикл изъятия кол-во объектов (sumObject) и рандомных объекто из ArrayList-a и запись этих объектов в List.
        //TODO: не работает
        // TODO: 20.08.2020 Исправил ошибку
        for (int x = 0; x < sumObject; x++) {
            Random randomIndex = new Random();
            list.add(dogList.get(randomIndex.nextInt(n)));
        }
        //TODO: где вывод?
        //TODO: 20.08.2020 Сделал вывод.
//      Вывод листа
        for (Dog dog : list) {
            System.out.println(dog.printOut());
            System.out.println();
        }

//      Map объектов типа Cat
        HashMap<Integer, Cat> catList = new HashMap<>();

//      Цикл создания и запись объектов типа Cat.
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
                i--;
            }

            catList.put(i, cat);
        }

        //Вывод всех обектов типа Cat
        for (Map.Entry<Integer, Cat> cat : catList.entrySet()) {
            System.out.println("Кот/кошка #" + cat.getKey() + "\n" + cat.getValue().printOut());
        }
    }


}
