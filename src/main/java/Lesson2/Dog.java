package Lesson2;

public class Dog {

    private String name, color, address, mom, dad, breed;

    public Dog(String name, String color, String address, String mom, String dad, String breed) {
        this.name = name;
        this.color = color;
        this.address = address;
        this.mom = mom;
        this.dad = dad;
        this.breed = breed;

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
}

