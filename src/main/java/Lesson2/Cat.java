package Lesson2;

public class Cat {
    private String name, color, address, mom, dad, breed;
    private Boolean vaccinated;

    public Cat(String name, String color, String address, String mom, String dad, String breed, Boolean vaccinated) {
        this.name = name;
        this.color = color;
        this.address = address;
        this.mom = mom;
        this.dad = dad;
        this.breed = breed;
        this.vaccinated = vaccinated;
    }

    public Cat() {

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

    public String print() {
        Cat ice = new Cat("Ice", "Белый", "Пермь", "Alpha", "Omega", "Maine coon", false);
        String iceName = ice.getName();
        String iceColor = ice.getColor();
        String iceAddress = ice.getAddress();
        String iceMom = ice.getMom();
        String iceDad = ice.getDad();
        String iceBreed = ice.getBreed();
        String iceVaccinated = ice.getVaccinated();

        StringBuilder sb = new StringBuilder();
        sb.append("Кличка кота/кошки" + " ").append(iceName);
        sb.append("\n");
        sb.append("Цвет" + " ").append(iceColor);
        sb.append("\n");
        sb.append("Местро проживания" + " ").append(iceAddress);
        sb.append("\n");
        sb.append("Мать" + " ").append(iceMom);
        sb.append("\n");
        sb.append("Отец" + " ").append(iceDad);
        sb.append("\n");
        sb.append("Порода" + " ").append(iceBreed);
        sb.append("\n");
        sb.append("Привит/не привит" + " ").append(iceVaccinated);
        return sb.toString();
    }
}