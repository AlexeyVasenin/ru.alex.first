package Lesson2;

import java.util.Scanner;

public class Dog extends Animal implements IPrint {

    private Boolean castrate;

    public Dog(String name, String color, String address, String mom, String dad, String breed, Boolean castrate) {
        super(name, color, address, mom, dad, breed);
        this.castrate = castrate;
    }

    public Dog() {
        super();
    }

    public String getCastrate() {
        if (castrate) {
            return "Кастрирован";
        } else {
            return "Не кастрирован";
        }
    }

    public void setCastrate(Boolean castrate) {
        this.castrate = castrate;
    }


    public String printIn() {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите кличку собаки");
        name = in.nextLine();
        System.out.println("Введите цвет");
        color = in.nextLine();
        System.out.println("Введите место проживания");
        address = in.nextLine();
        System.out.println("Введите Мать");
        mom = in.nextLine();
        System.out.println("Введите Отца");
        dad = in.nextLine();
        System.out.println("Введите Породу");
        breed = in.nextLine();
        System.out.println("Кастрирован(true)/ не кастрирован(false)");
        castrate = in.nextBoolean();

        StringBuilder sb = new StringBuilder();
        sb.append("Кличка животного ").append(getName());
        sb.append("\n");
        sb.append("Цвет ").append(getColor());
        sb.append("\n");
        sb.append("Местро проживания ").append(getAddress());
        sb.append("\n");
        sb.append("Мать ").append(getMom());
        sb.append("\n");
        sb.append("Отец ").append(getDad());
        sb.append("\n");
        sb.append("Порода ").append(getBreed());
        sb.append("\n");
        sb.append("Кастрирован/ не кастрирован ").append(getCastrate());

        return sb.toString();
    }
}



