package Lesson2;


public class Cat extends Animal implements IPrint {

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

    public String printOut() {

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
        sb.append("Привит/ не привит ").append(getVaccinated());

        return sb.toString();
    }
}