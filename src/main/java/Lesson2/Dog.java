package Lesson2;

public class Dog {

    private String name, color, address, mom, dad, breed;
    private Boolean castrate;

    public Dog(String name, String color, String address, String mom, String dad, String breed, Boolean castrate) {
        this.name = name;
        this.color = color;
        this.address = address;
        this.mom = mom;
        this.dad = dad;
        this.breed = breed;
        this.castrate = castrate;


    }

    public Dog() {

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

    public String print() {

        Dog haske = new Dog("Болто", "Черный", "Пермь", "Alpha", "Omega", "Хаски", true);
        String haskeName = haske.getName();
        String haskeColor = haske.getColor();
        String haskeAddress = haske.getAddress();
        String haskeMom = haske.getMom();
        String haskeDad = haske.getDad();
        String haskeBreed = haske.getBreed();
        String haskeCastrate = haske.getCastrate();

        StringBuilder sb = new StringBuilder();
        sb.append("Кличка собаки" + " ").append(haskeName);
        sb.append("\n");
        sb.append("Цвет" + " ").append(haskeColor);
        sb.append("\n");
        sb.append("Место проживания" + " ").append(haskeAddress);
        sb.append("\n");
        sb.append("Мать" + " ").append(haskeMom);
        sb.append("\n");
        sb.append("Отец" + " ").append(haskeDad);
        sb.append("\n");
        sb.append("Порода" + " ").append(haskeBreed);
        sb.append("\n");
        sb.append("Кастрирован/не кастрирован" + " ").append(haskeCastrate);
        return sb.toString();
    }


}



