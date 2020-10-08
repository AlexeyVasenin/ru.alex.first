package ru.alex.lesson2;

public interface IPrint {

    String getName();

    void setName(String name);

    String getColor();

    void setColor(String color);

    String getAddress();

    void setAddress(String address);

    String getMom();

    void setMom(String mom);

    String getDad();

    void setDad(String dad);

    String getBreed();

    void setBreed(String breed);

    Boolean intToBool(Integer i);

    String printOut();
}
