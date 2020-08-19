package Lesson2;

import java.util.*;

public class Main2 {

//TODO GLOBAL: Для пользователя не понятно что надо вводить новую собаку/кошку, раздели
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      Ввод количества объектов в листе и Map
        System.out.println("Введите число обьектов");
        int n;

        //TODO: А если я 2 раза введу не правильно?
        try {
            n = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Допущенна ошибка! повторите ввод число обьектов");
            n = Integer.parseInt(in.nextLine());
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
        //TODO:Зачем закоментированы пустые строки?
//  `
//      Вывод всех объектов типа Dog
        for (Dog dog : dogList) {
            //TODO:Сделай более читаемый вывод. Весь вывод сливается в 1
            System.out.println(dog.printOut());
        }
//
//      Лист с типом объекта Dog
        List<Dog> listDog = new ArrayList<>();
//
//      Записываем размер Arraylist dogList в переменную
        //TODO: Зачем ещё 1 переменная, если значение и так есть?
        int sizeList = dogList.size();
//
//      Генерируем рандомное число обектов в зависимости от размера ArrayList
        /*TODO: Не правильно генеришь
         http://developer.alexanderklimov.ru/android/java/random.php*/
        int sumObject = (int) (Math.random() * ++sizeList) + 1;
//
//      Цикл изъятия кол-во объектов (sumObject) и рандомных объекто и ArrayList-a и запись этих объектов в List.
        //TODO: не работает
        for (int x = 0; x <= sumObject; x++) {
            int iIndex = (int) (Math.random() * sizeList);
            Dog dog = dogList.get(iIndex);
            listDog.add(dog);
        }
        //TODO: где вывод?
//
//      Map объектов типа Cat
        HashMap<Integer, Cat> catList = new HashMap<>();
//
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
//
//      Вывод всех обектов типа Cat
        for (Map.Entry<Integer, Cat> cat : catList.entrySet()) {
            System.out.println("Животное #" + cat.getKey() + "\n" + cat.getValue().printOut());
        }
    }
}
