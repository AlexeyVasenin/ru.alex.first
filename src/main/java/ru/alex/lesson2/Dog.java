package ru.alex.lesson2;

public class Dog extends Animal implements IAnimal {

    private Boolean castrate;

    public Dog(String name, String color, String address, String mom,
               String dad, String breed, Integer i) {

        super(name, color, address, mom, dad, breed, i);

        this.castrate = intToBool(i);
    }

    public Dog() {
    }

    public String getCastrate() {
        if (Boolean.TRUE.equals(castrate)) {
            return "Кастрирован";
        } else {
            return "Не кастрирован";
        }
    }

    public void setCastrate(Integer i) {
        this.castrate = intToBool(i);
    }

    /*
         public String printOut() {
             StringBuilder sb = new StringBuilder();
             sb.append("Кличка собаки ").append(getName())
             .append("\n")
             .append("Цвет ").append(getColor())
             .append("\n")
             .append("Местро проживания ").append(getAddress())
             .append("\n")
             .append("Мать ").append(getMom())
             .append("\n")
             .append("Отец ").append(getDad())
             .append("\n")
             .append("Порода ").append(getBreed())
             .append("\n")
             .append("Кастрирован/ не кастрирован ").append(getCastrate());

             return sb.toString();
         }
        */

    @Override
    public String toString() {
        return "Кличка собаки " + name + "\n" +
                "Цвет " + color + "\n" +
                "Место проживания " + address + "\n" +
                "Мать " + mom + "\n" +
                "Отец " + dad + "\n" +
                "Порода " + breed + "\n" +
                "Кастрирован/ не кастрирован " + getCastrate();
    }
}



