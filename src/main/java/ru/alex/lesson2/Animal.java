package ru.alex.lesson2;


public abstract class Animal implements IAnimal {

    String name, color, address, mom, dad, breed;
    Integer i;

    protected Animal(String name, String color, String address, String mom,
                  String dad, String breed, Integer i) {

        this.name = name;
        this.color = color;
        this.address = address;
        this.mom = mom;
        this.dad = dad;
        this.breed = breed;
        this.i = i;
    }

    protected Animal() {
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

    public Boolean intToBool(Integer i) {

        if ((i == 0) || (i == 1)) {
            return i != 0;
        } else {
            throw new IllegalArgumentException("Входное значение может быть " +
                    "равно только 0 или 1 !");
        }
    }
}




