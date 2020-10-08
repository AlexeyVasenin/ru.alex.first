package ru.alex.lesson2;

public class Dog extends Animal implements IPrint {

    private Boolean castrate;

    public Dog(String name, String color, String address, String mom,
               String dad, String breed, Integer i) {

        super(name, color, address, mom, dad, breed, i);

        this.castrate = intToBool(i);
    }

    public Dog() {
    }

    public String getCastrate() {
        if (castrate) {
            return "Кастрирован";
        } else {
            return "Не кастрирован";
        }
    }

    public void setCastrate(Integer i) {
        this.castrate = intToBool(i);
    }

    public String printOut() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кличка собаки ").append(getName());
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



