package Lesson2;

import java.util.Scanner;

public class Print {

    String name, color, address, mom, dad, breed;

    public Print(String name, String color, String address, String mom, String dad, String breed) {
        this.name = name;
        this.color = color;
        this.address = address;
        this.mom = mom;
        this.dad = dad;
        this.breed = breed;
    }

    public Print() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMom() {
        return mom;
    }

    public void setMom(String mom) {
        this.mom = mom;
    }

    public String getDad() {
        return dad;
    }

    public void setDad(String dad) {
        this.dad = dad;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String printIn() {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите кличку животного");
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
        return sb.toString();
    }
}




