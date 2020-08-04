package Lesson2;

import java.util.Scanner;

public class Cat extends Print {

    private Boolean vaccinated;

    public Cat(String name, String color, String address, String mom, String dad, String breed, Boolean vaccinated) {
        super(name, color, address, mom, dad, breed);
        this.vaccinated = vaccinated;
    }

    public Cat() {
        super();
    }

    public String getVaccinated() {
        if (vaccinated) {
            return "Привит";
        } else {
            return "Не привит";
        }
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String printIn() {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите кличку кота(кошки)");
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
        System.out.println("Привит(true)/ не привит(false)");
        vaccinated = in.nextBoolean();

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
        sb.append(" Привит/ не привит ").append(getVaccinated());
        return sb.toString();
    }
}