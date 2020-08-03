package Lesson2;

public class Main {
    public static void main(String[] args) {
        Dog haske = new Dog("Болто", "Черный", "Пермь", "Alpha", "Omega", "Хаски", true);

        Cat ice = new Cat();

        System.out.println(haske.print());
        System.out.println(ice.print());
    }


}
