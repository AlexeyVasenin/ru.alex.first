package ru.alex.lesson2;


public class Cat extends Animal implements IAnimal {

    private Boolean vaccinated;

    public Cat(String name, String color, String address, String mom,
               String dad, String breed, Integer i) {

        super(name, color, address, mom, dad, breed, i);

        this.vaccinated = intToBool(i);
    }

    public Cat() {
    }

    public String getVaccinated() {
        if (Boolean.TRUE.equals(vaccinated)) {
            return "Привит";
        } else {
            return "Не привит";
        }
    }

    public void setVaccinated(Integer i) {
        this.vaccinated = intToBool(i);
    }

    /*
         public String printOut() {
            StringBuilder sb = new StringBuilder();
            sb.append("Кличка животного ").append(getName())
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
            .append("Привит/ не привит ").append(getVaccinated());

            return sb.toString();
       }
      */
    @Override
    public String toString() {
        return "Кличка кошки " + name + "\n" +
                "Цвет " + color + "\n" +
                "Место проживания " + address + "\n" +
                "Мать " + mom + "\n" +
                "Отец " + dad + "\n" +
                "Порода " + breed + "\n" +
                "Привит/ не привит " + getVaccinated();
    }
}