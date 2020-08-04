package Lesson2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<Dog> dogList = new ArrayList<>();

        Dog haske = new Dog();
        Dog haske1 = new Dog();
        Dog haske2 = new Dog();

        dogList.add(haske);
        dogList.add(haske1);
        dogList.add(haske2);

        System.out.println(haske.printIn());
        System.out.println(haske1.printIn());
        System.out.println(haske2.printIn());

        HashMap<Integer, Cat> nameAndBreed = new HashMap<>();

        Cat ice = new Cat();
        Cat ice1 = new Cat();

        nameAndBreed.put(1, ice);
        nameAndBreed.put(2, ice1);

        System.out.println(ice.printIn());
    }
}
